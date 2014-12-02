package org.cesiumjs.cesium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Document;

class CesiumInitializer {
  
  private static final Logger log = Logger.getLogger(CesiumInitializer.class.getName());
  
  private static Map<Document,CesiumInitializer> cesiumInitializerFromDocument 
    = new HashMap<Document,CesiumInitializer>();

  private String cesiumPath;
  private Document document;
  private List<Callback<Void, Exception>> callbacks = new ArrayList<Callback<Void, Exception>>();
  private boolean failed = false;

  /**
   * Initialize using Cesium.initialize()
   */
  CesiumInitializer(String cesiumPath, Document document, Callback<Void, Exception> callback) {
    this.cesiumPath = cesiumPath;
    this.document = document;
    addCallback(callback);
    cesiumInitializerFromDocument.put(document, this);
  }
  
  private void invokeCallback() {
    if (callbacks != null) {
      for (Callback<Void, Exception> callback : callbacks) {
        try {
          callback.onSuccess(null);
        } catch (Throwable t) {
          log.log(Level.SEVERE, "Error initializing a cesiumWidget: "+t.getMessage(), t);
        }
      }
      callbacks = null;
    }
  }
  
  void initialize() {
    
    final String cesiumURL = cesiumPath+"Cesium.js";
    
    /**
     * THE FOLLOWING Injector fromUrl (without setting the Window), works for Chrome but 
     * does not work for Firefox.
     *
     * Firefox attempts to inject the script into a window that does not support "performance"
     * javascript object, and Cesium throws an exception (a Cesium bug as well).
     * If I try to inject it into the window of the "document", it should work, but the
     * Cesium global is not available from the GWT window JavaScript, so I can't just inject
     * the script.  I also have to copy the reference to Cesium to the global.
//    ScriptInjector
//      .fromUrl(cesiumURL)
////      .setWindow(getWindow(document)) // this line is not necessary for Chrome to launch Cesium, and puts global "Cesium" in wrong scope
//      .setCallback(callback).inject();
     */
    
    ScriptInjector
      .fromUrl(cesiumURL)
      .setWindow(getWindow(document))
      .setCallback(new Callback<Void,Exception>() {

        public void onFailure(Exception reason) {
          failed = true;
          for (Callback<Void, Exception> callback : callbacks) {
            callback.onFailure(reason);
          }
          callbacks = null;
        }

        public void onSuccess(Void result) {
          createCesiumSetter(document);
    
          String script =
                "document.setCesiumGlobalInGWT(Cesium);"
                ;
          JavaScriptObject scriptElement = ScriptInjector
            .fromString(script)
            .setWindow(getWindow(document))
            .inject();
        }
      }).inject();
  }
  
  private static native JavaScriptObject getWindow(Document document) /*-{
    var win = document.parentWindow || document.defaultView
    return win
  }-*/;
  
  private native void createCesiumSetter(Document document) /*-{

    var outerThis = this
    
    document.setCesiumGlobalInGWT = function(CesiumToSet) {
      Cesium = CesiumToSet;
      outerThis.@org.cesiumjs.cesium.CesiumInitializer::invokeCallback()();
    }

  }-*/;

  public void addCallback(Callback<Void, Exception> callback) {
    if (callback != null) {
      if (callbacks != null) {
        callbacks.add(callback);
      } else {
        if (failed) {
          callback.onFailure(null);
        } else {
          callback.onSuccess(null);
        }
      }
    }
  }
  
  public static CesiumInitializer get(Document document) {
    return cesiumInitializerFromDocument.get(document);
  }
}

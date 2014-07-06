package com.harmonia.cesiumjs.gwt;

import java.util.logging.Logger;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Document;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;

class CesiumInitializer {
  
	private static final Logger log = Logger.getLogger(CesiumInitializer.class.getName());

	private Document document;
	private Callback<Void, Exception> callback;

	public CesiumInitializer(Document document, Callback<Void, Exception> callback) {
    this.document = document;
    this.callback = callback;
	}
  
	private void invokeCallback() {
		callback.onSuccess(null);
	}
	
  public static String getCesiumPath() {
return "Cesium-b28/Cesium/"; // Need to change this to a configurable parameter,
  // so we can change it to "Cesium-b28/CesiumUnminified" or to a different version
  }

	public void initialize() {
    
    final String cesiumURL = getCesiumPath()+"Cesium.js";
    
    /**
     * THE FOLLOWING Injector fromUrl (without setting the Window), works for Chrome but 
     * does not work for Firefox.
     *
     * Firefox attempts to inject the script into a window that does not support "performance"
     * javascript object, and Cesium throws an exception (a Cesium bug as well).
     * If I try to inject it into the window of the "document", it should work, but the
     * Cesium global is not available from the GWT window JavaScript, so I can't just inject
     * the script.  I also have to copy the reference to Cesium to the global.
     */
//    ScriptInjector
//    	.fromUrl(cesiumURL)
////      .setWindow(getWindow(document))
//    	.setCallback(callback).inject();
    
    ScriptInjector
    	.fromUrl(cesiumURL)
      .setWindow(getWindow(document))
    	.setCallback(new Callback<Void,Exception>() {

				public void onFailure(Exception reason) {
          callback.onFailure(reason);
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
    
//    createCesiumSetter(document);
//      
//    try {
//      RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, cesiumURL);
//      Request request = builder.sendRequest(null, new RequestCallback() {
//  
//  			@Override
//  			public void onError(Request request, Throwable e) {
//          callback.onFailure(
//          	new Exception("Error from HTTP Request: "+e.getMessage()
//          			+", while attempting to get "+cesiumURL, e));
//  			}
//  
//  			@Override
//  			public void onResponseReceived(Request request, Response response) {
//          if (200 == response.getStatusCode()) {
//            String script =
//                  "CESIUM_BASE_URL='"+cesiumURL+"';" // since we are not actually injecting a URL
//              		+response.getText()
//                  +"document.setCesiumGlobalInGWT(Cesium);"
//                  ;
//            JavaScriptObject scriptElement = ScriptInjector
//              .fromString(script)
//              .setWindow(getWindow(document))
//              .inject();
//          } else {
//          	callback.onFailure(
//          		new Exception("HTTP error response ("+response.getStatusCode()+") "
//          			+response.getStatusText()+", while attempting to get "+cesiumURL));
//          }
//  			}
//      });
//    } catch (RequestException e) {
//      callback.onFailure(
//      	new Exception("Error from HTTP Request: "+e.getMessage()
//      			+", while attempting to get "+cesiumURL, e));
//    }
	}
  
	private static native JavaScriptObject getWindow(Document document) /*-{
    var win = document.parentWindow || document.defaultView
    return win
	}-*/;
  
	private native void createCesiumSetter(Document document) /*-{
    
    var outerThis = this
    
    document.setCesiumGlobalInGWT = function(CesiumToSet) {
      Cesium = CesiumToSet
      outerThis.@com.harmonia.cesiumjs.gwt.CesiumInitializer::invokeCallback()();
    }
	}-*/;
}

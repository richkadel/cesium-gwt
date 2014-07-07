package com.harmonia.gwt.cesium;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LinkElement;

/**
 * @author richkadel
 *
 */
public final class Cesium extends JavaScriptObject {
  
  // Overlay types always have protected, zero argument constructors.
  protected Cesium(){}
  
  public static native Cesium get() /*-{
    if (typeof Cesium === "undefined") {
    	return null
    } else {
    	return Cesium
    }
  }-*/;

	public static void initialize(String cesiumPath, Document document, Callback<Void, Exception> callback) {
    
    document.setNodeValue("");
		if (!isCesiumInitializationStarted(document)) {
			setCesiumInitializationStarted(document);
      LinkElement link = Document.get().createLinkElement();
      link.setRel("stylesheet");
      
      final String cesiumCss = cesiumPath+"Widgets/widgets.css";
      link.setHref(cesiumCss);
      document.getElementsByTagName("head").getItem(0).appendChild(link);
        
      new CesiumInitializer(cesiumPath, document, callback).initialize();
  	} else {
  		CesiumInitializer.get(document).addCallback(callback);
  	}
	}
  
	private static native void setCesiumInitializationStarted(Document document) /*-{
    document.cesiumInitializationStarted = true;
	}-*/;
  
	private static native boolean isCesiumInitializationStarted(Document document) /*-{
    return document.cesiumInitializationStarted;
	}-*/;
}
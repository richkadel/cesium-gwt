package com.harmonia.cesiumjs.gwt;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;

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

	public static void initialize(Document document, Callback<Void, Exception> callback) {
    new CesiumInitializer(document, callback).initialize();
	}
}
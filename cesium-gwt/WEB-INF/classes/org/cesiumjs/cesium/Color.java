package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

public class Color extends JavaScriptObject {

  protected Color(){}
  
	/**
	 * @param red 0 (no intensity) to 1.0 (full intensity)
	 * @param blue 0 (no intensity) to 1.0 (full intensity)
	 * @param green 0 (no intensity) to 1.0 (full intensity)
	 * @param alpha 0 (no intensity) to 1.0 (full intensity)
	 * @return
	 */
	public final static native Color create(double red, double blue, double green, double alpha) /*-{
    return new Cesium.Color(red, green, blue, alpha)
	}-*/;
  
	public final static native Color fromName(String colorName) /*-{
    return Cesium.Color[colorName.toUpperCase()]
	}-*/;
}

package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * @author richkadel
 *
 */
public final class Ellipsoid extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
	protected Ellipsoid(){}
  
	private static native Ellipsoid getConstant(String name) /*-{
		return Cesium.Ellipsoid[name];
	}-*/;
	
	public static final Ellipsoid MOON = getConstant("MOON");
	public static final Ellipsoid UNIT_SPHERE = getConstant("UNIT_SPHERE");
	public static final Ellipsoid WGS84 = getConstant("WGS84");
  
	public native Cartesian3 cartographicToCartesian(Cartographic cartographic) /*-{
    	return this.cartographicToCartesian(cartographic)
	}-*/;

	public native Cartographic cartesianToCartographic(Cartesian3 cartesian) /*-{
    	return this.cartesianToCartographic(cartesian)
	}-*/;
	
	public native JsArray<Cartographic> cartesianArrayToCartographicArray(JsArray<Cartesian3> cartesians) /*-{
		return this.cartesianArrayToCartographicArray(cartesians);
	}-*/;
	
	public native JsArray<Cartesian3> cartographicArrayToCartesianArray(JsArray<Cartographic> cartographics) /*-{
		return this.cartographicArrayToCartesianArray(cartographics);
	}-*/;

}
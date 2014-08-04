package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public final class Ellipsoid extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected Ellipsoid(){}
  
	public native Cartesian3 cartographicToCartesian(Cartographic cartographic) /*-{
    return this.cartographicToCartesian(cartographic)
	}-*/;

	public native Cartographic cartesianToCartographic(Cartesian3 cartesian) /*-{
    return this.cartesianToCartographic(cartesian)
	}-*/;
}
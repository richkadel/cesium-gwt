package com.harmonia.cesiumjs.gwt;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * WARNING Cesium developers like to put longitude before latitude in their APIs (they like the consistency
 * with x, y, even though most of use map users say lat/lon.  For Cesium, it is lon/lat!
 * @author richkadel
 *
 */
public final class Cartographic extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected Cartographic(){}
  
  public static Cartographic fromDegrees(double longitude, double latitude, Double height) {
    if (height == null) {
    	height = 0.0;
    }
    // Note, the GWT JavaScriptObject overlays allow you to pass in primitive object wrappers like "Integer"
    // and "Double", but they are opaque to the javascript!  They don't really work!
  	return fromDegrees(longitude, latitude, (double)height);
  }
  
  private static native Cartographic fromDegrees(double longitude, double latitude, double height) /*-{
    if (latitude > 90.1 || latitude < -90.1) {
    	throw "Cartographic fromDegrees() latitude is out of range. Did you forget that Cesium uses longitude before latitude in function arguments?"
    }
    return Cesium.Cartographic.fromDegrees(longitude, latitude, height);
  }-*/;
  
  public static native Cartographic fromDegrees(double longitude, double latitude, double height, Cartographic result) /*-{
    if (latitude > 90.1 || latitude < -90.1) {
    	throw "Cartographic fromDegrees() latitude is out of range. Did you forget that Cesium uses longitude before latitude in function arguments?"
    }
    return Cesium.Cartographic.fromDegrees(longitude, latitude, height, result);
  }-*/;
  
  /**
   * WARNING Cesium developers like to put longitude before latitude in their APIs (they like the consistency
   * with x, y, even though most of use map users say lat/lon.  For Cesium, it is lon/lat!
   * @param longitude
   */
  public native void setLongitudeRadians(double longitude) /*-{ this.longitude = longitude; }-*/;
  public native double getLongitudeRadians() /*-{ return this.longitude }-*/;
  
  /**
   * WARNING Cesium developers like to put longitude before latitude in their APIs (they like the consistency
   * with x, y, even though most of use map users say lat/lon.  For Cesium, it is lon/lat!
   * @param latitude
   */
  public native void setLatitudeRadians(double latitude) /*-{ this.latitude = latitude; }-*/;
  public native double getLatitudeRadians() /*-{ return this.latitude }-*/;
  
  /**
   * @param height meters above the ellipsoid
   */
  public native void setHeightMeters(double height) /*-{ this.height = height; }-*/;
  public native double getHeightMeters() /*-{ return this.height }-*/;
  
  public native boolean equals(Cartographic right) /*-{ return this.equals(right) }-*/;

	public static native Cartographic ZERO() /*-{
		return Cesium.Cartographic.ZERO
	}-*/;
}
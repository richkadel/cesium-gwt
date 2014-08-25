package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public final class BoundingSphere extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected BoundingSphere(){}
  
  public static native BoundingSphere create() /*-{
    Cesium.BoundingSphere()
  }-*/;
  
  public static native BoundingSphere create(Cartesian3 center, double radiusMeters) /*-{
    Cesium.BoundingSphere(center,radiusMeters)
  }-*/;
  
  public native void setRadiusMeters(double radiusMeters) /*-{ this.radius = radiusMeters; }-*/;
  public native double getRadiusMeters() /*-{ return this.radius; }-*/;
  
  public native void setCenter(Cartesian3 center) /*-{ this.center = center; }-*/;
  public native Cartesian3 getCenter() /*-{ return this.center; }-*/;
}
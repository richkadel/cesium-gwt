package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

public final class Ray extends JavaScriptObject
{
  protected Ray() {}
  
  public static  native Ray create(Cartesian3 origin, Cartesian3 direction) /*-{
    return new Cesium.Ray(origin, direction);
  }-*/;
  
  public static native Cartesian3 getPoint(Ray ray, double t)/*-{
    return Cesium.Ray.getPoint(ray, t);
  }-*/;

  public native Cartesian3 getDirection() /*-{
    return this.direction;
  }-*/;

  public native void setDirection(Cartesian3 direction) /*-{
    this.direction = direction;
  }-*/;

  public native Cartesian3 getOrigin() /*-{
    return this.origin;
  }-*/;

  public native void setOrigin(Cartesian3 origin) /*-{
    this.origin = origin;
  }-*/;
}

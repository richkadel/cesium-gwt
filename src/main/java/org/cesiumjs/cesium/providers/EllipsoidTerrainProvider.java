package org.cesiumjs.cesium.providers;

import org.cesiumjs.cesium.Ellipsoid;

import com.google.gwt.core.client.JavaScriptObject;

public final class EllipsoidTerrainProvider extends JavaScriptObject
{
  protected EllipsoidTerrainProvider() {}
  
  public static native EllipsoidTerrainProvider create(Ellipsoid ellipsoid) /*-{
    return new Cesium.EllipsoidTerrainProvider({ellipsoid : ellipsoid});
  }-*/;
}

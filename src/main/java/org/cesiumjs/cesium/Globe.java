package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public final class Globe extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected Globe(){}
  
  public native Ellipsoid getEllipsoid() /*-{ return this.ellipsoid; }-*/;

  public native void setTerrainProvider(TerrainProvider terrainProvider) /*-{
    this.terrainProvider = terrainProvider;
  }-*/;
  
  public native ImageryLayerCollection getImageryLayers() /*-{
    return this.imageryLayers;
  }-*/;
  
  public native void setDepthTestAgainstTerrain(boolean depthTest) /*-{
    this.depthTestAgainstTerrain = depthTest;
  }-*/;
  
  public native boolean getDepthTestAgainstTerrain() /*-{
    return this.depthTestAgainstTerrain();
  }-*/;

  public native void setEnableLighting(boolean enableLighting) /*-{
    this.enableLighting = enableLighting;
  }-*/;
  
  public native boolean getEnableLighting() /*-{
    return this.enableLighting;
  }-*/;

  public native void setShow(boolean show) /*-{
    this.show = show;
  }-*/;

  public native boolean getShow() /*-{
    return this.show;
  }-*/;
  
  public native Double getHeight(Cartographic cartographic) /*-{
    var height = this.getHeight(cartographic);
    return (height === void 0) ? null : height;
  }-*/;
  
  public native Cartesian3 pick(Ray ray, Scene scene) /*-{
    var result = this.pick(ray, scene);
    return (result === void 0) ? null : result;
  }-*/;
}
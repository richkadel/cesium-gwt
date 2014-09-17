package org.cesiumjs.cesium.materials;

import org.cesiumjs.cesium.Undocumented;

import com.google.gwt.core.client.JavaScriptObject;

public class Material extends JavaScriptObject
{
  protected Material() {}
  
  public static final String ColorType = "Color";
  public static final String ImageType = "Image";
  public static final String PolylineOutlineType = "PolylineOutline";
  public static final String PolylineArrowType = "PolylineArrow";
  
  public static native <T extends Material> T fromType(String type) /*-{
    return Cesium.Material.fromType(type);
  }-*/;
  
  public static native <T extends Material> T fromType(String type, Undocumented uniforms) /*-{
    return Cesium.Material.fromType(type, uniforms);
  }-*/;
}

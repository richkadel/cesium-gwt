package org.cesiumjs.cesium.data;

import org.cesiumjs.cesium.materials.MaterialProperty;

import com.google.gwt.core.client.JavaScriptObject;

public final class PathGraphics extends JavaScriptObject {
  
  protected PathGraphics() {}

  public static native PathGraphics create() /*-{
    return new Cesium.PathGraphics()
  }-*/;
    
  public native PathGraphics setMaterial(MaterialProperty material) /*-{ 
    this.material = material
    return this
  }-*/;
    
  public native PathGraphics setWidth(Property<Number> width) /*-{ 
    this.width = width
    return this
  }-*/;
    
  public native PathGraphics setShow(Property<Boolean> show) /*-{ 
    this.show = show
    return this
  }-*/;

  public native PathGraphics setExtrudedHeight(Property<Number> extrudedHeight) /*-{
    this.extrudedHeight = extrudedHeight
    return this
  }-*/;
}

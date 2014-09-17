package org.cesiumjs.cesium.materials;

import org.cesiumjs.cesium.Color;

public class ColorMaterial extends Material
{
  protected ColorMaterial() {}
  
  public final native void setColor(Color color) /*-{
    this.uniforms.color = color;
  }-*/;
}

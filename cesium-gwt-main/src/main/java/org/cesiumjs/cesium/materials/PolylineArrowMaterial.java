package org.cesiumjs.cesium.materials;

import org.cesiumjs.cesium.Color;

public class PolylineArrowMaterial extends Material
{
  protected PolylineArrowMaterial() {}
  
  public final native void setColor(Color color) /*-{
    this.uniforms.color = color;
  }-*/;
}

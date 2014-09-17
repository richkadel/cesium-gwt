package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.ImageElement;

public class SkyBox extends JavaScriptObject
{
  protected SkyBox() {}
  
  public static final native SkyBox create(String px, String nx, String py, String ny, String pz, String nz) /*-{
    var skyBox = new Cesium.SkyBox({
      positiveX : px,
        negativeX : nx,
        positiveY : py,
        negativeY : ny,
        positiveZ : pz,
        negativeZ : nz
    });
    return skyBox;
  }-*/;
  
  public static final native SkyBox create(ImageElement px, ImageElement nx, ImageElement py, ImageElement ny, ImageElement pz, ImageElement nz) /*-{
    var skyBox = new Cesium.SkyBox({
      positiveX : px,
        negativeX : nx,
        positiveY : py,
        negativeY : ny,
        positiveZ : pz,
        negativeZ : nz
    });
    return skyBox;
  }-*/;
  
  public final native SkyBox show(boolean show) /*-{
    this.show = show;
    return this;
  }-*/;
}

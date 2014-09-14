package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public class ImageryProvider extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected ImageryProvider(){}
  
  public final native void setDefaultSaturation(double defaultSaturation) /*-{ 
    this.defaultSaturation = defaultSaturation
  }-*/;
  
  public final native boolean getReady()/*-{
    return this.ready;
  }-*/;

  public final native Rectangle getRectangle()/*-{
    return this.rectangle;
  }-*/;

}
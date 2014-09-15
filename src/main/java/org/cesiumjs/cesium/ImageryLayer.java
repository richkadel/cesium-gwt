package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 */
public final class ImageryLayer extends JavaScriptObject {
  
  public final static double DEFAULT_BRIGHTNESS = init("DEFAULT_BRIGHTNESS");
  public final static double DEFAULT_CONTRAST = init("DEFAULT_CONTRAST");
  public final static double DEFAULT_GAMMA = init("DEFAULT_GAMMA");
  public final static double DEFAULT_HUE = init("DEFAULT_HUE");
  public final static double DEFAULT_SATURATION = init("DEFAULT_SATURATION");
  
  private final native static double init(String constName) /*-{
    return Cesium.ImageryLayer[constName];
  }-*/;
  
  protected ImageryLayer() {}
  
  public static native ImageryLayer create() /*-{
    return {}
  }-*/;
  
  public static native ImageryLayer create(ImageryProvider provider) /*-{
    return new Cesium.ImageryLayer(provider);
  }-*/;

    
  public native ImageryLayer setSaturation(double saturation) /*-{ 
    this.saturation = saturation
    return this
  }-*/;

  public native ImageryLayer setBrightness(double brightness) /*-{ 
    this.brightness = brightness
    return this
  }-*/;

  public native ImageryLayer setContrast(double contrast) /*-{ 
    this.contrast = contrast
    return this
  }-*/;

  public native ImageryLayer setAlpha(double alpha) /*-{ 
    this.alpha = alpha
    return this
  }-*/;

  public native ImageryLayer setGamma(double gamma) /*-{ 
    this.gamma = gamma
    return this
  }-*/;

  public native ImageryLayer setHue(double hue) /*-{ 
    this.hue = hue
    return this
  }-*/;

  public native ImageryLayer setShow(boolean show) /*-{ 
    this.show = show
    return this
  }-*/;
    
  public native double getSaturation() /*-{ 
    return this.saturation
  }-*/;

  public native double getBrightness() /*-{ 
    return this.brightness
  }-*/;

  public native double getContrast() /*-{ 
    return this.contrast
  }-*/;

  public native double getAlpha() /*-{ 
    return this.alpha
  }-*/;

  public native double getGamma() /*-{ 
    return this.gamma
  }-*/;

  public native double getHue() /*-{ 
    return this.hue
  }-*/;

  public native boolean getShow() /*-{ 
    return this.show
  }-*/;

  public native boolean isBaseLayer() /*-{ 
    return this.isBaseLayer()
  }-*/;

  public native void destroy() /*-{ 
    return this.destroy()
  }-*/;

  public native boolean isDestroyed() /*-{ 
    return this.isDestroyed()
  }-*/;

  public native ImageryProvider getImageryProvider() /*-{ 
    return this.imageryProvider
  }-*/;

  public native Rectangle getRectangle() /*-{ 
    return this.rectangle
  }-*/;
}
  
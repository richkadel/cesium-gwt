package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public final class ScreenSpaceCameraController extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected ScreenSpaceCameraController(){}

  public final native static ScreenSpaceCameraController create(Element canvas, Camera camera) /*-{
    return new Cesium.ScreenSpaceCameraController(canvas, camera)
  }-*/;
  
  public native boolean getEnableInputs() /*-{
    return this.enableInputs;
  }-*/;
  
  public native void setEnableInputs(boolean enable) /*-{
    this.enableInputs = enable;
  }-*/;

  public native boolean getEnableLook() /*-{
    return this.enableLook;
  }-*/;
  
  public native void setEnableLook(boolean enable) /*-{
    this.enableLook = enable;
  }-*/;

  public native boolean getEnableRotate() /*-{
    return this.enableRotate;
  }-*/;

  public native void setEnableRotate(boolean enable) /*-{
    this.enableRotate = enable;
  }-*/;

  public native boolean getEnableTilt() /*-{
    return this.enableTilt;
  }-*/;

  public native void setEnableTilt(boolean enable) /*-{
    this.enableTilt = enable;
  }-*/;

  public native boolean getEnableTranslate() /*-{
    return this.enableTranslate;
  }-*/;

  public native void setEnableTranslate(boolean enable) /*-{
    this.enableTranslate = enable;
  }-*/;

  public native boolean getEnableZoom() /*-{
    return this.enableZoom;
  }-*/;

  public native void setEnableZoom(boolean enable) /*-{
    this.enableZoom = enable;
  }-*/;
}
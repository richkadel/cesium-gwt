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
}
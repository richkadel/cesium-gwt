package com.harmonia.cesiumjs.gwt;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public final class ScreenSpaceEventHandler extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected ScreenSpaceEventHandler(){}

  public final native static ScreenSpaceEventHandler create(Element element) /*-{
    return new Cesium.ScreenSpaceEventHandler(element)
  }-*/;
}
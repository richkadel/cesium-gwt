package org.cesiumjs.cesium;

import org.cesiumjs.js.EventListener;
import org.cesiumjs.js.JsFunction;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public final class ScreenSpaceEventHandler extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected ScreenSpaceEventHandler(){}

  public native static ScreenSpaceEventHandler create(Element element) /*-{
    return new Cesium.ScreenSpaceEventHandler(element)
  }-*/;

  public void setInputAction(EventListener eventListener, ScreenSpaceEventType type) {
    setInputAction(JsFunction.create(eventListener), type.toString());
  }
  
  private native void setInputAction(JsFunction eventListener, String typeName) /*-{
    this.setInputAction(eventListener, Cesium.ScreenSpaceEventType[typeName])
  }-*/;
}
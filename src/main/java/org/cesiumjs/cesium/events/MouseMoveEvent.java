package org.cesiumjs.cesium.events;

import org.cesiumjs.cesium.Cartesian2;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

/**
 * @author richkadel
 *
 */
public final class MouseMoveEvent extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected MouseMoveEvent(){}
  
  public native Cartesian2 getStartPosition() /*-{ return this.startPosition }-*/;
  public native Cartesian2 getEndPosition() /*-{ return this.endPosition }-*/;
}
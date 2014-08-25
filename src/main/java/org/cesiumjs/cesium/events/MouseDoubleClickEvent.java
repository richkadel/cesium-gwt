package org.cesiumjs.cesium.events;

import org.cesiumjs.cesium.Cartesian2;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

/**
 * @author richkadel
 *
 */
public final class MouseDoubleClickEvent extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected MouseDoubleClickEvent(){}
  
  public native Cartesian2 getPosition() /*-{ return this.position }-*/;
}
package org.cesiumjs.cesium.events;

import com.google.gwt.core.client.JavaScriptObject;

public class PinchMoveEvent extends CesiumInputEvent {
  protected PinchMoveEvent() {}
  
  public native final MovementEvent getDistance() /*-{
    return this.distance;
  }-*/;
  
  public native final MovementEvent getAngleAndHeight() /*-{
    return this.angleAndHeight;
  }-*/;
}

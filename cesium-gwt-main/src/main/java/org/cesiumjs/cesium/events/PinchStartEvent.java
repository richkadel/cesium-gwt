package org.cesiumjs.cesium.events;

import org.cesiumjs.cesium.Cartesian2;

public class PinchStartEvent extends CesiumInputEvent {
  protected PinchStartEvent() {}
  
  public native final Cartesian2 getPosition1() /*-{
    return this.position1;
  }-*/;
  
  public native final Cartesian2 getPosition2() /*-{
    return this.position2;
  }-*/;
}

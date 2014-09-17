package org.cesiumjs.cesium.events;

import org.cesiumjs.cesium.Cartesian2;

public class PositionEvent extends CesiumInputEvent {
  protected PositionEvent() {}
  
  public native final Cartesian2 getPosition() /*-{
    return this.position;
  }-*/;
}

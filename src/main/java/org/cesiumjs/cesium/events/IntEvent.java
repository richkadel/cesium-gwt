package org.cesiumjs.cesium.events;

public class IntEvent extends CesiumInputEvent {
  
  protected IntEvent() {}
  
  public native final int getValue() /*-{
    return this;
  }-*/;

}

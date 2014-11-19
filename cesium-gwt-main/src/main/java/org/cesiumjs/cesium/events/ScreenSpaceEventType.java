package org.cesiumjs.cesium.events;

public enum ScreenSpaceEventType {
  LEFT_DOWN,
  LEFT_UP,
  LEFT_CLICK,
  LEFT_DOUBLE_CLICK,
  RIGHT_DOWN,
  RIGHT_UP,
  RIGHT_CLICK,
  RIGHT_DOUBLE_CLICK,
  MIDDLE_DOWN,
  MIDDLE_UP,
  MIDDLE_CLICK,
  MIDDLE_DOUBLE_CLICK,
  MOUSE_MOVE,
  WHEEL,
  PINCH_START,
  PINCH_END,
  PINCH_MOVE;
  
  public static ScreenSpaceEventType valueOf(double nativeValue) { // ScreenSpaceEventTypes are Numbers in JavaScript
    for (ScreenSpaceEventType enumInstance : ScreenSpaceEventType.values()) {
      if (nativeValue == enumInstance.toNumber()) {
        return enumInstance;
      }
    }
    return null;
  }
  
  public double toNumber() {
    return toNumber(toString());
  }
  
  public native double toNumber(String asString) /*-{
    return Cesium.ScreenSpaceEventType[asString]
  }-*/;
}

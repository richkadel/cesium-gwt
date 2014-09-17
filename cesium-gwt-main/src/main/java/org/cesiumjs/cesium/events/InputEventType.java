package org.cesiumjs.cesium.events;

public enum InputEventType {
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
  
  public final int nativeValue;
  
  private static final native int getNativeValue(String typeName) /*-{
    return Cesium.ScreenSpaceEventType[typeName]
  }-*/;
  
  private InputEventType() {
    this.nativeValue = getNativeValue(this.toString());
  }
  
  public static InputEventType valueOf(int nativeValue) { // ScreenSpaceEventTypes are ints in JavaScript
    for (InputEventType enumInstance : InputEventType.values()) {
      if (matches(enumInstance.toString(), nativeValue)) {
        return enumInstance;
      }
    }
    return null;
  }
  
  private native static boolean matches(String enumString, int nativeValue) /*-{
    return Cesium.ScreenSpaceEventType[enumString] == value;
  }-*/;
}

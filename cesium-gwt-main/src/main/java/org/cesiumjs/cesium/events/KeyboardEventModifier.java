package org.cesiumjs.cesium.events;

public enum KeyboardEventModifier
{
  SHIFT,
  CTRL,
  ALT;
  
  public static KeyboardEventModifier valueOf(double nativeValue) { // KeyboardEventModifier are Numbers in JavaScript
    for (KeyboardEventModifier enumInstance : KeyboardEventModifier.values()) {
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
    return Cesium.KeyboardEventModifier[asString]
  }-*/;
}

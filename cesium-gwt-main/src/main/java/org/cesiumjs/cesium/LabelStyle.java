package org.cesiumjs.cesium;

public enum LabelStyle {
  FILL,
  FILL_AND_OUTLINE,
  OUTLINE;
  
  public static LabelStyle valueOf(double nativeValue) { // LabelStyles are Numbers in JavaScript
    for (LabelStyle enumInstance : LabelStyle.values()) {
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
    return Cesium.LabelStyle[asString]
  }-*/;
}

package org.cesiumjs.cesium;

public enum LabelStyle {
  FILL,
  FILL_AND_OUTLINE,
  OUTLINE;
  
  public static LabelStyle valueOf(int nativeValue) { // LabelStyles are ints in JavaScript
    for (LabelStyle enumInstance : LabelStyle.values()) {
      if (matches(enumInstance.toString(), nativeValue)) {
        return enumInstance;
      }
    }
    return null;
  }
  
  private native static boolean matches(String enumString, int nativeValue) /*-{
    return Cesium.LabelStyle[enumString] == value;
  }-*/;

  public double toNumber() {
    return toNumber(toString());
  }
  
  public native double toNumber(String asString) /*-{
    return Cesium.LabelStyle[asString]
  }-*/;
}

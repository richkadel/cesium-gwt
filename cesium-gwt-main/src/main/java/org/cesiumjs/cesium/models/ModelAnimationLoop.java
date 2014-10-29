package org.cesiumjs.cesium.models;

public enum ModelAnimationLoop {
  MIRRORED_REPEAT,
  NONE,
  REPEAT;
  
  public static ModelAnimationLoop valueOf(int nativeValue) { // ModelAnimationLoops are ints in JavaScript
    for (ModelAnimationLoop enumInstance : ModelAnimationLoop.values()) {
      if (matches(enumInstance.toString(), nativeValue)) {
        return enumInstance;
      }
    }
    return null;
  }
  
  private native static boolean matches(String enumString, int nativeValue) /*-{
    return Cesium.ModelAnimationLoop[enumString] == value;
  }-*/;

  public int nativeValue() {
    return nativeValue(toString());
  }
  
  private native static int nativeValue(String enumString) /*-{
    return Cesium.ModelAnimationLoop[enumString]
  }-*/;
}

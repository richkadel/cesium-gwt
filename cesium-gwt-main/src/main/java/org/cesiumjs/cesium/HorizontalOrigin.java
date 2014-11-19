package org.cesiumjs.cesium;

/**
 * @author richkadel
 *
 */
public enum HorizontalOrigin {
  CENTER,
  LEFT,
  RIGHT;

  public static HorizontalOrigin valueOf(double nativeValue) { // HorizontalOrigins are Numbers in JavaScript
    for (HorizontalOrigin enumInstance : HorizontalOrigin.values()) {
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
    return Cesium.HorizontalOrigin[asString]
  }-*/;
}
package org.cesiumjs.cesium;

/**
 * @author richkadel
 *
 */
public enum VerticalOrigin {
  BOTTOM,
  CENTER,
  TOP;
  
  public static VerticalOrigin valueOf(double nativeValue) { // VerticalOrigins are Numbers in JavaScript
    for (VerticalOrigin enumInstance : VerticalOrigin.values()) {
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
    return Cesium.VerticalOrigin[asString]
  }-*/;
}
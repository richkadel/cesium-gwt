package org.cesiumjs.cesium;

/**
 * @author richkadel
 *
 */
public enum VerticalOrigin {
  BOTTOM,
  CENTER,
  TOP;
  
  public static VerticalOrigin valueOf(int nativeValue) { // VerticalOrigins are ints in JavaScript
    for (VerticalOrigin enumInstance : VerticalOrigin.values()) {
      if (matches(enumInstance.toString(), nativeValue)) {
        return enumInstance;
      }
    }
    return null;
  }
  
  private native static boolean matches(String enumString, int nativeValue) /*-{
    return Cesium.VerticalOrigin[enumString] == value;
  }-*/;

  public double toNumber() {
    return toNumber(toString());
  }
  
  public native double toNumber(String asString) /*-{
    return Cesium.VerticalOrigin[asString]
  }-*/;
}
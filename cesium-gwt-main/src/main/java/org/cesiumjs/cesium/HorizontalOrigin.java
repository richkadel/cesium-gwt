package org.cesiumjs.cesium;

/**
 * @author richkadel
 *
 */
public enum HorizontalOrigin {
  CENTER,
  LEFT,
  RIGHT;

  public double toNumber() {
    return toNumber(toString());
  }
  
  public native double toNumber(String asString) /*-{
    return Cesium.HorizontalOrigin[asString]
  }-*/;
}
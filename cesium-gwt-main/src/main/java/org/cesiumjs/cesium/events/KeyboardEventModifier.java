package org.cesiumjs.cesium.events;

public enum KeyboardEventModifier
{
  SHIFT,
  CTRL,
  ALT;
  
  private static final native int getNativeValue(String typeName) /*-{
    return Cesium.KeyboardEventModifier[typeName]
  }-*/;
  
  public final int nativeValue;
  
  private KeyboardEventModifier() {
    this.nativeValue = getNativeValue(this.toString());
  }
}

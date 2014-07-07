package com.harmonia.gwt.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public final class Cartesian3 extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected Cartesian3(){}
  
  public static native Cartesian3 create(double x, double y, double z) /*-{
    return Cesium.Cartesian3.fromArray([x, y, z])
  }-*/;
  
  public native void setX(double x) /*-{ this.x = x; }-*/;
  public native double getX() /*-{ return this.x; }-*/;
  
  public native void setY(double y) /*-{ this.y = y; }-*/;
  public native double getY() /*-{ return this.y; }-*/;
  
  public native void setZ(double z) /*-{ this.z = z; }-*/;
  public native double getZ() /*-{ return this.z; }-*/;
  
  public native boolean equals(Cartesian3 right) /*-{ return this.equals(right) }-*/;
}
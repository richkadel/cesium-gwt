package com.harmonia.gwt.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public final class Cartesian4 extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected Cartesian4(){}
  
  public static native Cartesian4 create(double x, double y, double z, double w) /*-{
    return Cesium.Cartesian4.fromArray([x, y, z, w])
  }-*/;
  
  public native void setX(double x) /*-{ this.x = x; }-*/;
  public native double getX() /*-{ return this.x; }-*/;
  
  public native void setY(double y) /*-{ this.y = y; }-*/;
  public native double getY() /*-{ return this.y; }-*/;
  
  public native void setZ(double z) /*-{ this.z = z; }-*/;
  public native double getZ() /*-{ return this.z; }-*/;
  
  public native void setW(double w) /*-{ this.w = w; }-*/;
  public native double getW() /*-{ return this.w; }-*/;
  
  public native boolean equals(Cartesian4 right) /*-{ return this.equals(right) }-*/;
}
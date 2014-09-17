package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public final class Cartesian2 extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected Cartesian2(){}
  
  public static native Cartesian2 create(double x, double y) /*-{
    return Cesium.Cartesian2.fromArray([x, y])
  }-*/;
  
  public native void setX(double x) /*-{ this.x = x; }-*/;
  public native double getX() /*-{ return this.x; }-*/;
  
  public native void setY(double y) /*-{ this.y = y; }-*/;
  public native double getY() /*-{ return this.y; }-*/;
  
  public native boolean equals(Cartesian2 right) /*-{ return this.equals(right) }-*/;
}
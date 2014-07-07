package com.harmonia.gwt.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public final class BoundingRectangle extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected BoundingRectangle(){}
  
  public static native BoundingRectangle create(double x, double y, double width, double height) /*-{
    return {
      x : x,
      y : y,
      width : width,
      height : height
    }
  }-*/;
  
  public native void setX(double x) /*-{ this.x = x; }-*/;
  public native double getX() /*-{ return this.x; }-*/;
  
  public native void setY(double y) /*-{ this.y = y; }-*/;
  public native double getY() /*-{ return this.y; }-*/;
  
  public native void setWidth(double width) /*-{ this.width = width; }-*/;
  public native double getWidth() /*-{ return this.width; }-*/;
  
  public native void setHeight(double height) /*-{ this.height = height; }-*/;
  public native double getHeight() /*-{ return this.height; }-*/;
}
package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

public final class Color extends JavaScriptObject {

  protected Color(){}
  
	/**
	 * @param red 0 (no intensity) to 1.0 (full intensity)
	 * @param green 0 (no intensity) to 1.0 (full intensity)
	 * @param blue 0 (no intensity) to 1.0 (full intensity)
	 * @param alpha 0 (no intensity) to 1.0 (full intensity)
	 * @return
	 */
	public static native Color create(double red, double green, double blue, double alpha) /*-{
    return new Cesium.Color(red, green, blue, alpha)
	}-*/;
  
	public static native Color fromName(String colorName) /*-{
    return Cesium.Color[colorName.toUpperCase()]
	}-*/;

  public native double getRed() /*-{ return this.red }-*/;
  public native double getGreen() /*-{ return this.green }-*/;
  public native double getBlue() /*-{ return this.blue }-*/;
  public native double getAlpha() /*-{ return this.alpha }-*/;

  public native void setRed(double red) /*-{ this.red = red }-*/;
  public native void setGreen(double green) /*-{ this.green = green }-*/;
  public native void setBlue(double blue) /*-{ this.blue = blue }-*/;
  public native void setAlpha(double alpha) /*-{ this.alpha = alpha }-*/;
}

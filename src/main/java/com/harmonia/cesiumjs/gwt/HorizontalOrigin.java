package com.harmonia.cesiumjs.gwt;

/**
 * @author richkadel
 *
 */
public final class HorizontalOrigin extends Enumeration {
  // Overlay types always have protected, zero argument constructors.
  protected HorizontalOrigin(){}
  
	public static native HorizontalOrigin CENTER() /*-{
		return Cesium.HorizontalOrigin.CENTER
	}-*/;
  
	public static native HorizontalOrigin LEFT() /*-{
		return Cesium.HorizontalOrigin.LEFT
	}-*/;
  
	public static native HorizontalOrigin RIGHT() /*-{
		return Cesium.HorizontalOrigin.RIGHT
	}-*/;
}
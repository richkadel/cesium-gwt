package com.harmonia.gwt.cesium;

/**
 * @author richkadel
 *
 */
public final class VerticalOrigin extends Enumeration {
  // Overlay types always have protected, zero argument constructors.
  protected VerticalOrigin(){}
  
	public static native VerticalOrigin BOTTOM() /*-{
		return Cesium.VerticalOrigin.BOTTOM
	}-*/;
  
	public static native VerticalOrigin CENTER() /*-{
		return Cesium.VerticalOrigin.CENTER
	}-*/;
  
	public static native VerticalOrigin TOP() /*-{
		return Cesium.VerticalOrigin.TOP
	}-*/;
}
package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

public final class Rectangle extends JavaScriptObject {
  
  protected Rectangle() {}
  
  public static native Rectangle create(double westRadians, double southRadians, double eastRadians, double northRadians) /*-{
    return new Cesium.Rectangle(westRadians, southRadians, eastRadians, northRadians)
  }-*/;

  public static native Rectangle fromDegrees(double west, double south, double east, double north) /*-{
    return Cesium.Rectangle.fromDegrees(west, south, east, north)
  }-*/;

  public static native Rectangle fromDegrees(double west, double south, double east, double north, Rectangle result) /*-{
    return Cesium.Rectangle.fromDegrees(west, south, east, north, result)
  }-*/;

  public native double getWestRadians() /*-{
    return this.west;
  }-*/;

  public native double getSouthRadians() /*-{
    return this.south;
  }-*/;

  public native double getEastRadians() /*-{
    return this.east;
  }-*/;

  public native double getNorthRadians() /*-{
    return this.north;
  }-*/;

  public native Rectangle setWestRadians(double westRadians) /*-{
    this.west = westRadians;
    return this;
  }-*/;

  public native Rectangle setSouthRadians(double southRadians) /*-{
    this.south = southRadians;
    return this;
  }-*/;

  public native Rectangle setEastRadians(double eastRadians) /*-{
    this.east = eastRadians;
    return this;
  }-*/;

  public native Rectangle setNorthRadians(double northRadians) /*-{
    this.north = northRadians;
    return this;
  }-*/;
}

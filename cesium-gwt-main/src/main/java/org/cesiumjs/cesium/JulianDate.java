package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

public final class JulianDate extends JavaScriptObject
{
  protected JulianDate() {}
  
  public static native JulianDate create() /*-{
    return new Cesium.JulianDate();
  }-*/;
  
  public static native JulianDate create(double julianDayNumber, double secondsOfDay) /*-{
    return new Cesium.JulianDate(julianDayNumber, secondsOfDay);
  }-*/;
 
  public native double getDayNumber() /*-{
    return this.dayNumber;
  }-*/;
  
  public native void setDayNumber(double dayNumber) /*-{
    this.dayNumber = dayNumber;
  }-*/;

  public native double getSecondsOfDay() /*-{
    return this.secondsOfDay;
  }-*/;
  
  public native void setSecondsOfDay(double seconds) /*-{
    this.secondsOfDay = seconds;
  }-*/;
}

package org.cesiumjs.cesium.time;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public class TimeInterval extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected TimeInterval(){}
  
  private static native TimeInterval getConstant(String name) /*-{
    return Cesium.TimeInterval[name];
  }-*/;
  
  public static final TimeInterval EMPTY = getConstant("EMPTY");
  
  public static native TimeInterval create() /*-{
    return new Cesium.TimeInterval()
  }-*/;
  
  public static native TimeInterval fromIso8601(String iso8601) /*-{
    return Cesium.TimeInterval.fromIso8601({iso8601:iso8601})
  }-*/;
  
  public final native String toIso8601() /*-{
    return this.toString()
  }-*/;
  
  public final native boolean isEmpty() /*-{
    return this.isEmpty
  }-*/;

  public final native boolean isStartIncluded() /*-{
    return this.isStartIncluded
  }-*/;

  public final native boolean isStopIncluded() /*-{
    return this.isStopIncluded
  }-*/;

  public final native TimeInterval setStartIncluded(boolean isStartIncluded) /*-{
    this.isStartIncluded = isStartIncluded
    return this
  }-*/;

  public final native TimeInterval setStopIncluded(boolean isStopIncluded) /*-{
    this.isStopIncluded = isStopIncluded
    return this
  }-*/;

  public final native JulianDate getStart() /*-{
    return this.start
  }-*/;

  public final native JulianDate getStop() /*-{
    return this.stop
  }-*/;

  public final native TimeInterval setStart(JulianDate start) /*-{
    this.start = start
    return this
  }-*/;

  public final native TimeInterval setStop(JulianDate stop) /*-{
    this.stop = stop
    return this
  }-*/;

  public final native TimeInterval setData(Object data) /*-{
    this.data = data
    return this
  }-*/;
  
  public final native Object getData() /*-{
    return this.data
  }-*/;
}
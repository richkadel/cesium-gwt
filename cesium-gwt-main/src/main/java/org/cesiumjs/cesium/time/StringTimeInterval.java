package org.cesiumjs.cesium.time;

/**
 * @author richkadel
 *
 */
public final class StringTimeInterval extends PropertyTimeInterval<String> {
  // Overlay types always have protected, zero argument constructors.
  protected StringTimeInterval(){}
  
  public static StringTimeInterval create(String iso8601Interval, String data) {
    return ((StringTimeInterval)TimeInterval.fromIso8601(iso8601Interval)).setStringData(data);
  }

  private native StringTimeInterval setStringData(String data) /*-{
    this.data = data
    return this
  }-*/;
}
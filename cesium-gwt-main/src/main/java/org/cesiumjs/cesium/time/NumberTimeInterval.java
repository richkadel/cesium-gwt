package org.cesiumjs.cesium.time;

/**
 * @author richkadel
 *
 */
public final class NumberTimeInterval extends PropertyTimeInterval<Number> {
  // Overlay types always have protected, zero argument constructors.
  protected NumberTimeInterval(){}
  
  public static NumberTimeInterval create(String iso8601Interval, double data) {
    return ((NumberTimeInterval)TimeInterval.fromIso8601(iso8601Interval)).setNumberData(data);
  }

  private native NumberTimeInterval setNumberData(double data) /*-{
    this.data = data
    return this
  }-*/;
}
package org.cesiumjs.cesium.time;

/**
 * @author richkadel
 *
 */
public final class BooleanTimeInterval extends PropertyTimeInterval<Boolean> {
  // Overlay types always have protected, zero argument constructors.
  protected BooleanTimeInterval(){}
  
  public static BooleanTimeInterval create(String iso8601Interval, boolean data) {
    return ((BooleanTimeInterval)TimeInterval.fromIso8601(iso8601Interval)).setBooleanData(data);
  }

  private native BooleanTimeInterval setBooleanData(boolean data) /*-{
    this.data = data
    return this
  }-*/;
}
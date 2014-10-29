package org.cesiumjs.cesium.time;

import org.cesiumjs.cesium.data.Property;

public final class TimeIntervalCollectionProperty<T> extends Property<T> {
  
  protected TimeIntervalCollectionProperty() {}
  
  public static native <T> TimeIntervalCollectionProperty<T> create() /*-{
    return new Cesium.TimeIntervalCollectionProperty()
  }-*/;

  public static <T> TimeIntervalCollectionProperty<T> create(PropertyTimeInterval<T>... timeIntervals) {
    TimeIntervalCollectionProperty<T> ticp = create();
    TimeIntervalCollection intervals = ticp.intervals();
    for (TimeInterval timeInterval : timeIntervals) {
      intervals.addInterval(timeInterval);
    }
    return ticp;
  }
    
  public native TimeIntervalCollection intervals() /*-{
    return this.intervals
  }-*/;
}
  
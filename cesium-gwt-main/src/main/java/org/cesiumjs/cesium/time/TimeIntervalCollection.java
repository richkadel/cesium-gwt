package org.cesiumjs.cesium.time;

import org.cesiumjs.cesium.events.Event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public final class TimeIntervalCollection extends JavaScriptObject {
  
  protected TimeIntervalCollection() {}
  
  public static TimeIntervalCollection create(TimeInterval... timeIntervals) {
    TimeIntervalCollection collection = TimeIntervalCollection.create();
    for (TimeInterval timeInterval : timeIntervals) {
      collection.addInterval(timeInterval);
    }
    return collection;
  }
    
  public static native TimeIntervalCollection create() /*-{
    return new Cesium.TimeIntervalCollection()
  }-*/;
    
  public native Event onChangedEvent() /*-{
    return this.changedEvent
  }-*/;

  public native boolean isEmpty() /*-{
    return this.isEmpty
  }-*/;
    
  public native int length() /*-{
    return this.length
  }-*/;
    
  public native boolean isStartIncluded() /*-{
    return this.isStartIncluded
  }-*/;
    
  public native boolean isStopIncluded() /*-{
    return this.isStopIncluded
  }-*/;
    
  public native JulianDate getStart() /*-{
    return this.start
  }-*/;
    
  public native JulianDate getStop() /*-{
    return this.stop
  }-*/;
    
  public native void addInterval(TimeInterval interval) /*-{
    this.addInterval(interval)
  }-*/;

  public native boolean contains(JulianDate julianDate) /*-{
    return this.contains(julianDate)
  }-*/;

  public native int indexOf(JulianDate julianDate) /*-{
    return this.indexOf(julianDate)
  }-*/;

  public native TimeInterval get(int index) /*-{
    return this.get(index)
  }-*/;

  public native boolean removeInterval(TimeInterval interval) /*-{
    return this.remove(interval)
  }-*/;

  public native void removeAll() /*-{
    this.removeAll()
  }-*/;
}
  
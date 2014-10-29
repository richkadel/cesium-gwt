package org.cesiumjs.cesium.time;

import org.cesiumjs.cesium.Color;

/**
 * @author richkadel
 *
 */
public final class ColorTimeInterval extends PropertyTimeInterval<Color> {
  // Overlay types always have protected, zero argument constructors.
  protected ColorTimeInterval(){}
  
  public static ColorTimeInterval create(String iso8601Interval, Color data) {
    return (ColorTimeInterval)TimeInterval.fromIso8601(iso8601Interval).setData(data);
  }
}
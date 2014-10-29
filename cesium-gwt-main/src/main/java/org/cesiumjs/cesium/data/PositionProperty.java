package org.cesiumjs.cesium.data;

import org.cesiumjs.cesium.Cartesian3;
import org.cesiumjs.cesium.ReferenceFrame;
import org.cesiumjs.cesium.time.JulianDate;

/**
 * @author richkadel
 *
 */
public class PositionProperty extends Property<Cartesian3> {
  // Overlay types always have protected, zero argument constructors.
  protected PositionProperty(){}

  public static native PositionProperty create() /*-{
    return new Cesium.PositionProperty()
  }-*/;

  public final Cartesian3 getValueInReferenceFrame(JulianDate time, ReferenceFrame referenceFrame) {
    return getValueInReferenceFrame(time, referenceFrame.toString());
  }

  public final Cartesian3 getValueInReferenceFrame(JulianDate time, ReferenceFrame referenceFrame, Cartesian3 result) {
    return getValueInReferenceFrame(time, referenceFrame.toString(), result);
  }

  private final native Cartesian3 getValueInReferenceFrame(JulianDate time, String referenceFrame) /*-{
    return this.getValue(time, Cesium.ReferenceFrame[referenceFrame])
  }-*/;

  private final native Cartesian3 getValueInReferenceFrame(JulianDate time, String referenceFrame, Cartesian3 result) /*-{
    return this.getValue(time, Cesium.ReferenceFrame[referenceFrame], result)
  }-*/;
}
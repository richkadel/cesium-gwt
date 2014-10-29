package org.cesiumjs.cesium.data;

import org.cesiumjs.cesium.InterpolationAlgorithm;
import org.cesiumjs.cesium.time.JulianDate;

/**
 * @author richkadel
 *
 */
public class SampledPositionProperty extends PositionProperty {
  // Overlay types always have protected, zero argument constructors.
  protected SampledPositionProperty(){}

  public final static native SampledPositionProperty create() /*-{
    return new Cesium.SampledPositionProperty()
  }-*/;

  public final native SampledPositionProperty setInterpolationAlgorithm(InterpolationAlgorithm interpolationAlgorithm) /*-{
    this.setInterpolationOptions(
      {
        interpolationAlgorithm : interpolationAlgorithm,
        interpolationDegree : this.interpolationDegree
      }
    )
    return this
  }-*/;

  public final native SampledPositionProperty setInterpolationDegree(double interpolationDegree) /*-{
    this.setInterpolationOptions(
      {
        interpolationAlgorithm : this.interpolationAlgorithm,
        interpolationDegree : interpolationDegree
      }
    )
    return this
  }-*/;

  public final native SampledPositionProperty addSamplesPackedArray(double[] packedArray) /*-{
    this.addSamplesPackedArray(packedArray)
    return this
  }-*/;

  public final native SampledPositionProperty addSamplesPackedArray(double[] packedArray, JulianDate epoch) /*-{
    this.addSamplesPackedArray(packedArray, epoch)
    return this
  }-*/;
}
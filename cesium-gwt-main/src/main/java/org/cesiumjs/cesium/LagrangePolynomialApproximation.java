package org.cesiumjs.cesium;

/**
 * @author richkadel
 *
 */
public final class LagrangePolynomialApproximation extends InterpolationAlgorithm {
  // Overlay types always have protected, zero argument constructors.
  protected LagrangePolynomialApproximation(){}
  
  public static native LagrangePolynomialApproximation get() /*-{
    return Cesium.LagrangePolynomialApproximation
  }-*/;
}
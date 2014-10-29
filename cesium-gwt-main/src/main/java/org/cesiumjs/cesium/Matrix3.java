package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

/**
 * @author richkadel
 *
 */
public final class Matrix3 extends JavaScriptObject {
  
  // Overlay types always have protected, zero argument constructors.
  protected Matrix3(){}
  
  private static native Matrix3 getConstant(String name) /*-{
    return Cesium.Matrix3[name];
  }-*/;
  
  public static final Matrix3 IDENTITY = getConstant("IDENTITY");
  
  public static native Matrix3 create() /*-{
    return new Cesium.Matrix3();
  }-*/;
  
  public static native Matrix3 create(JsArrayNumber array) /*-{
    return Cesium.Matrix3.fromArray(array);
  }-*/;
  
  public native boolean equals(Matrix3 right) /*-{ return this.equals(right) }-*/;

  public static native Cartesian3 multiplyByVector(
      Matrix3 matrix, Cartesian3 cartesian3, Cartesian3 result) /*-{
    return Cesium.Matrix3.multiplyByVector(matrix, cartesian3, result);
  }-*/;

  public static native Matrix3 multiplyByScalar(
      Matrix3 matrix, double scalar, Matrix3 result) /*-{
    return Cesium.Matrix3.multiplyByScalar(matrix, scalar, result);
  }-*/;

  public native Matrix3 cloneMatrix3() /*-{
    return this.clone()
  }-*/;

  public static native Matrix3 cloneMatrix3(Matrix3 matrix3) /*-{
    return Cesium.Matrix3.clone(matrix3)
  }-*/;

  public static native Matrix3 clone(Matrix3 matrix3, Matrix3 result) /*-{
    return Cesium.Matrix3.clone(matrix3, result)
  }-*/;
}
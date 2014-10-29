package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

/**
 * @author richkadel
 *
 */
public final class Matrix4 extends JavaScriptObject {
  
  // Overlay types always have protected, zero argument constructors.
  protected Matrix4(){}
  
  private static native Matrix4 getConstant(String name) /*-{
    return Cesium.Matrix4[name];
  }-*/;
  
  public static final Matrix4 IDENTITY = getConstant("IDENTITY");
  
  public static native Matrix4 create() /*-{
    return new Cesium.Matrix4();
  }-*/;
  
  public static native Matrix4 create(JsArrayNumber array) /*-{
    return Cesium.Matrix4.fromArray(array);
  }-*/;
  
  public native boolean equals(Matrix4 right) /*-{ return this.equals(right) }-*/;

  public static native Matrix4 multiplyByTranslation(
      Matrix4 matrix, Cartesian3 translation, Matrix4 result) /*-{
    return Cesium.Matrix4.multiplyByTranslation(matrix, translation, result);
  }-*/;

  public static native Cartesian3 multiplyByPoint(
      Matrix4 matrix, Cartesian3 cartesian, Cartesian3 result) /*-{
    return Cesium.Matrix4.multiplyByPoint(matrix, cartesian, result);
  }-*/;

  public native Matrix4 cloneMatrix4() /*-{
    return this.clone()
  }-*/;

  public static native Matrix4 cloneMatrix4(Matrix4 matrix4) /*-{
    return Cesium.Matrix4.clone(matrix4)
  }-*/;

  public static native Matrix4 clone(Matrix4 matrix4, Matrix4 result) /*-{
    return Cesium.Matrix4.clone(matrix4, result)
  }-*/;
}
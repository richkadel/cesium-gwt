package com.harmonia.cesiumjs.gwt;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

/**
 * @author richkadel
 *
 */
public final class Matrix4 extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected Matrix4(){}
  
  public static native Cartesian4 create(JsArrayNumber array) /*-{
    return Cesium.Matrix4.fromArray(array);
  }-*/;
  
  public native boolean equals(Matrix4 right) /*-{ return this.equals(right) }-*/;
}
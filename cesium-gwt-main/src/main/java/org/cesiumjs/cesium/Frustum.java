package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

public class Frustum extends JavaScriptObject {

  protected Frustum() {}

  public final native void setFar(double far) /*-{
    this.far = far
  }-*/;

  public final native double getFar() /*-{
    return this.far
  }-*/;

  public final native void setNear(double near) /*-{
    this.near = near
  }-*/;

  public final native double getNear() /*-{
    return this.near
  }-*/;

  public final native void setProjectionMatrix(Matrix4 projectionMatrix) /*-{
    this.projectionMatrix = projectionMatrix
  }-*/;

  public final native Matrix4 getProjectionMatrix() /*-{
    return this.projectionMatrix
  }-*/;

}

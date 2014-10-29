package org.cesiumjs.cesium.models;

import org.cesiumjs.cesium.Matrix4;

import com.google.gwt.core.client.JavaScriptObject;

public final class ModelNode extends JavaScriptObject {
  
  protected ModelNode() {}
  
  public native String getId() /*-{
    return this.id
  }-*/;
    
  public native String getName() /*-{
    return this.name
  }-*/;
    
  public native void setMatrix(Matrix4 matrix) /*-{
    this.matrix = matrix
  }-*/;
    
  public native Matrix4 getMatrix() /*-{
    return this.matrix
  }-*/;
}
  
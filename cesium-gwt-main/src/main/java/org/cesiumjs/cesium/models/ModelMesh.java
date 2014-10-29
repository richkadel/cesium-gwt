package org.cesiumjs.cesium.models;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public final class ModelMesh extends JavaScriptObject {
  
  protected ModelMesh() {}
  
  public native String getId() /*-{
    return this.id
  }-*/;
    
  public native String getName() /*-{
    return this.name
  }-*/;
    
  public native JsArray<ModelMaterial> getMaterials() /*-{
    return this.materials
  }-*/;
}
  
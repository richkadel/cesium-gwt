package org.cesiumjs.cesium.models;

import org.cesiumjs.cesium.JSONDerivedObject;

public final class ModelMaterial extends JSONDerivedObject {
  
  protected ModelMaterial() {}
  
  public native String getId() /*-{
    return this.id
  }-*/;
    
  public native String getName() /*-{
    return this.name
  }-*/;
}
  
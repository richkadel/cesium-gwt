package org.cesiumjs.cesium;

import org.cesiumjs.cesium.materials.Material;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public final class Polyline extends JavaScriptObject {
  
  protected Polyline() {}

  public static native Polyline create() /*-{
    return {} // Just hold properties for now.  The Cesium.Polyline is constructed by calling PolylineCollection.add
  }-*/;
  
  public native boolean getShow() /*-{
    return this.show;
  }-*/;

    
  public native Polyline setShow(boolean show) /*-{ 
    this.show = show
    return this
  }-*/;
  
  public native Polyline setWidth(double width) /*-{
    this.width = width;
    return this;
  }-*/;
  
  public native Polyline setMaterial(Material material) /*-{
    this.material = material;
    return this;
  }-*/;
  
  public native Material getMaterial() /*-{
    return this.material;
  }-*/;

  
  public native boolean getLoop() /*-{
    return this.loop;
  }-*/;
  
  public native Polyline setLoop(boolean loop) /*-{
    this.loop = loop;
    return this;
  }-*/;
    
  public native Polyline setPositions(JsArray<Cartesian3> position) /*-{ 
    this.positions = position
    return this
  }-*/;    
  
  public native JsArray<Cartesian3> getPositions() /*-{
    return this.positions;
  }-*/;
    
  public native <T> T getId() /*-{ return this.id; }-*/;
  
  public native <T> Polyline setId(T id) /*-{
    this.id = id
    return this
  }-*/;
}

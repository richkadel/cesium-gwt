package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public final class GeometryInstance extends JavaScriptObject {
  
  // Overlay types always have protected, zero argument constructors.
  protected GeometryInstance(){}

  public final native static GeometryInstance create(Geometry geometry) /*-{
    return new Cesium.GeometryInstance({
      geometry : geometry
    });
  }-*/;

  public native GeometryInstance setGeometry(Geometry geometry) /*-{ 
    this.geometry = geometry
    return this
  }-*/;
    
  public native GeometryInstance setModelMatrix(Matrix4 modelMatrix) /*-{ 
    this.modelMatrix = modelMatrix
    return this
  }-*/;
    
  public native GeometryInstance setId(JavaScriptObject id) /*-{ 
    this.id = id
    return this
  }-*/;
    
  public native GeometryInstance setAttributes(GeometryInstanceAttributes attributes) /*-{ 
    this.attributes = attributes
    return this
  }-*/;
  
  public native Geometry getGeometry() /*-{
    return this.geometry;
  }-*/;

  public native Matrix4 getModelMatrix() /*-{
    return this.modelMatrix;
  }-*/;

  public native JavaScriptObject getId() /*-{
    return this.id;
  }-*/;

  public native JavaScriptObject getAttributes() /*-{
    return this.attributes;
  }-*/;
}
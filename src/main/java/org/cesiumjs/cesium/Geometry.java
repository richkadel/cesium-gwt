package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * 
 * @author richkadel
 *
 */
public class Geometry extends JavaScriptObject {
  
  protected Geometry() {}

  public final native BoundingSphere getBoundingSphere() /*-{
    return this.boundingSphere;
  }-*/;
  
  // TODO: As needed. For now, I get the Geometry from BoxGeometry.createGeometry. If I implement this now, I also have to implement the other classes
  // it refers to, e.g., GeometryAttributes (and GeometryAttribute), Uint16Array, BoundingSphere, ...
  
//  public static native Geometry create() /*-{
//    return {}
//  }-*/;
//    
//  public native Geometry setAttributes(GeometryAttributes attributes) /*-{ 
//  	this.attributes = attributes
//  	return this
//  }-*/;
// ...
}
  
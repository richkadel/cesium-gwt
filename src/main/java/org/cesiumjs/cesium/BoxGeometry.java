package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Javascript example to emulate:
 * 
 * var box = new Cesium.BoxGeometry({
 *   vertexFormat : Cesium.VertexFormat.POSITION_ONLY,
 *   maximumCorner : new Cesium.Cartesian3(250000.0, 250000.0, 250000.0),
 *   minimumCorner : new Cesium.Cartesian3(-250000.0, -250000.0, -250000.0)
 * });
 * var geometry = Cesium.BoxGeometry.createGeometry(box);
 * @author richkadel
 *
 */
public final class BoxGeometry extends JavaScriptObject {
  
  protected BoxGeometry() {}
  
  public static native BoxGeometry create(Options options) /*-{
    return new Cesium.BoxGeometry(options)
  }-*/;
    
  public native Geometry createGeometry() /*-{
    return Cesium.BoxGeometry.createGeometry(this)
  }-*/;
  
  public static native BoxGeometry fromDimensions(Cartesian3 dimensions, VertexFormat vertexFormat) /*-{
    return Cesium.BoxGeometry.fromDimensions({
      dimensions : dimensions,
      vertexFormat : vertexFormat
    })
  }-*/;
    
  public static final class Options extends JavaScriptObject {
    // Overlay types always have protected, zero argument constructors.
    protected Options(){}
    
    public static native Options create() /*-{
      return {}
    }-*/;
    
    public native Options setMinimumCorner(Cartesian3 minimumCorner) /*-{ 
    	this.minimumCorner = minimumCorner
    	return this
    }-*/;
      
    public native Options setMaximumCorner(Cartesian3 maximumCorner) /*-{ 
    	this.maximumCorner = maximumCorner
    	return this
    }-*/;
      
    public native Options setVertexFormat(VertexFormat vertexFormat) /*-{ 
    	this.vertexFormat = vertexFormat
    	return this
    }-*/;
  }
}
  
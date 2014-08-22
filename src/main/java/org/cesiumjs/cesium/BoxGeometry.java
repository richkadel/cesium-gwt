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
public final class BoxGeometry extends Geometry {
  
  protected BoxGeometry() {}
  
  public static native BoxGeometry create() /*-{
    return {}
  }-*/;
    
  public static native BoxGeometry fromDimensions(Cartesian3 dimensions, VertexFormat vertexFormat) /*-{
    return Cesium.BoxGeometry.fromDimensions({
      dimensions : dimensions,
      vertexFormat : vertexFormat
    })
  }-*/;
    
  public static native Geometry createGeometry() /*-{
    return Cesium.BoxGeometry.createGeometry(this)
  }-*/;
    
  public native BoxGeometry setMinimumCorner(Cartesian3 minimumCorner) /*-{ 
  	this.minimumCorner = minimumCorner
  	return this
  }-*/;
    
  public native BoxGeometry setMaximumCorner(Cartesian3 maximumCorner) /*-{ 
  	this.maximumCorner = maximumCorner
  	return this
  }-*/;
    
  public native BoxGeometry setVertexFormat(VertexFormat vertexFormat) /*-{ 
  	this.vertexFormat = vertexFormat
  	return this
  }-*/;
}
  
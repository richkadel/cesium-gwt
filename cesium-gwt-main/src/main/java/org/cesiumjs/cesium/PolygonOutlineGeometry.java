package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayUtils;

/**
 * Javascript example to emulate:
 * 
 * var polygon = new Cesium.PolygonOutlineGeometry({
 *   polygonHierarchy : {
 *     positions : Cesium.Cartesian3.fromDegreesArray([
 *       -72.0, 40.0,
 *       -70.0, 35.0,
 *       -75.0, 30.0,
 *       -70.0, 30.0,
 *       -68.0, 40.0
 *     ])
 *   }
 * });
 * 
 * var geometry = Cesium.PolygonOutlineGeometry.createGeometry(polygon);
 * 
 * @author richkadel
 *
 */
public final class PolygonOutlineGeometry extends JavaScriptObject {
  
  protected PolygonOutlineGeometry() {}
  
  public static PolygonOutlineGeometry create(PolygonGeometry.Hierarchy polygonHierarchy) {
    return create(polygonHierarchy, PolygonGeometry.Options.create());
  }
  
  public static native PolygonOutlineGeometry create(PolygonGeometry.Hierarchy polygonHierarchy, PolygonGeometry.Options options) /*-{
    options.polygonHierarchy = polygonHierarchy
    return new Cesium.PolygonOutlineGeometry(options)
  }-*/;
    
  public native Geometry createGeometry() /*-{
    return Cesium.PolygonOutlineGeometry.createGeometry(this)
  }-*/;
}
  
package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayUtils;

/**
 * Javascript example to emulate:
 * 
 * var circle = new Cesium.CircleGeometry({
 *   circleHierarchy : {
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
 * var geometry = Cesium.CircleGeometry.createGeometry(circle);
 * 
 * @author richkadel
 *
 */
public final class CircleGeometry extends JavaScriptObject {
  
  protected CircleGeometry() {}
  
  public static native CircleGeometry create(Options options) /*-{
    return new Cesium.CircleGeometry(options)
  }-*/;
    
  public native Geometry createGeometry() /*-{
    return Cesium.CircleGeometry.createGeometry(this)
  }-*/;
  
  public static final class Options extends JavaScriptObject {

    protected Options(){}
    
    public static native Options create() /*-{
      return {}
    }-*/;
    
// Documentation does not say these are in meters (units not specified) but test appear to confirm it.
    public native Options heightMeters(double heightMeters) /*-{
      this.height = heightMeters
      return this;
    }-*/;
    
// Documentation does not say these are in meters (units not specified) but test appear to confirm it.
    public native Options extrudedHeightMeters(double extrudedHeightMeters) /*-{
      this.extrudedHeight = extrudedHeightMeters
      return this;
    }-*/;

    public native Options center(Cartesian3 center) /*-{
      this.center = center
      return this;
    }-*/;

    public native Options radiusMeters(double radiusMeters) /*-{
      this.radius = radiusMeters
      return this;
    }-*/;

    public native Options granularityRadians(double granularityRadians) /*-{
      this.granularity = granularityRadians
      return this;
    }-*/;

    public native Options vertexFormat(VertexFormat vertexFormat) /*-{
      this.vertexFormat = vertexFormat
      return this;
    }-*/;

    public native Options ellipsoid(Ellipsoid ellipsoid) /*-{
      this.ellipsoid = ellipsoid
      return this;
    }-*/;

    public native Options stRotationRadians(double stRotationRadians) /*-{
      this.stRotation = stRotationRadians
      return this;
    }-*/;
  }
}
  
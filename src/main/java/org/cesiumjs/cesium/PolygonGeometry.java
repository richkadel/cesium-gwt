package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayUtils;

/**
 * Javascript example to emulate:
 * 
 * var polygon = new Cesium.PolygonGeometry({
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
 * var geometry = Cesium.PolygonGeometry.createGeometry(polygon);
 * 
 * @author richkadel
 *
 */
public final class PolygonGeometry extends JavaScriptObject {
  
  protected PolygonGeometry() {}
  
  public static PolygonGeometry create(Hierarchy polygonHierarchy) {
    return create(polygonHierarchy, Options.create());
  }
  
  public static native PolygonGeometry create(Hierarchy polygonHierarchy, Options options) /*-{
    options.polygonHierarchy = polygonHierarchy
    return new Cesium.PolygonGeometry(options)
  }-*/;
    
  public static PolygonGeometry fromPositions(double[] positionsInCartesianPairs) {
    return fromPositions(positionsInCartesianPairs, Options.create());
  }
  
  public static native PolygonGeometry fromPositions(double[] positionsInCartesianPairs, Options options) /*-{
    options.positions = positionsInCartesianPairs
    return new Cesium.PolygonGeometry.fromPositions(options)
  }-*/;
    
  public native Geometry createGeometry() /*-{
    return Cesium.PolygonGeometry.createGeometry(this)
  }-*/;
  
  public static final class Hierarchy extends JavaScriptObject {

    protected Hierarchy(){}
    
    public static Hierarchy create(double[] positionsInCartesianPairs) {
      return create(JsArrayUtils.readOnlyJsArray(positionsInCartesianPairs));
    }
    
    private static native Hierarchy create(JsArrayNumber positionsInCartesianPairs) /*-{
      return {
        positions : positionsInCartesianPairs
      }
    }-*/;
    
    public static Hierarchy create(double[] positionsInCartesianPairs, JsArray<Hierarchy> holes) {
      return create(JsArrayUtils.readOnlyJsArray(positionsInCartesianPairs));
    }
    
    private static native Hierarchy create(JsArrayNumber positionsInCartesianPairs, JsArray<Hierarchy> holes) /*-{
      return {
        positions : positionsInCartesianPairs,
        holes : holes
      }
    }-*/;
  }
    
  public static final class Holes {

    private Holes(){}
    
    public static JsArray<Hierarchy> create(Hierarchy... hierarchies) {
      JsArray<Hierarchy> holes = JsArray.createArray(hierarchies.length).cast();
      int i = 0;
      for (Hierarchy hierarchy : hierarchies) {
        holes.set(i++, hierarchy);
      }
      return holes;
    }
  }
    
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

    public native Options vertexFormat(VertexFormat vertexFormat) /*-{
      this.vertexFormat = vertexFormat
      return this;
    }-*/;

    public native Options perPositionHeight(boolean perPositionHeight) /*-{
      this.perPositionHeight = perPositionHeight
      return this;
    }-*/;
  }
}
  
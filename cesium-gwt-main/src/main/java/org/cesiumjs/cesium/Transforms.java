package org.cesiumjs.cesium;

import org.cesiumjs.cesium.time.JulianDate;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public final class Transforms extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected Transforms(){}
  
  public static native Matrix4 eastNorthUpToFixedFrame(Cartesian3 center) /*-{
    return Cesium.Transforms.eastNorthUpToFixedFrame(center) 
  }-*/;

  public static native Matrix4 eastNorthUpToFixedFrame(Cartesian3 center, Ellipsoid ellipsoid) /*-{
    return Cesium.Transforms.eastNorthUpToFixedFrame(center, ellipsoid) 
  }-*/;

  public static native Matrix4 northEastDownToFixedFrame(Cartesian3 center) /*-{
    return Cesium.Transforms.northEastDownToFixedFrame(center) 
  }-*/;

  public static native Matrix4 northEastDownToFixedFrame(Cartesian3 center, Ellipsoid ellipsoid) /*-{
    return Cesium.Transforms.northEastDownToFixedFrame(center, ellipsoid) 
  }-*/;

  public static native Matrix4 northUpEastToFixedFrame(Cartesian3 center) /*-{
    return Cesium.Transforms.northUpEastToFixedFrame(center) 
  }-*/;

  public static native Matrix4 northUpEastToFixedFrame(Cartesian3 center, Ellipsoid ellipsoid) /*-{
    return Cesium.Transforms.northUpEastToFixedFrame(center, ellipsoid) 
  }-*/;

  public static native Matrix3 computeTemeToPseudoFixedMatrix(JulianDate date) /*-{
    return Cesium.Transforms.computeTemeToPseudoFixedMatrix(date) 
  }-*/;

  public static native Matrix3 computeIcrfToFixedMatrix(JulianDate date) /*-{
    return Cesium.Transforms.computeIcrfToFixedMatrix(date) 
  }-*/;

  public static native Matrix3 computeFixedToIcrfMatrix(JulianDate date) /*-{
    return Cesium.Transforms.computeFixedToIcrfMatrix(date) 
  }-*/;

  public static native Cartesian2 pointToWindowCoordinates(Matrix4 modelViewProjectionMatrix, Matrix4 viewportTransformation, Cartesian3 point) /*-{
    return Cesium.Transforms.pointToWindowCoordinates(modelViewProjectionMatrix, viewportTransformation, point)
  }-*/;
}
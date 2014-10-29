package org.cesiumjs.cesium.data;

import org.cesiumjs.cesium.Undocumented;
import org.cesiumjs.cesium.time.TimeIntervalCollection;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public final class Entity extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected Entity(){}
  
  public static native Entity create() /*-{
    return new Cesium.Entity()
  }-*/;
  
  public static native Entity create(String id) /*-{
    return new Cesium.Entity(id)
  }-*/;
  
  public native String getId() /*-{
    return this.id
  }-*/;

  public native Entity setVersion(String version) /*-{
    this.version = version
    return this
  }-*/;

  public native Entity setAvailability(TimeIntervalCollection availability) /*-{
    this.availability = availability
    return this
  }-*/;

  public native Entity setBillboard(BillboardGraphics billboard) /*-{
    this.billboard = billboard
    return this
  }-*/;

  public native Entity setLabel(LabelGraphics label) /*-{
    this.label = label
    return this
  }-*/;

  public native Entity setPosition(PositionProperty position) /*-{
    this.position = position
    return this
  }-*/;

  public native Entity setPath(PathGraphics path) /*-{
    this.path = path
    return this
  }-*/;

  public native String getName() /*-{
    return this.name
  }-*/;

  public native PathGraphics getPolygon() /*-{
    return this.polygon
  }-*/;

  public native Undocumented getProperties() /*-{
    return this.properties
  }-*/;
}
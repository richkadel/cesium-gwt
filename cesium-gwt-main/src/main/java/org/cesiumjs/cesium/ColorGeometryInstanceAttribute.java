package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public class ColorGeometryInstanceAttribute extends JavaScriptObject {
  
  // Overlay types always have protected, zero argument constructors.
  protected ColorGeometryInstanceAttribute(){}

  public final native static ColorGeometryInstanceAttribute create(double red, double green, double blue, double alpha) /*-{
    return new Cesium.ColorGeometryInstanceAttribute(red, green, blue, alpha);
  }-*/;

  public final native static ColorGeometryInstanceAttribute fromColor(Color color) /*-{
    return new Cesium.ColorGeometryInstanceAttribute.fromColor(color)
  }-*/;
}
package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public class ShowGeometryInstanceAttribute extends JavaScriptObject {
  
  // Overlay types always have protected, zero argument constructors.
  protected ShowGeometryInstanceAttribute(){}

  public final native static ShowGeometryInstanceAttribute create() /*-{
    return new Cesium.ShowGeometryInstanceAttribute();
  }-*/;

  public final native static ShowGeometryInstanceAttribute create(boolean show) /*-{
    return new Cesium.ShowGeometryInstanceAttribute(show);
  }-*/;
}
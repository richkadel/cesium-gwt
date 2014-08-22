package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public final class GeometryInstanceAttributes extends JavaScriptObject {
  
  // Overlay types always have protected, zero argument constructors.
  protected GeometryInstanceAttributes(){}
  
  public static native GeometryInstanceAttributes create() /*-{
    return {}
  }-*/;
  
  public native GeometryInstanceAttributes set(String name, JavaScriptObject property) /*-{
    this[name] = property;
    return this;
  }-*/;
}
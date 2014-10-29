package org.cesiumjs.cesium.data;

import org.cesiumjs.cesium.events.Event;
import org.cesiumjs.cesium.time.JulianDate;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public class Property<T> extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected Property(){}

  public final native Event onDefinitionChanged() /*-{
    return this.definitionChanged
  }-*/;

  public final native boolean isConstant() /*-{
    return this.isConstant
  }-*/;

  public final native boolean equals(Property<T> other) /*-{
    return this.equals(other)
  }-*/;

  public final native T getValue(JulianDate time) /*-{
    return this.getValue(time)
  }-*/;

  public final native T getValue(JulianDate time, T result) /*-{
    return this.getValue(time, result)
  }-*/;
}
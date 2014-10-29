package org.cesiumjs.cesium.data;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public class ConstantProperty<T extends JavaScriptObject> extends Property<T> {
  // Overlay types always have protected, zero argument constructors.
  protected ConstantProperty(){}

  public final static native <T extends JavaScriptObject> ConstantProperty<T> create() /*-{
    return new Cesium.ConstantProperty()
  }-*/;

  public final static native <T extends JavaScriptObject> ConstantProperty<T> create(T value) /*-{
    return new Cesium.ConstantProperty(value)
  }-*/;

  public final native ConstantProperty<T> setValue(T value) /*-{
    this.setValue(value)
    return this
  }-*/;
}
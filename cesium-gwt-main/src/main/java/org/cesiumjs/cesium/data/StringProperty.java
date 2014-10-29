package org.cesiumjs.cesium.data;


/**
 * @author richkadel
 *
 */
public class StringProperty extends Property<String> {
  // Overlay types always have protected, zero argument constructors.
  protected StringProperty(){}

  public final static native StringProperty create() /*-{
    return new Cesium.ConstantProperty()
  }-*/;

  public final static native StringProperty create(String value) /*-{
    return new Cesium.ConstantProperty(value)
  }-*/;

  public final native StringProperty setValue(String value) /*-{
    this.setValue(value)
    return this
  }-*/;
}
package org.cesiumjs.cesium.data;


/**
 * @author richkadel
 *
 */
public class NumberProperty extends Property<Number> {
  // Overlay types always have protected, zero argument constructors.
  protected NumberProperty(){}

  public final static native NumberProperty create() /*-{
    return new Cesium.ConstantProperty();
  }-*/;

  public final static native NumberProperty create(double value) /*-{
    return new Cesium.ConstantProperty(value);
  }-*/;

  public final native NumberProperty setValue(double value) /*-{
    this.setValue(value)
    return this
  }-*/;
}
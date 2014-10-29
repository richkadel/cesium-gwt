package org.cesiumjs.cesium.data;


/**
 * @author richkadel
 *
 */
public class BooleanProperty extends Property<Boolean> {
  // Overlay types always have protected, zero argument constructors.
  protected BooleanProperty(){}

  public final static native BooleanProperty create() /*-{
    return new Cesium.ConstantProperty();
  }-*/;

  public final static native BooleanProperty create(boolean value) /*-{
    return new Cesium.ConstantProperty(value);
  }-*/;

  public final native BooleanProperty setValue(boolean value) /*-{
    this.setValue(value)
    return this
  }-*/;
}
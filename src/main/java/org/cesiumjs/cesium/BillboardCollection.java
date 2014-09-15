package org.cesiumjs.cesium;


/**
 * I tried to create a superclass "Primitive" for both LabelCollection and BillboardCollection
 * so the add() method in PrimitiveCollection wouldn't have to be duplicated, but 
 * I got runtime errors.  I think it's a GWT bug, but keeping the classes separate fixed it.
 * @author richkadel
 *
 */
public final class BillboardCollection extends Primitive {
  // Overlay types always have protected, zero argument constructors.
  protected BillboardCollection(){}

  public final static native BillboardCollection create() /*-{
    return new Cesium.BillboardCollection()
  }-*/;

  public final native Billboard add(Billboard billboard) /*-{
    return this.add(billboard);
  }-*/;

  public final native boolean contains(Billboard billboard) /*-{
    return this.contains(billboard);
  }-*/;

  public final native Billboard get(int index) /*-{
    return this.get(index);
  }-*/;

  public final native boolean remove(Billboard billboard) /*-{
    return this.remove(billboard);
  }-*/;

  public final native void removeAll() /*-{
    this.removeAll();
  }-*/;

  public final native int getLength()/*-{
    return this.length;
  }-*/;
}
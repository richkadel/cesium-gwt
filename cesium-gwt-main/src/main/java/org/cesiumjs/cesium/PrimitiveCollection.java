package org.cesiumjs.cesium;

/**
 * I tried to create a superclass "Primitive" for both LabelCollection and BillboardCollection
 * so the add() method in PrimitiveCollection wouldn't have to be duplicated, but 
 * I got runtime errors.  I think it's a GWT bug, but keeping the classes separate fixed it.
 * 
 * @author richkadel
 */
public final class PrimitiveCollection extends Primitive {
  // Overlay types always have protected, zero argument constructors.
  protected PrimitiveCollection(){}
  
  public native Primitive add(Primitive primitive) /*-{
    return this.add(primitive)
  }-*/;

  public native void removeAll() /*-{
    this.removeAll()
  }-*/;
}
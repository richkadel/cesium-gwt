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
  
  public native <T extends Primitive> T add(T primitive) /*-{
    return this.add(primitive)
  }-*/;
  
  public final native boolean remove(Primitive primitive) /*-{
    return this.remove(primitive);
  }-*/;

  public native void removeAll() /*-{
    this.removeAll()
  }-*/;
  
  public native void lower(Primitive primitive)/*-{
    this.lower(primitive)
  }-*/;
  
  public native void lowerToBotton(Primitive primitive)/*-{
    this.lowerToBotton(primitive)
  }-*/;
  
  public native void raise(Primitive primitive)/*-{
    this.raise(primitive)
  }-*/;
  
  public native void raiseToTop(Primitive primitive)/*-{
    this.raiseToTop(primitive)
  }-*/;
}
package org.cesiumjs.cesium;

/**
 * I tried to create a superclass "Primitive" for both LabelCollection and BillboardCollection
 * so the add() method in PrimitiveCollection wouldn't have to be duplicated, but 
 * I got runtime errors.  I think it's a GWT bug, but keeping the classes separate fixed it.
 * @author richkadel
 *
 */
public final class PolylineCollection extends Primitive {
  // Overlay types always have protected, zero argument constructors.
  protected PolylineCollection(){}
  
  public final static native PolylineCollection create() /*-{
      return new Cesium.PolylineCollection()
  }-*/;
  
  public final native Polyline add(Polyline polyline) /*-{
    return this.add(polyline);
  }-*/;
  
  public final native boolean contains(Polyline polyline) /*-{
    return this.contains(polyline);
  }-*/;
  
  public final native Polyline get(int index) /*-{
    return this.get(index);
  }-*/;
  
  public final native boolean remove(Polyline polyline) /*-{
    return this.remove(polyline);
  }-*/;
  
  public final native void removeAll() /*-{
    this.removeAll();
  }-*/;
  
  public final native int getLength()/*-{
    return this.length;
  }-*/;
}
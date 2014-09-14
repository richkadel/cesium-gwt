package org.cesiumjs.cesium;


/**
 * @author richkadel
 *
 */
public final class LabelCollection extends Primitive {
  // Overlay types always have protected, zero argument constructors.
  protected LabelCollection(){}

  public final static native LabelCollection create() /*-{
      return new Cesium.LabelCollection()
  }-*/;
  
  public final native Label add(Label label) /*-{
    return this.add(label);
  }-*/;
  
  public final native boolean contains(Label label) /*-{
    return this.contains(label);
  }-*/;
  
  public final native Label get(int index) /*-{
    return this.get(index);
  }-*/;
  
  public final native boolean remove(Label label) /*-{
    return this.remove(label);
  }-*/;
  
  public final native void removeAll() /*-{
    this.removeAll();
  }-*/;
  
  public final native int getLength()/*-{
    return this.length;
  }-*/;
}
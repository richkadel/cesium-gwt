package org.cesiumjs.cesium;


/**
 * @author richkadel
 *
 */
public final class PickedObject extends Undocumented {
  
  protected PickedObject(){}
  
  public native <T> T getId() /*-{ return this.id; }-*/;
  
  public native Primitive getPrimitive() /*-{ return this.primitive; }-*/;
}
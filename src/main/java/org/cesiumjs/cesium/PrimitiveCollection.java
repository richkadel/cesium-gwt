package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * I tried to create a superclass "Primitive" for both LabelCollection and BillboardCollection
 * so the add() method in PrimitiveCollection wouldn't have to be duplicated, but 
 * I got runtime errors.  I think it's a GWT bug, but keeping the classes separate fixed it.
 * 
 * @author richkadel
 */
public final class PrimitiveCollection extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected PrimitiveCollection(){}
  
	public native PrimitiveCollection add(BillboardCollection primitive) /*-{
		this.add(primitive)
	}-*/;
  
	public native PrimitiveCollection add(LabelCollection primitive) /*-{
		this.add(primitive)
	}-*/;

  public native void add(Primitive primitive) /*-{
		this.add(primitive)
  }-*/;
}
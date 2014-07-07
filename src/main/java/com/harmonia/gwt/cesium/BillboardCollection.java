package com.harmonia.gwt.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * I tried to create a superclass "Primitive" for both LabelCollection and BillboardCollection
 * so the add() method in CompositePrimitive wouldn't have to be duplicated, but 
 * I got runtime errors.  I think it's a GWT bug, but keeping the classes separate fixed it.
 * @author richkadel
 *
 */
public final class BillboardCollection extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected BillboardCollection(){}
  
	public final static native BillboardCollection create() /*-{
    return new Cesium.BillboardCollection()
	}-*/;
  
  public final native void setTextureAtlas(TextureAtlas textureAtlas) /*-{ this.textureAtlas = textureAtlas; }-*/;

	public final native void add(BillboardOptions options) /*-{
    this.add(options);
	}-*/;
}
package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public final class BillboardOptions extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected BillboardOptions(){}
  
  public static native BillboardOptions create() /*-{
    return {}
  }-*/;
  
  public native BillboardOptions setPosition(Cartesian3 position) /*-{ 
  	this.position = position
  	return this
  }-*/;
  
  public native BillboardOptions setImageIndex(int imageIndex) /*-{ 
  	this.imageIndex = imageIndex
  	return this
  }-*/;
  
  public native BillboardOptions setScale(double scale) /*-{ 
  	this.scale = scale
  	return this
  }-*/;
}
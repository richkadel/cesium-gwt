package com.harmonia.cesiumjs.gwt;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 * // Example 1:  Add a label, specifying all the default values.
 * var l = labels.add({
 *  show : true,
 *  position : Cesium.Cartesian3.ZERO,
 *  text : '',
 *  font : '30px sans-serif',
 *  fillColor : 'white',
 *  outlineColor : 'white',
 *  style : Cesium.LabelStyle.FILL,
 *  pixelOffset : Cesium.Cartesian2.ZERO,
 *  eyeOffset : Cesium.Cartesian3.ZERO,
 *  horizontalOrigin : Cesium.HorizontalOrigin.LEFT,
 *  verticalOrigin : Cesium.VerticalOrigin.BOTTOM,
 *  scale : 1.0
 * });
 * 
 * // Example 2:  Specify only the label's cartographic position,
 * // text, and font.
 * var l = labels.add({
 *   position : ellipsoid.cartographicToCartesian(new Cesium.Cartographic(longitude, latitude, height)),
 *   text : 'Hello World',
 *   font : '24px Helvetica',
 * });
 */
public final class LabelOptions extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected LabelOptions(){}
  
  public static native LabelOptions create() /*-{
    return {}
  }-*/;
  
  public native LabelOptions setPosition(Cartesian3 position) /*-{ 
  	this.position = position
  	return this
  }-*/;
  
  public native LabelOptions setText(String text) /*-{ 
  	this.text = text
  	return this
  }-*/;
  
  public native LabelOptions setFont(String font) /*-{ 
  	this.font = font
  	return this
  }-*/;
  
  public native LabelOptions setPixelOffset(Cartesian2 pixelOffset) /*-{ 
  	this.pixelOffset = pixelOffset
  	return this
  }-*/;
  
  public native LabelOptions setHorizontalOrigin(HorizontalOrigin horizontalOrigin) /*-{ 
  	this.horizontalOrigin = horizontalOrigin
  	return this
  }-*/;
  
  public native LabelOptions setVerticalOrigin(VerticalOrigin verticalOrigin) /*-{ 
  	this.verticalOrigin = verticalOrigin
  	return this
  }-*/;
  
  public native LabelOptions setScale(double scale) /*-{ 
  	this.scale = scale
  	return this
  }-*/;
}
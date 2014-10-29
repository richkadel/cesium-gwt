package org.cesiumjs.cesium;

import org.cesiumjs.cesium.data.Property;

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
 *  fillColor : Cesium.Color.WHITE,
 *  outlineColor : Cesium.Color.BLACK,
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
 *   position : Cesium.Cartesian3.fromDegrees(longitude, latitude, height),
 *   text : 'Hello World',
 *   font : '24px Helvetica',
 * });
 */
public final class Label extends JavaScriptObject {
  
  protected Label() {}
  
  public static native Label create() /*-{
    return {} // Just hold properties for now.  The Cesium.Label is constructed by calling LabelCollection.add
  }-*/;
    
  public native Label setShow(boolean show) /*-{ 
    this.show = show
    return this
  }-*/;
    
  public native Label setShow(Property<Boolean> show) /*-{ 
    this.show = show
    return this
  }-*/;
    
  public native Label setPosition(Cartesian3 position) /*-{ 
    this.position = position
    return this
  }-*/;
    
  public native Label setText(String text) /*-{ 
    this.text = text
    return this
  }-*/;
    
  public native Label setFont(String font) /*-{ 
    this.font = font
    return this
  }-*/;
    
  public native Label setFillColor(Color fillColor) /*-{ 
    this.fillColor = fillColor
    return this
  }-*/;
    
  public native Label setFillColor(Property<Color> fillColor) /*-{ 
    this.fillColor = fillColor
    return this
  }-*/;
    
  public native Label setOutlineColor(Color outlineColor) /*-{ 
    this.outlineColor = outlineColor
    return this
  }-*/;
    
  public Label setLabelStyle(LabelStyle labelStyle) { 
    setLabelStyle(labelStyle.toString());
    return this;
  }
    
  private native Label setLabelStyle(String labelStyle) /*-{ 
    this.labelStyle = Cesium.LabelStyle[labelStyle]
    return this
  }-*/;
    
  public native Label setPixelOffset(Cartesian2 pixelOffset) /*-{ 
    this.pixelOffset = pixelOffset
    return this
  }-*/;
    
  public native Label setEyeOffset(Cartesian3 eyeOffset) /*-{ 
    this.eyeOffset = eyeOffset
    return this
  }-*/;
    
  public Label setHorizontalOrigin(HorizontalOrigin horizontalOrigin) { 
    return setHorizontalOrigin(horizontalOrigin.toString());
  };
    
  private native Label setHorizontalOrigin(String type) /*-{ 
    this.horizontalOrigin = Cesium.HorizontalOrigin[type]
    return this
  }-*/;
    
  public Label setVerticalOrigin(VerticalOrigin verticalOrigin) { 
    return setVerticalOrigin(verticalOrigin.toString());
  };
    
  private native Label setVerticalOrigin(String type) /*-{ 
    this.verticalOrigin = Cesium.VerticalOrigin[type]
    return this
  }-*/;
    
  public native Label setScale(double scale) /*-{ 
    this.scale = scale
    return this
  }-*/;
  
  public native <T> T getId() /*-{ return this.id; }-*/;
  
  public native <T> Label setId(T id) /*-{
    this.id = id
    return this
  }-*/;
}
  
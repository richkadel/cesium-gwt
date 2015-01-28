package org.cesiumjs.cesium;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Image;

public final class Billboard extends JavaScriptObject {
  
  protected Billboard() {}

  public static native Billboard create() /*-{
    return {} // Just hold properties for now.  The Cesium.Billboard is constructed by calling BillboardCollection.add
  }-*/;
    
  public native Billboard setShow(boolean show) /*-{ 
    this.show = show
    return this
  }-*/;
    
  public native Billboard setPosition(Cartesian3 position) /*-{ 
    this.position = position
    return this
  }-*/;
    
  public native Billboard setPixelOffset(Cartesian2 pixelOffset) /*-{ 
    this.pixelOffset = pixelOffset
    return this
  }-*/;
    
  public native Billboard setEyeOffset(Cartesian3 eyeOffset) /*-{ 
    this.eyeOffset = eyeOffset
    return this
  }-*/;
    
  public Billboard setHorizontalOrigin(HorizontalOrigin horizontalOrigin) { 
    return setHorizontalOrigin(horizontalOrigin.toString());
  };
    
  private native Billboard setHorizontalOrigin(String type) /*-{ 
    this.horizontalOrigin = Cesium.HorizontalOrigin[type]
    return this
  }-*/;
    
  public Billboard setVerticalOrigin(VerticalOrigin verticalOrigin) { 
    return setVerticalOrigin(verticalOrigin.toString());
  };
    
  private native Billboard setVerticalOrigin(String type) /*-{ 
    this.verticalOrigin = Cesium.VerticalOrigin[type]
    return this
  }-*/;
    
  public native Billboard setScale(double scale) /*-{ 
    this.scale = scale
    return this
  }-*/;
  
  public native Billboard setAlignedAxis(Cartesian3 axis) /*-{
    this.alignedAxis = axis;
    return this;
  }-*/;
  
  public native Billboard setRotation(double rotationRadians) /*-{
    this.rotation = rotationRadians;
    return this;
  }-*/;
    
  public native Billboard setImage(String url) /*-{
    this.image = url
    return this
  }-*/;
    
  public Billboard setImage(Image image) {
    setImage(image.getElement());
    return this;
  }
  
  public Billboard setImage(Canvas canvas){
	setImage(canvas.getCanvasElement());
	return this;
  }
    
  public native Billboard setImage(Element imageElement) /*-{ 
    this.image = imageElement
    return this
  }-*/;
    
  public native Billboard setImageSubRegion(BoundingRectangle subRegion) /*-{
    this.imageSubRegion = subRegion
    return this
  }-*/;
    
  public native Billboard setColor(Color color) /*-{
    this.color = color
    return this
  }-*/;
    
  public native <T> T getId() /*-{ return this.id; }-*/;
  
  public native <T> Billboard setId(T id) /*-{
    this.id = id
    return this
  }-*/;
  
}

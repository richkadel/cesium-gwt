package org.cesiumjs.cesium.data;

import org.cesiumjs.cesium.Cartesian2;
import org.cesiumjs.cesium.Cartesian3;
import org.cesiumjs.cesium.Color;
import org.cesiumjs.cesium.HorizontalOrigin;
import org.cesiumjs.cesium.VerticalOrigin;

import com.google.gwt.core.client.JavaScriptObject;

public final class BillboardGraphics extends JavaScriptObject {
  
  protected BillboardGraphics() {}

  public static native BillboardGraphics create() /*-{
    return new Cesium.BillboardGraphics()
  }-*/;
    
  public BillboardGraphics setShow(boolean show) { 
    return setShow(BooleanProperty.create(show));
  }
    
  public native BillboardGraphics setShow(Property<Boolean> show) /*-{ 
    this.show = show
    return this
  }-*/;
    
  public BillboardGraphics setPixelOffset(Cartesian2 pixelOffset) { 
    return setPixelOffset(ConstantProperty.create(pixelOffset));
  }
  
  public native BillboardGraphics setPixelOffset(Property<Cartesian2> pixelOffset) /*-{ 
    this.pixelOffset = pixelOffset
    return this
  }-*/;
    
  public BillboardGraphics setEyeOffset(Cartesian3 eyeOffset) { 
    return setEyeOffset(ConstantProperty.create(eyeOffset));
  }
  
  public native BillboardGraphics setEyeOffset(Property<Cartesian3> eyeOffset) /*-{ 
    this.eyeOffset = eyeOffset
    return this
  }-*/;
    
  public BillboardGraphics setHorizontalOrigin(HorizontalOrigin horizontalOrigin) { 
    return setHorizontalOrigin(NumberProperty.create(horizontalOrigin.toNumber()));
  };
    
  private native BillboardGraphics setHorizontalOrigin(Property<Number> horizontalOrigin) /*-{ 
    this.horizontalOrigin = horizontalOrigin
    return this
  }-*/;
    
  public BillboardGraphics setVerticalOrigin(VerticalOrigin verticalOrigin) { 
    return setVerticalOrigin(NumberProperty.create(verticalOrigin.toNumber()));
  };
    
  private native BillboardGraphics setVerticalOrigin(Property<Number> verticalOrigin) /*-{ 
    this.verticalOrigin = verticalOrigin
    return this
  }-*/;
    
  public BillboardGraphics setScale(double scale) { 
    return setScale(NumberProperty.create(scale));
  }
  
  public native BillboardGraphics setScale(Property<Number> scale) /*-{ 
    this.scale = scale
    return this
  }-*/;
  
  public BillboardGraphics setAlignedAxis(Cartesian3 axis) {
    return setAlignedAxis(ConstantProperty.create(axis));
  }
  
  public native BillboardGraphics setAlignedAxis(Property<Cartesian3> axis) /*-{
    this.alignedAxis = axis;
    return this;
  }-*/;
  
  public BillboardGraphics setRotation(double rotationRadians) {
    return setRotation(NumberProperty.create(rotationRadians));
  }
  
  public native BillboardGraphics setRotation(Property<Number> rotationRadians) /*-{
    this.rotation = rotationRadians;
    return this;
  }-*/;
    
  public BillboardGraphics setImage(String url) {
    return setImage(StringProperty.create(url));
  }
  
  public native BillboardGraphics setImage(Property<String> url) /*-{
    
    
//    function unwrapImageInterval(czmlInterval, sourceUri) {
//        var result = defaultValue(czmlInterval.image, czmlInterval);
//        if (defined(sourceUri)) {
//            var baseUri = new Uri(document.location.href);
//            sourceUri = new Uri(sourceUri);
//            result = new Uri(result).resolve(sourceUri.resolve(baseUri)).toString();
//        }
//        return result;
//    }
    
    this.image = url
    return this
  }-*/;
    
  public BillboardGraphics setColor(Color color) {
    return setColor(ConstantProperty.create(color));
  }
  
  public native BillboardGraphics setColor(Property<Color> color) /*-{
    this.color = color
    return this
  }-*/;
}

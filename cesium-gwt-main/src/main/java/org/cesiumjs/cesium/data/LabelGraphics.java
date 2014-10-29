package org.cesiumjs.cesium.data;

import org.cesiumjs.cesium.Cartesian2;
import org.cesiumjs.cesium.Cartesian3;
import org.cesiumjs.cesium.Color;
import org.cesiumjs.cesium.HorizontalOrigin;
import org.cesiumjs.cesium.LabelStyle;
import org.cesiumjs.cesium.VerticalOrigin;

import com.google.gwt.core.client.JavaScriptObject;

public final class LabelGraphics extends JavaScriptObject {
  
  protected LabelGraphics() {}

  public static native LabelGraphics create() /*-{
    return new Cesium.LabelGraphics()
  }-*/;
    
  public LabelGraphics setShow(boolean show) { 
    return setShow(BooleanProperty.create(show));
  }
    
  public native LabelGraphics setShow(Property<Boolean> show) /*-{ 
    this.show = show
    return this
  }-*/;
    
  public LabelGraphics setPixelOffset(Cartesian2 pixelOffset) { 
    return setPixelOffset(ConstantProperty.create(pixelOffset));
  }
  
  public native LabelGraphics setPixelOffset(Property<Cartesian2> pixelOffset) /*-{ 
    this.pixelOffset = pixelOffset
    return this
  }-*/;
    
  public LabelGraphics setEyeOffset(Cartesian3 eyeOffset) { 
    return setEyeOffset(ConstantProperty.create(eyeOffset));
  }
  
  public native LabelGraphics setEyeOffset(Property<Cartesian3> eyeOffset) /*-{ 
    this.eyeOffset = eyeOffset
    return this
  }-*/;
  
  public LabelGraphics setHorizontalOrigin(HorizontalOrigin horizontalOrigin) { 
    return setHorizontalOrigin(NumberProperty.create(horizontalOrigin.toNumber()));
  };
    
  private native LabelGraphics setHorizontalOrigin(Property<Number> horizontalOrigin) /*-{ 
    this.horizontalOrigin = horizontalOrigin
    return this
  }-*/;
    
  public LabelGraphics setVerticalOrigin(VerticalOrigin verticalOrigin) { 
    return setVerticalOrigin(NumberProperty.create(verticalOrigin.toNumber()));
  };
    
  private native LabelGraphics setVerticalOrigin(Property<Number> verticalOrigin) /*-{ 
    this.verticalOrigin = verticalOrigin
    return this
  }-*/;
    
  public LabelGraphics setScale(double scale) { 
    return setScale(NumberProperty.create(scale));
  }
  
  public native LabelGraphics setScale(Property<Number> scale) /*-{ 
    this.scale = scale
    return this
  }-*/;
  
  public LabelGraphics setFillColor(Color fillColor) {
    return setFillColor(ConstantProperty.create(fillColor));
  }
  
  public native LabelGraphics setFillColor(Property<Color> fillColor) /*-{
    this.fillColor = fillColor
    return this
  }-*/;
  
  public LabelGraphics setStyle(LabelStyle style) { 
    return setStyle(NumberProperty.create(style.toNumber()));
  };
    
  private native LabelGraphics setStyle(Property<Number> style) /*-{ 
    this.style = style
    return this
  }-*/;
  
  public LabelGraphics setOutlineColor(Color outlineColor) {
    return setOutlineColor(ConstantProperty.create(outlineColor));
  }
  
  public native LabelGraphics setOutlineColor(Property<Color> outlineColor) /*-{
    this.outlineColor = outlineColor
    return this
  }-*/;
    
  public LabelGraphics setFont(String font) { 
    return setFont(StringProperty.create(font));
  };
    
  private native LabelGraphics setFont(Property<String> font) /*-{ 
    this.font = font
    return this
  }-*/;
    
  public LabelGraphics setText(String text) { 
    return setText(StringProperty.create(text));
  };
    
  private native LabelGraphics setText(Property<String> text) /*-{ 
    this.text = text
    return this
  }-*/;
}

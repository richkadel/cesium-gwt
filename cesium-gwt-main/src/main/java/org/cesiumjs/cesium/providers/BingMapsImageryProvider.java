package org.cesiumjs.cesium.providers;

import org.cesiumjs.cesium.ImageryProvider;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 * Name  Type  Argument  Default  Description
 *
 * options.pixelFormat,  PixelFormat,   <optional>, PixelFormat.RGBA,  The pixel format of the texture.
 * options.borderWidthInPixels,   Number,   <optional>, 1,  The amount of spacing between adjacent images in pixels.
 * options.initialSize,  Cartesian2,   <optional>, new Cartesian2(16.0, 16.0),  The initial side lengths of the texture.
 * options.images,   Array,   <optional>, undefined,  Array of Image to be added to the atlas. Same as calling addImages(images).
 * options.image,   Image,   <optional>, undefined,  Single image to be added to the atlas. Same as calling addImage(image).
 */
public final class BingMapsImageryProvider extends ImageryProvider {

  protected BingMapsImageryProvider(){}

  public final static BingMapsImageryProvider create() {
    return create(Options.create());
  }
  
  public final native static BingMapsImageryProvider create(Options options) /*-{
    return new Cesium.BingMapsImageryProvider(options);
  }-*/;
  
  public static final class Options extends JavaScriptObject {
  
    protected Options(){}
    
    public static Options create() {
      return create("http://dev.virtualearth.net");
    }
    
    public static native Options create(String url) /*-{
      return {url : url}
    }-*/;
    
    /**
     * @param key a Bing Maps API key (can be created at https://www.bingmapsportal.com/)
     * @return this for chaining options settings
     */
    public native Options key(String key) /*-{ 
      this.key = key
      return this
    }-*/;
    
    public native Options mapStyle(String bingMapsStyle) /*-{ 
      this.mapStyle = bingMapsStyle
      return this
    }-*/;
  }
}
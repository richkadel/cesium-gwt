package org.cesiumjs.cesium.providers;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 * Name	Type	Argument	Default	Description
 *
 * options.pixelFormat,	PixelFormat,	 <optional>, PixelFormat.RGBA,	The pixel format of the texture.
 * options.borderWidthInPixels,	 Number,	 <optional>, 1,	The amount of spacing between adjacent images in pixels.
 * options.initialSize,	Cartesian2,	 <optional>, new Cartesian2(16.0, 16.0),	The initial side lengths of the texture.
 * options.images,	 Array,	 <optional>, undefined,	Array of Image to be added to the atlas. Same as calling addImages(images).
 * options.image,	 Image,	 <optional>, undefined,	Single image to be added to the atlas. Same as calling addImage(image).
 */
public final class BingMapsImageryProviderOptions extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected BingMapsImageryProviderOptions(){}
  
  public static BingMapsImageryProviderOptions create() {
    return create("http://dev.virtualearth.net");
  }
  
  public static native BingMapsImageryProviderOptions create(String url) /*-{
    return {url : url}
  }-*/;
  
  /**
   * @param key a Bing Maps API key (can be created at https://www.bingmapsportal.com/)
   * @return this for chaining options settings
   */
  public native BingMapsImageryProviderOptions setKey(String key) /*-{ 
  	this.key = key
  	return this
  }-*/;
  
  public native BingMapsImageryProviderOptions setMapStyleAerial() /*-{ 
  	this.mapStyle = Cesium.BingMapsStyle.AERIAL
  	return this
  }-*/;
  
  public native BingMapsImageryProviderOptions setMapStyleAerialWithLabels() /*-{ 
  	this.mapStyle = Cesium.BingMapsStyle.AERIAL_WITH_LABELS
  	return this
  }-*/;
  
  public native BingMapsImageryProviderOptions setMapStyleCollinsBart() /*-{ 
  	this.mapStyle = Cesium.BingMapsStyle.COLLINS_BART
  	return this
  }-*/;
  
  public native BingMapsImageryProviderOptions setMapStyleOrdnanceSurvey() /*-{ 
  	this.mapStyle = Cesium.BingMapsStyle.ORDNANCE_SURVEY
  	return this
  }-*/;
  
  public native BingMapsImageryProviderOptions setMapStyleRoad() /*-{ 
  	this.mapStyle = Cesium.BingMapsStyle.ROAD
  	return this
  }-*/;
}
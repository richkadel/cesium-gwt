package org.cesiumjs.cesium;

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
public final class TextureAtlasOptions extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected TextureAtlasOptions(){}
  
  public static native TextureAtlasOptions create() /*-{
    return {}
  }-*/;
  
  public native TextureAtlasOptions setBorderWidthInPixels(int borderWidthInPixels) /*-{ 
  	this.borderWidthInPixels = borderWidthInPixels
  	return this
  }-*/;
}
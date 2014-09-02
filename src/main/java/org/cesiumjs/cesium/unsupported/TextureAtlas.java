package org.cesiumjs.cesium.unsupported;

import org.cesiumjs.cesium.BoundingRectangle;
import org.cesiumjs.cesium.Texture;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Image;

/**
 * @author richkadel
 *
 */
public final class TextureAtlas extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected TextureAtlas(){}
  
  public native void setTextureAtlas(TextureAtlas textureAtlas) /*-{ this.textureAtlas = textureAtlas; }-*/;

	public void addSubRegions(Image image, int[][] sprites) {
	    JsArray<BoundingRectangle> rects = JsArray.createArray().cast();
	    rects.setLength(sprites.length);
	    for (int i = 0; i < sprites.length; i++) {
	      int[] sprite = sprites[i];
	      rects.set(i, BoundingRectangle.create(sprite[0], sprite[1], sprite[2], sprite[3]));
	    }
	    addSubRegions(image.getElement(), rects);
	}

	public native void addSubRegions(Element image, JsArray<BoundingRectangle> sprites) /*-{
    this.addSubRegions(image, sprites);
	}-*/;

	public native Texture getTexture() /*-{
    return this.texture
	}-*/;

	public native JsArray<BoundingRectangle> getTextureCoordinates() /*-{
		return this.textureCoordinates
	}-*/;

	public int addImage(Image image) {
    return addImage(image.getElement());
	}
  
	private native int addImage(Element imageElement) /*-{ 
    return this.addImage(imageElement)
	}-*/;
}
package com.harmonia.cesiumjs.gwt;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.AbsolutePanel;

/**
 * @author richkadel
 *
 */
public final class Scene extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected Scene(){}
  
  public native TextureAtlas createTextureAtlas(TextureAtlasOptions options) /*-{ return this.createTextureAtlas(options); }-*/;

	public native CompositePrimitive getPrimitives() /*-{
		return this.primitives
	}-*/;

	public native AnimationsCollection getAnimations() /*-{
    return this.animations;
	}-*/;

  public final native Globe getGlobe() /*-{
    return this.globe;
  }-*/;
  
	public native Camera getCamera() /*-{
    return this.camera;
	}-*/;
  
  public final native void overrideScreenSpaceCameraController(ScreenSpaceCameraController newController) /*-{
    this._screenSpaceCameraController = newController;
  }-*/;
}
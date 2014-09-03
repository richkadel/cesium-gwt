package org.cesiumjs.cesium;

import org.cesiumjs.cesium.events.Event;
import org.cesiumjs.js.JsCallback;
import org.cesiumjs.js.JsFunctionCallback;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public final class Scene extends JavaScriptObject {

  protected Scene(){}

	public static final native Scene create(Options options) /*-{
		return new Cesium.Scene(options);
	}-*/;

	public native PrimitiveCollection getPrimitives() /*-{
		return this.primitives
	}-*/;

	public final native Globe getGlobe() /*-{
		return this.globe;
	}-*/;
	
	public final native void setGlobe(Globe globe) /*-{
		this.globe = globe;
	}-*/;

	public native Camera getCamera() /*-{
		return this.camera;
	}-*/;

	public native CanvasElement getCanvas() /*-{
		return this.canvas;
	}-*/;

	public native ImageryLayerCollection getImageryLayers() /*-{
		return this.imageryLayers;
	}-*/;

	public native void morphTo2D() /*-{
		return this.morphTo2D();
	}-*/;

	public native void morphTo3D() /*-{
		return this.morphTo3D();
	}-*/;

	public native void morphToColumbusView() /*-{
		return this.morphToColumbusView();
	}-*/;
	
	public native void setMode(SceneMode mode) /*-{
		this.mode = mode;
	}-*/;

	public SceneMode getMode() {
		return SceneMode.valueOf(nativeGetMode());
	}

	public native int nativeGetMode() /*-{
		return this.mode;
	}-*/;

	public native double getMaximumAliasedLineWidth() /*-{
		return this.maximumAliasedLineWidth;
	}-*/;

	public native PickedObject pick(Cartesian2 windowPosition) /*-{
		var tempResult = this.pick(windowPosition);
		return (tempResult === void 0) ? null : tempResult;
	}-*/;

	public native JsArray<PickedObject> drillPick(Cartesian2 windowPosition) /*-{
		return this.drillPick(windowPosition)
	}-*/;
	
	public native SkyBox getSkyBox() /*-{
		return this.skyBox;
	}-*/;

	public native void setSkyBox(SkyBox skyBox) /*-{
		this.skyBox = skyBox;
	}-*/;
	
	public native ScreenSpaceCameraController getScreenSpaceCameraController() /*-{
		return this.screenSpaceCameraController;
	}-*/;

  public native Event onMorphStart() /*-{
    return this.morphStart
  }-*/;
  
  public native Event onMorphComplete() /*-{
    return this.morphComplete
  }-*/;

 

	public static final class Options extends JavaScriptObject
	{
		// Overlay types always have protected, zero argument constructors.
		protected Options() {}

		public static native Options create() /*-{
			return {}
		}-*/;

		public final native Options canvas(CanvasElement canvas)/*-{
			this.canvas = canvas;
			return this;
		}-*/;

		public final native Options contextOptions(Undocumented contextOptions) /*-{
			this.contextOptions = contextOptions;
			return this;
		}-*/;

		public final native Options creditContainer(Element creditContainer) /*-{
			this.creditContainer = creditContainer;
			return this;
		}-*/;

		public final native Options scene3DOnly(boolean scene3DOnly) /*-{
			this.scene3DOnly = scene3DOnly;
			return this;
		}-*/;

		public final native Options mapProjection(Undocumented mapProjection) /*-{
			this.mapProjection = mapProjection;
			return this;
		}-*/;

	}

	// setMode() is functional but does not set the frustrum, etc. so use
	// morphTo2D() or similar
	// public void setMode(SceneMode sceneMode) {
	// nativeSetMode(sceneMode.toString());
	// }
	//
	// private native void nativeSetMode(String sceneModeString) /*-{
	// this.mode = Cesium.SceneMode[sceneModeString]
	// }-*/;
}

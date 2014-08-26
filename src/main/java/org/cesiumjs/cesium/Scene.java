package org.cesiumjs.cesium;

import org.cesiumjs.cesium.events.Event;
import org.cesiumjs.js.JsCallback;
import org.cesiumjs.js.JsFunctionCallback;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public final class Scene extends JavaScriptObject {

  protected Scene(){}
  
	public native PrimitiveCollection getPrimitives() /*-{
		return this.primitives
	}-*/;

  public final native Globe getGlobe() /*-{
    return this.globe;
  }-*/;
  
	public native Camera getCamera() /*-{
    return this.camera;
	}-*/;
  
	public native Element getCanvas() /*-{
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
    return this.pick(windowPosition)
  }-*/;
  
  public native JsArray<PickedObject> drillPick(Cartesian2 windowPosition) /*-{
    return this.drillPick(windowPosition)
  }-*/;
  
  public native Event onMorphStart() /*-{
    return this.morphStart
  }-*/;
  
  public native Event onMorphComplete() /*-{
    return this.morphComplete
  }-*/;
}
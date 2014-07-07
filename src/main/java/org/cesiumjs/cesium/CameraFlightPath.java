package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

public class CameraFlightPath extends JavaScriptObject {
  
	protected CameraFlightPath() {}

	public static native Animation createAnimationCartographic(Scene scene,
			CameraFlightCartographicOptions options) /*-{
    return Cesium.CameraFlightPath.createAnimationCartographic(scene, options);
	}-*/;

}

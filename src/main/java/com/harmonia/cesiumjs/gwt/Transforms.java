package com.harmonia.cesiumjs.gwt;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.AbsolutePanel;

/**
 * @author richkadel
 *
 */
public final class Transforms extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected Transforms(){}
  
	public static native Matrix4 eastNorthUpToFixedFrame(Cartesian3 center) /*-{
		return Cesium.Transforms.eastNorthUpToFixedFrame(center) 
	}-*/;
}
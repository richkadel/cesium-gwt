package org.cesiumjs.cesium.providers;

import com.google.gwt.core.client.JavaScriptObject;

public final class CesiumTerrainProvider extends JavaScriptObject
{
	protected CesiumTerrainProvider() {}
	
	public static final String CESIUM_SMALL_TERRAIN_URL = "//cesiumjs.org/smallterrain";
	public static final String CESIUM_STK_TERRAIN_URL = "//cesiumjs.org/stk-terrain/tilesets/world/tiles";
	
	public static native CesiumTerrainProvider create(String url) /*-{
		return new Cesium.CesiumTerrainProvider({url : url});
	}-*/;
 
	
}

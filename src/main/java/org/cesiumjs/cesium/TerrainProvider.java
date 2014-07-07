package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public final class TerrainProvider extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected TerrainProvider(){}

  public final static TerrainProvider createCesiumTerrainProvider() {
//		return createCesiumTerrainProvider("http://cesiumjs.org/smallterrain");
		return createCesiumTerrainProvider("//cesiumjs.org/stk-terrain/tilesets/world/tiles");
  }
  
  public final native static TerrainProvider createCesiumTerrainProvider(String url) /*-{
    return new Cesium.CesiumTerrainProvider({
        url : url
        // not currently supporting optional arguments "proxy" or "credit"
      });
  }-*/;
}
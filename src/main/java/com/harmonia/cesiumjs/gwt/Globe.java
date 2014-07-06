package com.harmonia.cesiumjs.gwt;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public final class Globe extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected Globe(){}
  
  public native Ellipsoid getEllipsoid() /*-{ return this.ellipsoid; }-*/;

	public native void setTerrainProvider(TerrainProvider terrainProvider) /*-{
  	this.terrainProvider = terrainProvider;
	}-*/;
}
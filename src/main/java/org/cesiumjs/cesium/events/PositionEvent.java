package org.cesiumjs.cesium.events;

import org.cesiumjs.cesium.Cartesian2;

import com.google.gwt.core.client.JavaScriptObject;

public class PositionEvent extends JavaScriptObject
{
	protected PositionEvent() {}
	
	public native final Cartesian2 getPosition() /*-{
		return this.position;
	}-*/;

}

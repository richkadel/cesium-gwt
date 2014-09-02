package org.cesiumjs.cesium.events;

import org.cesiumjs.cesium.Cartesian2;

import com.google.gwt.core.client.JavaScriptObject;

public class PinchStartEvent extends JavaScriptObject
{
	protected PinchStartEvent() {}
	
	public native final Cartesian2 getPosition1() /*-{
		return this.position1;
	}-*/;
	
	public native final Cartesian2 getPosition2() /*-{
		return this.position2;
	}-*/;
}

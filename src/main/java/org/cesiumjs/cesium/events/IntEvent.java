package org.cesiumjs.cesium.events;

import com.google.gwt.core.client.JavaScriptObject;

public class IntEvent extends JavaScriptObject
{
	protected IntEvent() {}
	
	public native final int getValue() /*-{
		return this;
	}-*/;

}

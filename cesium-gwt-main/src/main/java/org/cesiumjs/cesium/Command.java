package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

public class Command extends JavaScriptObject {

	public Command(){}
	
	public final native static Command create()/*-{
      return new Cesium.Command(container, options)
    }-*/;
	
//	public native Event afterExecute()/*-{
//    return this.container
//  }-*/;
	
}

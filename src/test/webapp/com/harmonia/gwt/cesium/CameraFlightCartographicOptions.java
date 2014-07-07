package com.harmonia.gwt.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.harmonia.gwt.js.JsFunction;
import com.harmonia.gwt.js.JsFunctionCallback;

/**
 * @author richkadel
 *
 */
public final class CameraFlightCartographicOptions extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected CameraFlightCartographicOptions(){}
  
  public static native CameraFlightCartographicOptions create() /*-{
    return {}
  }-*/;
  
  public native CameraFlightCartographicOptions setDestination(Cartographic destination) /*-{ 
  	this.destination = destination
  	return this
  }-*/;
  
  public native CameraFlightCartographicOptions setDirection(Cartesian3 direction) /*-{ 
    if (direction != null) {
    	this.direction = direction
    }
  	return this
  }-*/;

  public native CameraFlightCartographicOptions setUp(Cartesian3 up) /*-{ 
    if (up != null) {
    	this.up = up
    }
  	return this
  }-*/;

  /**
   * @param durationMs default is 3000 milliseconds
   * @return
   */
  public native CameraFlightCartographicOptions setDurationMs(int durationMs) /*-{ 
  	this.direction = directionMs
  	return this
  }-*/;

  private native CameraFlightCartographicOptions onComplete(JsFunction onComplete) /*-{ 
    this.onComplete = onComplete
    return this
  }-*/;

	public CameraFlightCartographicOptions onComplete(
			JsFunctionCallback callback) {
		return onComplete(JsFunction.create(callback, true)); // execute only once
	}
}
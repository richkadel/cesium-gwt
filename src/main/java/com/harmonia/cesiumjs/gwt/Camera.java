package com.harmonia.cesiumjs.gwt;

import com.google.gwt.core.client.JavaScriptObject;

public final class Camera extends JavaScriptObject {

  protected Camera() {}
  
  public static native Camera create(Scene scene) /*-{ 
  	return new Cesium.Camera(scene);
  }-*/;
  
  public native CameraState getState() /*-{
    state = {
    	position:this.position.clone(),
    	direction:this.direction.clone(),
    	up:this.up.clone()
    }
    if (typeof this.defaultLookDirection !== 'undefined') {
    	state.defaultLookDirection = this.defaultLookDirection
    }
    return state
  }-*/;
  
  public native void setState(CameraState state) /*-{
  	this.position = new Cesium.Cartesian3(state.position.x, state.position.y, state.position.z)
  	this.direction = new Cesium.Cartesian3(state.direction.x, state.direction.y, state.direction.z)
  	this.up = new Cesium.Cartesian3(state.up.x, state.up.y, state.up.z)
  	this.defaultLookDirection = state.defaultLookDirection
  }-*/;
  
  public native Cartesian3 getPosition() /*-{ return this.position; }-*/;
  public native void setPosition(Cartesian3 position) /*-{ this.position = position; }-*/;
  
  public native Cartesian3 getDirection() /*-{
    if (this.defaultLookDirection) {
    	return null
    }
	  return this.direction
  }-*/;
  
  public native void setDirection(Cartesian3 direction) /*-{ this.direction = direction; }-*/;

  public native Cartesian3 getUp() /*-{
    if (this.defaultLookDirection) {
    	return null
    }
    return this.up
  }-*/;
  
  public native void setUp(Cartesian3 up) /*-{ this.up = up; }-*/;

	public native Camera cloneCamera() /*-{
		return this.clone();
	}-*/;

	public native void setTransform(Matrix4 transform) /*-{
		 this.controller.setTransform(transform)
	}-*/;

	/**
	 * @param defaultLookDirection I added this JavaScript property to support
	 * flyTo with default parameters because I couldn't figure out how to set
	 * the camera to the correct look values.
	 */
	public native boolean isDefaultLookDirection() /*-{ return this.defaultLookDirection; }-*/;
	public native void setDefaultLookDirection(boolean defaultLookDirection) /*-{ this.defaultLookDirection = defaultLookDirection; }-*/;
}

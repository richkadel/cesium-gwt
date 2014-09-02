package org.cesiumjs.cesium;

import org.cesiumjs.js.JsFunction;
import org.cesiumjs.js.JsFunctionCallback;

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
  public native Cartographic getPositionCartographic() /*-{ return this.positionCartographic; }-*/;
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

  public  Cartesian3 pickEllipsoid(Cartesian2 windowPosition) {
	  return this.pickEllipsoidNative(windowPosition, null, null);
  }
  
  public Cartesian3 pickEllipsoid(Cartesian2 windowPosition, Ellipsoid ellipsoid) {
	  return this.pickEllipsoidNative(windowPosition, ellipsoid, null);
  }
  
  public Cartesian3 pickEllipsoid(Cartesian2 windowPosition, Ellipsoid ellipsoid, Cartesian3 result) {
	  return this.pickEllipsoidNative(windowPosition, ellipsoid, result);
  }
  
  private native Cartesian3 pickEllipsoidNative(Cartesian2 windowPosition, Ellipsoid ellipsoid, Cartesian3 result) /*-{
	ellipsoid = ellipsoid || void 0;
	result = result || void 0;
	
	var tempResult = this.pickEllipsoid(windowPosition, ellipsoid, result);
	return (tempResult === void 0) ? null : tempResult;
  }-*/;

  
	public native void flyTo(FlyToOptions flyToOptions) /*-{
		 this.flyTo(flyToOptions)
	}-*/;

	/**
	 * @param defaultLookDirection I added this JavaScript property to support
	 * flyTo with default parameters because I couldn't figure out how to set
	 * the camera to the correct look values.
	 */
	public native boolean isDefaultLookDirection() /*-{ return this.defaultLookDirection; }-*/;
	public native void setDefaultLookDirection(boolean defaultLookDirection) /*-{ this.defaultLookDirection = defaultLookDirection; }-*/;
  
  public static final class FlyToOptions extends JavaScriptObject {
    // Overlay types always have protected, zero argument constructors.
    protected FlyToOptions(){}
    
    public static native FlyToOptions create() /*-{
      return {}
    }-*/;
    
    public native FlyToOptions setDestination(Cartesian3 destination) /*-{ 
    	this.destination = destination
    	return this
    }-*/;
    
    public native FlyToOptions setDirection(Cartesian3 direction) /*-{ 
      if (direction != null) {
      	this.direction = direction
      }
    	return this
    }-*/;
  
    public native FlyToOptions setUp(Cartesian3 up) /*-{ 
      if (up != null) {
      	this.up = up
      }
    	return this
    }-*/;
  
    public native FlyToOptions setEndTransform(Matrix4 endTransform) /*-{ 
    	this.endTransform = endTransform
    	return this
    }-*/;
    
    public native FlyToOptions setConvert(boolean convert) /*-{ 
    	this.convert = convert
    	return this
    }-*/;
    
    /**
     * @param durationSeconds default is 3.0 seconds
     * @return
     */
    public native FlyToOptions setDurationSeconds(double durationSeconds) /*-{ 
    	this.duration = durationSeconds
    	return this
    }-*/;
  
  	public FlyToOptions complete(
  			JsFunctionCallback callback) {
  		return complete(JsFunction.create(callback, true)); // execute only once
  	}
  
    private native FlyToOptions complete(JsFunction complete) /*-{ 
      this.complete = complete
      return this
    }-*/;
  
  	public FlyToOptions cancel(
  			JsFunctionCallback callback) {
  		return cancel(JsFunction.create(callback, true)); // execute only once
  	}
    
    private native FlyToOptions cancel(JsFunction cancel) /*-{ 
      this.cancel = cancel
      return this
    }-*/;
  }
}
  
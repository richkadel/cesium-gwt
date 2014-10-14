package org.cesiumjs.cesium;

import jsfunction.JsFunction;
import jsfunction.NoArgsFunction;

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

  public native Matrix4 getTransform() /*-{
    return this.transform
  }-*/;

  public native void setTransform(Matrix4 transform) /*-{
//    this.controller.setTransform(transform)
    this.setTransform(transform)
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

    // pickEllipsoid returns "undefined" if the ellipsoid was not picked, and undefined
    // is not the same as "null" so we have to coerce it:

    return this.pickEllipsoid(windowPosition, ellipsoid, result);
  }-*/;
  
  public void flyTo(Cartesian3 destination) {
    flyTo(destination, FlyToOptions.create());
  }
  
  public native void flyTo(Cartesian3 destination, FlyToOptions flyToOptions) /*-{
    flyToOptions.destination = destination;
    this.flyTo(flyToOptions)
  }-*/;

  public void flyToRectangle(Rectangle destination) {
    flyToRectangle(destination, FlyToRectangleOptions.create());
  }
  
  public native void flyToRectangle(Rectangle destination, FlyToRectangleOptions flyToRectangleOptions) /*-{
    flyToRectangleOptions.destination = destination;
    this.flyToRectangle(flyToRectangleOptions)
  }-*/;

  public native void viewRectangle(Rectangle rectangle) /*-{
    this.viewRectangle(rectangle);
  }-*/;

  /**
   * @param defaultLookDirection I added this JavaScript property to support
   * flyTo with default parameters because I couldn't figure out how to set
   * the camera to the correct look values.
   */
  public native boolean isDefaultLookDirection() /*-{ return this.defaultLookDirection; }-*/;
  public native void setDefaultLookDirection(boolean defaultLookDirection) /*-{ this.defaultLookDirection = defaultLookDirection; }-*/;
  
  public native double getDefaultLookAmount() /*-{ return this.defaultLookAmount; }-*/;
  public native void setDefaultLookAmount(double defaultLookAmount) /*-{ this.defaultLookAmount = defaultLookAmount; }-*/;
  
  public native double getDefaultMoveAmount() /*-{ return this.defaultMoveAmount; }-*/;
  public native void setDefaultMoveAmount(double defaultMoveAmount) /*-{ this.defaultMoveAmount = defaultMoveAmount; }-*/;
  
  public native double getDefaultRotateAmount() /*-{ return this.defaultRotateAmount; }-*/;
  public native void setDefaultRotateAmount(double defaultRotateAmount) /*-{ this.defaultRotateAmount = defaultRotateAmount; }-*/;
  
  public native double getDefaultZoomAmount() /*-{ return this.defaultZoomAmount; }-*/;
  public native void setDefaultZoomAmount(double defaultZoomAmount) /*-{ this.defaultZoomAmount = defaultZoomAmount; }-*/;
  
  public native void look(Cartesian3 axis, double angleRadians) /*-{
    this.look(axis, angleRadians ? angleRadians : void 0)
  }-*/;
  
  public native void lookAt(Cartesian3 eye, Cartesian3 target, Cartesian3 up) /*-{
    this.lookAt(eye, target, up)
  }-*/;
  
  public native void lookDown(double amount) /*-{
    this.lookDown(amount ? amount : void 0)
  }-*/;
  
  public native void lookLeft(double amount) /*-{
    this.lookLeft(amount ? amount : void 0)
  }-*/;
  
  public native void lookRight(double amount) /*-{
    this.lookRight(amount ? amount : void 0)
  }-*/;
  
  public native void lookUp(double amount) /*-{
    this.lookUp(amount ? amount : void 0)
  }-*/;
  
  public native void move(Cartesian3 direction, double amount) /*-{
    this.move(direction, amount ? amount : void 0)
  }-*/;
  
  public native void moveBackward(double amount) /*-{
    this.moveBackward(amount ? amount : void 0)
  }-*/;
  
  public native void moveDown(double amount) /*-{
    this.moveDown(amount ? amount : void 0)
  }-*/;
  
  public native void moveForward(double amount) /*-{
    this.moveForward(amount ? amount : void 0)
  }-*/;
  
  public native void moveLeft(double amount) /*-{
    this.moveLeft(amount ? amount : void 0)
  }-*/;
  
  public native void moveRight(double amount) /*-{
    this.moveRight(amount ? amount : void 0)
  }-*/;
  
  public native void moveUp(double amount) /*-{
    this.moveUp(amount ? amount : void 0)
  }-*/;
  
  public native void rotate(Cartesian3 axis, double angle) /*-{
    this.rotate(axis, angle ? angle : void 0)
  }-*/;
  
  public native void rotateDown(double angle) /*-{
    this.rotateDown(angle ? angle : void 0)
  }-*/;
  
  public native void rotateLeft(double angle) /*-{
    this.rotateLeft(angle ? angle : void 0)
  }-*/;
  
  public native void rotateRight(double angle) /*-{
    this.rotateRight(angle ? angle : void 0)
  }-*/;
  
  public native void rotateUp(double angle) /*-{
    this.rotateUp(angle ? angle : void 0)
  }-*/;
  
  public native void twistLeft(double amount) /*-{
    this.twistLeft(amount ? amount : void 0)
  }-*/;
  
  public native void twistRight(double amount) /*-{
    this.twistRight(amount ? amount : void 0)
  }-*/;
  
  public static final class FlyToOptions extends JavaScriptObject {
    // Overlay types always have protected, zero argument constructors.
    protected FlyToOptions(){}
    
    public static native FlyToOptions create() /*-{
      return {}
    }-*/;
    
// NOT OPTIONAL
//    public native FlyToOptions destination(Cartesian3 destination) /*-{ 
//      this.destination = destination
//      return this
//    }-*/;
    
    public native FlyToOptions direction(Cartesian3 direction) /*-{ 
      if (direction != null) {
        this.direction = direction
      }
      return this
    }-*/;
  
    public native FlyToOptions up(Cartesian3 up) /*-{ 
      if (up != null) {
        this.up = up
      }
      return this
    }-*/;
  
    public native FlyToOptions endTransform(Matrix4 endTransform) /*-{ 
      this.endTransform = endTransform
      return this
    }-*/;
    
    public native FlyToOptions convert(boolean convert) /*-{ 
      this.convert = convert
      return this
    }-*/;
    
    /**
     * @param durationSeconds default is 3.0 seconds
     * @return
     */
    public native FlyToOptions durationSeconds(double durationSeconds) /*-{ 
      this.duration = durationSeconds
      return this
    }-*/;
  
    public FlyToOptions complete(
        NoArgsFunction callback) {
      return complete(JsFunction.create(callback)); // execute only once
    }
  
    private native FlyToOptions complete(JsFunction complete) /*-{ 
      this.complete = complete
      return this
    }-*/;
  
    public FlyToOptions cancel(
        NoArgsFunction callback) {
      return cancel(JsFunction.create(callback)); // execute only once
    }
    
    private native FlyToOptions cancel(JsFunction cancel) /*-{ 
      this.cancel = cancel
      return this
    }-*/;
  }
  
  public static final class FlyToRectangleOptions extends JavaScriptObject {
    // Overlay types always have protected, zero argument constructors.
    protected FlyToRectangleOptions(){}
    
    public static native FlyToRectangleOptions create() /*-{
      return {}
    }-*/;
    
    /**
     * @param durationSeconds default is 3.0 seconds
     * @return
     */
    public native FlyToOptions durationSeconds(double durationSeconds) /*-{ 
      this.duration = durationSeconds
      return this
    }-*/;
  
    public FlyToOptions complete(
        NoArgsFunction callback) {
      return complete(JsFunction.create(callback)); // execute only once
    }
  
    private native FlyToOptions complete(JsFunction complete) /*-{ 
      this.complete = complete
      return this
    }-*/;
  
    public FlyToOptions cancel(
        NoArgsFunction callback) {
      return cancel(JsFunction.create(callback)); // execute only once
    }
    
    private native FlyToOptions cancel(JsFunction cancel) /*-{ 
      this.cancel = cancel
      return this
    }-*/;
  }
}
  
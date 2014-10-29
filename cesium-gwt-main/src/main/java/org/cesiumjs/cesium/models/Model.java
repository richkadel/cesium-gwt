package org.cesiumjs.cesium.models;

import org.cesiumjs.cesium.BoundingSphere;
import org.cesiumjs.cesium.Matrix4;
import org.cesiumjs.cesium.Primitive;
import org.cesiumjs.cesium.events.Event;

import com.google.gwt.core.client.JavaScriptObject;

public final class Model extends Primitive {
  
  protected Model() {}
  
  public static native Model fromGltf(String url, Model.Options options) /*-{
    options.url = url
    return new Cesium.Model.fromGltf(options)
  }-*/;
    
  public native void setActiveAnimations(ModelAnimationCollection activeAnimations) /*-{
    this.activeAnimations = activeAnimations
  }-*/;
    
  public native ModelAnimationCollection getActiveAnimations() /*-{
    return this.activeAnimations
  }-*/;
    
  public native boolean isAllowPicking() /*-{
    return this.allowPicking
  }-*/;
    
  public native boolean isAsynchronous() /*-{
    return this.asynchronous
  }-*/;
    
  public native String getBasePath() /*-{
    return this.basePath
  }-*/;
    
  public native BoundingSphere getBoundingSphere() /*-{
    return this.boundingSphere
  }-*/;
    
  public native void setDebugShowBoundingVolume(boolean debugShowBoundingVolume) /*-{
    this.debugShowBoundingVolume = debugShowBoundingVolume
  }-*/;

  public native boolean isDebugShowBoundingVolume() /*-{
    return this.debugShowBoundingVolume
  }-*/;

  public native void setDebugWireframe(boolean debugWireframe) /*-{
    this.debugWireframe = debugWireframe
  }-*/;
  
  public native boolean isDebugWireframe() /*-{
    return this.debugWireframe
  }-*/;
  
  public native JavaScriptObject getGltf() /*-{
    return this.gltf // the object from the JSON version of the given glTF
  }-*/;
  
  public native <T> T getId() /*-{ return this.id; }-*/;
  
  public native <T> void setId(T id) /*-{
    this.id = id
  }-*/;
  
  public native void setShow(boolean show) /*-{
    this.show = show
  }-*/;

  public native boolean isShow() /*-{
    return this.show
  }-*/;

  public native void setModelMatrix(Matrix4 modelMatrix) /*-{
    this.modelMatrix = modelMatrix
  }-*/;

  public native Matrix4 getModelMatrix() /*-{
    return this.modelMatrix
  }-*/;

  public native void setScale(double scale) /*-{
    this.scale = scale
  }-*/;

  public native double getScale() /*-{
    return this.scale
  }-*/;

  public native void setMinimumPixelSize(double minimumPixelSize) /*-{
    this.minimumPixelSize = minimumPixelSize
  }-*/;

  public native double getMinimumPixelSize() /*-{
    return this.minimumPixelSize
  }-*/;

  public native boolean isReady() /*-{
    return this.ready
  }-*/;

  public native Event onReadyToRender() /*-{
    return this.readyToRender
  }-*/;

  public native ModelMaterial getMaterial(String name) /*-{
    return this.getMaterial(name)
  }-*/;

  public native ModelMesh getMesh(String name) /*-{
    return this.getMesh(name)
  }-*/;

  public native ModelNode getNode(String name) /*-{
    return this.getNode(name)
  }-*/;
  
  public native void destroy() /*-{
    this.destroy()
  }-*/;
  
  public native boolean isDestroyed() /*-{
    return this.isDestroyed()
  }-*/;

  public static final class Options extends JavaScriptObject {

    protected Options(){}
    
    public static native Options create() /*-{
      return {}
    }-*/;
    
    public native Options show(boolean show) /*-{
      this.show = show
      return this;
    }-*/;

    public native Options modelMatrix(Matrix4 modelMatrix) /*-{
      this.modelMatrix = modelMatrix
      return this;
    }-*/;

    public native Options scale(double scale) /*-{
      this.scale = scale
      return this;
    }-*/;

    public native Options minimumPixelSize(double minimumPixelSize) /*-{
      this.minimumPixelSize = minimumPixelSize
      return this;
    }-*/;

    public native Options allowPicking(boolean allowPicking) /*-{
      this.allowPicking = allowPicking
      return this;
    }-*/;

    public native Options asynchronous(boolean asynchronous) /*-{
      this.asynchronous = asynchronous
      return this;
    }-*/;

    public native Options debugShowBoundingVolume(boolean debugShowBoundingVolume) /*-{
      this.debugShowBoundingVolume = debugShowBoundingVolume
      return this;
    }-*/;

    public native Options debugWireframe(boolean debugWireframe) /*-{
      this.debugWireframe = debugWireframe
      return this;
    }-*/;
  }
}
  
package org.cesiumjs.cesium.models;

import org.cesiumjs.cesium.events.Event;

import com.google.gwt.core.client.JavaScriptObject;

public final class ModelAnimationCollection extends JavaScriptObject {
  
  protected ModelAnimationCollection() {}
  
  public static native ModelAnimationCollection create() /*-{
    return new Cesium.ModelAnimationCollection()
  }-*/;
    
  public native Event onAnimationAdded() /*-{
    return this.animationAdded
  }-*/;

  public native Event onAnimationRemoved() /*-{
    return this.animationRemoved
  }-*/;

  public native int length() /*-{
    return this.length
  }-*/;
    
  public native void add(String name, ModelAnimation.Options options) /*-{
    options.name = name
    this.add(options)
  }-*/;

  public native void addAll(ModelAnimation.Options options) /*-{
    this.addAll(options)
  }-*/;

  public native boolean contains(ModelAnimation animation) /*-{
    return this.contains(animation)
  }-*/;

  public native ModelAnimation get(int index) /*-{
    return this.get(index)
  }-*/;

  public native boolean remove(ModelAnimation animation) /*-{
    return this.remove(animation)
  }-*/;

  public native void removeAll() /*-{
    this.removeAll()
  }-*/;
}
  
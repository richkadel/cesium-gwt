package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public final class ImageryLayerCollection extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected ImageryLayerCollection(){}

  public final static native ImageryLayerCollection create() /*-{
    return new Cesium.ImageryLayerCollection()
  }-*/;

  public final native void add(ImageryLayer imageryLayer) /*-{
    this.add(imageryLayer);
  }-*/;

  public final native void add(ImageryLayer imageryLayer, int index) /*-{
    this.add(imageryLayer, index);
  }-*/;

  public final native void addImageryProvider(ImageryProvider imageryProvider) /*-{
    this.addImageryProvider(imageryProvider);
  }-*/;

  public final native void addImageryProvider(ImageryProvider imageryProvider, int index) /*-{
    this.addImageryProvider(imageryProvider, index);
  }-*/;

  public final native double length() /*-{
    return this.length
  }-*/;

  public final native ImageryLayer get(int index) /*-{
    return this.get(index)
  }-*/;

  public final native boolean contains(ImageryLayer layer) /*-{
    return this.contains(layer);
  }-*/;

  public final native int indexOf(ImageryLayer layer) /*-{
    return this.indexOf(layer);
  }-*/;

  public final native void raise(ImageryLayer layer) /*-{
    this.raise(layer)
  }-*/;

  public final native void raiseToTop(ImageryLayer layer) /*-{
    this.raiseToTop(layer)
  }-*/;

  public final native void lower(ImageryLayer layer) /*-{
    this.lower(layer)
  }-*/;

  public final native void lowerToBottom(ImageryLayer layer) /*-{
    this.lowerToBottom(layer)
  }-*/;

  public final native void remove(ImageryLayer layer, boolean destroy) /*-{
    this.remove(layer, destroy)
  }-*/;
  
  public final native void removeAll(boolean destroy) /*-{
    this.removeAll(destroy);
  }-*/;
}
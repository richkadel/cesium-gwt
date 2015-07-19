package org.cesiumjs.cesium.providers;

import org.cesiumjs.cesium.ImageryProvider;
import org.cesiumjs.cesium.Rectangle;

import com.google.gwt.core.client.JavaScriptObject;

public final class OpenStreetMapImageryProvider extends ImageryProvider
{
  protected OpenStreetMapImageryProvider() {}
  
  public static native OpenStreetMapImageryProvider create(Options osmso) /*-{
    return new Cesium.OpenStreetMapServiceImageryProvider(osmso);
  }-*/;
  
  public native double getMaximumLevel() /*-{
    return this.maximumLevel;
  }-*/;

  public native double getMinimumLevel() /*-{
    return this.minimumLevel;
  }-*/;

  public native double getTileWidth() /*-{
    return this.tileWidth;
  }-*/;

  public native double getTileHeight() /*-{
    return this.tileHeight;
  }-*/;
  
  public native String getUrl() /*-{
    return this.url;
  }-*/;
  
  public final static class Options extends JavaScriptObject
  {
    protected Options() {}
    
    public static native Options create() /*-{
      return {}
    }-*/;
    
    public native Options url(String url) /*-{
      this.url = url;
      return this;
    }-*/;    

    public native Options fileExtension(String fileExtension) /*-{
      this.fileExtension = fileExtension;
      return this;
    }-*/;
    
    public native Options layers(String layers) /*-{
      this.layers = layers;
      return this;
    }-*/;
    
    public native Options rectangle(Rectangle rectangle) /*-{
      this.rectangle = rectangle;
      return this;
    }-*/;    
    
    public native Options maximumLevel(double maximumLevel) /*-{
      this.maximumLevel = maximumLevel;
      return this;
    }-*/;

  }
}

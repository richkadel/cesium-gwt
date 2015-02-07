package org.cesiumjs.cesium.providers;

import org.cesiumjs.cesium.ImageryProvider;
import org.cesiumjs.cesium.Rectangle;

import com.google.gwt.core.client.JavaScriptObject;

public final class TileMapServiceImageryProvider extends ImageryProvider
{
  protected TileMapServiceImageryProvider() {}
  
  public static final String CESIUM_NATURAL_EARTH_URL = "//cesiumjs.org/tilesets/imagery/naturalearthii";
  public static final String CESIUM_BLACK_MARBLE_URL = "//cesiumjs.org/tilesets/imagery/blackmarble";
  
  public static native TileMapServiceImageryProvider create(Options tmso) /*-{
    return new Cesium.TileMapServiceImageryProvider(tmso);
  }-*/;
  
//  public native Rectangle getRectangle() /*-{
//    return this.rectangle;
//  }-*/;
  
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
    
    public native Options rectangle(Rectangle rectangle) /*-{
      this.rectangle = rectangle;
      return this;
    }-*/;
    
    public native Options minimumLevel(double minimumLevel) /*-{
      this.minimumLevel = minimumLevel;
      return this;
    }-*/;
    
    public native Options maximumLevel(double maximumLevel) /*-{
      this.maximumLevel = maximumLevel;
      return this;
    }-*/;
    
    public native Options tileWidth(double tileWidth) /*-{
      this.tileWidth = tileWidth;
      return this;
    }-*/;
    
    public native Options tileHeight(double tileHeight) /*-{
      this.tileHeight = tileHeight;
      return this;
    }-*/;
  }
}

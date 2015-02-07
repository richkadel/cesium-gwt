package org.cesiumjs.cesium.providers;

import org.cesiumjs.cesium.ImageryProvider;
import org.cesiumjs.cesium.Rectangle;

import com.google.gwt.core.client.JavaScriptObject;

public final class SingleTileImageryProvider extends ImageryProvider
{
  protected SingleTileImageryProvider() {}
  
  public static native SingleTileImageryProvider create(String url, Rectangle bounds) /*-{
    return new Cesium.SingleTileImageryProvider({
      url : url,
      rectangle : bounds || Cesium.Rectangle.MAX_BOUNDS
    });
  }-*/;
  
//  public native Rectangle getRectangle() /*-{
//    return this.rectangle;
//  }-*/;
}

package org.cesiumjs.cesium.data;

import org.cesiumjs.cesium.Undocumented;
import org.cesiumjs.cesium.events.Promise;

public class GeoJsonDataSource extends DataSource {
  
  protected GeoJsonDataSource() {}
  
  public static final native GeoJsonDataSource create() /*-{
    return new Cesium.GeoJsonDataSource();
  }-*/;

  public static final native GeoJsonDataSource fromUrl(String url) /*-{
    return Cesium.GeoJsonDataSource.fromUrl(url);
  }-*/;
  
  /**
   * @param geoJson A free-form JavaScript object which can be constructed from a parsed JSON string, for instance
   * @param sourceURI
   */
  public final native void load(Undocumented geoJson, String sourceURI) /*-{
    this.load(geoJson, sourceURI);
  }-*/;

  public final native Promise loadUrl(String url) /*-{
    return this.loadUrl(url);
  }-*/;
}

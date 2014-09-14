package org.cesiumjs.cesium.data;

import org.cesiumjs.cesium.JulianDate;
import org.cesiumjs.cesium.Scene;

import com.google.gwt.core.client.JavaScriptObject;

public class DataSourceDisplay extends JavaScriptObject
{
  protected DataSourceDisplay() {}
  
  public static final native DataSourceDisplay create(Scene scene, DataSourceCollection collection) /*-{
    return new Cesium.DataSourceDisplay({scene : scene, dataSourceCollection : collection});
  }-*/;
  
  public final native Scene getScene() /*-{
    return this.getScene();
  }-*/;

  public final native DataSourceCollection getDataSources() /*-{
    return this.getDataSources();
  }-*/;

  public final native boolean update(JulianDate time) /*-{
    return this.update(time);
  }-*/;
}

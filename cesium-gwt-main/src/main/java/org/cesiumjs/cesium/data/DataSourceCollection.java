package org.cesiumjs.cesium.data;

import com.google.gwt.core.client.JavaScriptObject;

public class DataSourceCollection extends JavaScriptObject
{
  protected DataSourceCollection() {}
  
  public static final native DataSourceCollection create() /*-{
    return new Cesium.DataSourceCollection();
  }-*/;
 
  public final native void add(DataSource dataSource) /*-{
    this.add(dataSource);
  }-*/;

  public final native boolean contains(DataSource dataSource) /*-{
    return this.contains(dataSource);
  }-*/;
  
  public final native DataSource get(int index) /*-{
    return this.get(index);
  }-*/;


  public final native int indexOf(DataSource dataSource) /*-{
    return this.indexOf(dataSource);
  }-*/;

  public final native boolean remove(DataSource dataSource, boolean destroy) /*-{
    return this.remove(dataSource, destroy);
  }-*/;
  
  public final native void removeAll(boolean destroy) /*-{
    this.removeAll(destroy);
  }-*/;
}

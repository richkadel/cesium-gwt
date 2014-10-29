package org.cesiumjs.cesium.data;

import org.cesiumjs.cesium.events.Event;
import org.cesiumjs.cesium.time.JulianDate;

import com.google.gwt.core.client.JavaScriptObject;

public class DataSource extends JavaScriptObject
{
  protected DataSource() {}
  
  public final native boolean isLoading() /*-{
    return this.isLoading
  }-*/;
  
  public final native String getName() /*-{
    return this.name
  }-*/;
  
  public final native Event onChangedEvent() /*-{
    return this.changedEvent
  }-*/;
  
  public final native Event onErrorEvent() /*-{
    return this.errorEvent
  }-*/;
  
  public final native Event onLoadingEvent() /*-{
    return this.loadingEvent
  }-*/;

  public final native EntityCollection getEntities() /*-{
    return this.entities
  }-*/;

  public final native void update(JulianDate time) /*-{
    return this.update(time)
  }-*/;
}

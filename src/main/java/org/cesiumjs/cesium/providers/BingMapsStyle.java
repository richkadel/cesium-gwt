package org.cesiumjs.cesium.providers;

import com.google.gwt.core.client.JavaScriptObject;

public final class BingMapsStyle extends JavaScriptObject {

  public final static BingMapsStyle AERIAL = init("AERIAL");
  public final static BingMapsStyle AERIAL_WITH_LABELS = init("AERIAL_WITH_LABELS");
  public final static BingMapsStyle COLLINS_BART = init("COLLINS_BART");
  public final static BingMapsStyle ORDNANCE_SURVEY = init("ORDNANCE_SURVEY");
  public final static BingMapsStyle ROAD = init("ROAD");

  private final native static BingMapsStyle init(String constName) /*-{
    return Cesium.BingMapsStyle[constName];
  }-*/;
  
  protected BingMapsStyle(){}
}

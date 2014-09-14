package org.cesiumjs.cesium.events;

import org.cesiumjs.cesium.Cartesian2;

import com.google.gwt.core.client.JavaScriptObject;

public class MovementEvent extends CesiumInputEvent {
  protected MovementEvent() {}
  
  public native final Cartesian2 getStartPosition() /*-{
    return this.startPosition;
  }-*/;
  
  public native final Cartesian2 getEndPosition() /*-{
    return this.endPosition;
  }-*/;
}

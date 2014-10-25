package org.cesiumjs.cesium.events;

import jsfunction.gwt.functions.EventListener;

/**
 * @author richkadel
 *
 */
public abstract class CesiumInputEventListener<T extends CesiumInputEvent> implements EventListener<T> {
  
  protected CesiumInputEventListener() {}
  
  public abstract ScreenSpaceEventType getDefaultScreenSpaceEventType();
}
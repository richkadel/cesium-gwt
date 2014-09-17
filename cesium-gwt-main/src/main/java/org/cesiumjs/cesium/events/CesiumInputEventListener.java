package org.cesiumjs.cesium.events;

import org.cesiumjs.js.EventListener;

/**
 * @author richkadel
 *
 */
public abstract class CesiumInputEventListener<T extends CesiumInputEvent> implements EventListener<T> {
  
  protected CesiumInputEventListener() {}
  
  public abstract ScreenSpaceEventType getDefaultScreenSpaceEventType();
}
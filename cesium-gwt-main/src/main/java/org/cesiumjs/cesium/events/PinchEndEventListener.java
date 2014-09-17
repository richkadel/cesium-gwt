package org.cesiumjs.cesium.events;

/**
 * @author richkadel
 *
 */
public abstract class PinchEndEventListener extends CesiumInputEventListener<PinchEndEvent> {
  public ScreenSpaceEventType getDefaultScreenSpaceEventType() {
    return ScreenSpaceEventType.PINCH_END;
  }
}
package org.cesiumjs.cesium.events;

/**
 * @author richkadel
 *
 */
public abstract class PinchStartEventListener extends CesiumInputEventListener<PinchStartEvent> {
  public ScreenSpaceEventType getDefaultScreenSpaceEventType() {
    return ScreenSpaceEventType.PINCH_START;
  }
}
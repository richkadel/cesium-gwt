package org.cesiumjs.cesium.events;

/**
 * @author richkadel
 *
 */
public abstract class PinchMoveEventListener extends CesiumInputEventListener<PinchMoveEvent> {
  public ScreenSpaceEventType getDefaultScreenSpaceEventType() {
    return ScreenSpaceEventType.PINCH_MOVE;
  }
}
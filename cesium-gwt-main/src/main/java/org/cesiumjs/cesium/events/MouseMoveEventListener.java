package org.cesiumjs.cesium.events;

/**
 * @author richkadel
 *
 */
public abstract class MouseMoveEventListener extends CesiumInputEventListener<MouseMoveEvent> {
  public ScreenSpaceEventType getDefaultScreenSpaceEventType() {
    return ScreenSpaceEventType.MOUSE_MOVE;
  }
}
package org.cesiumjs.cesium.events;

/**
 * @author richkadel
 *
 */
public abstract class MouseDownEventListener extends CesiumInputEventListener<MouseDownEvent> {
  public ScreenSpaceEventType getDefaultScreenSpaceEventType() {
    return ScreenSpaceEventType.LEFT_DOWN;
  }
}
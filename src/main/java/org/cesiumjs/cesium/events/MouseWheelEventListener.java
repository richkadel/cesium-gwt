package org.cesiumjs.cesium.events;

/**
 * @author richkadel
 *
 */
public abstract class MouseWheelEventListener extends CesiumInputEventListener<MouseWheelEvent> {
  public ScreenSpaceEventType getDefaultScreenSpaceEventType() {
    return ScreenSpaceEventType.WHEEL;
  }
}
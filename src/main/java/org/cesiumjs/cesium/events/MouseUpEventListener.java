package org.cesiumjs.cesium.events;

/**
 * @author richkadel
 *
 */
public abstract class MouseUpEventListener extends CesiumInputEventListener<MouseUpEvent> {
  public ScreenSpaceEventType getDefaultScreenSpaceEventType() {
    return ScreenSpaceEventType.LEFT_UP;
  }
}
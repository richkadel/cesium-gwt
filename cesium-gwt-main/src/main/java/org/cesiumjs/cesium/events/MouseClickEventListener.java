package org.cesiumjs.cesium.events;

/**
 * @author richkadel
 *
 */
public abstract class MouseClickEventListener extends CesiumInputEventListener<MouseClickEvent> {
  public ScreenSpaceEventType getDefaultScreenSpaceEventType() {
    return ScreenSpaceEventType.LEFT_CLICK;
  }
}
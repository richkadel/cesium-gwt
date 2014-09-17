package org.cesiumjs.cesium.events;

/**
 * @author richkadel
 *
 */
public abstract class MouseDoubleClickEventListener extends CesiumInputEventListener<MouseDoubleClickEvent> {
  public ScreenSpaceEventType getDefaultScreenSpaceEventType() {
    return ScreenSpaceEventType.LEFT_DOUBLE_CLICK;
  }
}
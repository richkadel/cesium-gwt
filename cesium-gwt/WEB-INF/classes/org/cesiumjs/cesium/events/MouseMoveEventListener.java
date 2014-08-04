package org.cesiumjs.cesium.events;

import org.cesiumjs.js.EventListener;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public abstract class MouseMoveEventListener implements EventListener {

  @Override
  public void callback(JavaScriptObject event) {
    callback((MouseMoveEvent)event);
  }
  
  public abstract void callback(MouseMoveEvent event);
}
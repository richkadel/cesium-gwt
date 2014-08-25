package org.cesiumjs.cesium.events;

import org.cesiumjs.js.EventListener;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public abstract class MouseDoubleClickEventListener implements EventListener {

  @Override
  public void callback(JavaScriptObject event) {
    callback((MouseDoubleClickEvent)event);
  }
  
  public abstract void callback(MouseDoubleClickEvent event);
}
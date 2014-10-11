package org.cesiumjs.js;

import com.google.gwt.core.client.JavaScriptObject;

public interface EventListener<T extends JavaScriptObject> {

  void callback(T event);
}

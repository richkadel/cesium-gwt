package org.cesiumjs.js;

import com.google.gwt.core.client.JavaScriptObject;

public interface EventListener<T extends JavaScriptObject> extends JsCallback {

  void callback(T event);
}

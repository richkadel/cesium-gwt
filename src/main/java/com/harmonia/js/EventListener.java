package com.harmonia.js;

import com.google.gwt.core.client.JavaScriptObject;

public interface EventListener extends JsCallback {

	void callback(JavaScriptObject event);
}

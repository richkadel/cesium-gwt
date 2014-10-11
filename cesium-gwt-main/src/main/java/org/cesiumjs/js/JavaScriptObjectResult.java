package org.cesiumjs.js;

import com.google.gwt.core.client.JavaScriptObject;

public abstract class JavaScriptObjectResult extends ResultCallback {

  @Override
  public void callback(ReturnValue returnValue) {
    onReturn(returnValue.asJavaScriptObject());
  }

  public abstract void onReturn(JavaScriptObject returnValue);
}

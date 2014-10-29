package org.cesiumjs.cesium.events;

import com.google.gwt.core.client.JavaScriptObject;

import jsfunction.gwt.JsFunction;
import jsfunction.gwt.functions.NoArgsFunction;

public final class Promise extends JavaScriptObject {
  
  protected Promise() {}
  
  public void then(NoArgsFunction callback) {
    nativeThen(JsFunction.create(callback));
  }

  private native void nativeThen(JsFunction callback) /*-{
    this["then"](callback) // this.then() is more "normal" javascript but GWT DevMode may freak out about using this keyword
  }-*/;
}

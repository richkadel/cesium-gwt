package com.harmonia.gwt.js;

import com.google.gwt.core.client.JavaScriptObject;

public class JsFunction extends JavaScriptObject {

  protected JsFunction() {}
  
  /**
   * @param callback The instance callback to call in a roundabout way from JSNI
   * @param once Delete the callback after the first invocation
   * @return
   */
  public final static JsFunction create(EventListener callback) {
    return createEventListener(JsFunctionCallbacks.register(callback));
  }
  
  private final static native JsFunction createEventListener(String callbackId) /*-{
    this.callbackId = callbackId
    return function(event) {
      @com.harmonia.gwt.js.JsFunctionCallbacks::invoke(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(callbackId, event)
    }
  }-*/;
  
  /**
   * @param callback The instance callback to call in a roundabout way from JSNI
   * @param once Delete the callback after the first invocation
   * @return
   */
  public final static JsFunction create(JsFunctionCallback callback, boolean once) {
    return create(JsFunctionCallbacks.register(callback), once);
  }
  
  private final static native JsFunction create(String callbackId, boolean once) /*-{
    this.callbackId = callbackId
    this.once = once
    return function() {
      @com.harmonia.gwt.js.JsFunctionCallbacks::invoke(Ljava/lang/String;)(callbackId)
      if (once) {
        @com.harmonia.gwt.js.JsFunctionCallbacks::remove(Ljava/lang/String;)(callbackId)
      }
    }
  }-*/;
  
  private final static native void removeCallback() /*-{
    @com.harmonia.gwt.js.JsFunctionCallbacks::remove(Ljava/lang/String;)(this.callbackId)
  }-*/;
}

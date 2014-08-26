package org.cesiumjs.js;

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
    jsFunction = function(event) {
      @org.cesiumjs.js.JsFunctionCallbacks::invoke(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(callbackId, event)
    }
    jsFunction.callbackId = callbackId
    return jsFunction
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
    jsFunction = function() {
      @org.cesiumjs.js.JsFunctionCallbacks::invoke(Ljava/lang/String;)(callbackId)
      if (once) {
        @org.cesiumjs.js.JsFunctionCallbacks::remove(Ljava/lang/String;)(callbackId)
      }
    }
    jsFunction.callbackId = callbackId
    jsFunction.once = once
    return jsFunction
  }-*/;
  
  public final native void removeCallback() /*-{
    @org.cesiumjs.js.JsFunctionCallbacks::remove(Ljava/lang/String;)(this.callbackId)
  }-*/;
}

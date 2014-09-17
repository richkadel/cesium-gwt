package org.cesiumjs.cesium.events;

import org.cesiumjs.js.JsFunction;
import org.cesiumjs.js.JsFunctionCallback;

import com.google.gwt.core.client.JavaScriptObject;

public final class Event extends JavaScriptObject {
  
  protected Event() {}

  public ListenerHandle addEventListener(JsFunctionCallback callback) {
    JsFunction jsFunction = JsFunction.create(callback, false);
    nativeAddEventListener(jsFunction);
    return new ListenerHandle(this, jsFunction);
  }

  private native void nativeAddEventListener(JsFunction callback) /*-{
    this.addEventListener(callback)
  }-*/;

  private native void nativeRemoveEventListener(JsFunction callback) /*-{
    this.removeEventListener(callback)
  }-*/;
  
  /**
   * TODO: I'm not actually sure how to use this scope variable. Since we have
   * some redirection happening through the JsFunction class, we may lose
   * the scope.
   * 
   * Oh, just discovered this JavaScript capability:
   * func.apply(thisArg, [argsArray]) -> where func is a known function object.
   * Plug in scope for "thisArg".
   * 
   * similarly func.call(thisArg[, optionalArg1[, optionalArg2[, ...]]])
   * 
   * similarly func.bind(thisArg[, optionalArg1[, optionalArg2[, ...]]])
   * creates a function to be called later, with the given "this" (scope)
   * and given initial args.
   * 
   * Also, on a related note, I did not implement raiseEvent yet. As it turns
   * out, raiseEvent implies you can have callback function parameters.
   * I may want to allow an "EventHandler" JsCallback to be passed in
   * so we can give it the parameters, but I'm currently not supporting that,
   * intentionally.
   * 
   * @param callback
   * @param scope
   * @return
   */
  public ListenerHandle addEventListener(JsFunctionCallback callback, JavaScriptObject scope) {
    JsFunction jsFunction = JsFunction.create(callback, false);
    nativeAddEventListener(jsFunction, scope);
    return new ListenerHandle(this, jsFunction, scope);
  }
  
  private native void nativeAddEventListener(JsFunction callback, JavaScriptObject scope) /*-{
    this.addEventListener(callback, scope)
  }-*/;

  private native void nativeRemoveEventListener(JsFunction callback, JavaScriptObject scope) /*-{
    this.removeEventListener(callback, scope)
  }-*/;

  public static final class ListenerHandle {
    
    private Event event;
    private JsFunction jsFunction;
    private JavaScriptObject scope;

    ListenerHandle(Event event, JsFunction jsFunction) {
      this.event = event;
      this.jsFunction = jsFunction;
    }
    
    ListenerHandle(Event event, JsFunction jsFunction, JavaScriptObject scope) {
      this.event = event;
      this.jsFunction = jsFunction;
      this.scope = scope;
    }
    
    public void removeCallback() {
      if (scope == null) {
        event.nativeRemoveEventListener(jsFunction);
      } else {
        event.nativeRemoveEventListener(jsFunction, scope);
      }
      jsFunction.removeCallback();
    }
  }
}

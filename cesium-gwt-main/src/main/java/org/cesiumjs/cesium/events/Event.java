package org.cesiumjs.cesium.events;

import jsfunction.gwt.JsFunction;
import jsfunction.gwt.NoArgsFunction;
import jsfunction.gwt.VarArgsFunction;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;

/**
 * Implements the semantics of Cesium's Event class. Note that the JavaScript
 * Event class allows an optional "scope" (the "this" value to be initialized
 * when invoking the callback). For Java, this doesn't make sense. The callback's
 * scope is provided as part of the Java class declaration--typically an
 * anonymous inner class that is an implementation of NoArgsFunction, for instance.
 * 
 * @author richkadel
 */
public final class Event extends JavaScriptObject {
  
  protected Event() {}

  public ListenerHandle addEventListener(NoArgsFunction callback) {
    return addEventListener(JsFunction.create(callback));
  }

  public ListenerHandle addEventListener(VarArgsFunction callback) {
    return addEventListener(JsFunction.create(callback));
  }
  
  private ListenerHandle addEventListener(JsFunction jsFunction) {
    nativeAddEventListener(jsFunction);
    return new ListenerHandle(this, jsFunction);
  }

  private native void nativeAddEventListener(JsFunction callback) /*-{
    this.addEventListener(callback)
  }-*/;

  private native void nativeRemoveEventListener(JsFunction callback) /*-{
    this.removeEventListener(callback)
  }-*/;
  
  public native void raiseEvent(JsArrayMixed arguments) /*-{
    this.raiseEvent.apply(this, arguments)
  }-*/;
  
  public static final class ListenerHandle {
    
    private Event event;
    private JsFunction jsFunction;

    ListenerHandle(Event event, JsFunction jsFunction) {
      this.event = event;
      this.jsFunction = jsFunction;
    }
    
    public void removeCallback() {
      event.nativeRemoveEventListener(jsFunction);
    }
  }
}

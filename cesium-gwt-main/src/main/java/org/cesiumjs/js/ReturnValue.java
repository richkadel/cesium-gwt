package org.cesiumjs.js;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * This class allows Java Objects to be returned from JavaScript methods,
 * which is allowed in GWT but only if those values are handled opaquely.
 * If there is a chance the invoked method will be transforming objects
 * to/from JSON strings (e.g., to pass objects between different browser
 * scopes or to/from servers) then you should restrict your ReturnValue
 * implementations to JavaScriptObject or accepted primitives.
 */
public final class ReturnValue<T> extends JavaScriptObject {
  
  protected ReturnValue() {}

  public static native ReturnValue<Object> create(Object value) /*-{
    return {
      value : value
    }
  }-*/;
  
  public static native ReturnValue<JavaScriptObject> create(JavaScriptObject value) /*-{
    return {
      value : value
    }
  }-*/;
  
  public static native ReturnValue<String> create(String value) /*-{
    return {
      value : value
    }
  }-*/;
  
  public static native ReturnValue<Boolean> create(boolean value) /*-{
    return {
      value : value
    }
  }-*/;
  
  public static native ReturnValue<Integer> create(int value) /*-{
    return {
      value : value
    }
  }-*/;
  
  public static native ReturnValue<Double> create(double value) /*-{
    return {
      value : value
    }
  }-*/;
  
  @SuppressWarnings("unchecked")
  public T get() {
    if (isNumber()) {
      return (T)Double.valueOf(asDouble());
    } else if (isBoolean()) {
      return (T)Boolean.valueOf(asBoolean());
    } else if (isString()) {
      return (T)String.valueOf(asString());
    } else {
      return (T)asObject();
    }
  }
  
  public native Object asObject() /*-{
    return this.value;
  }-*/;
  
  public native JavaScriptObject asJavaScriptObject() /*-{
    return this.value != null ? Object(this.value) : null;
  }-*/;
  
  public native String asString() /*-{
    return String(this.value);
  }-*/;
  
  public native double asDouble() /*-{
    return Number(this.value);
  }-*/;
  
  public native int asInt() /*-{
    return Number(this.value);
  }-*/;
  
  public native boolean asBoolean() /*-{
    return Boolean(this.value);
  }-*/;
  
  private native boolean isNumber() /*-{
    return typeof this.value === 'number';
  }-*/;

  private native boolean isBoolean() /*-{
    return typeof this.value === 'boolean';
  }-*/;

  private native boolean isString() /*-{
    return typeof this.value === 'string';
  }-*/;
}
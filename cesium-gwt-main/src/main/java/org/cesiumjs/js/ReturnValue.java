package org.cesiumjs.js;

import com.google.gwt.core.client.JavaScriptObject;

public final class ReturnValue extends JavaScriptObject {
  
  protected ReturnValue() {}

  public static native ReturnValue create(JavaScriptObject value) /*-{
    return {
      value : value
    }
  }-*/;
  
  public static native ReturnValue create(String value) /*-{
    return {
      value : value
    }
  }-*/;
  
  public static native ReturnValue create(boolean value) /*-{
    return {
      value : value
    }
  }-*/;
  
  public static native ReturnValue create(int value) /*-{
    return {
      value : value
    }
  }-*/;
  
  public static native ReturnValue create(double value) /*-{
    return {
      value : value
    }
  }-*/;
  
  public native Object asObject() /*-{
    return this.value;
  }-*/;
  
  public native JavaScriptObject asJavaScriptObject() /*-{
    return this.value;
  }-*/;
  
  public native String asString() /*-{
    return this.value;
  }-*/;
  
  public native double asDouble() /*-{
    return this.value;
  }-*/;
  
  public native int asInt() /*-{
    return this.value;
  }-*/;
  
  public native boolean asBoolean() /*-{
    return this.value;
  }-*/;
}
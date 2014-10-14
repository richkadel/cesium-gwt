package org.cesiumjs.js;

import com.google.gwt.core.client.JsArrayMixed;

/**
 * GWT allows objects to be passed in and out of methods, but the default JsArrayMixed
 * does not support Java Objects.  However, native JavaScript can handle these opaque
 * Java Objects, so by simply extending JsArrayMixed, we create a version that does
 * have methods to allow us to add and retrieve Java Objects.
 * 
 * The benefit is, when converting a Java "Object..." varargs argument to
 * send to a JavaScript function that may turn around and pass those arguments back
 * into a GWT Java method to handle the arguments, this array will allow
 * Java Objects and it will work.
 * 
 * The caution is, if the underlying JavaScript implementation will attempt
 * to convert the array to a JSON string, e.g., to pass the JSON to
 * another browser scope or to a server, the Java Object conversion is
 * undefined and will, at best, just not work, and at worst may cause
 * a fatal error in the program. Use with caution.
 */
public class JsArrayMixedWithObject extends JsArrayMixed {

  public final native void push(Object value) /*-{
    this[this.length] = value;
  }-*/;

  public final native void unshift(Object value) /*-{
    this.unshift(value);
  }-*/;

  public final native void shiftJavaObject() /*-{
    return this.shift();
  }-*/;

  public final native void set(int index, Object value) /*-{
    this[index] = value;
  }-*/;

  public final native Object getJavaObject(int index) /*-{
    return this[index];
  }-*/;
}

package org.cesiumjs.js;

/**
 * JSNI allows Java "Objects" to be passed in and returned out of JavaScript functions, but
 * it treates them as "opaque" JavaScript objects. You shouldn't manipulate them, but if
 * you pass a Java object into a JavaScript function, and later return it from another function,
 * this class will allow you to handle that returned value.
 * @author richkadel
 */
public abstract class ObjectResult extends ResultCallback {

  @Override
  public void callback(ReturnValue returnValue) {
    onReturn(returnValue.asObject());
  }

  public abstract void onReturn(Object returnValue);
}

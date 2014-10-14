package org.cesiumjs.js;

public abstract class JsReturn<T> {

  public void onReturn(ReturnValue<T> returnValue) {
    onReturn(returnValue.get());
  }

  public abstract void onReturn(T returnValue);
}

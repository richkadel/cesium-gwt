package org.cesiumjs.js;

public abstract class StringResult extends ResultCallback {

  @Override
  public void callback(ReturnValue returnValue) {
    onReturn(returnValue.asString());
  }

  public abstract void onReturn(String returnValue);
}

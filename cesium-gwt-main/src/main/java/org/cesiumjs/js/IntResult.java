package org.cesiumjs.js;

public abstract class IntResult extends ResultCallback {

  @Override
  public void callback(ReturnValue returnValue) {
    onReturn(returnValue.asInt());
  }

  public abstract void onReturn(int returnValue);
}

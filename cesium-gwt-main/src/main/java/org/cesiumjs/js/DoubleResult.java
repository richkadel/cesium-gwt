package org.cesiumjs.js;

public abstract class DoubleResult extends ResultCallback {

  @Override
  public void callback(ReturnValue returnValue) {
    onReturn(returnValue.asDouble());
  }

  public abstract void onReturn(double returnValue);
}

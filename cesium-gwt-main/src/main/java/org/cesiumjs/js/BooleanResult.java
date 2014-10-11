package org.cesiumjs.js;

public abstract class BooleanResult extends ResultCallback {

  @Override
  public void callback(ReturnValue returnValue) {
    onReturn(returnValue.asBoolean());
  }

  public abstract void onReturn(boolean returnValue);
}

package org.cesiumjs.js;

public abstract class ResultCallback implements EventListener<ReturnValue> {

  @Override
  public abstract void callback(ReturnValue returnValue);
}

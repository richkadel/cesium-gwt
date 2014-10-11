package org.cesiumjs.js;

import com.google.gwt.core.client.JsArrayMixed;

public abstract class DoubleFunction implements VarArgsFunctionReturn {

  @Override
  public ReturnValue callAndReturnValue(JsArrayMixed args) {
    return ReturnValue.create(callback(args));
  }

  public abstract double callback(JsArrayMixed args);
}

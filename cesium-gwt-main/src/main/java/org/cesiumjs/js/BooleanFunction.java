package org.cesiumjs.js;

import com.google.gwt.core.client.JsArrayMixed;

public abstract class BooleanFunction implements VarArgsFunctionReturn {

  @Override
  public ReturnValue callAndReturnValue(JsArrayMixed args) {
    return ReturnValue.create(callback(args));
  }

  public abstract boolean callback(JsArrayMixed args);
}

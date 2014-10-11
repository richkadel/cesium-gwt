package org.cesiumjs.js;

import com.google.gwt.core.client.JsArrayMixed;

public abstract class IntFunction implements VarArgsFunctionReturn {

  @Override
  public ReturnValue callAndReturnValue(JsArrayMixed args) {
    return ReturnValue.create(callback(args));
  }

  public abstract int callback(JsArrayMixed args);
}

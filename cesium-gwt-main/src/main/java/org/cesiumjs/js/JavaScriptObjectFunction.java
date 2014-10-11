package org.cesiumjs.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;

public abstract class JavaScriptObjectFunction implements VarArgsFunctionReturn {

  @Override
  public ReturnValue callAndReturnValue(JsArrayMixed args) {
    return ReturnValue.create(callback(args));
  }

  public abstract JavaScriptObject callback(JsArrayMixed args);
}

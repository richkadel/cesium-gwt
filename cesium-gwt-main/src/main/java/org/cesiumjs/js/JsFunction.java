package org.cesiumjs.js;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayMixed;

public final class JsFunction extends JavaScriptObject {

  protected JsFunction() {}
  
  private static void invoke(NoArgsFunction noArgCallback) {
    noArgCallback.callback();
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  private static void invoke(EventListener eventListener, JavaScriptObject event) {
    eventListener.callback(event);
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  private static void invoke(JsReturn deferredFunctionResult, ReturnValue result) {
    deferredFunctionResult.onReturn(result);
  }
  
  private static void invoke(VarArgsFunction varArgsFunction, JsArrayMixed args) {
    varArgsFunction.callback(args);
  }
  
//  private static <T> ReturnValue<T> invoke(VarArgsFunctionReturn<T> varArgsFunctionReturn, JsArrayMixed args) {
//    return varArgsFunctionReturn.callAndReturnValue(args);
//  }
//  
//  private static <T> ReturnValue<T> invoke(NoArgsFunctionReturn<T> noArgsFunctionReturn) {
//    return noArgsFunctionReturn.callAndReturnValue();
//  }
  
  @SuppressWarnings({ "rawtypes" })
  private static ReturnValue invoke(VarArgsFunctionReturn varArgsFunctionReturn, JsArrayMixed args) {
    return varArgsFunctionReturn.callAndReturnValue(args);
  }
  
  @SuppressWarnings({ "rawtypes" })
  private static ReturnValue invoke(NoArgsFunctionReturn noArgsFunctionReturn) {
    return noArgsFunctionReturn.callAndReturnValue();
  }
  
  /**
   * @param func The instance function to call from JSNI
   * @return a GWT reference to an actual JavaScript function pointer
   */
  public static native JsFunction create(NoArgsFunction func) /*-{
    return function() {
      @org.cesiumjs.js.JsFunction::invoke(Lorg/cesiumjs/js/NoArgsFunction;)(func)
    }
  }-*/;
  
  /**
   * @param func The instance function to call from JSNI
   * @return a GWT reference to an actual JavaScript function pointer
   */
  public static native JsFunction create(NoArgsFunctionReturn<?> func) /*-{
    return function() {
      return @org.cesiumjs.js.JsFunction::invoke(Lorg/cesiumjs/js/NoArgsFunctionReturn;)(func)
    }
  }-*/;
  
  /**
   * @param eventListener The instance eventListener to call from JSNI, taking a single event object, when invoked
   * @return a GWT reference to an actual JavaScript function pointer
   */
  public static native JsFunction create(EventListener<?> eventListener) /*-{
    return function(event) {
      @org.cesiumjs.js.JsFunction::invoke(Lorg/cesiumjs/js/EventListener;Lcom/google/gwt/core/client/JavaScriptObject;)(eventListener, event)
    }
  }-*/;
  
  /**
   * @param deferredFunctionResult The instance deferredFunctionResult to call from JSNI, taking a single result object, when invoked
   * @return a GWT reference to an actual JavaScript function pointer
   */
  public static native JsFunction create(JsReturn<?> deferredFunctionResult) /*-{
    return function(result) {
      @org.cesiumjs.js.JsFunction::invoke(Lorg/cesiumjs/js/JsReturn;Lorg/cesiumjs/js/ReturnValue;)(deferredFunctionResult, result)
    }
  }-*/;
  
  /**
   * @param func The instance function to call from JSNI, which may be called
   * with multiple arguments. When invoked, JsFunction packages the arguments into a JavaScript 
   * array.
   * @return a GWT reference to an actual JavaScript function pointer
   */
  public static native JsFunction create(VarArgsFunction func) /*-{
    return function() {
      var argumentsArray = Array.prototype.slice.apply(arguments);
      @org.cesiumjs.js.JsFunction::invoke(Lorg/cesiumjs/js/VarArgsFunction;Lcom/google/gwt/core/client/JsArrayMixed;)(func, argumentsArray)
    }
  }-*/;
  
  /**
   * @param func The instance function to call from JSNI, which may be called
   * with multiple arguments and should return a ReturnValue. When invoked, 
   * JsFunction packages the arguments into a JavaScript array.
   * @return a GWT reference to an actual JavaScript function pointer
   */
  public static native JsFunction create(VarArgsFunctionReturn<?> func) /*-{
    return function() {
      var argumentsArray = Array.prototype.slice.apply(arguments);
      return @org.cesiumjs.js.JsFunction::invoke(Lorg/cesiumjs/js/VarArgsFunctionReturn;Lcom/google/gwt/core/client/JsArrayMixed;)(func, argumentsArray)
    }
  }-*/;
  
  /**
   * Utility method
   * @param functionArgs a var args of objects (which can be called with primitives as well, using Java auto boxing).
   * The only valid argument types are those that match the JsArrayMixed "set()" methods, that is:
   * double, boolean, string, and JavaScriptObject
   * @return a JsArrayMixed
   */
  public static JsArrayMixed varArgsToMixedArray(Object[] functionArgs) {
    int len = functionArgs.length;
    JsArrayMixed mixedArray = JsArrayMixed.createArray(len).cast();
    for (int i = 0; i < len; i++) {
      Object arg = functionArgs[i];
      if (arg instanceof Number) {
        mixedArray.set(i, ((Number)arg).doubleValue());
      } else if (arg instanceof Boolean) {
        mixedArray.set(i, ((Boolean)arg).booleanValue());
      } else if (arg instanceof String) {
        mixedArray.set(i, (String)arg);
      } else {
        mixedArray.set(i, (JavaScriptObject)arg); 
      }
    }
    return mixedArray;
  }
  
  /**
   * Utility method
   * @param mixedArray 
   * @return an Object array
   */
  public static Object[] mixedArrayToObjects(JsArrayMixed mixedArray) {
    int len = mixedArray.length();
    List<Object> objects = new ArrayList<Object>(len);
    for (int i = 0; i < len; i++) {
      if (elementIsNumber(mixedArray, i)) {
        objects.add(Double.valueOf(mixedArray.getNumber(i)));
      } else if (elementIsBoolean(mixedArray, i)) {
        objects.add(Boolean.valueOf(mixedArray.getBoolean(i)));
      } else if (elementIsString(mixedArray, i)) {
        objects.add(String.valueOf(mixedArray.getString(i)));
      } else {
        objects.add(String.valueOf(mixedArray.getObject(i)));
      }
    }
    return objects.toArray();
  }

  /**
   * Utility method
   * @param functionArgs a var args of objects (which can be called with primitives as well, using Java auto boxing).
   * The only valid argument types are those that match the JsArrayMixed "set()" methods, that is:
   * double, boolean, string, and JavaScriptObject
   * @return a JsArrayMixed
   */
  public static JsArrayMixedWithObject varArgsToMixedArrayWithObject(Object[] functionArgs) {
    int len = functionArgs.length;
    JsArrayMixedWithObject mixedArray = JsArrayMixed.createArray(len).cast();
    for (int i = 0; i < len; i++) {
      Object arg = functionArgs[i];
      if (arg instanceof Number) {
        mixedArray.set(i, ((Number)arg).doubleValue());
      } else if (arg instanceof Boolean) {
        mixedArray.set(i, ((Boolean)arg).booleanValue());
      } else if (arg instanceof String) {
        mixedArray.set(i, (String)arg);
      } else {
        mixedArray.set(i, arg); // does not force conversion to JavaScriptObject
      }
    }
    return mixedArray;
  }
  
  /**
   * Utility method
   * @param mixedArray 
   * @return an Object array
   */
  public static Object[] mixedArrayToObjects(JsArrayMixedWithObject mixedArray) {
    int len = mixedArray.length();
    List<Object> objects = new ArrayList<Object>(len);
    for (int i = 0; i < len; i++) {
      if (elementIsNumber(mixedArray, i)) {
        objects.add(Double.valueOf(mixedArray.getNumber(i)));
      } else if (elementIsBoolean(mixedArray, i)) {
        objects.add(Boolean.valueOf(mixedArray.getBoolean(i)));
      } else if (elementIsString(mixedArray, i)) {
        objects.add(String.valueOf(mixedArray.getString(i)));
      } else {
        objects.add(String.valueOf(mixedArray.getJavaObject(i))); // less type checking but should work for JavaScriptObject as well
      }
    }
    return objects.toArray();
  }

  private static native boolean elementIsNumber(JsArrayMixed mixedArray, int i) /*-{
    return typeof mixedArray[i] === 'number';
  }-*/;

  private static native boolean elementIsBoolean(JsArrayMixed mixedArray, int i) /*-{
    return typeof mixedArray[i] === 'boolean';
  }-*/;

  private static native boolean elementIsString(JsArrayMixed mixedArray, int i) /*-{
    return typeof mixedArray[i] === 'string';
  }-*/;

  public static <T extends JavaScriptObject> JsArray<T> toJsArray(Collection<T> collection) {
    JsArray<T> jsArray = JsArray.createArray(collection.size()).cast();
    int i = 0;
    for (T item : collection) {
      jsArray.set(i++, item);
    }
    return jsArray;
  }
}

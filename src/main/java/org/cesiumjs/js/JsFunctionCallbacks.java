package org.cesiumjs.js;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;

public class JsFunctionCallbacks {
  
  private static Map<String,JsCallback> callbacks = new HashMap<String,JsCallback>();
  private static int nextId = 0;

  public static String register(JsCallback callback) {
    String id = Integer.toString(nextId++);
    callbacks.put(id, callback);
    return id;
  }
  
  public static JsCallback remove(String id) {
    return callbacks.remove(id);
  }

  public static void invoke(String id) {
    ((JsFunctionCallback)callbacks.get(id)).callback();
  }

  @SuppressWarnings("unchecked")
  public static <T extends JavaScriptObject> void invoke(String id, T event) {
    ((EventListener<T>)callbacks.get(id)).callback(event);
  }
}

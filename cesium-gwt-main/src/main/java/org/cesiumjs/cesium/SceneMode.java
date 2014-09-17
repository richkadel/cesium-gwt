package org.cesiumjs.cesium;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public enum SceneMode {
  
  COLUMBUS_VIEW,
  MORPHING,
  SCENE2D,
  SCENE3D;
  
  public static SceneMode valueOf(int nativeValue) { // SceneModes are ints in JavaScript
    for (SceneMode enumInstance : SceneMode.values()) {
      if (matches(enumInstance.toString(), nativeValue)) {
        return enumInstance;
      }
    }
    return null;
  }
  
  private native static boolean matches(String enumString, int nativeValue) /*-{
    return Cesium.SceneMode[enumString] == value;
  }-*/;
  
  public static double getMorphTime(SceneMode sceneMode) {
    return nativeGetMorphTime(sceneMode.toString());
  }

  private static native double nativeGetMorphTime(String sceneModeString) /*-{
    return Cesium.SceneMode.getMorphTime(Cesium.SceneMode[sceneModeString]);
  }-*/;
}
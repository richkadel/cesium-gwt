package org.cesiumjs.cesium;

/**
 * @author richkadel
 *
 */
public enum SceneMode {
  
  COLUMBUS_VIEW,
  MORPHING,
  SCENE2D,
  SCENE3D;
  
  public static SceneMode valueOf(double nativeValue) { // SceneModes are Numbers in JavaScript
    for (SceneMode enumInstance : SceneMode.values()) {
      if (nativeValue == enumInstance.toNumber()) {
        return enumInstance;
      }
    }
    return null;
  }
  
  public double toNumber() {
    return toNumber(toString());
  }
  
  public native double toNumber(String asString) /*-{
    return Cesium.SceneMode[asString]
  }-*/;
  
  public static double getMorphTime(SceneMode sceneMode) {
    return nativeGetMorphTime(sceneMode.toString());
  }

  private static native double nativeGetMorphTime(String sceneModeString) /*-{
    return Cesium.SceneMode.getMorphTime(Cesium.SceneMode[sceneModeString]);
  }-*/;
}
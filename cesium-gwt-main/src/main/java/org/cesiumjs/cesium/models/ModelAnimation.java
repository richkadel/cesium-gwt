package org.cesiumjs.cesium.models;

import org.cesiumjs.cesium.Matrix4;
import org.cesiumjs.cesium.events.Event;
import org.cesiumjs.cesium.time.JulianDate;

import com.google.gwt.core.client.JavaScriptObject;

public final class ModelAnimation extends JavaScriptObject {
  
  protected ModelAnimation() {}
  
  public native Event onStart() /*-{
    return this.start
  }-*/;

  public native Event onStop() /*-{
    return this.stop
  }-*/;

  public native Event onUpdate() /*-{
    return this.update
  }-*/;

  public native double getDelaySeconds() /*-{
    return this.delay
  }-*/;

  public ModelAnimationLoop getLoop() {
    return ModelAnimationLoop.valueOf(nativeGetLoop());
  }

  private native int nativeGetLoop() /*-{
    return this.loop
  }-*/;

  public native String getName() /*-{
    return this.name
  }-*/;
  
  public native boolean isReverse() /*-{
    return this.reverse
  }-*/;

  public native double getSpeedup() /*-{
    return this.speedup
  }-*/;

  public native void setRemoveOnStop(boolean removeOnStop) /*-{
    this.removeOnStop = removeOnStop
  }-*/;

  public native boolean isRemoveOnStop() /*-{
    return this.removeOnStop
  }-*/;

  public native JulianDate getStartTime() /*-{
    return this.startTime
  }-*/;

  public native JulianDate getStopTime() /*-{
    return this.stopTime
  }-*/;

  public static final class Options extends JavaScriptObject {

    protected Options(){}
    
    public static native Options create() /*-{
      return {}
    }-*/;
    
    public native Options startTime(JulianDate startTime) /*-{
      this.startTime = startTime
      return this;
    }-*/;
    
    public native Options delaySeconds(double delay) /*-{
      this.delay = delay
      return this;
    }-*/;
    
    public native Options stopTime(JulianDate stopTime) /*-{
      this.stopTime = stopTime
      return this;
    }-*/;
    
    public native Options removeOnStop(boolean removeOnStop) /*-{
      this.removeOnStop = removeOnStop
      return this;
    }-*/;
    
    public native Options speedup(double speedup) /*-{
      this.speedup = speedup
      return this;
    }-*/;
    
    public native Options reverse(boolean reverse) /*-{
      this.reverse = reverse
      return this;
    }-*/;
    
    public Options loop(ModelAnimationLoop loop) {
      return nativeLoop(loop.nativeValue());
    }
    
    private native Options nativeLoop(int loop) /*-{
      this.loop = loop
      return this;
    }-*/;
  }
}
  
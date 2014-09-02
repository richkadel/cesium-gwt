package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public class CesiumWidget extends JavaScriptObject {
  
  // Overlay types always have protected, zero argument constructors.
  protected CesiumWidget(){}

  public final static CesiumWidget create(Element element) {
    return CesiumWidget.create(element, Options.create());
  }
  
  public final static CesiumWidget create(Element element, Options options) {
    
    CesiumWidget cesiumWidget = nativeCreate(element, options);
    
    // THE FOLLOWING HACK OVERCOMES ISSUES INTEGRATING WITH GWT, WHICH SEEMS
		// TO MASK CERTAIN MOUSE EVENTS THAT CESIUM'S DEFAULT HANDLERS RELY ON.
		// CESIUM DOES NOT PROVIDE A SIMPLE WAY TO OVERCOME THIS ISSUE.
    Element canvas = cesiumWidget.getCanvas();
    canvas.setPropertyBoolean("disableRootEvents", true);
    
    return cesiumWidget;
  }
    
  private final native static CesiumWidget nativeCreate(Element element, Options options) /*-{
    return new Cesium.CesiumWidget(element, options);
  }-*/;
  
  public final native static CesiumWidget create(String divId) /*-{
    return new Cesium.CesiumWidget(divId);
  }-*/;
  
  public final native Element getCanvas() /*-{
    return this.canvas;
  }-*/;

  public final native Scene getScene() /*-{
    return this.scene;
  }-*/;

  public final native ScreenSpaceEventHandler getScreenSpaceEventHandler() /*-{
    return this.screenSpaceEventHandler;
  }-*/;

	public final native void resize() /*-{
    this.resize();
	}-*/;

	public final native void render() /*-{
    this.render();
	}-*/;
  
  public static final class Options extends JavaScriptObject {
    // Overlay types always have protected, zero argument constructors.
    protected Options(){}
    
    public static native Options create() /*-{
      return {}
    }-*/;
    
    public native Options scene3DOnly(boolean scene3DOnly) /*-{ 
    	this.scene3DOnly = scene3DOnly
    	return this
    }-*/;
    
    public native Options imageryProvider(ImageryProvider imageryProvider) /*-{ 
    	this.imageryProvider = imageryProvider
    	return this
    }-*/;
    
    public native Options terrainProvider(TerrainProvider terrainProvider) /*-{ 
    	this.terrainProvider = terrainProvider
    	return this
    }-*/;
    
    public native Options targetFrameRate(double targetFrameRateFPS) /*-{ 
    	this.targetFrameRate = targetFrameRateFPS
    	return this
    }-*/;
    
    public native Options useDefaultRenderLoop(boolean useDefaultRenderLoop) /*-{ 
    	this.useDefaultRenderLoop = useDefaultRenderLoop
    	return this
    }-*/;
    
    public native Options showRenderLoopErrors(boolean showRenderLoopErrors) /*-{ 
		this.showRenderLoopErrors = showRenderLoopErrors
		return this
	}-*/;
    
    public native Options creditContainer(String containerID) /*-{
		this.creditContainer = containerID;
		return this;
	}-*/;
    
    public native Options creditContainer(Element containerEl) /*-{
		this.creditContainer = containerEl;
		return this;
	}-*/;
    
    public native Options sceneMode(SceneMode sceneMode) /*-{
		this.sceneMode = sceneMode;
		return this;
	}-*/;
    
    public native Options skyBox(SkyBox skyBox) /*-{
		this.skyBox = skyBox;
		return this;
	}-*/;

    
    public native Options contextOptions(Undocumented contextOptions) /*-{
		this.contextOptions = contextOptions;
		return this;
	}-*/;
    
    

    
    
 
  }
}
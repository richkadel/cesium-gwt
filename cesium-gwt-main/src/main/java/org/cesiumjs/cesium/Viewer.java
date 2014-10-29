package org.cesiumjs.cesium;

import org.cesiumjs.cesium.data.DataSourceCollection;
import org.cesiumjs.cesium.events.ScreenSpaceEventHandler;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public class Viewer extends JavaScriptObject {
  
  // Overlay types always have protected, zero argument constructors.
  protected Viewer(){}

  public final static Viewer create(Element element) {
    return Viewer.create(element, Options.create());
  }
  
  public final static Viewer create(Element element, Options options) {
    
    Viewer viewer = nativeCreate(element, options);
    
    // THE FOLLOWING HACK OVERCOMES ISSUES INTEGRATING WITH GWT, WHICH SEEMS
    // TO MASK CERTAIN MOUSE EVENTS THAT CESIUM'S DEFAULT HANDLERS RELY ON.
    // CESIUM DOES NOT PROVIDE A SIMPLE WAY TO OVERCOME THIS ISSUE.
    Element canvas = viewer.getCanvas();
    canvas.setPropertyBoolean("disableRootEvents", true);
    
    return viewer;
  }
    
  private final native static Viewer nativeCreate(Element element, Options options) /*-{
    return new Cesium.Viewer(element, options);
  }-*/;
  
  public final native static Viewer create(String divId) /*-{
    return new Cesium.Viewer(divId);
  }-*/;
  
  public final native Element getContainer() /*-{
    return this.container;
  }-*/;

  public final native Element getCreditContainer() /*-{
    return this.creditContainer;
  }-*/;

  public final native CanvasElement getCanvas() /*-{
    return this.canvas;
  }-*/;

  public final native Scene getScene() /*-{
    return this.scene;
  }-*/;

  public final native Clock getClock() /*-{
    return this.clock;
  }-*/;

  public final native ScreenSpaceEventHandler getScreenSpaceEventHandler() /*-{
    return this.screenSpaceEventHandler;
  }-*/;

  public final native void setTargetFrameRate(double targetFrameRateFPS) /*-{ 
    this.targetFrameRate = targetFrameRateFPS
  }-*/;
    
  public final native double getTargetFrameRate() /*-{ 
    return this.targetFrameRate
  }-*/;
    
  public final native void setUseDefaultRenderLoop(boolean useDefaultRenderLoop) /*-{ 
    this.useDefaultRenderLoop = useDefaultRenderLoop
  }-*/;
    
  public final native boolean getUseDefaultRenderLoop() /*-{ 
    return this.useDefaultRenderLoop
  }-*/;
    
  public final native void setResolutionScale(boolean resolutionScale) /*-{ 
    this.resolutionScale = resolutionScale
  }-*/;
    
  public final native boolean getResolutionScale() /*-{ 
    return this.resolutionScale
  }-*/;
    
  public final native DataSourceCollection getDataSources() /*-{ 
    return this.dataSources
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
    
    public native Options clock(Clock clock) /*-{ 
      this.clock = clock
      return this
    }-*/;
    
    public native Options mapProjection(MapProjection mapProjection) /*-{ 
      this.mapProjection = mapProjection
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
    
    public native Options scene3DOnly(boolean scene3DOnly) /*-{ 
      this.scene3DOnly = scene3DOnly
      return this
    }-*/;
    
    public native Options skyBox(SkyBox skyBox) /*-{
      this.skyBox = skyBox;
      return this;
    }-*/;

    public native Options contextOptions(Undocumented contextOptions) /*-{
      this.contextOptions = contextOptions;
      return this;
    }-*/;

    public native Options animation(boolean animation) /*-{
      this.animation = animation;
      return this;
    }-*/;

    public native Options baseLayerPicker(boolean baseLayerPicker) /*-{
      this.baseLayerPicker = baseLayerPicker;
      return this;
    }-*/;

    public native Options fullscreenButton(boolean fullscreenButton) /*-{
      this.fullscreenButton = fullscreenButton;
      return this;
    }-*/;

    public native Options geocoder(boolean geocoder) /*-{
      this.geocoder = geocoder;
      return this;
    }-*/;

    public native Options homeButton(boolean homeButton) /*-{
      this.homeButton = homeButton;
      return this;
    }-*/;

    public native Options infoBox(boolean infoBox) /*-{
      this.infoBox = infoBox;
      return this;
    }-*/;

    public native Options sceneModePicker(boolean sceneModePicker) /*-{
      this.sceneModePicker = sceneModePicker;
      return this;
    }-*/;

    public native Options selectionIndicator(boolean selectionIndicator) /*-{
      this.selectionIndicator = selectionIndicator;
      return this;
    }-*/;

    public native Options timeline(boolean timeline) /*-{
      this.timeline = timeline;
      return this;
    }-*/;

    public native Options navigationHelpButton(boolean navigationHelpButton) /*-{
      this.navigationHelpButton = navigationHelpButton;
      return this;
    }-*/;

    public native Options navigationInstructionsInitiallyVisible(boolean navigationInstructionsInitiallyVisible) /*-{
      this.navigationInstructionsInitiallyVisible = navigationInstructionsInitiallyVisible;
      return this;
    }-*/;
    
    public native Options selectedImageryProviderViewModel(ProviderViewModel selectedImageryProviderViewModel) /*-{
      this.selectedImageryProviderViewModel = selectedImageryProviderViewModel;
      return this;
    }-*/;
    
    public native Options imageryProviderViewModels(JsArray<ProviderViewModel> imageryProviderViewModels) /*-{
      this.imageryProviderViewModels = imageryProviderViewModels;
      return this;
    }-*/;
    
    public native Options selectedTerrainProviderViewModel(ProviderViewModel selectedTerrainProviderViewModel) /*-{
      this.selectedTerrainProviderViewModel = selectedTerrainProviderViewModel;
      return this;
    }-*/;
    
    public native Options terrainProviderViewModels(JsArray<ProviderViewModel> terrainProviderViewModels) /*-{
      this.terrainProviderViewModels = terrainProviderViewModels;
      return this;
    }-*/;
    
    public native Options fullscreenElement(Element fullscreenElement) /*-{
      this.fullscreenElement = fullscreenElement;
      return this;
    }-*/;
    
    public native Options automaticallyTrackDataSourceClocks(boolean automaticallyTrackDataSourceClocks) /*-{
      this.automaticallyTrackDataSourceClocks = automaticallyTrackDataSourceClocks;
      return this;
    }-*/;
    
    public native Options dataSources(DataSourceCollection dataSources) /*-{
      this.dataSources = dataSources;
      return this;
    }-*/;
  }
}
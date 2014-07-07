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
    return CesiumWidget.create(element, CesiumWidgetOptions.create());
  }
  
  public final static CesiumWidget create(Element element, CesiumWidgetOptions options) {
    
    CesiumWidget cesiumWidget = nativeCreate(element, options);
    
    // THE FOLLOWING HACK OVERCOMES ISSUES INTEGRATING WITH GWT, WHICH SEEMS
		// TO MASK CERTAIN MOUSE EVENTS THAT CESIUM'S DEFAULT HANDLERS RELY ON.
		// CESIUM DOES NOT PROVIDE A SIMPLE WAY TO OVERCOME THIS ISSUE.
    Element canvas = cesiumWidget.getCanvas();
    canvas.setPropertyBoolean("disableRootEvents", true);
    
    return cesiumWidget;
  }
    
  private final native static CesiumWidget nativeCreate(Element element, CesiumWidgetOptions options) /*-{
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
  
	public final native void setBillboardCollection(BillboardCollection billboardCollection) /*-{
    this.billboardCollection = billboardCollection;
	}-*/;

	public final native BillboardCollection getBillboardCollection() /*-{
    return this.billboardCollection;
	}-*/;

	public final native void setTextureAtlas(TextureAtlas textureAtlas) /*-{
    this.textureAtlas = textureAtlas;
	}-*/;
  
	public final native TextureAtlas getTextureAtlas() /*-{
    return this.textureAtlas;
	}-*/;
}
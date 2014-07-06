package com.harmonia.cesiumjs.gwt;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public final class CesiumWidget extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected CesiumWidget(){}

  public final static CesiumWidget create(Element element) {
    return CesiumWidget.create(element, CesiumWidgetOptions.create());
  }
  
  public final native static CesiumWidget create(Element element, CesiumWidgetOptions options) /*-{
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

//  public final native void overrideScreenSpaceEventHandler(ScreenSpaceEventHandler newHandler) /*-{
//    this._screenSpaceEventHandler = newHandler;
//  }-*/;

	public native void resize() /*-{
    this.resize();
	}-*/;

	public native void render() /*-{
    this.render();
	}-*/;
  
  public final native void pickCartographicPosition() /*-{
    
    var cesiumWidget = this
    
    var otherLoaders = cesiumWidget.onload;
    
    if (otherLoaders != null) {
      otherLoaders();
    }
        
    var scene = cesiumWidget.scene;
    var ellipsoid = scene.globe.ellipsoid;
      
    var scaleFactor = 1;
    var pixelRatio = 1;
    if (typeof $wnd.devicePixelRatio !== 'undefined') {
      pixelRatio = $wnd.devicePixelRatio;
      scaleFactor *= pixelRatio;
    }
      
    var fontPixels = 18;
  
    var labels = new Cesium.LabelCollection();
    label = labels.add({
      font : (fontPixels*scaleFactor)+'px sans-serif'
    });
    scene.primitives.add(labels);
  
    // Mouse over the globe to see the cartographic position
    handler = new Cesium.ScreenSpaceEventHandler(scene.canvas);
      
    handler.setInputAction(function(movement) {
        var cartesian = scene.camera.pickEllipsoid(movement.endPosition, ellipsoid);
        if (cartesian) {
            var cartographic = ellipsoid.cartesianToCartographic(cartesian);
            label.show = true;
            label.text = '(' + Cesium.Math.toDegrees(cartographic.latitude).toFixed(2) + ', ' + Cesium.Math.toDegrees(cartographic.longitude).toFixed(2) + ')';
            label.position = cartesian;
        } else {
            label.text = '';
        }
    }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
  }-*/;
  
	public native void setBillboardCollection(BillboardCollection billboardCollection) /*-{
    this.billboardCollection = billboardCollection;
	}-*/;

	public native BillboardCollection getBillboardCollection() /*-{
    return this.billboardCollection;
	}-*/;

	public native void setTextureAtlas(TextureAtlas textureAtlas) /*-{
    this.textureAtlas = textureAtlas;
	}-*/;
  
	public native TextureAtlas getTextureAtlas() /*-{
    return this.textureAtlas;
	}-*/;
}
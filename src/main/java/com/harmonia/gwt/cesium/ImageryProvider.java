package com.harmonia.gwt.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public final class ImageryProvider extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected ImageryProvider(){}

  public final static ImageryProvider createBingMapsImageryProvider() {
    return createBingMapsImageryProvider(BingMapsImageryProviderOptions.create());
  }
  
  public final native static ImageryProvider createBingMapsImageryProvider(BingMapsImageryProviderOptions options) /*-{
    return new Cesium.BingMapsImageryProvider(options);
  }-*/;
}
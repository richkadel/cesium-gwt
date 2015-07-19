package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.CanvasElement;

public final class PinBuilder extends JavaScriptObject {

	protected PinBuilder() {}
	
	public final native static PinBuilder create() /*-{
      return new Cesium.PinBuilder()
    }-*/;
	
	public final native CanvasElement fromColor(Color color, int size) /*-{
      return this.fromColor(color, size)
    }-*/;
	
	public final native CanvasElement fromText(String text, Color color, int size) /*-{
      return this.fromText(text, color, size)
    }-*/;
	 
	public final native CanvasElement fromUrl(String url, Color color, int size) /*-{
      return this.fromUrl(url, color, size)
    }-*/;
	
	public final native CanvasElement fromMakiIconId(int id, Color color, int size)/*-{
      return this.fromMakiIconId(id, color, size)
    }-*/;
	
}

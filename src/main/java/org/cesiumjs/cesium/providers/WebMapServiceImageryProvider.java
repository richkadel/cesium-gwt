package org.cesiumjs.cesium.providers;

import org.cesiumjs.cesium.Rectangle;
import org.cesiumjs.cesium.Undocumented;

import com.google.gwt.core.client.JavaScriptObject;

public final class WebMapServiceImageryProvider extends JavaScriptObject
{
	protected WebMapServiceImageryProvider() {}
	
	public static native WebMapServiceImageryProvider create(WebMapServiceOptions wmso) /*-{
		return new Cesium.WebMapServiceImageryProvider(wmso);
	}-*/;
	
	public native Rectangle getRectangle() /*-{
		return this.rectangle;
	}-*/;
	
	public native String getLayers() /*-{
		return this.layers;
	}-*/;
	
	public native double getMaximumLevel() /*-{
		return this.maximumLevel;
	}-*/;

	public native double getMinimumLevel() /*-{
		return this.minimumLevel;
	}-*/;

	public native double getTileWidth() /*-{
		return this.tileWidth;
	}-*/;

	public native double getTileHeight() /*-{
		return this.tileHeight;
	}-*/;
	
	public native String getUrl() /*-{
		return this.url;
	}-*/;

	
	
	
	public final static class WebMapServiceOptions extends JavaScriptObject
	{
		protected WebMapServiceOptions() {}
		
		public static native WebMapServiceOptions create() /*-{
			return {}
		}-*/;
		
		public native WebMapServiceOptions url(String url) /*-{
			this.url = url;
			return this;
		}-*/;
		
		public native WebMapServiceOptions layers(String layers) /*-{
			this.layers = layers;
			return this;
		}-*/;
		
		public native WebMapServiceOptions parameters(Undocumented parameters) /*-{
			this.parameters = parameters;
			return this;
		}-*/;

		
		public native WebMapServiceOptions rectangle(Rectangle rectangle) /*-{
			this.rectangle = rectangle;
			return this;
		}-*/;
		
		
		public native WebMapServiceOptions maximumLevel(double maximumLevel) /*-{
			this.maximumLevel = maximumLevel;
			return this;
		}-*/;

	}
}

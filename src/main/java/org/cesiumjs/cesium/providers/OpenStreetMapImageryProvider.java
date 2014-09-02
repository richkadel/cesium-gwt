package org.cesiumjs.cesium.providers;

import org.cesiumjs.cesium.Rectangle;

import com.google.gwt.core.client.JavaScriptObject;

public final class OpenStreetMapImageryProvider extends JavaScriptObject
{
	protected OpenStreetMapImageryProvider() {}
	
	public static native OpenStreetMapImageryProvider create(OpenStreetMapServiceOptions osmso) /*-{
		return new Cesium.OpenStreetMapServiceImageryProvider(osmso);
	}-*/;
	
	public native Rectangle getRectangle() /*-{
		return this.rectangle;
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

	
	
	
	public final static class OpenStreetMapServiceOptions extends JavaScriptObject
	{
		protected OpenStreetMapServiceOptions() {}
		
		public static native OpenStreetMapServiceOptions create() /*-{
			return {}
		}-*/;
		
		public native OpenStreetMapServiceOptions url(String url) /*-{
			this.url = url;
			return this;
		}-*/;		

		public native OpenStreetMapServiceOptions fileExtension(String fileExtension) /*-{
			this.fileExtension = fileExtension;
			return this;
		}-*/;
		
		public native OpenStreetMapServiceOptions layers(String layers) /*-{
			this.layers = layers;
			return this;
		}-*/;
		
		public native OpenStreetMapServiceOptions rectangle(Rectangle rectangle) /*-{
			this.rectangle = rectangle;
			return this;
		}-*/;		
		
		public native OpenStreetMapServiceOptions maximumLevel(double maximumLevel) /*-{
			this.maximumLevel = maximumLevel;
			return this;
		}-*/;

	}
}

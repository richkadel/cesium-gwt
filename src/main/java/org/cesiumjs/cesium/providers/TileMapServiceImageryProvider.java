package org.cesiumjs.cesium.providers;

import org.cesiumjs.cesium.Rectangle;

import com.google.gwt.core.client.JavaScriptObject;

public final class TileMapServiceImageryProvider extends JavaScriptObject
{
	protected TileMapServiceImageryProvider() {}
	
	public static final String CESIUM_NATURAL_EARTH_URL = "//cesiumjs.org/tilesets/imagery/naturalearthii";
	public static final String CESIUM_BLACK_MARBLE_URL = "//cesiumjs.org/tilesets/imagery/blackmarble";
	
	public static native TileMapServiceImageryProvider create(TileMapServiceOptions tmso) /*-{
		return new Cesium.TileMapServiceImageryProvider(tmso);
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

	
	
	
	public final static class TileMapServiceOptions extends JavaScriptObject
	{
		protected TileMapServiceOptions() {}
		
		public static native TileMapServiceOptions create() /*-{
			return {}
		}-*/;
		
		public native TileMapServiceOptions url(String url) /*-{
			this.url = url;
			return this;
		}-*/;
		
		public native TileMapServiceOptions fileExtension(String fileExtension) /*-{
			this.fileExtension = fileExtension;
			return this;
		}-*/;
		
		public native TileMapServiceOptions rectangle(Rectangle rectangle) /*-{
			this.rectangle = rectangle;
			return this;
		}-*/;
		
		public native TileMapServiceOptions minimumLevel(double minimumLevel) /*-{
			this.minimumLevel = minimumLevel;
			return this;
		}-*/;
		
		public native TileMapServiceOptions maximumLevel(double maximumLevel) /*-{
			this.maximumLevel = maximumLevel;
			return this;
		}-*/;
		
		public native TileMapServiceOptions tileWidth(double tileWidth) /*-{
			this.tileWidth = tileWidth;
			return this;
		}-*/;
		
		public native TileMapServiceOptions tileHeight(double tileHeight) /*-{
			this.tileHeight = tileHeight;
			return this;
		}-*/;

		
		


	}
}

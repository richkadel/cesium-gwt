package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * @author richkadel
 *
 */
public final class ProviderViewModel extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected ProviderViewModel(){}
  
  public final native static ProviderViewModel create(Options options)/*-{
    return new Cesium.ProviderViewModel(options)
  }-*/;
  
  
  public static final class Options extends JavaScriptObject {
		
		protected Options(){}
		
		public static native Options create() /*-{
	      return {}
	    }-*/;
	    
	    public native Options name(String name) /*-{ 
	      this.name = name
	      return this
	    }-*/;
	    
	    public native Options toolTip(String tooltip) /*-{ 
	      this.tooltip = tooltip
	      return this
	    }-*/;
	    
	    public native Options iconUrl(String iconUrl) /*-{ 
	      this.iconUrl = iconUrl
	      return this
	    }-*/;
	    
	    public native Options creationFunction(ImageryProvider imageryProvider) /*-{ 
	      this.creationFunction = function() {
	        return imageryProvider
	      }
	      return this
	    }-*/;
	    
	    public native Options creationFunction(TerrainProvider terrainProvider) /*-{ 
	      this.creationFunction = function() {
	        return terrainProvider
	      }
	      return this
	    }-*/;
	    
	    public native Options creationFunction(JsArray<ImageryProvider> imageryProviders) /*-{ 
	      this.creationFunction = function() {
	        return imageryProviders
	      }
	      return this
	    }-*/;
	    

  }
  
  
}
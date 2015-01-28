package org.cesiumjs.cesium;


import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;

public final class BaseLayerPicker extends JavaScriptObject{
	
	protected BaseLayerPicker(){}
	
	public final native static BaseLayerPicker create(Element container, Options options)/*-{
      return new Cesium.BaseLayerPicker(container, options)
    }-*/;
	
	public native void destroy()/*-{
     this.destroy()
    }-*/;

	public native boolean isDestroyed()/*-{
      return this.isDestroyed()
    }-*/;
	
//	public native Element getContainer()/*-{
//      return this.container
//    }-*/;
// 
//	public native BaseLayerPickerViewModel getViewModel()/*-{
//      return this.viewModel
//    }-*/;
	
	public static final class Options extends JavaScriptObject {
		
		protected Options(){}
		
		public static native Options create() /*-{
		  return {}
		}-*/;
		
		public native Options globe(Globe globe) /*-{
		  this.globe = globe
		  return this
		}-*/;
		
	    public native Options imagerProviderViewModels(JsArray<ProviderViewModel> imageryProviderViewModels) /*-{ 
	      this.imageryProviderViewModels = imageryProviderViewModels
	      return this;
	    }-*/;
	    
	    public native Options selectedImageryProviderViewModel(ProviderViewModel selectedImageryProviderViewModel) /*-{ 
	      this.selectedImageryProviderViewModel = selectedImageryProviderViewModel
	      return this;
	    }-*/;
	    
	    public native Options terrainProviderViewModels(JsArray<ProviderViewModel> terrainProviderViewModels) /*-{ 
	      this.terrainProviderViewModels = terrainProviderViewModels
	      return this;
	    }-*/;
	    
	    public native Options selectedTerrainProviderViewModel(ProviderViewModel selectedTerrainProviderViewModel) /*-{ 
	      this.selectedTerrainProviderViewModel = selectedTerrainProviderViewModel
	      return this;
	    }-*/;
		
	}

}

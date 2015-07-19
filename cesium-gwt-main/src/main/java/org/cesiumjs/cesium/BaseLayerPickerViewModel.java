package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public final class BaseLayerPickerViewModel extends JavaScriptObject {

	protected BaseLayerPickerViewModel() {}

	public final native static BaseLayerPickerViewModel create(Options options)/*-{
      return new Cesium.BaseLayerPickerViewModel(options)
    }-*/;
	
	public native String getButtonImageUrl()/*-{
      return this.buttonImageUrl
    }-*/;
	
	public native void setButtonImageUrl(String buttonImageUrl)/*-{
      this.buttonImageUrl = buttonImageUrl
    }-*/;
	
	public native String getButtonTooltip()/*-{
      return this.buttonTooltip
    }-*/;
	
	public native void setButtonTooltip(String buttonToolTip)/*-{
      this.buttonTooltip = buttonToolTip
    }-*/;
	
	public native boolean getDropDownVisible()/*-{
      return this.dropDownVisible
    }-*/;
	
	public native void setDropDownVisible(boolean dropDownVisible)/*-{
      this.dropDownVisible = dropDownVisible
    }-*/;
	
	public native Globe getGlobe()/*-{
      return this.globe
    }-*/;
	
	public native void setGlobe(Globe globe)/*-{
      this.globe = globe
    }-*/; 
	
	public native JsArray<ProviderViewModel> getImageryProviderViewModels()/*-{
      return this.imageryProviderViewModels
    }-*/;
	
	public native void setImageryProviderViewModels(JsArray<ProviderViewModel> imageryProviderViewModels)/*-{
      this.imageryProviderViewModels = imagerProviderViewModels
    }-*/;
	
	public native ProviderViewModel getSelecetdImagery()/*-{
      return this.selectedImagery
    }-*/;
	
	public native void setSelecetdImagery(ProviderViewModel selectedImagery)/*-{
      this.selectedImagery = selectedImagery
    }-*/;
	
	public native JsArray<ProviderViewModel> getTerrainProviderViewModels()/*-{
      return this.terrainProviderViewModels
    }-*/;
	
	public native void getTerrainProviderViewModels(JsArray<ProviderViewModel> terrainProviderViewModels)/*-{
      this.terrainProviderViewModels = terrainProviderViewModels
    }-*/;
	
//	public native Command getToggleDropDown()/*-{
//      return this.toggleDropDown;
//    }-*/;
	
	
	public static final class Options extends JavaScriptObject {

		protected Options() {
		}
		
		public static native Options create() /*-{
	      return {}
	    }-*/;
	    
	    public native Options globe(Globe globe) /*-{ 
	      this.globe = globe
	      return this
	    }-*/;
	    
	    
	    public native Options imagerProviderViewModels(JsArray<ProviderViewModel> imageryProviderViewModels) /*-{ 
	      this.imageryProviderViewModels = imageryProviderViewModels
	      return this
	    }-*/;
	    
	    public native Options selectedImageryProviderViewModel(ProviderViewModel selectedImageryProviderViewModel) /*-{ 
	      this.selectedImageryProviderViewModel =selectedImageryProviderViewModel
	      return this
	    }-*/;
	    
	    public native Options terrainProviderViewModels(JsArray<ProviderViewModel> terrainProviderViewModels) /*-{ 
	      this.terrainProviderViewModels = terrainProviderViewModels
	      return this
	    }-*/;
	    
	    public native Options selectedTerrainProviderViewModel(ProviderViewModel selectedTerrainProviderViewModel) /*-{ 
	      this.selectedTerrainProviderViewModel = selectedTerrainProviderViewModel
	      return this
	    }-*/;
		

	}
}

package com.harmonia.gwt.cesium;

import com.google.gwt.core.client.Callback;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.SimplePanel;

public abstract class CesiumWidgetPanel extends SimplePanel {
  
	private CesiumConfiguration configuration;
	private CesiumWidget cesiumWidget;

	public CesiumWidgetPanel(CesiumConfiguration configuration) {
    this.configuration = configuration;
		
    addAttachHandler(new Handler() {

			public void onAttachOrDetach(AttachEvent event) {
        if (event.isAttached()) {
        	injectCesium(getElement());
        }
			}
    });
	}

	/**
	 * @param panel
	 */
	protected void injectCesium(final Element element) {
	  
		Document document = element.getOwnerDocument();
	    
	  Cesium.initialize(
			configuration.getCesiumPath(), 
			document,
	    new Callback<Void,Exception>() {
	        
				public void onSuccess(Void result) {
	        cesiumWidget = createCesiumWidget(element);
	      }
	        
	      public void onFailure(Exception reason) {
	        Window.alert("Error: Failed to inject Cesium scripts from "+configuration.getCesiumPath());
	      }
	    });
	}

	/**
   * This abstract method is invoked only after the Cesium environment has been initialized.
	 * @param element
	 * @return
	 */
	public abstract CesiumWidget createCesiumWidget(Element element);

	/**
	 * @return the configuration
	 */
	public CesiumConfiguration getConfiguration() {
		return configuration;
	}

	/**
	 * @return the cesiumWidget
	 */
	public CesiumWidget getCesiumWidget() {
		return cesiumWidget;
	}
}

package org.cesiumjs.cesium;

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
  private Callback<Void,Exception> initCallback;
  private Document document;

  public CesiumWidgetPanel(CesiumConfiguration configuration) {
    this.configuration = configuration;
    
    addAttachHandler(new Handler() {

      public void onAttachOrDetach(AttachEvent event) {
        if (event.isAttached()) {
          injectCesium(getElement());
        }
        else {
        	removeCesium();
        }
      }
    });
  }

  /**
   * @param panel
   */
  protected void injectCesium(final Element element) {
    
    this.document = element.getOwnerDocument();
    this.initCallback = new Callback<Void,Exception>() {
        
      public void onSuccess(Void result) {
        cesiumWidget = createCesiumWidget(element);
      }
        
      public void onFailure(Exception reason) {
        Window.alert("Error: Failed to inject Cesium scripts from "+configuration.getCesiumPath());
      }
    };

    Cesium.initialize(
      configuration.getCesiumPath(), 
      this.document,
      this.initCallback);
  }

  protected void removeCesium() {
	  Cesium.destroy(this.document, this.initCallback);
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

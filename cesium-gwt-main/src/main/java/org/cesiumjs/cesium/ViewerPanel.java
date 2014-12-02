package org.cesiumjs.cesium;

import com.google.gwt.core.client.Callback;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.SimplePanel;

public abstract class ViewerPanel extends SimplePanel {
  
  private CesiumConfiguration configuration;
  private Viewer viewer;

  public ViewerPanel(final CesiumConfiguration configuration) {
    this.configuration = configuration;
    
    Cesium.initialize(
      configuration, 
      this,
      new Callback<Void,Exception>() {
          
        public void onSuccess(Void result) {
          viewer = createViewer(getElement());
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
  public abstract Viewer createViewer(Element element);

  /**
   * @return the configuration
   */
  public CesiumConfiguration getConfiguration() {
    return configuration;
  }

  /**
   * @return the viewer
   */
  public Viewer getViewer() {
    return viewer;
  }
}

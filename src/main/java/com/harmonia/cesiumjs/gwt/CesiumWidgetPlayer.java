package com.harmonia.cesiumjs.gwt;

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.animation.client.AnimationScheduler.AnimationCallback;
import com.google.gwt.animation.client.AnimationScheduler.AnimationHandle;
import com.google.gwt.core.client.Callback;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.LinkElement;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.SimplePanel;

public class CesiumWidgetPlayer {

	private CesiumWidget cesiumWidget;
  private AnimationHandle loop;
	private SimplePanel panel;
  private static double lastTime = 0.0;

	/**
	 * 
	 */
	public CesiumWidgetPlayer(final SimplePanel panel) {
    this.panel = panel;
    
    panel.addAttachHandler(new Handler() {

			public void onAttachOrDetach(AttachEvent event) {
        if (event.isAttached()) {
        	injectCesium(panel.getElement().getOwnerDocument());
        }
			}
    	
    });
	}

	/**
	 * @param panel
	 */
	private void injectCesium(Document document) {
		Style style = panel.getElement().getStyle();
    style.setPosition(Position.RELATIVE);
    style.setTop(0, Unit.PX);
    style.setLeft(0, Unit.PX);
    style.setHeight(100, Unit.PCT);
    style.setWidth(100, Unit.PCT);
    style.setMargin(0, Unit.PX);
    style.setPadding(0, Unit.PX);
    style.setOverflow(Overflow.HIDDEN);
    style.setProperty("fontFamily", "sans-serif");
      
    LinkElement link = Document.get().createLinkElement();
    link.setRel("stylesheet");
    
    final String cesiumCss = CesiumInitializer.getCesiumPath()+"Widgets/widgets.css";
    link.setHref(cesiumCss);
    document.getElementsByTagName("head").getItem(0).appendChild(link);
      
    Cesium.initialize(document,
      new Callback<Void,Exception>() {
          
				public void onSuccess(Void result) {
          createCesiumWidget();
        }
          
        public void onFailure(Exception reason) {
          Window.alert("Error: Failed to inject Cesium script "+cesiumCss);
        }
      });
	}

	private void createCesiumWidget() {
		// THIS IS RICH KADEL'S KEY FOR TEMPORARY USE
		String bingMapsApiKey = "AqzJdW90KqFDzl_NFQuwSUOkL2eMs16fm-jb0vM0ggWdZV2sMtxiPPaAzmMHPU-H";
		
		ImageryProvider bingMaps = ImageryProvider.createBingMapsImageryProvider(
				BingMapsImageryProviderOptions.create()
					.setKey(bingMapsApiKey)
		      .setMapStyleAerialWithLabels()
		);
		
		cesiumWidget = CesiumWidget.create(panel.getElement(),
				CesiumWidgetOptions.create()
					.setImageryProvider(bingMaps)
					.setTerrainProvider(TerrainProvider.createCesiumTerrainProvider())
		      .setUseDefaultRenderLoop(false)
		);
    
    // THE FOLLOWING HACK OVERCOMES ISSUES INTEGRATING WITH GWT, WHICH SEEMS
		// TO MASK CERTAIN MOUSE EVENTS THAT CESIUM'S DEFAULT HANDLERS RELY ON.
		// CESIUM DOES NOT PROVIDE A SIMPLE WAY TO OVERCOME THIS ISSUE.
    Element canvas = cesiumWidget.getCanvas();
    canvas.setPropertyBoolean("disableRootEvents", true);
    Scene scene = cesiumWidget.getScene();
    ScreenSpaceCameraController screenSpaceCameraController = ScreenSpaceCameraController.create(canvas, scene.getCamera());
    scene.overrideScreenSpaceCameraController(screenSpaceCameraController);
    
    cesiumWidget.pickCartographicPosition();
	}

	/**
	 * @return the cesiumWidget
	 */
	public CesiumWidget getCesiumWidget() {
		return cesiumWidget;
	}
  
	public void play() {
    if (loop != null) {
    	return;
    }
    
    final AnimationScheduler scheduler = AnimationScheduler.get();
    
    loop = scheduler.requestAnimationFrame(new AnimationCallback() {
      
			public void execute(double timestamp) {
        //if ((timestamp - lastTime) > 100.0) { // I suggest doing something like this when "idle" (not moving the mouse or wheel)
          lastTime = timestamp;
          if (cesiumWidget != null) {
            cesiumWidget.resize();
            cesiumWidget.render();
          }
        //}
        loop = scheduler.requestAnimationFrame(this);
			}
            	
    });
	}
  
	public void pause() {
    if (loop != null) {
    	loop.cancel();
    	loop = null;
    }
	}
}

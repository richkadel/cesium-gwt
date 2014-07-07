package com.harmonia.gwt.cesium.samples;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.harmonia.gwt.cesium.Animation;
import com.harmonia.gwt.cesium.Camera;
import com.harmonia.gwt.cesium.CameraFlightCartographicOptions;
import com.harmonia.gwt.cesium.CameraFlightPath;
import com.harmonia.gwt.cesium.Cartesian3;
import com.harmonia.gwt.cesium.Cartographic;
import com.harmonia.gwt.cesium.CesiumConfiguration;
import com.harmonia.gwt.cesium.CesiumWidget;
import com.harmonia.gwt.cesium.CesiumWidgetPanel;
import com.harmonia.gwt.cesium.Scene;
import com.harmonia.gwt.js.JsFunctionCallback;

public class ZoomToCesium extends DockLayoutPanel {
  
  Camera flyingTo;
	protected CesiumWidget cesiumWidget;

	public ZoomToCesium(CesiumConfiguration configuration) {
    super(Unit.EM);
    
    
    FlowPanel buttons = new FlowPanel();
    addSouth(buttons, 2);
    
    Button zoom = new Button("Zoom");
    zoom.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
        flyToSanDiego();
			}
    });
    buttons.add(zoom);
    
    CesiumWidgetPanel cesiumPanel = new CesiumWidgetPanel(configuration) {
			@Override
			public CesiumWidget createCesiumWidget(Element element) {
    		return cesiumWidget = CesiumWidget.create(element);
			}
    };
    add(cesiumPanel);
	}
  
  public void flyToSanDiego() {
    // remember, lon then lat
    flyTo(Cartographic.fromDegrees(-117.16, 32.71, 11000.0));
  }
  
        
  public void flyTo(Cartographic point) {
    Camera camera = Camera.create(cesiumWidget.getScene());
    camera.setPosition(cartographicToCartesian(point));
    camera.setDefaultLookDirection(true);
        
  	if (flyingTo != null) {
  		if (isSameDestination(flyingTo, camera)) {
    		return;
  		} else {
  			// I don't know how to stop the flight, but it should be fine
  			// to add a new one, and I believe cesium will immediatly transition
  			// to the new destination rather than continuing to first destination
  			// before moving to next
  		}
  	}
        
  	flyingTo = camera;
        
    Cartographic destination = cartesianToCartographic(camera.getPosition());
            
    Scene scene = cesiumWidget.getScene();
        
    Animation flight = CameraFlightPath.createAnimationCartographic(
			scene,
			CameraFlightCartographicOptions.create()
			  .setDestination(destination)
        .setDirection(camera.getDirection())
        .setUp(camera.getUp())
        .onComplete(new JsFunctionCallback() {
          public void callback() {
            flyingTo = null;
          }
        })
	  );
        
// IT DIES BEFORE HERE BECAUSE I TRIED COMMENTING OUT BELOW AND IT STILL LOCKED OUT MY ABILITY TO CHANGE MAP LOC
    scene.getAnimations().add(flight);
  }
  
	public Cartesian3 cartographicToCartesian(Cartographic point) {
    return cesiumWidget.getScene().getGlobe().getEllipsoid().cartographicToCartesian(point);
	}
  
	public Cartographic cartesianToCartographic(Cartesian3 cartesian) {
    return cesiumWidget.getScene().getGlobe().getEllipsoid().cartesianToCartographic(cartesian);
	}
  
	private boolean isSameDestination(Camera left, Camera right) {
    if (left.getPosition().equals(right.getPosition())) {
      if (left.getDirection() == null) {
      	if (right.getDirection() == null) {
      		return true;
      	}
      } else if (right.getDirection() != null && left.getDirection().equals(right.getDirection())) {
      	return true;
      }
    }
    return false;
	}
}

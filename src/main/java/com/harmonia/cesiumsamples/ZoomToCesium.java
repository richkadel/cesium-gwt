package com.harmonia.cesiumsamples;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.harmonia.gwt.cesium.Animation;
import com.harmonia.gwt.cesium.BillboardCollection;
import com.harmonia.gwt.cesium.BillboardOptions;
import com.harmonia.gwt.cesium.BoundingRectangle;
import com.harmonia.gwt.cesium.Camera;
import com.harmonia.gwt.cesium.CameraFlightCartographicOptions;
import com.harmonia.gwt.cesium.CameraFlightPath;
import com.harmonia.gwt.cesium.Cartesian2;
import com.harmonia.gwt.cesium.Cartesian3;
import com.harmonia.gwt.cesium.Cartographic;
import com.harmonia.gwt.cesium.CesiumConfiguration;
import com.harmonia.gwt.cesium.CesiumWidget;
import com.harmonia.gwt.cesium.CesiumWidgetPanel;
import com.harmonia.gwt.cesium.HorizontalOrigin;
import com.harmonia.gwt.cesium.LabelCollection;
import com.harmonia.gwt.cesium.LabelOptions;
import com.harmonia.gwt.cesium.Scene;
import com.harmonia.gwt.cesium.Texture;
import com.harmonia.gwt.cesium.TextureAtlas;
import com.harmonia.gwt.cesium.TextureAtlasOptions;
import com.harmonia.gwt.cesium.VerticalOrigin;
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
    addIconAndLabel(-117.16, 32.71, 500, "Somewhere near San Diego", 40);
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
  
  public void addIconAndLabel(double lonDeg, double latDeg, double heightM, final String label, final int imageIndex) {
    
    final Scene scene = cesiumWidget.getScene();
    
    final Cartographic point = Cartographic.fromDegrees(lonDeg, latDeg, heightM);

    getBillboards(new BillboardsReadyHandler() {
      @Override
  		public void billboardsReady(BillboardCollection billboardCollection,
  				TextureAtlas textureAtlas) {
          
        double scaleFactor = 0.75;
          
        double pixelRatio = getDevicePixelRatio();
        scaleFactor *= pixelRatio;
        
        billboardCollection.add(BillboardOptions.create()
        		.setPosition(cartographicToCartesian(point))
        		.setImageIndex(imageIndex)
        		.setScale(scaleFactor));
          
        //* ******** SHOULD THIS BE DONE ONLY ONCE WHEN GETTING BILLBOARDS? ******** *
        scene.getPrimitives().add(billboardCollection);
          
        Texture texture = textureAtlas.getTexture();
        BoundingRectangle subRegionRect = textureAtlas.getTextureCoordinates().get(imageIndex);
        double iconWidth = texture.getWidth() * subRegionRect.getWidth();
        double iconHeight = texture.getHeight() * subRegionRect.getHeight();
          
          
        int fontPixels = 16;
            
        //* ******** SHOULD I BE REUSING THE SAME LABEL COLLECTION? ****** *
        LabelCollection labels = LabelCollection.create();
        labels.add(LabelOptions.create()
          .setPosition(cartographicToCartesian(point))
          .setText(label)
          .setFont((fontPixels*scaleFactor)+"px sans-serif")
          .setHorizontalOrigin(HorizontalOrigin.LEFT())
          .setVerticalOrigin(VerticalOrigin.BOTTOM())
          .setPixelOffset(Cartesian2.create(
            (iconWidth/2)*scaleFactor,
          	(iconHeight/2)*scaleFactor))
          //pixelOffsetScaleByDistance : new Cesium.NearFarScalar(1.5e2, 3.0, 1.5e7, 0.5)
        );
        scene.getPrimitives().add(labels);
      }
    });
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
  
  private interface BillboardsReadyHandler {
		public void billboardsReady(BillboardCollection billboardCollection,
				TextureAtlas textureAtlas);
	}
  
  private void getBillboards(final BillboardsReadyHandler billboardsReadyHandler) {
    
    final Scene scene = cesiumWidget.getScene();
      
    if (cesiumWidget.getBillboardCollection() != null) {
        billboardsReadyHandler.billboardsReady(cesiumWidget.getBillboardCollection(), cesiumWidget.getTextureAtlas());
    } else {
      final Image image = new Image();
      image.addLoadHandler(new LoadHandler() {
				@Override
				public void onLoad(LoadEvent event) {
            
          if (cesiumWidget.getBillboardCollection() == null) {
// I DON'T KNOW IF I REALLY WANT TO SET THE BILLBOARD COLLECTION AND TEXTURE ATLAS ON
// CesiumWidget.  I THINK I ORIGINALLY DID IT FOR CONVENIENCE, BUT MAYBE I SHOULD USE
// an external class INSTEAD NOW?
            cesiumWidget.setBillboardCollection(BillboardCollection.create());
            cesiumWidget.setTextureAtlas(scene.createTextureAtlas(
              TextureAtlasOptions.create().setBorderWidthInPixels(0)));
          }
            
          BillboardCollection billboardCollection = cesiumWidget.getBillboardCollection();
          TextureAtlas textureAtlas = cesiumWidget.getTextureAtlas();
            
            // Break one image full of markers into many subregions.
            // Dots, small to large, imageIndex 1 to 6
          int[][] sprites = {
          		// array of 4-double sub-arrays to be converted to 
          		// JavaScript BoundingRectangle objects 
          		// (x, y, width, height -- in that order)
            { 91,  11,  6,  6 },
            { 81,  9,   10, 10 },
            { 67,  7,   14, 14 },
            { 49,  5,   18, 18 },
            { 27,  3,   22, 22 },
            { 1,   1,   26, 26 },
            // Up-Triangles, small to large, imageIndex 7 to 12
            { 91,  49,  6,  6 },
            { 81,  47,  10, 10 },
            { 67,  45,  14, 14 },
            { 49,  43,  18, 18 },
            { 27,  41,  22, 22 },
            { 1,   39,  26, 26 },
            // Down-Triangles, small to large, imageIndex 13 to 18
            { 31,  29,  6,  6 },
            { 37,  27,  10, 10 },
            { 47,  25,  14, 14 },
            { 61,  23,  18, 18 },
            { 79,  21,  22, 22 },
            { 101, 19,  26, 26 },
            // Up-Arrows, small to large, imageIndex 19 to 24
            { 91,  84,  6,  6 },
            { 81,  82,  10, 10 },
            { 67,  80,  14, 14 },
            { 49,  78,  18, 18 },
            { 27,  76,  22, 22 },
            { 1,   74,  26, 26 },
            // Down-Arrows, small to large, imageIndex 25 to 30
            { 31,  66,  6,  6 },
            { 37,  64,  10, 10 },
            { 47,  62,  14, 14 },
            { 61,  60,  18, 18 },
            { 79,  58,  22, 22 },
            { 101, 56,  26, 26 },
            // X's, small to large, imageIndex 31 to 36
            { 91,  111, 6,  6 },
            { 81,  109, 10, 10 },
            { 67,  107, 14, 14 },
            { 49,  105, 18, 18 },
            { 27,  103, 22, 22 },
            { 1,   101, 26, 26 },
            // Plus's, small to large, imageIndex 37 to 42
            { 92,  120, 5,  5 },
            { 109, 109, 10, 10 },
            { 107, 107, 14, 14 },
            { 105, 105, 18, 18 },
            { 103, 103, 22, 22 },
            { 101, 101, 26, 26 }
          };
              
          textureAtlas.addSubRegions(image, sprites);
        
          billboardCollection.setTextureAtlas(textureAtlas);
            
          billboardsReadyHandler.billboardsReady(cesiumWidget.getBillboardCollection(), cesiumWidget.getTextureAtlas());
				}
			});
      
      image.setVisible(false);
      RootPanel.get().add(image);
      image.setUrl("images/whiteShapes.png");
    }
  }
  
  private final native double getDevicePixelRatio() /*-{
    var pixelRatio = 1;
    if (typeof $wnd.devicePixelRatio !== 'undefined') {
      pixelRatio = $wnd.devicePixelRatio;
    }
    return pixelRatio
  }-*/;
}

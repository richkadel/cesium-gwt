package com.harmonia.cesiumsamples;

import org.cesiumjs.cesium.Billboard;
import org.cesiumjs.cesium.BillboardCollection;
import org.cesiumjs.cesium.BoundingRectangle;
import org.cesiumjs.cesium.Camera;
import org.cesiumjs.cesium.Cartesian2;
import org.cesiumjs.cesium.Cartesian3;
import org.cesiumjs.cesium.CesiumConfiguration;
import org.cesiumjs.cesium.CesiumWidget;
import org.cesiumjs.cesium.CesiumWidgetPanel;
import org.cesiumjs.cesium.Color;
import org.cesiumjs.cesium.HorizontalOrigin;
import org.cesiumjs.cesium.Label;
import org.cesiumjs.cesium.LabelCollection;
import org.cesiumjs.cesium.Scene;
import org.cesiumjs.cesium.VerticalOrigin;
import org.cesiumjs.js.JsFunctionCallback;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;

public class ZoomToCesium extends DockLayoutPanel {

  private static final String WHITE_SHAPES_IMAGE = "images/whiteShapes.png";
  
  private static final int[][] WHITE_SHAPES_BOUNDS = {
    // JavaScript BoundingRectangle objects
    // (x, y, width, height -- in that order)
    { 91, 11, 6, 6 }, // index 0
    { 81, 9, 10, 10 }, // index 1
    { 67, 7, 14, 14 }, // index 2
    { 49, 5, 18, 18 }, // index 3
    { 27, 3, 22, 22 }, // index 4
    { 1, 1, 26, 26 }, // index 5
    // Up-Triangles, small to large
    { 91, 49, 6, 6 }, // index 6
    { 81, 47, 10, 10 }, // index 7
    { 67, 45, 14, 14 }, // index 8
    { 49, 43, 18, 18 }, // index 9
    { 27, 41, 22, 22 }, // index 10
    { 1, 39, 26, 26 }, // index 11
    // Down-Triangles, small to large
    { 31, 29, 6, 6 }, // index 12
    { 37, 27, 10, 10 },// index 13
    { 47, 25, 14, 14 }, // index 14
    { 61, 23, 18, 18 }, // index 15
    { 79, 21, 22, 22 }, // index 16
    { 101, 19, 26, 26 }, // index 17
    // Up-Arrows, small to large, imageIndex 19 to 24
    { 91, 84, 6, 6 }, // index 18
    { 81, 82, 10, 10 }, // index 19
    { 67, 80, 14, 14 }, // index 20
    { 49, 78, 18, 18 }, // index 21
    { 27, 76, 22, 22 }, // index 22
    { 1, 74, 26, 26 }, // index 23
    // Down-Arrows, small to large, imageIndex 25 to 30
    { 31, 66, 6, 6 }, // index 24
    { 37, 64, 10, 10 }, // index 25
    { 47, 62, 14, 14 }, // index 26
    { 61, 60, 18, 18 }, // index 27
    { 79, 58, 22, 22 }, // index 28
    { 101, 56, 26, 26 }, // index 29
    // X's, small to large, imageIndex 31 to 36
    { 91, 111, 6, 6 }, // index 30
    { 81, 109, 10, 10 }, // index 31
    { 67, 107, 14, 14 }, // index 32
    { 49, 105, 18, 18 }, // index 33
    { 27, 103, 22, 22 }, // index 34
    { 1, 101, 26, 26 }, // index 35
    // Plus's, small to large, imageIndex 37 to 42
    { 92, 120, 5, 5 }, // index 36
    { 109, 109, 10, 10 }, // index 37
    { 107, 107, 14, 14 }, // index 38
    { 105, 105, 18, 18 }, // index 39
    { 103, 103, 22, 22 }, // index 40
    { 101, 101, 26, 26 },  // index 41
  };
  
  private CesiumWidget cesiumWidget;

  private BillboardCollection billboards;
  private LabelCollection labels;

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
    flyTo(Cartesian3.fromDegrees(-117.16, 32.71, 11000.0));
    addIconAndLabel(-117.16, 32.71, 500, "Somewhere near San Diego", 40);
  }

  public void flyTo(Cartesian3 destination) {
//    Camera camera = Camera.create(cesiumWidget.getScene());
//    camera.setPosition(point);
//    camera.setDefaultLookDirection(true);

//    Cartesian3 destination = camera.getPosition();

    Scene scene = cesiumWidget.getScene();

    scene.getCamera().flyTo(
      Camera.FlyToOptions.create()
        .destination(destination)
//        .complete(new JsFunctionCallback() {
//          public void callback() {
//            // done flying
//          }
//        })
    );
  }

  public void addIconAndLabel(double lonDeg, double latDeg, double heightM,
      final String labelString, final int imageIndex) {

    if (billboards == null) {
      billboards = BillboardCollection.create();
      labels = LabelCollection.create();
      
      Scene scene = cesiumWidget.getScene();
      scene.getPrimitives().add(billboards);
      scene.getPrimitives().add(labels);
    }

    final Cartesian3 point = Cartesian3
        .fromDegrees(lonDeg, latDeg, heightM);
    
    double scaleFactor = 0.75;

    int[] b = WHITE_SHAPES_BOUNDS[imageIndex];

    Billboard billboard = billboards.add(Billboard.create()
        .setImage(WHITE_SHAPES_IMAGE)
        .setImageSubRegion(BoundingRectangle.create(b[0], b[1], b[2], b[3]))
        .setPosition(point)
        .setColor(Color.fromName("LIME"))
        .setScale(scaleFactor)
    );
        
    double iconWidth = b[2];
    double iconHeight = b[3];

    int fontPixels = 16;

    Label label = labels.add(Label.create()
        .setPosition(point)
        .setText(labelString)
        .setFont((fontPixels * scaleFactor) + "px sans-serif")
        .setHorizontalOrigin(HorizontalOrigin.LEFT)
        .setVerticalOrigin(VerticalOrigin.BOTTOM)
        .setPixelOffset(
            Cartesian2.create((iconWidth / 2) * scaleFactor,
                (iconHeight / 2) * scaleFactor))
        // pixelOffsetScaleByDistance : new Cesium.NearFarScalar(1.5e2, 3.0, 1.5e7, 0.5)
      );
  }
}

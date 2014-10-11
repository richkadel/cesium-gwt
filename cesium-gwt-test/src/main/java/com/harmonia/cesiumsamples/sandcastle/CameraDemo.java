package com.harmonia.cesiumsamples.sandcastle;

import org.cesiumjs.cesium.Camera;
import org.cesiumjs.cesium.Cartesian3;
import org.cesiumjs.cesium.CesiumConfiguration;
import org.cesiumjs.cesium.CesiumWidget;
import org.cesiumjs.cesium.CesiumWidgetPanel;
import org.cesiumjs.cesium.DebugModelMatrixPrimitive;
import org.cesiumjs.cesium.Matrix4;
import org.cesiumjs.cesium.Polyline;
import org.cesiumjs.cesium.PolylineCollection;
import org.cesiumjs.cesium.Rectangle;
import org.cesiumjs.cesium.Scene;
import org.cesiumjs.cesium.Transforms;
import org.cesiumjs.js.EventListener;
import org.cesiumjs.js.JsFunction;
import org.cesiumjs.js.NoArgsFunction;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ListBox;

public class CameraDemo extends DockLayoutPanel {

  private CesiumWidget cesiumWidget;

  protected Scene scene;

  public CameraDemo(CesiumConfiguration configuration) {
    super(Unit.EM);

    FlowPanel buttons = new FlowPanel();
    addSouth(buttons, 2);

    final ListBox cameraOptions = new ListBox();
    cameraOptions.addItem("Camera Options");
    cameraOptions.addItem("Fly to San Diego");
    cameraOptions.addItem("Fly to My Location");
    cameraOptions.addItem("Fly to Rectangle");
    cameraOptions.addItem("View a Rectangle");
    cameraOptions.addItem("Set camera reference frame");
//    cameraOptions.addItem("View in ICRF");
    buttons.add(cameraOptions);
    
    cameraOptions.addChangeHandler(new ChangeHandler() {
      public void onChange(ChangeEvent event) {
        String selected = cameraOptions.getValue(cameraOptions.getSelectedIndex());
        if ("Fly to San Diego".equals(selected)) {
          flyToSanDiego();
        } else if ("Fly to My Location".equals(selected)) {
          flyToLocation();
        } else if ("Fly to Rectangle".equals(selected)) {
          flyToRectangle();
        } else if ("View a Rectangle".equals(selected)) {
          viewRectangle();
        } else if ("Set camera reference frame".equals(selected)) {
          setReferenceFrame();
//        } else if ("View in ICRF".equals(selected)) {
//          viewInICRF();
        }
      }
    });
    
    final ListBox mapType = new ListBox();
    mapType.addItem("Map Types");
    mapType.addItem("3D");
    mapType.addItem("2D");
    mapType.addItem("Columbus View");
    buttons.add(mapType);
    
    mapType.addChangeHandler(new ChangeHandler() {
      public void onChange(ChangeEvent event) {
        String selected = mapType.getValue(mapType.getSelectedIndex());
        if ("3D".equals(selected)) {
          scene.morphTo3D();
        } else if ("2D".equals(selected)) {
          scene.morphTo2D();
        } else if ("Columbus View".equals(selected)) {
          scene.morphToColumbusView();
        }
      }
    });
    
    CesiumWidgetPanel cesiumPanel = new CesiumWidgetPanel(configuration) {
      @Override
      public CesiumWidget createCesiumWidget(Element element) {
        cesiumWidget = CesiumWidget.create(element);
        scene = cesiumWidget.getScene();
        
        scene.onMorphComplete().addEventListener(new NoArgsFunction() {
          public void callback() {
            scene.getPrimitives().removeAll();
            //scene.tweens.removeAll(); // undocumented

            scene.getCamera().setTransform(Matrix4.IDENTITY);

            //clock.multiplier = 1.0;
            //scene.preRender.removeEventListener(icrf);
            scene.getGlobe().setEnableLighting(false);
          }
        });
        
        return cesiumWidget;
      }
    };
    add(cesiumPanel);
  }

  public void flyToSanDiego() {
    scene.getCamera().flyTo(Cartesian3.fromDegrees(-117.16, 32.71, 15000.0));
  }

  public void flyToLocation() {
    getCurrentPosition(JsFunction.create(new EventListener<Position>() {
      public void callback(Position position) {
        scene.getCamera().flyTo(Cartesian3.fromDegrees(
            position.getLongitude(), position.getLatitude(), 1000.0));
      }
    }));
  }

  protected void flyToRectangle() {
    
    double west = -90.0;
    double south = 38.0;
    double east = -87.0;
    double north = 40.0;

    scene.getCamera().flyToRectangle(Rectangle.fromDegrees(west, south, east, north));

    // Show the rectangle.  Not required; just for show.
    PolylineCollection polylines = PolylineCollection.create();
    scene.getPrimitives().add(polylines);
    polylines.add(Polyline.create()
        .setPositions(Cartesian3.fromDegreesArray(new double[] {
            west, south,
            west, north,
            east, north,
            east, south,
            west, south
          }))
    );
  }

  protected void viewRectangle() {

    double west = -77.0;
    double south = 38.0;
    double east = -72.0;
    double north = 42.0;

    scene.getCamera().viewRectangle(Rectangle.fromDegrees(west, south, east, north));

    // Show the rectangle.  Not required; just for show.
    PolylineCollection polylines = PolylineCollection.create();
    scene.getPrimitives().add(polylines);
    polylines.add(Polyline.create()
      .setPositions(
        Cartesian3.fromDegreesArray(new double[] {
            west, south,
            west, north,
            east, north,
            east, south,
            west, south
        }))
    );
  }

  protected void setReferenceFrame() {

    Cartesian3 center = Cartesian3.fromDegrees(-75.59777, 40.03883);
    Matrix4 transform = Transforms.eastNorthUpToFixedFrame(center);

    // View in east-north-up frame
    Camera camera = scene.getCamera();
    Matrix4.clone(transform, camera.getTransform());
    //camera.setConstrainedAxis(Cartesian3.UNIT_Z); // undocumented (unsupported?)

    // Zoom in
    camera.lookAt(
        Cartesian3.create(-120000.0, -120000.0, 120000.0),
        Cartesian3.ZERO,
        Cartesian3.UNIT_Z);

    // Show reference frame.  Not required.
    scene.getPrimitives().add(DebugModelMatrixPrimitive.create(
        DebugModelMatrixPrimitive.Options.create()
        .modelMatrix(transform)
        .lengthMeters(100000.0)
      ));
  }
  
// Not currently supported because I'm not currently implementing the Viewer
//  protected void icrf(Scene scene, time) {
//    if (scene.getMode() != SceneMode.SCENE3D) {
//      return;
//    }
//
//    icrfToFixed = Transforms.computeIcrfToFixedMatrix(time);
//    if (icrfToFixed != null) {
//        scene.getCamera().setTransform(Matrix4.fromRotationTranslation(icrfToFixed, Cartesian3.ZERO));
//    }
//  }
//
//  protected void viewInICRF() {
//
//    vm = viewer.homeButton.viewModel;
//    vm.duration = 0.0;
//    vm.command();
//    vm.duration = 3.0;
//
//    clock.multiplier = 3 * 60 * 60;
//    scene.preRender.addEventListener(icrf);
//    scene.getGlobe().setEnableLighting(true);
//
//  }
  
  ///////////////////////////////
  // JSNI Native Methods and overlay classes to support invoking browser's getCurrentPosition()
  
  private static native void getCurrentPosition(JsFunction success) /*-{
    navigator.geolocation.getCurrentPosition(success); // not adding error callback or PositionOptions
  }-*/;
  
  public static final class Position extends JavaScriptObject {

    protected Position() {}
    
    // Only providing access to longitude and latitude, though a
    // timestamp and additional coordinate information can be available.
    
    public native double getLongitude() /*-{
      return this.coords.longitude;
    }-*/;
    
    public native double getLatitude() /*-{
      return this.coords.latitude;
    }-*/;
  }
}

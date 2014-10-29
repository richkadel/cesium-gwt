package com.harmonia.cesiumsamples.sandcastle;

import jsfunction.gwt.functions.NoArgsFunction;

import org.cesiumjs.cesium.Camera;
import org.cesiumjs.cesium.Cartesian3;
import org.cesiumjs.cesium.Cesium;
import org.cesiumjs.cesium.CesiumConfiguration;
import org.cesiumjs.cesium.CesiumWidget;
import org.cesiumjs.cesium.CesiumWidgetPanel;
import org.cesiumjs.cesium.Matrix4;
import org.cesiumjs.cesium.PickedObject;
import org.cesiumjs.cesium.Scene;
import org.cesiumjs.cesium.ScreenSpaceCameraController;
import org.cesiumjs.cesium.Transforms;
import org.cesiumjs.cesium.events.MouseMoveEvent;
import org.cesiumjs.cesium.events.MouseMoveEventListener;
import org.cesiumjs.cesium.events.ScreenSpaceEventHandler;
import org.cesiumjs.cesium.models.Model;
import org.cesiumjs.cesium.models.ModelAnimation;
import org.cesiumjs.cesium.models.ModelAnimationLoop;
import org.cesiumjs.cesium.models.ModelMesh;
import org.cesiumjs.cesium.models.ModelNode;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ListBox;

public class Demo3DModels extends DockLayoutPanel {

  private CesiumWidget cesiumWidget;

  private Scene scene;

  public Demo3DModels(CesiumConfiguration configuration) {
    super(Unit.EM);
    
    final String SAMPLE_DATA_DIR = configuration.getCesiumPath()+"../../Apps/SampleData/";

    FlowPanel buttons = new FlowPanel();
    addSouth(buttons, 2);

    final ListBox modelOptions = new ListBox();
    modelOptions.addItem("Select a Model");
    modelOptions.addItem("Aircraft");
    modelOptions.addItem("Ground vehicle");
    modelOptions.addItem("Skinned character");
    buttons.add(modelOptions);
    
    modelOptions.addChangeHandler(new ChangeHandler() {
      public void onChange(ChangeEvent event) {
        String selected = modelOptions.getValue(modelOptions.getSelectedIndex());
        if ("Aircraft".equals(selected)) {
          createModel(SAMPLE_DATA_DIR+"models/CesiumAir/Cesium_Air.gltf", 5000.0);
        } else if ("Ground vehicle".equals(selected)) {
          createModel(SAMPLE_DATA_DIR+"models/CesiumGround/Cesium_Ground.gltf");
        } else if ("Skinned character".equals(selected)) {
          createModel(SAMPLE_DATA_DIR+"models/CesiumMan/Cesium_Man.gltf");
        }
      }
    });
    
    CesiumWidgetPanel cesiumPanel = new CesiumWidgetPanel(configuration) {

      @Override
      public CesiumWidget createCesiumWidget(Element element) {
        cesiumWidget = CesiumWidget.create(element);
      
    //    var viewer = new Cesium.Viewer('cesiumContainer');
        scene = cesiumWidget.getScene();
    
        ScreenSpaceEventHandler handler = ScreenSpaceEventHandler.create(scene.getCanvas());
        handler.setInputAction(new MouseMoveEventListener() {
          public void callback(MouseMoveEvent event) {
            PickedObject pick = scene.pick(event.getEndPosition());
            if (pick != null && pick.getObject("node") != null && pick.getObject("mesh") != null) {
                // Output glTF node and mesh under the mouse. 
              GWT.log("node: " + ((ModelNode)pick.getObject("node")).getName() 
                    + ". mesh: " + ((ModelMesh)pick.getObject("mesh")).getName());
            }
          }
        });
        
        modelOptions.setSelectedIndex(1);
        DomEvent.fireNativeEvent(Document.get().createChangeEvent(), modelOptions);
        
        return cesiumWidget;
      }
    };
    add(cesiumPanel);
  }
    
  private void createModel(String url) {
    createModel(url, 0.0);
  }
  
  private void createModel(String url, double height) {

    Matrix4 modelMatrix;
    if (Cesium.getVersion().startsWith("1.0") || Cesium.getVersion().startsWith("1.1")) {
      // There is a bug in Cesium 1.0 and 1.1 (fixed in 1.2) that draws these models upside down.
      // This hack to use northEastDown at least draws the models right-side up, but they are still pointing in the wrong direction.
      // I recommend upgrading to Cesium 1.2, if you want to use glTF models.
      // See Cesium Forum discussion: https://groups.google.com/forum/embed/?place=forum/cesium-dev&showsearch=true&showpopout=true&hideforumtitle=true&parenturl=http%3A%2F%2Fcesiumjs.org%2Fforum.html#!topic/cesium-dev/B94XFEzWwS4
      modelMatrix = Transforms.northEastDownToFixedFrame(Cartesian3.fromDegrees(-123.0744619, 44.0503706, height));
    } else {
      modelMatrix = Transforms.eastNorthUpToFixedFrame(Cartesian3.fromDegrees(-123.0744619, 44.0503706, height));
    }

    scene.getPrimitives().removeAll(); // Remove previous model
    final Model model = scene.getPrimitives().add(
      Model.fromGltf(
        url, 
        Model.Options.create()
          .modelMatrix(modelMatrix)
          .minimumPixelSize(128)
      )
    );

    model.onReadyToRender().addEventListener(new NoArgsFunction() {
      public void callback() {
        // Play and loop all animations at half-speed
        model.getActiveAnimations().addAll(ModelAnimation.Options.create()
          .speedup(0.5)
          .loop(ModelAnimationLoop.REPEAT)
        );
  
        // Zoom to model
        Cartesian3 center = Matrix4.multiplyByPoint(model.getModelMatrix(), model.getBoundingSphere().getCenter(), Cartesian3.ZERO.cloneCartesian3());
        Matrix4 transform = Transforms.eastNorthUpToFixedFrame(center);
        Camera camera = scene.getCamera();
        camera.setTransform(transform);
        ScreenSpaceCameraController controller = scene.getScreenSpaceCameraController();
        double r = 2.0 * Math.max(model.getBoundingSphere().getRadius(), camera.getFrustum().getNear());
        controller.setMinimumZoomDistance(r * 0.5);
        camera.lookAt(Cartesian3.create(r, r, r), Cartesian3.ZERO, Cartesian3.UNIT_Z);
      }
    });
  }
}
  
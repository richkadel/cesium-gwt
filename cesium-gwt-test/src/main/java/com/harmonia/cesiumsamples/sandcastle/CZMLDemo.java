package com.harmonia.cesiumsamples.sandcastle;

import jsfunction.gwt.functions.NoArgsFunction;

import org.cesiumjs.cesium.Cartesian2;
import org.cesiumjs.cesium.Cartesian3;
import org.cesiumjs.cesium.CesiumConfiguration;
import org.cesiumjs.cesium.Color;
import org.cesiumjs.cesium.HorizontalOrigin;
import org.cesiumjs.cesium.LabelStyle;
import org.cesiumjs.cesium.LagrangePolynomialApproximation;
import org.cesiumjs.cesium.VerticalOrigin;
import org.cesiumjs.cesium.Viewer;
import org.cesiumjs.cesium.ViewerPanel;
import org.cesiumjs.cesium.data.BillboardGraphics;
import org.cesiumjs.cesium.data.CzmlDataSource;
import org.cesiumjs.cesium.data.DataSource;
import org.cesiumjs.cesium.data.Entity;
import org.cesiumjs.cesium.data.EntityCollection;
import org.cesiumjs.cesium.data.EntityDataSource;
import org.cesiumjs.cesium.data.LabelGraphics;
import org.cesiumjs.cesium.data.PathGraphics;
import org.cesiumjs.cesium.data.SampledPositionProperty;
import org.cesiumjs.cesium.materials.ColorMaterialProperty;
import org.cesiumjs.cesium.mixins.ViewerEntityMixin;
import org.cesiumjs.cesium.time.BooleanTimeInterval;
import org.cesiumjs.cesium.time.ColorTimeInterval;
import org.cesiumjs.cesium.time.JulianDate;
import org.cesiumjs.cesium.time.NumberTimeInterval;
import org.cesiumjs.cesium.time.TimeInterval;
import org.cesiumjs.cesium.time.TimeIntervalCollection;
import org.cesiumjs.cesium.time.TimeIntervalCollectionProperty;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;

public class CZMLDemo extends DockLayoutPanel {
  
  private Viewer viewer;

  private FlowPanel buttons;

  protected ViewerEntityMixin viewerEntityMixin;
  
  private Button addButton(String label) {
    Button button = new Button(label);
    buttons.add(button);
    return button;
  }

  public CZMLDemo(CesiumConfiguration configuration) {
    super(Unit.EM);

    final String SAMPLE_DATA_DIR = configuration.getCesiumPath()+"../../Apps/SampleData/";
  
    buttons = new FlowPanel();
    addSouth(buttons, 2);
    
    addButton("Satellites").addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        final CzmlDataSource czmlDataSource = CzmlDataSource.create();
        czmlDataSource.loadUrl(SAMPLE_DATA_DIR + "simple.czml");
        viewer.getDataSources().add(czmlDataSource);
      }
    });

    addButton("Tracked Satellite").addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        final CzmlDataSource czmlDataSource = CzmlDataSource.create();
        czmlDataSource.loadUrl(SAMPLE_DATA_DIR + "simple.czml");
        viewer.getDataSources().add(czmlDataSource);
        czmlDataSource.onLoadingEvent().addEventListener(new NoArgsFunction() {
          public void callback() {
            if (!czmlDataSource.isLoading()) {
              EntityCollection entityCollection = czmlDataSource.getEntities();
              JsArray<Entity> entities = entityCollection.getEntities();
              int len = entities.length();
              for (int i = 0; i < len; i++) {
                Entity entity = entities.get(i);
                GWT.log("entity "+i+": "+entity.getId());
              }
              viewerEntityMixin.setTrackedEntity(czmlDataSource.getEntities().getById("Satellite/Geoeye1/Sensor/Sensor"));
            }
          }
        });
      }
    });

    addButton("Vehicle").addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        CzmlDataSource czmlDataSource = CzmlDataSource.create();
        czmlDataSource.loadUrl(SAMPLE_DATA_DIR + "Vehicle.czml");
        viewer.getDataSources().add(czmlDataSource);
      }
    });

    addButton("Built-in CZML").addClickHandler(new ClickHandler() {
      @SuppressWarnings("unchecked")
      public void onClick(ClickEvent event) {
        EntityCollection builtInCzml = EntityCollection.create();
        builtInCzml.add(
          Entity.create("document")
            .setVersion("1.0"),
          Entity.create("Vehicle")
            .setAvailability(
              TimeIntervalCollection.create(
                TimeInterval.create()
                  .setStart(JulianDate.fromIso8601("2012-08-04T16:00:00Z"))
                  .setStop(JulianDate.fromIso8601("2012-08-04T17:04:54Z"))
              )
            )
            .setBillboard(BillboardGraphics.create()
              .setEyeOffset(Cartesian3.create(0.0, 0.0, 0.0))
              .setHorizontalOrigin(HorizontalOrigin.CENTER)
              .setImage("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAEISURBVEhLvVXBDYQwDOuojHKj8LhBbpTbpBCEkZsmIVTXq1RVQGrHiWlLmTTqPiZBlyLgy/KSZQ5JSHDQ/mCYCsC8106kDU0AdwRnvYZArWRcAl0dcYJq1hWCb3hBrumbDAVMwAC82WoRvgMnVMDBnB0nYZFTbE6BBvdUGqVqCbjBIk3PyFFR/NU7EKzru+qZsau3ryPwwCRLKYOzutZuCL6fUmWeJGzNzL/RxAMrUmASSCkkAayk2IxPlwhAAYGpsiHQjbLccfdOY5gKkCXAMi7SscAwbQpAnKyctWyUZ6z8ja3OGMepwD8asz+9FnSvbhU8uVOHFIwQsI3/p0CfhuqCSQuxLqsN6mu8SS+N42MAAAAASUVORK5CYII=")
              .setPixelOffset(Cartesian2.create(0.0, 0.0))
              .setScale(0.8)
              .setShow(
                TimeIntervalCollectionProperty.create(
                  BooleanTimeInterval.create("2012-08-04T16:00:00Z/2012-08-04T18:00:00Z", true)
                )
              )
              .setVerticalOrigin(VerticalOrigin.BOTTOM)
            ).setLabel(LabelGraphics.create()
              .setFillColor(
                TimeIntervalCollectionProperty.create(
                  ColorTimeInterval.create("2012-08-04T16:00:00Z/2012-08-04T18:00:00Z", Color.create(255, 255, 0, 255))
                )
              )
              .setFont("bold 10pt Segoe UI Semibold")
              .setHorizontalOrigin(HorizontalOrigin.LEFT)
              .setOutlineColor(Color.create(0, 0, 0, 255))
              .setPixelOffset(Cartesian2.create(10.0, 0.0))
              .setScale(1.0)
              .setShow(
                TimeIntervalCollectionProperty.create(
                  BooleanTimeInterval.create("2012-08-04T16:00:00Z/2012-08-04T18:00:00Z", true)
                )
              )
              .setStyle(LabelStyle.FILL)
              .setText("Vehicle")
              .setVerticalOrigin(VerticalOrigin.CENTER)
            )
            
            .setPath(PathGraphics.create()
              .setMaterial(
                ColorMaterialProperty.create(
                  TimeIntervalCollectionProperty.create(
                    ColorTimeInterval.create("2012-08-04T16:00:00Z/2012-08-04T18:00:00Z", Color.create(255, 255, 0, 255))
                  )
                )
              )
              .setWidth(
                TimeIntervalCollectionProperty.create(
                  NumberTimeInterval.create("2012-08-04T16:00:00Z/2012-08-04T18:00:00Z", 5.0)
                )
              )
              .setShow(
                TimeIntervalCollectionProperty.create(
                  BooleanTimeInterval.create("2012-08-04T16:00:00Z/2012-08-04T18:00:00Z", true)
                )
              )
            )
            .setPosition(SampledPositionProperty.create()
              .setInterpolationAlgorithm(LagrangePolynomialApproximation.get())
              .setInterpolationDegree(1)
              .addSamplesPackedArray(
                new double[]{0.0, -2379754.6637012, -4665332.88013588, 3628133.68924173,
                               3894.0, -2291336.52323822, -4682359.21232197, 3662718.52171165},
                JulianDate.fromIso8601("2012-08-04T16:00:00Z")
              )
            )
        );
            
        DataSource entityDataSource = EntityDataSource.create(builtInCzml, "Built-in CZML-like GWT Entities");
        viewer.getDataSources().add(entityDataSource);
      }
    });
        
    ViewerPanel cesiumPanel = new ViewerPanel(configuration) {

      @Override
      public Viewer createViewer(Element element) {

        viewer = Viewer.create(element);
        viewerEntityMixin = ViewerEntityMixin.create(viewer);
        
        return viewer;
      }
    };
    add(cesiumPanel);
  }
}
  
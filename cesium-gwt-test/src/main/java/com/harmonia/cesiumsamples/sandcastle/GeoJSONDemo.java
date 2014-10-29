package com.harmonia.cesiumsamples.sandcastle;

import java.util.HashMap;
import java.util.Map;

import jsfunction.gwt.functions.NoArgsFunction;

import org.cesiumjs.cesium.Cesium;
import org.cesiumjs.cesium.CesiumConfiguration;
import org.cesiumjs.cesium.Color;
import org.cesiumjs.cesium.Viewer;
import org.cesiumjs.cesium.ViewerPanel;
import org.cesiumjs.cesium.data.Entity;
import org.cesiumjs.cesium.data.GeoJsonDataSource;
import org.cesiumjs.cesium.data.NumberProperty;
import org.cesiumjs.cesium.materials.ColorMaterialProperty;
import org.cesiumjs.cesium.mixins.ViewerEntityMixin;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;

public class GeoJSONDemo extends DockLayoutPanel {

  private Viewer viewer;

  private FlowPanel buttons;

  protected ViewerEntityMixin viewerEntityMixin;
  
  private Button addButton(String label) {
    Button button = new Button(label);
    buttons.add(button);
    return button;
  }

  public GeoJSONDemo(CesiumConfiguration configuration) {
    super(Unit.EM);
    
    final String SAMPLE_DATA_DIR = configuration.getCesiumPath()+"../../Apps/SampleData/";

    buttons = new FlowPanel();
    addSouth(buttons, 2);
    
    addButton("Basic Loading").addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        viewer.getDataSources().add(GeoJsonDataSource.fromUrl(SAMPLE_DATA_DIR+"ne_10m_us_states.topojson"));
      }
    });

    addButton("Custom Graphics").addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
      //Seed the random number generator for repeatable results.
        Cesium.Math.setRandomNumberSeed(0);

        //Create a new GeoJSONDemo data source and add it to the list.
        final GeoJsonDataSource dataSource = GeoJsonDataSource.create();
        viewer.getDataSources().add(dataSource);
        
        //Load the document into the data source and then set custom graphics
        dataSource.loadUrl(SAMPLE_DATA_DIR+"ne_10m_us_states.topojson").then(
          new NoArgsFunction() {
            public void callback() {
              //Get the array of entities
              JsArray<Entity> entities = dataSource.getEntities().getEntities();
              
              Map<String,Color> colorHash = new HashMap<String,Color>();
              for (int i = 0; i < entities.length(); i++) {
                //For each entity, create a random color based on the state name.
                //Some states have multiple entities, so we store the color in a
                //hash so that we use the same color for the entire state.
                Entity entity = entities.get(i);
                String name = entity.getName();
                Color color = colorHash.get(name);
                if (color == null) {
                    color = Color.fromRandom(Color.Components.create()
                      .alpha(1.0)
                    );
                    colorHash.put(name, color);
                }
                  
                  //Set the polygon material to our random color.
                entity.getPolygon().setMaterial(ColorMaterialProperty.fromColor(color));
  
                //Extrude the polygon based on the state's population.  Each entity
                //stores the properties for the GeoJSONDemo feature it was created from
                //Since the population is a huge number, we divide by 50.
                entity.getPolygon().setExtrudedHeight(NumberProperty.create(entity.getProperties().getNumber("Population") / 50.0));
              }
            }
          }
        );
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
  
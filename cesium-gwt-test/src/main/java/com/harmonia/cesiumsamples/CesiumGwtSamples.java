package com.harmonia.cesiumsamples;

import org.cesiumjs.cesium.CesiumConfiguration;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.harmonia.cesiumsamples.sandcastle.CZMLDemo;
import com.harmonia.cesiumsamples.sandcastle.CameraDemo;
import com.harmonia.cesiumsamples.sandcastle.Demo3DModels;
import com.harmonia.cesiumsamples.sandcastle.GeoJSONDemo;
import com.harmonia.cesiumsamples.sandcastle.PolygonDemo;

// FYI: Here is the simplest Cesium-GWT app you could write, as of today:
//
// public class CesiumGwtSamples implements EntryPoint {
//   public void onModuleLoad() {
//     RootPanel.get().add(new CesiumWidgetPanel("Cesium-1.2/Build/CesiumUnminified") {
//       public CesiumWidget createCesiumWidget(Element element) {
//         return CesiumWidget.create(element);
//       }
//     });
//   }
// }

public class CesiumGwtSamples implements EntryPoint {

  @Override
  public void onModuleLoad() {
    TabPanel tabs = new TabPanel();
    CesiumConfiguration config = new CesiumConfiguration()
        .setCesiumPath("Cesium-1.2/Build/CesiumUnminified");

    tabs.add(new HelloCesium(config), "Hello");

    CesiumWidgetPlayer player = new CesiumWidgetPlayer(config);
    tabs.add(player.asWidget(), "Player");
    player.play();

    tabs.add(new ZoomToCesium(config), "Zoom");
    
    tabs.add(new PolygonDemo(config), "Polygon");
    tabs.add(new CameraDemo(config), "Camera");
    tabs.add(new Demo3DModels(config), "3D Models");
    tabs.add(new CZMLDemo(config), "CZML");
    tabs.add(new GeoJSONDemo(config), "GeoJSON/TopoJSON");

    tabs.selectTab(0);

    for (int i = 0; i < tabs.getWidgetCount(); i++) {
      tabs.getWidget(i).setPixelSize(650, 650);
    }

    RootPanel.get().add(tabs);
  }
}

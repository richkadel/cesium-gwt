package com.harmonia.cesiumsamples;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.harmonia.gwt.cesium.CesiumConfiguration;

public class CesiumGwtSamples implements EntryPoint {

	@Override
	public void onModuleLoad() {
    TabPanel tabs = new TabPanel();
    CesiumConfiguration config = new CesiumConfiguration().setCesiumPath("Cesium-b28/Cesium");
    
    tabs.add(new HelloCesium(config), "Hello");
    
    CesiumWidgetPlayer player = new CesiumWidgetPlayer(config);
    tabs.add(player.asWidget(), "Player");
    player.play();
    
    tabs.add(new ZoomToCesium(config), "Zoom");
    
    tabs.selectTab(0);
    
    for (int i = 0; i < tabs.getWidgetCount(); i++) {
    	tabs.getWidget(i).setPixelSize(500, 500);
    }
    
    RootPanel.get().add(tabs);
	}
}

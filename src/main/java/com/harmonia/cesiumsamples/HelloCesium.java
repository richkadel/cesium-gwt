package com.harmonia.cesiumsamples;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.SimplePanel;
import com.harmonia.gwt.cesium.CesiumConfiguration;
import com.harmonia.gwt.cesium.CesiumWidget;
import com.harmonia.gwt.cesium.CesiumWidgetPanel;

public class HelloCesium extends CesiumWidgetPanel {

	public HelloCesium(CesiumConfiguration configuration) {
    super(configuration);
	}
  
	public CesiumWidget createCesiumWidget(Element element) {
		return CesiumWidget.create(element);
	}
}

package com.harmonia.cesiumsamples;

import org.cesiumjs.cesium.CesiumConfiguration;
import org.cesiumjs.cesium.CesiumWidget;
import org.cesiumjs.cesium.CesiumWidgetPanel;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.SimplePanel;

public class HelloCesium extends CesiumWidgetPanel {

	public HelloCesium(CesiumConfiguration configuration) {
    super(configuration);
	}
  
	public CesiumWidget createCesiumWidget(Element element) {
		return CesiumWidget.create(element);
	}
}

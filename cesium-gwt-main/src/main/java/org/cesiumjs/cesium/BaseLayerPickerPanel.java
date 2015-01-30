package org.cesiumjs.cesium;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.user.client.ui.SimplePanel;

public abstract class BaseLayerPickerPanel extends SimplePanel {

	private BaseLayerPicker layerPicker;

	public BaseLayerPickerPanel() {
		addAttachHandler(new Handler() {

			@Override
			public void onAttachOrDetach(AttachEvent event) {
				if (event.isAttached() && BaseLayerPickerPanel.this.layerPicker == null) {
					BaseLayerPickerPanel.this.layerPicker = createLayerPicker(getElement());
				} else {
					
				}
			}
		});
	}

	public BaseLayerPicker getCesiumWidget() {
		return layerPicker;
	}

	public abstract BaseLayerPicker createLayerPicker(Element element);

}

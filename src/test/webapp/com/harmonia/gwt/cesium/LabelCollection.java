package com.harmonia.gwt.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public final class LabelCollection extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected LabelCollection(){}

	public final static native LabelCollection create() /*-{
    return new Cesium.LabelCollection()
	}-*/;

	public final native void add(LabelOptions options) /*-{
    this.add(options);
	}-*/;
}
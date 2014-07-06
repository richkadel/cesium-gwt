package com.harmonia.cesiumjs.gwt;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public final class Animation extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected Animation(){}

	public native void onComplete() /*-{
    this.onComplete()
	}-*/;
}
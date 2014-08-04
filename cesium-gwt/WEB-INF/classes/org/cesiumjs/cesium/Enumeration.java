package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public class Enumeration extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected Enumeration(){}
  
	public final native String getName() /*-{
		return this.name
	}-*/;
  
	public final native double value() /*-{
		return this.value
	}-*/;
}
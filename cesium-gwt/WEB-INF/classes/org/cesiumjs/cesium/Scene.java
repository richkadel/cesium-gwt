package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public final class Scene extends JavaScriptObject {

  protected Scene(){}
  
	public native PrimitiveCollection getPrimitives() /*-{
		return this.primitives
	}-*/;

  public final native Globe getGlobe() /*-{
    return this.globe;
  }-*/;
  
	public native Camera getCamera() /*-{
    return this.camera;
	}-*/;
  
	public native Element getCanvas() /*-{
    return this.canvas;
	}-*/;
}
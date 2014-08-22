package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public class Primitive extends JavaScriptObject {
  
  // Overlay types always have protected, zero argument constructors.
  protected Primitive(){}

  public final native static Primitive create() /*-{
    return new Cesium.Primitive({});
  }-*/;

  public final native Primitive setGeometryInstances(GeometryInstance geometryInstance) /*-{ 
  	this.geometryInstances = geometryInstance
  	return this
  }-*/;
  
  public final native Primitive setGeometryInstances(JsArray<GeometryInstance> geometryInstances) /*-{ 
  	this.geometryInstances = geometryInstances
  	return this
  }-*/;
  
  public final native Primitive setAppearance(Appearance appearance) /*-{ 
  	this.appearance = appearance
  	return this
  }-*/;
  
  public final native Primitive setClosed(boolean closed) /*-{ 
  	this.closed = closed
  	return this
  }-*/;
  
  public final native boolean getClosed() /*-{
    return this.closed;
  }-*/;
}
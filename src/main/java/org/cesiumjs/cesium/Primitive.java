package org.cesiumjs.cesium;

import org.cesiumjs.cesium.Primitive.Options;

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

  public final native static Primitive create(Options options) /*-{
    return new Cesium.Primitive(options);
  }-*/;
  
  public static final class Options extends JavaScriptObject {
    
    protected Options() {}
    
    public static native Options create() /*-{
      return {}
    }-*/;
    
    public native Options setGeometryInstance(GeometryInstance geometryInstance) /*-{ 
    	this.geometryInstances = geometryInstance
    	return this
    }-*/;
    
    public native Options setGeometryInstances(JsArray<GeometryInstance> geometryInstances) /*-{ 
    	this.geometryInstances = geometryInstances
    	return this
    }-*/;
    
    public native Options setAppearance(Appearance appearance) /*-{ 
    	this.appearance = appearance
    	return this
    }-*/;

    public native Options setReleaseGeometryInstances(boolean releaseGeometryInstances) /*-{
    	this.releaseGeometryInstances = releaseGeometryInstances
      return this
    }-*/;
  }

  public final native JsArray<GeometryInstance> getGeometryInstances() /*-{
    if (this.geometryInstances == null || Array.isArray(this.geometryInstances)) {
      return this.geometryInstances
    } else {
      return [this.geometryInstances]
    } 
  }-*/;
}
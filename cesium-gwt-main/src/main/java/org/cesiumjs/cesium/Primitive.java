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
  
  public final native void show(boolean show) /*-{
  	this.show = show;
  }-*/;
  
  public final native boolean isShown() /*-{
	return this.show;
  }-*/;
  
  public static final class Options extends JavaScriptObject {
    
    protected Options() {}
    
    public static native Options create() /*-{
      return {}
    }-*/;
    
    public native Options geometryInstance(GeometryInstance geometryInstance) /*-{ 
      this.geometryInstances = geometryInstance
      return this
    }-*/;
    
    public Options geometryInstances(GeometryInstance...geometryInstances) {
      JsArray<GeometryInstance> jsarray = JsArray.createArray(geometryInstances.length).cast();
      int i = 0;
      for (GeometryInstance geometryInstance : geometryInstances) {
        jsarray.set(i++, geometryInstance);
      }
      return geometryInstances(jsarray);
    }
    
    public native Options geometryInstances(JsArray<GeometryInstance> geometryInstances) /*-{ 
      this.geometryInstances = geometryInstances
      return this
    }-*/;
    
    public native Options appearance(Appearance appearance) /*-{ 
      this.appearance = appearance
      return this
    }-*/;

    public native Options releaseGeometryInstances(boolean releaseGeometryInstances) /*-{
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
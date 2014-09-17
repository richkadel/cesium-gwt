package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public final class DebugModelMatrixPrimitive extends Primitive {
  
  // Overlay types always have protected, zero argument constructors.
  protected DebugModelMatrixPrimitive(){}

  public static native DebugModelMatrixPrimitive create(Options options) /*-{
    return new Cesium.DebugModelMatrixPrimitive(options);
  }-*/;
  
  public native Object getId() /*-{
    return this.id
  }-*/;
  
  public static final class Options extends JavaScriptObject {
    // Overlay types always have protected, zero argument constructors.
    protected Options(){}
    
    public static native Options create() /*-{
      return {}
    }-*/;
    
    public native Options lengthMeters(double length) /*-{ 
      this.length = length
      return this
    }-*/;
    
    public native Options widthPixels(double width) /*-{ 
      this.width = width
      return this
    }-*/;
    
    public native Options modelMatrix(Matrix4 modelMatrix) /*-{ 
      this.modelMatrix = modelMatrix
      return this
    }-*/;
    
    public native Options show(boolean show) /*-{ 
      this.show = show
      return this
    }-*/;
    
    public native Options id(Object id) /*-{ 
      this.id = id
      return this
    }-*/;
  }
}
package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public final class PerInstanceColorAppearance extends Appearance {
  
  // Overlay types always have protected, zero argument constructors.
  protected PerInstanceColorAppearance(){}

  public final native static VertexFormat VERTEX_FORMAT() /*-{ return Cesium.PerInstanceColorAppearance.VERTEX_FORMAT }-*/;
  public final native static VertexFormat FLAT_VERTEX_FORMAT() /*-{ return Cesium.PerInstanceColorAppearance.FLAT_VERTEX_FORMAT }-*/;
  
  public final static PerInstanceColorAppearance create() {
    return create(Options.create());
  }

  public final native static PerInstanceColorAppearance create(Options options) /*-{
    return new Cesium.PerInstanceColorAppearance(options);
  }-*/;

  public native PerInstanceColorAppearance setTranslucent(boolean translucent) /*-{ 
    this.translucent = translucent
    return this
  }-*/;
  
  // TODO 
//  public native PerInstanceColorAppearance setMaterial(Material material) /*-{ 
//    this.material = material
//    return this
//  }-*/;
  
  public native boolean isFlat() /*-{
    return this.flat;
  }-*/;

  public native boolean isFaceForward() /*-{
    return this.faceForward;
  }-*/;

  public native boolean isTranslucent() /*-{
    return this.translucent;
  }-*/;

  public native boolean isClosed() /*-{
    return this.closed;
  }-*/;

  public native String getVertexShaderSource() /*-{
    return this.vertexShaderSource;
  }-*/;

  public native String getFragmentShaderSource() /*-{
    return this.fragmentShaderSource;
  }-*/;
  
//  public native Material getMaterial() /*-{ 
//    return this.material
//  }-*/;
  
//  public native RenderState getRenderState() /*-{ 
//    return this.renderState
//  }-*/;
  
  public static final class Options extends JavaScriptObject {
    // Overlay types always have protected, zero argument constructors.
    protected Options(){}
    
    public static native Options create() /*-{
      return {}
    }-*/;
    
    public native Options setFlat(boolean flat) /*-{ 
      this.flat = flat
      return this
    }-*/;
      
    public native Options setFaceForward(boolean faceForward) /*-{ 
      this.faceForward = faceForward
      return this
    }-*/;

    public native Options setTranslucent(boolean translucent) /*-{ 
      this.translucent = translucent
      return this
    }-*/;
        
    public native Options setClosed(boolean closed) /*-{ 
      this.closed = closed
      return this
    }-*/;
      
    public native Options setVertexShaderSource(String vertexShaderSource) /*-{ 
      this.vertexShaderSource = vertexShaderSource
      return this
    }-*/;
    
    public native Options setFragmentShaderSource(String fragmentShaderSource) /*-{ 
      this.fragmentShaderSource = fragmentShaderSource
      return this
    }-*/;
  
    public native Options setRenderState(Undocumented renderState) /*-{ 
      this.renderState = renderState
      return this
    }-*/;
  }
}
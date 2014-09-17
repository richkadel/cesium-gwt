package org.cesiumjs.cesium;

import org.cesiumjs.cesium.materials.Material;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public final class PerInstanceColorAppearance extends Appearance {
  
  // Overlay types always have protected, zero argument constructors.
  protected PerInstanceColorAppearance(){}

  public final static VertexFormat VERTEX_FORMAT = initVertexFormat("VERTEX_FORMAT");
  public final static VertexFormat FLAT_VERTEX_FORMAT = initVertexFormat("FLAT_VERTEX_FORMAT");
  
  public final native static VertexFormat initVertexFormat(String constName) /*-{
    return Cesium.PerInstanceColorAppearance[constName];
  }-*/;
  
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
  
  public native PerInstanceColorAppearance setMaterial(Material material) /*-{ 
    this.material = material
    return this
  }-*/;
  
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
  
  public native Material getMaterial() /*-{ 
    return this.material
  }-*/;
  
//  public native RenderState getRenderState() /*-{ 
//    return this.renderState
//  }-*/;
  
  public static final class Options extends JavaScriptObject {
    // Overlay types always have protected, zero argument constructors.
    protected Options(){}
    
    public static native Options create() /*-{
      return {}
    }-*/;
    
    public native Options flat(boolean flat) /*-{ 
      this.flat = flat
      return this
    }-*/;
      
    public native Options faceForward(boolean faceForward) /*-{ 
      this.faceForward = faceForward
      return this
    }-*/;

    public native Options translucent(boolean translucent) /*-{ 
      this.translucent = translucent
      return this
    }-*/;
        
    public native Options closed(boolean closed) /*-{ 
      this.closed = closed
      return this
    }-*/;
      
    public native Options vertexShaderSource(String vertexShaderSource) /*-{ 
      this.vertexShaderSource = vertexShaderSource
      return this
    }-*/;
    
    public native Options fragmentShaderSource(String fragmentShaderSource) /*-{ 
      this.fragmentShaderSource = fragmentShaderSource
      return this
    }-*/;
  
    public native Options renderState(Undocumented renderState) /*-{ 
      this.renderState = renderState
      return this
    }-*/;
  }
}
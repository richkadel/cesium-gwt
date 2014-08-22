package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public final class VertexFormat extends JavaScriptObject {
  
  // Overlay types always have protected, zero argument constructors.
  protected VertexFormat(){}

  public final native static VertexFormat ALL()                    /*-{ return Cesium.VertexFormat.ALL }-*/;
  public final native static VertexFormat DEFAULT()                /*-{ return Cesium.VertexFormat.DEFAULT }-*/;
  public final native static VertexFormat POSITION_AND_NORMAL()    /*-{ return Cesium.VertexFormat.POSITION_AND_NORMAL }-*/;
  public final native static VertexFormat POSITION_AND_ST()        /*-{ return Cesium.VertexFormat.POSITION_AND_ST }-*/;
  public final native static VertexFormat POSITION_NORMAL_AND_ST() /*-{ return Cesium.VertexFormat.POSITION_NORMAL_AND_ST }-*/;
  public final native static VertexFormat POSITION_ONLY()          /*-{ return Cesium.VertexFormat.POSITION_ONLY }-*/;
  
  public final native static VertexFormat create() /*-{
    return new Cesium.VertexFormat({});
  }-*/;

  public native VertexFormat setBinormal(boolean binormal) /*-{ 
  	this.binormal = binormal
  	return this
  }-*/;
    
  public native VertexFormat setNormal(boolean normal) /*-{ 
  	this.normal = normal
  	return this
  }-*/;
    
  public native VertexFormat setPosition(boolean position) /*-{ 
  	this.position = position
  	return this
  }-*/;
    
  public native VertexFormat setSt(boolean st) /*-{ 
  	this.st = st
  	return this
  }-*/;
    
  public native VertexFormat setTangent(boolean tangent) /*-{ 
  	this.tangent = tangent
  	return this
  }-*/;
  
  public native boolean getBinormal() /*-{
    return this.binormal;
  }-*/;

  public native boolean getNormal() /*-{
    return this.normal;
  }-*/;

  public native boolean getPosition() /*-{
    return this.position;
  }-*/;

  public native boolean getSt() /*-{
    return this.st;
  }-*/;

  public native boolean getTangent() /*-{
    return this.tangent;
  }-*/;
}
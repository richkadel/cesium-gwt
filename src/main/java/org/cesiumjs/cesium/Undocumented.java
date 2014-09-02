package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public class Undocumented extends JavaScriptObject {
  
  protected Undocumented(){}
  
  public static final native Undocumented create() /*-{
    return {}
  }-*/;
  
  public final native Undocumented set(String name, JavaScriptObject property) /*-{
    this[name] = property;
    return this;
  }-*/;
  
  public final native <T> Undocumented set(String name, T property) /*-{
	this[name] = property;
	return this;
  }-*/;


  public final native Undocumented set(String name, boolean property) /*-{
    this[name] = property;
    return this;
  }-*/;

  public final native Undocumented set(String name, double property) /*-{
    this[name] = property;
    return this;
  }-*/;

  public final native Undocumented set(String name, String property) /*-{
    this[name] = property;
    return this;
  }-*/;
  
  public final native <T extends JavaScriptObject> T getObject(String name) /*-{
    return this[name];
  }-*/;

  public final native boolean getBoolean(String name) /*-{
    return this[name];
  }-*/;

  public final native double getNumber(String name) /*-{
    return this[name];
  }-*/;

  public final native String getString(String name) /*-{
    return this[name];
  }-*/;
}
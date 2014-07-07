package com.harmonia.gwt.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public final class Texture extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected Texture(){}
  
  public native double getWidth() /*-{ return this.width; }-*/;
  
  public native double getHeight() /*-{ return this.height; }-*/;
}
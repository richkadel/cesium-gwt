package com.harmonia.cesiumjs.gwt;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public final class AnimationsCollection extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected AnimationsCollection(){}
  
  public native void add(Animation animation) /*-{ this.add(animation); }-*/;
}
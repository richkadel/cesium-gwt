package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public final class PickedObject extends Undocumented {
  
  protected PickedObject(){}
  
  public native <T extends JavaScriptObject> T getId() /*-{ return this.id; }-*/;
  
  public native Primitive getPrimitive() /*-{ return this.primitive; }-*/;
}
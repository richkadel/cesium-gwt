package org.cesiumjs.cesium.events;

import jsfunction.gwt.JsFunction;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * @author richkadel
 *
 */
public final class ScreenSpaceEventHandler extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected ScreenSpaceEventHandler(){}

  public native static ScreenSpaceEventHandler create(Element element) /*-{
    return new Cesium.ScreenSpaceEventHandler(element)
  }-*/;

  public void setInputAction(CesiumInputEventListener<?> eventListener, ScreenSpaceEventType type) {
    Params params = Params.create()
            .inputAction(eventListener)
            .type(type);
    this.setInputAction(params);
  }
  
  public void setInputAction(CesiumInputEventListener<?> eventListener, ScreenSpaceEventType type, KeyboardEventModifier modifier) {
    Params params = Params.create()
            .inputAction(eventListener)
            .type(type)
            .modifier(modifier);
    this.setInputAction(params);
  }
  
  /**
   * Set the input action using the default ScreenSpaceEventType of the given listener type.
   * For mouse button events, this defaults to left mouse button events.
   * @param eventListener
   */
  public void setInputAction(CesiumInputEventListener<?> eventListener) {
    Params params = Params.create()
            .inputAction(eventListener)
            .type(eventListener.getDefaultScreenSpaceEventType());
    this.setInputAction(params);
  }
  
  /**
   * Set the input action using the default ScreenSpaceEventType of the given listener type.
   * For mouse button events, this defaults to left mouse button events.
   * @param eventListener
   * @param modifier
   */
  public void setInputAction(CesiumInputEventListener<?> eventListener, KeyboardEventModifier modifier) {
    Params params = Params.create()
            .inputAction(eventListener)
            .type(eventListener.getDefaultScreenSpaceEventType())
            .modifier(modifier);
    this.setInputAction(params);
  }
  
  private native void setInputAction(Params params) /*-{
    this.setInputAction(params.inputAction, params.type, params.modifier); 
  }-*/;
  
  private static class Params extends JavaScriptObject {
    protected Params() {}
    
    public final static native Params create() /*-{
      return {}
    }-*/;

    public final Params inputAction(CesiumInputEventListener<?> eh) {
      return this.setInputAction(JsFunction.create(eh));
    }
    
    private final native Params setInputAction(JsFunction func) /*-{
      this.inputAction = func;
      return this;
    }-*/;

    public final Params type(ScreenSpaceEventType type) {
      return this.setType(type.nativeValue);
    }
    
    private final native Params setType(int type) /*-{
      this.type = type;
      return this;
    }-*/;
    
    public final Params modifier(KeyboardEventModifier modifier) {
      return this.setModifier(modifier.nativeValue);
    }
    
    private final native Params setModifier(int modifier) /*-{
      this.modifier = modifier;
      return this;
    }-*/;
  }
}
package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Due to a GWT DevMode bug, non-native methods cannot be declared in this class for some
 * reason. It causes a runtime exception. Therefore, the native versions of
 * nativeGetValueAsNumber(), nativeGetValueAsBoolean(), and isNull() are exposed
 * as public. These should be private, if a workaround can be found.
 * @author richkadel
 */
public class JSONDerivedObject extends JavaScriptObject {

  protected JSONDerivedObject() {}
  
  /////////////////////////////
  //  WARNING: There seems to be a but with GWT Dev Mode.  SuperDevMode and production works fine.
  //  But in DevMode, this class cannot have any non-native methods without breaking down at runtime
  //  with an error about an obscure error:  “Illegal method name <init>$”
  //  So I am making the private native methods public.
  /////////////////////////////
  
//  public void test() { // Dev mode breaks if you uncomment this
//  }
  
  public final native <T extends JavaScriptObject> T getValue(String name) /*-{
    return this.getValue(name)
  }-*/;
  public final native String getValueAsString(String name) /*-{
    var value = this.getValue(name)
    return value == null ? null : String(value);
  }-*/;

  public final native boolean isNull(String name) /*-{
    return typeof this.getValue(name) === 'undefined' || this.getValue(name) == null
  }-*/;
  
//GWT DevMode breaks if you uncomment this...
//  public Number getValueAsNumber(String name) {
//    if (isNull(name)) {
//      return null;
//    } else {
//      return nativeGetValueAsNumber(name);
//    }
//  }

  /**
   * See the source code. There is a GWT bug in DevMode. I don't normally use DevMode but
   * some people may, so I am commenting out the offending code.
   * WARNING, this method may throw an exception if the value is null. Use "isNull(name)"
   * first, if you want to check.
   * @param name
   * @return
   */
  public final native double nativeGetValueAsNumber(String name) /*-{
    return Number(this.getValue(name))
  }-*/;

//GWT DevMode breaks if you uncomment this...
//  public Boolean getValueAsBoolean(String name) {
//    if (isNull(name)) {
//      return null;
//    } else {
//      return nativeGetValueAsBoolean(name);
//    }
//  }

  /**
   * See the source code. There is a GWT bug in DevMode. I don't normally use DevMode but
   * some people may, so I am commenting out the offending code.
   * WARNING, this method may throw an exception if the value is null. Use "isNull(name)"
   * first, if you want to check.
   * @param name
   * @return
   */
  public final native boolean nativeGetValueAsBoolean(String name) /*-{
    return Boolean(this.getValue(name))
  }-*/;

  public final native <T extends JavaScriptObject> void setValue(T value) /*-{
    this.setValue(value)
  }-*/;

  public final native void setValue(String value) /*-{
    this.setValue(value)
  }-*/;

  public final native void setValue(int value) /*-{
    this.setValue(value)
  }-*/;

  public final native void setValue(double value) /*-{
    this.setValue(value)
  }-*/;

  public final native void setValue(boolean value) /*-{
    this.setValue(value)
  }-*/;
}

package org.cesiumjs.cesium.mixins;

import org.cesiumjs.cesium.Viewer;
import org.cesiumjs.cesium.data.Entity;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author richkadel
 *
 */
public final class ViewerEntityMixin extends JavaScriptObject {
  // Overlay types always have protected, zero argument constructors.
  protected ViewerEntityMixin(){}
  
  public static native ViewerEntityMixin create(Viewer viewer) /*-{
    viewer.extend(Cesium.viewerEntityMixin)
    return {
      viewer : viewer
    }
  }-*/;
  
  public native void setTrackedEntity(Entity entity) /*-{
    this.viewer.trackedEntity = entity
  }-*/;
  
  public native void setSelectedEntity(Entity entity) /*-{
    this.viewer.selectedEntity = entity
  }-*/;
}
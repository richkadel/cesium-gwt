package org.cesiumjs.cesium.data;


import org.cesiumjs.cesium.events.Event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class EntityCollection extends JavaScriptObject
{
  protected EntityCollection() {}
  
  public static final native EntityCollection create() /*-{
    return new Cesium.EntityCollection();
  }-*/;
 
  public final native JsArray<Entity> getEntities() /*-{
    return this.entities;
  }-*/;
 
  public final native String getId() /*-{
    return this.id;
  }-*/;
 
  public final native Event onCollectionChanged() /*-{
    return this.collectionChanged;
  }-*/;
 
  public final void add(Entity... entities) {
    for (Entity entity : entities) {
      add(entity);
    }
  }
  
  public final native void add(Entity entity) /*-{
    this.add(entity);
  }-*/;

  public final native Entity getById(Object id) /*-{
    return this.getById(id);
  }-*/;

  public final native Entity getOrCreateEntity(Object id) /*-{
    return this.getOrCreateEntity(id);
  }-*/;

  public final native boolean removeById(Object id) /*-{
    return this.removeById(id);
  }-*/;

  public final native boolean remove(Entity entity) /*-{
    return this.remove(entity);
  }-*/;

  public final native void removeAll() /*-{
    this.removeAll();
  }-*/;

  public final native void resumeEvents() /*-{
    this.resumeEvents();
  }-*/;

  public final native void suspendEvents() /*-{
    this.suspendEvents();
  }-*/;
}

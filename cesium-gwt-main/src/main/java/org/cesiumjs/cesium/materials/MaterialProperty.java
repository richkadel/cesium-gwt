package org.cesiumjs.cesium.materials;

import org.cesiumjs.cesium.data.Property;
import org.cesiumjs.cesium.time.JulianDate;

/**
 * @author richkadel
 *
 */
public class MaterialProperty extends Property<Material> {
  // Overlay types always have protected, zero argument constructors.
  protected MaterialProperty(){}

  public static native MaterialProperty create() /*-{
    return new Cesium.MaterialProperty()
  }-*/;

  private final native String getType(JulianDate time) /*-{
    return this.getType(time)
  }-*/;
}
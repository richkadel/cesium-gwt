package org.cesiumjs.cesium.materials;

import org.cesiumjs.cesium.Color;
import org.cesiumjs.cesium.data.Property;

/**
 * @author richkadel
 *
 */
public class ColorMaterialProperty extends MaterialProperty {
  // Overlay types always have protected, zero argument constructors.
  protected ColorMaterialProperty(){}

  public static native ColorMaterialProperty create() /*-{
    return new Cesium.ColorMaterialProperty()
  }-*/;

  public static native MaterialProperty create(Property<Color> color) /*-{
    return new Cesium.ColorMaterialProperty(color)
  }-*/;

  public static native MaterialProperty fromColor(Color color) /*-{
    return Cesium.ColorMaterialProperty.fromColor(color)
  }-*/;
}
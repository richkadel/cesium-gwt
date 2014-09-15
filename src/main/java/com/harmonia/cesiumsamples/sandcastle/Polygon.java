package com.harmonia.cesiumsamples.sandcastle;

import org.cesiumjs.cesium.Cartesian3;
import org.cesiumjs.cesium.CesiumConfiguration;
import org.cesiumjs.cesium.CesiumWidget;
import org.cesiumjs.cesium.CesiumWidgetPanel;
import org.cesiumjs.cesium.Color;
import org.cesiumjs.cesium.ColorGeometryInstanceAttribute;
import org.cesiumjs.cesium.GeometryInstance;
import org.cesiumjs.cesium.GeometryInstanceAttributes;
import org.cesiumjs.cesium.PerInstanceColorAppearance;
import org.cesiumjs.cesium.PolygonGeometry;
import org.cesiumjs.cesium.PolygonGeometry.Holes;
import org.cesiumjs.cesium.PolygonGeometry.Hierarchy;
import org.cesiumjs.cesium.Primitive;
import org.cesiumjs.cesium.PrimitiveCollection;

import com.google.gwt.dom.client.Element;

public class Polygon extends CesiumWidgetPanel {

  private CesiumWidget cesiumWidget;

  public Polygon(CesiumConfiguration configuration) {
    super(configuration);
  }

  public CesiumWidget createCesiumWidget(Element element) {
    cesiumWidget = CesiumWidget.create(element);
    
    PrimitiveCollection primitives = cesiumWidget.getScene().getPrimitives();
  
    // Example 1: Draw a red polygon on the globe surface.
    
    // Create the polygon geometry. The positions here are
    // in counter clockwise order.
    double[] positions = Cartesian3.fromDegreesArray(new double[]{
      -115.0, 37.0,
      -115.0, 32.0,
      -107.0, 33.0,
      -102.0, 31.0,
      -102.0, 35.0
    });
    
    // Create a geometry instance using the polygon geometry.
    GeometryInstance redPolygonInstance = GeometryInstance.create(
      PolygonGeometry.fromPositions(
        positions, 
        PolygonGeometry.Options.create()
          .vertexFormat(PerInstanceColorAppearance.VERTEX_FORMAT)
      ).createGeometry() // CesiumGWT: From JS samples, it would appear you don't have to call createGeometry,
                         // but in many cases they seem to show this call is required. That being the case
                         // I do not feel comfortable making PolygonGeometry a subclass and have someone
                         // actually use the PolygonGeometry where a Geometry from createGeometry() may be
                         // required. So until otherwise corrected, this createGeometry() call is required here.
    )
    .setAttributes(GeometryInstanceAttributes.create()
      .setColor(ColorGeometryInstanceAttribute.fromColor(Color.RED))
    );
        
    // Example 2: Draw a blue polygon with holes.
    
    // To draw a polygon with holes, create a nested position
    // hierarchy defining the positions of the polygon
    // edges and the positions of the holes.
    Hierarchy polygonHierarchy = 
      Hierarchy.create(Cartesian3.fromDegreesArray(new double[] {
          -99.0, 30.0,
          -85.0, 30.0,
          -85.0, 40.0,
          -99.0, 40.0
          }),
        Holes.create(
          Hierarchy.create(Cartesian3.fromDegreesArray(new double[] {
              -97.0, 31.0,
              -97.0, 39.0,
              -87.0, 39.0,
              -87.0, 31.0
              }),
            Holes.create(
              Hierarchy.create(Cartesian3.fromDegreesArray(new double[] {
                  -95.0, 33.0,
                  -89.0, 33.0,
                  -89.0, 37.0,
                  -95.0, 37.0
                  }),
                Holes.create(
                  Hierarchy.create(Cartesian3.fromDegreesArray(new double[] {
                      -93.0, 34.0,
                      -91.0, 34.0,
                      -91.0, 36.0,
                      -93.0, 36.0
                    })
                  )
                )
              )
            )
          )
        )
      );
    
    // Create a geometry instance using the polygon geometry.
    GeometryInstance bluePolygonInstance = GeometryInstance.create(
      PolygonGeometry.create(
        polygonHierarchy,
        PolygonGeometry.Options.create()
          .vertexFormat(PerInstanceColorAppearance.VERTEX_FORMAT)
      ).createGeometry()
    )
    .setAttributes(GeometryInstanceAttributes.create()
      .setColor(ColorGeometryInstanceAttribute.fromColor(Color.BLUE))
    );
    
    // Example 3: Draw a green extruded polygon.
    
    // To extrude, use the extruded height option to specify
    // the height of the polygon geometry.
    positions = Cartesian3.fromDegreesArray(new double[] {
        -108.0, 42.0,
        -100.0, 42.0,
        -104.0, 40.0
    });
    GeometryInstance greenPolygonInstance = GeometryInstance.create(
      PolygonGeometry.fromPositions(
        positions,
        PolygonGeometry.Options.create()
          .extrudedHeightMeters(500000.0)
          .vertexFormat(PerInstanceColorAppearance.VERTEX_FORMAT)
      ).createGeometry()
    )
    .setAttributes(GeometryInstanceAttributes.create()
      .setColor(ColorGeometryInstanceAttribute.fromColor(Color.GREEN))
    );
    
    // Example 4: Draw an orange extruded polygon with
    // per position heights.
    
    positions = Cartesian3.fromDegreesArrayHeights(new double[] {
      -108.0, 25.0, 100000,
      -100.0, 25.0, 100000,
      -100.0, 30.0, 100000,
      -108.0, 30.0, 300000
    });
    
    // Set the perPositionHeight option to true for the polygon
    // to use the heights each position.  In this case, we are
    // also seting extrudedHeight to zero for the polygon
    // to be extruded down to the globe surface.
    GeometryInstance orangePolygonInstance = GeometryInstance.create(
      PolygonGeometry.fromPositions(
        positions,
        PolygonGeometry.Options.create()
          .extrudedHeightMeters(0)
          .vertexFormat(PerInstanceColorAppearance.VERTEX_FORMAT)
          .perPositionHeight(true)
      ).createGeometry()
    )
    .setAttributes(GeometryInstanceAttributes.create()
      .setColor(ColorGeometryInstanceAttribute.fromColor(Color.ORANGE))
    );
    
    // Add each polygon instance to primitives.
    primitives.add(
      Primitive.create(Primitive.Options.create()
        .geometryInstances(redPolygonInstance, greenPolygonInstance, bluePolygonInstance, orangePolygonInstance)
        .appearance(PerInstanceColorAppearance.create(
            PerInstanceColorAppearance.Options.create()
              .closed(true)
              .translucent(false)
          )
        )
      )
    );
 
    return cesiumWidget;
  }
}

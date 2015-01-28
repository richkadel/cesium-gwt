package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;

public final class CircleOutlineGeometry extends JavaScriptObject {

	protected CircleOutlineGeometry() {}
	
	public static native CircleOutlineGeometry create(Options options) /*-{
		return new Cesium.CircleOutlineGeometry(options)
	}-*/;
	
	public native Geometry createGeometry() /*-{
	  return Cesium.CircleOutlineGeometry.createGeometry(this)
	}-*/;

	 public static final class Options extends JavaScriptObject {

		 protected Options(){}
		 
		 public static native Options create() /*-{
	      return {}
	     }-*/;
		 
		 public native Options center(Cartesian3 center) /*-{
	      this.center = center
	      return this;
	     }-*/;
		 
		 public native Options radiusMeters(double radiusMeters) /*-{
	      this.radius = radiusMeters
	      return this;
	     }-*/;
		 
		 public native Options ellipsoid(Ellipsoid ellipsoid) /*-{
	      this.ellipsoid = ellipsoid
	      return this;
	     }-*/;
		     
		 public native Options heightMeters(double heightMeters) /*-{
	      this.height = heightMeters
	      return this;
	     }-*/;
		 
		 public native Options granularityRadians(double granularityRadians) /*-{
	      this.granularity = granularityRadians
	      return this;
	     }-*/;
		 
		 public native Options extrudedHeightMeters(double extrudedHeightMeters) /*-{
	      this.extrudedHeight = extrudedHeightMeters
	      return this;
	     }-*/;
		 
		 public native Options numberOfVerticalLines(int numberOfVerticalLines) /*-{
	      this.numberOfVerticalLines = numberOfVerticalLines
	      return this;
	     }-*/;
	 }
}

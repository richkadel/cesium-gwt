package org.cesiumjs.cesium.materials;

import org.cesiumjs.cesium.Color;

public class PolylineOutlineMaterial extends Material
{
	protected PolylineOutlineMaterial() {}
	
	public final native void setColor(Color color) /*-{
		this.uniforms.color = color;
	}-*/;
	
	public final native void setOutlineColor(Color color) /*-{
		this.uniforms.outlineColor = color;
	}-*/;

	public final native void setOutlineWidth(double width) /*-{
		this.uniforms.outlineWidth = width;
	}-*/;

}

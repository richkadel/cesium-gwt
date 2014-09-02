package org.cesiumjs.cesium.materials;

import org.cesiumjs.cesium.Color;

public class PolylineGlow extends Material
{
	protected PolylineGlow() {}
	
	public final native void setColor(Color color) /*-{
		this.uniforms.color = color;
	}-*/;
	
	public final native void setGlowPower(double glowWidthFraction) /*-{
		this.uniforms.glowPower = glowWidthFraction;
	}-*/;


}

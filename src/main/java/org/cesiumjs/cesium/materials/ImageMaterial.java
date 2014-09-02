package org.cesiumjs.cesium.materials;

import org.cesiumjs.cesium.Cartesian2;


public class ImageMaterial extends Material
{
	protected ImageMaterial() {}
	
	public final native void setImage(String imageURL) /*-{
		this.uniforms.image = imageURL;
	}-*/;
	
	public final native void setRepeat(Cartesian2 repeat) /*-{
		this.uniforms.repeat = repeat;
	}-*/;


}

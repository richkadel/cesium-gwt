package org.cesiumjs.cesium;

public class CesiumConfiguration {

	private String cesiumPath;
	private String bingMapsKey;

	public String getCesiumPath() {
    return cesiumPath;
  }

	public CesiumConfiguration setCesiumPath(String cesiumPath) {
    this.cesiumPath = cesiumPath;
    if (cesiumPath != null && cesiumPath.length() > 0 
    		&& cesiumPath.charAt(cesiumPath.length()-1) != '/') {
    	this.cesiumPath = this.cesiumPath + "/";
    }
    return this;
	}

	/**
	 * @return the bingMapsKey
	 */
	public String getBingMapsKey() {
		return bingMapsKey;
	}

	/**
	 * @param bingMapsKey the bingMapsKey to set
	 * @return 
	 */
	public CesiumConfiguration setBingMapsKey(String bingMapsKey) {
		this.bingMapsKey = bingMapsKey;
    return this;
	}

}

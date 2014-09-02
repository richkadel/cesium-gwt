package org.cesiumjs.cesium;

import com.google.gwt.core.client.JavaScriptObject;


public class CesiumMath extends JavaScriptObject
{
	protected CesiumMath() {}
	
	private static native double getConstant(String name) /*-{
	  return Cesium.Math[name];
	}-*/;
	
	public static double DEGREES_PER_RADIAN = getConstant("DEGREES_PER_RADIAN");
	public static double EPSILON1  = getConstant("EPSILON1");
	public static double EPSILON2  = getConstant("EPSILON2");
	public static double EPSILON3  = getConstant("EPSILON3");
	public static double EPSILON4  = getConstant("EPSILON4");
	public static double EPSILON5  = getConstant("EPSILON5");
	public static double EPSILON6  = getConstant("EPSILON6");
	public static double EPSILON7  = getConstant("EPSILON7");
	public static double EPSILON8  = getConstant("EPSILON8");
	public static double EPSILON9  = getConstant("EPSILON9");
	public static double EPSILON10  = getConstant("EPSILON10");
	public static double EPSILON11  = getConstant("EPSILON11");
	public static double EPSILON12  = getConstant("EPSILON12");
	public static double EPSILON13  = getConstant("EPSILON13");
	public static double EPSILON14  = getConstant("EPSILON14");
	public static double EPSILON15  = getConstant("EPSILON15");
	public static double EPSILON16  = getConstant("EPSILON16");
	public static double EPSILON17  = getConstant("EPSILON17");
	public static double EPSILON18  = getConstant("EPSILON18");
	public static double EPSILON19  = getConstant("EPSILON19");
	public static double EPSILON20  = getConstant("EPSILON20");
	public static double GRAVITATIONALPARAMETER  = getConstant("GRAVITATIONALPARAMETER");
	public static double LUNAR_RADIUS = getConstant("LUNAR_RADIUS");
	public static double ONE_OVER_PI  = getConstant("ONE_OVER_PI");
	public static double ONE_OVER_TWO_PI = getConstant("ONE_OVER_TWO_PI");
	public static double PI = getConstant("PI");
	public static double PI_OVER_FOUR = getConstant("PI_OVER_FOUR");
	public static double PI_OVER_SIX = getConstant("PI_OVER_SIX");
	public static double PI_OVER_THREE = getConstant("PI_OVER_THREE");
	public static double PI_OVER_TWO = getConstant("DEGREES_PER_RADIAN");
	public static double RADIANS_PER_ARCSECOND = getConstant("RADIANS_PER_ARCSECOND");
	public static double RADIANS_PER_DEGREE = getConstant("RADIANS_PER_DEGREE");
	public static double SIXTY_FOUR_KILOBYTES = getConstant("SIXTY_FOUR_KILOBYTES");
	public static double SOLAR_RADIUS = getConstant("SOLAR_RADIUS");
	public static double THREE_PI_OVER_TWO = getConstant("THREE_PI_OVER_TWO");
	public static double TWO_PI = getConstant("TWO_PI");
	
	public static native double acosClamped(double value)/*-{
		return Cesium.Math.acosClamped(value);
	}-*/;
	
	public static native double asinClamped(double value) /*-{
		return Cesium.Math.asinClamped(value);
	}-*/;
	
	public static native double clamp(double value, double min, double max) /*-{
		return Cesium.Math.clamp(value, min, max);
	}-*/;
	
	public static native double convertLongitudeRange(double angle) /*-{
		return Cesium.Math.convertLongitudeRange(angle);
	}-*/;
	
	public static native double cosh(double value) /*-{
		return Cesium.Math.cosh(value);
	}-*/;
	
	public static native double equalsEpsilon(double left, double right, double epsilon) /*-{
		return Cesium.Math.clamp(left, right, epsilon);
	}-*/;
	
	public static native double factorial(double n) /*-{
		return Cesium.Math.factorial(n);
	}-*/;
	
	public static native double fromSNorm(double value) /*-{
		return Cesium.Math.fromSNorm(value);
	}-*/;
	
	public static native double incrementWrap(double n, double maximumValue, double minimumValue) /*-{
		return Cesium.Math.incrementWrap(n, maximumValue, minimumValue);
	}-*/;
	
	public static native boolean isPowerOfTwo(double value) /*-{
		return Cesium.Math.isPowerOfTwo(value);
	}-*/;
	
	public static native double lerp(double p, double q, double time) /*-{
		return Cesium.Math.lerp(p, q, time);
	}-*/;
	
	public static native double nextPowerOfTwo(double n) /*-{
		return Cesium.Math.nextPowerOfTwo(n);
	}-*/;
	
	public static native double nextRandomNumber() /*-{
		return Cesium.Math.nextRandomNumber();
	}-*/;
	
	public static native double setRandomNumberSeed(double seed) /*-{
		return Cesium.Math.setRandomNumberSeed(seed);
	}-*/;
	
	public static native double sign(double value) /*-{
		return Cesium.Math.sign(value);
	}-*/;
	
	public static native double signNotZero(double value) /*-{
		return Cesium.Math.signNotZero(value);
	}-*/;
	
	public static native double sinh(double value) /*-{
		return Cesium.Math.sinh(value);
	}-*/;
	
	public static native double toDegrees(double radians) /*-{
		return Cesium.Math.toDegrees(radians);
	}-*/;
	
	public static native double toRadians(double degrees) /*-{
		return Cesium.Math.toRadians(degrees);
	}-*/;
	
	public static native double toSNorm(double value) /*-{
		return Cesium.Math.toSNorm(value);
	}-*/;
	
	public static native double zeroToTwoPi(double angle) /*-{
		return Cesium.Math.zeroToTwoPi(angle);
	}-*/;

}

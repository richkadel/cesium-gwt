package org.cesiumjs.cesium;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LinkElement;

/**
 * @author richkadel
 *
 */
public final class Cesium extends JavaScriptObject {

  // Overlay types always have protected, zero argument constructors.
  protected Cesium() {}

  public static native Cesium get() /*-{
    if (typeof Cesium === "undefined") {
      return null
    } else {
      return Cesium
    }
  }-*/;

  public static void initialize(String cesiumPath, Document document,
      Callback<Void, Exception> callback) {
    CesiumInitializer cesiumInitializer = CesiumInitializer.get(document);
    if (cesiumInitializer != null) {
      cesiumInitializer.addCallback(callback);
    } else {
      LinkElement link = Document.get().createLinkElement();
      link.setRel("stylesheet");

      final String cesiumCss = cesiumPath + "Widgets/widgets.css";
      link.setHref(cesiumCss);
      document.getElementsByTagName("head").getItem(0).appendChild(link);

      new CesiumInitializer(cesiumPath, document, callback).initialize();
    }
  }

  public static native String getVersion() /*-{
    return Cesium.VERSION
  }-*/;

  /**
   * Why am I making this an inner class instead of its own class?
   * It's almost an either or, but here's my reason. Although some of the
   * Cesium-scoped functions are in separate classes (e.g., Ray.getPoint()
   * for one example), the only way to have equivalent scoping for
   * Cesium.Math would be to make this a class called "Math"; but that
   * is too similar to java.lang.Math, and I think it would very likely
   * become a class import conflict. One of the other contributors (Mark)
   * suggested CesiumMath. But now we're creating something "close" to
   * the JavaScript equivalent "Cesium.Math" and yet, not the same without
   * the dot. So why not keep at least this one the same "Cesium.Math"
   * syntax? So that's why.
   */
  public static class Math extends JavaScriptObject {
    protected Math() {
    }

    private static native double getConstant(String name) /*-{
      return Cesium.Math[name];
    }-*/;

    public static final double DEGREES_PER_RADIAN = getConstant("DEGREES_PER_RADIAN");
    public static final double EPSILON1 = getConstant("EPSILON1");
    public static final double EPSILON2 = getConstant("EPSILON2");
    public static final double EPSILON3 = getConstant("EPSILON3");
    public static final double EPSILON4 = getConstant("EPSILON4");
    public static final double EPSILON5 = getConstant("EPSILON5");
    public static final double EPSILON6 = getConstant("EPSILON6");
    public static final double EPSILON7 = getConstant("EPSILON7");
    public static final double EPSILON8 = getConstant("EPSILON8");
    public static final double EPSILON9 = getConstant("EPSILON9");
    public static final double EPSILON10 = getConstant("EPSILON10");
    public static final double EPSILON11 = getConstant("EPSILON11");
    public static final double EPSILON12 = getConstant("EPSILON12");
    public static final double EPSILON13 = getConstant("EPSILON13");
    public static final double EPSILON14 = getConstant("EPSILON14");
    public static final double EPSILON15 = getConstant("EPSILON15");
    public static final double EPSILON16 = getConstant("EPSILON16");
    public static final double EPSILON17 = getConstant("EPSILON17");
    public static final double EPSILON18 = getConstant("EPSILON18");
    public static final double EPSILON19 = getConstant("EPSILON19");
    public static final double EPSILON20 = getConstant("EPSILON20");
    public static final double GRAVITATIONALPARAMETER = getConstant("GRAVITATIONALPARAMETER");
    public static final double LUNAR_RADIUS = getConstant("LUNAR_RADIUS");
    public static final double ONE_OVER_PI = getConstant("ONE_OVER_PI");
    public static final double ONE_OVER_TWO_PI = getConstant("ONE_OVER_TWO_PI");
    public static final double PI = getConstant("PI");
    public static final double PI_OVER_FOUR = getConstant("PI_OVER_FOUR");
    public static final double PI_OVER_SIX = getConstant("PI_OVER_SIX");
    public static final double PI_OVER_THREE = getConstant("PI_OVER_THREE");
    public static final double PI_OVER_TWO = getConstant("DEGREES_PER_RADIAN");
    public static final double RADIANS_PER_ARCSECOND = getConstant("RADIANS_PER_ARCSECOND");
    public static final double RADIANS_PER_DEGREE = getConstant("RADIANS_PER_DEGREE");
    public static final double SIXTY_FOUR_KILOBYTES = getConstant("SIXTY_FOUR_KILOBYTES");
    public static final double SOLAR_RADIUS = getConstant("SOLAR_RADIUS");
    public static final double THREE_PI_OVER_TWO = getConstant("THREE_PI_OVER_TWO");
    public static final double TWO_PI = getConstant("TWO_PI");

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

    public static native double equalsEpsilon(double left, double right,
        double epsilon) /*-{
      return Cesium.Math.clamp(left, right, epsilon);
    }-*/;

    public static native double factorial(double n) /*-{
      return Cesium.Math.factorial(n);
    }-*/;

    public static native double fromSNorm(double value) /*-{
      return Cesium.Math.fromSNorm(value);
    }-*/;

    public static native double incrementWrap(double n, double maximumValue,
        double minimumValue) /*-{
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

    public static native void setRandomNumberSeed(double seed) /*-{
      Cesium.Math.setRandomNumberSeed(seed);
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
}
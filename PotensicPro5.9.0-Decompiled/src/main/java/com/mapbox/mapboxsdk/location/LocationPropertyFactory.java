package com.mapbox.mapboxsdk.location;

import com.mapbox.mapboxsdk.style.expressions.Expression;
import com.mapbox.mapboxsdk.style.layers.LayoutPropertyValue;
import com.mapbox.mapboxsdk.style.layers.PaintPropertyValue;
import com.mapbox.mapboxsdk.style.layers.PropertyValue;
import com.mapbox.mapboxsdk.utils.ColorUtils;

/* loaded from: classes3.dex */
class LocationPropertyFactory {
    LocationPropertyFactory() {
    }

    public static PropertyValue<String> visibility(String str) {
        return new LayoutPropertyValue("visibility", str);
    }

    public static PropertyValue<Float> perspectiveCompensation(Float f) {
        return new PaintPropertyValue("perspective-compensation", f);
    }

    public static PropertyValue<Expression> perspectiveCompensation(Expression expression) {
        return new PaintPropertyValue("perspective-compensation", expression);
    }

    public static PropertyValue<Float> imageTiltDisplacement(Float f) {
        return new PaintPropertyValue("image-pitch-displacement", f);
    }

    public static PropertyValue<Expression> imageTiltDisplacement(Expression expression) {
        return new PaintPropertyValue("image-pitch-displacement", expression);
    }

    public static PropertyValue<Float> imagePitchDisplacement(Float f) {
        return new PaintPropertyValue("image-pitch-displacement", f);
    }

    public static PropertyValue<Expression> imagePitchDisplacement(Expression expression) {
        return new PaintPropertyValue("image-pitch-displacement", expression);
    }

    public static PropertyValue<Double> bearing(Double d) {
        return new PaintPropertyValue("bearing", d);
    }

    public static PropertyValue<Expression> bearing(Expression expression) {
        return new PaintPropertyValue("bearing", expression);
    }

    public static PropertyValue<Double[]> location(Double[] dArr) {
        return new PaintPropertyValue("location", dArr);
    }

    public static PropertyValue<Expression> location(Expression expression) {
        return new PaintPropertyValue("location", expression);
    }

    public static PropertyValue<Float> accuracyRadius(Float f) {
        return new PaintPropertyValue("accuracy-radius", f);
    }

    public static PropertyValue<Expression> accuracyRadius(Expression expression) {
        return new PaintPropertyValue("accuracy-radius", expression);
    }

    public static PropertyValue<Float> topImageSize(Float f) {
        return new PaintPropertyValue("top-image-size", f);
    }

    public static PropertyValue<Expression> topImageSize(Expression expression) {
        return new PaintPropertyValue("top-image-size", expression);
    }

    public static PropertyValue<Float> bearingImageSize(Float f) {
        return new PaintPropertyValue("bearing-image-size", f);
    }

    public static PropertyValue<Expression> bearingImageSize(Expression expression) {
        return new PaintPropertyValue("bearing-image-size", expression);
    }

    public static PropertyValue<Float> shadowImageSize(Float f) {
        return new PaintPropertyValue("shadow-image-size", f);
    }

    public static PropertyValue<Expression> shadowImageSize(Expression expression) {
        return new PaintPropertyValue("shadow-image-size", expression);
    }

    public static PropertyValue<String> accuracyRadiusColor(int i) {
        return new PaintPropertyValue("accuracy-radius-color", ColorUtils.colorToRgbaString(i));
    }

    public static PropertyValue<String> accuracyRadiusColor(String str) {
        return new PaintPropertyValue("accuracy-radius-color", str);
    }

    public static PropertyValue<Expression> accuracyRadiusColor(Expression expression) {
        return new PaintPropertyValue("accuracy-radius-color", expression);
    }

    public static PropertyValue<String> accuracyRadiusBorderColor(int i) {
        return new PaintPropertyValue("accuracy-radius-border-color", ColorUtils.colorToRgbaString(i));
    }

    public static PropertyValue<String> accuracyRadiusBorderColor(String str) {
        return new PaintPropertyValue("accuracy-radius-border-color", str);
    }

    public static PropertyValue<Expression> accuracyRadiusBorderColor(Expression expression) {
        return new PaintPropertyValue("accuracy-radius-border-color", expression);
    }

    public static PropertyValue<String> topImage(String str) {
        return new LayoutPropertyValue("top-image", str);
    }

    public static PropertyValue<Expression> topImage(Expression expression) {
        return new LayoutPropertyValue("top-image", expression);
    }

    public static PropertyValue<String> bearingImage(String str) {
        return new LayoutPropertyValue("bearing-image", str);
    }

    public static PropertyValue<Expression> bearingImage(Expression expression) {
        return new LayoutPropertyValue("bearing-image", expression);
    }

    public static PropertyValue<String> shadowImage(String str) {
        return new LayoutPropertyValue("shadow-image", str);
    }

    public static PropertyValue<Expression> shadowImage(Expression expression) {
        return new LayoutPropertyValue("shadow-image", expression);
    }
}

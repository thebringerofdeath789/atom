package com.mapbox.mapboxsdk.location;

import com.mapbox.mapboxsdk.style.layers.Layer;
import com.mapbox.mapboxsdk.style.layers.PropertyValue;
import com.mapbox.mapboxsdk.style.layers.TransitionOptions;
import com.mapbox.mapboxsdk.utils.ColorUtils;

/* loaded from: classes3.dex */
class LocationIndicatorLayer extends Layer {
    private native Object nativeGetAccuracyRadius();

    private native Object nativeGetAccuracyRadiusBorderColor();

    private native TransitionOptions nativeGetAccuracyRadiusBorderColorTransition();

    private native Object nativeGetAccuracyRadiusColor();

    private native TransitionOptions nativeGetAccuracyRadiusColorTransition();

    private native TransitionOptions nativeGetAccuracyRadiusTransition();

    private native Object nativeGetBearing();

    private native Object nativeGetBearingImage();

    private native Object nativeGetBearingImageSize();

    private native TransitionOptions nativeGetBearingImageSizeTransition();

    private native Object nativeGetImagePitchDisplacement();

    private native Object nativeGetImageTiltDisplacement();

    private native Object nativeGetLocation();

    private native TransitionOptions nativeGetLocationTransition();

    private native Object nativeGetPerspectiveCompensation();

    private native Object nativeGetShadowImage();

    private native Object nativeGetShadowImageSize();

    private native TransitionOptions nativeGetShadowImageSizeTransition();

    private native Object nativeGetTopImage();

    private native Object nativeGetTopImageSize();

    private native TransitionOptions nativeGetTopImageSizeTransition();

    private native void nativeSetAccuracyRadiusBorderColorTransition(long j, long j2);

    private native void nativeSetAccuracyRadiusColorTransition(long j, long j2);

    private native void nativeSetAccuracyRadiusTransition(long j, long j2);

    private native void nativeSetBearingImageSizeTransition(long j, long j2);

    private native void nativeSetLocationTransition(long j, long j2);

    private native void nativeSetShadowImageSizeTransition(long j, long j2);

    private native void nativeSetTopImageSizeTransition(long j, long j2);

    @Override // com.mapbox.mapboxsdk.style.layers.Layer
    protected native void finalize() throws Throwable;

    protected native void initialize(String str);

    LocationIndicatorLayer(long j) {
        super(j);
    }

    public LocationIndicatorLayer(String str) {
        initialize(str);
    }

    public LocationIndicatorLayer withProperties(PropertyValue<?>... propertyValueArr) {
        setProperties(propertyValueArr);
        return this;
    }

    public PropertyValue<String> getTopImage() {
        checkThread();
        return new PropertyValue<>("top-image", nativeGetTopImage());
    }

    public PropertyValue<String> getBearingImage() {
        checkThread();
        return new PropertyValue<>("bearing-image", nativeGetBearingImage());
    }

    public PropertyValue<String> getShadowImage() {
        checkThread();
        return new PropertyValue<>("shadow-image", nativeGetShadowImage());
    }

    public PropertyValue<Float> getPerspectiveCompensation() {
        checkThread();
        return new PropertyValue<>("perspective-compensation", nativeGetPerspectiveCompensation());
    }

    @Deprecated
    public PropertyValue<Float> getImageTiltDisplacement() {
        checkThread();
        return new PropertyValue<>("image-pitch-displacement", nativeGetImageTiltDisplacement());
    }

    public PropertyValue<Float> getImagePitchDisplacement() {
        checkThread();
        return new PropertyValue<>("image-pitch-displacement", nativeGetImagePitchDisplacement());
    }

    public PropertyValue<Double> getBearing() {
        checkThread();
        return new PropertyValue<>("bearing", nativeGetBearing());
    }

    public PropertyValue<Double[]> getLocation() {
        checkThread();
        return new PropertyValue<>("location", nativeGetLocation());
    }

    public TransitionOptions getLocationTransition() {
        checkThread();
        return nativeGetLocationTransition();
    }

    public void setLocationTransition(TransitionOptions transitionOptions) {
        checkThread();
        nativeSetLocationTransition(transitionOptions.getDuration(), transitionOptions.getDelay());
    }

    public PropertyValue<Float> getAccuracyRadius() {
        checkThread();
        return new PropertyValue<>("accuracy-radius", nativeGetAccuracyRadius());
    }

    public TransitionOptions getAccuracyRadiusTransition() {
        checkThread();
        return nativeGetAccuracyRadiusTransition();
    }

    public void setAccuracyRadiusTransition(TransitionOptions transitionOptions) {
        checkThread();
        nativeSetAccuracyRadiusTransition(transitionOptions.getDuration(), transitionOptions.getDelay());
    }

    public PropertyValue<Float> getTopImageSize() {
        checkThread();
        return new PropertyValue<>("top-image-size", nativeGetTopImageSize());
    }

    public TransitionOptions getTopImageSizeTransition() {
        checkThread();
        return nativeGetTopImageSizeTransition();
    }

    public void setTopImageSizeTransition(TransitionOptions transitionOptions) {
        checkThread();
        nativeSetTopImageSizeTransition(transitionOptions.getDuration(), transitionOptions.getDelay());
    }

    public PropertyValue<Float> getBearingImageSize() {
        checkThread();
        return new PropertyValue<>("bearing-image-size", nativeGetBearingImageSize());
    }

    public TransitionOptions getBearingImageSizeTransition() {
        checkThread();
        return nativeGetBearingImageSizeTransition();
    }

    public void setBearingImageSizeTransition(TransitionOptions transitionOptions) {
        checkThread();
        nativeSetBearingImageSizeTransition(transitionOptions.getDuration(), transitionOptions.getDelay());
    }

    public PropertyValue<Float> getShadowImageSize() {
        checkThread();
        return new PropertyValue<>("shadow-image-size", nativeGetShadowImageSize());
    }

    public TransitionOptions getShadowImageSizeTransition() {
        checkThread();
        return nativeGetShadowImageSizeTransition();
    }

    public void setShadowImageSizeTransition(TransitionOptions transitionOptions) {
        checkThread();
        nativeSetShadowImageSizeTransition(transitionOptions.getDuration(), transitionOptions.getDelay());
    }

    public PropertyValue<String> getAccuracyRadiusColor() {
        checkThread();
        return new PropertyValue<>("accuracy-radius-color", nativeGetAccuracyRadiusColor());
    }

    public int getAccuracyRadiusColorAsInt() {
        checkThread();
        PropertyValue<String> accuracyRadiusColor = getAccuracyRadiusColor();
        if (accuracyRadiusColor.isValue()) {
            return ColorUtils.rgbaToColor(accuracyRadiusColor.getValue());
        }
        throw new RuntimeException("accuracy-radius-color was set as a Function");
    }

    public TransitionOptions getAccuracyRadiusColorTransition() {
        checkThread();
        return nativeGetAccuracyRadiusColorTransition();
    }

    public void setAccuracyRadiusColorTransition(TransitionOptions transitionOptions) {
        checkThread();
        nativeSetAccuracyRadiusColorTransition(transitionOptions.getDuration(), transitionOptions.getDelay());
    }

    public PropertyValue<String> getAccuracyRadiusBorderColor() {
        checkThread();
        return new PropertyValue<>("accuracy-radius-border-color", nativeGetAccuracyRadiusBorderColor());
    }

    public int getAccuracyRadiusBorderColorAsInt() {
        checkThread();
        PropertyValue<String> accuracyRadiusBorderColor = getAccuracyRadiusBorderColor();
        if (accuracyRadiusBorderColor.isValue()) {
            return ColorUtils.rgbaToColor(accuracyRadiusBorderColor.getValue());
        }
        throw new RuntimeException("accuracy-radius-border-color was set as a Function");
    }

    public TransitionOptions getAccuracyRadiusBorderColorTransition() {
        checkThread();
        return nativeGetAccuracyRadiusBorderColorTransition();
    }

    public void setAccuracyRadiusBorderColorTransition(TransitionOptions transitionOptions) {
        checkThread();
        nativeSetAccuracyRadiusBorderColorTransition(transitionOptions.getDuration(), transitionOptions.getDelay());
    }
}
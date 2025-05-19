package com.mapbox.mapboxsdk.maps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.mapbox.mapboxsdk.R;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.constants.MapboxConstants;
import com.mapbox.mapboxsdk.maps.widgets.CompassView;
import com.mapbox.mapboxsdk.utils.BitmapUtils;
import com.mapbox.mapboxsdk.utils.ColorUtils;

/* loaded from: classes3.dex */
public final class UiSettings {
    private AttributionDialogManager attributionDialogManager;
    ImageView attributionsView;
    private double clockwiseBearing;
    CompassView compassView;
    private final FocalPointChangeListener focalPointChangeListener;
    ImageView logoView;
    private final MapView mapView;
    private final float pixelRatio;
    private final Projection projection;
    private PointF userProvidedFocalPoint;
    private final int[] compassMargins = new int[4];
    private final int[] attributionsMargins = new int[4];
    private final int[] logoMargins = new int[4];
    private boolean rotateGesturesEnabled = true;
    private boolean tiltGesturesEnabled = true;
    private boolean zoomGesturesEnabled = true;
    private boolean scrollGesturesEnabled = true;
    private boolean horizontalScrollGesturesEnabled = true;
    private boolean doubleTapGesturesEnabled = true;
    private boolean quickZoomGesturesEnabled = true;
    private boolean scaleVelocityAnimationEnabled = true;
    private boolean rotateVelocityAnimationEnabled = true;
    private boolean flingVelocityAnimationEnabled = true;
    private boolean increaseRotateThresholdWhenScaling = true;
    private boolean disableRotateWhenScaling = true;
    private boolean increaseScaleThresholdWhenRotating = true;
    private float zoomRate = 1.0f;
    private boolean deselectMarkersOnTap = true;
    boolean isCompassInitialized = false;
    boolean isAttributionInitialized = false;
    boolean isLogoInitialized = false;

    UiSettings(Projection projection, FocalPointChangeListener focalPointChangeListener, float f, MapView mapView) {
        this.projection = projection;
        this.focalPointChangeListener = focalPointChangeListener;
        this.pixelRatio = f;
        this.mapView = mapView;
    }

    void initialise(Context context, MapboxMapOptions mapboxMapOptions) {
        Resources resources = context.getResources();
        initialiseGestures(mapboxMapOptions);
        if (mapboxMapOptions.getCompassEnabled()) {
            initialiseCompass(mapboxMapOptions, resources);
        }
        if (mapboxMapOptions.getLogoEnabled()) {
            initialiseLogo(mapboxMapOptions, resources);
        }
        if (mapboxMapOptions.getAttributionEnabled()) {
            initialiseAttribution(context, mapboxMapOptions);
        }
    }

    void onSaveInstanceState(Bundle bundle) {
        saveGestures(bundle);
        saveCompass(bundle);
        saveLogo(bundle);
        saveAttribution(bundle);
        saveDeselectMarkersOnTap(bundle);
        saveFocalPoint(bundle);
    }

    void onRestoreInstanceState(Bundle bundle) {
        restoreGestures(bundle);
        restoreCompass(bundle);
        restoreLogo(bundle);
        restoreAttribution(bundle);
        restoreDeselectMarkersOnTap(bundle);
        restoreFocalPoint(bundle);
    }

    private void initialiseGestures(MapboxMapOptions mapboxMapOptions) {
        setZoomGesturesEnabled(mapboxMapOptions.getZoomGesturesEnabled());
        setScrollGesturesEnabled(mapboxMapOptions.getScrollGesturesEnabled());
        setHorizontalScrollGesturesEnabled(mapboxMapOptions.getHorizontalScrollGesturesEnabled());
        setRotateGesturesEnabled(mapboxMapOptions.getRotateGesturesEnabled());
        setTiltGesturesEnabled(mapboxMapOptions.getTiltGesturesEnabled());
        setDoubleTapGesturesEnabled(mapboxMapOptions.getDoubleTapGesturesEnabled());
        setQuickZoomGesturesEnabled(mapboxMapOptions.getQuickZoomGesturesEnabled());
    }

    private void saveGestures(Bundle bundle) {
        bundle.putBoolean(MapboxConstants.STATE_HORIZONAL_SCROLL_ENABLED, isHorizontalScrollGesturesEnabled());
        bundle.putBoolean(MapboxConstants.STATE_ZOOM_ENABLED, isZoomGesturesEnabled());
        bundle.putBoolean(MapboxConstants.STATE_SCROLL_ENABLED, isScrollGesturesEnabled());
        bundle.putBoolean(MapboxConstants.STATE_ROTATE_ENABLED, isRotateGesturesEnabled());
        bundle.putBoolean(MapboxConstants.STATE_TILT_ENABLED, isTiltGesturesEnabled());
        bundle.putBoolean(MapboxConstants.STATE_DOUBLE_TAP_ENABLED, isDoubleTapGesturesEnabled());
        bundle.putBoolean(MapboxConstants.STATE_SCALE_ANIMATION_ENABLED, isScaleVelocityAnimationEnabled());
        bundle.putBoolean(MapboxConstants.STATE_ROTATE_ANIMATION_ENABLED, isRotateVelocityAnimationEnabled());
        bundle.putBoolean(MapboxConstants.STATE_FLING_ANIMATION_ENABLED, isFlingVelocityAnimationEnabled());
        bundle.putBoolean(MapboxConstants.STATE_INCREASE_ROTATE_THRESHOLD, isIncreaseRotateThresholdWhenScaling());
        bundle.putBoolean(MapboxConstants.STATE_DISABLE_ROTATE_WHEN_SCALING, isDisableRotateWhenScaling());
        bundle.putBoolean(MapboxConstants.STATE_INCREASE_SCALE_THRESHOLD, isIncreaseScaleThresholdWhenRotating());
        bundle.putBoolean(MapboxConstants.STATE_QUICK_ZOOM_ENABLED, isQuickZoomGesturesEnabled());
        bundle.putFloat(MapboxConstants.STATE_ZOOM_RATE, getZoomRate());
    }

    private void restoreGestures(Bundle bundle) {
        setHorizontalScrollGesturesEnabled(bundle.getBoolean(MapboxConstants.STATE_HORIZONAL_SCROLL_ENABLED));
        setZoomGesturesEnabled(bundle.getBoolean(MapboxConstants.STATE_ZOOM_ENABLED));
        setScrollGesturesEnabled(bundle.getBoolean(MapboxConstants.STATE_SCROLL_ENABLED));
        setRotateGesturesEnabled(bundle.getBoolean(MapboxConstants.STATE_ROTATE_ENABLED));
        setTiltGesturesEnabled(bundle.getBoolean(MapboxConstants.STATE_TILT_ENABLED));
        setDoubleTapGesturesEnabled(bundle.getBoolean(MapboxConstants.STATE_DOUBLE_TAP_ENABLED));
        setScaleVelocityAnimationEnabled(bundle.getBoolean(MapboxConstants.STATE_SCALE_ANIMATION_ENABLED));
        setRotateVelocityAnimationEnabled(bundle.getBoolean(MapboxConstants.STATE_ROTATE_ANIMATION_ENABLED));
        setFlingVelocityAnimationEnabled(bundle.getBoolean(MapboxConstants.STATE_FLING_ANIMATION_ENABLED));
        setIncreaseRotateThresholdWhenScaling(bundle.getBoolean(MapboxConstants.STATE_INCREASE_ROTATE_THRESHOLD));
        setDisableRotateWhenScaling(bundle.getBoolean(MapboxConstants.STATE_DISABLE_ROTATE_WHEN_SCALING));
        setIncreaseScaleThresholdWhenRotating(bundle.getBoolean(MapboxConstants.STATE_INCREASE_SCALE_THRESHOLD));
        setQuickZoomGesturesEnabled(bundle.getBoolean(MapboxConstants.STATE_QUICK_ZOOM_ENABLED));
        setZoomRate(bundle.getFloat(MapboxConstants.STATE_ZOOM_RATE, 1.0f));
    }

    private void initialiseCompass(MapboxMapOptions mapboxMapOptions, Resources resources) {
        this.isCompassInitialized = true;
        this.compassView = this.mapView.initialiseCompassView();
        setCompassEnabled(mapboxMapOptions.getCompassEnabled());
        setCompassGravity(mapboxMapOptions.getCompassGravity());
        int[] compassMargins = mapboxMapOptions.getCompassMargins();
        if (compassMargins != null) {
            setCompassMargins(compassMargins[0], compassMargins[1], compassMargins[2], compassMargins[3]);
        } else {
            int dimension = (int) resources.getDimension(R.dimen.mapbox_four_dp);
            setCompassMargins(dimension, dimension, dimension, dimension);
        }
        setCompassFadeFacingNorth(mapboxMapOptions.getCompassFadeFacingNorth());
        if (mapboxMapOptions.getCompassImage() != null) {
            setCompassImage(mapboxMapOptions.getCompassImage());
        }
        setCompassImageResource(mapboxMapOptions.getCompassImageResource());
    }

    private void saveCompass(Bundle bundle) {
        bundle.putBoolean(MapboxConstants.STATE_COMPASS_ENABLED, isCompassEnabled());
        bundle.putInt(MapboxConstants.STATE_COMPASS_GRAVITY, getCompassGravity());
        bundle.putInt(MapboxConstants.STATE_COMPASS_MARGIN_LEFT, getCompassMarginLeft());
        bundle.putInt(MapboxConstants.STATE_COMPASS_MARGIN_TOP, getCompassMarginTop());
        bundle.putInt(MapboxConstants.STATE_COMPASS_MARGIN_BOTTOM, getCompassMarginBottom());
        bundle.putInt(MapboxConstants.STATE_COMPASS_MARGIN_RIGHT, getCompassMarginRight());
        bundle.putBoolean(MapboxConstants.STATE_COMPASS_FADE_WHEN_FACING_NORTH, isCompassFadeWhenFacingNorth());
        CompassView compassView = this.compassView;
        if (compassView != null && compassView.isLegacyImageDrawableSetter()) {
            bundle.putByteArray(MapboxConstants.STATE_COMPASS_IMAGE_BITMAP, BitmapUtils.getByteArrayFromDrawable(getCompassImage()));
        } else {
            bundle.putInt(MapboxConstants.STATE_COMPASS_IMAGE_RES, getCompassImageResource());
        }
    }

    private void restoreCompass(Bundle bundle) {
        if (bundle.getBoolean(MapboxConstants.STATE_COMPASS_ENABLED) && !this.isCompassInitialized) {
            this.compassView = this.mapView.initialiseCompassView();
            this.isCompassInitialized = true;
        }
        setCompassEnabled(bundle.getBoolean(MapboxConstants.STATE_COMPASS_ENABLED));
        setCompassGravity(bundle.getInt(MapboxConstants.STATE_COMPASS_GRAVITY));
        setCompassMargins(bundle.getInt(MapboxConstants.STATE_COMPASS_MARGIN_LEFT), bundle.getInt(MapboxConstants.STATE_COMPASS_MARGIN_TOP), bundle.getInt(MapboxConstants.STATE_COMPASS_MARGIN_RIGHT), bundle.getInt(MapboxConstants.STATE_COMPASS_MARGIN_BOTTOM));
        setCompassFadeFacingNorth(bundle.getBoolean(MapboxConstants.STATE_COMPASS_FADE_WHEN_FACING_NORTH));
        if (bundle.containsKey(MapboxConstants.STATE_COMPASS_IMAGE_BITMAP)) {
            setCompassImage(BitmapUtils.getDrawableFromByteArray(this.mapView.getContext(), bundle.getByteArray(MapboxConstants.STATE_COMPASS_IMAGE_BITMAP)));
        } else {
            setCompassImageResource(bundle.getInt(MapboxConstants.STATE_COMPASS_IMAGE_RES));
        }
    }

    private void initialiseLogo(MapboxMapOptions mapboxMapOptions, Resources resources) {
        this.isLogoInitialized = true;
        this.logoView = this.mapView.initialiseLogoView();
        setLogoEnabled(mapboxMapOptions.getLogoEnabled());
        setLogoGravity(mapboxMapOptions.getLogoGravity());
        setLogoMargins(resources, mapboxMapOptions.getLogoMargins());
    }

    private void setLogoMargins(Resources resources, int[] iArr) {
        if (iArr != null) {
            setLogoMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
        } else {
            int dimension = (int) resources.getDimension(R.dimen.mapbox_four_dp);
            setLogoMargins(dimension, dimension, dimension, dimension);
        }
    }

    private void saveLogo(Bundle bundle) {
        bundle.putInt(MapboxConstants.STATE_LOGO_GRAVITY, getLogoGravity());
        bundle.putInt(MapboxConstants.STATE_LOGO_MARGIN_LEFT, getLogoMarginLeft());
        bundle.putInt(MapboxConstants.STATE_LOGO_MARGIN_TOP, getLogoMarginTop());
        bundle.putInt(MapboxConstants.STATE_LOGO_MARGIN_RIGHT, getLogoMarginRight());
        bundle.putInt(MapboxConstants.STATE_LOGO_MARGIN_BOTTOM, getLogoMarginBottom());
        bundle.putBoolean(MapboxConstants.STATE_LOGO_ENABLED, isLogoEnabled());
    }

    private void restoreLogo(Bundle bundle) {
        if (bundle.getBoolean(MapboxConstants.STATE_LOGO_ENABLED) && !this.isLogoInitialized) {
            this.logoView = this.mapView.initialiseLogoView();
            this.isLogoInitialized = true;
        }
        setLogoEnabled(bundle.getBoolean(MapboxConstants.STATE_LOGO_ENABLED));
        setLogoGravity(bundle.getInt(MapboxConstants.STATE_LOGO_GRAVITY));
        setLogoMargins(bundle.getInt(MapboxConstants.STATE_LOGO_MARGIN_LEFT), bundle.getInt(MapboxConstants.STATE_LOGO_MARGIN_TOP), bundle.getInt(MapboxConstants.STATE_LOGO_MARGIN_RIGHT), bundle.getInt(MapboxConstants.STATE_LOGO_MARGIN_BOTTOM));
    }

    private void initialiseAttribution(Context context, MapboxMapOptions mapboxMapOptions) {
        this.isAttributionInitialized = true;
        this.attributionsView = this.mapView.initialiseAttributionView();
        setAttributionEnabled(mapboxMapOptions.getAttributionEnabled());
        setAttributionGravity(mapboxMapOptions.getAttributionGravity());
        setAttributionMargins(context, mapboxMapOptions.getAttributionMargins());
        int attributionTintColor = mapboxMapOptions.getAttributionTintColor();
        if (attributionTintColor == -1) {
            attributionTintColor = ColorUtils.getPrimaryColor(context);
        }
        setAttributionTintColor(attributionTintColor);
    }

    private void setAttributionMargins(Context context, int[] iArr) {
        if (iArr != null) {
            setAttributionMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
            return;
        }
        Resources resources = context.getResources();
        int dimension = (int) resources.getDimension(R.dimen.mapbox_four_dp);
        setAttributionMargins((int) resources.getDimension(R.dimen.mapbox_ninety_two_dp), dimension, dimension, dimension);
    }

    private void saveAttribution(Bundle bundle) {
        bundle.putInt(MapboxConstants.STATE_ATTRIBUTION_GRAVITY, getAttributionGravity());
        bundle.putInt(MapboxConstants.STATE_ATTRIBUTION_MARGIN_LEFT, getAttributionMarginLeft());
        bundle.putInt(MapboxConstants.STATE_ATTRIBUTION_MARGIN_TOP, getAttributionMarginTop());
        bundle.putInt(MapboxConstants.STATE_ATTRIBUTION_MARGIN_RIGHT, getAttributionMarginRight());
        bundle.putInt(MapboxConstants.STATE_ATTRIBUTION_MARGIN_BOTTOM, getAttributionMarginBottom());
        bundle.putBoolean(MapboxConstants.STATE_ATTRIBUTION_ENABLED, isAttributionEnabled());
    }

    private void restoreAttribution(Bundle bundle) {
        if (bundle.getBoolean(MapboxConstants.STATE_ATTRIBUTION_ENABLED) && !this.isAttributionInitialized) {
            this.attributionsView = this.mapView.initialiseAttributionView();
            this.isAttributionInitialized = true;
        }
        setAttributionEnabled(bundle.getBoolean(MapboxConstants.STATE_ATTRIBUTION_ENABLED));
        setAttributionGravity(bundle.getInt(MapboxConstants.STATE_ATTRIBUTION_GRAVITY));
        setAttributionMargins(bundle.getInt(MapboxConstants.STATE_ATTRIBUTION_MARGIN_LEFT), bundle.getInt(MapboxConstants.STATE_ATTRIBUTION_MARGIN_TOP), bundle.getInt(MapboxConstants.STATE_ATTRIBUTION_MARGIN_RIGHT), bundle.getInt(MapboxConstants.STATE_ATTRIBUTION_MARGIN_BOTTOM));
    }

    public void setCompassEnabled(boolean z) {
        if (z && !this.isCompassInitialized) {
            initialiseCompass(this.mapView.mapboxMapOptions, this.mapView.getContext().getResources());
        }
        CompassView compassView = this.compassView;
        if (compassView != null) {
            compassView.setEnabled(z);
            this.compassView.update(this.clockwiseBearing);
        }
    }

    public boolean isCompassEnabled() {
        CompassView compassView = this.compassView;
        if (compassView != null) {
            return compassView.isEnabled();
        }
        return false;
    }

    public void setCompassGravity(int i) {
        CompassView compassView = this.compassView;
        if (compassView != null) {
            setWidgetGravity(compassView, i);
        }
    }

    public void setCompassFadeFacingNorth(boolean z) {
        CompassView compassView = this.compassView;
        if (compassView != null) {
            compassView.fadeCompassViewFacingNorth(z);
        }
    }

    @Deprecated
    public void setCompassImage(Drawable drawable) {
        CompassView compassView = this.compassView;
        if (compassView != null) {
            compassView.setCompassImage(drawable);
        }
    }

    public void setCompassImageResource(int i) {
        CompassView compassView = this.compassView;
        if (compassView != null) {
            compassView.setCompassImageResource(i);
        }
    }

    public boolean isCompassFadeWhenFacingNorth() {
        CompassView compassView = this.compassView;
        if (compassView != null) {
            return compassView.isFadeCompassViewFacingNorth();
        }
        return false;
    }

    public int getCompassGravity() {
        CompassView compassView = this.compassView;
        if (compassView != null) {
            return ((FrameLayout.LayoutParams) compassView.getLayoutParams()).gravity;
        }
        return -1;
    }

    public void setCompassMargins(int i, int i2, int i3, int i4) {
        CompassView compassView = this.compassView;
        if (compassView != null) {
            setWidgetMargins(compassView, this.compassMargins, i, i2, i3, i4);
        }
    }

    public int getCompassMarginLeft() {
        return this.compassMargins[0];
    }

    public int getCompassMarginTop() {
        return this.compassMargins[1];
    }

    public int getCompassMarginRight() {
        return this.compassMargins[2];
    }

    public int getCompassMarginBottom() {
        return this.compassMargins[3];
    }

    @Deprecated
    public Drawable getCompassImage() {
        CompassView compassView = this.compassView;
        if (compassView != null) {
            return compassView.getCompassImage();
        }
        return null;
    }

    public int getCompassImageResource() {
        CompassView compassView = this.compassView;
        if (compassView != null) {
            return compassView.getCompassImageResource();
        }
        return R.drawable.mapbox_compass_icon;
    }

    void update(CameraPosition cameraPosition) {
        double d = -cameraPosition.bearing;
        this.clockwiseBearing = d;
        CompassView compassView = this.compassView;
        if (compassView != null) {
            compassView.update(d);
        }
    }

    public void setLogoEnabled(boolean z) {
        if (z && !this.isLogoInitialized) {
            initialiseLogo(this.mapView.mapboxMapOptions, this.mapView.getContext().getResources());
        }
        ImageView imageView = this.logoView;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public boolean isLogoEnabled() {
        ImageView imageView = this.logoView;
        return imageView != null && imageView.getVisibility() == 0;
    }

    public void setLogoGravity(int i) {
        ImageView imageView = this.logoView;
        if (imageView != null) {
            setWidgetGravity(imageView, i);
        }
    }

    public int getLogoGravity() {
        ImageView imageView = this.logoView;
        if (imageView != null) {
            return ((FrameLayout.LayoutParams) imageView.getLayoutParams()).gravity;
        }
        return -1;
    }

    public void setLogoMargins(int i, int i2, int i3, int i4) {
        ImageView imageView = this.logoView;
        if (imageView != null) {
            setWidgetMargins(imageView, this.logoMargins, i, i2, i3, i4);
        }
    }

    public int getLogoMarginLeft() {
        return this.logoMargins[0];
    }

    public int getLogoMarginTop() {
        return this.logoMargins[1];
    }

    public int getLogoMarginRight() {
        return this.logoMargins[2];
    }

    public int getLogoMarginBottom() {
        return this.logoMargins[3];
    }

    public void setAttributionEnabled(boolean z) {
        if (z && !this.isAttributionInitialized) {
            initialiseAttribution(this.mapView.getContext(), this.mapView.mapboxMapOptions);
        }
        ImageView imageView = this.attributionsView;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public boolean isAttributionEnabled() {
        ImageView imageView = this.attributionsView;
        return imageView != null && imageView.getVisibility() == 0;
    }

    public void setAttributionDialogManager(AttributionDialogManager attributionDialogManager) {
        this.attributionDialogManager = attributionDialogManager;
    }

    public AttributionDialogManager getAttributionDialogManager() {
        return this.attributionDialogManager;
    }

    public void setAttributionGravity(int i) {
        ImageView imageView = this.attributionsView;
        if (imageView != null) {
            setWidgetGravity(imageView, i);
        }
    }

    public int getAttributionGravity() {
        ImageView imageView = this.attributionsView;
        if (imageView != null) {
            return ((FrameLayout.LayoutParams) imageView.getLayoutParams()).gravity;
        }
        return -1;
    }

    public void setAttributionMargins(int i, int i2, int i3, int i4) {
        ImageView imageView = this.attributionsView;
        if (imageView != null) {
            setWidgetMargins(imageView, this.attributionsMargins, i, i2, i3, i4);
        }
    }

    public void setAttributionTintColor(int i) {
        if (this.attributionsView == null) {
            return;
        }
        if (Color.alpha(i) == 0) {
            ImageView imageView = this.attributionsView;
            ColorUtils.setTintList(imageView, ContextCompat.getColor(imageView.getContext(), R.color.mapbox_blue));
        } else {
            ColorUtils.setTintList(this.attributionsView, i);
        }
    }

    public int getAttributionMarginLeft() {
        return this.attributionsMargins[0];
    }

    public int getAttributionMarginTop() {
        return this.attributionsMargins[1];
    }

    public int getAttributionMarginRight() {
        return this.attributionsMargins[2];
    }

    public int getAttributionMarginBottom() {
        return this.attributionsMargins[3];
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.rotateGesturesEnabled = z;
    }

    public boolean isRotateGesturesEnabled() {
        return this.rotateGesturesEnabled;
    }

    public void setTiltGesturesEnabled(boolean z) {
        this.tiltGesturesEnabled = z;
    }

    public boolean isTiltGesturesEnabled() {
        return this.tiltGesturesEnabled;
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.zoomGesturesEnabled = z;
    }

    public boolean isZoomGesturesEnabled() {
        return this.zoomGesturesEnabled;
    }

    public void setDoubleTapGesturesEnabled(boolean z) {
        this.doubleTapGesturesEnabled = z;
    }

    public boolean isDoubleTapGesturesEnabled() {
        return this.doubleTapGesturesEnabled;
    }

    public boolean isQuickZoomGesturesEnabled() {
        return this.quickZoomGesturesEnabled;
    }

    public void setQuickZoomGesturesEnabled(boolean z) {
        this.quickZoomGesturesEnabled = z;
    }

    public float getZoomRate() {
        return this.zoomRate;
    }

    public void setZoomRate(float f) {
        this.zoomRate = f;
    }

    private void restoreDeselectMarkersOnTap(Bundle bundle) {
        setDeselectMarkersOnTap(bundle.getBoolean(MapboxConstants.STATE_DESELECT_MARKER_ON_TAP));
    }

    private void saveDeselectMarkersOnTap(Bundle bundle) {
        bundle.putBoolean(MapboxConstants.STATE_DESELECT_MARKER_ON_TAP, isDeselectMarkersOnTap());
    }

    public boolean isDeselectMarkersOnTap() {
        return this.deselectMarkersOnTap;
    }

    public void setDeselectMarkersOnTap(boolean z) {
        this.deselectMarkersOnTap = z;
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.scrollGesturesEnabled = z;
    }

    public boolean isScrollGesturesEnabled() {
        return this.scrollGesturesEnabled;
    }

    public void setHorizontalScrollGesturesEnabled(boolean z) {
        this.horizontalScrollGesturesEnabled = z;
    }

    public boolean isHorizontalScrollGesturesEnabled() {
        return this.horizontalScrollGesturesEnabled;
    }

    public boolean isScaleVelocityAnimationEnabled() {
        return this.scaleVelocityAnimationEnabled;
    }

    public void setScaleVelocityAnimationEnabled(boolean z) {
        this.scaleVelocityAnimationEnabled = z;
    }

    public boolean isRotateVelocityAnimationEnabled() {
        return this.rotateVelocityAnimationEnabled;
    }

    public void setRotateVelocityAnimationEnabled(boolean z) {
        this.rotateVelocityAnimationEnabled = z;
    }

    public boolean isFlingVelocityAnimationEnabled() {
        return this.flingVelocityAnimationEnabled;
    }

    public void setFlingVelocityAnimationEnabled(boolean z) {
        this.flingVelocityAnimationEnabled = z;
    }

    public void setAllVelocityAnimationsEnabled(boolean z) {
        setScaleVelocityAnimationEnabled(z);
        setRotateVelocityAnimationEnabled(z);
        setFlingVelocityAnimationEnabled(z);
    }

    @Deprecated
    public boolean isIncreaseRotateThresholdWhenScaling() {
        return this.increaseRotateThresholdWhenScaling;
    }

    @Deprecated
    public void setIncreaseRotateThresholdWhenScaling(boolean z) {
        this.increaseRotateThresholdWhenScaling = z;
    }

    public boolean isDisableRotateWhenScaling() {
        return this.disableRotateWhenScaling;
    }

    public void setDisableRotateWhenScaling(boolean z) {
        this.disableRotateWhenScaling = z;
    }

    public boolean isIncreaseScaleThresholdWhenRotating() {
        return this.increaseScaleThresholdWhenRotating;
    }

    public void setIncreaseScaleThresholdWhenRotating(boolean z) {
        this.increaseScaleThresholdWhenRotating = z;
    }

    public void setAllGesturesEnabled(boolean z) {
        setScrollGesturesEnabled(z);
        setRotateGesturesEnabled(z);
        setTiltGesturesEnabled(z);
        setZoomGesturesEnabled(z);
        setDoubleTapGesturesEnabled(z);
        setQuickZoomGesturesEnabled(z);
    }

    public boolean areAllGesturesEnabled() {
        return this.rotateGesturesEnabled && this.tiltGesturesEnabled && this.zoomGesturesEnabled && this.scrollGesturesEnabled && this.doubleTapGesturesEnabled && this.quickZoomGesturesEnabled;
    }

    private void saveFocalPoint(Bundle bundle) {
        bundle.putParcelable(MapboxConstants.STATE_USER_FOCAL_POINT, getFocalPoint());
    }

    private void restoreFocalPoint(Bundle bundle) {
        PointF pointF = (PointF) bundle.getParcelable(MapboxConstants.STATE_USER_FOCAL_POINT);
        if (pointF != null) {
            setFocalPoint(pointF);
        }
    }

    public void setFocalPoint(PointF pointF) {
        this.userProvidedFocalPoint = pointF;
        this.focalPointChangeListener.onFocalPointChanged(pointF);
    }

    public PointF getFocalPoint() {
        return this.userProvidedFocalPoint;
    }

    public float getHeight() {
        return this.projection.getHeight();
    }

    public float getWidth() {
        return this.projection.getWidth();
    }

    float getPixelRatio() {
        return this.pixelRatio;
    }

    public void invalidate() {
        setLogoMargins(getLogoMarginLeft(), getLogoMarginTop(), getLogoMarginRight(), getLogoMarginBottom());
        setCompassEnabled(isCompassEnabled());
        setCompassMargins(getCompassMarginLeft(), getCompassMarginTop(), getCompassMarginRight(), getCompassMarginBottom());
        setAttributionMargins(getAttributionMarginLeft(), getAttributionMarginTop(), getAttributionMarginRight(), getAttributionMarginBottom());
    }

    private void setWidgetGravity(View view, int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.gravity = i;
        view.setLayoutParams(layoutParams);
    }

    private void setWidgetMargins(View view, int[] iArr, int i, int i2, int i3, int i4) {
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.setMargins(i, i2, i3, i4);
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(i);
            layoutParams.setMarginEnd(i3);
        }
        view.setLayoutParams(layoutParams);
    }
}

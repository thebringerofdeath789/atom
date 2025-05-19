package com.mapbox.mapboxsdk.location;

import android.graphics.Bitmap;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.MapboxAnimator;
import com.mapbox.mapboxsdk.log.Logger;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.expressions.Expression;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
final class LocationLayerController {
    private static final String TAG = "Mbgl-LocationLayerController";
    private final LayerBitmapProvider bitmapProvider;
    private final OnIndicatorPositionChangedListener internalIndicatorPositionChangedListener;
    private final OnRenderModeChangedListener internalRenderModeChangedListener;
    private boolean isStale;
    private LocationLayerRenderer locationLayerRenderer;
    private final MapboxMap mapboxMap;
    private LocationComponentOptions options;
    private LocationComponentPositionManager positionManager;
    private int renderMode;
    private final boolean useSpecializedLocationLayer;
    private boolean isHidden = true;
    private final MapboxAnimator.AnimationsValueChangeListener<LatLng> latLngValueListener = new MapboxAnimator.AnimationsValueChangeListener<LatLng>() { // from class: com.mapbox.mapboxsdk.location.LocationLayerController.1
        @Override // com.mapbox.mapboxsdk.location.MapboxAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(LatLng latLng) {
            LocationLayerController.this.locationLayerRenderer.setLatLng(latLng);
            LocationLayerController.this.internalIndicatorPositionChangedListener.onIndicatorPositionChanged(Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude(), latLng.getAltitude()));
        }
    };
    private final MapboxAnimator.AnimationsValueChangeListener<Float> gpsBearingValueListener = new MapboxAnimator.AnimationsValueChangeListener<Float>() { // from class: com.mapbox.mapboxsdk.location.LocationLayerController.2
        @Override // com.mapbox.mapboxsdk.location.MapboxAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(Float f) {
            LocationLayerController.this.locationLayerRenderer.setGpsBearing(f);
        }
    };
    private final MapboxAnimator.AnimationsValueChangeListener<Float> compassBearingValueListener = new MapboxAnimator.AnimationsValueChangeListener<Float>() { // from class: com.mapbox.mapboxsdk.location.LocationLayerController.3
        @Override // com.mapbox.mapboxsdk.location.MapboxAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(Float f) {
            LocationLayerController.this.locationLayerRenderer.setCompassBearing(f);
        }
    };
    private final MapboxAnimator.AnimationsValueChangeListener<Float> accuracyValueListener = new MapboxAnimator.AnimationsValueChangeListener<Float>() { // from class: com.mapbox.mapboxsdk.location.LocationLayerController.4
        @Override // com.mapbox.mapboxsdk.location.MapboxAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(Float f) {
            LocationLayerController.this.locationLayerRenderer.setAccuracyRadius(f);
        }
    };
    private final MapboxAnimator.AnimationsValueChangeListener<Float> pulsingCircleRadiusListener = new MapboxAnimator.AnimationsValueChangeListener<Float>() { // from class: com.mapbox.mapboxsdk.location.LocationLayerController.5
        @Override // com.mapbox.mapboxsdk.location.MapboxAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(Float f) {
            LocationLayerController.this.locationLayerRenderer.updatePulsingUi(f.floatValue(), (!LocationLayerController.this.options.pulseFadeEnabled().booleanValue() || LocationLayerController.this.options.pulseMaxRadius() <= 0.0f) ? null : Float.valueOf(1.0f - (f.floatValue() / LocationLayerController.this.options.pulseMaxRadius())));
        }
    };

    LocationLayerController(MapboxMap mapboxMap, Style style, LayerSourceProvider layerSourceProvider, LayerFeatureProvider layerFeatureProvider, LayerBitmapProvider layerBitmapProvider, LocationComponentOptions locationComponentOptions, OnRenderModeChangedListener onRenderModeChangedListener, OnIndicatorPositionChangedListener onIndicatorPositionChangedListener, boolean z) {
        this.mapboxMap = mapboxMap;
        this.bitmapProvider = layerBitmapProvider;
        this.internalRenderModeChangedListener = onRenderModeChangedListener;
        this.internalIndicatorPositionChangedListener = onIndicatorPositionChangedListener;
        this.useSpecializedLocationLayer = z;
        boolean enableStaleState = locationComponentOptions.enableStaleState();
        this.isStale = enableStaleState;
        if (z) {
            this.locationLayerRenderer = layerSourceProvider.getIndicatorLocationLayerRenderer();
        } else {
            this.locationLayerRenderer = layerSourceProvider.getSymbolLocationLayerRenderer(layerFeatureProvider, enableStaleState);
        }
        initializeComponents(style, locationComponentOptions);
    }

    void initializeComponents(Style style, LocationComponentOptions locationComponentOptions) {
        this.positionManager = new LocationComponentPositionManager(style, locationComponentOptions.layerAbove(), locationComponentOptions.layerBelow());
        this.locationLayerRenderer.initializeComponents(style);
        this.locationLayerRenderer.addLayers(this.positionManager);
        applyStyle(locationComponentOptions);
        if (this.isHidden) {
            hide();
        } else {
            show();
        }
    }

    void applyStyle(LocationComponentOptions locationComponentOptions) {
        if (this.positionManager.update(locationComponentOptions.layerAbove(), locationComponentOptions.layerBelow())) {
            this.locationLayerRenderer.removeLayers();
            this.locationLayerRenderer.addLayers(this.positionManager);
            if (this.isHidden) {
                hide();
            }
        }
        this.options = locationComponentOptions;
        styleBitmaps(locationComponentOptions);
        this.locationLayerRenderer.styleAccuracy(locationComponentOptions.accuracyAlpha(), locationComponentOptions.accuracyColor());
        styleScaling(locationComponentOptions);
        this.locationLayerRenderer.stylePulsingCircle(locationComponentOptions);
        determineIconsSource(locationComponentOptions);
        if (this.isHidden) {
            return;
        }
        show();
    }

    void setGpsBearing(float f) {
        this.locationLayerRenderer.setGpsBearing(Float.valueOf(f));
    }

    void setRenderMode(int i) {
        if (this.renderMode == i) {
            return;
        }
        this.renderMode = i;
        styleBitmaps(this.options);
        determineIconsSource(this.options);
        if (!this.isHidden) {
            show();
        }
        this.internalRenderModeChangedListener.onRenderModeChanged(i);
    }

    int getRenderMode() {
        return this.renderMode;
    }

    void show() {
        this.isHidden = false;
        this.locationLayerRenderer.show(this.renderMode, this.isStale);
    }

    void hide() {
        this.isHidden = true;
        this.locationLayerRenderer.hide();
    }

    boolean isHidden() {
        return this.isHidden;
    }

    boolean isConsumingCompass() {
        return this.renderMode == 4;
    }

    private void styleBitmaps(LocationComponentOptions locationComponentOptions) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap generateShadowBitmap = locationComponentOptions.elevation() > 0.0f ? this.bitmapProvider.generateShadowBitmap(locationComponentOptions) : null;
        Bitmap generateBitmap = this.bitmapProvider.generateBitmap(locationComponentOptions.backgroundDrawable(), locationComponentOptions.backgroundTintColor());
        Bitmap generateBitmap2 = this.bitmapProvider.generateBitmap(locationComponentOptions.backgroundDrawableStale(), locationComponentOptions.backgroundStaleTintColor());
        Bitmap generateBitmap3 = this.bitmapProvider.generateBitmap(locationComponentOptions.bearingDrawable(), locationComponentOptions.bearingTintColor());
        Bitmap generateBitmap4 = this.bitmapProvider.generateBitmap(locationComponentOptions.foregroundDrawable(), locationComponentOptions.foregroundTintColor());
        Bitmap generateBitmap5 = this.bitmapProvider.generateBitmap(locationComponentOptions.foregroundDrawableStale(), locationComponentOptions.foregroundStaleTintColor());
        if (this.renderMode == 8) {
            Bitmap generateBitmap6 = this.bitmapProvider.generateBitmap(locationComponentOptions.gpsDrawable(), locationComponentOptions.foregroundTintColor());
            bitmap2 = this.bitmapProvider.generateBitmap(locationComponentOptions.gpsDrawable(), locationComponentOptions.foregroundStaleTintColor());
            bitmap = generateBitmap6;
        } else {
            bitmap = generateBitmap4;
            bitmap2 = generateBitmap5;
        }
        this.locationLayerRenderer.addBitmaps(this.renderMode, generateShadowBitmap, generateBitmap, generateBitmap2, generateBitmap3, bitmap, bitmap2);
    }

    private void styleScaling(LocationComponentOptions locationComponentOptions) {
        this.locationLayerRenderer.styleScaling(Expression.interpolate(Expression.linear(), Expression.zoom(), Expression.stop(Double.valueOf(this.mapboxMap.getMinZoomLevel()), Float.valueOf(locationComponentOptions.minZoomIconScale())), Expression.stop(Double.valueOf(this.mapboxMap.getMaxZoomLevel()), Float.valueOf(locationComponentOptions.maxZoomIconScale()))));
    }

    private void determineIconsSource(LocationComponentOptions locationComponentOptions) {
        this.locationLayerRenderer.updateIconIds(buildIconString(this.renderMode == 8 ? locationComponentOptions.gpsName() : locationComponentOptions.foregroundName(), "mapbox-location-icon"), buildIconString(locationComponentOptions.foregroundStaleName(), "mapbox-location-stale-icon"), buildIconString(locationComponentOptions.backgroundName(), "mapbox-location-stroke-icon"), buildIconString(locationComponentOptions.backgroundStaleName(), "mapbox-location-background-stale-icon"), buildIconString(locationComponentOptions.bearingName(), "mapbox-location-bearing-icon"));
    }

    private String buildIconString(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (!this.useSpecializedLocationLayer) {
            return str;
        }
        Logger.e(TAG, str + " replacement ID provided for an unsupported specialized location layer");
        return str2;
    }

    void setLocationsStale(boolean z) {
        this.isStale = z;
        this.locationLayerRenderer.setLocationStale(z, this.renderMode);
    }

    boolean onMapClick(LatLng latLng) {
        return !this.mapboxMap.queryRenderedFeatures(this.mapboxMap.getProjection().toScreenLocation(latLng), LocationComponentConstants.BACKGROUND_LAYER, LocationComponentConstants.FOREGROUND_LAYER, LocationComponentConstants.BEARING_LAYER).isEmpty();
    }

    Set<AnimatorListenerHolder> getAnimationListeners() {
        HashSet hashSet = new HashSet();
        hashSet.add(new AnimatorListenerHolder(0, this.latLngValueListener));
        int i = this.renderMode;
        if (i == 8) {
            hashSet.add(new AnimatorListenerHolder(2, this.gpsBearingValueListener));
        } else if (i == 4) {
            hashSet.add(new AnimatorListenerHolder(3, this.compassBearingValueListener));
        }
        int i2 = this.renderMode;
        if (i2 == 4 || i2 == 18) {
            hashSet.add(new AnimatorListenerHolder(6, this.accuracyValueListener));
        }
        if (this.options.pulseEnabled().booleanValue()) {
            hashSet.add(new AnimatorListenerHolder(9, this.pulsingCircleRadiusListener));
        }
        return hashSet;
    }

    void cameraBearingUpdated(double d) {
        if (this.renderMode != 8) {
            this.locationLayerRenderer.cameraBearingUpdated(d);
        }
    }

    void cameraTiltUpdated(double d) {
        this.locationLayerRenderer.cameraTiltUpdated(d);
    }

    void adjustPulsingCircleLayerVisibility(boolean z) {
        this.locationLayerRenderer.adjustPulsingCircleLayerVisibility(z);
    }
}

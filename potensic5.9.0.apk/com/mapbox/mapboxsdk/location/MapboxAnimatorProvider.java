package com.mapbox.mapboxsdk.location;

import android.view.animation.Interpolator;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.MapboxAnimator;
import com.mapbox.mapboxsdk.maps.MapboxMap;

/* loaded from: classes3.dex */
final class MapboxAnimatorProvider {
    private static MapboxAnimatorProvider INSTANCE;

    private MapboxAnimatorProvider() {
    }

    public static MapboxAnimatorProvider getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MapboxAnimatorProvider();
        }
        return INSTANCE;
    }

    MapboxLatLngAnimator latLngAnimator(LatLng[] latLngArr, MapboxAnimator.AnimationsValueChangeListener animationsValueChangeListener, int i) {
        return new MapboxLatLngAnimator(latLngArr, animationsValueChangeListener, i);
    }

    MapboxFloatAnimator floatAnimator(Float[] fArr, MapboxAnimator.AnimationsValueChangeListener animationsValueChangeListener, int i) {
        return new MapboxFloatAnimator(fArr, animationsValueChangeListener, i);
    }

    MapboxCameraAnimatorAdapter cameraAnimator(Float[] fArr, MapboxAnimator.AnimationsValueChangeListener animationsValueChangeListener, MapboxMap.CancelableCallback cancelableCallback) {
        return new MapboxCameraAnimatorAdapter(fArr, animationsValueChangeListener, cancelableCallback);
    }

    MapboxPaddingAnimator paddingAnimator(double[][] dArr, MapboxAnimator.AnimationsValueChangeListener<double[]> animationsValueChangeListener, MapboxMap.CancelableCallback cancelableCallback) {
        return new MapboxPaddingAnimator(dArr, animationsValueChangeListener, cancelableCallback);
    }

    PulsingLocationCircleAnimator pulsingCircleAnimator(MapboxAnimator.AnimationsValueChangeListener animationsValueChangeListener, int i, float f, float f2, Interpolator interpolator) {
        PulsingLocationCircleAnimator pulsingLocationCircleAnimator = new PulsingLocationCircleAnimator(animationsValueChangeListener, i, f2);
        pulsingLocationCircleAnimator.setDuration((long) f);
        pulsingLocationCircleAnimator.setRepeatMode(1);
        pulsingLocationCircleAnimator.setRepeatCount(-1);
        pulsingLocationCircleAnimator.setInterpolator(interpolator);
        return pulsingLocationCircleAnimator;
    }
}
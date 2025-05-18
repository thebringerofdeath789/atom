package com.mapbox.mapboxsdk.location;

import android.animation.TypeEvaluator;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.MapboxAnimator;

/* loaded from: classes3.dex */
class MapboxLatLngAnimator extends MapboxAnimator<LatLng> {
    MapboxLatLngAnimator(LatLng[] latLngArr, MapboxAnimator.AnimationsValueChangeListener animationsValueChangeListener, int i) {
        super(latLngArr, animationsValueChangeListener, i);
    }

    @Override // com.mapbox.mapboxsdk.location.MapboxAnimator
    TypeEvaluator provideEvaluator() {
        return new LatLngEvaluator();
    }
}
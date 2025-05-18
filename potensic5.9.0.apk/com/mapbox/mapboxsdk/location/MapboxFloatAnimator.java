package com.mapbox.mapboxsdk.location;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;
import com.mapbox.mapboxsdk.location.MapboxAnimator;

/* loaded from: classes3.dex */
class MapboxFloatAnimator extends MapboxAnimator<Float> {
    MapboxFloatAnimator(Float[] fArr, MapboxAnimator.AnimationsValueChangeListener animationsValueChangeListener, int i) {
        super(fArr, animationsValueChangeListener, i);
    }

    @Override // com.mapbox.mapboxsdk.location.MapboxAnimator
    TypeEvaluator provideEvaluator() {
        return new FloatEvaluator();
    }
}
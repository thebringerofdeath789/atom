package com.mapbox.mapboxsdk.location;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import com.mapbox.mapboxsdk.location.MapboxAnimator;
import com.mapbox.mapboxsdk.maps.MapboxMap;

/* loaded from: classes3.dex */
public class MapboxPaddingAnimator extends MapboxAnimator<double[]> {
    @Override // com.mapbox.mapboxsdk.location.MapboxAnimator
    public /* bridge */ /* synthetic */ void makeInvalid() {
        super.makeInvalid();
    }

    @Override // com.mapbox.mapboxsdk.location.MapboxAnimator, android.animation.ValueAnimator.AnimatorUpdateListener
    public /* bridge */ /* synthetic */ void onAnimationUpdate(ValueAnimator valueAnimator) {
        super.onAnimationUpdate(valueAnimator);
    }

    MapboxPaddingAnimator(double[][] dArr, MapboxAnimator.AnimationsValueChangeListener<double[]> animationsValueChangeListener, MapboxMap.CancelableCallback cancelableCallback) {
        super(dArr, animationsValueChangeListener, Integer.MAX_VALUE);
        addListener(new MapboxAnimatorListener(cancelableCallback));
    }

    @Override // com.mapbox.mapboxsdk.location.MapboxAnimator
    TypeEvaluator<double[]> provideEvaluator() {
        return new PaddingEvaluator();
    }
}

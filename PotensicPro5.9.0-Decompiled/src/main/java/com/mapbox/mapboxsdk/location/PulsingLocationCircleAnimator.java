package com.mapbox.mapboxsdk.location;

import android.animation.ValueAnimator;
import com.mapbox.mapboxsdk.location.MapboxAnimator;

/* loaded from: classes3.dex */
public class PulsingLocationCircleAnimator extends MapboxFloatAnimator {
    @Override // com.mapbox.mapboxsdk.location.MapboxAnimator
    public /* bridge */ /* synthetic */ void makeInvalid() {
        super.makeInvalid();
    }

    @Override // com.mapbox.mapboxsdk.location.MapboxAnimator, android.animation.ValueAnimator.AnimatorUpdateListener
    public /* bridge */ /* synthetic */ void onAnimationUpdate(ValueAnimator valueAnimator) {
        super.onAnimationUpdate(valueAnimator);
    }

    public PulsingLocationCircleAnimator(MapboxAnimator.AnimationsValueChangeListener animationsValueChangeListener, int i, float f) {
        super(new Float[]{Float.valueOf(0.0f), Float.valueOf(f)}, animationsValueChangeListener, i);
    }
}

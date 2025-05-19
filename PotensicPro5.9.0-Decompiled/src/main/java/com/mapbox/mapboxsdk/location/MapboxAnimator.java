package com.mapbox.mapboxsdk.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;

/* loaded from: classes3.dex */
abstract class MapboxAnimator<K> extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {
    static final int ANIMATOR_CAMERA_COMPASS_BEARING = 5;
    static final int ANIMATOR_CAMERA_GPS_BEARING = 4;
    static final int ANIMATOR_CAMERA_LATLNG = 1;
    static final int ANIMATOR_LAYER_ACCURACY = 6;
    static final int ANIMATOR_LAYER_COMPASS_BEARING = 3;
    static final int ANIMATOR_LAYER_GPS_BEARING = 2;
    static final int ANIMATOR_LAYER_LATLNG = 0;
    static final int ANIMATOR_PADDING = 10;
    static final int ANIMATOR_PULSING_CIRCLE = 9;
    static final int ANIMATOR_TILT = 8;
    static final int ANIMATOR_ZOOM = 7;
    private K animatedValue;
    private boolean invalid;
    private final double minUpdateInterval;
    private final K target;
    private long timeElapsed;
    private final AnimationsValueChangeListener<K> updateListener;

    interface AnimationsValueChangeListener<K> {
        void onNewAnimationValue(K k);
    }

    abstract TypeEvaluator provideEvaluator();

    MapboxAnimator(K[] kArr, AnimationsValueChangeListener<K> animationsValueChangeListener, int i) {
        this.minUpdateInterval = 1.0E9d / i;
        setObjectValues(kArr);
        setEvaluator(provideEvaluator());
        this.updateListener = animationsValueChangeListener;
        this.target = kArr[kArr.length - 1];
        addUpdateListener(this);
        addListener(new AnimatorListener());
    }

    public MapboxAnimator(AnimationsValueChangeListener<K> animationsValueChangeListener, K k, K k2, double d, long j) {
        this.updateListener = animationsValueChangeListener;
        this.target = k;
        this.animatedValue = k2;
        this.minUpdateInterval = d;
        this.timeElapsed = j;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.animatedValue = (K) valueAnimator.getAnimatedValue();
        long nanoTime = System.nanoTime();
        if (nanoTime - this.timeElapsed < this.minUpdateInterval) {
            return;
        }
        postUpdates();
        this.timeElapsed = nanoTime;
    }

    private class AnimatorListener extends AnimatorListenerAdapter {
        private AnimatorListener() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            MapboxAnimator.this.postUpdates();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postUpdates() {
        if (this.invalid) {
            return;
        }
        this.updateListener.onNewAnimationValue(this.animatedValue);
    }

    K getTarget() {
        return this.target;
    }

    public void makeInvalid() {
        this.invalid = true;
    }
}

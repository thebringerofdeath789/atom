package com.mapbox.mapboxsdk.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.mapbox.mapboxsdk.maps.MapboxMap;

/* loaded from: classes3.dex */
class MapboxAnimatorListener extends AnimatorListenerAdapter {
    private final MapboxMap.CancelableCallback cancelableCallback;

    MapboxAnimatorListener(MapboxMap.CancelableCallback cancelableCallback) {
        this.cancelableCallback = cancelableCallback;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        MapboxMap.CancelableCallback cancelableCallback = this.cancelableCallback;
        if (cancelableCallback != null) {
            cancelableCallback.onCancel();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        MapboxMap.CancelableCallback cancelableCallback = this.cancelableCallback;
        if (cancelableCallback != null) {
            cancelableCallback.onFinish();
        }
    }
}

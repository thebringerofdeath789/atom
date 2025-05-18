package com.mapbox.mapboxsdk.utils;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* loaded from: classes3.dex */
public class AnimatorUtils {

    public interface OnAnimationEndListener {
        void onAnimationEnd();
    }

    public static void animate(View view, int i, OnAnimationEndListener onAnimationEndListener) {
        animate(view, i, -1, onAnimationEndListener);
    }

    public static void animate(final View view, int i, int i2, final OnAnimationEndListener onAnimationEndListener) {
        if (view == null) {
            return;
        }
        view.setLayerType(2, null);
        Animator loadAnimator = AnimatorInflater.loadAnimator(view.getContext(), i);
        if (i2 != -1) {
            loadAnimator.setDuration(i2);
        }
        loadAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.mapbox.mapboxsdk.utils.AnimatorUtils.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setLayerType(0, null);
                OnAnimationEndListener onAnimationEndListener2 = onAnimationEndListener;
                if (onAnimationEndListener2 != null) {
                    onAnimationEndListener2.onAnimationEnd();
                }
            }
        });
        loadAnimator.setTarget(view);
        loadAnimator.start();
    }

    public static void animate(View view, int i) {
        animate(view, i, -1);
    }

    public static void animate(View view, int i, int i2) {
        animate(view, i, i2, null);
    }

    public static void rotate(final View view, float f) {
        view.setLayerType(2, null);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ROTATION, view.getRotation(), f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.mapbox.mapboxsdk.utils.AnimatorUtils.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setLayerType(0, null);
            }
        });
        ofFloat.start();
    }

    public static void rotateBy(final View view, float f) {
        view.setLayerType(2, null);
        view.animate().rotationBy(f).setInterpolator(new FastOutSlowInInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: com.mapbox.mapboxsdk.utils.AnimatorUtils.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setLayerType(0, null);
            }
        });
    }

    public static void alpha(final View view, float f, final OnAnimationEndListener onAnimationEndListener) {
        view.setLayerType(2, null);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, view.getAlpha(), f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.mapbox.mapboxsdk.utils.AnimatorUtils.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setLayerType(0, null);
                OnAnimationEndListener onAnimationEndListener2 = onAnimationEndListener;
                if (onAnimationEndListener2 != null) {
                    onAnimationEndListener2.onAnimationEnd();
                }
            }
        });
        ofFloat.start();
    }

    public static void alpha(View view, float f) {
        alpha(view, f, null);
    }
}
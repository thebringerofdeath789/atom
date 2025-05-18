package com.transitionseverywhere;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.RectEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.Property;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;

/* loaded from: classes3.dex */
public class Crossfade extends Transition {
    public static final int FADE_BEHAVIOR_CROSSFADE = 0;
    public static final int FADE_BEHAVIOR_OUT_IN = 2;
    public static final int FADE_BEHAVIOR_REVEAL = 1;
    private static final String LOG_TAG = "Crossfade";
    private static final String PROPNAME_BITMAP = "android:crossfade:bitmap";
    private static final String PROPNAME_BOUNDS = "android:crossfade:bounds";
    private static final String PROPNAME_DRAWABLE = "android:crossfade:drawable";
    public static final int RESIZE_BEHAVIOR_NONE = 0;
    public static final int RESIZE_BEHAVIOR_SCALE = 1;
    private static RectEvaluator sRectEvaluator;
    private int mFadeBehavior = 1;
    private int mResizeBehavior = 1;

    public Crossfade setFadeBehavior(int i) {
        if (i >= 0 && i <= 2) {
            this.mFadeBehavior = i;
        }
        return this;
    }

    public int getFadeBehavior() {
        return this.mFadeBehavior;
    }

    public Crossfade setResizeBehavior(int i) {
        if (i >= 0 && i <= 1) {
            this.mResizeBehavior = i;
        }
        return this;
    }

    public int getResizeBehavior() {
        return this.mResizeBehavior;
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ObjectAnimator objectAnimator = null;
        if (transitionValues != null && transitionValues2 != null && Build.VERSION.SDK_INT >= 18) {
            if (sRectEvaluator == null) {
                sRectEvaluator = new RectEvaluator();
            }
            boolean z = this.mFadeBehavior != 1;
            final View view = transitionValues2.view;
            Map<String, Object> map = transitionValues.values;
            Map<String, Object> map2 = transitionValues2.values;
            Rect rect = (Rect) map.get(PROPNAME_BOUNDS);
            Rect rect2 = (Rect) map2.get(PROPNAME_BOUNDS);
            if (rect != null && rect2 != null) {
                Bitmap bitmap = (Bitmap) map.get(PROPNAME_BITMAP);
                Bitmap bitmap2 = (Bitmap) map2.get(PROPNAME_BITMAP);
                final BitmapDrawable bitmapDrawable = (BitmapDrawable) map.get(PROPNAME_DRAWABLE);
                final BitmapDrawable bitmapDrawable2 = (BitmapDrawable) map2.get(PROPNAME_DRAWABLE);
                if (bitmapDrawable != null && bitmapDrawable2 != null && !bitmap.sameAs(bitmap2)) {
                    ViewOverlay overlay = z ? ((ViewGroup) view.getParent()).getOverlay() : view.getOverlay();
                    if (this.mFadeBehavior == 1) {
                        overlay.add(bitmapDrawable2);
                    }
                    overlay.add(bitmapDrawable);
                    ObjectAnimator ofInt = this.mFadeBehavior == 2 ? ObjectAnimator.ofInt(bitmapDrawable, "alpha", 255, 0, 0) : ObjectAnimator.ofInt(bitmapDrawable, "alpha", 0);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transitionseverywhere.Crossfade.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            view.invalidate(bitmapDrawable.getBounds());
                        }
                    });
                    int i = this.mFadeBehavior;
                    if (i == 2) {
                        objectAnimator = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f, 0.0f, 1.0f);
                    } else if (i == 0) {
                        objectAnimator = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
                    }
                    ObjectAnimator objectAnimator2 = objectAnimator;
                    final boolean z2 = z;
                    ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.transitionseverywhere.Crossfade.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            ViewOverlay overlay2 = z2 ? ((ViewGroup) view.getParent()).getOverlay() : view.getOverlay();
                            overlay2.remove(bitmapDrawable);
                            if (Crossfade.this.mFadeBehavior == 1) {
                                overlay2.remove(bitmapDrawable2);
                            }
                        }
                    });
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(ofInt);
                    if (objectAnimator2 != null) {
                        animatorSet.playTogether(objectAnimator2);
                    }
                    if (this.mResizeBehavior == 1 && !rect.equals(rect2)) {
                        animatorSet.playTogether(ObjectAnimator.ofObject(bitmapDrawable, "bounds", sRectEvaluator, rect, rect2));
                        if (this.mResizeBehavior == 1) {
                            animatorSet.playTogether(ObjectAnimator.ofObject(bitmapDrawable2, "bounds", sRectEvaluator, rect, rect2));
                        }
                    }
                    return animatorSet;
                }
            }
        }
        return null;
    }

    private void captureValues(TransitionValues transitionValues) {
        if (Build.VERSION.SDK_INT < 18) {
            return;
        }
        View view = transitionValues.view;
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return;
        }
        Rect rect = new Rect(0, 0, view.getWidth(), view.getHeight());
        if (this.mFadeBehavior != 1) {
            rect.offset(view.getLeft(), view.getTop());
        }
        transitionValues.values.put(PROPNAME_BOUNDS, rect);
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        if (view instanceof TextureView) {
            createBitmap = ((TextureView) view).getBitmap();
        } else {
            view.draw(new Canvas(createBitmap));
        }
        transitionValues.values.put(PROPNAME_BITMAP, createBitmap);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(view.getResources(), createBitmap);
        bitmapDrawable.setBounds(rect);
        transitionValues.values.put(PROPNAME_DRAWABLE, bitmapDrawable);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }
}
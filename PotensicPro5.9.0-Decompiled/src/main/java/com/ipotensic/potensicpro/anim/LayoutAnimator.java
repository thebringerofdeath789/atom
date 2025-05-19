package com.ipotensic.potensicpro.anim;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes2.dex */
public class LayoutAnimator {

    public static class LayoutHeightUpdateListener implements ValueAnimator.AnimatorUpdateListener {
        private final View _view;

        public LayoutHeightUpdateListener(View view) {
            this._view = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup.LayoutParams layoutParams = this._view.getLayoutParams();
            layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this._view.setLayoutParams(layoutParams);
        }
    }

    public static Animator ofHeight(View view, int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.addUpdateListener(new LayoutHeightUpdateListener(view));
        return ofInt;
    }
}

package com.transitionseverywhere.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;

/* loaded from: classes3.dex */
public class TransitionUtils {
    public static Animator mergeAnimators(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }
}
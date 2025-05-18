package com.transitionseverywhere.extra;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.transitionseverywhere.C3415R;
import com.transitionseverywhere.utils.TransitionUtils;

/* loaded from: classes3.dex */
public class Scale extends Visibility {
    static final String PROPNAME_SCALE_X = "scale:scaleX";
    static final String PROPNAME_SCALE_Y = "scale:scaleY";
    private float mDisappearedScale;

    public Scale() {
        this.mDisappearedScale = 0.0f;
    }

    public Scale(float f) {
        this.mDisappearedScale = 0.0f;
        setDisappearedScale(f);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        transitionValues.values.put(PROPNAME_SCALE_X, Float.valueOf(transitionValues.view.getScaleX()));
        transitionValues.values.put(PROPNAME_SCALE_Y, Float.valueOf(transitionValues.view.getScaleY()));
    }

    public Scale setDisappearedScale(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("disappearedScale cannot be negative!");
        }
        this.mDisappearedScale = f;
        return this;
    }

    public Scale(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDisappearedScale = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3415R.styleable.Scale);
        setDisappearedScale(obtainStyledAttributes.getFloat(C3415R.styleable.Scale_disappearedScale, this.mDisappearedScale));
        obtainStyledAttributes.recycle();
    }

    private Animator createAnimation(final View view, float f, float f2, TransitionValues transitionValues) {
        final float scaleX = view.getScaleX();
        final float scaleY = view.getScaleY();
        float f3 = scaleX * f;
        float f4 = scaleX * f2;
        float f5 = f * scaleY;
        float f6 = f2 * scaleY;
        if (transitionValues != null) {
            Float f7 = (Float) transitionValues.values.get(PROPNAME_SCALE_X);
            Float f8 = (Float) transitionValues.values.get(PROPNAME_SCALE_Y);
            if (f7 != null && f7.floatValue() != scaleX) {
                f3 = f7.floatValue();
            }
            if (f8 != null && f8.floatValue() != scaleY) {
                f5 = f8.floatValue();
            }
        }
        view.setScaleX(f3);
        view.setScaleY(f5);
        Animator mergeAnimators = TransitionUtils.mergeAnimators(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, f3, f4), ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, f5, f6));
        addListener(new TransitionListenerAdapter() { // from class: com.transitionseverywhere.extra.Scale.1
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                view.setScaleX(scaleX);
                view.setScaleY(scaleY);
                transition.removeListener(this);
            }
        });
        return mergeAnimators;
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimation(view, this.mDisappearedScale, 1.0f, transitionValues);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimation(view, 1.0f, this.mDisappearedScale, transitionValues);
    }
}
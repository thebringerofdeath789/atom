package com.transitionseverywhere.extra;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.transitionseverywhere.utils.TransitionUtils;

/* loaded from: classes3.dex */
public class Translation extends Transition {
    private static final Property<View, PointF> TRANSLATION_PROPERTY;
    private static final String TRANSLATION_X = "Translation:translationX";
    private static final String TRANSLATION_Y = "Translation:translationY";

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            TRANSLATION_PROPERTY = new Property<View, PointF>(PointF.class, "translation") { // from class: com.transitionseverywhere.extra.Translation.1
                @Override // android.util.Property
                public void set(View view, PointF pointF) {
                    view.setTranslationX(pointF.x);
                    view.setTranslationY(pointF.y);
                }

                @Override // android.util.Property
                public PointF get(View view) {
                    return new PointF(view.getTranslationX(), view.getTranslationY());
                }
            };
        } else {
            TRANSLATION_PROPERTY = null;
        }
    }

    public Translation() {
    }

    public Translation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void captureValues(TransitionValues transitionValues) {
        transitionValues.values.put(TRANSLATION_X, Float.valueOf(transitionValues.view.getTranslationX()));
        transitionValues.values.put(TRANSLATION_Y, Float.valueOf(transitionValues.view.getTranslationY()));
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        Property<View, PointF> property;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        float floatValue = ((Float) transitionValues.values.get(TRANSLATION_X)).floatValue();
        float floatValue2 = ((Float) transitionValues.values.get(TRANSLATION_Y)).floatValue();
        float floatValue3 = ((Float) transitionValues2.values.get(TRANSLATION_X)).floatValue();
        float floatValue4 = ((Float) transitionValues2.values.get(TRANSLATION_Y)).floatValue();
        transitionValues2.view.setTranslationX(floatValue);
        transitionValues2.view.setTranslationY(floatValue2);
        if (Build.VERSION.SDK_INT >= 21 && (property = TRANSLATION_PROPERTY) != null) {
            return ObjectAnimator.ofObject(transitionValues2.view, (Property<View, V>) property, (TypeConverter) null, getPathMotion().getPath(floatValue, floatValue2, floatValue3, floatValue4));
        }
        return TransitionUtils.mergeAnimators(floatValue == floatValue3 ? null : ObjectAnimator.ofFloat(transitionValues2.view, (Property<View, Float>) View.TRANSLATION_X, floatValue, floatValue3), floatValue2 != floatValue4 ? ObjectAnimator.ofFloat(transitionValues2.view, (Property<View, Float>) View.TRANSLATION_Y, floatValue2, floatValue4) : null);
    }
}
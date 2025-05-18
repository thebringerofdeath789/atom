package com.transitionseverywhere;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionValues;
import java.util.Map;

/* loaded from: classes3.dex */
public class ChangeText extends Transition {
    public static final int CHANGE_BEHAVIOR_IN = 2;
    public static final int CHANGE_BEHAVIOR_KEEP = 0;
    public static final int CHANGE_BEHAVIOR_OUT = 1;
    public static final int CHANGE_BEHAVIOR_OUT_IN = 3;
    private static final String PROPNAME_TEXT_COLOR = "android:textchange:textColor";
    private int mChangeBehavior = 0;
    private static final String PROPNAME_TEXT = "android:textchange:text";
    private static final String PROPNAME_TEXT_SELECTION_START = "android:textchange:textSelectionStart";
    private static final String PROPNAME_TEXT_SELECTION_END = "android:textchange:textSelectionEnd";
    private static final String[] sTransitionProperties = {PROPNAME_TEXT, PROPNAME_TEXT_SELECTION_START, PROPNAME_TEXT_SELECTION_END};

    public ChangeText setChangeBehavior(int i) {
        if (i >= 0 && i <= 3) {
            this.mChangeBehavior = i;
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public int getChangeBehavior() {
        return this.mChangeBehavior;
    }

    private void captureValues(TransitionValues transitionValues) {
        if (transitionValues.view instanceof TextView) {
            TextView textView = (TextView) transitionValues.view;
            transitionValues.values.put(PROPNAME_TEXT, textView.getText());
            if (textView instanceof EditText) {
                transitionValues.values.put(PROPNAME_TEXT_SELECTION_START, Integer.valueOf(textView.getSelectionStart()));
                transitionValues.values.put(PROPNAME_TEXT_SELECTION_END, Integer.valueOf(textView.getSelectionEnd()));
            }
            if (this.mChangeBehavior > 0) {
                transitionValues.values.put(PROPNAME_TEXT_COLOR, Integer.valueOf(textView.getCurrentTextColor()));
            }
        }
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
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char c;
        CharSequence charSequence;
        int i6;
        int i7;
        int i8;
        Animator animator;
        ValueAnimator ofInt;
        final int i9;
        Animator animator2;
        final int i10;
        if (transitionValues == null || transitionValues2 == null || !(transitionValues.view instanceof TextView) || !(transitionValues2.view instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) transitionValues2.view;
        Map<String, Object> map = transitionValues.values;
        Map<String, Object> map2 = transitionValues2.values;
        String str = map.get(PROPNAME_TEXT) != null ? (CharSequence) map.get(PROPNAME_TEXT) : "";
        String str2 = map2.get(PROPNAME_TEXT) != null ? (CharSequence) map2.get(PROPNAME_TEXT) : "";
        boolean z = textView instanceof EditText;
        if (z) {
            int intValue = map.get(PROPNAME_TEXT_SELECTION_START) != null ? ((Integer) map.get(PROPNAME_TEXT_SELECTION_START)).intValue() : -1;
            i = map.get(PROPNAME_TEXT_SELECTION_END) != null ? ((Integer) map.get(PROPNAME_TEXT_SELECTION_END)).intValue() : intValue;
            int intValue2 = map2.get(PROPNAME_TEXT_SELECTION_START) != null ? ((Integer) map2.get(PROPNAME_TEXT_SELECTION_START)).intValue() : -1;
            i2 = intValue2;
            i3 = map2.get(PROPNAME_TEXT_SELECTION_END) != null ? ((Integer) map2.get(PROPNAME_TEXT_SELECTION_END)).intValue() : intValue2;
            i4 = intValue;
        } else {
            i = -1;
            i2 = -1;
            i3 = -1;
            i4 = -1;
        }
        if (str.equals(str2)) {
            return null;
        }
        if (this.mChangeBehavior != 2) {
            textView.setText(str);
            if (z) {
                setSelection((EditText) textView, i4, i);
            }
        }
        if (this.mChangeBehavior == 0) {
            animator = ValueAnimator.ofFloat(0.0f, 1.0f);
            final CharSequence charSequence2 = str;
            final CharSequence charSequence3 = str2;
            final int i11 = i2;
            final int i12 = i3;
            animator.addListener(new AnimatorListenerAdapter() { // from class: com.transitionseverywhere.ChangeText.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator3) {
                    if (charSequence2.equals(textView.getText())) {
                        textView.setText(charSequence3);
                        TextView textView2 = textView;
                        if (textView2 instanceof EditText) {
                            ChangeText.this.setSelection((EditText) textView2, i11, i12);
                        }
                    }
                }
            });
            i7 = i;
            charSequence = str;
            i5 = i4;
            i10 = 0;
        } else {
            int i13 = i;
            final int intValue3 = ((Integer) map.get(PROPNAME_TEXT_COLOR)).intValue();
            final int intValue4 = ((Integer) map2.get(PROPNAME_TEXT_COLOR)).intValue();
            int i14 = this.mChangeBehavior;
            if (i14 == 3 || i14 == 1) {
                ValueAnimator ofInt2 = ValueAnimator.ofInt(Color.alpha(intValue3), 0);
                ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transitionseverywhere.ChangeText.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue5 = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        TextView textView2 = textView;
                        int i15 = intValue3;
                        textView2.setTextColor((intValue5 << 24) | (16711680 & i15) | (65280 & i15) | (i15 & 255));
                    }
                });
                final CharSequence charSequence4 = str;
                i5 = i4;
                c = 1;
                final CharSequence charSequence5 = str2;
                charSequence = str;
                i6 = 3;
                final int i15 = i2;
                final int i16 = i3;
                i7 = i13;
                i8 = intValue4;
                ofInt2.addListener(new AnimatorListenerAdapter() { // from class: com.transitionseverywhere.ChangeText.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator3) {
                        if (charSequence4.equals(textView.getText())) {
                            textView.setText(charSequence5);
                            TextView textView2 = textView;
                            if (textView2 instanceof EditText) {
                                ChangeText.this.setSelection((EditText) textView2, i15, i16);
                            }
                        }
                        textView.setTextColor(intValue4);
                    }
                });
                animator = ofInt2;
            } else {
                i7 = i13;
                c = 1;
                i8 = intValue4;
                charSequence = str;
                i5 = i4;
                animator = null;
                i6 = 3;
            }
            int i17 = this.mChangeBehavior;
            if (i17 == i6 || i17 == 2) {
                int[] iArr = new int[2];
                iArr[0] = 0;
                iArr[c] = Color.alpha(i8);
                ofInt = ValueAnimator.ofInt(iArr);
                i9 = i8;
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transitionseverywhere.ChangeText.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        textView.setTextColor((((Integer) valueAnimator.getAnimatedValue()).intValue() << 24) | (Color.red(i9) << 16) | (Color.green(i9) << 8) | Color.blue(i9));
                    }
                });
                ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.transitionseverywhere.ChangeText.5
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator3) {
                        textView.setTextColor(i9);
                    }
                });
            } else {
                i9 = i8;
                ofInt = null;
            }
            if (animator != null && ofInt != null) {
                Animator animatorSet = new AnimatorSet();
                Animator[] animatorArr = new Animator[2];
                animatorArr[0] = animator;
                animatorArr[c] = ofInt;
                ((AnimatorSet) animatorSet).playSequentially(animatorArr);
                animator2 = animatorSet;
            } else if (animator != null) {
                i10 = i9;
            } else {
                animator2 = ofInt;
            }
            i10 = i9;
            final CharSequence charSequence6 = str2;
            final int i18 = i2;
            final int i19 = i3;
            final CharSequence charSequence7 = charSequence;
            final int i20 = i5;
            final int i21 = i7;
            addListener(new TransitionListenerAdapter() { // from class: com.transitionseverywhere.ChangeText.6
                int mPausedColor = 0;

                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionPause(Transition transition) {
                    if (ChangeText.this.mChangeBehavior != 2) {
                        textView.setText(charSequence6);
                        TextView textView2 = textView;
                        if (textView2 instanceof EditText) {
                            ChangeText.this.setSelection((EditText) textView2, i18, i19);
                        }
                    }
                    if (ChangeText.this.mChangeBehavior > 0) {
                        this.mPausedColor = textView.getCurrentTextColor();
                        textView.setTextColor(i10);
                    }
                }

                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionResume(Transition transition) {
                    if (ChangeText.this.mChangeBehavior != 2) {
                        textView.setText(charSequence7);
                        TextView textView2 = textView;
                        if (textView2 instanceof EditText) {
                            ChangeText.this.setSelection((EditText) textView2, i20, i21);
                        }
                    }
                    if (ChangeText.this.mChangeBehavior > 0) {
                        textView.setTextColor(this.mPausedColor);
                    }
                }

                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionEnd(Transition transition) {
                    transition.removeListener(this);
                }
            });
            return animator2;
        }
        animator2 = animator;
        final CharSequence charSequence62 = str2;
        final int i182 = i2;
        final int i192 = i3;
        final CharSequence charSequence72 = charSequence;
        final int i202 = i5;
        final int i212 = i7;
        addListener(new TransitionListenerAdapter() { // from class: com.transitionseverywhere.ChangeText.6
            int mPausedColor = 0;

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
                if (ChangeText.this.mChangeBehavior != 2) {
                    textView.setText(charSequence62);
                    TextView textView2 = textView;
                    if (textView2 instanceof EditText) {
                        ChangeText.this.setSelection((EditText) textView2, i182, i192);
                    }
                }
                if (ChangeText.this.mChangeBehavior > 0) {
                    this.mPausedColor = textView.getCurrentTextColor();
                    textView.setTextColor(i10);
                }
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
                if (ChangeText.this.mChangeBehavior != 2) {
                    textView.setText(charSequence72);
                    TextView textView2 = textView;
                    if (textView2 instanceof EditText) {
                        ChangeText.this.setSelection((EditText) textView2, i202, i212);
                    }
                }
                if (ChangeText.this.mChangeBehavior > 0) {
                    textView.setTextColor(this.mPausedColor);
                }
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
            }
        });
        return animator2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelection(EditText editText, int i, int i2) {
        if (i < 0 || i2 < 0) {
            return;
        }
        editText.setSelection(i, i2);
    }
}
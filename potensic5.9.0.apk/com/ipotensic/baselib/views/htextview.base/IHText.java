package com.ipotensic.baselib.views.htextview.base;

import android.graphics.Canvas;
import android.util.AttributeSet;

/* loaded from: classes2.dex */
public interface IHText {
    void animateText(CharSequence charSequence);

    void init(HTextView hTextView, AttributeSet attributeSet, int i);

    void onDraw(Canvas canvas);

    void setAnimationListener(AnimationListener animationListener);
}
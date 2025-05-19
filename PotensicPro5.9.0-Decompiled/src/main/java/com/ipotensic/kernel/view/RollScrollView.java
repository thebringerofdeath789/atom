package com.ipotensic.kernel.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/* loaded from: classes2.dex */
public class RollScrollView extends ScrollView {
    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public RollScrollView(Context context) {
        super(context);
    }

    public RollScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RollScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

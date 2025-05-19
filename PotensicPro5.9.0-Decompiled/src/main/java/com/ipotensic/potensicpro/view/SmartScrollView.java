package com.ipotensic.potensicpro.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: classes2.dex */
public class SmartScrollView extends ScrollView {
    private onScrollViewScrollChanged listener;

    public interface onScrollViewScrollChanged {
        void onObservableScrollViewScrollChanged(int i, int i2, int i3, int i4);
    }

    public SmartScrollView(Context context) {
        super(context);
    }

    public SmartScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SmartScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        onScrollViewScrollChanged onscrollviewscrollchanged = this.listener;
        if (onscrollviewscrollchanged != null) {
            onscrollviewscrollchanged.onObservableScrollViewScrollChanged(i, i2, i3, i4);
        }
    }

    public void setOnScrollViewScrollChanged(onScrollViewScrollChanged onscrollviewscrollchanged) {
        this.listener = onscrollviewscrollchanged;
    }
}

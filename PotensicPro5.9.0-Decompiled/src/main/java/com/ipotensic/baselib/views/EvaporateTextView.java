package com.ipotensic.baselib.views;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.ipotensic.baselib.views.htextview.base.AnimationListener;
import com.ipotensic.baselib.views.htextview.base.HTextView;

/* loaded from: classes2.dex */
public class EvaporateTextView extends HTextView {
    private EvaporateText evaporateText;

    public EvaporateTextView(Context context) {
        this(context, null);
    }

    public EvaporateTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EvaporateTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i);
    }

    @Override // com.ipotensic.baselib.views.htextview.base.HTextView
    public void setAnimationListener(AnimationListener animationListener) {
        this.evaporateText.setAnimationListener(animationListener);
    }

    private void init(AttributeSet attributeSet, int i) {
        EvaporateText evaporateText = new EvaporateText();
        this.evaporateText = evaporateText;
        evaporateText.init(this, attributeSet, i);
        setMaxLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // com.ipotensic.baselib.views.htextview.base.HTextView
    public void setProgress(float f) {
        this.evaporateText.setProgress(f);
    }

    @Override // com.ipotensic.baselib.views.htextview.base.HTextView
    public void animateText(CharSequence charSequence) {
        this.evaporateText.animateText(charSequence);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.evaporateText.onDraw(canvas);
    }
}

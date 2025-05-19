package com.ipotensic.baselib.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes2.dex */
public class DrawbaleCenterTextView extends AppCompatTextView {
    public DrawbaleCenterTextView(Context context) {
        super(context);
    }

    public DrawbaleCenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DrawbaleCenterTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables != null && (drawable = compoundDrawables[0]) != null) {
            canvas.translate((getWidth() - ((getPaint().measureText(getText().toString()) + drawable.getIntrinsicWidth()) + getCompoundDrawablePadding())) / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }
}

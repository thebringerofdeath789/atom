package com.ipotensic.kernel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes2.dex */
public class DrawableTextView extends AppCompatTextView {
    public DrawableTextView(Context context) {
        super(context);
    }

    public DrawableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DrawableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getCompoundDrawables()[0];
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth() + getCompoundDrawablePadding() + ((int) getPaint().measureText(getText().toString().trim()));
            canvas.save();
            canvas.translate((getWidth() - intrinsicWidth) / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }
}

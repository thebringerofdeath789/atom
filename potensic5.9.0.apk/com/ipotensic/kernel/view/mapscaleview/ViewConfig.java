package com.ipotensic.kernel.view.mapscaleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
class ViewConfig {
    final int color;
    final int desiredWidth;
    final boolean expandRtl;
    final boolean isMiles;
    final boolean outline;
    final float strokeWidth;
    final float textSize;

    ViewConfig(Context context, AttributeSet attributeSet) {
        float f = context.getResources().getDisplayMetrics().density;
        this.desiredWidth = (int) (100.0f * f);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1965R.styleable.MapScaleView, 0, 0);
        try {
            this.color = obtainStyledAttributes.getColor(C1965R.styleable.MapScaleView_scale_color, Color.parseColor("#333333"));
            this.textSize = obtainStyledAttributes.getDimension(C1965R.styleable.MapScaleView_scale_textSize, 12.0f * f);
            this.strokeWidth = obtainStyledAttributes.getDimension(C1965R.styleable.MapScaleView_scale_strokeWidth, f * 1.5f);
            this.isMiles = obtainStyledAttributes.getBoolean(C1965R.styleable.MapScaleView_scale_miles, false);
            this.outline = obtainStyledAttributes.getBoolean(C1965R.styleable.MapScaleView_scale_outline, true);
            this.expandRtl = obtainStyledAttributes.getBoolean(C1965R.styleable.MapScaleView_scale_expandRtl, false);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
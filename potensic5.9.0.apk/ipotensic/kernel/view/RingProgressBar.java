package com.ipotensic.kernel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes2.dex */
public class RingProgressBar extends View {
    private int height;
    private boolean isInit;
    private int max;
    private Paint paint;
    private int progress;
    private int strokeWidth;
    private int width;

    public RingProgressBar(Context context) {
        super(context);
        this.strokeWidth = 10;
        this.progress = 0;
        this.max = 100;
        this.isInit = false;
        init();
    }

    public RingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.strokeWidth = 10;
        this.progress = 0;
        this.max = 100;
        this.isInit = false;
        init();
    }

    public RingProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.strokeWidth = 10;
        this.progress = 0;
        this.max = 100;
        this.isInit = false;
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(-16711936);
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.strokeWidth);
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
    }

    public void setProgress(int i) {
        if (this.isInit) {
            this.progress = i;
            postInvalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.isInit) {
            this.isInit = true;
            init();
        }
        int i = this.strokeWidth;
        canvas.drawArc(new RectF((i / 2) + 0, (i / 2) + 0, this.width - (i / 2), this.height - (i / 2)), -90.0f, (this.progress / this.max) * 360.0f, false, this.paint);
    }
}
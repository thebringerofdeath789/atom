package com.ipotensic.kernel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class CrossView extends View {
    private final float centerCircleRadius;
    private boolean isCrossShow;
    private boolean isNineGridShow;
    private boolean isPointShow;
    private Paint paint;
    private final Path path;

    public CrossView(Context context) {
        super(context);
        this.centerCircleRadius = 10.0f;
        this.path = new Path();
        this.isPointShow = false;
        this.isNineGridShow = false;
        this.isCrossShow = false;
        initPaint();
    }

    public CrossView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.centerCircleRadius = 10.0f;
        this.path = new Path();
        this.isPointShow = false;
        this.isNineGridShow = false;
        this.isCrossShow = false;
        initPaint();
    }

    public CrossView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.centerCircleRadius = 10.0f;
        this.path = new Path();
        this.isPointShow = false;
        this.isNineGridShow = false;
        this.isCrossShow = false;
        initPaint();
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setColor(getContext().getColor(R.color.colorSixPercent));
        this.paint.setStrokeWidth(1.0f);
    }

    public void setPointShow(boolean z) {
        this.isPointShow = z;
        postInvalidate();
    }

    public void setNineGridShow(boolean z) {
        this.isNineGridShow = z;
        postInvalidate();
    }

    public void setCrossShow(boolean z) {
        this.isCrossShow = z;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        int color = getContext().getColor(R.color.color50TransBlack);
        int color2 = getContext().getColor(R.color.white);
        if (this.isNineGridShow) {
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(color);
            this.path.reset();
            float f = measuredHeight / 3.0f;
            float f2 = f + 2.0f;
            this.path.moveTo(0.0f, f2);
            float f3 = f - 2.0f;
            this.path.lineTo(0.0f, f3);
            this.path.lineTo(measuredWidth, f3);
            this.path.lineTo(measuredWidth, f2);
            canvas.drawPath(this.path, this.paint);
            this.paint.setColor(color2);
            this.path.reset();
            float f4 = f + 1.0f;
            this.path.moveTo(0.0f, f4);
            float f5 = f - 1.0f;
            this.path.lineTo(0.0f, f5);
            this.path.lineTo(measuredWidth, f5);
            this.path.lineTo(measuredWidth, f4);
            canvas.drawPath(this.path, this.paint);
            this.paint.setColor(color);
            this.path.reset();
            float f6 = (measuredHeight * 2.0f) / 3.0f;
            float f7 = f6 + 2.0f;
            this.path.moveTo(0.0f, f7);
            float f8 = f6 - 2.0f;
            this.path.lineTo(0.0f, f8);
            this.path.lineTo(measuredWidth, f8);
            this.path.lineTo(measuredWidth, f7);
            canvas.drawPath(this.path, this.paint);
            this.paint.setColor(color2);
            this.path.reset();
            float f9 = f6 + 1.0f;
            this.path.moveTo(0.0f, f9);
            float f10 = f6 - 1.0f;
            this.path.lineTo(0.0f, f10);
            this.path.lineTo(measuredWidth, f10);
            this.path.lineTo(measuredWidth, f9);
            canvas.drawPath(this.path, this.paint);
            this.paint.setColor(color);
            this.path.reset();
            float f11 = measuredWidth / 3.0f;
            float f12 = f11 - 2.0f;
            this.path.moveTo(f12, 0.0f);
            float f13 = f11 + 2.0f;
            this.path.lineTo(f13, 0.0f);
            this.path.lineTo(f13, measuredHeight);
            this.path.lineTo(f12, measuredHeight);
            canvas.drawPath(this.path, this.paint);
            this.paint.setColor(color2);
            this.path.reset();
            float f14 = f11 - 1.0f;
            this.path.moveTo(f14, 0.0f);
            float f15 = f11 + 1.0f;
            this.path.lineTo(f15, 0.0f);
            this.path.lineTo(f15, measuredHeight);
            this.path.lineTo(f14, measuredHeight);
            canvas.drawPath(this.path, this.paint);
            this.paint.setColor(color);
            this.path.reset();
            float f16 = (measuredWidth * 2.0f) / 3.0f;
            float f17 = f16 - 2.0f;
            this.path.moveTo(f17, 0.0f);
            float f18 = f16 + 2.0f;
            this.path.lineTo(f18, 0.0f);
            this.path.lineTo(f18, measuredHeight);
            this.path.lineTo(f17, measuredHeight);
            canvas.drawPath(this.path, this.paint);
            this.paint.setColor(color2);
            this.path.reset();
            float f19 = f16 - 1.0f;
            this.path.moveTo(f19, 0.0f);
            float f20 = f16 + 1.0f;
            this.path.lineTo(f20, 0.0f);
            this.path.lineTo(f20, measuredHeight);
            this.path.lineTo(f19, measuredHeight);
            canvas.drawPath(this.path, this.paint);
        }
        if (this.isCrossShow) {
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(color);
            this.path.reset();
            this.path.moveTo(0.0f, 3.0f);
            this.path.lineTo(0.0f, 0.0f);
            this.path.lineTo(3.0f, 0.0f);
            float f21 = measuredHeight - 3.0f;
            this.path.lineTo(measuredWidth, f21);
            this.path.lineTo(measuredWidth, measuredHeight);
            float f22 = measuredWidth - 3.0f;
            this.path.lineTo(f22, measuredHeight);
            canvas.drawPath(this.path, this.paint);
            this.paint.setColor(color2);
            this.path.reset();
            this.path.moveTo(0.0f, 1.5f);
            this.path.lineTo(0.0f, 0.0f);
            this.path.lineTo(1.5f, 0.0f);
            float f23 = measuredHeight - 1.5f;
            this.path.lineTo(measuredWidth, f23);
            this.path.lineTo(measuredWidth, measuredHeight);
            float f24 = measuredWidth - 1.5f;
            this.path.lineTo(f24, measuredHeight);
            canvas.drawPath(this.path, this.paint);
            this.paint.setColor(color);
            this.path.reset();
            this.path.moveTo(measuredWidth, 3.0f);
            this.path.lineTo(measuredWidth, 0.0f);
            this.path.lineTo(f22, 0.0f);
            this.path.lineTo(0.0f, f21);
            this.path.lineTo(0.0f, measuredHeight);
            this.path.lineTo(3.0f, measuredHeight);
            canvas.drawPath(this.path, this.paint);
            this.paint.setColor(color2);
            this.path.reset();
            this.path.moveTo(measuredWidth, 1.5f);
            this.path.lineTo(measuredWidth, 0.0f);
            this.path.lineTo(f24, 0.0f);
            this.path.lineTo(0.0f, f23);
            this.path.lineTo(0.0f, measuredHeight);
            this.path.lineTo(1.5f, measuredHeight);
            this.path.close();
            canvas.drawPath(this.path, this.paint);
        }
        if (this.isPointShow) {
            this.paint.setColor(-1);
            this.paint.setStyle(Paint.Style.FILL);
            float f25 = measuredWidth / 2.0f;
            float f26 = measuredHeight / 2.0f;
            canvas.drawCircle(f25, f26, 10.0f, this.paint);
            this.paint.setColor(color);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(5.0f);
            canvas.drawCircle(f25, f26, 10.0f, this.paint);
        }
    }
}
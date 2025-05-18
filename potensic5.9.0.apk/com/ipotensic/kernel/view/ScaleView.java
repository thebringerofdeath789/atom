package com.ipotensic.kernel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.utils.UnitUtil;

/* loaded from: classes2.dex */
public class ScaleView extends View {
    private Paint mPaint;
    private Paint mTextPaint;
    private int position;

    private void initPaint() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(Color.parseColor("#999999"));
        this.mPaint.setStrokeWidth(UnitUtil.dp2px(2));
        Paint paint2 = new Paint();
        this.mTextPaint = paint2;
        paint2.setAntiAlias(true);
        this.mTextPaint.setTextSize(UnitUtil.sp2px(16));
        this.mTextPaint.setTypeface(PhoneConfig.typeface);
    }

    public ScaleView(Context context) {
        super(context);
        this.position = 6;
        initPaint();
    }

    public ScaleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.position = 6;
        initPaint();
    }

    public ScaleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.position = 6;
        initPaint();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawIndicator(canvas);
        drawText(canvas);
    }

    private void drawIndicator(Canvas canvas) {
        int paddingStart = getPaddingStart();
        int measuredWidth = (((getMeasuredWidth() - getPaddingStart()) - getPaddingEnd()) + UnitUtil.dp2px(2)) / 19;
        for (int i = 0; i <= 20; i++) {
            int dp2px = UnitUtil.dp2px(7);
            int dp2px2 = UnitUtil.dp2px(25);
            if (i == 10) {
                dp2px = UnitUtil.dp2px(13);
                dp2px2 = UnitUtil.dp2px(22);
            }
            int i2 = this.position;
            boolean z = i2 < 10;
            int i3 = z ? i2 : 10;
            int i4 = z ? 10 : i2;
            if (i >= i3 && i <= i4) {
                this.mPaint.setColor(getPositionColor());
            } else {
                this.mPaint.setColor(Color.parseColor("#999999"));
            }
            float f = paddingStart;
            canvas.drawLine(f, dp2px2, f, dp2px2 + dp2px, this.mPaint);
            if (i == this.position) {
                canvas.drawPoint(f, UnitUtil.dp2px(40), this.mPaint);
            }
            paddingStart += measuredWidth;
        }
    }

    private void drawText(Canvas canvas) {
        String textFromPosition = getTextFromPosition();
        int paddingStart = getPaddingStart() + (((((getMeasuredWidth() - getPaddingStart()) - getPaddingEnd()) + UnitUtil.dp2px(2)) / 19) * this.position);
        Rect rect = new Rect();
        float measureText = this.mTextPaint.measureText(textFromPosition);
        this.mTextPaint.getTextBounds(textFromPosition, 0, textFromPosition.length(), rect);
        this.mTextPaint.setColor(getPositionColor());
        canvas.drawText(textFromPosition, paddingStart - (measureText / 2.0f), UnitUtil.dp2px(2) + rect.height(), this.mTextPaint);
    }

    private String getTextFromPosition() {
        float f = (this.position - 10) / 10.0f;
        if (f > 0.0f) {
            return "+" + f;
        }
        return String.valueOf(f);
    }

    private int getPositionColor() {
        int i = this.position;
        return Color.parseColor(((i <= 3 || i > 8) && (i < 12 || i >= 17)) ? (i <= 8 || i >= 12) ? "#CB0813" : "#00D505" : "#D96F1D");
    }

    public void setPosition(int i) {
        if (i > 20) {
            return;
        }
        this.position = i;
        invalidate();
    }
}
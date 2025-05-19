package com.ipotensic.kernel.view.mapscaleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import com.ipotensic.baselib.configs.PhoneConfig;

/* loaded from: classes2.dex */
public class Drawer {
    private boolean expandRtlEnabled;
    private float horizontalLineY;
    private final Path outlineDiffPath;
    private boolean outlineEnabled;
    private final Paint outlinePaint;
    private float outlineStrokeDiff;
    private float outlineStrokeWidth;
    private float outlineTextStrokeWidth;
    private final Paint strokePaint;
    private final Path strokePath;
    private float textHeight;
    private final Paint textPaint;
    private int viewWidth;

    Drawer(int i, float f, float f2, float f3, boolean z, boolean z2, Context context) {
        Paint paint = new Paint();
        this.textPaint = paint;
        Paint paint2 = new Paint();
        this.strokePaint = paint2;
        this.strokePath = new Path();
        Paint paint3 = new Paint();
        this.outlinePaint = paint3;
        this.outlineDiffPath = new Path();
        this.outlineStrokeWidth = 2.0f;
        this.outlineStrokeDiff = (2.0f / 2.0f) / 2.0f;
        this.outlineTextStrokeWidth = 3.0f;
        this.outlineEnabled = true;
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(f);
        paint.setTypeface(PhoneConfig.typeface);
        paint2.setAntiAlias(true);
        paint2.setColor(i);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(f2);
        paint2.setTypeface(PhoneConfig.typeface);
        paint3.set(paint2);
        paint3.setARGB(255, 255, 255, 255);
        this.outlineStrokeWidth = f2 * 2.0f;
        this.outlineStrokeDiff = f2 / 2.0f;
        this.outlineTextStrokeWidth = f3 * 2.0f;
        this.outlineEnabled = z;
        this.expandRtlEnabled = z2;
        update();
    }

    void update() {
        this.outlinePaint.setTextSize(this.textPaint.getTextSize());
        this.outlinePaint.setStrokeWidth(this.outlineTextStrokeWidth);
        Rect rect = new Rect();
        (this.outlineEnabled ? this.outlinePaint : this.textPaint).getTextBounds("1234567890kmift", 0, 15, rect);
        float height = rect.height();
        this.textHeight = height;
        this.horizontalLineY = height + (height / 2.0f);
    }

    int getHeight() {
        return (int) ((this.textPaint.getTextSize() * 2.0f) + this.textPaint.getStrokeWidth());
    }

    void setColor(int i) {
        this.textPaint.setColor(i);
        this.strokePaint.setColor(i);
    }

    void setTextSize(float f) {
        this.textPaint.setTextSize(f);
        update();
    }

    void setStrokeWidth(float f) {
        this.strokePaint.setStrokeWidth(f);
        this.outlineStrokeWidth = f * 2.0f;
        this.outlineStrokeDiff = f / 2.0f;
        update();
    }

    void setOutlineEnabled(boolean z) {
        this.outlineEnabled = z;
        update();
    }

    void setExpandRtlEnabled(boolean z) {
        this.expandRtlEnabled = z;
    }

    void setViewWidth(int i) {
        this.viewWidth = i;
    }

    void draw(Canvas canvas, Scales scales) {
        if (scales == null || scales.top() == null) {
            return;
        }
        if (this.expandRtlEnabled && this.viewWidth == 0) {
            this.expandRtlEnabled = false;
        }
        Scale pVar = scales.top();
        if (this.expandRtlEnabled) {
            this.outlinePaint.setTextAlign(Paint.Align.RIGHT);
            this.textPaint.setTextAlign(Paint.Align.RIGHT);
        } else {
            this.outlinePaint.setTextAlign(Paint.Align.LEFT);
            this.textPaint.setTextAlign(Paint.Align.LEFT);
        }
        if (this.outlineEnabled) {
            this.outlinePaint.setStrokeWidth(this.outlineTextStrokeWidth);
            canvas.drawText(pVar.text(), this.expandRtlEnabled ? this.viewWidth : 0.0f, this.textHeight, this.outlinePaint);
        }
        canvas.drawText(pVar.text(), this.expandRtlEnabled ? this.viewWidth : 0.0f, this.textHeight, this.textPaint);
        this.strokePath.rewind();
        this.strokePath.moveTo(this.expandRtlEnabled ? this.viewWidth - this.outlineStrokeDiff : this.outlineStrokeDiff, this.horizontalLineY);
        this.strokePath.lineTo(this.expandRtlEnabled ? this.viewWidth - pVar.length() : pVar.length(), this.horizontalLineY);
        if (this.outlineEnabled) {
            this.strokePath.lineTo(this.expandRtlEnabled ? this.viewWidth - pVar.length() : pVar.length(), this.textHeight + this.outlineStrokeDiff);
        } else {
            this.strokePath.lineTo(this.expandRtlEnabled ? this.viewWidth - pVar.length() : pVar.length(), this.textHeight);
        }
        Scale bottom = scales.bottom();
        if (bottom != null) {
            if (bottom.length() > pVar.length()) {
                this.strokePath.moveTo(this.expandRtlEnabled ? this.viewWidth - pVar.length() : pVar.length(), this.horizontalLineY);
                this.strokePath.lineTo(this.expandRtlEnabled ? this.viewWidth - bottom.length() : bottom.length(), this.horizontalLineY);
            } else {
                this.strokePath.moveTo(this.expandRtlEnabled ? this.viewWidth - bottom.length() : bottom.length(), this.horizontalLineY);
            }
            this.strokePath.lineTo(this.expandRtlEnabled ? this.viewWidth - bottom.length() : bottom.length(), this.textHeight * 2.0f);
            float f = this.horizontalLineY;
            float f2 = this.textHeight;
            float f3 = f + f2 + (f2 / 2.0f);
            if (this.outlineEnabled) {
                canvas.drawText(bottom.text(), this.expandRtlEnabled ? this.viewWidth : 0.0f, f3, this.outlinePaint);
            }
            canvas.drawText(bottom.text(), this.expandRtlEnabled ? this.viewWidth : 0.0f, f3, this.textPaint);
        }
        if (this.outlineEnabled) {
            this.outlinePaint.setStrokeWidth(this.outlineStrokeWidth);
            this.outlineDiffPath.rewind();
            this.outlineDiffPath.moveTo(this.expandRtlEnabled ? this.viewWidth : 0.0f, this.horizontalLineY);
            this.outlineDiffPath.lineTo(this.expandRtlEnabled ? this.viewWidth - this.outlineStrokeDiff : this.outlineStrokeDiff, this.horizontalLineY);
            this.outlineDiffPath.moveTo(this.expandRtlEnabled ? this.viewWidth - pVar.length() : pVar.length(), this.textHeight + this.outlineStrokeDiff);
            this.outlineDiffPath.lineTo(this.expandRtlEnabled ? this.viewWidth - pVar.length() : pVar.length(), this.textHeight);
            if (bottom != null) {
                this.outlineDiffPath.moveTo(this.expandRtlEnabled ? this.viewWidth - bottom.length() : bottom.length(), this.textHeight * 2.0f);
                this.outlineDiffPath.lineTo(this.expandRtlEnabled ? this.viewWidth - bottom.length() : bottom.length(), (this.textHeight * 2.0f) + this.outlineStrokeDiff);
            }
            canvas.drawPath(this.outlineDiffPath, this.outlinePaint);
            canvas.drawPath(this.strokePath, this.outlinePaint);
        }
        canvas.drawPath(this.strokePath, this.strokePaint);
    }
}

package com.ipotensic.kernel.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import androidx.core.content.ContextCompat;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.utils.LanguageHelper;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class BatteryProgressView extends View {
    private Paint arcPaint;
    private Paint bacPaint;
    private int bgColor;
    private float curProgressAngle;
    private String electricContent;
    private float electricContentWidth;
    private int fontColor;
    private Paint fontPaint;
    private int forColor;
    private Paint forPaint;
    private int lineColor;
    private Paint linePaint;
    private float mProgressAngle;
    private float mSweepAngle;
    private String percentageContent;
    private float startAngle;
    private float strokeWidth;
    private String surplusContent;
    private float surplusContentWidth;
    private float sweepAngle;
    private Paint titlePaint;

    public BatteryProgressView(Context context) {
        this(context, null);
    }

    public BatteryProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.BatteryProgressView);
    }

    public BatteryProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.percentageContent = "N/A";
        this.mProgressAngle = 0.0f;
        this.mSweepAngle = 0.0f;
        this.curProgressAngle = 0.0f;
        obtainAttrs(context, attributeSet);
        init();
    }

    private void obtainAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BatteryProgressView);
        Resources resources = getResources();
        this.lineColor = obtainStyledAttributes.getColor(R.styleable.BatteryProgressView_lineColor, resources.getColor(R.color.color_battery_line));
        this.bgColor = obtainStyledAttributes.getColor(R.styleable.BatteryProgressView_bgColor, resources.getColor(R.color.color_battery_bg));
        this.forColor = obtainStyledAttributes.getColor(R.styleable.BatteryProgressView_forColor, resources.getColor(R.color.color_battery_for));
        this.fontColor = obtainStyledAttributes.getColor(R.styleable.BatteryProgressView_fontColor, resources.getColor(R.color.colorWhite));
        this.startAngle = obtainStyledAttributes.getFloat(R.styleable.BatteryProgressView_startAngle, 135.0f);
        this.sweepAngle = obtainStyledAttributes.getFloat(R.styleable.BatteryProgressView_sweepAngle, 270.0f);
        this.surplusContent = resources.getString(R.string.sys_surplus);
        this.electricContent = resources.getString(R.string.sys_electric);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        this.forPaint = new Paint();
        this.bacPaint = new Paint();
        this.linePaint = new Paint();
        this.fontPaint = new Paint();
        this.titlePaint = new Paint();
        this.arcPaint = new Paint();
        this.linePaint.setAntiAlias(true);
        this.linePaint.setStyle(Paint.Style.STROKE);
        this.linePaint.setColor(this.lineColor);
        this.bacPaint.setAntiAlias(true);
        this.bacPaint.setStyle(Paint.Style.STROKE);
        this.bacPaint.setColor(this.bgColor);
        this.forPaint.setAntiAlias(true);
        this.forPaint.setStyle(Paint.Style.STROKE);
        this.forPaint.setColor(this.forColor);
        this.fontPaint.setAntiAlias(true);
        this.fontPaint.setColor(this.fontColor);
        this.fontPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.fontPaint.setTextSize(getResources().getDimension(R.dimen.sp_20));
        this.fontPaint.setTypeface(PhoneConfig.typeface);
        this.titlePaint.setAntiAlias(true);
        this.titlePaint.setColor(this.fontColor);
        this.titlePaint.setTypeface(PhoneConfig.typeface);
        if (LanguageHelper.getLanguage(getContext()).equals(LanguageHelper.LANGUAGE_TYPE.CHINESE) || LanguageHelper.getLanguage(getContext()).equals(LanguageHelper.LANGUAGE_TYPE.JAPAN)) {
            this.titlePaint.setLetterSpacing(0.3f);
        }
        this.titlePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.titlePaint.setTextSize(getResources().getDimension(R.dimen.sp_9));
        this.surplusContentWidth = this.titlePaint.measureText(this.surplusContent);
        this.electricContentWidth = this.titlePaint.measureText(this.electricContent);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int min = Math.min(width, height);
        int i = (height / 35) * 3;
        float f = r4 + i + 0.5f;
        float f2 = i + r5 + 0.5f;
        float f3 = (f2 - 6.0f) * 2.0f;
        this.strokeWidth = f3;
        this.bacPaint.setStrokeWidth(f3);
        this.forPaint.setStrokeWidth(this.strokeWidth);
        RectF rectF = new RectF(f, f2, width - f, height - f2);
        canvas.drawArc(rectF, this.startAngle, this.sweepAngle, false, this.bacPaint);
        canvas.drawArc(rectF, this.startAngle, this.mProgressAngle, false, this.forPaint);
        this.linePaint.setStrokeWidth(4.0f);
        float f4 = ((width - min) / 2) + 6;
        float f5 = ((height - min) / 2) + 6;
        canvas.drawArc(new RectF(f4, f5, width - r4, height - r5), this.startAngle, this.sweepAngle, false, this.linePaint);
        float f6 = ((min / 17) * 3) + 0.5f;
        int i2 = (int) (f4 + f6);
        int i3 = (int) (f5 + f6);
        canvas.drawArc(new RectF(i2, i3, width - i2, height - i3), this.startAngle, this.sweepAngle, false, this.linePaint);
        float f7 = width / 2;
        int i4 = min / 2;
        float f8 = i4 - i3;
        float f9 = i4;
        canvas.drawLine(f7 + (((float) Math.cos((this.startAngle * 3.141592653589793d) / 180.0d)) * f8), f9 + (((float) Math.sin((this.startAngle * 3.141592653589793d) / 180.0d)) * f8), f7 + ((this.strokeWidth + f8) * ((float) Math.cos((this.startAngle * 3.141592653589793d) / 180.0d))), f9 + ((this.strokeWidth + f8) * ((float) Math.sin((this.startAngle * 3.141592653589793d) / 180.0d))), this.linePaint);
        canvas.drawLine(f7 + (((float) Math.cos(0.7853981633974483d)) * f8), f9 + (((float) Math.sin(0.7853981633974483d)) * f8), f7 + ((this.strokeWidth + f8 + 2.0f) * ((float) Math.cos(0.7853981633974483d))), f9 + ((f8 + this.strokeWidth + 2.0f) * ((float) Math.sin(0.7853981633974483d))), this.linePaint);
        printTextContent(canvas, width, height);
    }

    private void printTextContent(Canvas canvas, int i, int i2) {
        float f = i / 2;
        canvas.drawText(this.percentageContent, f - (this.fontPaint.measureText(this.percentageContent) / 2.0f), (i2 / 2) + 15, this.fontPaint);
        canvas.drawText(this.surplusContent, f - (this.surplusContentWidth / 2.0f), i2 - 55, this.titlePaint);
        canvas.translate(0.0f, 5.0f);
        canvas.drawText(this.electricContent, f - (this.electricContentWidth / 2.0f), i2 - 25, this.titlePaint);
    }

    public void setProgress(int i) {
        float round = Math.round(i * 2.7f);
        this.mSweepAngle = round;
        if (this.curProgressAngle == round) {
            return;
        }
        this.percentageContent = String.format("%s%%", Integer.valueOf(i));
        if (i <= 20) {
            this.bacPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_battery_warn_bg));
            this.forPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_battery_warn_for));
            this.linePaint.setColor(ContextCompat.getColor(getContext(), R.color.color_battery_warn_line));
            this.fontPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_battery_warn_for));
        } else {
            this.bacPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_battery_bg));
            this.forPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_battery_for));
            this.linePaint.setColor(ContextCompat.getColor(getContext(), R.color.color_battery_line));
            this.fontPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.curProgressAngle, this.mSweepAngle);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.ipotensic.kernel.view.BatteryProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BatteryProgressView.this.mProgressAngle = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BatteryProgressView.this.invalidate();
            }
        });
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(1000L);
        ofFloat.start();
        this.curProgressAngle = this.mSweepAngle;
    }

    public void disconnect() {
        this.percentageContent = "N/A";
        this.bacPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_battery_bg));
        this.forPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_battery_for));
        this.linePaint.setColor(ContextCompat.getColor(getContext(), R.color.color_battery_line));
        this.fontPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
        this.curProgressAngle = 0.0f;
        this.mProgressAngle = 0.0f;
        this.mSweepAngle = 0.0f;
        invalidate();
    }
}

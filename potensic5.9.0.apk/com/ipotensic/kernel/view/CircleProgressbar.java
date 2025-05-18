package com.ipotensic.kernel.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import com.ipotensic.baselib.configs.PhoneConfig;

/* loaded from: classes2.dex */
public class CircleProgressbar extends AppCompatTextView {
    private Paint bgPaint;
    private RectF bounds;
    private float centerX;
    private float centerY;
    private int height;
    private float lineWidth;
    private int mCountdownTime;
    private int mCurrentProgress;
    private OnCountDownListener mListener;
    private ValueAnimator valueAnimator;
    private int width;

    public interface OnCountDownListener {
        void countDownFinished();
    }

    public CircleProgressbar(Context context) {
        this(context, null);
    }

    public CircleProgressbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lineWidth = 6.0f;
        this.mCurrentProgress = 0;
        this.mCountdownTime = 8;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.width = getWidth();
        this.height = getHeight();
        RectF rectF = new RectF(0.0f, 0.0f, this.width, this.height);
        this.bounds = rectF;
        this.centerX = rectF.centerX();
        this.centerY = this.bounds.centerY();
        Paint paint = new Paint();
        this.bgPaint = paint;
        paint.setAntiAlias(true);
        this.bgPaint.setStyle(Paint.Style.STROKE);
        this.bgPaint.setStrokeWidth(this.lineWidth);
        this.bgPaint.setColor(Color.parseColor("#4Dffffff"));
        canvas.drawCircle(this.centerX, this.centerY, (this.width / 2.0f) - this.lineWidth, this.bgPaint);
        Paint paint2 = new Paint();
        float f = this.centerY - paint2.getFontMetricsInt().top;
        paint2.setAntiAlias(true);
        paint2.setColor(-1);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setTextSize(42.0f);
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setTypeface(PhoneConfig.typeface);
        StringBuilder sb = new StringBuilder();
        int i = this.mCountdownTime;
        canvas.drawText(sb.append(i - ((int) ((this.mCurrentProgress / 360.0f) * i))).append("").toString(), this.centerX, f, paint2);
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(this.lineWidth);
        paint3.setColor(-1);
        float f2 = this.lineWidth;
        canvas.drawArc(new RectF(f2, f2, this.width - f2, this.height - f2), -90.0f, this.mCurrentProgress, false, paint3);
    }

    private ValueAnimator getValueAnimator(long j) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(0);
        return ofFloat;
    }

    public void startCountDown() {
        ValueAnimator valueAnimator = getValueAnimator(this.mCountdownTime * 1000);
        this.valueAnimator = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.ipotensic.kernel.view.CircleProgressbar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CircleProgressbar.this.mCurrentProgress = (int) Float.valueOf(String.valueOf(valueAnimator2.getAnimatedValue())).floatValue();
                CircleProgressbar.this.invalidate();
            }
        });
        this.valueAnimator.start();
        this.valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.ipotensic.kernel.view.CircleProgressbar.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (CircleProgressbar.this.mListener != null) {
                    CircleProgressbar.this.mListener.countDownFinished();
                }
            }
        });
    }

    public void setOnCountDownListener(OnCountDownListener onCountDownListener) {
        this.mListener = onCountDownListener;
    }
}
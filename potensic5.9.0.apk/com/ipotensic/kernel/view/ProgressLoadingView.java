package com.ipotensic.kernel.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public class ProgressLoadingView extends View {
    private RectF arcRectF;
    private boolean isReverse;
    private boolean isStart;
    private float minRadian;
    private float padding;
    private Paint paint;
    private float progress;
    private final float radian;
    private long rotateTime;
    private float strokeWidth;
    private ValueAnimator valueAnimator;

    public ProgressLoadingView(Context context) {
        this(context, null);
    }

    public ProgressLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProgressLoadingView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ProgressLoadingView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.isStart = false;
        this.rotateTime = 2500L;
        this.arcRectF = new RectF();
        this.radian = 180.0f;
        this.strokeWidth = context.getResources().getDimension(C1965R.dimen.dp_6);
        this.padding = context.getResources().getDimension(C1965R.dimen.dp_12);
    }

    public void setPadding(float f) {
        this.padding = f;
    }

    public void setStrokeWidth(float f) {
        this.strokeWidth = f;
    }

    public void setRotateTime(long j) {
        this.rotateTime = j;
    }

    private void init() {
        if (this.paint == null) {
            Paint paint = new Paint();
            this.paint = paint;
            paint.setAntiAlias(true);
            this.paint.setColor(-1);
            this.paint.setStrokeWidth(this.strokeWidth);
            this.paint.setStrokeCap(Paint.Cap.ROUND);
            this.paint.setStyle(Paint.Style.STROKE);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        init();
        float f = this.padding + (this.strokeWidth / 2.0f);
        this.arcRectF.set(f, f, getWidth() - f, getHeight() - f);
        float f2 = this.isReverse ? this.progress * 180.0f : 0.0f;
        canvas.drawArc(this.arcRectF, 270.0f - f2, this.progress * 180.0f, false, this.paint);
        canvas.drawArc(this.arcRectF, 90.0f - f2, this.progress * 180.0f, false, this.paint);
    }

    private void startAnim() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.minRadian, 1.0f);
        this.valueAnimator = ofFloat;
        ofFloat.setDuration(this.rotateTime);
        this.valueAnimator.setRepeatMode(2);
        this.valueAnimator.setRepeatCount(-1);
        this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.ipotensic.kernel.view.-$$Lambda$ProgressLoadingView$ubu0w6HS4lJCmuoCdFJjvEeTW8s
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ProgressLoadingView.this.lambda$startAnim$0$ProgressLoadingView(valueAnimator);
            }
        });
        this.valueAnimator.start();
    }

    public /* synthetic */ void lambda$startAnim$0$ProgressLoadingView(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.isReverse = this.progress >= floatValue;
        this.progress = floatValue;
        postInvalidate();
    }

    public void showProgress() {
        startAnim();
    }

    public void hideProgress() {
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.valueAnimator = null;
            this.progress = 0.0f;
            this.isReverse = false;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hideProgress();
    }
}
package com.ipotensic.baselib.views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.view.ViewCompat;
import com.ipotensic.baselib.views.htextview.base.CharacterDiffResult;
import com.ipotensic.baselib.views.htextview.base.CharacterUtils;
import com.ipotensic.baselib.views.htextview.base.DefaultAnimatorListener;
import com.ipotensic.baselib.views.htextview.base.HText;
import com.ipotensic.baselib.views.htextview.base.HTextView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class EvaporateText extends HText {
    private ValueAnimator animator;
    private long duration;
    private int mTextHeight;
    private int mTextWidth;
    float charTime = 300.0f;
    int mostCount = 40;
    private List<CharacterDiffResult> differentList = new ArrayList();

    @Override // com.ipotensic.baselib.views.htextview.base.HText
    protected void initVariables() {
    }

    @Override // com.ipotensic.baselib.views.htextview.base.HText, com.ipotensic.baselib.views.htextview.base.IHText
    public void init(HTextView hTextView, AttributeSet attributeSet, int i) {
        super.init(hTextView, attributeSet, i);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.animator = valueAnimator;
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.animator.addListener(new DefaultAnimatorListener() { // from class: com.ipotensic.baselib.views.EvaporateText.1
            @Override // com.ipotensic.baselib.views.htextview.base.DefaultAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (EvaporateText.this.animationListener != null) {
                    EvaporateText.this.animationListener.onAnimationEnd(EvaporateText.this.mHTextView);
                }
            }
        });
        this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.ipotensic.baselib.views.EvaporateText.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                EvaporateText.this.progress = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                EvaporateText.this.mHTextView.invalidate();
            }
        });
        int length = this.mText.length();
        if (length <= 0) {
            length = 1;
        }
        float f = this.charTime;
        this.duration = (long) (f + ((f / this.mostCount) * (length - 1)));
    }

    @Override // com.ipotensic.baselib.views.htextview.base.HText, com.ipotensic.baselib.views.htextview.base.IHText
    public void animateText(final CharSequence charSequence) {
        this.mHTextView.post(new Runnable() { // from class: com.ipotensic.baselib.views.EvaporateText.3
            @Override // java.lang.Runnable
            public void run() {
                if (EvaporateText.this.mHTextView == null || EvaporateText.this.mHTextView.getLayout() == null) {
                    return;
                }
                EvaporateText evaporateText = EvaporateText.this;
                evaporateText.oldStartX = evaporateText.mHTextView.getLayout().getLineLeft(0) + EvaporateText.this.mHTextView.getPaddingStart();
                EvaporateText.super.animateText(charSequence);
            }
        });
    }

    @Override // com.ipotensic.baselib.views.htextview.base.HText
    protected void animateStart(CharSequence charSequence) {
        int length = this.mText.length();
        if (length <= 0) {
            length = 1;
        }
        float f = this.charTime;
        this.duration = (long) (f + ((f / this.mostCount) * (length - 1)));
        this.animator.cancel();
        this.animator.setFloatValues(0.0f, 1.0f);
        this.animator.setDuration(this.duration);
        this.animator.start();
    }

    @Override // com.ipotensic.baselib.views.htextview.base.HText
    protected void animatePrepare(CharSequence charSequence) {
        this.differentList.clear();
        this.differentList.addAll(CharacterUtils.diff(this.mOldText, this.mText));
        Rect rect = new Rect();
        this.mPaint.getTextBounds(this.mText.toString(), 0, this.mText.length(), rect);
        this.mTextHeight = rect.height();
        this.mTextWidth = rect.width();
    }

    @Override // com.ipotensic.baselib.views.htextview.base.HText
    protected void drawFrame(Canvas canvas) {
        if (this.mHTextView.getLayout() == null) {
            return;
        }
        float lineLeft = this.mHTextView.getLayout().getLineLeft(0) + this.mHTextView.getPaddingLeft();
        float baseline = this.mHTextView.getBaseline();
        this.mPaint.setColor(this.mHTextView.getCurrentTextColor());
        if (this.mText.length() == this.mOldText.length()) {
            drawStroke(canvas, this.mPaint, this.mText.toString(), lineLeft, baseline);
            canvas.drawText(this.mText.toString(), lineLeft, baseline, this.mPaint);
            return;
        }
        float measureText = this.mPaint.measureText(this.mText.toString()) - this.mPaint.measureText(this.mOldText.toString());
        for (int i = 0; i < this.mText.length(); i++) {
            int i2 = (int) ((255.0f / this.charTime) * ((this.progress * this.duration) - ((this.charTime * i) / this.mostCount)));
            if (i2 > 255) {
                i2 = 255;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            this.mPaint.setAlpha(i2);
            this.mPaint.setTextSize(this.mTextSize);
            float f = this.progress * this.duration;
            float f2 = this.charTime;
            float floatValue = ((((this.gapList.get(i).floatValue() - this.mPaint.measureText(this.mText.charAt(i) + "")) / 2.0f) + lineLeft) + measureText) - ((f / (f2 + ((f2 / this.mostCount) * (this.mText.length() - 1)))) * measureText);
            drawStroke(canvas, this.mPaint, this.mText.charAt(i) + "", floatValue, baseline);
            canvas.drawText(this.mText.charAt(i) + "", 0, 1, floatValue, baseline, (Paint) this.mPaint);
            lineLeft += this.gapList.get(i).floatValue();
        }
    }

    private void drawStroke(Canvas canvas, TextPaint textPaint, String str, float f, float f2) {
        float strokeWidth = textPaint.getStrokeWidth();
        Paint.Style style = textPaint.getStyle();
        int color = textPaint.getColor();
        textPaint.setStrokeWidth(2.0f);
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawText(str, f, f2, textPaint);
        textPaint.setStrokeWidth(strokeWidth);
        textPaint.setStyle(style);
        textPaint.setColor(color);
    }
}
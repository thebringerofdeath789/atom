package com.example.horizontalselectedviewlibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class HorizontalselectedView extends View {
    private int anInt;
    private float anOffset;
    private int centerTextHeight;
    private Context context;
    private float downX;
    private boolean firstVisible;
    private int height;

    /* renamed from: n */
    private int f1875n;
    private Rect rect;
    private int seeSize;
    private int selectedColor;
    private Paint selectedPaint;
    private float selectedTextSize;
    private List<String> strings;
    private int textColor;
    private int textHeight;
    private TextPaint textPaint;
    private float textSize;
    private int textWidth;
    private int width;

    public HorizontalselectedView(Context context) {
        this(context, null);
    }

    public HorizontalselectedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalselectedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.strings = new ArrayList();
        this.seeSize = 5;
        this.firstVisible = true;
        this.rect = new Rect();
        this.textWidth = 0;
        this.textHeight = 0;
        this.centerTextHeight = 0;
        this.context = context;
        setWillNotDraw(false);
        setClickable(true);
        initAttrs(attributeSet);
        initPaint();
    }

    private void initPaint() {
        TextPaint textPaint = new TextPaint(1);
        this.textPaint = textPaint;
        textPaint.setTextSize(this.textSize);
        this.textPaint.setColor(this.textColor);
        TextPaint textPaint2 = new TextPaint(1);
        this.selectedPaint = textPaint2;
        textPaint2.setColor(this.selectedColor);
        this.selectedPaint.setTextSize(this.selectedTextSize);
    }

    private void initAttrs(AttributeSet attributeSet) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, C0842R.styleable.HorizontalselectedView);
        this.seeSize = obtainStyledAttributes.getInteger(C0842R.styleable.HorizontalselectedView_HorizontalselectedViewSeesize, 5);
        this.selectedTextSize = obtainStyledAttributes.getFloat(C0842R.styleable.HorizontalselectedView_HorizontalselectedViewSelectedTextSize, 50.0f);
        this.selectedColor = obtainStyledAttributes.getColor(C0842R.styleable.HorizontalselectedView_HorizontalselectedViewSelectedTextColor, this.context.getResources().getColor(android.R.color.black));
        this.textSize = obtainStyledAttributes.getFloat(C0842R.styleable.HorizontalselectedView_HorizontalselectedViewTextSize, 40.0f);
        this.textColor = obtainStyledAttributes.getColor(C0842R.styleable.HorizontalselectedView_HorizontalselectedViewTextColor, this.context.getResources().getColor(android.R.color.darker_gray));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        Log.e("action", "onTouchEvent: " + motionEvent.getAction());
        int action = motionEvent.getAction();
        if (action == 0) {
            this.downX = motionEvent.getX();
        } else if (action == 1) {
            this.anOffset = 0.0f;
            invalidate();
        } else if (action == 2) {
            float x = motionEvent.getX();
            int i2 = this.f1875n;
            if (i2 != 0 && i2 != this.strings.size() - 1) {
                this.anOffset = x - this.downX;
            } else {
                this.anOffset = (float) ((x - this.downX) / 1.5d);
            }
            float f = this.downX;
            if (x > f) {
                if (x - f >= this.anInt && (i = this.f1875n) > 0) {
                    this.anOffset = 0.0f;
                    this.f1875n = i - 1;
                    this.downX = x;
                }
            } else if (f - x >= this.anInt && this.f1875n < this.strings.size() - 1) {
                this.anOffset = 0.0f;
                this.f1875n++;
                this.downX = x;
            }
            invalidate();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.firstVisible) {
            this.width = getWidth();
            this.height = getHeight();
            this.anInt = this.width / this.seeSize;
            this.firstVisible = false;
        }
        int i = this.f1875n;
        if (i < 0 || i > this.strings.size() - 1) {
            return;
        }
        String str = this.strings.get(this.f1875n);
        this.selectedPaint.getTextBounds(str, 0, str.length(), this.rect);
        int width = this.rect.width();
        this.centerTextHeight = this.rect.height();
        canvas.drawText(this.strings.get(this.f1875n), ((getWidth() / 2) - (width / 2)) + this.anOffset, (getHeight() / 2) + (this.centerTextHeight / 2), this.selectedPaint);
        for (int i2 = 0; i2 < this.strings.size(); i2++) {
            int i3 = this.f1875n;
            if (i3 > 0 && i3 < this.strings.size() - 1) {
                this.textPaint.getTextBounds(this.strings.get(this.f1875n - 1), 0, this.strings.get(this.f1875n - 1).length(), this.rect);
                int width2 = this.rect.width();
                this.textPaint.getTextBounds(this.strings.get(this.f1875n + 1), 0, this.strings.get(this.f1875n + 1).length(), this.rect);
                this.textWidth = (width2 + this.rect.width()) / 2;
            }
            if (i2 == 0) {
                this.textPaint.getTextBounds(this.strings.get(0), 0, this.strings.get(0).length(), this.rect);
                this.textHeight = this.rect.height();
            }
            if (i2 != this.f1875n) {
                canvas.drawText(this.strings.get(i2), ((((i2 - this.f1875n) * this.anInt) + (getWidth() / 2)) - (this.textWidth / 2)) + this.anOffset, (getHeight() / 2) + (this.textHeight / 2), this.textPaint);
            }
        }
    }

    public void setSeeSize(int i) {
        if (this.seeSize > 0) {
            this.seeSize = i;
            invalidate();
        }
    }

    public void setAnLeftOffset() {
        if (this.f1875n < this.strings.size() - 1) {
            this.f1875n++;
            invalidate();
        }
    }

    public void setAnRightOffset() {
        int i = this.f1875n;
        if (i > 0) {
            this.f1875n = i - 1;
            invalidate();
        }
    }

    public void setData(List<String> list) {
        this.strings = list;
        this.f1875n = list.size() / 2;
        invalidate();
    }

    public String getSelectedString() {
        if (this.strings.size() != 0) {
            return this.strings.get(this.f1875n);
        }
        return null;
    }
}
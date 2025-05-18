package com.ipotensic.baselib.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.ipotensic.baselib.C1819R;

/* loaded from: classes2.dex */
public class MyTextView extends AppCompatTextView {
    public static final int TEXT_TYPE_FOCUED = 2;
    public static final int TEXT_TYPE_NORMAL = 1;
    private String contentFocuedColor;
    private String contentNormalColor;
    private Paint contentPaint;
    private int currentTextType;
    private String ellipsis;
    private int line;
    private float lineSpace;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private String mText;
    private int maxLines;
    private float minHeight;
    private float minWidth;
    private int realLines;
    private boolean showEllipsise;
    private int signleLineHeight;
    private String textColor;
    private Paint.FontMetricsInt textFm;
    private int textSize;
    private int textWidth;
    private int viewHeight;
    private int viewWidth;

    public MyTextView(Context context) {
        this(context, null);
    }

    public MyTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.contentNormalColor = "#737373";
        this.contentFocuedColor = "#333333";
        this.viewWidth = 0;
        this.viewHeight = 0;
        this.currentTextType = 1;
        this.textColor = "#333333";
        this.textSize = 40;
        this.mText = "测试的文字信息";
        this.minHeight = 0.0f;
        this.minWidth = 0.0f;
        this.maxLines = 0;
        this.ellipsis = "...";
        initAttr(context, attributeSet);
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.contentPaint = paint;
        paint.setTextSize(this.textSize);
        this.contentPaint.setAntiAlias(true);
        this.contentPaint.setStrokeWidth(2.0f);
        this.contentPaint.setColor(Color.parseColor(this.textColor));
        this.contentPaint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetricsInt fontMetricsInt = this.contentPaint.getFontMetricsInt();
        this.textFm = fontMetricsInt;
        this.signleLineHeight = Math.abs(fontMetricsInt.top - this.textFm.bottom);
    }

    private void initAttr(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1819R.styleable.AutoWrapTextViewStyle);
        this.mPaddingLeft = obtainStyledAttributes.getDimensionPixelSize(C1819R.styleable.AutoWrapTextViewStyle_paddingLeft, 0);
        this.mPaddingRight = obtainStyledAttributes.getDimensionPixelSize(C1819R.styleable.AutoWrapTextViewStyle_paddingRight, 0);
        this.mPaddingTop = obtainStyledAttributes.getDimensionPixelSize(C1819R.styleable.AutoWrapTextViewStyle_paddingTop, 0);
        this.mPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(C1819R.styleable.AutoWrapTextViewStyle_paddingBottom, 0);
        this.mText = obtainStyledAttributes.getString(C1819R.styleable.AutoWrapTextViewStyle_text);
        String string = obtainStyledAttributes.getString(C1819R.styleable.AutoWrapTextViewStyle_textColor);
        this.textColor = string;
        if (string == null) {
            this.textColor = "#000000";
        }
        this.textSize = obtainStyledAttributes.getDimensionPixelSize(C1819R.styleable.AutoWrapTextViewStyle_textSize, 50);
        this.lineSpace = obtainStyledAttributes.getInteger(C1819R.styleable.AutoWrapTextViewStyle_lineSpacingExtra, 0);
        obtainStyledAttributes.recycle();
    }

    public void setText(String str) {
        this.mText = str;
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        this.viewWidth = measuredWidth;
        this.textWidth = (measuredWidth - this.mPaddingLeft) - this.mPaddingRight;
        int viewHeight = (int) getViewHeight();
        this.viewHeight = viewHeight;
        setMeasuredDimension(this.viewWidth, viewHeight);
    }

    private float getViewHeight() {
        char[] charArray = this.mText.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        float f = 0.0f;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            float measureText = this.contentPaint.measureText(charArray[i2] + "");
            f += measureText;
            if (f <= this.textWidth) {
                sb.append(charArray[i2]);
            } else {
                i++;
                sb = new StringBuilder();
                sb.append(charArray[i2]);
                f = measureText + 0.0f;
            }
        }
        if (sb.toString().length() != 0) {
            i++;
        }
        return (this.signleLineHeight * i) + (this.lineSpace * (i - 1)) + this.mPaddingBottom + this.mPaddingTop;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        drawText(canvas);
    }

    private void drawText(Canvas canvas) {
        char[] charArray = this.mText.toCharArray();
        float f = this.mPaddingLeft + 0.0f;
        float f2 = (((this.mPaddingTop + (this.signleLineHeight / 2)) + ((this.textFm.bottom - this.textFm.top) / 2)) - this.textFm.bottom) + 0.0f;
        StringBuilder sb = new StringBuilder();
        float f3 = 0.0f;
        for (int i = 0; i < charArray.length; i++) {
            float measureText = this.contentPaint.measureText(charArray[i] + "");
            f3 += measureText;
            if (f3 <= this.textWidth) {
                sb.append(charArray[i]);
            } else {
                canvas.drawText(sb.toString(), f, f2, this.contentPaint);
                f2 += this.signleLineHeight + this.lineSpace;
                sb = new StringBuilder();
                sb.append(charArray[i]);
                f3 = measureText + 0.0f;
            }
        }
        if (sb.toString().length() > 0) {
            canvas.drawText(sb.toString(), f, f2, this.contentPaint);
        }
    }
}
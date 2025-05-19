package com.ipotensic.baselib.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.ipotensic.baselib.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class AutoWrapTextView extends View {
    private int mLineSpacingExtra;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private int mSingleTextWidth;
    private List<String> mSplitTextList;
    private Rect[] mSplitTextRectArray;
    private String mText;
    private char[] mTextCharArray;
    private int mTextColor;
    private TextPaint mTextPaint;
    private int mTextSize;

    public AutoWrapTextView(Context context) {
        super(context);
        this.mSplitTextRectArray = null;
    }

    public AutoWrapTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSplitTextRectArray = null;
        init(context, attributeSet);
    }

    public AutoWrapTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSplitTextRectArray = null;
        init(context, attributeSet);
    }

    public AutoWrapTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mSplitTextRectArray = null;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        initStyle(context, attributeSet);
        initPaint();
        setText(this.mText);
    }

    private void initStyle(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AutoWrapTextViewStyle);
        this.mPaddingLeft = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AutoWrapTextViewStyle_paddingLeft, 0);
        this.mPaddingRight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AutoWrapTextViewStyle_paddingRight, 0);
        this.mPaddingTop = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AutoWrapTextViewStyle_paddingTop, 0);
        this.mPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AutoWrapTextViewStyle_paddingBottom, 0);
        this.mText = obtainStyledAttributes.getString(R.styleable.AutoWrapTextViewStyle_text);
        this.mTextColor = obtainStyledAttributes.getColor(R.styleable.AutoWrapTextViewStyle_textColor, ViewCompat.MEASURED_STATE_MASK);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AutoWrapTextViewStyle_textSize, 50);
        this.mLineSpacingExtra = obtainStyledAttributes.getInteger(R.styleable.AutoWrapTextViewStyle_lineSpacingExtra, 15);
        obtainStyledAttributes.recycle();
    }

    private void initPaint() {
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setAntiAlias(true);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setColor(this.mTextColor);
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mTextCharArray = str.toCharArray();
        requestLayout();
    }

    private void splitText(int i) {
        if (this.mTextCharArray == null) {
            return;
        }
        this.mSplitTextList = new ArrayList();
        this.mSingleTextWidth = (getMeasuredWidth() - this.mPaddingLeft) - this.mPaddingRight;
        StringBuffer stringBuffer = new StringBuffer();
        int length = this.mTextCharArray.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char c = this.mTextCharArray[i2];
            i3 = (int) (i3 + getSingleCharWidth(c));
            if (stringBuffer.toString().contains("\n") || i3 > this.mSingleTextWidth) {
                this.mSplitTextList.add(stringBuffer.toString());
                stringBuffer = new StringBuffer();
                i2--;
                i3 = 0;
            } else {
                stringBuffer.append(c);
                if (i2 == length - 1) {
                    this.mSplitTextList.add(stringBuffer.toString());
                }
            }
            i2++;
        }
        this.mSplitTextRectArray = new Rect[this.mSplitTextList.size()];
        int size = this.mSplitTextList.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            String str = this.mSplitTextList.get(i5);
            Rect rect = new Rect();
            this.mTextPaint.getTextBounds(str, 0, str.length(), rect);
            if (i == Integer.MIN_VALUE) {
                i4 += rect.height() + this.mLineSpacingExtra;
                if (i5 == size - 1) {
                    i4 = i4 + this.mPaddingBottom + this.mPaddingTop;
                }
            } else if (i4 == 0) {
                i4 = getMeasuredHeight();
            }
            this.mSplitTextRectArray[i5] = rect;
        }
        setMeasuredDimension(getMeasuredWidth(), i4);
    }

    public float getSingleCharWidth(char c) {
        float[] fArr = new float[1];
        this.mTextPaint.getTextWidths(new char[]{c}, 0, 1, fArr);
        return fArr[0];
    }

    public float getStringWidth(String str) {
        int length = str.length();
        float[] fArr = new float[length];
        int textWidths = this.mTextPaint.getTextWidths(str, 0, length, fArr);
        float f = 0.0f;
        for (int i = 0; i < textWidths; i++) {
            f += fArr[i];
        }
        return f;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        splitText(View.MeasureSpec.getMode(i2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawText(canvas);
    }

    public void drawText(Canvas canvas) {
        List<String> list = this.mSplitTextList;
        if (list == null || list.size() == 0) {
            return;
        }
        int topTextMarginTop = getTopTextMarginTop();
        if (this.mSplitTextList.size() == 1) {
            String str = this.mSplitTextList.get(0);
            float stringWidth = getStringWidth(str);
            float measuredWidth = (getMeasuredWidth() - stringWidth) / 2.0f;
            int i = this.mPaddingLeft;
            canvas.drawText(str, measuredWidth > ((float) i) ? (getMeasuredWidth() - stringWidth) / 2.0f : i, topTextMarginTop, this.mTextPaint);
            this.mSplitTextRectArray[0].height();
            return;
        }
        int size = this.mSplitTextList.size();
        for (int i2 = 0; i2 < size; i2++) {
            canvas.drawText(this.mSplitTextList.get(i2), this.mPaddingLeft, topTextMarginTop, this.mTextPaint);
            topTextMarginTop += this.mSplitTextRectArray[i2].height() + this.mLineSpacingExtra;
        }
    }

    private int getTopTextMarginTop() {
        return (this.mSplitTextRectArray[0].height() / 2) + this.mPaddingTop + getFontSpace();
    }

    private int getFontSpace() {
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        return ((fontMetricsInt.descent - fontMetricsInt.ascent) / 2) - fontMetricsInt.descent;
    }
}

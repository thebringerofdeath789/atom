package com.ipotensic.baselib.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.ipotensic.baselib.R;

/* loaded from: classes2.dex */
public class ExcelLayout extends ViewGroup {
    static final String TAG = "ExcelLayout";
    int borderColor;
    Paint borderPaint;
    float maxItemSizeX;
    int maxItemSizeY;
    int maxSpanCountX;
    int maxSpanCountY;

    public ExcelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.maxSpanCountX = 0;
        this.maxSpanCountY = 0;
        this.maxItemSizeX = 0.0f;
        this.maxItemSizeY = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExcelLayout);
        this.borderColor = obtainStyledAttributes.getColor(R.styleable.ExcelLayout_ELBorderColor, ViewCompat.MEASURED_STATE_MASK);
        obtainStyledAttributes.recycle();
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.borderPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.borderPaint.setColor(this.borderColor);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int childCount = getChildCount();
        int childMeasureSpec = getChildMeasureSpec(0, 0, -2);
        int childMeasureSpec2 = getChildMeasureSpec(0, 0, -2);
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (i3 == 0) {
                measureChild(childAt, childMeasureSpec, childMeasureSpec2);
                this.maxItemSizeY = Math.max(this.maxItemSizeY, childAt.getMeasuredHeight());
            }
            ExcelLayoutParam excelLayoutParam = (ExcelLayoutParam) childAt.getLayoutParams();
            this.maxSpanCountX = Math.max(this.maxSpanCountX, excelLayoutParam.startX + excelLayoutParam.spanX);
            this.maxSpanCountY = Math.max(this.maxSpanCountY, excelLayoutParam.startY + excelLayoutParam.spanY);
        }
        int i4 = this.maxSpanCountY * this.maxItemSizeY;
        if (mode == 1073741824) {
            this.maxItemSizeX = (size * 1.0f) / this.maxSpanCountX;
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt2 = getChildAt(i5);
            measureChild(childAt2, getChildMeasureSpec(1073741824, 0, Math.round(r8.spanX * this.maxItemSizeX)), getChildMeasureSpec(1073741824, 0, ((ExcelLayoutParam) childAt2.getLayoutParams()).spanY * this.maxItemSizeY));
        }
        if (mode != 1073741824) {
            size = 0;
        }
        if (mode2 != 1073741824) {
            size2 = i4;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            ExcelLayoutParam excelLayoutParam = (ExcelLayoutParam) childAt.getLayoutParams();
            childAt.layout(Math.round(excelLayoutParam.startX * this.maxItemSizeX), excelLayoutParam.startY * this.maxItemSizeY, Math.round((excelLayoutParam.startX + excelLayoutParam.spanX) * this.maxItemSizeX), (excelLayoutParam.startY + excelLayoutParam.spanY) * this.maxItemSizeY);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.borderPaint.setStrokeWidth(2.0f);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ExcelLayoutParam excelLayoutParam = (ExcelLayoutParam) getChildAt(i).getLayoutParams();
            if (excelLayoutParam.startX == 0) {
                canvas.drawLine((excelLayoutParam.startX * this.maxItemSizeX) + 2.0f, excelLayoutParam.startY * this.maxItemSizeY, ((excelLayoutParam.startX + excelLayoutParam.spanX) * this.maxItemSizeX) + 2.0f, excelLayoutParam.startY * this.maxItemSizeY, this.borderPaint);
            } else {
                canvas.drawLine(excelLayoutParam.startX * this.maxItemSizeX, excelLayoutParam.startY * this.maxItemSizeY, (excelLayoutParam.startX + excelLayoutParam.spanX) * this.maxItemSizeX, excelLayoutParam.startY * this.maxItemSizeY, this.borderPaint);
            }
            if (excelLayoutParam.startX + excelLayoutParam.spanX >= this.maxSpanCountX) {
                canvas.drawLine(((excelLayoutParam.startX + excelLayoutParam.spanX) * this.maxItemSizeX) - 2.0f, excelLayoutParam.startY * this.maxItemSizeY, ((excelLayoutParam.startX + excelLayoutParam.spanX) * this.maxItemSizeX) - 2.0f, (excelLayoutParam.startY + excelLayoutParam.spanY) * this.maxItemSizeY, this.borderPaint);
            } else {
                canvas.drawLine((excelLayoutParam.startX + excelLayoutParam.spanX) * this.maxItemSizeX, excelLayoutParam.startY * this.maxItemSizeY, (excelLayoutParam.startX + excelLayoutParam.spanX) * this.maxItemSizeX, (excelLayoutParam.startY + excelLayoutParam.spanY) * this.maxItemSizeY, this.borderPaint);
            }
            if (excelLayoutParam.startY + excelLayoutParam.spanY >= this.maxSpanCountY) {
                canvas.drawLine((excelLayoutParam.startX + excelLayoutParam.spanX) * this.maxItemSizeX, ((excelLayoutParam.startY + excelLayoutParam.spanY) * this.maxItemSizeY) - 2.0f, excelLayoutParam.startX * this.maxItemSizeX, ((excelLayoutParam.startY + excelLayoutParam.spanY) * this.maxItemSizeY) - 2.0f, this.borderPaint);
            } else {
                canvas.drawLine((excelLayoutParam.startX + excelLayoutParam.spanX) * this.maxItemSizeX, (excelLayoutParam.startY + excelLayoutParam.spanY) * this.maxItemSizeY, excelLayoutParam.startX * this.maxItemSizeX, (excelLayoutParam.startY + excelLayoutParam.spanY) * this.maxItemSizeY, this.borderPaint);
            }
            canvas.drawLine(excelLayoutParam.startX * this.maxItemSizeX, (excelLayoutParam.startY + excelLayoutParam.spanY) * this.maxItemSizeY, excelLayoutParam.startX * this.maxItemSizeX, excelLayoutParam.startY * this.maxItemSizeY, this.borderPaint);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ExcelLayoutParam(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ExcelLayoutParam(getContext(), attributeSet);
    }

    public class ExcelLayoutParam extends ViewGroup.LayoutParams {
        int spanX;
        int spanY;
        int startX;
        int startY;

        public ExcelLayoutParam(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.startX = 0;
            this.startY = 0;
            this.spanX = 0;
            this.spanY = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExcelLayout);
            this.startX = obtainStyledAttributes.getInt(R.styleable.ExcelLayout_ELStartX, 0);
            this.startY = obtainStyledAttributes.getInt(R.styleable.ExcelLayout_ELStartY, 0);
            this.spanX = obtainStyledAttributes.getInt(R.styleable.ExcelLayout_ELSpanX, 1);
            this.spanY = obtainStyledAttributes.getInt(R.styleable.ExcelLayout_ELSpanY, 1);
            obtainStyledAttributes.recycle();
        }

        public ExcelLayoutParam(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.startX = 0;
            this.startY = 0;
            this.spanX = 0;
            this.spanY = 0;
            if (layoutParams instanceof ExcelLayoutParam) {
                ExcelLayoutParam excelLayoutParam = (ExcelLayoutParam) layoutParams;
                this.startX = excelLayoutParam.startX;
                this.startY = excelLayoutParam.startY;
                this.spanX = excelLayoutParam.spanX;
                this.spanY = excelLayoutParam.spanY;
            }
        }
    }
}
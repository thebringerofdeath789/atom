package com.ipotensic.kernel.view;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public class ArrowRectangleView extends ViewGroup {
    private int mArrowHeight;
    private int mArrowOffset;
    private int mArrowWidth;
    private int mBackgroundColor;
    private int mRadius;
    private int mShadowColor;
    private int mShadowThickness;

    public ArrowRectangleView(Context context) {
        this(context, null);
    }

    public ArrowRectangleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArrowRectangleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        context.getTheme().obtainStyledAttributes(attributeSet, C1965R.styleable.ArrowRectangleView, i, 0).recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        int i3 = this.mArrowHeight + this.mRadius;
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                i4 = Math.max(i4, childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                i3 = i3 + childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            }
        }
        setMeasuredDimension(i4 + getPaddingLeft() + getPaddingRight() + this.mShadowThickness, i3 + getPaddingTop() + getPaddingBottom() + this.mShadowThickness);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i2 + this.mArrowHeight + (this.mRadius / 2);
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            int measuredHeight = (childAt.getMeasuredHeight() * i6) + i5;
            childAt.layout(i, measuredHeight, (i3 - (this.mRadius / 2)) - this.mShadowThickness, childAt.getMeasuredHeight() + measuredHeight);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        setLayerType(1, null);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.mBackgroundColor);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint.setColor(this.mBackgroundColor);
        RectF rectF = new RectF(0.0f, this.mArrowHeight, getMeasuredWidth() - this.mShadowThickness, getMeasuredHeight() - this.mShadowThickness);
        int i = this.mRadius;
        canvas.drawRoundRect(rectF, i, i, paint);
        Path path = new Path();
        path.moveTo(getMeasuredWidth() - this.mArrowOffset, this.mArrowHeight);
        path.lineTo(this.mArrowWidth + r2, this.mArrowHeight);
        path.lineTo(r2 + (this.mArrowWidth / 2), 0.0f);
        path.close();
        canvas.drawPath(path, paint);
        if (this.mShadowThickness > 0) {
            paint.setMaskFilter(new BlurMaskFilter(this.mShadowThickness, BlurMaskFilter.Blur.OUTER));
            paint.setColor(this.mShadowColor);
            RectF rectF2 = new RectF(this.mShadowThickness, this.mArrowHeight + r2, getMeasuredWidth() - this.mShadowThickness, getMeasuredHeight() - this.mShadowThickness);
            int i2 = this.mRadius;
            canvas.drawRoundRect(rectF2, i2, i2, paint);
        }
        super.dispatchDraw(canvas);
    }
}
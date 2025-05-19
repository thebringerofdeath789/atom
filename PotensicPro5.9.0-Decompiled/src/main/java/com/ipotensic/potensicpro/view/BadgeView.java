package com.ipotensic.potensicpro.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.internal.view.SupportMenu;

/* loaded from: classes2.dex */
public class BadgeView extends View {
    public static final int SHAPE_CIRCLE = 1;
    public static final int SHAPE_OVAL = 3;
    public static final int SHAPE_RECTANGLE = 2;
    public static final int SHAPE_SQUARE = 5;
    public static final int SHAPTE_ROUND_RECTANGLE = 4;
    private Paint backgroundPaint;
    private int badgeGravity;
    private int bottomMargin;
    private int currentShape;
    private int defaultBackgroundColor;
    private int defaultTextColor;
    private int defaultTextSize;
    private boolean hasBind;
    private int horiontalSpace;
    private int leftMargin;
    private Paint numberPaint;
    private int rightMargin;
    private String showText;
    private int topMargin;
    private int verticalSpace;

    public BadgeView(Context context) {
        super(context);
        this.currentShape = 1;
        this.defaultTextColor = -1;
        this.defaultBackgroundColor = SupportMenu.CATEGORY_MASK;
        this.showText = "";
        this.badgeGravity = 53;
        this.leftMargin = 0;
        this.topMargin = 0;
        this.bottomMargin = 0;
        this.rightMargin = 0;
        this.hasBind = false;
        this.horiontalSpace = 0;
        this.verticalSpace = 0;
        init(context);
    }

    public BadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentShape = 1;
        this.defaultTextColor = -1;
        this.defaultBackgroundColor = SupportMenu.CATEGORY_MASK;
        this.showText = "";
        this.badgeGravity = 53;
        this.leftMargin = 0;
        this.topMargin = 0;
        this.bottomMargin = 0;
        this.rightMargin = 0;
        this.hasBind = false;
        this.horiontalSpace = 0;
        this.verticalSpace = 0;
        init(context);
    }

    public BadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentShape = 1;
        this.defaultTextColor = -1;
        this.defaultBackgroundColor = SupportMenu.CATEGORY_MASK;
        this.showText = "";
        this.badgeGravity = 53;
        this.leftMargin = 0;
        this.topMargin = 0;
        this.bottomMargin = 0;
        this.rightMargin = 0;
        this.hasBind = false;
        this.horiontalSpace = 0;
        this.verticalSpace = 0;
        init(context);
    }

    public BadgeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.currentShape = 1;
        this.defaultTextColor = -1;
        this.defaultBackgroundColor = SupportMenu.CATEGORY_MASK;
        this.showText = "";
        this.badgeGravity = 53;
        this.leftMargin = 0;
        this.topMargin = 0;
        this.bottomMargin = 0;
        this.rightMargin = 0;
        this.hasBind = false;
        this.horiontalSpace = 0;
        this.verticalSpace = 0;
        init(context);
    }

    private void init(Context context) {
        this.defaultTextSize = dip2px(context, 1);
        Paint paint = new Paint(1);
        this.numberPaint = paint;
        paint.setColor(this.defaultTextColor);
        this.numberPaint.setStyle(Paint.Style.FILL);
        this.numberPaint.setTextSize(this.defaultTextSize);
        this.numberPaint.setTextAlign(Paint.Align.CENTER);
        Paint paint2 = new Paint(1);
        this.backgroundPaint = paint2;
        paint2.setColor(this.defaultBackgroundColor);
        this.backgroundPaint.setStyle(Paint.Style.FILL);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = this.badgeGravity;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        Paint.FontMetrics fontMetrics = this.numberPaint.getFontMetrics();
        float f = fontMetrics.descent - fontMetrics.ascent;
        int i = this.currentShape;
        if (i == 1) {
            canvas.drawCircle(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, getMeasuredWidth() / 2, this.backgroundPaint);
            canvas.drawText(this.showText, getMeasuredWidth() / 2.0f, (getMeasuredHeight() / 2.0f) + ((f / 2.0f) - fontMetrics.descent), this.numberPaint);
            return;
        }
        if (i == 2) {
            canvas.drawRect(rectF, this.backgroundPaint);
            canvas.drawText(this.showText, getMeasuredWidth() / 2.0f, (getMeasuredHeight() / 2.0f) + ((f / 2.0f) - fontMetrics.descent), this.numberPaint);
            return;
        }
        if (i == 3) {
            canvas.drawOval(rectF, this.backgroundPaint);
            canvas.drawText(this.showText, getMeasuredWidth() / 2.0f, (getMeasuredHeight() / 2.0f) + ((f / 2.0f) - fontMetrics.descent), this.numberPaint);
        } else if (i == 4) {
            canvas.drawRoundRect(rectF, dip2px(getContext(), 5), dip2px(getContext(), 5), this.backgroundPaint);
            canvas.drawText(this.showText, getMeasuredWidth() / 2.0f, (getMeasuredHeight() / 2.0f) + ((f / 2.0f) - fontMetrics.descent), this.numberPaint);
        } else {
            if (i != 5) {
                return;
            }
            float min = Math.min(getMeasuredHeight(), getMeasuredWidth());
            canvas.drawRect(new RectF(0.0f, 0.0f, min, min), this.backgroundPaint);
            float f2 = min / 2.0f;
            canvas.drawText(this.showText, f2, ((f / 2.0f) - fontMetrics.descent) + f2, this.numberPaint);
        }
    }

    private int dip2px(Context context, int i) {
        return (int) ((i * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int sp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public BadgeView setShape(int i) {
        this.currentShape = i;
        invalidate();
        return this;
    }

    public BadgeView setWidthAndHeight(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.width = dip2px(getContext(), i);
        layoutParams.height = dip2px(getContext(), i2);
        setLayoutParams(layoutParams);
        return this;
    }

    public BadgeView setWidth(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.width = dip2px(getContext(), i);
        setLayoutParams(layoutParams);
        return this;
    }

    public BadgeView setHeight(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.height = dip2px(getContext(), i);
        setLayoutParams(layoutParams);
        return this;
    }

    @Deprecated
    public BadgeView setMargin(int i, int i2, int i3, int i4) {
        this.leftMargin = dip2px(getContext(), i);
        this.bottomMargin = dip2px(getContext(), i4);
        this.topMargin = dip2px(getContext(), i2);
        this.rightMargin = dip2px(getContext(), i3);
        invalidate();
        return this;
    }

    public BadgeView setSpace(int i, int i2) {
        this.horiontalSpace = dip2px(getContext(), i);
        this.verticalSpace = dip2px(getContext(), i2);
        invalidate();
        return this;
    }

    public BadgeView setTextSize(int i) {
        this.defaultTextSize = sp2px(getContext(), i);
        this.numberPaint.setTextSize(sp2px(getContext(), r3));
        invalidate();
        return this;
    }

    public BadgeView setTextColor(int i) {
        this.defaultTextColor = i;
        this.numberPaint.setColor(i);
        invalidate();
        return this;
    }

    public BadgeView setBadgeBackground(int i) {
        this.defaultBackgroundColor = i;
        this.backgroundPaint.setColor(i);
        invalidate();
        return this;
    }

    public BadgeView setBadgeCount(int i) {
        this.showText = String.valueOf(i);
        invalidate();
        return this;
    }

    public BadgeView setBadgeCount(String str) {
        this.showText = str;
        invalidate();
        return this;
    }

    public BadgeView setBadgeGravity(int i) {
        this.badgeGravity = i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.gravity = i;
        setLayoutParams(layoutParams);
        return this;
    }

    public BadgeView bind(View view) {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (view == null) {
            return this;
        }
        if ((view.getParent() instanceof FrameLayout) && this.hasBind) {
            ((FrameLayout) view.getParent()).addView(this);
            return this;
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int indexOfChild = ((ViewGroup) view.getParent()).indexOfChild(view);
            ((ViewGroup) view.getParent()).removeView(view);
            FrameLayout frameLayout = new FrameLayout(getContext());
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int i = layoutParams.height;
            int i2 = layoutParams.width;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i);
            if (i == -2) {
                layoutParams.height = -2;
                layoutParams2.topMargin = this.topMargin;
                layoutParams2.bottomMargin = this.bottomMargin;
            } else {
                layoutParams.height = i + this.topMargin + this.bottomMargin + this.verticalSpace;
            }
            if (i2 == -2) {
                layoutParams.width = -2;
                layoutParams2.leftMargin = this.leftMargin;
                layoutParams2.rightMargin = this.rightMargin;
            } else {
                layoutParams.width = i2 + this.rightMargin + this.horiontalSpace + this.leftMargin;
            }
            frameLayout.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) getLayoutParams();
            if (layoutParams3.gravity == 53 || layoutParams3.gravity == 5 || layoutParams3.gravity == 48) {
                view.setPadding(0, this.verticalSpace, this.horiontalSpace, 0);
                layoutParams2.gravity = 83;
            } else if (layoutParams3.gravity == 51 || layoutParams3.gravity == 3 || layoutParams3.gravity == 48) {
                view.setPadding(this.horiontalSpace, this.verticalSpace, 0, 0);
                layoutParams2.gravity = 85;
            } else if (layoutParams3.gravity == 83) {
                view.setPadding(this.horiontalSpace, 0, 0, this.verticalSpace);
                layoutParams2.gravity = 53;
            } else if (layoutParams3.gravity == 85) {
                view.setPadding(0, 0, this.horiontalSpace, this.verticalSpace);
                layoutParams2.gravity = 51;
            } else {
                view.setPadding(0, this.verticalSpace, this.horiontalSpace, 0);
                layoutParams2.gravity = 83;
            }
            view.setLayoutParams(layoutParams2);
            frameLayout.setId(view.getId());
            frameLayout.addView(view);
            frameLayout.addView(this);
            viewGroup.addView(frameLayout, indexOfChild);
            this.hasBind = true;
        } else if (view.getParent() == null) {
            Log.e("badgeview", "View must have a parent");
        }
        return this;
    }

    public boolean unbind() {
        if (getParent() == null) {
            return false;
        }
        ((ViewGroup) getParent()).removeView(this);
        return true;
    }

    public String getBadgeCount() {
        return this.showText;
    }
}

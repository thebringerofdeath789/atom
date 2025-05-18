package com.ipotensic.baselib.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: classes2.dex */
public class RoundRelativeLayout extends RelativeLayout {
    public static final int MODE_ALL = 1;
    public static final int MODE_BOTTOM = 5;
    public static final int MODE_LEFT = 2;
    public static final int MODE_NONE = 0;
    public static final int MODE_RIGHT = 4;
    public static final int MODE_TOP = 3;
    private int mHeight;
    private int mLastRadius;
    private Path mPath;
    private int mRadius;
    private int mRoundMode;
    private int mWidth;

    public RoundRelativeLayout(Context context) {
        super(context);
        this.mRoundMode = 1;
        init();
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRoundMode = 1;
        init();
    }

    private void init() {
        setBackground(new ColorDrawable(0));
        Path path = new Path();
        this.mPath = path;
        path.setFillType(Path.FillType.EVEN_ODD);
        setCornerRadius(30);
    }

    public void setRoundMode(int i) {
        this.mRoundMode = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    private void checkPathChanged() {
        if (getWidth() == this.mWidth && getHeight() == this.mHeight && this.mLastRadius == this.mRadius) {
            return;
        }
        this.mWidth = getWidth();
        this.mHeight = getHeight();
        this.mLastRadius = this.mRadius;
        this.mPath.reset();
        int i = this.mRoundMode;
        if (i == 1) {
            Path path = this.mPath;
            RectF rectF = new RectF(0.0f, 0.0f, this.mWidth, this.mHeight);
            int i2 = this.mRadius;
            path.addRoundRect(rectF, i2, i2, Path.Direction.CW);
            return;
        }
        if (i == 2) {
            Path path2 = this.mPath;
            RectF rectF2 = new RectF(0.0f, 0.0f, this.mWidth, this.mHeight);
            int i3 = this.mRadius;
            path2.addRoundRect(rectF2, new float[]{i3, i3, 0.0f, 0.0f, 0.0f, 0.0f, i3, i3}, Path.Direction.CW);
            return;
        }
        if (i == 3) {
            Path path3 = this.mPath;
            RectF rectF3 = new RectF(0.0f, 0.0f, this.mWidth, this.mHeight);
            int i4 = this.mRadius;
            path3.addRoundRect(rectF3, new float[]{i4, i4, i4, i4, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
            return;
        }
        if (i == 4) {
            Path path4 = this.mPath;
            RectF rectF4 = new RectF(0.0f, 0.0f, this.mWidth, this.mHeight);
            int i5 = this.mRadius;
            path4.addRoundRect(rectF4, new float[]{0.0f, 0.0f, i5, i5, i5, i5, 0.0f, 0.0f}, Path.Direction.CW);
            return;
        }
        if (i != 5) {
            return;
        }
        Path path5 = this.mPath;
        RectF rectF5 = new RectF(0.0f, 0.0f, this.mWidth, this.mHeight);
        int i6 = this.mRadius;
        path5.addRoundRect(rectF5, new float[]{0.0f, 0.0f, 0.0f, 0.0f, i6, i6, i6, i6}, Path.Direction.CW);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.mRoundMode != 0) {
            int save = canvas.save();
            checkPathChanged();
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.mPath);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }
}
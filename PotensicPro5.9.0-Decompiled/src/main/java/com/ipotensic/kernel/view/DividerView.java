package com.ipotensic.kernel.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class DividerView extends View {
    private final int ORIENTATION_HORIZONTAL;
    private final int ORIENTATION_VERTICAL;
    private int color;
    private int dashGap;
    private int dashLength;
    private int dashThickness;
    private int endColor;
    private Paint mPaint;
    private int orientation;
    private int startColor;

    public DividerView(Context context) {
        this(context, null);
    }

    public DividerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ORIENTATION_HORIZONTAL = 0;
        this.ORIENTATION_VERTICAL = 1;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.DividerView, 0, 0);
        try {
            this.dashGap = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DividerView_dashGap, 5);
            this.dashLength = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DividerView_dashLength, 5);
            this.dashThickness = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DividerView_dashThickness, 3);
            this.color = obtainStyledAttributes.getColor(R.styleable.DividerView_divider_line_color, ViewCompat.MEASURED_STATE_MASK);
            this.orientation = obtainStyledAttributes.getInt(R.styleable.DividerView_divider_orientation, 1);
            obtainStyledAttributes.recycle();
            this.startColor = getResources().getColor(R.color.color_divider_start);
            this.endColor = getResources().getColor(R.color.color_divider_end);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mPaint == null) {
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setColor(this.color);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.dashThickness);
            this.mPaint.setShader(new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), this.startColor, this.endColor, Shader.TileMode.MIRROR));
            this.mPaint.setPathEffect(new DashPathEffect(new float[]{this.dashGap, this.dashLength}, 0.0f));
        }
        if (this.orientation == 0) {
            float height = getHeight() * 0.5f;
            canvas.drawLine(0.0f, height, getWidth(), height, this.mPaint);
        } else {
            float width = getWidth() * 0.5f;
            canvas.drawLine(width, 0.0f, width, getHeight(), this.mPaint);
        }
    }
}

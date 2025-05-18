package com.ipotensic.kernel.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class BatteryCircleProgressView extends View {
    private Paint bacPaint;
    private int bgColor;
    private int circleColor;
    private float circleWidth;
    private int curProgressColor;
    private int fontColor;
    private Paint fontPaint;
    private Paint forPaint;
    private Paint linePaint;
    private Bitmap mBitmap;
    private int percent;

    public BatteryCircleProgressView(Context context) {
        this(context, null);
    }

    public BatteryCircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BatteryCircleProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.percent = 0;
        init(context);
    }

    private void init(Context context) {
        this.circleColor = ContextCompat.getColor(context, R.color.color_battery_line);
        this.bgColor = ContextCompat.getColor(context, R.color.color_battery_bg);
        this.curProgressColor = ContextCompat.getColor(context, R.color.color_battery_for);
        this.fontColor = ContextCompat.getColor(context, R.color.colorWhite);
        this.circleWidth = UnitUtil.dip2px(10.0f);
        this.mBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.icon_power_dis);
        this.forPaint = new Paint();
        this.bacPaint = new Paint();
        this.linePaint = new Paint();
        this.fontPaint = new Paint();
        this.linePaint.setAntiAlias(true);
        this.linePaint.setStyle(Paint.Style.STROKE);
        this.linePaint.setColor(this.circleColor);
        this.linePaint.setStrokeWidth(this.circleWidth);
        this.bacPaint.setAntiAlias(true);
        this.bacPaint.setStyle(Paint.Style.FILL);
        this.bacPaint.setColor(this.bgColor);
        this.forPaint.setAntiAlias(true);
        this.forPaint.setStyle(Paint.Style.STROKE);
        this.forPaint.setStrokeCap(Paint.Cap.ROUND);
        this.forPaint.setStrokeWidth(this.circleWidth);
        this.forPaint.setColor(this.curProgressColor);
        this.fontPaint.setAntiAlias(true);
        this.fontPaint.setColor(this.fontColor);
        this.fontPaint.setStyle(Paint.Style.FILL);
        this.fontPaint.setTextSize(getResources().getDimension(R.dimen.sp_30));
        this.fontPaint.setTextAlign(Paint.Align.CENTER);
        this.fontPaint.setTypeface(PhoneConfig.typeface);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.percent > 0) {
            drawBackGround(canvas);
            drawPercent(canvas);
            drawBatteryText(canvas);
            return;
        }
        drawNABitmap(canvas);
    }

    private void drawBackGround(Canvas canvas) {
        float width = getWidth() / 2.0f;
        canvas.drawCircle(width, width, width, this.bacPaint);
    }

    private void drawPercent(Canvas canvas) {
        int width = getWidth();
        float f = this.circleWidth * 1.5f;
        float f2 = width - f;
        RectF rectF = new RectF(f, f, f2, f2);
        canvas.drawArc(rectF, -90.0f, (100 - this.percent) * 3.6f, false, this.linePaint);
        canvas.drawArc(rectF, -90.0f, (-this.percent) * 3.6f, false, this.forPaint);
    }

    private void drawBatteryText(Canvas canvas) {
        int width = getWidth();
        if (this.percent > 0) {
            Paint.FontMetrics fontMetrics = this.fontPaint.getFontMetrics();
            float f = width / 2.0f;
            canvas.drawText(this.percent + "%", f, (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom) + f, this.fontPaint);
        }
    }

    private void drawNABitmap(Canvas canvas) {
        canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, this.forPaint);
    }

    public void setProgress(int i) {
        if (i != this.percent) {
            this.percent = i;
            if (i <= 20) {
                this.bacPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_battery_warn_bg));
                this.forPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_battery_warn_for));
                this.linePaint.setColor(ContextCompat.getColor(getContext(), R.color.color_battery_warn_line));
                this.fontPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_battery_warn_for));
            } else {
                this.bacPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_battery_bg));
                this.forPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_battery_for));
                this.linePaint.setColor(ContextCompat.getColor(getContext(), R.color.color_battery_line));
                this.fontPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
            }
            invalidate();
        }
    }
}
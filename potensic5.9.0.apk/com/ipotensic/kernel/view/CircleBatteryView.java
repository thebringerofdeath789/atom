package com.ipotensic.kernel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public class CircleBatteryView extends View {
    private Paint fillPaint;
    private int height;
    private boolean isInit;
    private Paint progressPaint;
    private RectF progressRect;
    private Paint rectPaint;
    private int remainBattery;
    private Paint txtPaint;
    private int width;

    public CircleBatteryView(Context context) {
        super(context);
        this.remainBattery = -1;
        this.isInit = false;
    }

    public CircleBatteryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.remainBattery = -1;
        this.isInit = false;
    }

    public CircleBatteryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.remainBattery = -1;
        this.isInit = false;
    }

    private void init() {
        Paint paint = new Paint();
        this.fillPaint = paint;
        paint.setStrokeWidth(100.0f);
        this.fillPaint.setColor(getContext().getResources().getColor(C1965R.color.dialog_bg));
        Paint paint2 = new Paint();
        this.progressPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.progressPaint.setAntiAlias(true);
        this.progressPaint.setStrokeWidth(this.width * 0.065f);
        this.progressPaint.setStrokeCap(Paint.Cap.ROUND);
        this.progressPaint.setColor(SupportMenu.CATEGORY_MASK);
        Paint paint3 = new Paint(1);
        this.txtPaint = paint3;
        paint3.setColor(getContext().getResources().getColor(C1965R.color.white));
        this.txtPaint.setTextSize(this.width * 0.312f);
        this.txtPaint.setAntiAlias(true);
        this.txtPaint.setTypeface(PhoneConfig.typeface);
        Paint paint4 = new Paint();
        this.rectPaint = paint4;
        paint4.setColor(-1);
        this.rectPaint.setStyle(Paint.Style.FILL);
        this.rectPaint.setAntiAlias(true);
        RectF rectF = new RectF();
        this.progressRect = rectF;
        int i = this.width;
        float f = i * 0.078f;
        int i2 = this.height;
        rectF.set(0.0f + f, ((i2 / 2) - (i / 2)) + f, i - f, ((i2 / 2) + (i / 2)) - f);
    }

    public void setRemainBattery(int i) {
        this.remainBattery = i;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.isInit) {
            this.isInit = true;
            this.width = getMeasuredWidth();
            this.height = getMeasuredHeight();
            init();
        }
        drawFilledCircle(canvas);
        int i = this.remainBattery;
        if (i >= 0 && i <= 100) {
            drawProgressCircle(canvas);
            drawProgressTxt(canvas);
        } else {
            setDisableView(canvas);
        }
    }

    private void drawFilledCircle(Canvas canvas) {
        int i = this.remainBattery;
        if (i >= 0 && i <= 20) {
            this.fillPaint.setColor(getContext().getResources().getColor(C1965R.color.color_kernel_top_battery_light_red));
        } else {
            this.fillPaint.setColor(getContext().getResources().getColor(C1965R.color.dialog_bg));
        }
        int i2 = this.width;
        canvas.drawCircle(i2 / 2, this.height / 2, i2 / 2, this.fillPaint);
    }

    private void drawProgressCircle(Canvas canvas) {
        int i = this.remainBattery;
        int i2 = (i * 360) / 100;
        if (i == 100) {
            this.progressPaint.setColor(getContext().getResources().getColor(C1965R.color.color_kernel_top_battery_green));
            canvas.drawArc(this.progressRect, 0.0f, 360.0f, false, this.progressPaint);
            return;
        }
        if (20 < i && i < 100) {
            this.progressPaint.setColor(getContext().getResources().getColor(C1965R.color.color_gray));
            canvas.drawArc(this.progressRect, -90.0f, 360 - i2, false, this.progressPaint);
            this.progressPaint.setColor(getContext().getResources().getColor(C1965R.color.color_kernel_top_battery_green));
            canvas.drawArc(this.progressRect, 270 - i2, i2, false, this.progressPaint);
            return;
        }
        this.progressPaint.setColor(getContext().getResources().getColor(C1965R.color.color_kernel_top_battery_deep_red));
        canvas.drawArc(this.progressRect, -90.0f, 360 - i2, false, this.progressPaint);
        this.progressPaint.setColor(getContext().getResources().getColor(C1965R.color.color_kernel_top_battery_red));
        canvas.drawArc(this.progressRect, 270 - i2, i2, false, this.progressPaint);
    }

    private void drawProgressTxt(Canvas canvas) {
        int i = this.remainBattery;
        if (20 < i && i <= 100) {
            this.txtPaint.setColor(getContext().getResources().getColor(C1965R.color.white));
        } else {
            this.txtPaint.setColor(getContext().getResources().getColor(C1965R.color.white));
        }
        int i2 = this.remainBattery;
        if (i2 == 100) {
            this.txtPaint.setTextSize(this.width * 0.38f);
        } else if (10 <= i2 && i2 < 100) {
            this.txtPaint.setTextSize(this.width * 0.48f);
        } else if (i2 >= 0 && i2 < 10) {
            this.txtPaint.setTextSize(this.width * 0.6f);
        }
        String str = this.remainBattery + "";
        this.txtPaint.getTextBounds(str, 0, str.length(), new Rect());
        if (this.remainBattery == 100) {
            canvas.drawText(str, ((this.width / 2) - (r2.width() / 2)) - 1, (this.height / 2) + (r2.height() / 2), this.txtPaint);
        } else if (str.contains("1")) {
            canvas.drawText(str, ((this.width / 2) - (r2.width() / 2)) - 2, (this.height / 2) + (r2.height() / 2), this.txtPaint);
        } else {
            canvas.drawText(str, ((this.width / 2) - (r2.width() / 2)) - 1, (this.height / 2) + (r2.height() / 2), this.txtPaint);
        }
    }

    private void setDisableView(Canvas canvas) {
        this.progressPaint.setColor(getContext().getResources().getColor(C1965R.color.colorWhite));
        canvas.drawArc(this.progressRect, 0.0f, 360.0f, false, this.progressPaint);
        int i = this.width;
        int i2 = this.height;
        canvas.drawRect(i * 0.26f, (i2 / 2) - (i * 0.13f), i - (i * 0.325f), (i * 0.13f) + (i2 / 2), this.rectPaint);
        int i3 = this.width;
        int i4 = this.height;
        canvas.drawRect(i3 - (i3 * 0.312f), (i4 / 2) - (i3 * 0.065f), i3 - (i3 * 0.26f), (i4 / 2) + (i3 * 0.065f), this.rectPaint);
    }
}
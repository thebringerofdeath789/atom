package com.ipotensic.kernel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public class UpgradeProgressView extends View {
    private Paint bgPaint;
    private int center;
    private boolean isInit;
    private int progress;
    private Paint progressBgPaint;
    private Paint progressPaint;
    private RectF rectF;
    private int width;

    public UpgradeProgressView(Context context) {
        super(context);
        this.isInit = false;
    }

    public UpgradeProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInit = false;
    }

    public UpgradeProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isInit = false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.isInit) {
            this.isInit = true;
            Paint paint = new Paint(1);
            this.bgPaint = paint;
            paint.setColor(getResources().getColor(C1965R.color.color_bg_upgrade_dialog));
            this.bgPaint.setStyle(Paint.Style.FILL);
            Paint paint2 = new Paint(1);
            this.progressBgPaint = paint2;
            paint2.setColor(getResources().getColor(C1965R.color.color_modify_pwd_text));
            this.progressBgPaint.setStyle(Paint.Style.STROKE);
            this.progressBgPaint.setStrokeWidth(18.0f);
            Paint paint3 = new Paint(1);
            this.progressPaint = paint3;
            paint3.setColor(getResources().getColor(C1965R.color.colorWhite));
            this.progressPaint.setStyle(Paint.Style.STROKE);
            this.progressPaint.setStrokeWidth(18.0f);
            this.progressPaint.setStrokeCap(Paint.Cap.ROUND);
            int width = getWidth();
            this.width = width;
            this.center = width >> 1;
            int i = this.width;
            this.rectF = new RectF(0.0f, 0.0f, i, i);
        }
        int i2 = this.center;
        canvas.drawCircle(i2, i2, i2, this.bgPaint);
        canvas.drawArc(this.rectF, 0.0f, 360.0f, false, this.progressBgPaint);
        canvas.drawArc(this.rectF, 0.0f, 60.0f, false, this.progressPaint);
    }

    public void upgradeProgress(int i) {
        this.progress = i;
    }
}
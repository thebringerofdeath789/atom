package com.ipotensic.kernel.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class BigPackageSingleFirmwareProgressView extends View {
    private int bgColor;
    private Paint bgPaint;
    private Bitmap bitmap;
    private int bitmapHeight;
    private Paint bitmapPaint;
    private int bitmapWidth;
    private int center;
    private int progress;
    private int progressBgColor;
    private Paint progressBgPaint;
    private int progressColor;
    private Paint progressPaint;
    private int progressWidth;
    private int width;

    public BigPackageSingleFirmwareProgressView(Context context) {
        this(context, null);
    }

    public BigPackageSingleFirmwareProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BigPackageSingleFirmwareProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.progress = 100;
        init(context);
    }

    private void init(Context context) {
        this.progressWidth = UnitUtil.dp2px(2);
        this.bgColor = context.getColor(R.color.colorCycleProgressBackground);
        this.progressBgColor = context.getColor(R.color.colorInner);
        this.progressColor = context.getColor(R.color.colorWhite);
        Paint paint = new Paint(1);
        this.bgPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.bgPaint.setColor(this.bgColor);
        Paint paint2 = new Paint(1);
        this.progressBgPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.progressBgPaint.setColor(this.progressBgColor);
        this.progressBgPaint.setStrokeWidth(this.progressWidth);
        Paint paint3 = new Paint(1);
        this.progressPaint = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.progressPaint.setColor(this.progressColor);
        this.progressPaint.setStrokeWidth(this.progressWidth);
        this.progressPaint.setStrokeCap(Paint.Cap.ROUND);
        this.bitmapPaint = new Paint(1);
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), R.mipmap.icon_big_package_finish);
        this.bitmap = decodeResource;
        this.bitmapWidth = decodeResource.getWidth();
        this.bitmapHeight = this.bitmap.getHeight();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int width = getWidth();
        this.width = width;
        this.center = width >> 1;
        DDLog.e("BigPackageFirmwareProgressView:" + this.width);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.center;
        canvas.drawCircle(i, i, i, this.bgPaint);
        int i2 = this.center;
        canvas.drawCircle(i2, i2, i2 - (this.progressWidth >> 1), this.progressBgPaint);
        int i3 = this.progressWidth;
        int i4 = this.width;
        canvas.drawArc(i3, i3, i4 - i3, i4 - i3, 0.0f, this.progress * 3.6f, false, this.progressPaint);
        if (this.progress >= 100) {
            Rect rect = new Rect(0, 0, this.bitmapWidth, this.bitmapHeight);
            int i5 = this.width;
            int i6 = (i5 - this.bitmapWidth) >> 1;
            int i7 = (i5 - this.bitmapHeight) >> 1;
            canvas.drawBitmap(this.bitmap, rect, new Rect(i6, i7, this.bitmapWidth + i6, this.bitmapHeight + i7), this.bitmapPaint);
        }
    }

    public void setUpgradeProgress(int i) {
        this.progress = i;
        invalidate();
    }
}
package com.ipotensic.potensicpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.potensicpro.C2640R;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes2.dex */
public class IndicatorProgressbar extends View {
    private float defaultSize;
    private Paint indicateBackPaint;
    private Bitmap indicateBitmap;
    private int indicateHeight;
    private String indicateText;
    private int indicateTextColor;
    private Paint indicateTextPaint;
    private int indicateWidth;
    private int max;
    private int progress;
    private Bitmap progressBitmap;
    private int progressHeight;
    private Paint progressPaint;
    private int progressWidth;

    public IndicatorProgressbar(Context context) {
        this(context, null);
    }

    public IndicatorProgressbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.progress = 1;
        this.indicateText = "1/15";
        init(context, attributeSet);
    }

    public IndicatorProgressbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.progress = 1;
        this.indicateText = "1/15";
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2640R.styleable.IndicateProgressView);
        if (obtainStyledAttributes != null) {
            this.indicateTextColor = obtainStyledAttributes.getColor(1, this.indicateTextColor);
            this.defaultSize = obtainStyledAttributes.getDimension(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint(1);
        this.progressPaint = paint;
        paint.setFilterBitmap(true);
        this.progressPaint.setStyle(Paint.Style.FILL);
        this.indicateBackPaint = new Paint(1);
        this.progressPaint.setFilterBitmap(true);
        this.indicateBackPaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.indicateTextPaint = paint2;
        paint2.setColor(this.indicateTextColor);
        this.indicateTextPaint.setTextAlign(Paint.Align.CENTER);
        this.indicateTextPaint.setTextSize(this.defaultSize);
        this.indicateBitmap = BitmapFactory.decodeResource(getResources(), C2640R.mipmap.img_pdf_indicate_tip);
        this.progressBitmap = BitmapFactory.decodeResource(getResources(), C2640R.mipmap.img_pdf_indicate_all);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int i = (int) (((this.progress - 1) / this.max) * (r3 - this.indicateWidth));
        float f = width;
        canvas.drawBitmap(this.progressBitmap, (f - this.progressWidth) / 2.0f, height - this.progressHeight, this.progressPaint);
        canvas.drawBitmap(this.indicateBitmap, ((f - this.progressWidth) / 2.0f) + i, (height - this.indicateHeight) - 20, this.indicateBackPaint);
        canvas.drawText(this.indicateText, ((width - this.progressWidth) / 2) + i + (this.indicateWidth / 2), (((height - r4) - 20) + (this.indicateHeight / 2.0f)) - 5.0f, this.indicateTextPaint);
        DDLog.m1684e("width: " + width + ", height:" + height + ",progressWidth:" + this.progressWidth + ",progressHeight:" + this.progressHeight + ",indicateHeight:" + this.indicateHeight + ",indicateWidth:" + this.indicateWidth);
        DDLog.m1684e(",offsex:" + i);
    }

    public void setMax(int i) {
        this.max = i;
        this.indicateText = this.progress + InternalZipConstants.ZIP_FILE_SEPARATOR + i;
        postInvalidate();
    }

    public void setProgress(int i, int i2) {
        this.max = i2;
        this.progress = i + 1;
        this.indicateText = this.progress + InternalZipConstants.ZIP_FILE_SEPARATOR + i2;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.progressWidth = this.progressBitmap.getWidth();
        this.progressHeight = this.progressBitmap.getHeight();
        this.indicateWidth = this.indicateBitmap.getWidth();
        this.indicateHeight = this.indicateBitmap.getHeight();
    }
}
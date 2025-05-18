package com.ipotensic.potensicpro.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.github.barteksc.pdfviewer.util.Util;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public class PDFDownloadProgressView extends ProgressBar {
    private int centerX;
    private int centerY;
    private Context context;
    private String text;
    private Paint textPaint;

    public PDFDownloadProgressView(Context context) {
        this(context, null);
    }

    public PDFDownloadProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PDFDownloadProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        setEnabled(true);
        setClickable(true);
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.textPaint = paint;
        paint.setAntiAlias(true);
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setTextSize(Util.getDP(this.context, 15));
        this.textPaint.setColor(-1);
        this.text = this.context.getString(C2640R.string.start_download);
    }

    public void setText(String str) {
        this.text = str;
        invalidate();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.centerX == 0) {
            this.centerX = getWidth() >> 1;
            this.centerY = getHeight() >> 1;
        }
        drawText(canvas, this.text);
    }

    private void drawText(Canvas canvas, String str) {
        this.textPaint.getTextBounds(str, 0, str.length(), new Rect());
        Paint.FontMetricsInt fontMetricsInt = this.textPaint.getFontMetricsInt();
        canvas.drawText(str, this.centerX - r0.centerX(), this.centerY + (((fontMetricsInt.bottom - fontMetricsInt.top) >> 1) - fontMetricsInt.bottom), this.textPaint);
    }
}
package com.ipotensic.kernel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import java.util.List;

/* loaded from: classes2.dex */
public class FormView extends View {
    private int ALERT_VALUE;
    private List<List<String>> dataList;
    private Paint dataTextPaint;
    private float heightSize;
    private Paint itemsTextPaint;
    private Paint linePaint;
    private Paint linePaint2;
    private List<String> longitudinalItems;
    private String longitudinalName;
    private String longitudinalUnit;
    private List<String> transverseItems;
    private String transverseName;
    private String transverseUnit;
    private float widthSize;

    public FormView(Context context) {
        this(context, null);
    }

    public FormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FormView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ALERT_VALUE = 100;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.widthSize = View.MeasureSpec.getSize(i) - 12;
        this.heightSize = View.MeasureSpec.getSize(i2) - 12;
        Paint paint = new Paint();
        this.linePaint = paint;
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.linePaint.setStrokeWidth(2.0f);
        Paint paint2 = new Paint();
        this.linePaint2 = paint2;
        paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.linePaint2.setStyle(Paint.Style.STROKE);
        this.linePaint2.setStrokeWidth(2.0f);
        this.linePaint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.itemsTextPaint = paint3;
        paint3.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.itemsTextPaint.setStrokeWidth(2.0f);
        this.itemsTextPaint.setTextSize(40.0f);
        this.itemsTextPaint.setFakeBoldText(true);
        this.itemsTextPaint.setTextAlign(Paint.Align.CENTER);
        Paint paint4 = new Paint();
        this.dataTextPaint = paint4;
        paint4.setColor(SupportMenu.CATEGORY_MASK);
        this.dataTextPaint.setStrokeWidth(2.0f);
        this.dataTextPaint.setTextSize(38.0f);
        this.dataTextPaint.setFakeBoldText(true);
        this.dataTextPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        List<String> list;
        super.onDraw(canvas);
        List<String> list2 = this.transverseItems;
        if (list2 == null || list2.size() == 0 || (list = this.longitudinalItems) == null || list.size() == 0) {
            return;
        }
        float size = this.widthSize / (this.transverseItems.size() + 1);
        for (int i = 0; i <= this.transverseItems.size() + 1; i++) {
            float f = (i * size) + 6.0f;
            canvas.drawLine(f, 6.0f, f, this.heightSize + 6.0f, this.linePaint);
        }
        float size2 = this.heightSize / (this.longitudinalItems.size() + 1);
        for (int i2 = 0; i2 <= this.longitudinalItems.size() + 1; i2++) {
            float f2 = (i2 * size2) + 6.0f;
            canvas.drawLine(6.0f, f2, this.widthSize + 6.0f, f2, this.linePaint);
        }
        canvas.drawLine(1.0f, 1.0f, this.widthSize + 11.0f, 1.0f, this.linePaint);
        float f3 = this.widthSize;
        canvas.drawLine(f3 + 11.0f, 1.0f, f3 + 11.0f, this.heightSize + 11.0f, this.linePaint);
        float f4 = this.widthSize + 11.0f;
        float f5 = this.heightSize;
        canvas.drawLine(f4, f5 + 11.0f, 1.0f, f5 + 11.0f, this.linePaint);
        canvas.drawLine(1.0f, this.heightSize + 11.0f, 1.0f, 1.0f, this.linePaint);
        float f6 = (0.0f * size) + 6.0f;
        float f7 = size / 2.0f;
        float f8 = size2 / 2.0f;
        float f9 = size + 6.0f;
        float f10 = size2 + 6.0f;
        Path path = new Path();
        path.moveTo(f6, 6.0f);
        path.quadTo(f7, 2.0f, f7, f8);
        canvas.drawPath(path, this.linePaint2);
        Path path2 = new Path();
        path2.moveTo(f7, f8);
        path2.quadTo(f7, 4.0f + f10, f9, f10);
        canvas.drawPath(path2, this.linePaint2);
        float f11 = f9 + f7;
        float f12 = (f10 + 6.0f) / 2.0f;
        canvas.drawText(this.transverseName, f11 / 2.0f, (this.itemsTextPaint.getTextSize() / 5.0f) + f12, this.itemsTextPaint);
        canvas.drawText(this.longitudinalName, (f6 + f7) / 2.0f, f12 + (this.itemsTextPaint.getTextSize() / 5.0f), this.itemsTextPaint);
        for (int i3 = 0; i3 < this.transverseItems.size(); i3++) {
            canvas.drawText(this.transverseItems.get(i3), (i3 * size) + f11, f8 + 6.0f + (this.itemsTextPaint.getTextSize() / 5.0f), this.itemsTextPaint);
        }
        for (int i4 = 0; i4 < this.longitudinalItems.size(); i4++) {
            canvas.drawText(this.longitudinalItems.get(i4), f7 + 6.0f, f10 + f8 + (i4 * size2) + (this.itemsTextPaint.getTextSize() / 5.0f), this.itemsTextPaint);
        }
        List<List<String>> list3 = this.dataList;
        if (list3 == null || list3.size() == 0 || this.dataList.size() != this.transverseItems.size()) {
            return;
        }
        for (int i5 = 0; i5 < this.dataList.size(); i5++) {
            if (this.dataList.get(i5).size() != this.longitudinalItems.size()) {
                return;
            }
        }
        for (int i6 = 0; i6 < this.dataList.size(); i6++) {
            for (int i7 = 0; i7 < this.dataList.get(i6).size(); i7++) {
                float f13 = (i6 * size) + f11;
                float textSize = f10 + f8 + (i7 * size2) + (this.dataTextPaint.getTextSize() / 5.0f);
                if (this.dataList.get(i6).get(i7) == null) {
                    this.dataList.get(i6).set(i7, "null");
                }
                this.dataTextPaint.setColor(-16776961);
                canvas.drawText(this.dataList.get(i6).get(i7) + "", f13, textSize, this.dataTextPaint);
            }
        }
    }

    public void setTransverse(List<String> list, String str, String str2) {
        this.transverseItems = list;
        this.transverseName = str;
        this.transverseUnit = str2;
        postInvalidate();
    }

    public void setLongitudinal(List<String> list, String str, String str2) {
        this.longitudinalItems = list;
        this.longitudinalName = str;
        this.longitudinalUnit = str2;
        postInvalidate();
    }

    public void setData(List<List<String>> list) {
        this.dataList = list;
        postInvalidate();
    }
}
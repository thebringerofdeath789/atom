package com.ipotensic.kernel.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.kernel.R;
import com.logan.flight.data.recv.FlightRevRemoterCalibrationData;

/* loaded from: classes2.dex */
public class CalRockerView extends View {
    private Paint bitmapPaint;
    private Rect bottomProgressRect;
    private Rect bottomRoundRect;
    private Point[] bottomTriangle;
    private FlightRevRemoterCalibrationData calibrationData;
    private Bitmap centerBitmap;
    private Rect centerRect;
    private final int centerScale;
    private Bitmap dialBitmap;
    private Rect dialRect;
    private final int dialScale;
    private Bitmap doneRoundBitmap;
    private int height;
    private boolean isGray;
    private boolean isInit;
    private boolean isLeftRocker;
    private Rect leftProgressRect;
    private Rect leftRoundRect;
    private Bitmap leftSegmentDisableBitmap;
    private Bitmap leftSegmentEnableBitmap;
    private Point[] leftTriangle;
    private Bitmap normalRoundBitmap;
    private Paint progressPaint;
    private final int rectHeight;
    private Rect rightProgressRect;
    private Rect rightRoundRect;
    private Bitmap rightSegmentDisableBitmap;
    private Bitmap rightSegmentEnableBitmap;
    private Point[] rightTriangle;
    private final int roundScale;
    private final int textPadding;
    private Paint textPaint;
    private Rect topProgressRect;
    private Rect topRoundRect;
    private Point[] topTriangle;
    private final int trianglePercent;
    private final int triangleScale;
    private int width;

    public CalRockerView(Context context) {
        super(context);
        this.isInit = false;
        this.textPadding = 8;
        this.dialScale = 65;
        this.centerScale = 13;
        this.roundScale = 6;
        this.leftTriangle = new Point[3];
        this.topTriangle = new Point[3];
        this.rightTriangle = new Point[3];
        this.bottomTriangle = new Point[3];
        this.triangleScale = 5;
        this.trianglePercent = 50;
        this.rectHeight = 3;
        this.isLeftRocker = false;
        this.isGray = false;
    }

    public CalRockerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInit = false;
        this.textPadding = 8;
        this.dialScale = 65;
        this.centerScale = 13;
        this.roundScale = 6;
        this.leftTriangle = new Point[3];
        this.topTriangle = new Point[3];
        this.rightTriangle = new Point[3];
        this.bottomTriangle = new Point[3];
        this.triangleScale = 5;
        this.trianglePercent = 50;
        this.rectHeight = 3;
        this.isLeftRocker = false;
        this.isGray = false;
    }

    public CalRockerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isInit = false;
        this.textPadding = 8;
        this.dialScale = 65;
        this.centerScale = 13;
        this.roundScale = 6;
        this.leftTriangle = new Point[3];
        this.topTriangle = new Point[3];
        this.rightTriangle = new Point[3];
        this.bottomTriangle = new Point[3];
        this.triangleScale = 5;
        this.trianglePercent = 50;
        this.rectHeight = 3;
        this.isLeftRocker = false;
        this.isGray = false;
    }

    public CalRockerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.isInit = false;
        this.textPadding = 8;
        this.dialScale = 65;
        this.centerScale = 13;
        this.roundScale = 6;
        this.leftTriangle = new Point[3];
        this.topTriangle = new Point[3];
        this.rightTriangle = new Point[3];
        this.bottomTriangle = new Point[3];
        this.triangleScale = 5;
        this.trianglePercent = 50;
        this.rectHeight = 3;
        this.isLeftRocker = false;
        this.isGray = false;
    }

    public void setGray(boolean z) {
        this.isGray = z;
        postInvalidate();
    }

    public void setLeftRocker(boolean z) {
        this.isLeftRocker = z;
        postInvalidate();
    }

    public void setProgress(FlightRevRemoterCalibrationData flightRevRemoterCalibrationData) {
        this.calibrationData = flightRevRemoterCalibrationData;
        postInvalidate();
    }

    private void init() {
        if (this.isInit) {
            return;
        }
        this.isInit = true;
        this.width = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.height = measuredHeight;
        int i = (this.width * 65) / 100;
        int i2 = (measuredHeight * 65) / 100;
        int i3 = this.width;
        int i4 = this.height;
        this.dialRect = new Rect((i3 - i) / 2, (i4 - i2) / 2, ((i3 - i) / 2) + i, ((i4 - i2) / 2) + i2);
        int i5 = (this.width * 13) / 100;
        int i6 = (this.height * 13) / 100;
        int i7 = this.width;
        int i8 = this.height;
        this.centerRect = new Rect((i7 - i5) / 2, (i8 - i6) / 2, ((i7 - i5) / 2) + i5, ((i8 - i6) / 2) + i6);
        int i9 = ((this.width * 6) / 100) / 2;
        int i10 = ((this.height * 6) / 100) / 2;
        this.leftRoundRect = new Rect(this.dialRect.left - i9, (this.height / 2) - i10, this.dialRect.left + i9, (this.height / 2) + i10);
        this.topRoundRect = new Rect((this.width / 2) - i9, this.dialRect.top - i10, (this.width / 2) + i9, this.dialRect.top + i10);
        this.rightRoundRect = new Rect(this.dialRect.right - i9, (this.height / 2) - i10, this.dialRect.right + i9, (this.height / 2) + i10);
        this.bottomRoundRect = new Rect((this.width / 2) - i9, this.dialRect.bottom - i10, (this.width / 2) + i9, this.dialRect.bottom + i10);
        int i11 = (this.width * 5) / 100;
        int i12 = (this.height * 5) / 100;
        this.leftTriangle[0] = new Point(this.leftRoundRect.right + (((this.centerRect.left - this.leftRoundRect.right) * 50) / 100), this.height / 2);
        int i13 = i12 / 2;
        this.leftTriangle[1] = new Point(this.leftTriangle[0].x + i11, (this.height / 2) - i13);
        this.leftTriangle[2] = new Point(this.leftTriangle[0].x + i11, (this.height / 2) + i13);
        this.rightTriangle[0] = new Point(this.centerRect.right + (((this.rightRoundRect.left - this.centerRect.right) * 50) / 100), this.height / 2);
        this.rightTriangle[1] = new Point(this.rightTriangle[0].x - i11, (this.height / 2) - i13);
        this.rightTriangle[2] = new Point(this.rightTriangle[0].x - i11, (this.height / 2) + i13);
        this.topTriangle[0] = new Point(this.width / 2, this.topRoundRect.bottom + (((this.centerRect.top - this.topRoundRect.bottom) * 50) / 100));
        int i14 = i11 / 2;
        this.topTriangle[1] = new Point((this.width / 2) - i14, this.topTriangle[0].y + i12);
        this.topTriangle[2] = new Point((this.width / 2) + i14, this.topTriangle[0].y + i12);
        this.bottomTriangle[0] = new Point(this.width / 2, this.centerRect.bottom + (((this.bottomRoundRect.top - this.centerRect.bottom) * 50) / 100));
        this.bottomTriangle[1] = new Point((this.width / 2) - i14, this.bottomTriangle[0].y - i12);
        this.bottomTriangle[2] = new Point((this.width / 2) + i14, this.bottomTriangle[0].y - i12);
        this.leftProgressRect = new Rect(this.leftRoundRect.right, (this.height / 2) - 3, this.centerRect.left, (this.height / 2) + 3);
        this.rightProgressRect = new Rect(this.centerRect.right, (this.height / 2) - 3, this.rightRoundRect.left, (this.height / 2) + 3);
        this.topProgressRect = new Rect((this.width / 2) - 3, this.topRoundRect.bottom, (this.width / 2) + 3, this.centerRect.top);
        this.bottomProgressRect = new Rect((this.width / 2) - 3, this.centerRect.bottom, (this.width / 2) + 3, this.bottomRoundRect.top);
        this.dialBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.img_bg_rocker);
        this.centerBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.img_icon_rocker_center);
        this.normalRoundBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.img_icon_indicator_disable);
        this.doneRoundBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.img_icon_indicator_enable);
        this.leftSegmentEnableBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.img_remoter_cal_line_segment_left_enable);
        this.leftSegmentDisableBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.img_remoter_cal_line_segment_left_disable);
        this.rightSegmentEnableBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.img_remoter_cal_line_segment_right_enable);
        this.rightSegmentDisableBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.img_remoter_cal_line_segment_right_disable);
        Paint paint = new Paint(1);
        this.bitmapPaint = paint;
        paint.setFilterBitmap(true);
        this.bitmapPaint.setDither(true);
        Paint paint2 = new Paint();
        this.progressPaint = paint2;
        paint2.setAntiAlias(false);
        this.progressPaint.setStyle(Paint.Style.FILL);
        this.progressPaint.setColor(getResources().getColor(R.color.color_progress_gray));
        Paint paint3 = new Paint(1);
        this.textPaint = paint3;
        paint3.setColor(getContext().getResources().getColor(R.color.color_progress_green));
        this.textPaint.setTextSize(this.width * 0.05f);
        this.textPaint.setTypeface(PhoneConfig.typeface);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        init();
        drawBitmap(canvas);
        drawProgress(canvas);
        drawSegment(canvas);
    }

    private void drawBitmap(Canvas canvas) {
        canvas.drawBitmap(this.dialBitmap, new Rect(0, 0, this.dialBitmap.getWidth(), this.dialBitmap.getHeight()), this.dialRect, this.bitmapPaint);
        canvas.drawBitmap(this.centerBitmap, new Rect(0, 0, this.centerBitmap.getWidth(), this.centerBitmap.getHeight()), this.centerRect, this.bitmapPaint);
        FlightRevRemoterCalibrationData flightRevRemoterCalibrationData = this.calibrationData;
        if (flightRevRemoterCalibrationData != null) {
            if (this.isLeftRocker) {
                Bitmap bitmap = flightRevRemoterCalibrationData.isLeftLeftCalSuccess() ? this.doneRoundBitmap : this.normalRoundBitmap;
                canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), this.leftRoundRect, this.bitmapPaint);
                Bitmap bitmap2 = this.calibrationData.isLeftRightCalSuccess() ? this.doneRoundBitmap : this.normalRoundBitmap;
                canvas.drawBitmap(bitmap2, new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), this.rightRoundRect, this.bitmapPaint);
                Bitmap bitmap3 = this.calibrationData.isLeftTopCalSuccess() ? this.doneRoundBitmap : this.normalRoundBitmap;
                canvas.drawBitmap(bitmap3, new Rect(0, 0, bitmap3.getWidth(), bitmap3.getHeight()), this.topRoundRect, this.bitmapPaint);
                Bitmap bitmap4 = this.calibrationData.isLeftBottomCalSuccess() ? this.doneRoundBitmap : this.normalRoundBitmap;
                canvas.drawBitmap(bitmap4, new Rect(0, 0, bitmap4.getWidth(), bitmap4.getHeight()), this.bottomRoundRect, this.bitmapPaint);
                return;
            }
            Bitmap bitmap5 = flightRevRemoterCalibrationData.isRightLeftCalSuccess() ? this.doneRoundBitmap : this.normalRoundBitmap;
            canvas.drawBitmap(bitmap5, new Rect(0, 0, bitmap5.getWidth(), bitmap5.getHeight()), this.leftRoundRect, this.bitmapPaint);
            Bitmap bitmap6 = this.calibrationData.isRightRightCalSuccess() ? this.doneRoundBitmap : this.normalRoundBitmap;
            canvas.drawBitmap(bitmap6, new Rect(0, 0, bitmap6.getWidth(), bitmap6.getHeight()), this.rightRoundRect, this.bitmapPaint);
            Bitmap bitmap7 = this.calibrationData.isRightTopCalSuccess() ? this.doneRoundBitmap : this.normalRoundBitmap;
            canvas.drawBitmap(bitmap7, new Rect(0, 0, bitmap7.getWidth(), bitmap7.getHeight()), this.topRoundRect, this.bitmapPaint);
            Bitmap bitmap8 = this.calibrationData.isRightBottomCalSuccess() ? this.doneRoundBitmap : this.normalRoundBitmap;
            canvas.drawBitmap(bitmap8, new Rect(0, 0, bitmap8.getWidth(), bitmap8.getHeight()), this.bottomRoundRect, this.bitmapPaint);
            return;
        }
        canvas.drawBitmap(this.normalRoundBitmap, new Rect(0, 0, this.normalRoundBitmap.getWidth(), this.normalRoundBitmap.getHeight()), this.leftRoundRect, this.bitmapPaint);
        canvas.drawBitmap(this.normalRoundBitmap, new Rect(0, 0, this.normalRoundBitmap.getWidth(), this.normalRoundBitmap.getHeight()), this.topRoundRect, this.bitmapPaint);
        canvas.drawBitmap(this.normalRoundBitmap, new Rect(0, 0, this.normalRoundBitmap.getWidth(), this.normalRoundBitmap.getHeight()), this.rightRoundRect, this.bitmapPaint);
        canvas.drawBitmap(this.normalRoundBitmap, new Rect(0, 0, this.normalRoundBitmap.getWidth(), this.normalRoundBitmap.getHeight()), this.bottomRoundRect, this.bitmapPaint);
    }

    private void drawProgress(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        this.progressPaint.setColor(getResources().getColor(R.color.color_progress_gray));
        Path path = new Path();
        path.moveTo(this.leftTriangle[0].x, this.leftTriangle[0].y);
        path.lineTo(this.leftTriangle[1].x, this.leftTriangle[1].y);
        path.lineTo(this.leftTriangle[2].x, this.leftTriangle[2].y);
        path.close();
        canvas.drawPath(path, this.progressPaint);
        canvas.drawRect(this.leftProgressRect, this.progressPaint);
        path.reset();
        path.moveTo(this.rightTriangle[0].x, this.rightTriangle[0].y);
        path.lineTo(this.rightTriangle[1].x, this.rightTriangle[1].y);
        path.lineTo(this.rightTriangle[2].x, this.rightTriangle[2].y);
        path.close();
        canvas.drawPath(path, this.progressPaint);
        canvas.drawRect(this.rightProgressRect, this.progressPaint);
        path.reset();
        path.moveTo(this.topTriangle[0].x, this.topTriangle[0].y);
        path.lineTo(this.topTriangle[1].x, this.topTriangle[1].y);
        path.lineTo(this.topTriangle[2].x, this.topTriangle[2].y);
        path.close();
        canvas.drawPath(path, this.progressPaint);
        canvas.drawRect(this.topProgressRect, this.progressPaint);
        path.reset();
        path.moveTo(this.bottomTriangle[0].x, this.bottomTriangle[0].y);
        path.lineTo(this.bottomTriangle[1].x, this.bottomTriangle[1].y);
        path.lineTo(this.bottomTriangle[2].x, this.bottomTriangle[2].y);
        path.close();
        canvas.drawPath(path, this.progressPaint);
        canvas.drawRect(this.bottomProgressRect, this.progressPaint);
        this.progressPaint.setColor(getResources().getColor(R.color.color_progress_green));
        int i5 = (this.width * 5) / 100;
        int i6 = (this.height * 5) / 100;
        FlightRevRemoterCalibrationData flightRevRemoterCalibrationData = this.calibrationData;
        if (flightRevRemoterCalibrationData == null) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else if (this.isLeftRocker) {
            i = flightRevRemoterCalibrationData.getLeftLeftCalValue();
            i2 = this.calibrationData.getLeftRightCalValue();
            i3 = this.calibrationData.getLeftTopCalValue();
            i4 = this.calibrationData.getLeftBottomCalValue();
        } else {
            i = flightRevRemoterCalibrationData.getRightLeftCalValue();
            i2 = this.calibrationData.getRightRightCalValue();
            i3 = this.calibrationData.getRightTopCalValue();
            i4 = this.calibrationData.getRightBottomCalValue();
        }
        if (i != 0) {
            Rect rect = new Rect();
            rect.left = this.leftProgressRect.left + (((this.leftProgressRect.right - this.leftProgressRect.left) * (100 - i)) / 100);
            rect.right = this.leftProgressRect.right;
            rect.top = this.leftProgressRect.top;
            rect.bottom = this.leftProgressRect.bottom;
            canvas.drawRect(rect, this.progressPaint);
            path.reset();
            path.moveTo(this.leftTriangle[0].x, this.leftTriangle[0].y);
            path.lineTo(this.leftTriangle[1].x, this.leftTriangle[1].y);
            path.lineTo(this.leftTriangle[2].x, this.leftTriangle[2].y);
            path.close();
            canvas.drawPath(path, this.progressPaint);
            if (rect.left < this.leftTriangle[1].x) {
                int i7 = rect.left;
                int i8 = this.leftTriangle[0].x;
            }
        }
        if (i2 != 0) {
            Rect rect2 = new Rect();
            rect2.left = this.rightProgressRect.left;
            rect2.right = this.rightProgressRect.left + (((this.rightProgressRect.right - this.rightProgressRect.left) * i2) / 100);
            rect2.top = this.rightProgressRect.top;
            rect2.bottom = this.rightProgressRect.bottom;
            canvas.drawRect(rect2, this.progressPaint);
            path.reset();
            path.moveTo(this.rightTriangle[0].x, this.rightTriangle[0].y);
            path.lineTo(this.rightTriangle[1].x, this.rightTriangle[1].y);
            path.lineTo(this.rightTriangle[2].x, this.rightTriangle[2].y);
            path.close();
            canvas.drawPath(path, this.progressPaint);
            if (rect2.right > this.rightTriangle[1].x) {
                int i9 = rect2.right;
                int i10 = this.rightTriangle[0].x;
            }
        }
        if (i3 != 0) {
            Rect rect3 = new Rect();
            rect3.left = this.topProgressRect.left;
            rect3.right = this.topProgressRect.right;
            rect3.top = this.topProgressRect.top + (((this.topProgressRect.bottom - this.topProgressRect.top) * (100 - i3)) / 100);
            rect3.bottom = this.topProgressRect.bottom;
            canvas.drawRect(rect3, this.progressPaint);
            path.reset();
            path.moveTo(this.topTriangle[0].x, this.topTriangle[0].y);
            path.lineTo(this.topTriangle[1].x, this.topTriangle[1].y);
            path.lineTo(this.topTriangle[2].x, this.topTriangle[2].y);
            path.close();
            canvas.drawPath(path, this.progressPaint);
            if (rect3.top < this.topTriangle[1].y) {
                int i11 = rect3.top;
                int i12 = this.topTriangle[0].y;
            }
        }
        if (i4 != 0) {
            Rect rect4 = new Rect();
            rect4.left = this.bottomProgressRect.left;
            rect4.right = this.bottomProgressRect.right;
            rect4.top = this.bottomProgressRect.top;
            rect4.bottom = this.bottomProgressRect.top + (((this.bottomProgressRect.bottom - this.bottomProgressRect.top) * i4) / 100);
            canvas.drawRect(rect4, this.progressPaint);
            path.reset();
            path.moveTo(this.bottomTriangle[0].x, this.bottomTriangle[0].y);
            path.lineTo(this.bottomTriangle[1].x, this.bottomTriangle[1].y);
            path.lineTo(this.bottomTriangle[2].x, this.bottomTriangle[2].y);
            path.close();
            canvas.drawPath(path, this.progressPaint);
            if (rect4.bottom > this.bottomTriangle[1].y) {
                int i13 = rect4.bottom;
                int i14 = this.bottomTriangle[0].y;
            }
        }
        String str = i + "%";
        String str2 = i3 + "%";
        String str3 = i2 + "%";
        String str4 = i4 + "%";
        Rect rect5 = new Rect();
        if (i == 100) {
            this.textPaint.setColor(getResources().getColor(R.color.color_progress_green));
        } else {
            this.textPaint.setColor(getResources().getColor(R.color.color_progress_gray));
        }
        this.textPaint.getTextBounds(str, 0, str.length(), rect5);
        canvas.drawText(str, (this.leftRoundRect.left - rect5.width()) - 8, (this.height / 2) + (rect5.height() / 2), this.textPaint);
        if (i2 == 100) {
            this.textPaint.setColor(getResources().getColor(R.color.color_progress_green));
        } else {
            this.textPaint.setColor(getResources().getColor(R.color.color_progress_gray));
        }
        this.textPaint.getTextBounds(str3, 0, str3.length(), new Rect());
        canvas.drawText(str3, this.rightRoundRect.right + 8, (this.height / 2) + (r0.height() / 2), this.textPaint);
        if (i3 == 100) {
            this.textPaint.setColor(getResources().getColor(R.color.color_progress_green));
        } else {
            this.textPaint.setColor(getResources().getColor(R.color.color_progress_gray));
        }
        this.textPaint.getTextBounds(str2, 0, str2.length(), new Rect());
        canvas.drawText(str2, (this.width / 2) - (r0.width() / 2), this.topRoundRect.top - 8, this.textPaint);
        if (i4 == 100) {
            this.textPaint.setColor(getResources().getColor(R.color.color_progress_green));
        } else {
            this.textPaint.setColor(getResources().getColor(R.color.color_progress_gray));
        }
        this.textPaint.getTextBounds(str4, 0, str4.length(), new Rect());
        canvas.drawText(str4, (this.width / 2) - (r0.width() / 2), this.bottomRoundRect.bottom + r0.height() + 8, this.textPaint);
    }

    private void drawSegment(Canvas canvas) {
        Bitmap bitmap;
        Rect rect = new Rect();
        if (this.isLeftRocker) {
            rect.left = this.centerRect.right - 5;
            rect.right = this.width;
            rect.top = 0;
            rect.bottom = ((this.height / 2) - (this.centerRect.height() / 2)) + 5;
            bitmap = this.isGray ? this.leftSegmentDisableBitmap : this.leftSegmentEnableBitmap;
        } else {
            rect.left = 0;
            rect.right = this.centerRect.left + 5;
            rect.top = 0;
            rect.bottom = ((this.height / 2) - (this.centerRect.height() / 2)) + 5;
            bitmap = this.isGray ? this.rightSegmentDisableBitmap : this.rightSegmentEnableBitmap;
        }
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, this.bitmapPaint);
    }
}

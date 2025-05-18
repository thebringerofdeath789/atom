package com.ipotensic.kernel.view.attitude;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class Attitude {
    private float PADDING;
    private float TOP_RECT_HEIGHT;
    private int TOP_TRIANGLE_HEIGHT;
    private Context context;
    private Paint gradientPaint;
    private int gradientTop;
    private int height;
    private int startAngel;
    private int sweepAngel;
    private Paint topPaint;
    private int width;
    private final String TAG = getClass().getSimpleName();
    private int yawPitch = 0;
    private int rotate = 0;
    private RectF mainRect = new RectF();
    private Rect topRect = new Rect();
    private Point[] topTriangle = new Point[3];
    private boolean isConnect = false;

    public Attitude(Context context, int i, int i2) {
        this.PADDING = 4.0f;
        this.TOP_RECT_HEIGHT = 2.0f;
        this.TOP_TRIANGLE_HEIGHT = 8;
        this.context = context;
        this.width = i;
        this.height = i2;
        float f = i;
        this.PADDING = f / 27.0f;
        this.TOP_RECT_HEIGHT = f / 100.0f;
        this.TOP_TRIANGLE_HEIGHT = i / 30;
        Paint paint = new Paint();
        this.gradientPaint = paint;
        paint.setAntiAlias(true);
        this.gradientPaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.topPaint = paint2;
        paint2.setAntiAlias(true);
        this.topPaint.setStyle(Paint.Style.FILL);
        this.mainRect.left = this.PADDING + (this.TOP_RECT_HEIGHT / 2.0f);
        this.mainRect.top = this.PADDING;
        this.mainRect.right = (f - this.PADDING) - (this.TOP_RECT_HEIGHT / 2.0f);
        this.mainRect.bottom = i2 - this.PADDING;
    }

    public void setYawPitch(int i) {
        DDLog.e(this.TAG, "yaw:" + i);
        this.yawPitch = i;
    }

    public int getYawPitchPercent() {
        return 100 - (((this.yawPitch + 90) * 100) / 180);
    }

    public float getYawPitchTopPadding() {
        return Math.abs(getYawPitchPercent() - 50) * (this.TOP_RECT_HEIGHT / 50.0f);
    }

    public void setRotate(int i) {
        this.rotate = i;
    }

    public void setConnect(boolean z) {
        this.isConnect = z;
        if (z) {
            return;
        }
        this.yawPitch = 0;
        this.rotate = 0;
    }

    public void draw(Canvas canvas) {
        canvas.rotate(this.rotate, this.width / 2, this.height / 2);
        int i = R.color.color_attitude_view_gray_start;
        int i2 = R.color.color_attitude_view_gray_end;
        int i3 = R.color.color_attitude_view_gray_full;
        if (this.isConnect) {
            if (Math.abs(this.yawPitch) <= 30 && Math.abs(this.rotate) <= 30) {
                i = R.color.color_attitude_view_green_start;
                i2 = R.color.color_attitude_view_green_end;
                i3 = R.color.color_attitude_view_green_full;
            } else if ((40 < Math.abs(this.yawPitch) && Math.abs(this.yawPitch) <= 180) || (40 < Math.abs(this.rotate) && Math.abs(this.rotate) <= 180)) {
                i = R.color.color_attitude_view_red_start;
                i2 = R.color.color_attitude_view_red_end;
                i3 = R.color.color_attitude_view_red_full;
            } else {
                i = R.color.color_attitude_view_yellow_start;
                i2 = R.color.color_attitude_view_yellow_end;
                i3 = R.color.color_attitude_view_yellow_full;
            }
        }
        this.gradientTop = (int) (this.mainRect.bottom - ((this.mainRect.height() * getYawPitchPercent()) / 100.0f));
        this.gradientPaint.setShader(new LinearGradient(this.mainRect.width() / 2.0f, this.gradientTop, this.mainRect.width() / 2.0f, this.mainRect.height(), new int[]{this.context.getResources().getColor(i2), this.context.getResources().getColor(i)}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
        calPosition();
        canvas.drawArc(this.mainRect, this.startAngel, this.sweepAngel, false, this.gradientPaint);
        this.topPaint.setColor(this.context.getResources().getColor(i3));
        canvas.drawRect(new RectF(this.topRect.left + getYawPitchTopPadding(), this.topRect.top, this.topRect.right - getYawPitchTopPadding(), this.topRect.bottom), this.topPaint);
        Path path = new Path();
        path.moveTo(this.topTriangle[0].x, this.topTriangle[0].y);
        path.lineTo(this.topTriangle[1].x, this.topTriangle[1].y);
        path.lineTo(this.topTriangle[2].x, this.topTriangle[2].y);
        path.close();
        canvas.drawPath(path, this.topPaint);
        canvas.rotate(-this.rotate, this.width / 2, this.height / 2);
    }

    private void calPosition() {
        double height = this.mainRect.height();
        double yawPitchPercent = (getYawPitchPercent() * height) / 100.0d;
        double d = height / 2.0d;
        if (yawPitchPercent > d) {
            DDLog.e(this.TAG, "attitude:1");
            double d2 = yawPitchPercent - d;
            double d3 = d * d;
            double d4 = d2 * d2;
            double sqrt = Math.sqrt(d3 - d4);
            int degrees = (int) (360.0d - (Math.toDegrees(Math.acos((((sqrt * sqrt) - d4) - d3) / (((-2.0d) * d2) * d))) * 2.0d));
            this.sweepAngel = degrees;
            this.startAngel = (-(degrees - 180)) / 2;
            this.topRect.left = (int) (this.mainRect.centerX() - sqrt);
            this.topRect.top = (int) ((this.mainRect.centerY() - d2) - (this.TOP_RECT_HEIGHT / 2.0f));
            this.topRect.right = (int) (this.mainRect.centerX() + sqrt);
            this.topRect.bottom = (int) ((this.mainRect.centerY() - d2) + (this.TOP_RECT_HEIGHT / 2.0f));
        } else if (yawPitchPercent < d) {
            DDLog.e(this.TAG, "attitude:2");
            double d5 = d - yawPitchPercent;
            double d6 = d * d;
            double d7 = d5 * d5;
            double sqrt2 = Math.sqrt(d6 - d7);
            int degrees2 = ((int) Math.toDegrees(Math.acos((((sqrt2 * sqrt2) - d7) - d6) / (((-2.0d) * d5) * d)))) * 2;
            this.sweepAngel = degrees2;
            this.startAngel = (180 - degrees2) / 2;
            this.topRect.left = (int) (this.mainRect.centerX() - sqrt2);
            this.topRect.top = (int) ((this.mainRect.centerY() + d5) - (this.TOP_RECT_HEIGHT / 2.0f));
            this.topRect.right = (int) (this.mainRect.centerX() + sqrt2);
            this.topRect.bottom = (int) (this.mainRect.centerY() + d5 + (this.TOP_RECT_HEIGHT / 2.0f));
        } else {
            DDLog.e(this.TAG, "attitude:3");
            this.sweepAngel = 180;
            this.startAngel = 0;
            this.topRect.left = (int) this.mainRect.left;
            this.topRect.top = (int) (this.mainRect.centerY() - (this.TOP_RECT_HEIGHT / 2.0f));
            this.topRect.right = (int) this.mainRect.right;
            this.topRect.bottom = (int) (this.mainRect.centerY() + (this.TOP_RECT_HEIGHT / 2.0f));
        }
        this.topRect.left += 2;
        this.topRect.right -= 2;
        this.topTriangle[0] = new Point(this.topRect.centerX(), this.topRect.top - this.TOP_TRIANGLE_HEIGHT);
        this.topTriangle[1] = new Point(this.topRect.centerX() - this.TOP_TRIANGLE_HEIGHT, this.topRect.top);
        this.topTriangle[2] = new Point(this.topRect.centerX() + this.TOP_TRIANGLE_HEIGHT, this.topRect.top);
    }
}
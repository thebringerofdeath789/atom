package com.ipotensic.kernel.view.attitude;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.TypedValue;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.utils.compress.BitmapUtil;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class Wind {
    private final Context context;
    private final Runnable drawRunnable;
    private final Handler handler;
    private final int height;
    private final Paint paint;
    private final int radius;
    private final Paint textPaint;
    private String txt;
    private final int width;
    private Bitmap windBitmap;
    private final String TAG = "wind";
    private int windSpeed = 0;
    private float windDegree = 0.0f;
    private boolean isConnect = false;
    private boolean isShow = false;
    private int rotate = 0;

    public Wind(Context context, int i, int i2) {
        Handler handler = new Handler();
        this.handler = handler;
        Runnable runnable = new Runnable() { // from class: com.ipotensic.kernel.view.attitude.Wind.1
            @Override // java.lang.Runnable
            public void run() {
                Wind.this.isShow = !r0.isShow;
                Wind.this.handler.postDelayed(this, 500L);
            }
        };
        this.drawRunnable = runnable;
        this.context = context;
        this.width = i;
        this.height = i2;
        this.windBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.icon_wind);
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), R.mipmap.img_bg_attitude_compass);
        this.radius = decodeResource.getWidth() >> 1;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.textPaint = paint2;
        paint2.setAntiAlias(true);
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setTextSize(dp2px());
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setColor(context.getResources().getColor(R.color.colorWhite));
        paint2.setTypeface(PhoneConfig.typeface);
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 500L);
        BitmapUtil.recycle(decodeResource);
    }

    public synchronized void draw(Canvas canvas) {
        Bitmap bitmap = this.windBitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            this.windBitmap = BitmapFactory.decodeResource(this.context.getResources(), R.mipmap.icon_wind);
        }
        if (this.txt != null && this.windSpeed >= 4 && this.isShow) {
            canvas.rotate(this.windDegree + 90.0f + this.rotate, this.width >> 1, this.height >> 1);
            canvas.drawBitmap(this.windBitmap, new Rect(0, 0, this.windBitmap.getWidth(), this.windBitmap.getHeight()), new Rect(0, 0, this.width, this.height), this.paint);
            canvas.rotate(-(this.windDegree + 90.0f + this.rotate), this.width >> 1, this.height >> 1);
            canvas.rotate(this.windDegree + this.rotate, this.width >> 1, this.height >> 1);
            canvas.translate(this.width >> 1, this.height >> 1);
            Rect rect = new Rect();
            Paint paint = this.textPaint;
            String str = this.txt;
            paint.getTextBounds(str, 0, str.length(), rect);
            Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
            float f = -(this.radius - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
            DDLog.e("wind", "baseLine = " + f);
            canvas.drawText(this.txt, 0.0f, f, this.textPaint);
            canvas.rotate(-(this.windDegree + this.rotate), this.width >> 1, this.height >> 1);
        }
    }

    public void setRotate(int i) {
        DDLog.e("wind", "rotate = " + i);
        this.rotate = i;
    }

    public void setConnect(boolean z) {
        this.isConnect = z;
        this.handler.removeCallbacks(this.drawRunnable);
        if (!z) {
            this.rotate = 0;
            this.windDegree = 0.0f;
            this.txt = null;
            this.windSpeed = 0;
            return;
        }
        this.handler.postDelayed(this.drawRunnable, 500L);
    }

    public void setWindSpeedAndDirection(int i, float f) {
        this.windSpeed = i;
        this.txt = this.windSpeed + "";
        this.windDegree = (float) ((180.0f * f) / 3.141592653589793d);
        DDLog.e("wind", "风速= " + i + ", 风向= " + f + ", windDegree = " + this.windDegree);
    }

    private int dp2px() {
        return (int) TypedValue.applyDimension(1, 10.0f, this.context.getResources().getDisplayMetrics());
    }

    public void release() {
        BitmapUtil.recycle(this.windBitmap);
        this.handler.removeCallbacks(this.drawRunnable);
    }
}

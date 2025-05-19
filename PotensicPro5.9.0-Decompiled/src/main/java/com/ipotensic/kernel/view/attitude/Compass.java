package com.ipotensic.kernel.view.attitude;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import com.ipotensic.baselib.utils.compress.BitmapUtil;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class Compass {
    private Bitmap compassBitmap;
    private Context context;
    private int height;
    private Paint paint;
    private int width;
    private final int PADDING = 0;
    private int rotateDegree = 0;
    private boolean isConnect = false;

    public Compass(Context context, int i, int i2) {
        this.context = context;
        this.width = i;
        this.height = i2;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
        this.compassBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.img_bg_attitude_compass);
    }

    public void setRotate(int i) {
        this.rotateDegree = i;
    }

    public void setConnect(boolean z) {
        this.isConnect = z;
        if (z) {
            return;
        }
        this.rotateDegree = 0;
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.compassBitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            this.compassBitmap = BitmapFactory.decodeResource(this.context.getResources(), R.mipmap.img_bg_attitude_compass);
        }
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.rotate(this.rotateDegree, this.width / 2, this.height / 2);
        canvas.drawBitmap(this.compassBitmap, new Rect(0, 0, this.compassBitmap.getWidth(), this.compassBitmap.getHeight()), new RectF(0.0f, 0.0f, this.width - 0, this.height - 0), this.paint);
        canvas.rotate(-this.rotateDegree, this.width / 2, this.height / 2);
    }

    public void release() {
        BitmapUtil.recycle(this.compassBitmap);
    }
}

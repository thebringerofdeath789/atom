package com.ipotensic.kernel.view.attitude;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public class GlobalBg {
    private float INTERVAL;
    private final float LINE_WIDTH = 0.4f;
    private float RADIUS;
    private Context context;
    private float height;
    private Paint paint;
    private float width;

    public GlobalBg(Context context, int i, int i2) {
        this.RADIUS = 8.0f;
        this.INTERVAL = 2.0f;
        this.context = context;
        float f = i;
        this.width = f;
        this.height = i2;
        float f2 = f / 8.8f;
        this.INTERVAL = f2;
        this.RADIUS = f2 * 4.0f;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
    }

    public float getRadius() {
        return this.RADIUS;
    }

    public void draw(Canvas canvas) {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.context.getResources().getColor(C1965R.color.color_attitude_view_bg));
        float f = this.width;
        canvas.drawCircle(f / 2.0f, this.height / 2.0f, f / 2.0f, this.paint);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setColor(this.context.getResources().getColor(C1965R.color.colorGray));
        this.paint.setStrokeWidth(0.4f);
        canvas.drawCircle(this.width / 2.0f, this.height / 2.0f, this.INTERVAL, this.paint);
        canvas.drawCircle(this.width / 2.0f, this.height / 2.0f, this.INTERVAL * 2.0f, this.paint);
        canvas.drawCircle(this.width / 2.0f, this.height / 2.0f, this.INTERVAL * 3.0f, this.paint);
        float f2 = this.width;
        float f3 = this.INTERVAL;
        float f4 = this.height;
        canvas.drawRect(new RectF((f2 / 2.0f) - (f3 * 4.0f), (f4 / 2.0f) + 0.2f, (f2 / 2.0f) + (f3 * 4.0f), (f4 / 2.0f) - 0.2f), this.paint);
        float f5 = this.width;
        float f6 = this.height;
        float f7 = this.INTERVAL;
        canvas.drawRect(new RectF((f5 / 2.0f) - 0.2f, (f6 / 2.0f) - (f7 * 4.0f), (f5 / 2.0f) + 0.2f, (f6 / 2.0f) + (f7 * 4.0f)), this.paint);
    }
}
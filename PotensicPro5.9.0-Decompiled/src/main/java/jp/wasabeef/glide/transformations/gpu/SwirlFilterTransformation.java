package jp.wasabeef.glide.transformations.gpu;

import android.content.Context;
import android.graphics.PointF;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import jp.co.cyberagent.android.gpuimage.GPUImageSwirlFilter;

/* loaded from: classes4.dex */
public class SwirlFilterTransformation extends GPUFilterTransformation {
    private float mAngle;
    private PointF mCenter;
    private float mRadius;

    public SwirlFilterTransformation(Context context) {
        this(context, Glide.get(context).getBitmapPool());
    }

    public SwirlFilterTransformation(Context context, BitmapPool bitmapPool) {
        this(context, bitmapPool, 0.5f, 1.0f, new PointF(0.5f, 0.5f));
    }

    public SwirlFilterTransformation(Context context, float f, float f2, PointF pointF) {
        this(context, Glide.get(context).getBitmapPool(), f, f2, pointF);
    }

    public SwirlFilterTransformation(Context context, BitmapPool bitmapPool, float f, float f2, PointF pointF) {
        super(context, bitmapPool, new GPUImageSwirlFilter());
        this.mRadius = f;
        this.mAngle = f2;
        this.mCenter = pointF;
        GPUImageSwirlFilter gPUImageSwirlFilter = (GPUImageSwirlFilter) getFilter();
        gPUImageSwirlFilter.setRadius(this.mRadius);
        gPUImageSwirlFilter.setAngle(this.mAngle);
        gPUImageSwirlFilter.setCenter(this.mCenter);
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, com.bumptech.glide.load.Transformation
    public String getId() {
        return "SwirlFilterTransformation(radius=" + this.mRadius + ",angle=" + this.mAngle + ",center=" + this.mCenter.toString() + ")";
    }
}

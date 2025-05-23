package jp.wasabeef.glide.transformations.gpu;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import jp.co.cyberagent.android.gpuimage.GPUImageBrightnessFilter;

/* loaded from: classes4.dex */
public class BrightnessFilterTransformation extends GPUFilterTransformation {
    private float mBrightness;

    public BrightnessFilterTransformation(Context context) {
        this(context, Glide.get(context).getBitmapPool());
    }

    public BrightnessFilterTransformation(Context context, BitmapPool bitmapPool) {
        this(context, bitmapPool, 0.0f);
    }

    public BrightnessFilterTransformation(Context context, float f) {
        this(context, Glide.get(context).getBitmapPool(), f);
    }

    public BrightnessFilterTransformation(Context context, BitmapPool bitmapPool, float f) {
        super(context, bitmapPool, new GPUImageBrightnessFilter());
        this.mBrightness = f;
        ((GPUImageBrightnessFilter) getFilter()).setBrightness(this.mBrightness);
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, com.bumptech.glide.load.Transformation
    public String getId() {
        return "BrightnessFilterTransformation(brightness=" + this.mBrightness + ")";
    }
}

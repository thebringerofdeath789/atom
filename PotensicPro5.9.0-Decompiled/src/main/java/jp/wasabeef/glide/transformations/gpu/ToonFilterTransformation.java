package jp.wasabeef.glide.transformations.gpu;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import jp.co.cyberagent.android.gpuimage.GPUImageToonFilter;

/* loaded from: classes4.dex */
public class ToonFilterTransformation extends GPUFilterTransformation {
    private float mQuantizationLevels;
    private float mThreshold;

    public ToonFilterTransformation(Context context) {
        this(context, Glide.get(context).getBitmapPool());
    }

    public ToonFilterTransformation(Context context, BitmapPool bitmapPool) {
        this(context, bitmapPool, 0.2f, 10.0f);
    }

    public ToonFilterTransformation(Context context, float f, float f2) {
        this(context, Glide.get(context).getBitmapPool(), f, f2);
    }

    public ToonFilterTransformation(Context context, BitmapPool bitmapPool, float f, float f2) {
        super(context, bitmapPool, new GPUImageToonFilter());
        this.mThreshold = f;
        this.mQuantizationLevels = f2;
        GPUImageToonFilter gPUImageToonFilter = (GPUImageToonFilter) getFilter();
        gPUImageToonFilter.setThreshold(this.mThreshold);
        gPUImageToonFilter.setQuantizationLevels(this.mQuantizationLevels);
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, com.bumptech.glide.load.Transformation
    public String getId() {
        return "ToonFilterTransformation(threshold=" + this.mThreshold + ",quantizationLevels=" + this.mQuantizationLevels + ")";
    }
}

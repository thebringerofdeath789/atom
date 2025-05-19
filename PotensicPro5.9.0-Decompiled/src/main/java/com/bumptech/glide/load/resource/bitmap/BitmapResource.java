package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.util.Objects;

/* loaded from: classes.dex */
public class BitmapResource implements Resource<Bitmap> {
    private final Bitmap bitmap;
    private final BitmapPool bitmapPool;

    public static BitmapResource obtain(Bitmap bitmap, BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapResource(bitmap, bitmapPool);
    }

    public BitmapResource(Bitmap bitmap, BitmapPool bitmapPool) {
        Objects.requireNonNull(bitmap, "Bitmap must not be null");
        Objects.requireNonNull(bitmapPool, "BitmapPool must not be null");
        this.bitmap = bitmap;
        this.bitmapPool = bitmapPool;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.Resource
    public Bitmap get() {
        return this.bitmap;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return Util.getBitmapByteSize(this.bitmap);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        if (this.bitmapPool.put(this.bitmap)) {
            return;
        }
        this.bitmap.recycle();
    }
}

package com.bumptech.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class GifBitmapWrapperResourceEncoder implements ResourceEncoder<GifBitmapWrapper> {
    private final ResourceEncoder<Bitmap> bitmapEncoder;
    private final ResourceEncoder<GifDrawable> gifEncoder;

    /* renamed from: id */
    private String f1817id;

    public GifBitmapWrapperResourceEncoder(ResourceEncoder<Bitmap> resourceEncoder, ResourceEncoder<GifDrawable> resourceEncoder2) {
        this.bitmapEncoder = resourceEncoder;
        this.gifEncoder = resourceEncoder2;
    }

    @Override // com.bumptech.glide.load.Encoder
    public boolean encode(Resource<GifBitmapWrapper> resource, OutputStream outputStream) {
        GifBitmapWrapper gifBitmapWrapper = resource.get();
        Resource<Bitmap> bitmapResource = gifBitmapWrapper.getBitmapResource();
        if (bitmapResource != null) {
            return this.bitmapEncoder.encode(bitmapResource, outputStream);
        }
        return this.gifEncoder.encode(gifBitmapWrapper.getGifResource(), outputStream);
    }

    @Override // com.bumptech.glide.load.Encoder
    public String getId() {
        if (this.f1817id == null) {
            this.f1817id = this.bitmapEncoder.getId() + this.gifEncoder.getId();
        }
        return this.f1817id;
    }
}
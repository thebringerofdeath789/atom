package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class BitmapImageViewTarget extends ImageViewTarget<Bitmap> {
    public BitmapImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget
    protected void setResource(Bitmap bitmap) {
        ((ImageView) this.view).setImageBitmap(bitmap);
    }
}
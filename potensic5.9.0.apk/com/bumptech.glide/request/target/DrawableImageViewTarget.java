package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class DrawableImageViewTarget extends ImageViewTarget<Drawable> {
    public DrawableImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget
    protected void setResource(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }
}
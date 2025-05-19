package com.squareup.picasso;

import android.graphics.Bitmap;

/* loaded from: classes3.dex */
public interface Transformation {
    String key();

    Bitmap transform(Bitmap bitmap);
}

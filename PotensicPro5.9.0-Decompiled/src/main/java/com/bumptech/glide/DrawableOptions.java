package com.bumptech.glide;

import android.view.animation.Animation;

/* loaded from: classes.dex */
interface DrawableOptions {
    GenericRequestBuilder<?, ?, ?, ?> crossFade();

    GenericRequestBuilder<?, ?, ?, ?> crossFade(int i);

    GenericRequestBuilder<?, ?, ?, ?> crossFade(int i, int i2);

    @Deprecated
    GenericRequestBuilder<?, ?, ?, ?> crossFade(Animation animation, int i);
}

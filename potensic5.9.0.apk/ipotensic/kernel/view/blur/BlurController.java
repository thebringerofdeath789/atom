package com.ipotensic.kernel.view.blur;

import android.graphics.Canvas;

/* loaded from: classes2.dex */
public interface BlurController extends BlurViewFacade {
    public static final float DEFAULT_BLUR_RADIUS = 16.0f;
    public static final float DEFAULT_SCALE_FACTOR = 6.0f;

    void destroy();

    boolean draw(Canvas canvas);

    void updateBlurViewSize();
}
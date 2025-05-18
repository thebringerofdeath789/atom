package com.camera.listener;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public interface JCameraListener {
    void captureSuccess(Bitmap bitmap);

    void recordSuccess(String str, Bitmap bitmap);
}
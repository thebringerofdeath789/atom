package com.camera.listener;

/* loaded from: classes.dex */
public interface CaptureListener {
    void recordEnd(long j);

    void recordError();

    void recordShort(long j);

    void recordStart();

    void recordZoom(float f);

    void takePictures();
}

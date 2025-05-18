package com.logan.nativeapp;

import android.view.Surface;

/* loaded from: classes3.dex */
public abstract class BaseDecoder {
    public abstract int getHeight();

    public abstract int getWidth();

    public abstract void onReceiveFrame(Frame frame);

    public abstract void startPreview(Surface surface);

    public abstract void stopPreview();

    public void onReceiveH264(byte[] bArr) {
        onReceiveFrame(new Frame(bArr));
    }
}
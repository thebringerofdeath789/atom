package com.ipotensic.baselib.okhttp;

/* loaded from: classes2.dex */
public interface OnUploadProgressListener {
    void onEnd();

    void onError(Exception exc);

    void onProgress(float f, long j);

    void onStart();
}

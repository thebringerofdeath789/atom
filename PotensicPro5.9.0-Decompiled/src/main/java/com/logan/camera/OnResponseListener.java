package com.logan.camera;

/* loaded from: classes2.dex */
public interface OnResponseListener<T> {
    void onRequestFailed(int i, Exception exc);

    void onRequestSuccess(int i, T t);
}

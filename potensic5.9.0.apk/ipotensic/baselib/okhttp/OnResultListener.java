package com.ipotensic.baselib.okhttp;

/* loaded from: classes2.dex */
public interface OnResultListener<T> {
    void onFailed(Exception exc);

    void onSuccess(T t);
}
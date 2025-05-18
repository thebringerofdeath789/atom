package com.ipotensic.baselib.okhttp;

/* loaded from: classes2.dex */
public interface DownloadListener {
    void notEnoughSpace();

    void onDownloadEnd(String str);

    void onDownloadEnd(String str, String str2);

    void onDownloadError(Exception exc);

    void onDownloadProgress(float f, long j);

    void onDownloadStart();
}
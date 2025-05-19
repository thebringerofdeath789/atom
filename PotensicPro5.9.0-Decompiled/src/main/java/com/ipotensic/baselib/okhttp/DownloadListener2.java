package com.ipotensic.baselib.okhttp;

/* loaded from: classes2.dex */
public interface DownloadListener2 {
    void onDownloadEnd(String str, String str2, String str3);

    void onDownloadError(Exception exc);

    void onDownloadFinished();

    void onDownloadProgress(long j);

    void onDownloadStart(long j);
}

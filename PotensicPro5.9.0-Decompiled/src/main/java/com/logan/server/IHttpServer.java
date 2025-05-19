package com.logan.server;

import com.ipotensic.baselib.okhttp.OnResultListener;

/* loaded from: classes3.dex */
public interface IHttpServer {
    void execute(OnResultListener onResultListener);

    boolean isKeepRunning();

    void setKeepRunning(boolean z);

    String setPath(String str);

    void stopStream();
}

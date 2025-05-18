package com.ipotensic.baselib.netty.listener;

/* loaded from: classes2.dex */
public interface OnSocketListener {
    void onConnectFailed(String str);

    void onConnected();

    void onDisconnected();

    void onException(Throwable th);

    void onResponse(byte[] bArr);
}
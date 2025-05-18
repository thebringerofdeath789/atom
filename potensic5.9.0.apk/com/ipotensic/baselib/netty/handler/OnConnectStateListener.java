package com.ipotensic.baselib.netty.handler;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public interface OnConnectStateListener<T> {
    public static final int STATUS_CONNECT_CLOSED = 0;
    public static final int STATUS_CONNECT_ERROR = -1;
    public static final int STATUS_CONNECT_SUCCESS = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectState {
    }

    void onClientStatusConnectChanged(int i);

    void onMessageResponseClient(T t);
}
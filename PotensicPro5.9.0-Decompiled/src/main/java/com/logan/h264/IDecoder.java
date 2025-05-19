package com.logan.h264;

import com.ipotensic.baselib.okhttp.OnResultListener;

/* loaded from: classes.dex */
public abstract class IDecoder extends Thread {
    public abstract void decode(byte[] bArr);

    public abstract boolean isStart();

    public abstract void release(OnResultListener<Boolean> onResultListener);
}

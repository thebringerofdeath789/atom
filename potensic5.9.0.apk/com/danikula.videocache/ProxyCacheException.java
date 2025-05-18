package com.danikula.videocache;

/* loaded from: classes.dex */
public class ProxyCacheException extends Exception {
    public ProxyCacheException(String str) {
        super(str);
    }

    public ProxyCacheException(String str, Throwable th) {
        super(str, th);
    }

    public ProxyCacheException(Throwable th) {
        super("No explanation error", th);
    }
}
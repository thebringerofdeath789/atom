package com.ipotensic.baselib.utils;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomHandlerThread.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/ipotensic/baselib/utils/CustomHandlerThread;", "", "name", "", "callback", "Landroid/os/Handler$Callback;", "(Ljava/lang/String;Landroid/os/Handler$Callback;)V", "getCallback", "()Landroid/os/Handler$Callback;", "handler", "Landroid/os/Handler;", "handlerThread", "Landroid/os/HandlerThread;", "getName", "()Ljava/lang/String;", "getHandler", "quit", "", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class CustomHandlerThread {
    private final Handler.Callback callback;
    private Handler handler;
    private HandlerThread handlerThread;
    private final String name;

    public CustomHandlerThread(String name, Handler.Callback callback) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this.name = name;
        this.callback = callback;
        HandlerThread handlerThread = new HandlerThread(name);
        this.handlerThread = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.handlerThread.getLooper(), callback);
    }

    public final Handler.Callback getCallback() {
        return this.callback;
    }

    public final String getName() {
        return this.name;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final void quit() {
        this.handlerThread.quitSafely();
    }
}
package io.netty.util.concurrent;

/* loaded from: classes4.dex */
public interface RejectedExecutionHandler {
    void rejected(Runnable runnable, SingleThreadEventExecutor singleThreadEventExecutor);
}

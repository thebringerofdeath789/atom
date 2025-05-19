package io.netty.util.concurrent;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes4.dex */
public final class ThreadPerTaskExecutor implements Executor {
    private final ThreadFactory threadFactory;

    public ThreadPerTaskExecutor(ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory");
        this.threadFactory = threadFactory;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.threadFactory.newThread(runnable).start();
    }
}

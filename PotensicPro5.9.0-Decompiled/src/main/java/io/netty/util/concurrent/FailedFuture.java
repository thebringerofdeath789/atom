package io.netty.util.concurrent;

import io.netty.util.internal.PlatformDependent;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class FailedFuture<V> extends CompleteFuture<V> {
    private final Throwable cause;

    @Override // io.netty.util.concurrent.Future
    public V getNow() {
        return null;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return false;
    }

    public FailedFuture(EventExecutor eventExecutor, Throwable th) {
        super(eventExecutor);
        Objects.requireNonNull(th, "cause");
        this.cause = th;
    }

    @Override // io.netty.util.concurrent.Future
    public Throwable cause() {
        return this.cause;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<V> sync() {
        PlatformDependent.throwException(this.cause);
        return this;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<V> syncUninterruptibly() {
        PlatformDependent.throwException(this.cause);
        return this;
    }
}

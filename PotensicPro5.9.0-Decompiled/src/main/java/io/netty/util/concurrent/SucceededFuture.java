package io.netty.util.concurrent;

/* loaded from: classes4.dex */
public final class SucceededFuture<V> extends CompleteFuture<V> {
    private final V result;

    @Override // io.netty.util.concurrent.Future
    public Throwable cause() {
        return null;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return true;
    }

    public SucceededFuture(EventExecutor eventExecutor, V v) {
        super(eventExecutor);
        this.result = v;
    }

    @Override // io.netty.util.concurrent.Future
    public V getNow() {
        return this.result;
    }
}

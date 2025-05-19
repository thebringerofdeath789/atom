package io.netty.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes4.dex */
class PromiseTask<V> extends DefaultPromise<V> implements RunnableFuture<V> {
    protected final Callable<V> task;

    public final boolean equals(Object obj) {
        return this == obj;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public final boolean tryFailure(Throwable th) {
        return false;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public final boolean trySuccess(V v) {
        return false;
    }

    static <T> Callable<T> toCallable(Runnable runnable, T t) {
        return new RunnableAdapter(runnable, t);
    }

    private static final class RunnableAdapter<T> implements Callable<T> {
        final T result;
        final Runnable task;

        RunnableAdapter(Runnable runnable, T t) {
            this.task = runnable;
            this.result = t;
        }

        @Override // java.util.concurrent.Callable
        public T call() {
            this.task.run();
            return this.result;
        }

        public String toString() {
            return "Callable(task: " + this.task + ", result: " + this.result + PropertyUtils.MAPPED_DELIM2;
        }
    }

    PromiseTask(EventExecutor eventExecutor, Runnable runnable, V v) {
        this(eventExecutor, toCallable(runnable, v));
    }

    PromiseTask(EventExecutor eventExecutor, Callable<V> callable) {
        super(eventExecutor);
        this.task = callable;
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        try {
            if (setUncancellableInternal()) {
                setSuccessInternal(this.task.call());
            }
        } catch (Throwable th) {
            setFailureInternal(th);
        }
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
    public final Promise<V> setFailure(Throwable th) {
        throw new IllegalStateException();
    }

    protected final Promise<V> setFailureInternal(Throwable th) {
        super.setFailure(th);
        return this;
    }

    protected final boolean tryFailureInternal(Throwable th) {
        return super.tryFailure(th);
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.ProgressivePromise
    public final Promise<V> setSuccess(V v) {
        throw new IllegalStateException();
    }

    protected final Promise<V> setSuccessInternal(V v) {
        super.setSuccess(v);
        return this;
    }

    protected final boolean trySuccessInternal(V v) {
        return super.trySuccess(v);
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public final boolean setUncancellable() {
        throw new IllegalStateException();
    }

    protected final boolean setUncancellableInternal() {
        return super.setUncancellable();
    }

    @Override // io.netty.util.concurrent.DefaultPromise
    protected StringBuilder toStringBuilder() {
        StringBuilder stringBuilder = super.toStringBuilder();
        stringBuilder.setCharAt(stringBuilder.length() - 1, ',');
        return stringBuilder.append(" task: ").append(this.task).append(PropertyUtils.MAPPED_DELIM2);
    }
}

package io.netty.channel;

import io.netty.util.concurrent.CompleteFuture;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.Objects;

/* loaded from: classes3.dex */
abstract class CompleteChannelFuture extends CompleteFuture<Void> implements ChannelFuture {
    private final Channel channel;

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<Void> await() throws InterruptedException {
        return this;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<Void> awaitUninterruptibly() {
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Void getNow() {
        return null;
    }

    @Override // io.netty.channel.ChannelFuture
    public boolean isVoid() {
        return false;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<Void> sync() throws InterruptedException {
        return this;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<Void> syncUninterruptibly() {
        return this;
    }

    protected CompleteChannelFuture(Channel channel, EventExecutor eventExecutor) {
        super(eventExecutor);
        Objects.requireNonNull(channel, "channel");
        this.channel = channel;
    }

    @Override // io.netty.util.concurrent.CompleteFuture
    protected EventExecutor executor() {
        EventExecutor executor = super.executor();
        return executor == null ? channel().eventLoop() : executor;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<Void> addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        super.addListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<Void> addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        super.addListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<Void> removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        super.removeListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<Void> removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        super.removeListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    @Override // io.netty.channel.ChannelFuture
    public Channel channel() {
        return this.channel;
    }
}

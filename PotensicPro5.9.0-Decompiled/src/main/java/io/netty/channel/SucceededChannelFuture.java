package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;

/* loaded from: classes3.dex */
final class SucceededChannelFuture extends CompleteChannelFuture {
    @Override // io.netty.util.concurrent.Future
    public Throwable cause() {
        return null;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return true;
    }

    SucceededChannelFuture(Channel channel, EventExecutor eventExecutor) {
        super(channel, eventExecutor);
    }
}

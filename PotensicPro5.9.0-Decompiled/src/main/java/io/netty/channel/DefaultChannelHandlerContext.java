package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;
import java.util.Objects;

/* loaded from: classes3.dex */
final class DefaultChannelHandlerContext extends AbstractChannelHandlerContext {
    private final ChannelHandler handler;

    DefaultChannelHandlerContext(DefaultChannelPipeline defaultChannelPipeline, EventExecutor eventExecutor, String str, ChannelHandler channelHandler) {
        super(defaultChannelPipeline, eventExecutor, str, isInbound(channelHandler), isOutbound(channelHandler));
        Objects.requireNonNull(channelHandler, "handler");
        this.handler = channelHandler;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandler handler() {
        return this.handler;
    }

    private static boolean isInbound(ChannelHandler channelHandler) {
        return channelHandler instanceof ChannelInboundHandler;
    }

    private static boolean isOutbound(ChannelHandler channelHandler) {
        return channelHandler instanceof ChannelOutboundHandler;
    }
}

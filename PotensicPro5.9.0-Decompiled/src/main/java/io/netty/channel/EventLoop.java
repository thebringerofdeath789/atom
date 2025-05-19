package io.netty.channel;

import io.netty.util.concurrent.OrderedEventExecutor;

/* loaded from: classes3.dex */
public interface EventLoop extends OrderedEventExecutor, EventLoopGroup {
    EventLoopGroup parent();
}

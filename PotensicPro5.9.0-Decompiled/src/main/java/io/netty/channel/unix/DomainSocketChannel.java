package io.netty.channel.unix;

import io.netty.channel.socket.DuplexChannel;

/* loaded from: classes3.dex */
public interface DomainSocketChannel extends UnixChannel, DuplexChannel {
    @Override // io.netty.channel.Channel
    DomainSocketChannelConfig config();

    @Override // io.netty.channel.Channel
    DomainSocketAddress localAddress();

    @Override // io.netty.channel.Channel
    DomainSocketAddress remoteAddress();
}

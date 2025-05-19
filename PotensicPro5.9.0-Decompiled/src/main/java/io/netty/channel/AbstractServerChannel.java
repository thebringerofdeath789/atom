package io.netty.channel;

import io.netty.channel.AbstractChannel;
import java.net.SocketAddress;

/* loaded from: classes3.dex */
public abstract class AbstractServerChannel extends AbstractChannel implements ServerChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public SocketAddress remoteAddress() {
        return null;
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return null;
    }

    protected AbstractServerChannel() {
        super(null);
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.AbstractChannel
    protected AbstractChannel.AbstractUnsafe newUnsafe() {
        return new DefaultServerUnsafe();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.AbstractChannel
    protected final Object filterOutboundMessage(Object obj) {
        throw new UnsupportedOperationException();
    }

    private final class DefaultServerUnsafe extends AbstractChannel.AbstractUnsafe {
        private DefaultServerUnsafe() {
            super();
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            safeSetFailure(channelPromise, new UnsupportedOperationException());
        }
    }
}

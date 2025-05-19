package io.netty.channel.kqueue;

import io.netty.channel.Channel;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoop;
import io.netty.channel.ServerChannel;
import io.netty.channel.kqueue.AbstractKQueueChannel;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* loaded from: classes3.dex */
public abstract class AbstractKQueueServerChannel extends AbstractKQueueChannel implements ServerChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);

    abstract Channel newChildChannel(int i, byte[] bArr, int i2, int i3) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public InetSocketAddress remoteAddress0() {
        return null;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isActive() {
        return super.isActive();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    AbstractKQueueServerChannel(BsdSocket bsdSocket) {
        this(bsdSocket, isSoErrorZero(bsdSocket));
    }

    AbstractKQueueServerChannel(BsdSocket bsdSocket, boolean z) {
        super((Channel) null, bsdSocket, z);
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof KQueueEventLoop;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueServerSocketUnsafe();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel
    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        throw new UnsupportedOperationException();
    }

    final class KQueueServerSocketUnsafe extends AbstractKQueueChannel.AbstractKQueueUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final byte[] acceptedAddress;

        KQueueServerSocketUnsafe() {
            super();
            this.acceptedAddress = new byte[26];
        }

        @Override // io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe
        void readReady(KQueueRecvByteAllocatorHandle kQueueRecvByteAllocatorHandle) {
            KQueueChannelConfig config = AbstractKQueueServerChannel.this.config();
            if (AbstractKQueueServerChannel.this.shouldBreakReadReady(config)) {
                clearReadFilter0();
                return;
            }
            ChannelPipeline pipeline = AbstractKQueueServerChannel.this.pipeline();
            kQueueRecvByteAllocatorHandle.reset(config);
            kQueueRecvByteAllocatorHandle.attemptedBytesRead(1);
            readReadyBefore();
            Throwable th = null;
            do {
                try {
                    int accept = AbstractKQueueServerChannel.this.socket.accept(this.acceptedAddress);
                    if (accept == -1) {
                        kQueueRecvByteAllocatorHandle.lastBytesRead(-1);
                        break;
                    }
                    kQueueRecvByteAllocatorHandle.lastBytesRead(1);
                    kQueueRecvByteAllocatorHandle.incMessagesRead(1);
                    this.readPending = false;
                    AbstractKQueueServerChannel abstractKQueueServerChannel = AbstractKQueueServerChannel.this;
                    byte[] bArr = this.acceptedAddress;
                    pipeline.fireChannelRead((Object) abstractKQueueServerChannel.newChildChannel(accept, bArr, 1, bArr[0]));
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (kQueueRecvByteAllocatorHandle.continueReading());
            try {
                kQueueRecvByteAllocatorHandle.readComplete();
                pipeline.fireChannelReadComplete();
                if (th != null) {
                    pipeline.fireExceptionCaught(th);
                }
            } finally {
                readReadyFinally(config);
            }
        }
    }
}

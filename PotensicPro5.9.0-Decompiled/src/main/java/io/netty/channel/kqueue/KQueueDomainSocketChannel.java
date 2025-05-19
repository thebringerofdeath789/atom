package io.netty.channel.kqueue;

import io.netty.channel.Channel;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.kqueue.AbstractKQueueChannel;
import io.netty.channel.kqueue.AbstractKQueueStreamChannel;
import io.netty.channel.unix.DomainSocketAddress;
import io.netty.channel.unix.DomainSocketChannel;
import io.netty.channel.unix.DomainSocketReadMode;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.PeerCredentials;
import java.io.IOException;
import java.net.SocketAddress;

/* loaded from: classes3.dex */
public final class KQueueDomainSocketChannel extends AbstractKQueueStreamChannel implements DomainSocketChannel {
    private final KQueueDomainSocketChannelConfig config;
    private volatile DomainSocketAddress local;
    private volatile DomainSocketAddress remote;

    public KQueueDomainSocketChannel() {
        super((Channel) null, BsdSocket.newSocketDomain(), false);
        this.config = new KQueueDomainSocketChannelConfig(this);
    }

    public KQueueDomainSocketChannel(int i) {
        this(null, new BsdSocket(i));
    }

    KQueueDomainSocketChannel(Channel channel, BsdSocket bsdSocket) {
        super(channel, bsdSocket, true);
        this.config = new KQueueDomainSocketChannelConfig(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.kqueue.AbstractKQueueStreamChannel, io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueDomainUnsafe(this, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public DomainSocketAddress localAddress0() {
        return this.local;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public DomainSocketAddress remoteAddress0() {
        return this.remote;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        this.socket.bind(socketAddress);
        this.local = (DomainSocketAddress) socketAddress;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public KQueueDomainSocketChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel
    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (!super.doConnect(socketAddress, socketAddress2)) {
            return false;
        }
        this.local = (DomainSocketAddress) socketAddress2;
        this.remote = (DomainSocketAddress) socketAddress;
        return true;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public DomainSocketAddress remoteAddress() {
        return (DomainSocketAddress) super.remoteAddress();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public DomainSocketAddress localAddress() {
        return (DomainSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueStreamChannel
    protected int doWriteSingle(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        Object current = channelOutboundBuffer.current();
        if ((current instanceof FileDescriptor) && this.socket.sendFd(((FileDescriptor) current).intValue()) > 0) {
            channelOutboundBuffer.remove();
            return 1;
        }
        return super.doWriteSingle(channelOutboundBuffer);
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueStreamChannel, io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object obj) {
        return obj instanceof FileDescriptor ? obj : super.filterOutboundMessage(obj);
    }

    public PeerCredentials peerCredentials() throws IOException {
        return this.socket.getPeerCredentials();
    }

    private final class KQueueDomainUnsafe extends AbstractKQueueStreamChannel.KQueueStreamUnsafe {
        private KQueueDomainUnsafe() {
            super();
        }

        /* synthetic */ KQueueDomainUnsafe(KQueueDomainSocketChannel kQueueDomainSocketChannel, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.netty.channel.kqueue.AbstractKQueueStreamChannel.KQueueStreamUnsafe, io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe
        void readReady(KQueueRecvByteAllocatorHandle kQueueRecvByteAllocatorHandle) {
            int i = AnonymousClass1.$SwitchMap$io$netty$channel$unix$DomainSocketReadMode[KQueueDomainSocketChannel.this.config().getReadMode().ordinal()];
            if (i == 1) {
                super.readReady(kQueueRecvByteAllocatorHandle);
            } else {
                if (i == 2) {
                    readReadyFd();
                    return;
                }
                throw new Error();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
        
            r1.readComplete();
            r2.fireChannelReadComplete();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void readReadyFd() {
            /*
                r6 = this;
                io.netty.channel.kqueue.KQueueDomainSocketChannel r0 = io.netty.channel.kqueue.KQueueDomainSocketChannel.this
                io.netty.channel.kqueue.BsdSocket r0 = r0.socket
                boolean r0 = r0.isInputShutdown()
                if (r0 == 0) goto Le
                super.clearReadFilter0()
                return
            Le:
                io.netty.channel.kqueue.KQueueDomainSocketChannel r0 = io.netty.channel.kqueue.KQueueDomainSocketChannel.this
                io.netty.channel.kqueue.KQueueDomainSocketChannelConfig r0 = r0.config()
                io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle r1 = r6.recvBufAllocHandle()
                io.netty.channel.kqueue.KQueueDomainSocketChannel r2 = io.netty.channel.kqueue.KQueueDomainSocketChannel.this
                io.netty.channel.ChannelPipeline r2 = r2.pipeline()
                r1.reset(r0)
                r6.readReadyBefore()
            L24:
                io.netty.channel.kqueue.KQueueDomainSocketChannel r3 = io.netty.channel.kqueue.KQueueDomainSocketChannel.this     // Catch: java.lang.Throwable -> L62
                io.netty.channel.kqueue.BsdSocket r3 = r3.socket     // Catch: java.lang.Throwable -> L62
                int r3 = r3.recvFd()     // Catch: java.lang.Throwable -> L62
                r4 = -1
                if (r3 == r4) goto L54
                r4 = 0
                if (r3 == 0) goto L4a
                r5 = 1
                r1.lastBytesRead(r5)     // Catch: java.lang.Throwable -> L62
                r1.incMessagesRead(r5)     // Catch: java.lang.Throwable -> L62
                r6.readPending = r4     // Catch: java.lang.Throwable -> L62
                io.netty.channel.unix.FileDescriptor r4 = new io.netty.channel.unix.FileDescriptor     // Catch: java.lang.Throwable -> L62
                r4.<init>(r3)     // Catch: java.lang.Throwable -> L62
                r2.fireChannelRead(r4)     // Catch: java.lang.Throwable -> L62
                boolean r3 = r1.continueReading()     // Catch: java.lang.Throwable -> L62
                if (r3 != 0) goto L24
                goto L4d
            L4a:
                r1.lastBytesRead(r4)     // Catch: java.lang.Throwable -> L62
            L4d:
                r1.readComplete()     // Catch: java.lang.Throwable -> L62
                r2.fireChannelReadComplete()     // Catch: java.lang.Throwable -> L62
                goto L6c
            L54:
                r1.lastBytesRead(r4)     // Catch: java.lang.Throwable -> L62
                io.netty.channel.ChannelPromise r3 = r6.voidPromise()     // Catch: java.lang.Throwable -> L62
                r6.close(r3)     // Catch: java.lang.Throwable -> L62
                r6.readReadyFinally(r0)
                return
            L62:
                r3 = move-exception
                r1.readComplete()     // Catch: java.lang.Throwable -> L70
                r2.fireChannelReadComplete()     // Catch: java.lang.Throwable -> L70
                r2.fireExceptionCaught(r3)     // Catch: java.lang.Throwable -> L70
            L6c:
                r6.readReadyFinally(r0)
                return
            L70:
                r1 = move-exception
                r6.readReadyFinally(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.kqueue.KQueueDomainSocketChannel.KQueueDomainUnsafe.readReadyFd():void");
        }
    }

    /* renamed from: io.netty.channel.kqueue.KQueueDomainSocketChannel$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$channel$unix$DomainSocketReadMode;

        static {
            int[] iArr = new int[DomainSocketReadMode.values().length];
            $SwitchMap$io$netty$channel$unix$DomainSocketReadMode = iArr;
            try {
                iArr[DomainSocketReadMode.BYTES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$channel$unix$DomainSocketReadMode[DomainSocketReadMode.FILE_DESCRIPTORS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}

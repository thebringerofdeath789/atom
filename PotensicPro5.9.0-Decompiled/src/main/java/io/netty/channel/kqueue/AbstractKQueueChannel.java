package io.netty.channel.kqueue;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.EventLoop;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.UnixChannel;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.UnresolvedAddressException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes3.dex */
abstract class AbstractKQueueChannel extends AbstractChannel implements UnixChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    protected volatile boolean active;
    private ChannelPromise connectPromise;
    private ScheduledFuture<?> connectTimeoutFuture;
    boolean inputClosedSeenErrorOnRead;
    long jniSelfPtr;
    private volatile SocketAddress local;
    private boolean readFilterEnabled;
    boolean readReadyRunnablePending;
    private volatile SocketAddress remote;
    private SocketAddress requestedRemoteAddress;
    final BsdSocket socket;
    private boolean writeFilterEnabled;

    @Override // io.netty.channel.Channel
    public abstract KQueueChannelConfig config();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public abstract AbstractKQueueUnsafe newUnsafe();

    AbstractKQueueChannel(Channel channel, BsdSocket bsdSocket, boolean z) {
        this(channel, bsdSocket, z, false);
    }

    AbstractKQueueChannel(Channel channel, BsdSocket bsdSocket, boolean z, boolean z2) {
        super(channel);
        this.readFilterEnabled = true;
        this.socket = (BsdSocket) ObjectUtil.checkNotNull(bsdSocket, IjkMediaPlayer.OnNativeInvokeListener.ARG_FD);
        this.active = z;
        this.writeFilterEnabled = z2;
        if (z) {
            this.local = bsdSocket.localAddress();
            this.remote = bsdSocket.remoteAddress();
        }
    }

    AbstractKQueueChannel(Channel channel, BsdSocket bsdSocket, SocketAddress socketAddress) {
        super(channel);
        this.readFilterEnabled = true;
        this.socket = (BsdSocket) ObjectUtil.checkNotNull(bsdSocket, IjkMediaPlayer.OnNativeInvokeListener.ARG_FD);
        this.active = true;
        this.remote = socketAddress;
        this.local = bsdSocket.localAddress();
    }

    static boolean isSoErrorZero(BsdSocket bsdSocket) {
        try {
            return bsdSocket.getSoError() == 0;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.channel.unix.UnixChannel
    public final FileDescriptor fd() {
        return this.socket;
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        return this.active;
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        this.active = false;
        this.inputClosedSeenErrorOnRead = true;
        try {
            if (isRegistered()) {
                EventLoop eventLoop = eventLoop();
                if (eventLoop.inEventLoop()) {
                    doDeregister();
                } else {
                    eventLoop.execute(new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueChannel.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AbstractKQueueChannel.this.doDeregister();
                            } catch (Throwable th) {
                                AbstractKQueueChannel.this.pipeline().fireExceptionCaught(th);
                            }
                        }
                    });
                }
            }
        } finally {
            this.socket.close();
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        doClose();
    }

    @Override // io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof KQueueEventLoop;
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return this.socket.isOpen();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDeregister() throws Exception {
        readFilter(false);
        writeFilter(false);
        evSet0(Native.EVFILT_SOCK, Native.EV_DELETE, 0);
        ((KQueueEventLoop) eventLoop()).remove(this);
        this.readFilterEnabled = true;
    }

    @Override // io.netty.channel.AbstractChannel
    protected final void doBeginRead() throws Exception {
        AbstractKQueueUnsafe abstractKQueueUnsafe = (AbstractKQueueUnsafe) unsafe();
        abstractKQueueUnsafe.readPending = true;
        readFilter(true);
        if (abstractKQueueUnsafe.maybeMoreDataToRead) {
            abstractKQueueUnsafe.executeReadReadyRunnable(config());
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doRegister() throws Exception {
        this.readReadyRunnablePending = false;
        if (this.writeFilterEnabled) {
            evSet0(Native.EVFILT_WRITE, Native.EV_ADD_CLEAR_ENABLE);
        }
        if (this.readFilterEnabled) {
            evSet0(Native.EVFILT_READ, Native.EV_ADD_CLEAR_ENABLE);
        }
        evSet0(Native.EVFILT_SOCK, Native.EV_ADD, Native.NOTE_RDHUP);
    }

    protected final ByteBuf newDirectBuffer(ByteBuf byteBuf) {
        return newDirectBuffer(byteBuf, byteBuf);
    }

    protected final ByteBuf newDirectBuffer(Object obj, ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            ReferenceCountUtil.release(obj);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator alloc = alloc();
        if (alloc.isDirectBufferPooled()) {
            return newDirectBuffer0(obj, byteBuf, alloc, readableBytes);
        }
        ByteBuf threadLocalDirectBuffer = ByteBufUtil.threadLocalDirectBuffer();
        if (threadLocalDirectBuffer == null) {
            return newDirectBuffer0(obj, byteBuf, alloc, readableBytes);
        }
        threadLocalDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
        ReferenceCountUtil.safeRelease(obj);
        return threadLocalDirectBuffer;
    }

    private static ByteBuf newDirectBuffer0(Object obj, ByteBuf byteBuf, ByteBufAllocator byteBufAllocator, int i) {
        ByteBuf directBuffer = byteBufAllocator.directBuffer(i);
        directBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i);
        ReferenceCountUtil.safeRelease(obj);
        return directBuffer;
    }

    protected static void checkResolvable(InetSocketAddress inetSocketAddress) {
        if (inetSocketAddress.isUnresolved()) {
            throw new UnresolvedAddressException();
        }
    }

    protected final int doReadBytes(ByteBuf byteBuf) throws Exception {
        int read;
        int writerIndex = byteBuf.writerIndex();
        unsafe().recvBufAllocHandle().attemptedBytesRead(byteBuf.writableBytes());
        if (byteBuf.hasMemoryAddress()) {
            read = this.socket.readAddress(byteBuf.memoryAddress(), writerIndex, byteBuf.capacity());
        } else {
            ByteBuffer internalNioBuffer = byteBuf.internalNioBuffer(writerIndex, byteBuf.writableBytes());
            read = this.socket.read(internalNioBuffer, internalNioBuffer.position(), internalNioBuffer.limit());
        }
        if (read > 0) {
            byteBuf.writerIndex(writerIndex + read);
        }
        return read;
    }

    protected final int doWriteBytes(ChannelOutboundBuffer channelOutboundBuffer, ByteBuf byteBuf) throws Exception {
        if (byteBuf.hasMemoryAddress()) {
            int writeAddress = this.socket.writeAddress(byteBuf.memoryAddress(), byteBuf.readerIndex(), byteBuf.writerIndex());
            if (writeAddress <= 0) {
                return Integer.MAX_VALUE;
            }
            channelOutboundBuffer.removeBytes(writeAddress);
            return 1;
        }
        ByteBuffer internalNioBuffer = byteBuf.nioBufferCount() == 1 ? byteBuf.internalNioBuffer(byteBuf.readerIndex(), byteBuf.readableBytes()) : byteBuf.nioBuffer();
        int write = this.socket.write(internalNioBuffer, internalNioBuffer.position(), internalNioBuffer.limit());
        if (write <= 0) {
            return Integer.MAX_VALUE;
        }
        internalNioBuffer.position(internalNioBuffer.position() + write);
        channelOutboundBuffer.removeBytes(write);
        return 1;
    }

    final boolean shouldBreakReadReady(ChannelConfig channelConfig) {
        return this.socket.isInputShutdown() && (this.inputClosedSeenErrorOnRead || !isAllowHalfClosure(channelConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAllowHalfClosure(ChannelConfig channelConfig) {
        return (channelConfig instanceof KQueueSocketChannelConfig) && ((KQueueSocketChannelConfig) channelConfig).isAllowHalfClosure();
    }

    final void clearReadFilter() {
        if (isRegistered()) {
            EventLoop eventLoop = eventLoop();
            final AbstractKQueueUnsafe abstractKQueueUnsafe = (AbstractKQueueUnsafe) unsafe();
            if (eventLoop.inEventLoop()) {
                abstractKQueueUnsafe.clearReadFilter0();
                return;
            } else {
                eventLoop.execute(new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueChannel.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (abstractKQueueUnsafe.readPending || AbstractKQueueChannel.this.config().isAutoRead()) {
                            return;
                        }
                        abstractKQueueUnsafe.clearReadFilter0();
                    }
                });
                return;
            }
        }
        this.readFilterEnabled = false;
    }

    void readFilter(boolean z) throws IOException {
        if (this.readFilterEnabled != z) {
            this.readFilterEnabled = z;
            evSet(Native.EVFILT_READ, z ? Native.EV_ADD_CLEAR_ENABLE : Native.EV_DELETE_DISABLE);
        }
    }

    void writeFilter(boolean z) throws IOException {
        if (this.writeFilterEnabled != z) {
            this.writeFilterEnabled = z;
            evSet(Native.EVFILT_WRITE, z ? Native.EV_ADD_CLEAR_ENABLE : Native.EV_DELETE_DISABLE);
        }
    }

    private void evSet(short s, short s2) {
        if (isOpen() && isRegistered()) {
            evSet0(s, s2);
        }
    }

    private void evSet0(short s, short s2) {
        evSet0(s, s2, 0);
    }

    private void evSet0(short s, short s2, int i) {
        ((KQueueEventLoop) eventLoop()).evSet(this, s, s2, i);
    }

    abstract class AbstractKQueueUnsafe extends AbstractChannel.AbstractUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private KQueueRecvByteAllocatorHandle allocHandle;
        boolean maybeMoreDataToRead;
        boolean readPending;
        private final Runnable readReadyRunnable;

        abstract void readReady(KQueueRecvByteAllocatorHandle kQueueRecvByteAllocatorHandle);

        AbstractKQueueUnsafe() {
            super();
            this.readReadyRunnable = new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractKQueueChannel.this.readReadyRunnablePending = false;
                    AbstractKQueueUnsafe abstractKQueueUnsafe = AbstractKQueueUnsafe.this;
                    abstractKQueueUnsafe.readReady(abstractKQueueUnsafe.recvBufAllocHandle());
                }
            };
        }

        final void readReady(long j) {
            KQueueRecvByteAllocatorHandle recvBufAllocHandle = recvBufAllocHandle();
            recvBufAllocHandle.numberBytesPending(j);
            readReady(recvBufAllocHandle);
        }

        final void readReadyBefore() {
            this.maybeMoreDataToRead = false;
        }

        final void readReadyFinally(ChannelConfig channelConfig) {
            this.maybeMoreDataToRead = this.allocHandle.maybeMoreDataToRead();
            if (!this.readPending && !channelConfig.isAutoRead()) {
                clearReadFilter0();
            } else if (this.readPending && this.maybeMoreDataToRead) {
                executeReadReadyRunnable(channelConfig);
            }
        }

        final void writeReady() {
            if (AbstractKQueueChannel.this.connectPromise != null) {
                finishConnect();
            } else {
                if (AbstractKQueueChannel.this.socket.isOutputShutdown()) {
                    return;
                }
                super.flush0();
            }
        }

        void shutdownInput(boolean z) {
            if (z && AbstractKQueueChannel.this.connectPromise != null) {
                finishConnect();
            }
            if (AbstractKQueueChannel.this.socket.isInputShutdown()) {
                if (z) {
                    return;
                }
                AbstractKQueueChannel.this.inputClosedSeenErrorOnRead = true;
                AbstractKQueueChannel.this.pipeline().fireUserEventTriggered((Object) ChannelInputShutdownReadComplete.INSTANCE);
                return;
            }
            if (AbstractKQueueChannel.isAllowHalfClosure(AbstractKQueueChannel.this.config())) {
                try {
                    AbstractKQueueChannel.this.socket.shutdown(true, false);
                } catch (IOException unused) {
                    fireEventAndClose(ChannelInputShutdownEvent.INSTANCE);
                    return;
                } catch (NotYetConnectedException unused2) {
                }
                AbstractKQueueChannel.this.pipeline().fireUserEventTriggered((Object) ChannelInputShutdownEvent.INSTANCE);
                return;
            }
            close(voidPromise());
        }

        final void readEOF() {
            KQueueRecvByteAllocatorHandle recvBufAllocHandle = recvBufAllocHandle();
            recvBufAllocHandle.readEOF();
            if (AbstractKQueueChannel.this.isActive()) {
                readReady(recvBufAllocHandle);
            } else {
                shutdownInput(true);
            }
        }

        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe, io.netty.channel.Channel.Unsafe
        public KQueueRecvByteAllocatorHandle recvBufAllocHandle() {
            if (this.allocHandle == null) {
                this.allocHandle = new KQueueRecvByteAllocatorHandle((RecvByteBufAllocator.ExtendedHandle) super.recvBufAllocHandle());
            }
            return this.allocHandle;
        }

        final void executeReadReadyRunnable(ChannelConfig channelConfig) {
            if (AbstractKQueueChannel.this.readReadyRunnablePending || !AbstractKQueueChannel.this.isActive() || AbstractKQueueChannel.this.shouldBreakReadReady(channelConfig)) {
                return;
            }
            AbstractKQueueChannel.this.readReadyRunnablePending = true;
            AbstractKQueueChannel.this.eventLoop().execute(this.readReadyRunnable);
        }

        protected final void clearReadFilter0() {
            try {
                this.readPending = false;
                AbstractKQueueChannel.this.readFilter(false);
            } catch (IOException e) {
                AbstractKQueueChannel.this.pipeline().fireExceptionCaught((Throwable) e);
                AbstractKQueueChannel.this.unsafe().close(AbstractKQueueChannel.this.unsafe().voidPromise());
            }
        }

        private void fireEventAndClose(Object obj) {
            AbstractKQueueChannel.this.pipeline().fireUserEventTriggered(obj);
            close(voidPromise());
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void connect(final SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable() && ensureOpen(channelPromise)) {
                try {
                    if (AbstractKQueueChannel.this.connectPromise != null) {
                        throw new ConnectionPendingException();
                    }
                    boolean isActive = AbstractKQueueChannel.this.isActive();
                    if (!AbstractKQueueChannel.this.doConnect(socketAddress, socketAddress2)) {
                        AbstractKQueueChannel.this.connectPromise = channelPromise;
                        AbstractKQueueChannel.this.requestedRemoteAddress = socketAddress;
                        int connectTimeoutMillis = AbstractKQueueChannel.this.config().getConnectTimeoutMillis();
                        if (connectTimeoutMillis > 0) {
                            AbstractKQueueChannel abstractKQueueChannel = AbstractKQueueChannel.this;
                            abstractKQueueChannel.connectTimeoutFuture = abstractKQueueChannel.eventLoop().schedule(new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ChannelPromise channelPromise2 = AbstractKQueueChannel.this.connectPromise;
                                    ConnectTimeoutException connectTimeoutException = new ConnectTimeoutException("connection timed out: " + socketAddress);
                                    if (channelPromise2 == null || !channelPromise2.tryFailure(connectTimeoutException)) {
                                        return;
                                    }
                                    AbstractKQueueUnsafe abstractKQueueUnsafe = AbstractKQueueUnsafe.this;
                                    abstractKQueueUnsafe.close(abstractKQueueUnsafe.voidPromise());
                                }
                            }, connectTimeoutMillis, TimeUnit.MILLISECONDS);
                        }
                        channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe.3
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                                if (channelFuture.isCancelled()) {
                                    if (AbstractKQueueChannel.this.connectTimeoutFuture != null) {
                                        AbstractKQueueChannel.this.connectTimeoutFuture.cancel(false);
                                    }
                                    AbstractKQueueChannel.this.connectPromise = null;
                                    AbstractKQueueUnsafe abstractKQueueUnsafe = AbstractKQueueUnsafe.this;
                                    abstractKQueueUnsafe.close(abstractKQueueUnsafe.voidPromise());
                                }
                            }
                        });
                        return;
                    }
                    fulfillConnectPromise(channelPromise, isActive);
                } catch (Throwable th) {
                    closeIfClosed();
                    channelPromise.tryFailure(annotateConnectException(th, socketAddress));
                }
            }
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise, boolean z) {
            if (channelPromise == null) {
                return;
            }
            AbstractKQueueChannel.this.active = true;
            boolean isActive = AbstractKQueueChannel.this.isActive();
            boolean trySuccess = channelPromise.trySuccess();
            if (!z && isActive) {
                AbstractKQueueChannel.this.pipeline().fireChannelActive();
            }
            if (trySuccess) {
                return;
            }
            close(voidPromise());
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise, Throwable th) {
            if (channelPromise == null) {
                return;
            }
            channelPromise.tryFailure(th);
            closeIfClosed();
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x004c, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
        
            if (r5.this$0.connectTimeoutFuture == null) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void finishConnect() {
            /*
                r5 = this;
                r0 = 0
                r1 = 0
                io.netty.channel.kqueue.AbstractKQueueChannel r2 = io.netty.channel.kqueue.AbstractKQueueChannel.this     // Catch: java.lang.Throwable -> L2f
                boolean r2 = r2.isActive()     // Catch: java.lang.Throwable -> L2f
                boolean r3 = r5.doFinishConnect()     // Catch: java.lang.Throwable -> L2f
                if (r3 != 0) goto Lf
                return
            Lf:
                io.netty.channel.kqueue.AbstractKQueueChannel r3 = io.netty.channel.kqueue.AbstractKQueueChannel.this     // Catch: java.lang.Throwable -> L2f
                io.netty.channel.ChannelPromise r3 = io.netty.channel.kqueue.AbstractKQueueChannel.access$000(r3)     // Catch: java.lang.Throwable -> L2f
                r5.fulfillConnectPromise(r3, r2)     // Catch: java.lang.Throwable -> L2f
                io.netty.channel.kqueue.AbstractKQueueChannel r2 = io.netty.channel.kqueue.AbstractKQueueChannel.this
                java.util.concurrent.ScheduledFuture r2 = io.netty.channel.kqueue.AbstractKQueueChannel.access$300(r2)
                if (r2 == 0) goto L29
            L20:
                io.netty.channel.kqueue.AbstractKQueueChannel r2 = io.netty.channel.kqueue.AbstractKQueueChannel.this
                java.util.concurrent.ScheduledFuture r2 = io.netty.channel.kqueue.AbstractKQueueChannel.access$300(r2)
                r2.cancel(r0)
            L29:
                io.netty.channel.kqueue.AbstractKQueueChannel r0 = io.netty.channel.kqueue.AbstractKQueueChannel.this
                io.netty.channel.kqueue.AbstractKQueueChannel.access$002(r0, r1)
                goto L4c
            L2f:
                r2 = move-exception
                io.netty.channel.kqueue.AbstractKQueueChannel r3 = io.netty.channel.kqueue.AbstractKQueueChannel.this     // Catch: java.lang.Throwable -> L4d
                io.netty.channel.ChannelPromise r3 = io.netty.channel.kqueue.AbstractKQueueChannel.access$000(r3)     // Catch: java.lang.Throwable -> L4d
                io.netty.channel.kqueue.AbstractKQueueChannel r4 = io.netty.channel.kqueue.AbstractKQueueChannel.this     // Catch: java.lang.Throwable -> L4d
                java.net.SocketAddress r4 = io.netty.channel.kqueue.AbstractKQueueChannel.access$200(r4)     // Catch: java.lang.Throwable -> L4d
                java.lang.Throwable r2 = r5.annotateConnectException(r2, r4)     // Catch: java.lang.Throwable -> L4d
                r5.fulfillConnectPromise(r3, r2)     // Catch: java.lang.Throwable -> L4d
                io.netty.channel.kqueue.AbstractKQueueChannel r2 = io.netty.channel.kqueue.AbstractKQueueChannel.this
                java.util.concurrent.ScheduledFuture r2 = io.netty.channel.kqueue.AbstractKQueueChannel.access$300(r2)
                if (r2 == 0) goto L29
                goto L20
            L4c:
                return
            L4d:
                r2 = move-exception
                io.netty.channel.kqueue.AbstractKQueueChannel r3 = io.netty.channel.kqueue.AbstractKQueueChannel.this
                java.util.concurrent.ScheduledFuture r3 = io.netty.channel.kqueue.AbstractKQueueChannel.access$300(r3)
                if (r3 == 0) goto L5f
                io.netty.channel.kqueue.AbstractKQueueChannel r3 = io.netty.channel.kqueue.AbstractKQueueChannel.this
                java.util.concurrent.ScheduledFuture r3 = io.netty.channel.kqueue.AbstractKQueueChannel.access$300(r3)
                r3.cancel(r0)
            L5f:
                io.netty.channel.kqueue.AbstractKQueueChannel r0 = io.netty.channel.kqueue.AbstractKQueueChannel.this
                io.netty.channel.kqueue.AbstractKQueueChannel.access$002(r0, r1)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe.finishConnect():void");
        }

        private boolean doFinishConnect() throws Exception {
            if (AbstractKQueueChannel.this.socket.finishConnect()) {
                AbstractKQueueChannel.this.writeFilter(false);
                if (AbstractKQueueChannel.this.requestedRemoteAddress instanceof InetSocketAddress) {
                    AbstractKQueueChannel abstractKQueueChannel = AbstractKQueueChannel.this;
                    abstractKQueueChannel.remote = UnixChannelUtil.computeRemoteAddr((InetSocketAddress) abstractKQueueChannel.requestedRemoteAddress, AbstractKQueueChannel.this.socket.remoteAddress());
                }
                AbstractKQueueChannel.this.requestedRemoteAddress = null;
                return true;
            }
            AbstractKQueueChannel.this.writeFilter(true);
            return false;
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        if (socketAddress instanceof InetSocketAddress) {
            checkResolvable((InetSocketAddress) socketAddress);
        }
        this.socket.bind(socketAddress);
        this.local = this.socket.localAddress();
    }

    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (socketAddress2 instanceof InetSocketAddress) {
            checkResolvable((InetSocketAddress) socketAddress2);
        }
        InetSocketAddress inetSocketAddress = socketAddress instanceof InetSocketAddress ? (InetSocketAddress) socketAddress : null;
        if (inetSocketAddress != null) {
            checkResolvable(inetSocketAddress);
        }
        if (this.remote != null) {
            throw new AlreadyConnectedException();
        }
        if (socketAddress2 != null) {
            this.socket.bind(socketAddress2);
        }
        boolean doConnect0 = doConnect0(socketAddress);
        if (doConnect0) {
            if (inetSocketAddress != null) {
                socketAddress = UnixChannelUtil.computeRemoteAddr(inetSocketAddress, this.socket.remoteAddress());
            }
            this.remote = socketAddress;
        }
        this.local = this.socket.localAddress();
        return doConnect0;
    }

    private boolean doConnect0(SocketAddress socketAddress) throws Exception {
        try {
            boolean connect = this.socket.connect(socketAddress);
            if (!connect) {
                writeFilter(true);
            }
            return connect;
        } catch (Throwable th) {
            doClose();
            throw th;
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return this.local;
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return this.remote;
    }
}

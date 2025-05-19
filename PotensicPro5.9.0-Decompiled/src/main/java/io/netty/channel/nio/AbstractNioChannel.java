package io.netty.channel.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.EventLoop;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class AbstractNioChannel extends AbstractChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SelectableChannel ch;
    private final Runnable clearReadPendingRunnable;
    private ChannelPromise connectPromise;
    private ScheduledFuture<?> connectTimeoutFuture;
    protected final int readInterestOp;
    boolean readPending;
    private SocketAddress requestedRemoteAddress;
    volatile SelectionKey selectionKey;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractNioChannel.class);
    private static final ClosedChannelException DO_CLOSE_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), AbstractNioChannel.class, "doClose()");

    public interface NioUnsafe extends Channel.Unsafe {
        SelectableChannel ch();

        void finishConnect();

        void forceFlush();

        void read();
    }

    protected abstract boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception;

    protected abstract void doFinishConnect() throws Exception;

    protected AbstractNioChannel(Channel channel, SelectableChannel selectableChannel, int i) {
        super(channel);
        this.clearReadPendingRunnable = new Runnable() { // from class: io.netty.channel.nio.AbstractNioChannel.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractNioChannel.this.clearReadPending0();
            }
        };
        this.ch = selectableChannel;
        this.readInterestOp = i;
        try {
            selectableChannel.configureBlocking(false);
        } catch (IOException e) {
            try {
                selectableChannel.close();
            } catch (IOException e2) {
                if (logger.isWarnEnabled()) {
                    logger.warn("Failed to close a partially initialized socket.", (Throwable) e2);
                }
            }
            throw new ChannelException("Failed to enter non-blocking mode.", e);
        }
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return this.ch.isOpen();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public NioUnsafe unsafe() {
        return (NioUnsafe) super.unsafe();
    }

    /* renamed from: javaChannel */
    protected SelectableChannel mo46javaChannel() {
        return this.ch;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public NioEventLoop eventLoop() {
        return (NioEventLoop) super.eventLoop();
    }

    protected SelectionKey selectionKey() {
        return this.selectionKey;
    }

    @Deprecated
    protected boolean isReadPending() {
        return this.readPending;
    }

    @Deprecated
    protected void setReadPending(final boolean z) {
        if (isRegistered()) {
            NioEventLoop eventLoop = eventLoop();
            if (eventLoop.inEventLoop()) {
                setReadPending0(z);
                return;
            } else {
                eventLoop.execute(new Runnable() { // from class: io.netty.channel.nio.AbstractNioChannel.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractNioChannel.this.setReadPending0(z);
                    }
                });
                return;
            }
        }
        this.readPending = z;
    }

    protected final void clearReadPending() {
        if (isRegistered()) {
            NioEventLoop eventLoop = eventLoop();
            if (eventLoop.inEventLoop()) {
                clearReadPending0();
                return;
            } else {
                eventLoop.execute(this.clearReadPendingRunnable);
                return;
            }
        }
        this.readPending = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadPending0(boolean z) {
        this.readPending = z;
        if (z) {
            return;
        }
        ((AbstractNioUnsafe) unsafe()).removeReadOp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReadPending0() {
        this.readPending = false;
        ((AbstractNioUnsafe) unsafe()).removeReadOp();
    }

    protected abstract class AbstractNioUnsafe extends AbstractChannel.AbstractUnsafe implements NioUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        protected AbstractNioUnsafe() {
            super();
        }

        protected final void removeReadOp() {
            SelectionKey selectionKey = AbstractNioChannel.this.selectionKey();
            if (selectionKey.isValid()) {
                int interestOps = selectionKey.interestOps();
                if ((AbstractNioChannel.this.readInterestOp & interestOps) != 0) {
                    selectionKey.interestOps(interestOps & (~AbstractNioChannel.this.readInterestOp));
                }
            }
        }

        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public final SelectableChannel ch() {
            return AbstractNioChannel.this.mo46javaChannel();
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void connect(final SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable() && ensureOpen(channelPromise)) {
                try {
                    if (AbstractNioChannel.this.connectPromise != null) {
                        throw new ConnectionPendingException();
                    }
                    boolean isActive = AbstractNioChannel.this.isActive();
                    if (!AbstractNioChannel.this.doConnect(socketAddress, socketAddress2)) {
                        AbstractNioChannel.this.connectPromise = channelPromise;
                        AbstractNioChannel.this.requestedRemoteAddress = socketAddress;
                        int connectTimeoutMillis = AbstractNioChannel.this.config().getConnectTimeoutMillis();
                        if (connectTimeoutMillis > 0) {
                            AbstractNioChannel abstractNioChannel = AbstractNioChannel.this;
                            abstractNioChannel.connectTimeoutFuture = abstractNioChannel.eventLoop().schedule(new Runnable() { // from class: io.netty.channel.nio.AbstractNioChannel.AbstractNioUnsafe.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ChannelPromise channelPromise2 = AbstractNioChannel.this.connectPromise;
                                    ConnectTimeoutException connectTimeoutException = new ConnectTimeoutException("connection timed out: " + socketAddress);
                                    if (channelPromise2 == null || !channelPromise2.tryFailure(connectTimeoutException)) {
                                        return;
                                    }
                                    AbstractNioUnsafe abstractNioUnsafe = AbstractNioUnsafe.this;
                                    abstractNioUnsafe.close(abstractNioUnsafe.voidPromise());
                                }
                            }, connectTimeoutMillis, TimeUnit.MILLISECONDS);
                        }
                        channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.nio.AbstractNioChannel.AbstractNioUnsafe.2
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                                if (channelFuture.isCancelled()) {
                                    if (AbstractNioChannel.this.connectTimeoutFuture != null) {
                                        AbstractNioChannel.this.connectTimeoutFuture.cancel(false);
                                    }
                                    AbstractNioChannel.this.connectPromise = null;
                                    AbstractNioUnsafe abstractNioUnsafe = AbstractNioUnsafe.this;
                                    abstractNioUnsafe.close(abstractNioUnsafe.voidPromise());
                                }
                            }
                        });
                        return;
                    }
                    fulfillConnectPromise(channelPromise, isActive);
                } catch (Throwable th) {
                    channelPromise.tryFailure(annotateConnectException(th, socketAddress));
                    closeIfClosed();
                }
            }
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise, boolean z) {
            if (channelPromise == null) {
                return;
            }
            boolean isActive = AbstractNioChannel.this.isActive();
            boolean trySuccess = channelPromise.trySuccess();
            if (!z && isActive) {
                AbstractNioChannel.this.pipeline().fireChannelActive();
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

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        
            if (r5.this$0.connectTimeoutFuture == null) goto L7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x004a, code lost:
        
            return;
         */
        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void finishConnect() {
            /*
                r5 = this;
                r0 = 0
                r1 = 0
                io.netty.channel.nio.AbstractNioChannel r2 = io.netty.channel.nio.AbstractNioChannel.this     // Catch: java.lang.Throwable -> L2d
                boolean r2 = r2.isActive()     // Catch: java.lang.Throwable -> L2d
                io.netty.channel.nio.AbstractNioChannel r3 = io.netty.channel.nio.AbstractNioChannel.this     // Catch: java.lang.Throwable -> L2d
                r3.doFinishConnect()     // Catch: java.lang.Throwable -> L2d
                io.netty.channel.nio.AbstractNioChannel r3 = io.netty.channel.nio.AbstractNioChannel.this     // Catch: java.lang.Throwable -> L2d
                io.netty.channel.ChannelPromise r3 = io.netty.channel.nio.AbstractNioChannel.access$200(r3)     // Catch: java.lang.Throwable -> L2d
                r5.fulfillConnectPromise(r3, r2)     // Catch: java.lang.Throwable -> L2d
                io.netty.channel.nio.AbstractNioChannel r2 = io.netty.channel.nio.AbstractNioChannel.this
                java.util.concurrent.ScheduledFuture r2 = io.netty.channel.nio.AbstractNioChannel.access$400(r2)
                if (r2 == 0) goto L27
            L1e:
                io.netty.channel.nio.AbstractNioChannel r2 = io.netty.channel.nio.AbstractNioChannel.this
                java.util.concurrent.ScheduledFuture r2 = io.netty.channel.nio.AbstractNioChannel.access$400(r2)
                r2.cancel(r0)
            L27:
                io.netty.channel.nio.AbstractNioChannel r0 = io.netty.channel.nio.AbstractNioChannel.this
                io.netty.channel.nio.AbstractNioChannel.access$202(r0, r1)
                goto L4a
            L2d:
                r2 = move-exception
                io.netty.channel.nio.AbstractNioChannel r3 = io.netty.channel.nio.AbstractNioChannel.this     // Catch: java.lang.Throwable -> L4b
                io.netty.channel.ChannelPromise r3 = io.netty.channel.nio.AbstractNioChannel.access$200(r3)     // Catch: java.lang.Throwable -> L4b
                io.netty.channel.nio.AbstractNioChannel r4 = io.netty.channel.nio.AbstractNioChannel.this     // Catch: java.lang.Throwable -> L4b
                java.net.SocketAddress r4 = io.netty.channel.nio.AbstractNioChannel.access$300(r4)     // Catch: java.lang.Throwable -> L4b
                java.lang.Throwable r2 = r5.annotateConnectException(r2, r4)     // Catch: java.lang.Throwable -> L4b
                r5.fulfillConnectPromise(r3, r2)     // Catch: java.lang.Throwable -> L4b
                io.netty.channel.nio.AbstractNioChannel r2 = io.netty.channel.nio.AbstractNioChannel.this
                java.util.concurrent.ScheduledFuture r2 = io.netty.channel.nio.AbstractNioChannel.access$400(r2)
                if (r2 == 0) goto L27
                goto L1e
            L4a:
                return
            L4b:
                r2 = move-exception
                io.netty.channel.nio.AbstractNioChannel r3 = io.netty.channel.nio.AbstractNioChannel.this
                java.util.concurrent.ScheduledFuture r3 = io.netty.channel.nio.AbstractNioChannel.access$400(r3)
                if (r3 == 0) goto L5d
                io.netty.channel.nio.AbstractNioChannel r3 = io.netty.channel.nio.AbstractNioChannel.this
                java.util.concurrent.ScheduledFuture r3 = io.netty.channel.nio.AbstractNioChannel.access$400(r3)
                r3.cancel(r0)
            L5d:
                io.netty.channel.nio.AbstractNioChannel r0 = io.netty.channel.nio.AbstractNioChannel.this
                io.netty.channel.nio.AbstractNioChannel.access$202(r0, r1)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.nio.AbstractNioChannel.AbstractNioUnsafe.finishConnect():void");
        }

        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe
        protected final void flush0() {
            if (isFlushPending()) {
                return;
            }
            super.flush0();
        }

        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public final void forceFlush() {
            super.flush0();
        }

        private boolean isFlushPending() {
            SelectionKey selectionKey = AbstractNioChannel.this.selectionKey();
            return selectionKey.isValid() && (selectionKey.interestOps() & 4) != 0;
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof NioEventLoop;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doRegister() throws Exception {
        boolean z = false;
        while (true) {
            try {
                this.selectionKey = mo46javaChannel().register(eventLoop().unwrappedSelector(), 0, this);
                return;
            } catch (CancelledKeyException e) {
                if (!z) {
                    eventLoop().selectNow();
                    z = true;
                } else {
                    throw e;
                }
            }
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDeregister() throws Exception {
        eventLoop().cancel(selectionKey());
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBeginRead() throws Exception {
        SelectionKey selectionKey = this.selectionKey;
        if (selectionKey.isValid()) {
            this.readPending = true;
            int interestOps = selectionKey.interestOps();
            int i = this.readInterestOp;
            if ((interestOps & i) == 0) {
                selectionKey.interestOps(interestOps | i);
            }
        }
    }

    protected final ByteBuf newDirectBuffer(ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            ReferenceCountUtil.safeRelease(byteBuf);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator alloc = alloc();
        if (alloc.isDirectBufferPooled()) {
            ByteBuf directBuffer = alloc.directBuffer(readableBytes);
            directBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
            ReferenceCountUtil.safeRelease(byteBuf);
            return directBuffer;
        }
        ByteBuf threadLocalDirectBuffer = ByteBufUtil.threadLocalDirectBuffer();
        if (threadLocalDirectBuffer == null) {
            return byteBuf;
        }
        threadLocalDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
        ReferenceCountUtil.safeRelease(byteBuf);
        return threadLocalDirectBuffer;
    }

    protected final ByteBuf newDirectBuffer(ReferenceCounted referenceCounted, ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            ReferenceCountUtil.safeRelease(referenceCounted);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator alloc = alloc();
        if (alloc.isDirectBufferPooled()) {
            ByteBuf directBuffer = alloc.directBuffer(readableBytes);
            directBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
            ReferenceCountUtil.safeRelease(referenceCounted);
            return directBuffer;
        }
        ByteBuf threadLocalDirectBuffer = ByteBufUtil.threadLocalDirectBuffer();
        if (threadLocalDirectBuffer != null) {
            threadLocalDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
            ReferenceCountUtil.safeRelease(referenceCounted);
            return threadLocalDirectBuffer;
        }
        if (referenceCounted != byteBuf) {
            byteBuf.retain();
            ReferenceCountUtil.safeRelease(referenceCounted);
        }
        return byteBuf;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        ChannelPromise channelPromise = this.connectPromise;
        if (channelPromise != null) {
            channelPromise.tryFailure(DO_CLOSE_CLOSED_CHANNEL_EXCEPTION);
            this.connectPromise = null;
        }
        ScheduledFuture<?> scheduledFuture = this.connectTimeoutFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.connectTimeoutFuture = null;
        }
    }
}

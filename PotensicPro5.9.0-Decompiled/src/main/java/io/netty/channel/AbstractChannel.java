package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.ChannelOutputShutdownEvent;
import io.netty.channel.socket.ChannelOutputShutdownException;
import io.netty.util.DefaultAttributeMap;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public abstract class AbstractChannel extends DefaultAttributeMap implements Channel {
    private final CloseFuture closeFuture;
    private boolean closeInitiated;
    private volatile EventLoop eventLoop;
    private final ChannelId id;
    private volatile SocketAddress localAddress;
    private final Channel parent;
    private final DefaultChannelPipeline pipeline;
    private volatile boolean registered;
    private volatile SocketAddress remoteAddress;
    private String strVal;
    private boolean strValActive;
    private final Channel.Unsafe unsafe;
    private final VoidChannelPromise unsafeVoidPromise;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractChannel.class);
    private static final ClosedChannelException FLUSH0_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), AbstractUnsafe.class, "flush0()");
    private static final ClosedChannelException ENSURE_OPEN_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), AbstractUnsafe.class, "ensureOpen(...)");
    private static final ClosedChannelException CLOSE_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), AbstractUnsafe.class, "close(...)");
    private static final ClosedChannelException WRITE_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), AbstractUnsafe.class, "write(...)");
    private static final NotYetConnectedException FLUSH0_NOT_YET_CONNECTED_EXCEPTION = (NotYetConnectedException) ThrowableUtil.unknownStackTrace(new NotYetConnectedException(), AbstractUnsafe.class, "flush0()");

    protected abstract void doBeginRead() throws Exception;

    protected abstract void doBind(SocketAddress socketAddress) throws Exception;

    protected abstract void doClose() throws Exception;

    protected void doDeregister() throws Exception {
    }

    protected abstract void doDisconnect() throws Exception;

    protected void doRegister() throws Exception {
    }

    protected abstract void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception;

    public final boolean equals(Object obj) {
        return this == obj;
    }

    protected Object filterOutboundMessage(Object obj) throws Exception {
        return obj;
    }

    protected abstract boolean isCompatible(EventLoop eventLoop);

    protected abstract SocketAddress localAddress0();

    protected abstract AbstractUnsafe newUnsafe();

    protected abstract SocketAddress remoteAddress0();

    protected AbstractChannel(Channel channel) {
        this.unsafeVoidPromise = new VoidChannelPromise(this, false);
        this.closeFuture = new CloseFuture(this);
        this.parent = channel;
        this.id = newId();
        this.unsafe = newUnsafe();
        this.pipeline = newChannelPipeline();
    }

    protected AbstractChannel(Channel channel, ChannelId channelId) {
        this.unsafeVoidPromise = new VoidChannelPromise(this, false);
        this.closeFuture = new CloseFuture(this);
        this.parent = channel;
        this.id = channelId;
        this.unsafe = newUnsafe();
        this.pipeline = newChannelPipeline();
    }

    @Override // io.netty.channel.Channel
    public final ChannelId id() {
        return this.id;
    }

    protected ChannelId newId() {
        return DefaultChannelId.newInstance();
    }

    protected DefaultChannelPipeline newChannelPipeline() {
        return new DefaultChannelPipeline(this);
    }

    @Override // io.netty.channel.Channel
    public boolean isWritable() {
        ChannelOutboundBuffer outboundBuffer = this.unsafe.outboundBuffer();
        return outboundBuffer != null && outboundBuffer.isWritable();
    }

    @Override // io.netty.channel.Channel
    public long bytesBeforeUnwritable() {
        ChannelOutboundBuffer outboundBuffer = this.unsafe.outboundBuffer();
        if (outboundBuffer != null) {
            return outboundBuffer.bytesBeforeUnwritable();
        }
        return 0L;
    }

    @Override // io.netty.channel.Channel
    public long bytesBeforeWritable() {
        ChannelOutboundBuffer outboundBuffer = this.unsafe.outboundBuffer();
        if (outboundBuffer != null) {
            return outboundBuffer.bytesBeforeWritable();
        }
        return Long.MAX_VALUE;
    }

    @Override // io.netty.channel.Channel
    public Channel parent() {
        return this.parent;
    }

    @Override // io.netty.channel.Channel
    public ChannelPipeline pipeline() {
        return this.pipeline;
    }

    @Override // io.netty.channel.Channel
    public ByteBufAllocator alloc() {
        return config().getAllocator();
    }

    @Override // io.netty.channel.Channel
    public EventLoop eventLoop() {
        EventLoop eventLoop = this.eventLoop;
        if (eventLoop != null) {
            return eventLoop;
        }
        throw new IllegalStateException("channel not registered to an event loop");
    }

    @Override // io.netty.channel.Channel
    public SocketAddress localAddress() {
        SocketAddress socketAddress = this.localAddress;
        if (socketAddress != null) {
            return socketAddress;
        }
        try {
            SocketAddress localAddress = unsafe().localAddress();
            this.localAddress = localAddress;
            return localAddress;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Deprecated
    protected void invalidateLocalAddress() {
        this.localAddress = null;
    }

    @Override // io.netty.channel.Channel
    public SocketAddress remoteAddress() {
        SocketAddress socketAddress = this.remoteAddress;
        if (socketAddress != null) {
            return socketAddress;
        }
        try {
            SocketAddress remoteAddress = unsafe().remoteAddress();
            this.remoteAddress = remoteAddress;
            return remoteAddress;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Deprecated
    protected void invalidateRemoteAddress() {
        this.remoteAddress = null;
    }

    @Override // io.netty.channel.Channel
    public boolean isRegistered() {
        return this.registered;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(SocketAddress socketAddress) {
        return this.pipeline.bind(socketAddress);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress) {
        return this.pipeline.connect(socketAddress);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
        return this.pipeline.connect(socketAddress, socketAddress2);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect() {
        return this.pipeline.disconnect();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close() {
        return this.pipeline.close();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister() {
        return this.pipeline.deregister();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public Channel flush() {
        this.pipeline.flush();
        return this;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return this.pipeline.bind(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return this.pipeline.connect(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        return this.pipeline.connect(socketAddress, socketAddress2, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect(ChannelPromise channelPromise) {
        return this.pipeline.disconnect(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close(ChannelPromise channelPromise) {
        return this.pipeline.close(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister(ChannelPromise channelPromise) {
        return this.pipeline.deregister(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public Channel read() {
        this.pipeline.read();
        return this;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object obj) {
        return this.pipeline.write(obj);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object obj, ChannelPromise channelPromise) {
        return this.pipeline.write(obj, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object obj) {
        return this.pipeline.writeAndFlush(obj);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object obj, ChannelPromise channelPromise) {
        return this.pipeline.writeAndFlush(obj, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise newPromise() {
        return this.pipeline.newPromise();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelProgressivePromise newProgressivePromise() {
        return this.pipeline.newProgressivePromise();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newSucceededFuture() {
        return this.pipeline.newSucceededFuture();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newFailedFuture(Throwable th) {
        return this.pipeline.newFailedFuture(th);
    }

    @Override // io.netty.channel.Channel
    public ChannelFuture closeFuture() {
        return this.closeFuture;
    }

    @Override // io.netty.channel.Channel
    public Channel.Unsafe unsafe() {
        return this.unsafe;
    }

    public final int hashCode() {
        return this.id.hashCode();
    }

    @Override // java.lang.Comparable
    public final int compareTo(Channel channel) {
        if (this == channel) {
            return 0;
        }
        return id().compareTo(channel.id());
    }

    public String toString() {
        String str;
        boolean isActive = isActive();
        if (this.strValActive == isActive && (str = this.strVal) != null) {
            return str;
        }
        SocketAddress remoteAddress = remoteAddress();
        SocketAddress localAddress = localAddress();
        if (remoteAddress != null) {
            this.strVal = new StringBuilder(96).append("[id: 0x").append(this.id.asShortText()).append(", L:").append(localAddress).append(isActive ? " - " : " ! ").append("R:").append(remoteAddress).append(PropertyUtils.INDEXED_DELIM2).toString();
        } else if (localAddress != null) {
            this.strVal = new StringBuilder(64).append("[id: 0x").append(this.id.asShortText()).append(", L:").append(localAddress).append(PropertyUtils.INDEXED_DELIM2).toString();
        } else {
            this.strVal = new StringBuilder(16).append("[id: 0x").append(this.id.asShortText()).append(PropertyUtils.INDEXED_DELIM2).toString();
        }
        this.strValActive = isActive;
        return this.strVal;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelPromise voidPromise() {
        return this.pipeline.voidPromise();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract class AbstractUnsafe implements Channel.Unsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean inFlush0;
        private boolean neverRegistered = true;
        private volatile ChannelOutboundBuffer outboundBuffer;
        private RecvByteBufAllocator.Handle recvHandle;

        private void assertEventLoop() {
        }

        protected Executor prepareToClose() {
            return null;
        }

        protected AbstractUnsafe() {
            this.outboundBuffer = new ChannelOutboundBuffer(AbstractChannel.this);
        }

        @Override // io.netty.channel.Channel.Unsafe
        public RecvByteBufAllocator.Handle recvBufAllocHandle() {
            if (this.recvHandle == null) {
                this.recvHandle = AbstractChannel.this.config().getRecvByteBufAllocator().newHandle();
            }
            return this.recvHandle;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final ChannelOutboundBuffer outboundBuffer() {
            return this.outboundBuffer;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final SocketAddress localAddress() {
            return AbstractChannel.this.localAddress0();
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final SocketAddress remoteAddress() {
            return AbstractChannel.this.remoteAddress0();
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void register(EventLoop eventLoop, final ChannelPromise channelPromise) {
            Objects.requireNonNull(eventLoop, "eventLoop");
            if (AbstractChannel.this.isRegistered()) {
                channelPromise.setFailure((Throwable) new IllegalStateException("registered to an event loop already"));
                return;
            }
            if (AbstractChannel.this.isCompatible(eventLoop)) {
                AbstractChannel.this.eventLoop = eventLoop;
                if (eventLoop.inEventLoop()) {
                    register0(channelPromise);
                    return;
                }
                try {
                    eventLoop.execute(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AbstractUnsafe.this.register0(channelPromise);
                        }
                    });
                    return;
                } catch (Throwable th) {
                    AbstractChannel.logger.warn("Force-closing a channel whose registration task was not accepted by an event loop: {}", AbstractChannel.this, th);
                    closeForcibly();
                    AbstractChannel.this.closeFuture.setClosed();
                    safeSetFailure(channelPromise, th);
                    return;
                }
            }
            channelPromise.setFailure((Throwable) new IllegalStateException("incompatible event loop type: " + eventLoop.getClass().getName()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void register0(ChannelPromise channelPromise) {
            try {
                if (channelPromise.setUncancellable() && ensureOpen(channelPromise)) {
                    boolean z = this.neverRegistered;
                    AbstractChannel.this.doRegister();
                    this.neverRegistered = false;
                    AbstractChannel.this.registered = true;
                    AbstractChannel.this.pipeline.invokeHandlerAddedIfNeeded();
                    safeSetSuccess(channelPromise);
                    AbstractChannel.this.pipeline.fireChannelRegistered();
                    if (AbstractChannel.this.isActive()) {
                        if (z) {
                            AbstractChannel.this.pipeline.fireChannelActive();
                        } else if (AbstractChannel.this.config().isAutoRead()) {
                            beginRead();
                        }
                    }
                }
            } catch (Throwable th) {
                closeForcibly();
                AbstractChannel.this.closeFuture.setClosed();
                safeSetFailure(channelPromise, th);
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
            assertEventLoop();
            if (channelPromise.setUncancellable() && ensureOpen(channelPromise)) {
                if (Boolean.TRUE.equals(AbstractChannel.this.config().getOption(ChannelOption.SO_BROADCAST)) && (socketAddress instanceof InetSocketAddress) && !((InetSocketAddress) socketAddress).getAddress().isAnyLocalAddress() && !PlatformDependent.isWindows() && !PlatformDependent.maybeSuperUser()) {
                    AbstractChannel.logger.warn("A non-root user can't receive a broadcast packet if the socket is not bound to a wildcard address; binding to a non-wildcard address (" + socketAddress + ") anyway as requested.");
                }
                boolean isActive = AbstractChannel.this.isActive();
                try {
                    AbstractChannel.this.doBind(socketAddress);
                    if (!isActive && AbstractChannel.this.isActive()) {
                        invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AbstractChannel.this.pipeline.fireChannelActive();
                            }
                        });
                    }
                    safeSetSuccess(channelPromise);
                } catch (Throwable th) {
                    safeSetFailure(channelPromise, th);
                    closeIfClosed();
                }
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void disconnect(ChannelPromise channelPromise) {
            assertEventLoop();
            if (channelPromise.setUncancellable()) {
                boolean isActive = AbstractChannel.this.isActive();
                try {
                    AbstractChannel.this.doDisconnect();
                    if (isActive && !AbstractChannel.this.isActive()) {
                        invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.3
                            @Override // java.lang.Runnable
                            public void run() {
                                AbstractChannel.this.pipeline.fireChannelInactive();
                            }
                        });
                    }
                    safeSetSuccess(channelPromise);
                    closeIfClosed();
                } catch (Throwable th) {
                    safeSetFailure(channelPromise, th);
                    closeIfClosed();
                }
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void close(ChannelPromise channelPromise) {
            assertEventLoop();
            close(channelPromise, AbstractChannel.CLOSE_CLOSED_CHANNEL_EXCEPTION, AbstractChannel.CLOSE_CLOSED_CHANNEL_EXCEPTION, false);
        }

        public final void shutdownOutput(ChannelPromise channelPromise) {
            assertEventLoop();
            shutdownOutput(channelPromise, null);
        }

        private void shutdownOutput(final ChannelPromise channelPromise, Throwable th) {
            if (channelPromise.setUncancellable()) {
                final ChannelOutboundBuffer channelOutboundBuffer = this.outboundBuffer;
                if (channelOutboundBuffer == null) {
                    channelPromise.setFailure((Throwable) AbstractChannel.CLOSE_CLOSED_CHANNEL_EXCEPTION);
                    return;
                }
                this.outboundBuffer = null;
                final ChannelOutputShutdownException channelOutputShutdownException = th == null ? new ChannelOutputShutdownException("Channel output shutdown") : new ChannelOutputShutdownException("Channel output shutdown", th);
                Executor prepareToClose = prepareToClose();
                if (prepareToClose != null) {
                    prepareToClose.execute(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.4
                        @Override // java.lang.Runnable
                        public void run() {
                            EventLoop eventLoop;
                            Runnable runnable;
                            try {
                                AbstractChannel.this.doShutdownOutput();
                                channelPromise.setSuccess();
                                eventLoop = AbstractChannel.this.eventLoop();
                                runnable = new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AbstractUnsafe.this.closeOutboundBufferForShutdown(AbstractChannel.this.pipeline, channelOutboundBuffer, channelOutputShutdownException);
                                    }
                                };
                            } catch (Throwable th2) {
                                try {
                                    channelPromise.setFailure(th2);
                                    eventLoop = AbstractChannel.this.eventLoop();
                                    runnable = new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.4.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            AbstractUnsafe.this.closeOutboundBufferForShutdown(AbstractChannel.this.pipeline, channelOutboundBuffer, channelOutputShutdownException);
                                        }
                                    };
                                } catch (Throwable th3) {
                                    AbstractChannel.this.eventLoop().execute(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.4.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            AbstractUnsafe.this.closeOutboundBufferForShutdown(AbstractChannel.this.pipeline, channelOutboundBuffer, channelOutputShutdownException);
                                        }
                                    });
                                    throw th3;
                                }
                            }
                            eventLoop.execute(runnable);
                        }
                    });
                    return;
                }
                try {
                    AbstractChannel.this.doShutdownOutput();
                    channelPromise.setSuccess();
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void closeOutboundBufferForShutdown(ChannelPipeline channelPipeline, ChannelOutboundBuffer channelOutboundBuffer, Throwable th) {
            channelOutboundBuffer.failFlushed(th, false);
            channelOutboundBuffer.close(th, true);
            channelPipeline.fireUserEventTriggered((Object) ChannelOutputShutdownEvent.INSTANCE);
        }

        private void close(final ChannelPromise channelPromise, final Throwable th, final ClosedChannelException closedChannelException, final boolean z) {
            if (channelPromise.setUncancellable()) {
                if (AbstractChannel.this.closeInitiated) {
                    if (AbstractChannel.this.closeFuture.isDone()) {
                        safeSetSuccess(channelPromise);
                        return;
                    } else {
                        if (channelPromise instanceof VoidChannelPromise) {
                            return;
                        }
                        AbstractChannel.this.closeFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.5
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                                channelPromise.setSuccess();
                            }
                        });
                        return;
                    }
                }
                AbstractChannel.this.closeInitiated = true;
                final boolean isActive = AbstractChannel.this.isActive();
                final ChannelOutboundBuffer channelOutboundBuffer = this.outboundBuffer;
                this.outboundBuffer = null;
                Executor prepareToClose = prepareToClose();
                if (prepareToClose != null) {
                    prepareToClose.execute(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.6
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AbstractUnsafe.this.doClose0(channelPromise);
                            } finally {
                                AbstractUnsafe.this.invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.6.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (channelOutboundBuffer != null) {
                                            channelOutboundBuffer.failFlushed(th, z);
                                            channelOutboundBuffer.close(closedChannelException);
                                        }
                                        AbstractUnsafe.this.fireChannelInactiveAndDeregister(isActive);
                                    }
                                });
                            }
                        }
                    });
                    return;
                }
                try {
                    doClose0(channelPromise);
                    if (this.inFlush0) {
                        invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.7
                            @Override // java.lang.Runnable
                            public void run() {
                                AbstractUnsafe.this.fireChannelInactiveAndDeregister(isActive);
                            }
                        });
                    } else {
                        fireChannelInactiveAndDeregister(isActive);
                    }
                } finally {
                    if (channelOutboundBuffer != null) {
                        channelOutboundBuffer.failFlushed(th, z);
                        channelOutboundBuffer.close(closedChannelException);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doClose0(ChannelPromise channelPromise) {
            try {
                AbstractChannel.this.doClose();
                AbstractChannel.this.closeFuture.setClosed();
                safeSetSuccess(channelPromise);
            } catch (Throwable th) {
                AbstractChannel.this.closeFuture.setClosed();
                safeSetFailure(channelPromise, th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fireChannelInactiveAndDeregister(boolean z) {
            deregister(voidPromise(), z && !AbstractChannel.this.isActive());
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void closeForcibly() {
            assertEventLoop();
            try {
                AbstractChannel.this.doClose();
            } catch (Exception e) {
                AbstractChannel.logger.warn("Failed to close a channel.", (Throwable) e);
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void deregister(ChannelPromise channelPromise) {
            assertEventLoop();
            deregister(channelPromise, false);
        }

        private void deregister(final ChannelPromise channelPromise, final boolean z) {
            if (channelPromise.setUncancellable()) {
                if (!AbstractChannel.this.registered) {
                    safeSetSuccess(channelPromise);
                } else {
                    invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.8
                        /* JADX WARN: Code restructure failed: missing block: B:11:0x005f, code lost:
                        
                            return;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
                        
                            if (r4.this$1.this$0.registered == false) goto L10;
                         */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public void run() {
                            /*
                                r4 = this;
                                r0 = 0
                                io.netty.channel.AbstractChannel$AbstractUnsafe r1 = io.netty.channel.AbstractChannel.AbstractUnsafe.this     // Catch: java.lang.Throwable -> L3b
                                io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this     // Catch: java.lang.Throwable -> L3b
                                r1.doDeregister()     // Catch: java.lang.Throwable -> L3b
                                boolean r1 = r2
                                if (r1 == 0) goto L17
                                io.netty.channel.AbstractChannel$AbstractUnsafe r1 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this
                                io.netty.channel.DefaultChannelPipeline r1 = io.netty.channel.AbstractChannel.access$500(r1)
                                r1.fireChannelInactive()
                            L17:
                                io.netty.channel.AbstractChannel$AbstractUnsafe r1 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this
                                boolean r1 = io.netty.channel.AbstractChannel.access$000(r1)
                                if (r1 == 0) goto L33
                            L21:
                                io.netty.channel.AbstractChannel$AbstractUnsafe r1 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this
                                io.netty.channel.AbstractChannel.access$002(r1, r0)
                                io.netty.channel.AbstractChannel$AbstractUnsafe r0 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r0 = io.netty.channel.AbstractChannel.this
                                io.netty.channel.DefaultChannelPipeline r0 = io.netty.channel.AbstractChannel.access$500(r0)
                                r0.fireChannelUnregistered()
                            L33:
                                io.netty.channel.AbstractChannel$AbstractUnsafe r0 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.ChannelPromise r1 = r3
                                r0.safeSetSuccess(r1)
                                goto L5f
                            L3b:
                                r1 = move-exception
                                io.netty.util.internal.logging.InternalLogger r2 = io.netty.channel.AbstractChannel.access$300()     // Catch: java.lang.Throwable -> L60
                                java.lang.String r3 = "Unexpected exception occurred while deregistering a channel."
                                r2.warn(r3, r1)     // Catch: java.lang.Throwable -> L60
                                boolean r1 = r2
                                if (r1 == 0) goto L54
                                io.netty.channel.AbstractChannel$AbstractUnsafe r1 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this
                                io.netty.channel.DefaultChannelPipeline r1 = io.netty.channel.AbstractChannel.access$500(r1)
                                r1.fireChannelInactive()
                            L54:
                                io.netty.channel.AbstractChannel$AbstractUnsafe r1 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this
                                boolean r1 = io.netty.channel.AbstractChannel.access$000(r1)
                                if (r1 == 0) goto L33
                                goto L21
                            L5f:
                                return
                            L60:
                                r1 = move-exception
                                boolean r2 = r2
                                if (r2 == 0) goto L70
                                io.netty.channel.AbstractChannel$AbstractUnsafe r2 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r2 = io.netty.channel.AbstractChannel.this
                                io.netty.channel.DefaultChannelPipeline r2 = io.netty.channel.AbstractChannel.access$500(r2)
                                r2.fireChannelInactive()
                            L70:
                                io.netty.channel.AbstractChannel$AbstractUnsafe r2 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r2 = io.netty.channel.AbstractChannel.this
                                boolean r2 = io.netty.channel.AbstractChannel.access$000(r2)
                                if (r2 == 0) goto L8c
                                io.netty.channel.AbstractChannel$AbstractUnsafe r2 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r2 = io.netty.channel.AbstractChannel.this
                                io.netty.channel.AbstractChannel.access$002(r2, r0)
                                io.netty.channel.AbstractChannel$AbstractUnsafe r0 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r0 = io.netty.channel.AbstractChannel.this
                                io.netty.channel.DefaultChannelPipeline r0 = io.netty.channel.AbstractChannel.access$500(r0)
                                r0.fireChannelUnregistered()
                            L8c:
                                io.netty.channel.AbstractChannel$AbstractUnsafe r0 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.ChannelPromise r2 = r3
                                r0.safeSetSuccess(r2)
                                throw r1
                            */
                            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.AbstractChannel.AbstractUnsafe.AnonymousClass8.run():void");
                        }
                    });
                }
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void beginRead() {
            assertEventLoop();
            if (AbstractChannel.this.isActive()) {
                try {
                    AbstractChannel.this.doBeginRead();
                } catch (Exception e) {
                    invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.9
                        @Override // java.lang.Runnable
                        public void run() {
                            AbstractChannel.this.pipeline.fireExceptionCaught((Throwable) e);
                        }
                    });
                    close(voidPromise());
                }
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void write(Object obj, ChannelPromise channelPromise) {
            assertEventLoop();
            ChannelOutboundBuffer channelOutboundBuffer = this.outboundBuffer;
            if (channelOutboundBuffer == null) {
                safeSetFailure(channelPromise, AbstractChannel.WRITE_CLOSED_CHANNEL_EXCEPTION);
                ReferenceCountUtil.release(obj);
                return;
            }
            try {
                obj = AbstractChannel.this.filterOutboundMessage(obj);
                int size = AbstractChannel.this.pipeline.estimatorHandle().size(obj);
                if (size < 0) {
                    size = 0;
                }
                channelOutboundBuffer.addMessage(obj, size, channelPromise);
            } catch (Throwable th) {
                safeSetFailure(channelPromise, th);
                ReferenceCountUtil.release(obj);
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void flush() {
            assertEventLoop();
            ChannelOutboundBuffer channelOutboundBuffer = this.outboundBuffer;
            if (channelOutboundBuffer == null) {
                return;
            }
            channelOutboundBuffer.addFlush();
            flush0();
        }

        /* JADX WARN: Can't wrap try/catch for region: R(8:17|18|(2:20|(4:22|23|14|15))|25|26|23|14|15) */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected void flush0() {
            /*
                r4 = this;
                boolean r0 = r4.inFlush0
                if (r0 == 0) goto L5
                return
            L5:
                io.netty.channel.ChannelOutboundBuffer r0 = r4.outboundBuffer
                if (r0 == 0) goto L79
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L10
                goto L79
            L10:
                r1 = 1
                r4.inFlush0 = r1
                io.netty.channel.AbstractChannel r2 = io.netty.channel.AbstractChannel.this
                boolean r2 = r2.isActive()
                r3 = 0
                if (r2 != 0) goto L3a
                io.netty.channel.AbstractChannel r2 = io.netty.channel.AbstractChannel.this     // Catch: java.lang.Throwable -> L36
                boolean r2 = r2.isOpen()     // Catch: java.lang.Throwable -> L36
                if (r2 == 0) goto L2c
                java.nio.channels.NotYetConnectedException r2 = io.netty.channel.AbstractChannel.access$1300()     // Catch: java.lang.Throwable -> L36
                r0.failFlushed(r2, r1)     // Catch: java.lang.Throwable -> L36
                goto L33
            L2c:
                java.nio.channels.ClosedChannelException r1 = io.netty.channel.AbstractChannel.access$1400()     // Catch: java.lang.Throwable -> L36
                r0.failFlushed(r1, r3)     // Catch: java.lang.Throwable -> L36
            L33:
                r4.inFlush0 = r3
                return
            L36:
                r0 = move-exception
                r4.inFlush0 = r3
                throw r0
            L3a:
                io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this     // Catch: java.lang.Throwable -> L42
                r1.doWrite(r0)     // Catch: java.lang.Throwable -> L42
            L3f:
                r4.inFlush0 = r3
                goto L74
            L42:
                r0 = move-exception
                boolean r1 = r0 instanceof java.io.IOException     // Catch: java.lang.Throwable -> L75
                if (r1 == 0) goto L5f
                io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this     // Catch: java.lang.Throwable -> L75
                io.netty.channel.ChannelConfig r1 = r1.config()     // Catch: java.lang.Throwable -> L75
                boolean r1 = r1.isAutoClose()     // Catch: java.lang.Throwable -> L75
                if (r1 == 0) goto L5f
                io.netty.channel.ChannelPromise r1 = r4.voidPromise()     // Catch: java.lang.Throwable -> L75
                java.nio.channels.ClosedChannelException r2 = io.netty.channel.AbstractChannel.access$1400()     // Catch: java.lang.Throwable -> L75
                r4.close(r1, r0, r2, r3)     // Catch: java.lang.Throwable -> L75
                goto L3f
            L5f:
                io.netty.channel.ChannelPromise r1 = r4.voidPromise()     // Catch: java.lang.Throwable -> L67
                r4.shutdownOutput(r1, r0)     // Catch: java.lang.Throwable -> L67
                goto L3f
            L67:
                r0 = move-exception
                io.netty.channel.ChannelPromise r1 = r4.voidPromise()     // Catch: java.lang.Throwable -> L75
                java.nio.channels.ClosedChannelException r2 = io.netty.channel.AbstractChannel.access$1400()     // Catch: java.lang.Throwable -> L75
                r4.close(r1, r0, r2, r3)     // Catch: java.lang.Throwable -> L75
                goto L3f
            L74:
                return
            L75:
                r0 = move-exception
                r4.inFlush0 = r3
                throw r0
            L79:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.AbstractChannel.AbstractUnsafe.flush0():void");
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final ChannelPromise voidPromise() {
            assertEventLoop();
            return AbstractChannel.this.unsafeVoidPromise;
        }

        protected final boolean ensureOpen(ChannelPromise channelPromise) {
            if (AbstractChannel.this.isOpen()) {
                return true;
            }
            safeSetFailure(channelPromise, AbstractChannel.ENSURE_OPEN_CLOSED_CHANNEL_EXCEPTION);
            return false;
        }

        protected final void safeSetSuccess(ChannelPromise channelPromise) {
            if ((channelPromise instanceof VoidChannelPromise) || channelPromise.trySuccess()) {
                return;
            }
            AbstractChannel.logger.warn("Failed to mark a promise as success because it is done already: {}", channelPromise);
        }

        protected final void safeSetFailure(ChannelPromise channelPromise, Throwable th) {
            if ((channelPromise instanceof VoidChannelPromise) || channelPromise.tryFailure(th)) {
                return;
            }
            AbstractChannel.logger.warn("Failed to mark a promise as failure because it's done already: {}", channelPromise, th);
        }

        protected final void closeIfClosed() {
            if (AbstractChannel.this.isOpen()) {
                return;
            }
            close(voidPromise());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void invokeLater(Runnable runnable) {
            try {
                AbstractChannel.this.eventLoop().execute(runnable);
            } catch (RejectedExecutionException e) {
                AbstractChannel.logger.warn("Can't invoke task later as EventLoop rejected it", (Throwable) e);
            }
        }

        protected final Throwable annotateConnectException(Throwable th, SocketAddress socketAddress) {
            if (th instanceof ConnectException) {
                return new AnnotatedConnectException((ConnectException) th, socketAddress);
            }
            if (th instanceof NoRouteToHostException) {
                return new AnnotatedNoRouteToHostException((NoRouteToHostException) th, socketAddress);
            }
            return th instanceof SocketException ? new AnnotatedSocketException((SocketException) th, socketAddress) : th;
        }
    }

    protected void doShutdownOutput() throws Exception {
        doClose();
    }

    static final class CloseFuture extends DefaultChannelPromise {
        CloseFuture(AbstractChannel abstractChannel) {
            super(abstractChannel);
        }

        @Override // io.netty.channel.DefaultChannelPromise, io.netty.channel.ChannelPromise
        public ChannelPromise setSuccess() {
            throw new IllegalStateException();
        }

        @Override // io.netty.channel.DefaultChannelPromise, io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
        public ChannelPromise setFailure(Throwable th) {
            throw new IllegalStateException();
        }

        @Override // io.netty.channel.DefaultChannelPromise, io.netty.channel.ChannelPromise
        public boolean trySuccess() {
            throw new IllegalStateException();
        }

        @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
        public boolean tryFailure(Throwable th) {
            throw new IllegalStateException();
        }

        boolean setClosed() {
            return super.trySuccess();
        }
    }

    private static final class AnnotatedConnectException extends ConnectException {
        private static final long serialVersionUID = 3901958112696433556L;

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }

        AnnotatedConnectException(ConnectException connectException, SocketAddress socketAddress) {
            super(connectException.getMessage() + ": " + socketAddress);
            initCause(connectException);
            setStackTrace(connectException.getStackTrace());
        }
    }

    private static final class AnnotatedNoRouteToHostException extends NoRouteToHostException {
        private static final long serialVersionUID = -6801433937592080623L;

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }

        AnnotatedNoRouteToHostException(NoRouteToHostException noRouteToHostException, SocketAddress socketAddress) {
            super(noRouteToHostException.getMessage() + ": " + socketAddress);
            initCause(noRouteToHostException);
            setStackTrace(noRouteToHostException.getStackTrace());
        }
    }

    private static final class AnnotatedSocketException extends SocketException {
        private static final long serialVersionUID = 3896743275010454039L;

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }

        AnnotatedSocketException(SocketException socketException, SocketAddress socketAddress) {
            super(socketException.getMessage() + ": " + socketAddress);
            initCause(socketException);
            setStackTrace(socketException.getStackTrace());
        }
    }
}

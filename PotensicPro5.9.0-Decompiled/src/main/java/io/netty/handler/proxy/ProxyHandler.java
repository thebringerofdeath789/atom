package io.netty.handler.proxy;

import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.PendingWriteQueue;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.nio.channels.ConnectionPendingException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class ProxyHandler extends ChannelDuplexHandler {
    static final String AUTH_NONE = "none";
    private static final long DEFAULT_CONNECT_TIMEOUT_MILLIS = 10000;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ProxyHandler.class);
    private ScheduledFuture<?> connectTimeoutFuture;
    private volatile ChannelHandlerContext ctx;
    private volatile SocketAddress destinationAddress;
    private boolean finished;
    private boolean flushedPrematurely;
    private PendingWriteQueue pendingWrites;
    private final SocketAddress proxyAddress;
    private boolean suppressChannelReadComplete;
    private volatile long connectTimeoutMillis = 10000;
    private final LazyChannelPromise connectPromise = new LazyChannelPromise();
    private final ChannelFutureListener writeListener = new ChannelFutureListener() { // from class: io.netty.handler.proxy.ProxyHandler.1
        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (channelFuture.isSuccess()) {
                return;
            }
            ProxyHandler.this.setConnectFailure(channelFuture.cause());
        }
    };

    protected abstract void addCodec(ChannelHandlerContext channelHandlerContext) throws Exception;

    public abstract String authScheme();

    protected abstract boolean handleResponse(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception;

    protected abstract Object newInitialMessage(ChannelHandlerContext channelHandlerContext) throws Exception;

    public abstract String protocol();

    protected abstract void removeDecoder(ChannelHandlerContext channelHandlerContext) throws Exception;

    protected abstract void removeEncoder(ChannelHandlerContext channelHandlerContext) throws Exception;

    protected ProxyHandler(SocketAddress socketAddress) {
        Objects.requireNonNull(socketAddress, "proxyAddress");
        this.proxyAddress = socketAddress;
    }

    public final <T extends SocketAddress> T proxyAddress() {
        return (T) this.proxyAddress;
    }

    public final <T extends SocketAddress> T destinationAddress() {
        return (T) this.destinationAddress;
    }

    public final boolean isConnected() {
        return this.connectPromise.isSuccess();
    }

    public final Future<Channel> connectFuture() {
        return this.connectPromise;
    }

    public final long connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    public final void setConnectTimeoutMillis(long j) {
        if (j <= 0) {
            j = 0;
        }
        this.connectTimeoutMillis = j;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public final void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
        addCodec(channelHandlerContext);
        if (channelHandlerContext.channel().isActive()) {
            sendInitialMessage(channelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public final void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        if (this.destinationAddress != null) {
            channelPromise.setFailure((Throwable) new ConnectionPendingException());
        } else {
            this.destinationAddress = socketAddress;
            channelHandlerContext.connect(this.proxyAddress, socketAddress2, channelPromise);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        sendInitialMessage(channelHandlerContext);
        channelHandlerContext.fireChannelActive();
    }

    private void sendInitialMessage(ChannelHandlerContext channelHandlerContext) throws Exception {
        long j = this.connectTimeoutMillis;
        if (j > 0) {
            this.connectTimeoutFuture = channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.proxy.ProxyHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ProxyHandler.this.connectPromise.isDone()) {
                        return;
                    }
                    ProxyHandler.this.setConnectFailure(new ProxyConnectException(ProxyHandler.this.exceptionMessage(RtspHeaders.Values.TIMEOUT)));
                }
            }, j, TimeUnit.MILLISECONDS);
        }
        Object newInitialMessage = newInitialMessage(channelHandlerContext);
        if (newInitialMessage != null) {
            sendToProxyServer(newInitialMessage);
        }
        readIfNeeded(channelHandlerContext);
    }

    protected final void sendToProxyServer(Object obj) {
        this.ctx.writeAndFlush(obj).addListener((GenericFutureListener<? extends Future<? super Void>>) this.writeListener);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.finished) {
            channelHandlerContext.fireChannelInactive();
        } else {
            setConnectFailure(new ProxyConnectException(exceptionMessage("disconnected")));
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public final void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        if (this.finished) {
            channelHandlerContext.fireExceptionCaught(th);
        } else {
            setConnectFailure(th);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (this.finished) {
            this.suppressChannelReadComplete = false;
            channelHandlerContext.fireChannelRead(obj);
            return;
        }
        this.suppressChannelReadComplete = true;
        try {
            if (handleResponse(channelHandlerContext, obj)) {
                setConnectSuccess();
            }
            ReferenceCountUtil.release(obj);
        } catch (Throwable th) {
            ReferenceCountUtil.release(obj);
            setConnectFailure(th);
        }
    }

    private void setConnectSuccess() {
        this.finished = true;
        cancelConnectTimeoutFuture();
        if (this.connectPromise.isDone()) {
            return;
        }
        boolean safeRemoveEncoder = true & safeRemoveEncoder();
        this.ctx.fireUserEventTriggered((Object) new ProxyConnectionEvent(protocol(), authScheme(), this.proxyAddress, this.destinationAddress));
        if (safeRemoveEncoder & safeRemoveDecoder()) {
            writePendingWrites();
            if (this.flushedPrematurely) {
                this.ctx.flush();
            }
            this.connectPromise.trySuccess(this.ctx.channel());
            return;
        }
        failPendingWritesAndClose(new ProxyConnectException("failed to remove all codec handlers added by the proxy handler; bug?"));
    }

    private boolean safeRemoveDecoder() {
        try {
            removeDecoder(this.ctx);
            return true;
        } catch (Exception e) {
            logger.warn("Failed to remove proxy decoders:", (Throwable) e);
            return false;
        }
    }

    private boolean safeRemoveEncoder() {
        try {
            removeEncoder(this.ctx);
            return true;
        } catch (Exception e) {
            logger.warn("Failed to remove proxy encoders:", (Throwable) e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectFailure(Throwable th) {
        this.finished = true;
        cancelConnectTimeoutFuture();
        if (this.connectPromise.isDone()) {
            return;
        }
        if (!(th instanceof ProxyConnectException)) {
            th = new ProxyConnectException(exceptionMessage(th.toString()), th);
        }
        safeRemoveDecoder();
        safeRemoveEncoder();
        failPendingWritesAndClose(th);
    }

    private void failPendingWritesAndClose(Throwable th) {
        failPendingWrites(th);
        this.connectPromise.tryFailure(th);
        this.ctx.fireExceptionCaught(th);
        this.ctx.close();
    }

    private void cancelConnectTimeoutFuture() {
        ScheduledFuture<?> scheduledFuture = this.connectTimeoutFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.connectTimeoutFuture = null;
        }
    }

    protected final String exceptionMessage(String str) {
        if (str == null) {
            str = "";
        }
        StringBuilder append = new StringBuilder(str.length() + 128).append(protocol()).append(", ").append(authScheme()).append(", ").append(this.proxyAddress).append(" => ").append(this.destinationAddress);
        if (!str.isEmpty()) {
            append.append(", ").append(str);
        }
        return append.toString();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.suppressChannelReadComplete) {
            this.suppressChannelReadComplete = false;
            readIfNeeded(channelHandlerContext);
        } else {
            channelHandlerContext.fireChannelReadComplete();
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public final void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (this.finished) {
            writePendingWrites();
            channelHandlerContext.write(obj, channelPromise);
        } else {
            addPendingWrite(channelHandlerContext, obj, channelPromise);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public final void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.finished) {
            writePendingWrites();
            channelHandlerContext.flush();
        } else {
            this.flushedPrematurely = true;
        }
    }

    private static void readIfNeeded(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.channel().config().isAutoRead()) {
            return;
        }
        channelHandlerContext.read();
    }

    private void writePendingWrites() {
        PendingWriteQueue pendingWriteQueue = this.pendingWrites;
        if (pendingWriteQueue != null) {
            pendingWriteQueue.removeAndWriteAll();
            this.pendingWrites = null;
        }
    }

    private void failPendingWrites(Throwable th) {
        PendingWriteQueue pendingWriteQueue = this.pendingWrites;
        if (pendingWriteQueue != null) {
            pendingWriteQueue.removeAndFailAll(th);
            this.pendingWrites = null;
        }
    }

    private void addPendingWrite(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        PendingWriteQueue pendingWriteQueue = this.pendingWrites;
        if (pendingWriteQueue == null) {
            pendingWriteQueue = new PendingWriteQueue(channelHandlerContext);
            this.pendingWrites = pendingWriteQueue;
        }
        pendingWriteQueue.add(obj, channelPromise);
    }

    private final class LazyChannelPromise extends DefaultPromise<Channel> {
        private LazyChannelPromise() {
        }

        @Override // io.netty.util.concurrent.DefaultPromise
        protected EventExecutor executor() {
            if (ProxyHandler.this.ctx != null) {
                return ProxyHandler.this.ctx.executor();
            }
            throw new IllegalStateException();
        }
    }
}

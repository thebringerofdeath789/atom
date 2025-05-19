package io.netty.handler.ssl;

import com.ipotensic.baselib.netty.Constant;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractCoalescingBufferQueue;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ChannelPromiseNotifier;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ImmediateExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;

/* loaded from: classes4.dex */
public class SslHandler extends ByteToMessageDecoder implements ChannelOutboundHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_PLAINTEXT_LENGTH = 16384;
    private volatile long closeNotifyFlushTimeoutMillis;
    private volatile long closeNotifyReadTimeoutMillis;
    private volatile ChannelHandlerContext ctx;
    private final Executor delegatedTaskExecutor;
    private final SSLEngine engine;
    private final SslEngineType engineType;
    private boolean firedChannelRead;
    private boolean flushedBeforeHandshake;
    private Promise<Channel> handshakePromise;
    private boolean handshakeStarted;
    private volatile long handshakeTimeoutMillis;
    private final boolean jdkCompatibilityMode;
    private boolean needsFlush;
    private boolean outboundClosed;
    private int packetLength;
    private SslHandlerCoalescingBufferQueue pendingUnencryptedWrites;
    private boolean readDuringHandshake;
    private boolean sentFirstMessage;
    private final ByteBuffer[] singleBuffer;
    private final LazyChannelPromise sslClosePromise;
    private final boolean startTls;
    volatile int wrapDataSize;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SslHandler.class);
    private static final Pattern IGNORABLE_CLASS_IN_STACK = Pattern.compile("^.*(?:Socket|Datagram|Sctp|Udt)Channel.*$");
    private static final Pattern IGNORABLE_ERROR_MESSAGE = Pattern.compile("^.*(?:connection.*(?:reset|closed|abort|broken)|broken.*pipe).*$", 2);
    private static final SSLException SSLENGINE_CLOSED = (SSLException) ThrowableUtil.unknownStackTrace(new SSLException("SSLEngine closed already"), SslHandler.class, "wrap(...)");
    private static final SSLException HANDSHAKE_TIMED_OUT = (SSLException) ThrowableUtil.unknownStackTrace(new SSLException("handshake timed out"), SslHandler.class, "handshake(...)");
    private static final ClosedChannelException CHANNEL_CLOSED = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), SslHandler.class, "channelInactive(...)");

    private enum SslEngineType {
        TCNATIVE(true, ByteToMessageDecoder.COMPOSITE_CUMULATOR) { // from class: io.netty.handler.ssl.SslHandler.SslEngineType.1
            @Override // io.netty.handler.ssl.SslHandler.SslEngineType
            SSLEngineResult unwrap(SslHandler sslHandler, ByteBuf byteBuf, int i, int i2, ByteBuf byteBuf2) throws SSLException {
                SSLEngineResult unwrap;
                int nioBufferCount = byteBuf.nioBufferCount();
                int writerIndex = byteBuf2.writerIndex();
                if (nioBufferCount > 1) {
                    ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = (ReferenceCountedOpenSslEngine) sslHandler.engine;
                    try {
                        sslHandler.singleBuffer[0] = SslHandler.toByteBuffer(byteBuf2, writerIndex, byteBuf2.writableBytes());
                        unwrap = referenceCountedOpenSslEngine.unwrap(byteBuf.nioBuffers(i, i2), sslHandler.singleBuffer);
                    } finally {
                        sslHandler.singleBuffer[0] = null;
                    }
                } else {
                    unwrap = sslHandler.engine.unwrap(SslHandler.toByteBuffer(byteBuf, i, i2), SslHandler.toByteBuffer(byteBuf2, writerIndex, byteBuf2.writableBytes()));
                }
                byteBuf2.writerIndex(writerIndex + unwrap.bytesProduced());
                return unwrap;
            }

            @Override // io.netty.handler.ssl.SslHandler.SslEngineType
            int getPacketBufferSize(SslHandler sslHandler) {
                return ((ReferenceCountedOpenSslEngine) sslHandler.engine).maxEncryptedPacketLength0();
            }

            @Override // io.netty.handler.ssl.SslHandler.SslEngineType
            int calculateWrapBufferCapacity(SslHandler sslHandler, int i, int i2) {
                return ((ReferenceCountedOpenSslEngine) sslHandler.engine).calculateMaxLengthForWrap(i, i2);
            }

            @Override // io.netty.handler.ssl.SslHandler.SslEngineType
            int calculatePendingData(SslHandler sslHandler, int i) {
                int sslPending = ((ReferenceCountedOpenSslEngine) sslHandler.engine).sslPending();
                return sslPending > 0 ? sslPending : i;
            }

            @Override // io.netty.handler.ssl.SslHandler.SslEngineType
            boolean jdkCompatibilityMode(SSLEngine sSLEngine) {
                return ((ReferenceCountedOpenSslEngine) sSLEngine).jdkCompatibilityMode;
            }
        },
        CONSCRYPT(true ? 1 : 0, ByteToMessageDecoder.COMPOSITE_CUMULATOR) { // from class: io.netty.handler.ssl.SslHandler.SslEngineType.2
            @Override // io.netty.handler.ssl.SslHandler.SslEngineType
            int calculatePendingData(SslHandler sslHandler, int i) {
                return i;
            }

            @Override // io.netty.handler.ssl.SslHandler.SslEngineType
            boolean jdkCompatibilityMode(SSLEngine sSLEngine) {
                return true;
            }

            @Override // io.netty.handler.ssl.SslHandler.SslEngineType
            SSLEngineResult unwrap(SslHandler sslHandler, ByteBuf byteBuf, int i, int i2, ByteBuf byteBuf2) throws SSLException {
                SSLEngineResult unwrap;
                int nioBufferCount = byteBuf.nioBufferCount();
                int writerIndex = byteBuf2.writerIndex();
                if (nioBufferCount > 1) {
                    try {
                        sslHandler.singleBuffer[0] = SslHandler.toByteBuffer(byteBuf2, writerIndex, byteBuf2.writableBytes());
                        unwrap = ((ConscryptAlpnSslEngine) sslHandler.engine).unwrap(byteBuf.nioBuffers(i, i2), sslHandler.singleBuffer);
                    } finally {
                        sslHandler.singleBuffer[0] = null;
                    }
                } else {
                    unwrap = sslHandler.engine.unwrap(SslHandler.toByteBuffer(byteBuf, i, i2), SslHandler.toByteBuffer(byteBuf2, writerIndex, byteBuf2.writableBytes()));
                }
                byteBuf2.writerIndex(writerIndex + unwrap.bytesProduced());
                return unwrap;
            }

            @Override // io.netty.handler.ssl.SslHandler.SslEngineType
            int calculateWrapBufferCapacity(SslHandler sslHandler, int i, int i2) {
                return ((ConscryptAlpnSslEngine) sslHandler.engine).calculateOutNetBufSize(i, i2);
            }
        },
        JDK(0 == true ? 1 : 0, ByteToMessageDecoder.MERGE_CUMULATOR) { // from class: io.netty.handler.ssl.SslHandler.SslEngineType.3
            @Override // io.netty.handler.ssl.SslHandler.SslEngineType
            int calculatePendingData(SslHandler sslHandler, int i) {
                return i;
            }

            @Override // io.netty.handler.ssl.SslHandler.SslEngineType
            boolean jdkCompatibilityMode(SSLEngine sSLEngine) {
                return true;
            }

            @Override // io.netty.handler.ssl.SslHandler.SslEngineType
            SSLEngineResult unwrap(SslHandler sslHandler, ByteBuf byteBuf, int i, int i2, ByteBuf byteBuf2) throws SSLException {
                int writerIndex = byteBuf2.writerIndex();
                SSLEngineResult unwrap = sslHandler.engine.unwrap(SslHandler.toByteBuffer(byteBuf, i, i2), SslHandler.toByteBuffer(byteBuf2, writerIndex, byteBuf2.writableBytes()));
                byteBuf2.writerIndex(writerIndex + unwrap.bytesProduced());
                return unwrap;
            }

            @Override // io.netty.handler.ssl.SslHandler.SslEngineType
            int calculateWrapBufferCapacity(SslHandler sslHandler, int i, int i2) {
                return sslHandler.engine.getSession().getPacketBufferSize();
            }
        };

        final ByteToMessageDecoder.Cumulator cumulator;
        final boolean wantsDirectBuffer;

        abstract int calculatePendingData(SslHandler sslHandler, int i);

        abstract int calculateWrapBufferCapacity(SslHandler sslHandler, int i, int i2);

        abstract boolean jdkCompatibilityMode(SSLEngine sSLEngine);

        abstract SSLEngineResult unwrap(SslHandler sslHandler, ByteBuf byteBuf, int i, int i2, ByteBuf byteBuf2) throws SSLException;

        static SslEngineType forEngine(SSLEngine sSLEngine) {
            return sSLEngine instanceof ReferenceCountedOpenSslEngine ? TCNATIVE : sSLEngine instanceof ConscryptAlpnSslEngine ? CONSCRYPT : JDK;
        }

        SslEngineType(boolean z, ByteToMessageDecoder.Cumulator cumulator) {
            this.wantsDirectBuffer = z;
            this.cumulator = cumulator;
        }

        int getPacketBufferSize(SslHandler sslHandler) {
            return sslHandler.engine.getSession().getPacketBufferSize();
        }
    }

    public SslHandler(SSLEngine sSLEngine) {
        this(sSLEngine, false);
    }

    public SslHandler(SSLEngine sSLEngine, boolean z) {
        this(sSLEngine, z, ImmediateExecutor.INSTANCE);
    }

    @Deprecated
    public SslHandler(SSLEngine sSLEngine, Executor executor) {
        this(sSLEngine, false, executor);
    }

    @Deprecated
    public SslHandler(SSLEngine sSLEngine, boolean z, Executor executor) {
        this.singleBuffer = new ByteBuffer[1];
        this.handshakePromise = new LazyChannelPromise();
        this.sslClosePromise = new LazyChannelPromise();
        this.handshakeTimeoutMillis = Constant.DELAY_MILLIS;
        this.closeNotifyFlushTimeoutMillis = 3000L;
        this.wrapDataSize = 16384;
        Objects.requireNonNull(sSLEngine, "engine");
        Objects.requireNonNull(executor, "delegatedTaskExecutor");
        this.engine = sSLEngine;
        SslEngineType forEngine = SslEngineType.forEngine(sSLEngine);
        this.engineType = forEngine;
        this.delegatedTaskExecutor = executor;
        this.startTls = z;
        this.jdkCompatibilityMode = forEngine.jdkCompatibilityMode(sSLEngine);
        setCumulator(forEngine.cumulator);
    }

    public long getHandshakeTimeoutMillis() {
        return this.handshakeTimeoutMillis;
    }

    public void setHandshakeTimeout(long j, TimeUnit timeUnit) {
        Objects.requireNonNull(timeUnit, "unit");
        setHandshakeTimeoutMillis(timeUnit.toMillis(j));
    }

    public void setHandshakeTimeoutMillis(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("handshakeTimeoutMillis: " + j + " (expected: >= 0)");
        }
        this.handshakeTimeoutMillis = j;
    }

    public final void setWrapDataSize(int i) {
        this.wrapDataSize = i;
    }

    @Deprecated
    public long getCloseNotifyTimeoutMillis() {
        return getCloseNotifyFlushTimeoutMillis();
    }

    @Deprecated
    public void setCloseNotifyTimeout(long j, TimeUnit timeUnit) {
        setCloseNotifyFlushTimeout(j, timeUnit);
    }

    @Deprecated
    public void setCloseNotifyTimeoutMillis(long j) {
        setCloseNotifyFlushTimeoutMillis(j);
    }

    public final long getCloseNotifyFlushTimeoutMillis() {
        return this.closeNotifyFlushTimeoutMillis;
    }

    public final void setCloseNotifyFlushTimeout(long j, TimeUnit timeUnit) {
        setCloseNotifyFlushTimeoutMillis(timeUnit.toMillis(j));
    }

    public final void setCloseNotifyFlushTimeoutMillis(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("closeNotifyFlushTimeoutMillis: " + j + " (expected: >= 0)");
        }
        this.closeNotifyFlushTimeoutMillis = j;
    }

    public final long getCloseNotifyReadTimeoutMillis() {
        return this.closeNotifyReadTimeoutMillis;
    }

    public final void setCloseNotifyReadTimeout(long j, TimeUnit timeUnit) {
        setCloseNotifyReadTimeoutMillis(timeUnit.toMillis(j));
    }

    public final void setCloseNotifyReadTimeoutMillis(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("closeNotifyReadTimeoutMillis: " + j + " (expected: >= 0)");
        }
        this.closeNotifyReadTimeoutMillis = j;
    }

    public SSLEngine engine() {
        return this.engine;
    }

    public String applicationProtocol() {
        Object engine = engine();
        if (engine instanceof ApplicationProtocolAccessor) {
            return ((ApplicationProtocolAccessor) engine).getNegotiatedApplicationProtocol();
        }
        return null;
    }

    public Future<Channel> handshakeFuture() {
        return this.handshakePromise;
    }

    @Deprecated
    public ChannelFuture close() {
        return close(this.ctx.newPromise());
    }

    @Deprecated
    public ChannelFuture close(final ChannelPromise channelPromise) {
        final ChannelHandlerContext channelHandlerContext = this.ctx;
        channelHandlerContext.executor().execute(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.1
            @Override // java.lang.Runnable
            public void run() {
                SslHandler.this.outboundClosed = true;
                SslHandler.this.engine.closeOutbound();
                try {
                    SslHandler.this.flush(channelHandlerContext, channelPromise);
                } catch (Exception e) {
                    if (channelPromise.tryFailure(e)) {
                        return;
                    }
                    SslHandler.logger.warn("{} flush() raised a masked exception.", channelHandlerContext.channel(), e);
                }
            }
        });
        return channelPromise;
    }

    public Future<Channel> sslCloseFuture() {
        return this.sslClosePromise;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.pendingUnencryptedWrites.isEmpty()) {
            this.pendingUnencryptedWrites.releaseAndFailAll(channelHandlerContext, new ChannelException("Pending write on removal of SslHandler"));
        }
        this.pendingUnencryptedWrites = null;
        Object obj = this.engine;
        if (obj instanceof ReferenceCounted) {
            ((ReferenceCounted) obj).release();
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.bind(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.deregister(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        closeOutboundAndChannel(channelHandlerContext, channelPromise, true);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        closeOutboundAndChannel(channelHandlerContext, channelPromise, false);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.handshakePromise.isDone()) {
            this.readDuringHandshake = true;
        }
        channelHandlerContext.read();
    }

    private static IllegalStateException newPendingWritesNullException() {
        return new IllegalStateException("pendingUnencryptedWrites is null, handlerRemoved0 called?");
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (!(obj instanceof ByteBuf)) {
            UnsupportedMessageTypeException unsupportedMessageTypeException = new UnsupportedMessageTypeException(obj, (Class<?>[]) new Class[]{ByteBuf.class});
            ReferenceCountUtil.safeRelease(obj);
            channelPromise.setFailure((Throwable) unsupportedMessageTypeException);
        } else {
            SslHandlerCoalescingBufferQueue sslHandlerCoalescingBufferQueue = this.pendingUnencryptedWrites;
            if (sslHandlerCoalescingBufferQueue == null) {
                ReferenceCountUtil.safeRelease(obj);
                channelPromise.setFailure((Throwable) newPendingWritesNullException());
            } else {
                sslHandlerCoalescingBufferQueue.add((ByteBuf) obj, channelPromise);
            }
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.startTls && !this.sentFirstMessage) {
            this.sentFirstMessage = true;
            this.pendingUnencryptedWrites.writeAndRemoveAll(channelHandlerContext);
            forceFlush(channelHandlerContext);
        } else {
            try {
                wrapAndFlush(channelHandlerContext);
            } catch (Throwable th) {
                setHandshakeFailure(channelHandlerContext, th);
                PlatformDependent.throwException(th);
            }
        }
    }

    private void wrapAndFlush(ChannelHandlerContext channelHandlerContext) throws SSLException {
        if (this.pendingUnencryptedWrites.isEmpty()) {
            this.pendingUnencryptedWrites.add(Unpooled.EMPTY_BUFFER, channelHandlerContext.newPromise());
        }
        if (!this.handshakePromise.isDone()) {
            this.flushedBeforeHandshake = true;
        }
        try {
            wrap(channelHandlerContext, false);
        } finally {
            forceFlush(channelHandlerContext);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0080, code lost:
    
        if (r4 == 2) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0083, code lost:
    
        if (r4 == 3) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0086, code lost:
    
        if (r4 == 4) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0089, code lost:
    
        if (r4 != 5) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008b, code lost:
    
        r11 = true;
        r6 = r12;
        r7 = r13;
        r8 = r5;
        r9 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0056, code lost:
    
        r6.finishWrap(r7, r8, r9, r14, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ad, code lost:
    
        throw new java.lang.IllegalStateException("Unknown handshake status: " + r6.getHandshakeStatus());
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b1, code lost:
    
        setHandshakeSuccessIfStillHandshaking();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ae, code lost:
    
        setHandshakeSuccess();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0044, code lost:
    
        r4.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0047, code lost:
    
        r0 = io.netty.handler.ssl.SslHandler.SSLENGINE_CLOSED;
        r3.tryFailure(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x004c, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x004d, code lost:
    
        r12.pendingUnencryptedWrites.releaseAndFailAll(r13, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0052, code lost:
    
        r11 = false;
        r6 = r12;
        r7 = r13;
        r8 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x005b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x005c, code lost:
    
        r4 = r5;
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void wrap(io.netty.channel.ChannelHandlerContext r13, boolean r14) throws javax.net.ssl.SSLException {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslHandler.wrap(io.netty.channel.ChannelHandlerContext, boolean):void");
    }

    private void finishWrap(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ChannelPromise channelPromise, boolean z, boolean z2) {
        if (byteBuf == null) {
            byteBuf = Unpooled.EMPTY_BUFFER;
        } else if (!byteBuf.isReadable()) {
            byteBuf.release();
            byteBuf = Unpooled.EMPTY_BUFFER;
        }
        if (channelPromise != null) {
            channelHandlerContext.write(byteBuf, channelPromise);
        } else {
            channelHandlerContext.write(byteBuf);
        }
        if (z) {
            this.needsFlush = true;
        }
        if (z2) {
            readIfNeeded(channelHandlerContext);
        }
    }

    private boolean wrapNonAppData(ChannelHandlerContext channelHandlerContext, boolean z) throws SSLException {
        ByteBufAllocator alloc = channelHandlerContext.alloc();
        ByteBuf byteBuf = null;
        while (!channelHandlerContext.isRemoved()) {
            try {
                if (byteBuf == null) {
                    byteBuf = allocateOutNetBuf(channelHandlerContext, 2048, 1);
                }
                SSLEngineResult wrap = wrap(alloc, this.engine, Unpooled.EMPTY_BUFFER, byteBuf);
                if (wrap.bytesProduced() > 0) {
                    channelHandlerContext.write(byteBuf);
                    if (z) {
                        this.needsFlush = true;
                    }
                    byteBuf = null;
                }
                int i = AnonymousClass9.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[wrap.getHandshakeStatus().ordinal()];
                if (i == 1) {
                    runDelegatedTasks();
                } else {
                    if (i == 2) {
                        setHandshakeSuccess();
                        if (byteBuf != null) {
                            byteBuf.release();
                        }
                        return false;
                    }
                    if (i == 3) {
                        setHandshakeSuccessIfStillHandshaking();
                        if (!z) {
                            unwrapNonAppData(channelHandlerContext);
                        }
                        if (byteBuf != null) {
                            byteBuf.release();
                        }
                        return true;
                    }
                    if (i != 4) {
                        if (i != 5) {
                            throw new IllegalStateException("Unknown handshake status: " + wrap.getHandshakeStatus());
                        }
                        if (z) {
                            return false;
                        }
                        unwrapNonAppData(channelHandlerContext);
                    }
                }
                if (wrap.bytesProduced() == 0 || (wrap.bytesConsumed() == 0 && wrap.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING)) {
                    break;
                }
            } finally {
                if (byteBuf != null) {
                    byteBuf.release();
                }
            }
        }
        if (byteBuf != null) {
            byteBuf.release();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0080 A[Catch: all -> 0x008c, LOOP:0: B:12:0x0045->B:14:0x0080, LOOP_END, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x008c, blocks: (B:10:0x001c, B:12:0x0045, B:14:0x0080), top: B:9:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0076 A[EDGE_INSN: B:15:0x0076->B:16:0x0076 BREAK  A[LOOP:0: B:12:0x0045->B:14:0x0080], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private javax.net.ssl.SSLEngineResult wrap(io.netty.buffer.ByteBufAllocator r8, javax.net.ssl.SSLEngine r9, io.netty.buffer.ByteBuf r10, io.netty.buffer.ByteBuf r11) throws javax.net.ssl.SSLException {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            int r2 = r10.readerIndex()     // Catch: java.lang.Throwable -> L8e
            int r3 = r10.readableBytes()     // Catch: java.lang.Throwable -> L8e
            boolean r4 = r10.isDirect()     // Catch: java.lang.Throwable -> L8e
            r5 = 1
            if (r4 != 0) goto L2c
            io.netty.handler.ssl.SslHandler$SslEngineType r4 = r7.engineType     // Catch: java.lang.Throwable -> L8e
            boolean r4 = r4.wantsDirectBuffer     // Catch: java.lang.Throwable -> L8e
            if (r4 != 0) goto L18
            goto L2c
        L18:
            io.netty.buffer.ByteBuf r8 = r8.directBuffer(r3)     // Catch: java.lang.Throwable -> L8e
            r8.writeBytes(r10, r2, r3)     // Catch: java.lang.Throwable -> L8c
            java.nio.ByteBuffer[] r2 = r7.singleBuffer     // Catch: java.lang.Throwable -> L8c
            int r4 = r8.readerIndex()     // Catch: java.lang.Throwable -> L8c
            java.nio.ByteBuffer r3 = r8.internalNioBuffer(r4, r3)     // Catch: java.lang.Throwable -> L8c
            r2[r1] = r3     // Catch: java.lang.Throwable -> L8c
            goto L45
        L2c:
            boolean r8 = r10 instanceof io.netty.buffer.CompositeByteBuf     // Catch: java.lang.Throwable -> L8e
            if (r8 != 0) goto L40
            int r8 = r10.nioBufferCount()     // Catch: java.lang.Throwable -> L8e
            if (r8 != r5) goto L40
            java.nio.ByteBuffer[] r8 = r7.singleBuffer     // Catch: java.lang.Throwable -> L8e
            java.nio.ByteBuffer r2 = r10.internalNioBuffer(r2, r3)     // Catch: java.lang.Throwable -> L8e
            r8[r1] = r2     // Catch: java.lang.Throwable -> L8e
            r2 = r8
            goto L44
        L40:
            java.nio.ByteBuffer[] r2 = r10.nioBuffers()     // Catch: java.lang.Throwable -> L8e
        L44:
            r8 = r0
        L45:
            int r3 = r11.writerIndex()     // Catch: java.lang.Throwable -> L8c
            int r4 = r11.writableBytes()     // Catch: java.lang.Throwable -> L8c
            java.nio.ByteBuffer r3 = r11.nioBuffer(r3, r4)     // Catch: java.lang.Throwable -> L8c
            javax.net.ssl.SSLEngineResult r3 = r9.wrap(r2, r3)     // Catch: java.lang.Throwable -> L8c
            int r4 = r3.bytesConsumed()     // Catch: java.lang.Throwable -> L8c
            r10.skipBytes(r4)     // Catch: java.lang.Throwable -> L8c
            int r4 = r11.writerIndex()     // Catch: java.lang.Throwable -> L8c
            int r6 = r3.bytesProduced()     // Catch: java.lang.Throwable -> L8c
            int r4 = r4 + r6
            r11.writerIndex(r4)     // Catch: java.lang.Throwable -> L8c
            int[] r4 = io.netty.handler.ssl.SslHandler.AnonymousClass9.$SwitchMap$javax$net$ssl$SSLEngineResult$Status     // Catch: java.lang.Throwable -> L8c
            javax.net.ssl.SSLEngineResult$Status r6 = r3.getStatus()     // Catch: java.lang.Throwable -> L8c
            int r6 = r6.ordinal()     // Catch: java.lang.Throwable -> L8c
            r4 = r4[r6]     // Catch: java.lang.Throwable -> L8c
            if (r4 == r5) goto L80
            java.nio.ByteBuffer[] r9 = r7.singleBuffer
            r9[r1] = r0
            if (r8 == 0) goto L7f
            r8.release()
        L7f:
            return r3
        L80:
            javax.net.ssl.SSLSession r3 = r9.getSession()     // Catch: java.lang.Throwable -> L8c
            int r3 = r3.getPacketBufferSize()     // Catch: java.lang.Throwable -> L8c
            r11.ensureWritable(r3)     // Catch: java.lang.Throwable -> L8c
            goto L45
        L8c:
            r9 = move-exception
            goto L90
        L8e:
            r9 = move-exception
            r8 = r0
        L90:
            java.nio.ByteBuffer[] r10 = r7.singleBuffer
            r10[r1] = r0
            if (r8 == 0) goto L99
            r8.release()
        L99:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslHandler.wrap(io.netty.buffer.ByteBufAllocator, javax.net.ssl.SSLEngine, io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf):javax.net.ssl.SSLEngineResult");
    }

    /* renamed from: io.netty.handler.ssl.SslHandler$9, reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus;
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$Status;

        static {
            int[] iArr = new int[SSLEngineResult.Status.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$Status = iArr;
            try {
                iArr[SSLEngineResult.Status.BUFFER_OVERFLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[SSLEngineResult.HandshakeStatus.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = iArr2;
            try {
                iArr2[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        ClosedChannelException closedChannelException = CHANNEL_CLOSED;
        setHandshakeFailure(channelHandlerContext, closedChannelException, !this.outboundClosed, this.handshakeStarted);
        notifyClosePromise(closedChannelException);
        super.channelInactive(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        if (ignoreException(th)) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("{} Swallowing a harmless 'connection reset by peer / broken pipe' error that occurred while writing close_notify in response to the peer's close_notify", channelHandlerContext.channel(), th);
            }
            if (channelHandlerContext.channel().isActive()) {
                channelHandlerContext.close();
                return;
            }
            return;
        }
        channelHandlerContext.fireExceptionCaught(th);
    }

    private boolean ignoreException(Throwable th) {
        if (!(th instanceof SSLException) && (th instanceof IOException) && this.sslClosePromise.isDone()) {
            String message = th.getMessage();
            if (message != null && IGNORABLE_ERROR_MESSAGE.matcher(message).matches()) {
                return true;
            }
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                String className = stackTraceElement.getClassName();
                String methodName = stackTraceElement.getMethodName();
                if (!className.startsWith("io.netty.") && "read".equals(methodName)) {
                    if (IGNORABLE_CLASS_IN_STACK.matcher(className).matches()) {
                        return true;
                    }
                    try {
                        Class<?> loadClass = PlatformDependent.getClassLoader(getClass()).loadClass(className);
                        if (!SocketChannel.class.isAssignableFrom(loadClass)) {
                            if (!DatagramChannel.class.isAssignableFrom(loadClass)) {
                                if (PlatformDependent.javaVersion() >= 7 && "com.sun.nio.sctp.SctpChannel".equals(loadClass.getSuperclass().getName())) {
                                }
                            }
                        }
                        return true;
                    } catch (Throwable th2) {
                        logger.debug("Unexpected exception while loading class {} classname {}", getClass(), className, th2);
                    }
                }
            }
        }
        return false;
    }

    public static boolean isEncrypted(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() >= 5) {
            return SslUtils.getEncryptedPacketLength(byteBuf, byteBuf.readerIndex()) != -2;
        }
        throw new IllegalArgumentException("buffer must have at least 5 readable bytes");
    }

    private void decodeJdkCompatible(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws NotSslRecordException {
        int i = this.packetLength;
        if (i > 0) {
            if (byteBuf.readableBytes() < i) {
                return;
            }
        } else {
            int readableBytes = byteBuf.readableBytes();
            if (readableBytes < 5) {
                return;
            }
            int encryptedPacketLength = SslUtils.getEncryptedPacketLength(byteBuf, byteBuf.readerIndex());
            if (encryptedPacketLength == -2) {
                NotSslRecordException notSslRecordException = new NotSslRecordException("not an SSL/TLS record: " + ByteBufUtil.hexDump(byteBuf));
                byteBuf.skipBytes(byteBuf.readableBytes());
                setHandshakeFailure(channelHandlerContext, notSslRecordException);
                throw notSslRecordException;
            }
            if (encryptedPacketLength > readableBytes) {
                this.packetLength = encryptedPacketLength;
                return;
            }
            i = encryptedPacketLength;
        }
        this.packetLength = 0;
        try {
            byteBuf.skipBytes(unwrap(channelHandlerContext, byteBuf, byteBuf.readerIndex(), i));
        } catch (Throwable th) {
            handleUnwrapThrowable(channelHandlerContext, th);
        }
    }

    private void decodeNonJdkCompatible(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        try {
            byteBuf.skipBytes(unwrap(channelHandlerContext, byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes()));
        } catch (Throwable th) {
            handleUnwrapThrowable(channelHandlerContext, th);
        }
    }

    private void handleUnwrapThrowable(ChannelHandlerContext channelHandlerContext, Throwable th) {
        try {
            try {
                wrapAndFlush(channelHandlerContext);
            } catch (SSLException e) {
                logger.debug("SSLException during trying to call SSLEngine.wrap(...) because of an previous SSLException, ignoring...", (Throwable) e);
            }
            PlatformDependent.throwException(th);
        } finally {
            setHandshakeFailure(channelHandlerContext, th);
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws SSLException {
        if (this.jdkCompatibilityMode) {
            decodeJdkCompatible(channelHandlerContext, byteBuf);
        } else {
            decodeNonJdkCompatible(channelHandlerContext, byteBuf);
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        discardSomeReadBytes();
        flushIfNeeded(channelHandlerContext);
        readIfNeeded(channelHandlerContext);
        this.firedChannelRead = false;
        channelHandlerContext.fireChannelReadComplete();
    }

    private void readIfNeeded(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.channel().config().isAutoRead()) {
            return;
        }
        if (this.firedChannelRead && this.handshakePromise.isDone()) {
            return;
        }
        channelHandlerContext.read();
    }

    private void flushIfNeeded(ChannelHandlerContext channelHandlerContext) {
        if (this.needsFlush) {
            forceFlush(channelHandlerContext);
        }
    }

    private void unwrapNonAppData(ChannelHandlerContext channelHandlerContext) throws SSLException {
        unwrap(channelHandlerContext, Unpooled.EMPTY_BUFFER, 0, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0047, code lost:
    
        if (r5 == 2) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x004c, code lost:
    
        r5 = io.netty.handler.ssl.SslHandler.AnonymousClass9.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[r3.ordinal()];
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0054, code lost:
    
        if (r5 == 1) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0056, code lost:
    
        if (r5 == 2) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0059, code lost:
    
        if (r5 == 3) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0089, code lost:
    
        if (setHandshakeSuccessIfStillHandshaking() == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008b, code lost:
    
        r16 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0090, code lost:
    
        if (r18.flushedBeforeHandshake == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0092, code lost:
    
        r18.flushedBeforeHandshake = false;
        r16 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0096, code lost:
    
        if (r14 != 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a5, code lost:
    
        if (r2 == javax.net.ssl.SSLEngineResult.Status.BUFFER_UNDERFLOW) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a7, code lost:
    
        if (r1 != 0) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a9, code lost:
    
        if (r4 != 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ad, code lost:
    
        if (r3 != javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_UNWRAP) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00af, code lost:
    
        readIfNeeded(r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0129, code lost:
    
        if (r16 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x012b, code lost:
    
        wrap(r19, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x012e, code lost:
    
        if (r17 == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0130, code lost:
    
        notifyClosePromise(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0133, code lost:
    
        if (r13 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0139, code lost:
    
        if (r13.isReadable() == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x013b, code lost:
    
        r18.firedChannelRead = true;
        r19.fireChannelRead((java.lang.Object) r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0141, code lost:
    
        r13.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0145, code lost:
    
        return r22 - r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0014, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x005c, code lost:
    
        if (r5 == 4) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x005f, code lost:
    
        if (r5 != 5) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x007a, code lost:
    
        throw new java.lang.IllegalStateException("unknown handshake status: " + r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x007f, code lost:
    
        if (wrapNonAppData(r19, true) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0081, code lost:
    
        if (r14 != 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x009a, code lost:
    
        setHandshakeSuccess();
        r16 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00a0, code lost:
    
        runDelegatedTasks();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x004a, code lost:
    
        r17 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int unwrap(io.netty.channel.ChannelHandlerContext r19, io.netty.buffer.ByteBuf r20, int r21, int r22) throws javax.net.ssl.SSLException {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslHandler.unwrap(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteBuffer toByteBuffer(ByteBuf byteBuf, int i, int i2) {
        return byteBuf.nioBufferCount() == 1 ? byteBuf.internalNioBuffer(i, i2) : byteBuf.nioBuffer(i, i2);
    }

    private void runDelegatedTasks() {
        if (this.delegatedTaskExecutor != ImmediateExecutor.INSTANCE) {
            final ArrayList arrayList = new ArrayList(2);
            while (true) {
                Runnable delegatedTask = this.engine.getDelegatedTask();
                if (delegatedTask == null) {
                    break;
                } else {
                    arrayList.add(delegatedTask);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.delegatedTaskExecutor.execute(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((Runnable) it.next()).run();
                            }
                        } catch (Exception e) {
                            SslHandler.this.ctx.fireExceptionCaught((Throwable) e);
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            });
            boolean z = false;
            while (countDownLatch.getCount() != 0) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException unused) {
                    z = true;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
                return;
            }
            return;
        }
        while (true) {
            Runnable delegatedTask2 = this.engine.getDelegatedTask();
            if (delegatedTask2 == null) {
                return;
            } else {
                delegatedTask2.run();
            }
        }
    }

    private boolean setHandshakeSuccessIfStillHandshaking() {
        if (this.handshakePromise.isDone()) {
            return false;
        }
        setHandshakeSuccess();
        return true;
    }

    private void setHandshakeSuccess() {
        this.handshakePromise.trySuccess(this.ctx.channel());
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("{} HANDSHAKEN: {}", this.ctx.channel(), this.engine.getSession().getCipherSuite());
        }
        this.ctx.fireUserEventTriggered((Object) SslHandshakeCompletionEvent.SUCCESS);
        if (!this.readDuringHandshake || this.ctx.channel().config().isAutoRead()) {
            return;
        }
        this.readDuringHandshake = false;
        this.ctx.read();
    }

    private void setHandshakeFailure(ChannelHandlerContext channelHandlerContext, Throwable th) {
        setHandshakeFailure(channelHandlerContext, th, true, true);
    }

    private void setHandshakeFailure(ChannelHandlerContext channelHandlerContext, Throwable th, boolean z, boolean z2) {
        String message;
        try {
            this.engine.closeOutbound();
            if (z) {
                try {
                    this.engine.closeInbound();
                } catch (SSLException e) {
                    InternalLogger internalLogger = logger;
                    if (internalLogger.isDebugEnabled() && ((message = e.getMessage()) == null || !message.contains("possible truncation attack"))) {
                        internalLogger.debug("{} SSLEngine.closeInbound() raised an exception.", channelHandlerContext.channel(), e);
                    }
                }
            }
            notifyHandshakeFailure(th, z2);
        } finally {
            releaseAndFailAll(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseAndFailAll(Throwable th) {
        SslHandlerCoalescingBufferQueue sslHandlerCoalescingBufferQueue = this.pendingUnencryptedWrites;
        if (sslHandlerCoalescingBufferQueue != null) {
            sslHandlerCoalescingBufferQueue.releaseAndFailAll(this.ctx, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyHandshakeFailure(Throwable th, boolean z) {
        if (this.handshakePromise.tryFailure(th)) {
            SslUtils.notifyHandshakeFailure(this.ctx, th, z);
        }
    }

    private void notifyClosePromise(Throwable th) {
        if (th == null) {
            if (this.sslClosePromise.trySuccess(this.ctx.channel())) {
                this.ctx.fireUserEventTriggered((Object) SslCloseCompletionEvent.SUCCESS);
            }
        } else if (this.sslClosePromise.tryFailure(th)) {
            this.ctx.fireUserEventTriggered((Object) new SslCloseCompletionEvent(th));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [io.netty.channel.ChannelPromise] */
    /* JADX WARN: Type inference failed for: r7v2, types: [io.netty.channel.ChannelPromise] */
    private void closeOutboundAndChannel(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise, boolean z) throws Exception {
        if (!channelHandlerContext.channel().isActive()) {
            if (z) {
                channelHandlerContext.disconnect(channelPromise);
                return;
            } else {
                channelHandlerContext.close(channelPromise);
                return;
            }
        }
        this.outboundClosed = true;
        this.engine.closeOutbound();
        ChannelPromise newPromise = channelHandlerContext.newPromise();
        try {
            flush(channelHandlerContext, newPromise);
            safeClose(channelHandlerContext, newPromise, channelHandlerContext.newPromise().addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelPromiseNotifier(false, channelPromise)));
        } catch (Throwable th) {
            safeClose(channelHandlerContext, newPromise, channelHandlerContext.newPromise().addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelPromiseNotifier(false, channelPromise)));
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flush(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        SslHandlerCoalescingBufferQueue sslHandlerCoalescingBufferQueue = this.pendingUnencryptedWrites;
        if (sslHandlerCoalescingBufferQueue != null) {
            sslHandlerCoalescingBufferQueue.add(Unpooled.EMPTY_BUFFER, channelPromise);
        } else {
            channelPromise.setFailure((Throwable) newPendingWritesNullException());
        }
        flush(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
        this.pendingUnencryptedWrites = new SslHandlerCoalescingBufferQueue(channelHandlerContext.channel(), 16);
        if (channelHandlerContext.channel().isActive()) {
            startHandshakeProcessing();
        }
    }

    private void startHandshakeProcessing() {
        this.handshakeStarted = true;
        if (this.engine.getUseClientMode()) {
            handshake(null);
        } else {
            applyHandshakeTimeout(null);
        }
    }

    public Future<Channel> renegotiate() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext == null) {
            throw new IllegalStateException();
        }
        return renegotiate(channelHandlerContext.executor().newPromise());
    }

    public Future<Channel> renegotiate(final Promise<Channel> promise) {
        Objects.requireNonNull(promise, "promise");
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext == null) {
            throw new IllegalStateException();
        }
        EventExecutor executor = channelHandlerContext.executor();
        if (!executor.inEventLoop()) {
            executor.execute(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.3
                @Override // java.lang.Runnable
                public void run() {
                    SslHandler.this.handshake(promise);
                }
            });
            return promise;
        }
        handshake(promise);
        return promise;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handshake(final Promise<Channel> promise) {
        if (promise != null) {
            Promise<Channel> promise2 = this.handshakePromise;
            if (!promise2.isDone()) {
                promise2.addListener((GenericFutureListener<? extends Future<? super Channel>>) new FutureListener<Channel>() { // from class: io.netty.handler.ssl.SslHandler.4
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(Future<Channel> future) throws Exception {
                        if (future.isSuccess()) {
                            promise.setSuccess(future.getNow());
                        } else {
                            promise.setFailure(future.cause());
                        }
                    }
                });
                return;
            }
            this.handshakePromise = promise;
        } else if (this.engine.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            return;
        } else {
            promise = this.handshakePromise;
        }
        ChannelHandlerContext channelHandlerContext = this.ctx;
        try {
            this.engine.beginHandshake();
            wrapNonAppData(channelHandlerContext, false);
        } finally {
            try {
                forceFlush(channelHandlerContext);
                applyHandshakeTimeout(promise);
            } catch (Throwable th) {
            }
        }
        forceFlush(channelHandlerContext);
        applyHandshakeTimeout(promise);
    }

    private void applyHandshakeTimeout(final Promise<Channel> promise) {
        if (promise == null) {
            promise = this.handshakePromise;
        }
        long j = this.handshakeTimeoutMillis;
        if (j <= 0 || promise.isDone()) {
            return;
        }
        final ScheduledFuture<?> schedule = this.ctx.executor().schedule(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.5
            @Override // java.lang.Runnable
            public void run() {
                if (promise.isDone()) {
                    return;
                }
                try {
                    SslHandler.this.notifyHandshakeFailure(SslHandler.HANDSHAKE_TIMED_OUT, true);
                } finally {
                    SslHandler.this.releaseAndFailAll(SslHandler.HANDSHAKE_TIMED_OUT);
                }
            }
        }, j, TimeUnit.MILLISECONDS);
        promise.addListener((GenericFutureListener<? extends Future<? super Channel>>) new FutureListener<Channel>() { // from class: io.netty.handler.ssl.SslHandler.6
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<Channel> future) throws Exception {
                schedule.cancel(false);
            }
        });
    }

    private void forceFlush(ChannelHandlerContext channelHandlerContext) {
        this.needsFlush = false;
        channelHandlerContext.flush();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.startTls) {
            startHandshakeProcessing();
        }
        channelHandlerContext.fireChannelActive();
    }

    private void safeClose(final ChannelHandlerContext channelHandlerContext, final ChannelFuture channelFuture, final ChannelPromise channelPromise) {
        if (!channelHandlerContext.channel().isActive()) {
            channelHandlerContext.close(channelPromise);
            return;
        }
        final ScheduledFuture<?> scheduledFuture = null;
        if (!channelFuture.isDone()) {
            long j = this.closeNotifyFlushTimeoutMillis;
            if (j > 0) {
                scheduledFuture = channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (channelFuture.isDone()) {
                            return;
                        }
                        SslHandler.logger.warn("{} Last write attempt timed out; force-closing the connection.", channelHandlerContext.channel());
                        ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
                        SslHandler.addCloseListener(channelHandlerContext2.close(channelHandlerContext2.newPromise()), channelPromise);
                    }
                }, j, TimeUnit.MILLISECONDS);
            }
        }
        channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.ssl.SslHandler.8
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                java.util.concurrent.ScheduledFuture scheduledFuture2 = scheduledFuture;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(false);
                }
                final long j2 = SslHandler.this.closeNotifyReadTimeoutMillis;
                if (j2 <= 0) {
                    ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
                    SslHandler.addCloseListener(channelHandlerContext2.close(channelHandlerContext2.newPromise()), channelPromise);
                } else {
                    final ScheduledFuture<?> schedule = !SslHandler.this.sslClosePromise.isDone() ? channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SslHandler.this.sslClosePromise.isDone()) {
                                return;
                            }
                            SslHandler.logger.debug("{} did not receive close_notify in {}ms; force-closing the connection.", channelHandlerContext.channel(), Long.valueOf(j2));
                            SslHandler.addCloseListener(channelHandlerContext.close(channelHandlerContext.newPromise()), channelPromise);
                        }
                    }, j2, TimeUnit.MILLISECONDS) : null;
                    SslHandler.this.sslClosePromise.addListener((GenericFutureListener) new FutureListener<Channel>() { // from class: io.netty.handler.ssl.SslHandler.8.2
                        @Override // io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(Future<Channel> future) throws Exception {
                            java.util.concurrent.ScheduledFuture scheduledFuture3 = schedule;
                            if (scheduledFuture3 != null) {
                                scheduledFuture3.cancel(false);
                            }
                            SslHandler.addCloseListener(channelHandlerContext.close(channelHandlerContext.newPromise()), channelPromise);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addCloseListener(ChannelFuture channelFuture, ChannelPromise channelPromise) {
        channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelPromiseNotifier(false, channelPromise));
    }

    private ByteBuf allocate(ChannelHandlerContext channelHandlerContext, int i) {
        ByteBufAllocator alloc = channelHandlerContext.alloc();
        if (this.engineType.wantsDirectBuffer) {
            return alloc.directBuffer(i);
        }
        return alloc.buffer(i);
    }

    private ByteBuf allocateOutNetBuf(ChannelHandlerContext channelHandlerContext, int i, int i2) {
        return allocate(channelHandlerContext, this.engineType.calculateWrapBufferCapacity(this, i, i2));
    }

    private final class SslHandlerCoalescingBufferQueue extends AbstractCoalescingBufferQueue {
        @Override // io.netty.channel.AbstractCoalescingBufferQueue
        protected ByteBuf removeEmptyValue() {
            return null;
        }

        SslHandlerCoalescingBufferQueue(Channel channel, int i) {
            super(channel, i);
        }

        @Override // io.netty.channel.AbstractCoalescingBufferQueue
        protected ByteBuf compose(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
            int i = SslHandler.this.wrapDataSize;
            if (!(byteBuf instanceof CompositeByteBuf)) {
                return SslHandler.attemptCopyToCumulation(byteBuf, byteBuf2, i) ? byteBuf : copyAndCompose(byteBufAllocator, byteBuf, byteBuf2);
            }
            CompositeByteBuf compositeByteBuf = (CompositeByteBuf) byteBuf;
            int numComponents = compositeByteBuf.numComponents();
            if (numComponents == 0 || !SslHandler.attemptCopyToCumulation(compositeByteBuf.internalComponent(numComponents - 1), byteBuf2, i)) {
                compositeByteBuf.addComponent(true, byteBuf2);
            }
            return compositeByteBuf;
        }

        @Override // io.netty.channel.AbstractCoalescingBufferQueue
        protected ByteBuf composeFirst(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf) {
            if (!(byteBuf instanceof CompositeByteBuf)) {
                return byteBuf;
            }
            CompositeByteBuf compositeByteBuf = (CompositeByteBuf) byteBuf;
            ByteBuf directBuffer = byteBufAllocator.directBuffer(compositeByteBuf.readableBytes());
            try {
                directBuffer.writeBytes(compositeByteBuf);
            } catch (Throwable th) {
                directBuffer.release();
                PlatformDependent.throwException(th);
            }
            compositeByteBuf.release();
            return directBuffer;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean attemptCopyToCumulation(ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        int readableBytes = byteBuf2.readableBytes();
        int capacity = byteBuf.capacity();
        if (i - byteBuf.readableBytes() < readableBytes || ((!byteBuf.isWritable(readableBytes) || capacity < i) && (capacity >= i || !ByteBufUtil.ensureWritableSuccess(byteBuf.ensureWritable(readableBytes, false))))) {
            return false;
        }
        byteBuf.writeBytes(byteBuf2);
        byteBuf2.release();
        return true;
    }

    private final class LazyChannelPromise extends DefaultPromise<Channel> {
        private LazyChannelPromise() {
        }

        @Override // io.netty.util.concurrent.DefaultPromise
        protected EventExecutor executor() {
            if (SslHandler.this.ctx != null) {
                return SslHandler.this.ctx.executor();
            }
            throw new IllegalStateException();
        }

        @Override // io.netty.util.concurrent.DefaultPromise
        protected void checkDeadLock() {
            if (SslHandler.this.ctx == null) {
                return;
            }
            super.checkDeadLock();
        }
    }
}

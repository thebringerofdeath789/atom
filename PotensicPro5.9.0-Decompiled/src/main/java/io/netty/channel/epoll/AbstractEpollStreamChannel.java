package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.EventLoop;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.epoll.AbstractEpollChannel;
import io.netty.channel.socket.DuplexChannel;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.SocketWritableByteChannel;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.util.Queue;
import java.util.concurrent.Executor;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public abstract class AbstractEpollStreamChannel extends AbstractEpollChannel implements DuplexChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private WritableByteChannel byteChannel;
    private final Runnable flushTask;
    private FileDescriptor pipeIn;
    private FileDescriptor pipeOut;
    private Queue<SpliceInTask> spliceQueue;
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) DefaultFileRegion.class) + PropertyUtils.MAPPED_DELIM2;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractEpollStreamChannel.class);
    private static final ClosedChannelException CLEAR_SPLICE_QUEUE_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), AbstractEpollStreamChannel.class, "clearSpliceQueue()");
    private static final ClosedChannelException SPLICE_TO_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), AbstractEpollStreamChannel.class, "spliceTo(...)");
    private static final ClosedChannelException FAIL_SPLICE_IF_CLOSED_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), AbstractEpollStreamChannel.class, "failSpliceIfClosed(...)");

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isActive() {
        return super.isActive();
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    protected AbstractEpollStreamChannel(Channel channel, int i) {
        this(channel, new LinuxSocket(i));
    }

    protected AbstractEpollStreamChannel(int i) {
        this(new LinuxSocket(i));
    }

    AbstractEpollStreamChannel(LinuxSocket linuxSocket) {
        this(linuxSocket, isSoErrorZero(linuxSocket));
    }

    AbstractEpollStreamChannel(Channel channel, LinuxSocket linuxSocket) {
        super(channel, linuxSocket, Native.EPOLLIN, true);
        this.flushTask = new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractEpollStreamChannel.this.flush();
            }
        };
        this.flags |= Native.EPOLLRDHUP;
    }

    AbstractEpollStreamChannel(Channel channel, LinuxSocket linuxSocket, SocketAddress socketAddress) {
        super(channel, linuxSocket, Native.EPOLLIN, socketAddress);
        this.flushTask = new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractEpollStreamChannel.this.flush();
            }
        };
        this.flags |= Native.EPOLLRDHUP;
    }

    protected AbstractEpollStreamChannel(LinuxSocket linuxSocket, boolean z) {
        super((Channel) null, linuxSocket, Native.EPOLLIN, z);
        this.flushTask = new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractEpollStreamChannel.this.flush();
            }
        };
        this.flags |= Native.EPOLLRDHUP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollStreamUnsafe();
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    public final ChannelFuture spliceTo(AbstractEpollStreamChannel abstractEpollStreamChannel, int i) {
        return spliceTo(abstractEpollStreamChannel, i, newPromise());
    }

    public final ChannelFuture spliceTo(AbstractEpollStreamChannel abstractEpollStreamChannel, int i, ChannelPromise channelPromise) {
        if (abstractEpollStreamChannel.eventLoop() != eventLoop()) {
            throw new IllegalArgumentException("EventLoops are not the same.");
        }
        if (i < 0) {
            throw new IllegalArgumentException("len: " + i + " (expected: >= 0)");
        }
        if (abstractEpollStreamChannel.config().getEpollMode() != EpollMode.LEVEL_TRIGGERED || config().getEpollMode() != EpollMode.LEVEL_TRIGGERED) {
            throw new IllegalStateException("spliceTo() supported only when using " + EpollMode.LEVEL_TRIGGERED);
        }
        ObjectUtil.checkNotNull(channelPromise, "promise");
        if (!isOpen()) {
            channelPromise.tryFailure(SPLICE_TO_CLOSED_CHANNEL_EXCEPTION);
        } else {
            addToSpliceQueue(new SpliceInChannelTask(abstractEpollStreamChannel, i, channelPromise));
            failSpliceIfClosed(channelPromise);
        }
        return channelPromise;
    }

    public final ChannelFuture spliceTo(FileDescriptor fileDescriptor, int i, int i2) {
        return spliceTo(fileDescriptor, i, i2, newPromise());
    }

    public final ChannelFuture spliceTo(FileDescriptor fileDescriptor, int i, int i2, ChannelPromise channelPromise) {
        if (i2 < 0) {
            throw new IllegalArgumentException("len: " + i2 + " (expected: >= 0)");
        }
        if (i < 0) {
            throw new IllegalArgumentException("offset must be >= 0 but was " + i);
        }
        if (config().getEpollMode() != EpollMode.LEVEL_TRIGGERED) {
            throw new IllegalStateException("spliceTo() supported only when using " + EpollMode.LEVEL_TRIGGERED);
        }
        ObjectUtil.checkNotNull(channelPromise, "promise");
        if (!isOpen()) {
            channelPromise.tryFailure(SPLICE_TO_CLOSED_CHANNEL_EXCEPTION);
        } else {
            addToSpliceQueue(new SpliceFdTask(fileDescriptor, i, i2, channelPromise));
            failSpliceIfClosed(channelPromise);
        }
        return channelPromise;
    }

    private void failSpliceIfClosed(ChannelPromise channelPromise) {
        if (isOpen() || !channelPromise.tryFailure(FAIL_SPLICE_IF_CLOSED_CLOSED_CHANNEL_EXCEPTION)) {
            return;
        }
        eventLoop().execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.2
            @Override // java.lang.Runnable
            public void run() {
                AbstractEpollStreamChannel.this.clearSpliceQueue();
            }
        });
    }

    private int writeBytes(ChannelOutboundBuffer channelOutboundBuffer, ByteBuf byteBuf) throws Exception {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            channelOutboundBuffer.remove();
            return 0;
        }
        if (byteBuf.hasMemoryAddress() || byteBuf.nioBufferCount() == 1) {
            return doWriteBytes(channelOutboundBuffer, byteBuf);
        }
        ByteBuffer[] nioBuffers = byteBuf.nioBuffers();
        return writeBytesMultiple(channelOutboundBuffer, nioBuffers, nioBuffers.length, readableBytes, config().getMaxBytesPerGatheringWrite());
    }

    private void adjustMaxBytesPerGatheringWrite(long j, long j2, long j3) {
        if (j == j2) {
            long j4 = j << 1;
            if (j4 > j3) {
                config().setMaxBytesPerGatheringWrite(j4);
                return;
            }
            return;
        }
        if (j > 4096) {
            long j5 = j >>> 1;
            if (j2 < j5) {
                config().setMaxBytesPerGatheringWrite(j5);
            }
        }
    }

    private int writeBytesMultiple(ChannelOutboundBuffer channelOutboundBuffer, IovArray iovArray) throws IOException {
        long size = iovArray.size();
        long writevAddresses = this.socket.writevAddresses(iovArray.memoryAddress(0), iovArray.count());
        if (writevAddresses <= 0) {
            return Integer.MAX_VALUE;
        }
        adjustMaxBytesPerGatheringWrite(size, writevAddresses, iovArray.maxBytes());
        channelOutboundBuffer.removeBytes(writevAddresses);
        return 1;
    }

    private int writeBytesMultiple(ChannelOutboundBuffer channelOutboundBuffer, ByteBuffer[] byteBufferArr, int i, long j, long j2) throws IOException {
        if (j > j2) {
            j = j2;
        }
        long writev = this.socket.writev(byteBufferArr, 0, i, j);
        if (writev <= 0) {
            return Integer.MAX_VALUE;
        }
        adjustMaxBytesPerGatheringWrite(j, writev, j2);
        channelOutboundBuffer.removeBytes(writev);
        return 1;
    }

    private int writeDefaultFileRegion(ChannelOutboundBuffer channelOutboundBuffer, DefaultFileRegion defaultFileRegion) throws Exception {
        long count = defaultFileRegion.count();
        if (defaultFileRegion.transferred() >= count) {
            channelOutboundBuffer.remove();
            return 0;
        }
        long transferred = defaultFileRegion.transferred();
        long sendFile = this.socket.sendFile(defaultFileRegion, defaultFileRegion.position(), transferred, count - transferred);
        if (sendFile <= 0) {
            return Integer.MAX_VALUE;
        }
        channelOutboundBuffer.progress(sendFile);
        if (defaultFileRegion.transferred() < count) {
            return 1;
        }
        channelOutboundBuffer.remove();
        return 1;
    }

    private int writeFileRegion(ChannelOutboundBuffer channelOutboundBuffer, FileRegion fileRegion) throws Exception {
        if (fileRegion.transferred() >= fileRegion.count()) {
            channelOutboundBuffer.remove();
            return 0;
        }
        if (this.byteChannel == null) {
            this.byteChannel = new EpollSocketWritableByteChannel();
        }
        long transferTo = fileRegion.transferTo(this.byteChannel, fileRegion.transferred());
        if (transferTo <= 0) {
            return Integer.MAX_VALUE;
        }
        channelOutboundBuffer.progress(transferTo);
        if (fileRegion.transferred() < fileRegion.count()) {
            return 1;
        }
        channelOutboundBuffer.remove();
        return 1;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        int doWriteSingle;
        int writeSpinCount = config().getWriteSpinCount();
        do {
            int size = channelOutboundBuffer.size();
            if (size > 1 && (channelOutboundBuffer.current() instanceof ByteBuf)) {
                doWriteSingle = doWriteMultiple(channelOutboundBuffer);
            } else {
                if (size == 0) {
                    clearFlag(Native.EPOLLOUT);
                    return;
                }
                doWriteSingle = doWriteSingle(channelOutboundBuffer);
            }
            writeSpinCount -= doWriteSingle;
        } while (writeSpinCount > 0);
        if (writeSpinCount == 0) {
            eventLoop().execute(this.flushTask);
        } else {
            setFlag(Native.EPOLLOUT);
        }
    }

    protected int doWriteSingle(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        Object current = channelOutboundBuffer.current();
        if (current instanceof ByteBuf) {
            return writeBytes(channelOutboundBuffer, (ByteBuf) current);
        }
        if (current instanceof DefaultFileRegion) {
            return writeDefaultFileRegion(channelOutboundBuffer, (DefaultFileRegion) current);
        }
        if (current instanceof FileRegion) {
            return writeFileRegion(channelOutboundBuffer, (FileRegion) current);
        }
        if (current instanceof SpliceOutTask) {
            if (!((SpliceOutTask) current).spliceOut()) {
                return Integer.MAX_VALUE;
            }
            channelOutboundBuffer.remove();
            return 1;
        }
        throw new Error();
    }

    private int doWriteMultiple(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        long maxBytesPerGatheringWrite = config().getMaxBytesPerGatheringWrite();
        if (PlatformDependent.hasUnsafe()) {
            IovArray cleanArray = ((EpollEventLoop) eventLoop()).cleanArray();
            cleanArray.maxBytes(maxBytesPerGatheringWrite);
            channelOutboundBuffer.forEachFlushedMessage(cleanArray);
            if (cleanArray.count() >= 1) {
                return writeBytesMultiple(channelOutboundBuffer, cleanArray);
            }
        } else {
            ByteBuffer[] nioBuffers = channelOutboundBuffer.nioBuffers();
            int nioBufferCount = channelOutboundBuffer.nioBufferCount();
            if (nioBufferCount >= 1) {
                return writeBytesMultiple(channelOutboundBuffer, nioBuffers, nioBufferCount, channelOutboundBuffer.nioBufferSize(), maxBytesPerGatheringWrite);
            }
        }
        channelOutboundBuffer.removeBytes(0L);
        return 0;
    }

    @Override // io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf) ? newDirectBuffer(byteBuf) : byteBuf;
        }
        if ((obj instanceof FileRegion) || (obj instanceof SpliceOutTask)) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    @Override // io.netty.channel.AbstractChannel
    protected final void doShutdownOutput() throws Exception {
        this.socket.shutdown(false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownInput0(ChannelPromise channelPromise) {
        try {
            this.socket.shutdown(true, false);
            channelPromise.setSuccess();
        } catch (Throwable th) {
            channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isOutputShutdown() {
        return this.socket.isOutputShutdown();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isInputShutdown() {
        return this.socket.isInputShutdown();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isShutdown() {
        return this.socket.isShutdown();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput() {
        return shutdownOutput(newPromise());
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput(final ChannelPromise channelPromise) {
        EventLoop eventLoop = eventLoop();
        if (eventLoop.inEventLoop()) {
            ((AbstractChannel.AbstractUnsafe) unsafe()).shutdownOutput(channelPromise);
        } else {
            eventLoop.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.3
                @Override // java.lang.Runnable
                public void run() {
                    ((AbstractChannel.AbstractUnsafe) AbstractEpollStreamChannel.this.unsafe()).shutdownOutput(channelPromise);
                }
            });
        }
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput() {
        return shutdownInput(newPromise());
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput(final ChannelPromise channelPromise) {
        Executor prepareToClose = ((EpollStreamUnsafe) unsafe()).prepareToClose();
        if (prepareToClose != null) {
            prepareToClose.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.4
                @Override // java.lang.Runnable
                public void run() {
                    AbstractEpollStreamChannel.this.shutdownInput0(channelPromise);
                }
            });
        } else {
            EventLoop eventLoop = eventLoop();
            if (eventLoop.inEventLoop()) {
                shutdownInput0(channelPromise);
            } else {
                eventLoop.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.5
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractEpollStreamChannel.this.shutdownInput0(channelPromise);
                    }
                });
            }
        }
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown() {
        return shutdown(newPromise());
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown(final ChannelPromise channelPromise) {
        ChannelFuture shutdownOutput = shutdownOutput();
        if (shutdownOutput.isDone()) {
            shutdownOutputDone(shutdownOutput, channelPromise);
        } else {
            shutdownOutput.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.6
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    AbstractEpollStreamChannel.this.shutdownOutputDone(channelFuture, channelPromise);
                }
            });
        }
        return channelPromise;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownOutputDone(final ChannelFuture channelFuture, final ChannelPromise channelPromise) {
        ChannelFuture shutdownInput = shutdownInput();
        if (shutdownInput.isDone()) {
            shutdownDone(channelFuture, shutdownInput, channelPromise);
        } else {
            shutdownInput.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.7
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                    AbstractEpollStreamChannel.shutdownDone(channelFuture, channelFuture2, channelPromise);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void shutdownDone(ChannelFuture channelFuture, ChannelFuture channelFuture2, ChannelPromise channelPromise) {
        Throwable cause = channelFuture.cause();
        Throwable cause2 = channelFuture2.cause();
        if (cause != null) {
            if (cause2 != null) {
                logger.debug("Exception suppressed because a previous exception occurred.", cause2);
            }
            channelPromise.setFailure(cause);
        } else if (cause2 != null) {
            channelPromise.setFailure(cause2);
        } else {
            channelPromise.setSuccess();
        }
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        try {
            super.doClose();
        } finally {
            safeClosePipe(this.pipeIn);
            safeClosePipe(this.pipeOut);
            clearSpliceQueue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSpliceQueue() {
        if (this.spliceQueue == null) {
            return;
        }
        while (true) {
            SpliceInTask poll = this.spliceQueue.poll();
            if (poll == null) {
                return;
            } else {
                poll.promise.tryFailure(CLEAR_SPLICE_QUEUE_CLOSED_CHANNEL_EXCEPTION);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void safeClosePipe(FileDescriptor fileDescriptor) {
        if (fileDescriptor != null) {
            try {
                fileDescriptor.close();
            } catch (IOException e) {
                if (logger.isWarnEnabled()) {
                    logger.warn("Error while closing a pipe", (Throwable) e);
                }
            }
        }
    }

    class EpollStreamUnsafe extends AbstractEpollChannel.AbstractEpollUnsafe {
        EpollStreamUnsafe() {
            super();
        }

        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe
        protected Executor prepareToClose() {
            return super.prepareToClose();
        }

        private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z, EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    this.readPending = false;
                    channelPipeline.fireChannelRead((Object) byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            epollRecvByteAllocatorHandle.readComplete();
            channelPipeline.fireChannelReadComplete();
            channelPipeline.fireExceptionCaught(th);
            if (z || (th instanceof IOException)) {
                shutdownInput(false);
            }
        }

        @Override // io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        EpollRecvByteAllocatorHandle newEpollHandle(RecvByteBufAllocator.ExtendedHandle extendedHandle) {
            return new EpollRecvByteAllocatorStreamingHandle(extendedHandle);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00a7 A[Catch: all -> 0x00ab, TRY_LEAVE, TryCatch #3 {all -> 0x00ab, blocks: (B:22:0x009f, B:24:0x00a7, B:55:0x0084), top: B:54:0x0084 }] */
        @Override // io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void epollInReady() {
            /*
                r9 = this;
                io.netty.channel.epoll.AbstractEpollStreamChannel r0 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                io.netty.channel.epoll.EpollChannelConfig r0 = r0.config()
                io.netty.channel.epoll.AbstractEpollStreamChannel r1 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                boolean r1 = r1.shouldBreakEpollInReady(r0)
                if (r1 == 0) goto L12
                r9.clearEpollIn0()
                return
            L12:
                io.netty.channel.epoll.EpollRecvByteAllocatorHandle r7 = r9.recvBufAllocHandle()
                io.netty.channel.epoll.AbstractEpollStreamChannel r1 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                int r2 = io.netty.channel.epoll.Native.EPOLLET
                boolean r1 = r1.isFlagSet(r2)
                r7.edgeTriggered(r1)
                io.netty.channel.epoll.AbstractEpollStreamChannel r1 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                io.netty.channel.ChannelPipeline r3 = r1.pipeline()
                io.netty.buffer.ByteBufAllocator r1 = r0.getAllocator()
                r7.reset(r0)
                r9.epollInBefore()
            L31:
                r2 = 0
                r4 = 0
                io.netty.channel.epoll.AbstractEpollStreamChannel r5 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> Lb5
                java.util.Queue r5 = io.netty.channel.epoll.AbstractEpollStreamChannel.access$400(r5)     // Catch: java.lang.Throwable -> Lb5
                if (r5 == 0) goto L63
                io.netty.channel.epoll.AbstractEpollStreamChannel r5 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> Lb5
                java.util.Queue r5 = io.netty.channel.epoll.AbstractEpollStreamChannel.access$400(r5)     // Catch: java.lang.Throwable -> Lb5
                java.lang.Object r5 = r5.peek()     // Catch: java.lang.Throwable -> Lb5
                io.netty.channel.epoll.AbstractEpollStreamChannel$SpliceInTask r5 = (io.netty.channel.epoll.AbstractEpollStreamChannel.SpliceInTask) r5     // Catch: java.lang.Throwable -> Lb5
                if (r5 == 0) goto L63
                boolean r5 = r5.spliceIn(r7)     // Catch: java.lang.Throwable -> Lb5
                if (r5 == 0) goto L61
                io.netty.channel.epoll.AbstractEpollStreamChannel r5 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> Lb5
                boolean r5 = r5.isActive()     // Catch: java.lang.Throwable -> Lb5
                if (r5 == 0) goto L98
                io.netty.channel.epoll.AbstractEpollStreamChannel r5 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> Lb5
                java.util.Queue r5 = io.netty.channel.epoll.AbstractEpollStreamChannel.access$400(r5)     // Catch: java.lang.Throwable -> Lb5
                r5.remove()     // Catch: java.lang.Throwable -> Lb5
                goto L98
            L61:
                r8 = r4
                goto L9f
            L63:
                io.netty.buffer.ByteBuf r5 = r7.allocate(r1)     // Catch: java.lang.Throwable -> Lb5
                io.netty.channel.epoll.AbstractEpollStreamChannel r6 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> Lb0
                int r6 = r6.doReadBytes(r5)     // Catch: java.lang.Throwable -> Lb0
                r7.lastBytesRead(r6)     // Catch: java.lang.Throwable -> Lb0
                int r6 = r7.lastBytesRead()     // Catch: java.lang.Throwable -> Lb0
                r8 = 1
                if (r6 > 0) goto L87
                r5.release()     // Catch: java.lang.Throwable -> Lb0
                int r1 = r7.lastBytesRead()     // Catch: java.lang.Throwable -> Lb5
                if (r1 >= 0) goto L81
                goto L82
            L81:
                r8 = r4
            L82:
                if (r8 == 0) goto L9f
                r9.readPending = r4     // Catch: java.lang.Throwable -> Lab
                goto L9f
            L87:
                r7.incMessagesRead(r8)     // Catch: java.lang.Throwable -> Lb0
                r9.readPending = r4     // Catch: java.lang.Throwable -> Lb0
                r3.fireChannelRead(r5)     // Catch: java.lang.Throwable -> Lb0
                io.netty.channel.epoll.AbstractEpollStreamChannel r5 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> Lb5
                boolean r5 = r5.shouldBreakEpollInReady(r0)     // Catch: java.lang.Throwable -> Lb5
                if (r5 == 0) goto L98
                goto L61
            L98:
                boolean r5 = r7.continueReading()     // Catch: java.lang.Throwable -> Lb5
                if (r5 != 0) goto L31
                goto L61
            L9f:
                r7.readComplete()     // Catch: java.lang.Throwable -> Lab
                r3.fireChannelReadComplete()     // Catch: java.lang.Throwable -> Lab
                if (r8 == 0) goto Lbd
                r9.shutdownInput(r4)     // Catch: java.lang.Throwable -> Lab
                goto Lbd
            Lab:
                r1 = move-exception
                r5 = r1
                r4 = r2
                r6 = r8
                goto Lb9
            Lb0:
                r1 = move-exception
                r6 = r4
                r4 = r5
                r5 = r1
                goto Lb9
            Lb5:
                r1 = move-exception
                r5 = r1
                r6 = r4
                r4 = r2
            Lb9:
                r2 = r9
                r2.handleReadException(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> Lc1
            Lbd:
                r9.epollInFinally(r0)
                return
            Lc1:
                r1 = move-exception
                r9.epollInFinally(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.AbstractEpollStreamChannel.EpollStreamUnsafe.epollInReady():void");
        }
    }

    private void addToSpliceQueue(final SpliceInTask spliceInTask) {
        EventLoop eventLoop = eventLoop();
        if (eventLoop.inEventLoop()) {
            addToSpliceQueue0(spliceInTask);
        } else {
            eventLoop.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.8
                @Override // java.lang.Runnable
                public void run() {
                    AbstractEpollStreamChannel.this.addToSpliceQueue0(spliceInTask);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToSpliceQueue0(SpliceInTask spliceInTask) {
        if (this.spliceQueue == null) {
            this.spliceQueue = PlatformDependent.newMpscQueue();
        }
        this.spliceQueue.add(spliceInTask);
    }

    protected abstract class SpliceInTask {
        int len;
        final ChannelPromise promise;

        abstract boolean spliceIn(RecvByteBufAllocator.Handle handle);

        protected SpliceInTask(int i, ChannelPromise channelPromise) {
            this.promise = channelPromise;
            this.len = i;
        }

        protected final int spliceIn(FileDescriptor fileDescriptor, RecvByteBufAllocator.Handle handle) throws IOException {
            int min = Math.min(handle.guess(), this.len);
            int i = 0;
            while (true) {
                int splice = Native.splice(AbstractEpollStreamChannel.this.socket.intValue(), -1L, fileDescriptor.intValue(), -1L, min);
                if (splice == 0) {
                    return i;
                }
                i += splice;
                min -= splice;
            }
        }
    }

    private final class SpliceInChannelTask extends SpliceInTask implements ChannelFutureListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AbstractEpollStreamChannel ch;

        SpliceInChannelTask(AbstractEpollStreamChannel abstractEpollStreamChannel, int i, ChannelPromise channelPromise) {
            super(i, channelPromise);
            this.ch = abstractEpollStreamChannel;
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (channelFuture.isSuccess()) {
                return;
            }
            this.promise.setFailure(channelFuture.cause());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [io.netty.channel.ChannelPromise] */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r4v1, types: [io.netty.channel.Channel$Unsafe] */
        @Override // io.netty.channel.epoll.AbstractEpollStreamChannel.SpliceInTask
        public boolean spliceIn(RecvByteBufAllocator.Handle handle) {
            ?? r0;
            if (this.len != 0) {
                try {
                    FileDescriptor fileDescriptor = this.ch.pipeOut;
                    if (fileDescriptor == null) {
                        FileDescriptor[] pipe = FileDescriptor.pipe();
                        this.ch.pipeIn = pipe[0];
                        fileDescriptor = this.ch.pipeOut = pipe[1];
                    }
                    int spliceIn = spliceIn(fileDescriptor, handle);
                    if (spliceIn > 0) {
                        if (this.len != Integer.MAX_VALUE) {
                            this.len -= spliceIn;
                        }
                        if (this.len == 0) {
                            r0 = this.promise;
                        } else {
                            r0 = this.ch.newPromise().addListener((GenericFutureListener<? extends Future<? super Void>>) this);
                        }
                        boolean isAutoRead = AbstractEpollStreamChannel.this.config().isAutoRead();
                        this.ch.unsafe().write(AbstractEpollStreamChannel.this.new SpliceOutTask(this.ch, spliceIn, isAutoRead), r0);
                        this.ch.unsafe().flush();
                        if (isAutoRead && !r0.isDone()) {
                            AbstractEpollStreamChannel.this.config().setAutoRead(false);
                        }
                    }
                    return this.len == 0;
                } catch (Throwable th) {
                    this.promise.setFailure(th);
                    return true;
                }
            }
            this.promise.setSuccess();
            return true;
        }
    }

    private final class SpliceOutTask {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean autoRead;
        private final AbstractEpollStreamChannel ch;
        private int len;

        SpliceOutTask(AbstractEpollStreamChannel abstractEpollStreamChannel, int i, boolean z) {
            this.ch = abstractEpollStreamChannel;
            this.len = i;
            this.autoRead = z;
        }

        public boolean spliceOut() throws Exception {
            try {
                int splice = this.len - Native.splice(this.ch.pipeIn.intValue(), -1L, this.ch.socket.intValue(), -1L, this.len);
                this.len = splice;
                if (splice != 0) {
                    return false;
                }
                if (this.autoRead) {
                    AbstractEpollStreamChannel.this.config().setAutoRead(true);
                }
                return true;
            } catch (IOException e) {
                if (this.autoRead) {
                    AbstractEpollStreamChannel.this.config().setAutoRead(true);
                }
                throw e;
            }
        }
    }

    private final class SpliceFdTask extends SpliceInTask {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final FileDescriptor fd;
        private final int offset;
        private final ChannelPromise promise;

        SpliceFdTask(FileDescriptor fileDescriptor, int i, int i2, ChannelPromise channelPromise) {
            super(i2, channelPromise);
            this.fd = fileDescriptor;
            this.promise = channelPromise;
            this.offset = i;
        }

        @Override // io.netty.channel.epoll.AbstractEpollStreamChannel.SpliceInTask
        public boolean spliceIn(RecvByteBufAllocator.Handle handle) {
            if (this.len == 0) {
                this.promise.setSuccess();
                return true;
            }
            try {
                FileDescriptor[] pipe = FileDescriptor.pipe();
                FileDescriptor fileDescriptor = pipe[0];
                FileDescriptor fileDescriptor2 = pipe[1];
                try {
                    int spliceIn = spliceIn(fileDescriptor2, handle);
                    if (spliceIn > 0) {
                        if (this.len != Integer.MAX_VALUE) {
                            this.len -= spliceIn;
                        }
                        do {
                            spliceIn -= Native.splice(fileDescriptor.intValue(), -1L, this.fd.intValue(), this.offset, spliceIn);
                        } while (spliceIn > 0);
                        if (this.len == 0) {
                            this.promise.setSuccess();
                            return true;
                        }
                    }
                    return false;
                } finally {
                    AbstractEpollStreamChannel.safeClosePipe(fileDescriptor);
                    AbstractEpollStreamChannel.safeClosePipe(fileDescriptor2);
                }
            } catch (Throwable th) {
                this.promise.setFailure(th);
                return true;
            }
        }
    }

    private final class EpollSocketWritableByteChannel extends SocketWritableByteChannel {
        EpollSocketWritableByteChannel() {
            super(AbstractEpollStreamChannel.this.socket);
        }

        @Override // io.netty.channel.unix.SocketWritableByteChannel
        protected ByteBufAllocator alloc() {
            return AbstractEpollStreamChannel.this.alloc();
        }
    }
}

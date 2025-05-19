package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;

/* loaded from: classes3.dex */
public abstract class AbstractCoalescingBufferQueue {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractCoalescingBufferQueue.class);
    private final ArrayDeque<Object> bufAndListenerPairs;
    private int readableBytes;
    private final PendingBytesTracker tracker;

    protected abstract ByteBuf compose(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2);

    protected ByteBuf composeFirst(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf) {
        return byteBuf;
    }

    protected abstract ByteBuf removeEmptyValue();

    protected AbstractCoalescingBufferQueue(Channel channel, int i) {
        this.bufAndListenerPairs = new ArrayDeque<>(i);
        this.tracker = channel == null ? null : PendingBytesTracker.newTracker(channel);
    }

    public final void addFirst(ByteBuf byteBuf, ChannelPromise channelPromise) {
        addFirst(byteBuf, toChannelFutureListener(channelPromise));
    }

    private void addFirst(ByteBuf byteBuf, ChannelFutureListener channelFutureListener) {
        if (channelFutureListener != null) {
            this.bufAndListenerPairs.addFirst(channelFutureListener);
        }
        this.bufAndListenerPairs.addFirst(byteBuf);
        incrementReadableBytes(byteBuf.readableBytes());
    }

    public final void add(ByteBuf byteBuf) {
        add(byteBuf, (ChannelFutureListener) null);
    }

    public final void add(ByteBuf byteBuf, ChannelPromise channelPromise) {
        add(byteBuf, toChannelFutureListener(channelPromise));
    }

    public final void add(ByteBuf byteBuf, ChannelFutureListener channelFutureListener) {
        this.bufAndListenerPairs.add(byteBuf);
        if (channelFutureListener != null) {
            this.bufAndListenerPairs.add(channelFutureListener);
        }
        incrementReadableBytes(byteBuf.readableBytes());
    }

    public final ByteBuf removeFirst(ChannelPromise channelPromise) {
        Object poll = this.bufAndListenerPairs.poll();
        if (poll == null) {
            return null;
        }
        ByteBuf byteBuf = (ByteBuf) poll;
        decrementReadableBytes(byteBuf.readableBytes());
        Object peek = this.bufAndListenerPairs.peek();
        if (peek instanceof ChannelFutureListener) {
            channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) peek);
            this.bufAndListenerPairs.poll();
        }
        return byteBuf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003b, code lost:
    
        r5.bufAndListenerPairs.addFirst(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0040, code lost:
    
        if (r1 <= 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0042, code lost:
    
        r0 = r3.readRetainedSlice(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
    
        if (r2 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0048, code lost:
    
        r6 = composeFirst(r6, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0051, code lost:
    
        r2 = r6;
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
    
        r6 = compose(r6, r2, r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final io.netty.buffer.ByteBuf remove(io.netty.buffer.ByteBufAllocator r6, int r7, io.netty.channel.ChannelPromise r8) {
        /*
            r5 = this;
            java.lang.String r0 = "bytes"
            io.netty.util.internal.ObjectUtil.checkPositiveOrZero(r7, r0)
            java.lang.String r0 = "aggregatePromise"
            io.netty.util.internal.ObjectUtil.checkNotNull(r8, r0)
            java.util.ArrayDeque<java.lang.Object> r0 = r5.bufAndListenerPairs
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L17
            io.netty.buffer.ByteBuf r6 = r5.removeEmptyValue()
            return r6
        L17:
            int r0 = r5.readableBytes
            int r7 = java.lang.Math.min(r7, r0)
            r0 = 0
            r1 = r7
            r2 = r0
        L20:
            java.util.ArrayDeque<java.lang.Object> r3 = r5.bufAndListenerPairs     // Catch: java.lang.Throwable -> L68
            java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L68
            if (r3 != 0) goto L29
            goto L75
        L29:
            boolean r4 = r3 instanceof io.netty.channel.ChannelFutureListener     // Catch: java.lang.Throwable -> L68
            if (r4 == 0) goto L33
            io.netty.channel.ChannelFutureListener r3 = (io.netty.channel.ChannelFutureListener) r3     // Catch: java.lang.Throwable -> L68
            r8.addListener(r3)     // Catch: java.lang.Throwable -> L68
            goto L20
        L33:
            io.netty.buffer.ByteBuf r3 = (io.netty.buffer.ByteBuf) r3     // Catch: java.lang.Throwable -> L68
            int r4 = r3.readableBytes()     // Catch: java.lang.Throwable -> L65
            if (r4 <= r1) goto L54
            java.util.ArrayDeque<java.lang.Object> r0 = r5.bufAndListenerPairs     // Catch: java.lang.Throwable -> L65
            r0.addFirst(r3)     // Catch: java.lang.Throwable -> L65
            if (r1 <= 0) goto L75
            io.netty.buffer.ByteBuf r0 = r3.readRetainedSlice(r1)     // Catch: java.lang.Throwable -> L65
            if (r2 != 0) goto L4d
            io.netty.buffer.ByteBuf r6 = r5.composeFirst(r6, r0)     // Catch: java.lang.Throwable -> L68
            goto L51
        L4d:
            io.netty.buffer.ByteBuf r6 = r5.compose(r6, r2, r0)     // Catch: java.lang.Throwable -> L68
        L51:
            r2 = r6
            r1 = 0
            goto L75
        L54:
            int r4 = r3.readableBytes()     // Catch: java.lang.Throwable -> L65
            int r1 = r1 - r4
            if (r2 != 0) goto L60
            io.netty.buffer.ByteBuf r2 = r5.composeFirst(r6, r3)     // Catch: java.lang.Throwable -> L65
            goto L20
        L60:
            io.netty.buffer.ByteBuf r2 = r5.compose(r6, r2, r3)     // Catch: java.lang.Throwable -> L65
            goto L20
        L65:
            r6 = move-exception
            r0 = r3
            goto L69
        L68:
            r6 = move-exception
        L69:
            io.netty.util.ReferenceCountUtil.safeRelease(r0)
            io.netty.util.ReferenceCountUtil.safeRelease(r2)
            r8.setFailure(r6)
            io.netty.util.internal.PlatformDependent.throwException(r6)
        L75:
            int r7 = r7 - r1
            r5.decrementReadableBytes(r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.AbstractCoalescingBufferQueue.remove(io.netty.buffer.ByteBufAllocator, int, io.netty.channel.ChannelPromise):io.netty.buffer.ByteBuf");
    }

    public final int readableBytes() {
        return this.readableBytes;
    }

    public final boolean isEmpty() {
        return this.bufAndListenerPairs.isEmpty();
    }

    public final void releaseAndFailAll(ChannelOutboundInvoker channelOutboundInvoker, Throwable th) {
        releaseAndCompleteAll(channelOutboundInvoker.newFailedFuture(th));
    }

    public final void copyTo(AbstractCoalescingBufferQueue abstractCoalescingBufferQueue) {
        abstractCoalescingBufferQueue.bufAndListenerPairs.addAll(this.bufAndListenerPairs);
        abstractCoalescingBufferQueue.incrementReadableBytes(this.readableBytes);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeAndRemoveAll(io.netty.channel.ChannelHandlerContext r7) {
        /*
            r6 = this;
            int r0 = r6.readableBytes
            r6.decrementReadableBytes(r0)
            r0 = 0
            r1 = r0
            r2 = r1
        L8:
            java.util.ArrayDeque<java.lang.Object> r3 = r6.bufAndListenerPairs
            java.lang.Object r3 = r3.poll()
            if (r3 != 0) goto L22
            if (r1 == 0) goto L19
            io.netty.channel.ChannelPromise r3 = r7.voidPromise()     // Catch: java.lang.Throwable -> L48
            r7.write(r1, r3)     // Catch: java.lang.Throwable -> L48
        L19:
            if (r2 != 0) goto L1c
            return
        L1c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>(r2)
            throw r7
        L22:
            boolean r4 = r3 instanceof io.netty.buffer.ByteBuf     // Catch: java.lang.Throwable -> L48
            if (r4 == 0) goto L33
            if (r1 == 0) goto L2f
            io.netty.channel.ChannelPromise r4 = r7.voidPromise()     // Catch: java.lang.Throwable -> L48
            r7.write(r1, r4)     // Catch: java.lang.Throwable -> L48
        L2f:
            io.netty.buffer.ByteBuf r3 = (io.netty.buffer.ByteBuf) r3     // Catch: java.lang.Throwable -> L48
            r1 = r3
            goto L8
        L33:
            boolean r4 = r3 instanceof io.netty.channel.ChannelPromise     // Catch: java.lang.Throwable -> L48
            if (r4 == 0) goto L3e
            io.netty.channel.ChannelPromise r3 = (io.netty.channel.ChannelPromise) r3     // Catch: java.lang.Throwable -> L48
            r7.write(r1, r3)     // Catch: java.lang.Throwable -> L48
        L3c:
            r1 = r0
            goto L8
        L3e:
            io.netty.channel.ChannelFuture r4 = r7.write(r1)     // Catch: java.lang.Throwable -> L48
            io.netty.channel.ChannelFutureListener r3 = (io.netty.channel.ChannelFutureListener) r3     // Catch: java.lang.Throwable -> L48
            r4.addListener(r3)     // Catch: java.lang.Throwable -> L48
            goto L3c
        L48:
            r3 = move-exception
            if (r2 != 0) goto L4d
            r2 = r3
            goto L8
        L4d:
            io.netty.util.internal.logging.InternalLogger r4 = io.netty.channel.AbstractCoalescingBufferQueue.logger
            java.lang.String r5 = "Throwable being suppressed because Throwable {} is already pending"
            r4.info(r5, r2, r3)
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.AbstractCoalescingBufferQueue.writeAndRemoveAll(io.netty.channel.ChannelHandlerContext):void");
    }

    protected final ByteBuf composeIntoComposite(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
        CompositeByteBuf compositeBuffer = byteBufAllocator.compositeBuffer(size() + 2);
        try {
            compositeBuffer.addComponent(true, byteBuf);
            compositeBuffer.addComponent(true, byteBuf2);
        } catch (Throwable th) {
            compositeBuffer.release();
            ReferenceCountUtil.safeRelease(byteBuf2);
            PlatformDependent.throwException(th);
        }
        return compositeBuffer;
    }

    protected final ByteBuf copyAndCompose(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
        ByteBuf ioBuffer = byteBufAllocator.ioBuffer(byteBuf.readableBytes() + byteBuf2.readableBytes());
        try {
            ioBuffer.writeBytes(byteBuf).writeBytes(byteBuf2);
        } catch (Throwable th) {
            ioBuffer.release();
            ReferenceCountUtil.safeRelease(byteBuf2);
            PlatformDependent.throwException(th);
        }
        byteBuf.release();
        byteBuf2.release();
        return ioBuffer;
    }

    protected final int size() {
        return this.bufAndListenerPairs.size();
    }

    private void releaseAndCompleteAll(ChannelFuture channelFuture) {
        decrementReadableBytes(this.readableBytes);
        Throwable th = null;
        while (true) {
            Object poll = this.bufAndListenerPairs.poll();
            if (poll == null) {
                break;
            }
            try {
                if (poll instanceof ByteBuf) {
                    ReferenceCountUtil.safeRelease(poll);
                } else {
                    ((ChannelFutureListener) poll).operationComplete(channelFuture);
                }
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    logger.info("Throwable being suppressed because Throwable {} is already pending", th, th2);
                }
            }
        }
        if (th != null) {
            throw new IllegalStateException(th);
        }
    }

    private void incrementReadableBytes(int i) {
        int i2 = this.readableBytes;
        int i3 = i2 + i;
        if (i3 < i2) {
            throw new IllegalStateException("buffer queue length overflow: " + this.readableBytes + " + " + i);
        }
        this.readableBytes = i3;
        PendingBytesTracker pendingBytesTracker = this.tracker;
        if (pendingBytesTracker != null) {
            pendingBytesTracker.incrementPendingOutboundBytes(i);
        }
    }

    private void decrementReadableBytes(int i) {
        this.readableBytes -= i;
        PendingBytesTracker pendingBytesTracker = this.tracker;
        if (pendingBytesTracker != null) {
            pendingBytesTracker.decrementPendingOutboundBytes(i);
        }
    }

    private static ChannelFutureListener toChannelFutureListener(ChannelPromise channelPromise) {
        if (channelPromise.isVoid()) {
            return null;
        }
        return new DelegatingChannelPromiseNotifier(channelPromise);
    }
}

package io.netty.handler.stream;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelProgressivePromise;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes4.dex */
public class ChunkedWriteHandler extends ChannelDuplexHandler {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ChunkedWriteHandler.class);
    private volatile ChannelHandlerContext ctx;
    private PendingWrite currentWrite;
    private final Queue<PendingWrite> queue = new ArrayDeque();

    public ChunkedWriteHandler() {
    }

    @Deprecated
    public ChunkedWriteHandler(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxPendingWrites: " + i + " (expected: > 0)");
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
    }

    public void resumeTransfer() {
        final ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext == null) {
            return;
        }
        if (channelHandlerContext.executor().inEventLoop()) {
            try {
                doFlush(channelHandlerContext);
                return;
            } catch (Exception e) {
                if (logger.isWarnEnabled()) {
                    logger.warn("Unexpected exception while sending chunks.", (Throwable) e);
                    return;
                }
                return;
            }
        }
        channelHandlerContext.executor().execute(new Runnable() { // from class: io.netty.handler.stream.ChunkedWriteHandler.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ChunkedWriteHandler.this.doFlush(channelHandlerContext);
                } catch (Exception e2) {
                    if (ChunkedWriteHandler.logger.isWarnEnabled()) {
                        ChunkedWriteHandler.logger.warn("Unexpected exception while sending chunks.", (Throwable) e2);
                    }
                }
            }
        });
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        this.queue.add(new PendingWrite(obj, channelPromise));
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        doFlush(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        doFlush(channelHandlerContext);
        channelHandlerContext.fireChannelInactive();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (channelHandlerContext.channel().isWritable()) {
            doFlush(channelHandlerContext);
        }
        channelHandlerContext.fireChannelWritabilityChanged();
    }

    private void discard(Throwable th) {
        while (true) {
            PendingWrite pendingWrite = this.currentWrite;
            if (pendingWrite == null) {
                pendingWrite = this.queue.poll();
            } else {
                this.currentWrite = null;
            }
            if (pendingWrite == null) {
                return;
            }
            Object obj = pendingWrite.msg;
            if (obj instanceof ChunkedInput) {
                ChunkedInput chunkedInput = (ChunkedInput) obj;
                try {
                    if (!chunkedInput.isEndOfInput()) {
                        if (th == null) {
                            th = new ClosedChannelException();
                        }
                        pendingWrite.fail(th);
                    } else {
                        pendingWrite.success(chunkedInput.length());
                    }
                    closeInput(chunkedInput);
                } catch (Exception e) {
                    pendingWrite.fail(e);
                    logger.warn(ChunkedInput.class.getSimpleName() + ".isEndOfInput() failed", (Throwable) e);
                    closeInput(chunkedInput);
                }
            } else {
                if (th == null) {
                    th = new ClosedChannelException();
                }
                pendingWrite.fail(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void doFlush(io.netty.channel.ChannelHandlerContext r14) throws java.lang.Exception {
        /*
            r13 = this;
            io.netty.channel.Channel r6 = r14.channel()
            boolean r0 = r6.isActive()
            r7 = 0
            if (r0 != 0) goto Lf
            r13.discard(r7)
            return
        Lf:
            io.netty.buffer.ByteBufAllocator r8 = r14.alloc()
            r9 = 1
            r0 = r9
        L15:
            boolean r1 = r6.isWritable()
            if (r1 == 0) goto La6
            io.netty.handler.stream.ChunkedWriteHandler$PendingWrite r1 = r13.currentWrite
            if (r1 != 0) goto L29
            java.util.Queue<io.netty.handler.stream.ChunkedWriteHandler$PendingWrite> r1 = r13.queue
            java.lang.Object r1 = r1.poll()
            io.netty.handler.stream.ChunkedWriteHandler$PendingWrite r1 = (io.netty.handler.stream.ChunkedWriteHandler.PendingWrite) r1
            r13.currentWrite = r1
        L29:
            io.netty.handler.stream.ChunkedWriteHandler$PendingWrite r3 = r13.currentWrite
            if (r3 != 0) goto L2f
            goto La6
        L2f:
            java.lang.Object r2 = r3.msg
            boolean r1 = r2 instanceof io.netty.handler.stream.ChunkedInput
            r10 = 0
            if (r1 == 0) goto L90
            r4 = r2
            io.netty.handler.stream.ChunkedInput r4 = (io.netty.handler.stream.ChunkedInput) r4
            java.lang.Object r1 = r4.readChunk(r8)     // Catch: java.lang.Throwable -> L80
            boolean r5 = r4.isEndOfInput()     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L46
            r11 = r5 ^ 1
            goto L47
        L46:
            r11 = r10
        L47:
            if (r11 == 0) goto L4a
            goto La6
        L4a:
            if (r1 != 0) goto L4e
            io.netty.buffer.ByteBuf r1 = io.netty.buffer.Unpooled.EMPTY_BUFFER
        L4e:
            io.netty.channel.ChannelFuture r11 = r14.write(r1)
            if (r5 == 0) goto L5f
            r13.currentWrite = r7
            io.netty.handler.stream.ChunkedWriteHandler$2 r0 = new io.netty.handler.stream.ChunkedWriteHandler$2
            r0.<init>()
            r11.addListener(r0)
            goto L79
        L5f:
            boolean r0 = r6.isWritable()
            if (r0 == 0) goto L6e
            io.netty.handler.stream.ChunkedWriteHandler$3 r0 = new io.netty.handler.stream.ChunkedWriteHandler$3
            r0.<init>()
            r11.addListener(r0)
            goto L79
        L6e:
            io.netty.handler.stream.ChunkedWriteHandler$4 r12 = new io.netty.handler.stream.ChunkedWriteHandler$4
            r0 = r12
            r1 = r13
            r5 = r6
            r0.<init>()
            r11.addListener(r12)
        L79:
            r14.flush()
            r0 = r10
            goto L98
        L7e:
            r2 = move-exception
            goto L82
        L80:
            r2 = move-exception
            r1 = r7
        L82:
            r13.currentWrite = r7
            if (r1 == 0) goto L89
            io.netty.util.ReferenceCountUtil.release(r1)
        L89:
            r3.fail(r2)
            closeInput(r4)
            goto La6
        L90:
            io.netty.channel.ChannelPromise r0 = r3.promise
            r14.write(r2, r0)
            r13.currentWrite = r7
            r0 = r9
        L98:
            boolean r1 = r6.isActive()
            if (r1 != 0) goto L15
            java.nio.channels.ClosedChannelException r1 = new java.nio.channels.ClosedChannelException
            r1.<init>()
            r13.discard(r1)
        La6:
            if (r0 == 0) goto Lab
            r14.flush()
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.stream.ChunkedWriteHandler.doFlush(io.netty.channel.ChannelHandlerContext):void");
    }

    static void closeInput(ChunkedInput<?> chunkedInput) {
        try {
            chunkedInput.close();
        } catch (Throwable th) {
            if (logger.isWarnEnabled()) {
                logger.warn("Failed to close a chunked input.", th);
            }
        }
    }

    private static final class PendingWrite {
        final Object msg;
        final ChannelPromise promise;

        PendingWrite(Object obj, ChannelPromise channelPromise) {
            this.msg = obj;
            this.promise = channelPromise;
        }

        void fail(Throwable th) {
            ReferenceCountUtil.release(this.msg);
            this.promise.tryFailure(th);
        }

        void success(long j) {
            if (this.promise.isDone()) {
                return;
            }
            ChannelPromise channelPromise = this.promise;
            if (channelPromise instanceof ChannelProgressivePromise) {
                ((ChannelProgressivePromise) channelPromise).tryProgress(j, j);
            }
            this.promise.trySuccess();
        }

        void progress(long j, long j2) {
            ChannelPromise channelPromise = this.promise;
            if (channelPromise instanceof ChannelProgressivePromise) {
                ((ChannelProgressivePromise) channelPromise).tryProgress(j, j2);
            }
        }
    }
}

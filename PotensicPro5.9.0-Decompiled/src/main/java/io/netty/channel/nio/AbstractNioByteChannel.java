package io.netty.channel.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public abstract class AbstractNioByteChannel extends AbstractNioChannel {
    private Runnable flushTask;
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) FileRegion.class) + PropertyUtils.MAPPED_DELIM2;

    protected abstract int doReadBytes(ByteBuf byteBuf) throws Exception;

    protected abstract int doWriteBytes(ByteBuf byteBuf) throws Exception;

    protected abstract long doWriteFileRegion(FileRegion fileRegion) throws Exception;

    protected boolean isInputShutdown0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ChannelFuture shutdownInput();

    protected AbstractNioByteChannel(Channel channel, SelectableChannel selectableChannel) {
        super(channel, selectableChannel, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioByteUnsafe();
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public class NioByteUnsafe extends AbstractNioChannel.AbstractNioUnsafe {
        protected NioByteUnsafe() {
            super();
        }

        private void closeOnRead(ChannelPipeline channelPipeline) {
            if (!AbstractNioByteChannel.this.isInputShutdown0()) {
                if (Boolean.TRUE.equals(AbstractNioByteChannel.this.config().getOption(ChannelOption.ALLOW_HALF_CLOSURE))) {
                    AbstractNioByteChannel.this.shutdownInput();
                    channelPipeline.fireUserEventTriggered((Object) ChannelInputShutdownEvent.INSTANCE);
                    return;
                } else {
                    close(voidPromise());
                    return;
                }
            }
            channelPipeline.fireUserEventTriggered((Object) ChannelInputShutdownReadComplete.INSTANCE);
        }

        private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z, RecvByteBufAllocator.Handle handle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    AbstractNioByteChannel.this.readPending = false;
                    channelPipeline.fireChannelRead((Object) byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            handle.readComplete();
            channelPipeline.fireChannelReadComplete();
            channelPipeline.fireExceptionCaught(th);
            if (z || (th instanceof IOException)) {
                closeOnRead(channelPipeline);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x002d, code lost:
        
            r5.release();
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0034, code lost:
        
            if (r7.lastBytesRead() >= 0) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0037, code lost:
        
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0038, code lost:
        
            if (r8 == false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0044, code lost:
        
            r4 = r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x003a, code lost:
        
            r9.this$0.readPending = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x003f, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0040, code lost:
        
            r5 = r1;
            r4 = null;
            r6 = r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0078, code lost:
        
            handleReadException(r3, r4, r5, r6, r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x008b, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0090, code lost:
        
            if (r9.this$0.readPending == false) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0098, code lost:
        
            removeReadOp();
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x009b, code lost:
        
            throw r1;
         */
        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void read() {
            /*
                r9 = this;
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this
                io.netty.channel.ChannelConfig r0 = r0.config()
                io.netty.channel.nio.AbstractNioByteChannel r1 = io.netty.channel.nio.AbstractNioByteChannel.this
                io.netty.channel.ChannelPipeline r3 = r1.pipeline()
                io.netty.buffer.ByteBufAllocator r1 = r0.getAllocator()
                io.netty.channel.RecvByteBufAllocator$Handle r7 = r9.recvBufAllocHandle()
                r7.reset(r0)
            L17:
                r2 = 0
                r4 = 0
                io.netty.buffer.ByteBuf r5 = r7.allocate(r1)     // Catch: java.lang.Throwable -> L73
                io.netty.channel.nio.AbstractNioByteChannel r6 = io.netty.channel.nio.AbstractNioByteChannel.this     // Catch: java.lang.Throwable -> L6e
                int r6 = r6.doReadBytes(r5)     // Catch: java.lang.Throwable -> L6e
                r7.lastBytesRead(r6)     // Catch: java.lang.Throwable -> L6e
                int r6 = r7.lastBytesRead()     // Catch: java.lang.Throwable -> L6e
                r8 = 1
                if (r6 > 0) goto L46
                r5.release()     // Catch: java.lang.Throwable -> L6e
                int r1 = r7.lastBytesRead()     // Catch: java.lang.Throwable -> L73
                if (r1 >= 0) goto L37
                goto L38
            L37:
                r8 = r4
            L38:
                if (r8 == 0) goto L44
                io.netty.channel.nio.AbstractNioByteChannel r1 = io.netty.channel.nio.AbstractNioByteChannel.this     // Catch: java.lang.Throwable -> L3f
                r1.readPending = r4     // Catch: java.lang.Throwable -> L3f
                goto L44
            L3f:
                r1 = move-exception
                r5 = r1
                r4 = r2
                r6 = r8
                goto L77
            L44:
                r4 = r8
                goto L56
            L46:
                r7.incMessagesRead(r8)     // Catch: java.lang.Throwable -> L6e
                io.netty.channel.nio.AbstractNioByteChannel r6 = io.netty.channel.nio.AbstractNioByteChannel.this     // Catch: java.lang.Throwable -> L6e
                r6.readPending = r4     // Catch: java.lang.Throwable -> L6e
                r3.fireChannelRead(r5)     // Catch: java.lang.Throwable -> L6e
                boolean r5 = r7.continueReading()     // Catch: java.lang.Throwable -> L73
                if (r5 != 0) goto L17
            L56:
                r7.readComplete()     // Catch: java.lang.Throwable -> L73
                r3.fireChannelReadComplete()     // Catch: java.lang.Throwable -> L73
                if (r4 == 0) goto L61
                r9.closeOnRead(r3)     // Catch: java.lang.Throwable -> L73
            L61:
                io.netty.channel.nio.AbstractNioByteChannel r1 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r1 = r1.readPending
                if (r1 != 0) goto L8a
                boolean r0 = r0.isAutoRead()
                if (r0 != 0) goto L8a
                goto L87
            L6e:
                r1 = move-exception
                r6 = r4
                r4 = r5
                r5 = r1
                goto L77
            L73:
                r1 = move-exception
                r5 = r1
                r6 = r4
                r4 = r2
            L77:
                r2 = r9
                r2.handleReadException(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L8b
                io.netty.channel.nio.AbstractNioByteChannel r1 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r1 = r1.readPending
                if (r1 != 0) goto L8a
                boolean r0 = r0.isAutoRead()
                if (r0 != 0) goto L8a
            L87:
                r9.removeReadOp()
            L8a:
                return
            L8b:
                r1 = move-exception
                io.netty.channel.nio.AbstractNioByteChannel r2 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r2 = r2.readPending
                if (r2 != 0) goto L9b
                boolean r0 = r0.isAutoRead()
                if (r0 != 0) goto L9b
                r9.removeReadOp()
            L9b:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.nio.AbstractNioByteChannel.NioByteUnsafe.read():void");
        }
    }

    protected final int doWrite0(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        if (channelOutboundBuffer.current() == null) {
            return 0;
        }
        return doWriteInternal(channelOutboundBuffer, channelOutboundBuffer.current());
    }

    private int doWriteInternal(ChannelOutboundBuffer channelOutboundBuffer, Object obj) throws Exception {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            if (!byteBuf.isReadable()) {
                channelOutboundBuffer.remove();
                return 0;
            }
            int doWriteBytes = doWriteBytes(byteBuf);
            if (doWriteBytes <= 0) {
                return Integer.MAX_VALUE;
            }
            channelOutboundBuffer.progress(doWriteBytes);
            if (!byteBuf.isReadable()) {
                channelOutboundBuffer.remove();
            }
            return 1;
        }
        if (obj instanceof FileRegion) {
            FileRegion fileRegion = (FileRegion) obj;
            if (fileRegion.transferred() >= fileRegion.count()) {
                channelOutboundBuffer.remove();
                return 0;
            }
            long doWriteFileRegion = doWriteFileRegion(fileRegion);
            if (doWriteFileRegion <= 0) {
                return Integer.MAX_VALUE;
            }
            channelOutboundBuffer.progress(doWriteFileRegion);
            if (fileRegion.transferred() >= fileRegion.count()) {
                channelOutboundBuffer.remove();
            }
            return 1;
        }
        throw new Error();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        int writeSpinCount = config().getWriteSpinCount();
        do {
            Object current = channelOutboundBuffer.current();
            if (current == null) {
                clearOpWrite();
                return;
            }
            writeSpinCount -= doWriteInternal(channelOutboundBuffer, current);
        } while (writeSpinCount > 0);
        incompleteWrite(writeSpinCount < 0);
    }

    @Override // io.netty.channel.AbstractChannel
    protected final Object filterOutboundMessage(Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return byteBuf.isDirect() ? obj : newDirectBuffer(byteBuf);
        }
        if (obj instanceof FileRegion) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    protected final void incompleteWrite(boolean z) {
        if (z) {
            setOpWrite();
            return;
        }
        Runnable runnable = this.flushTask;
        if (runnable == null) {
            runnable = new Runnable() { // from class: io.netty.channel.nio.AbstractNioByteChannel.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractNioByteChannel.this.flush();
                }
            };
            this.flushTask = runnable;
        }
        eventLoop().execute(runnable);
    }

    protected final void setOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (selectionKey.isValid()) {
            int interestOps = selectionKey.interestOps();
            if ((interestOps & 4) == 0) {
                selectionKey.interestOps(interestOps | 4);
            }
        }
    }

    protected final void clearOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (selectionKey.isValid()) {
            int interestOps = selectionKey.interestOps();
            if ((interestOps & 4) != 0) {
                selectionKey.interestOps(interestOps & (-5));
            }
        }
    }
}

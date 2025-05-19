package io.netty.channel.oio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public abstract class AbstractOioByteChannel extends AbstractOioChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) FileRegion.class) + PropertyUtils.MAPPED_DELIM2;

    protected abstract int available();

    protected abstract int doReadBytes(ByteBuf byteBuf) throws Exception;

    protected abstract void doWriteBytes(ByteBuf byteBuf) throws Exception;

    protected abstract void doWriteFileRegion(FileRegion fileRegion) throws Exception;

    protected abstract boolean isInputShutdown();

    protected abstract ChannelFuture shutdownInput();

    protected AbstractOioByteChannel(Channel channel) {
        super(channel);
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    private void closeOnRead(ChannelPipeline channelPipeline) {
        if (isOpen()) {
            if (Boolean.TRUE.equals(config().getOption(ChannelOption.ALLOW_HALF_CLOSURE))) {
                shutdownInput();
                channelPipeline.fireUserEventTriggered((Object) ChannelInputShutdownEvent.INSTANCE);
            } else {
                unsafe().close(unsafe().voidPromise());
            }
        }
    }

    private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z, RecvByteBufAllocator.Handle handle) {
        if (byteBuf != null) {
            if (byteBuf.isReadable()) {
                this.readPending = false;
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

    /* JADX WARN: Code restructure failed: missing block: B:100:0x004d, code lost:
    
        r12.readPending = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0051, code lost:
    
        r2 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0052, code lost:
    
        r6 = false;
        r4 = null;
        r1 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x00e5, code lost:
    
        r5 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b5, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
    
        r6 = r4;
        r4 = r5;
        r5 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e0, code lost:
    
        r1 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x003e, code lost:
    
        if (r6.isReadable() != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0040, code lost:
    
        r6.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0047, code lost:
    
        if (r7.lastBytesRead() >= 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x004a, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x004b, code lost:
    
        if (r4 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x004f, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ee A[DONT_GENERATE] */
    @Override // io.netty.channel.oio.AbstractOioChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void doRead() {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.oio.AbstractOioByteChannel.doRead():void");
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        while (true) {
            Object current = channelOutboundBuffer.current();
            if (current == null) {
                return;
            }
            if (current instanceof ByteBuf) {
                ByteBuf byteBuf = (ByteBuf) current;
                int readableBytes = byteBuf.readableBytes();
                while (readableBytes > 0) {
                    doWriteBytes(byteBuf);
                    int readableBytes2 = byteBuf.readableBytes();
                    channelOutboundBuffer.progress(readableBytes - readableBytes2);
                    readableBytes = readableBytes2;
                }
                channelOutboundBuffer.remove();
            } else if (current instanceof FileRegion) {
                FileRegion fileRegion = (FileRegion) current;
                long transferred = fileRegion.transferred();
                doWriteFileRegion(fileRegion);
                channelOutboundBuffer.progress(fileRegion.transferred() - transferred);
                channelOutboundBuffer.remove();
            } else {
                channelOutboundBuffer.remove(new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(current)));
            }
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected final Object filterOutboundMessage(Object obj) throws Exception {
        if ((obj instanceof ByteBuf) || (obj instanceof FileRegion)) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }
}

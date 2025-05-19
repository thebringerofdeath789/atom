package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.Http2CodecUtil;
import io.netty.handler.codec.http2.Http2FrameWriter;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.util.collection.CharObjectMap;
import io.netty.util.internal.ObjectUtil;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes3.dex */
public class DefaultHttp2FrameWriter implements Http2FrameWriter, Http2FrameSizePolicy, Http2FrameWriter.Configuration {
    private static final String STREAM_DEPENDENCY = "Stream Dependency";
    private static final String STREAM_ID = "Stream ID";
    private static final ByteBuf ZERO_BUFFER = Unpooled.unreleasableBuffer(Unpooled.directBuffer(255).writeZero(255)).asReadOnly();
    private final Http2HeadersEncoder headersEncoder;
    private int maxFrameSize;

    private static int paddingBytes(int i) {
        return i - 1;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public Http2FrameWriter.Configuration configuration() {
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter.Configuration
    public Http2FrameSizePolicy frameSizePolicy() {
        return this;
    }

    public DefaultHttp2FrameWriter() {
        this(new DefaultHttp2HeadersEncoder());
    }

    public DefaultHttp2FrameWriter(Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        this(new DefaultHttp2HeadersEncoder(sensitivityDetector));
    }

    public DefaultHttp2FrameWriter(Http2HeadersEncoder.SensitivityDetector sensitivityDetector, boolean z) {
        this(new DefaultHttp2HeadersEncoder(sensitivityDetector, z));
    }

    public DefaultHttp2FrameWriter(Http2HeadersEncoder http2HeadersEncoder) {
        this.headersEncoder = http2HeadersEncoder;
        this.maxFrameSize = 16384;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter.Configuration
    public Http2HeadersEncoder.Configuration headersConfiguration() {
        return this.headersEncoder.configuration();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameSizePolicy
    public void maxFrameSize(int i) throws Http2Exception {
        if (!Http2CodecUtil.isMaxFrameSizeValid(i)) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Invalid MAX_FRAME_SIZE specified in sent settings: %d", Integer.valueOf(i));
        }
        this.maxFrameSize = i;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameSizePolicy
    public int maxFrameSize() {
        return this.maxFrameSize;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0165 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0139 A[Catch: all -> 0x0153, TRY_LEAVE, TryCatch #1 {all -> 0x0153, blocks: (B:27:0x00d1, B:32:0x00f9, B:35:0x0100, B:38:0x0116, B:57:0x0128, B:58:0x0133, B:60:0x0139), top: B:26:0x00d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ff  */
    @Override // io.netty.handler.codec.http2.Http2DataWriter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.netty.channel.ChannelFuture writeData(io.netty.channel.ChannelHandlerContext r17, int r18, io.netty.buffer.ByteBuf r19, int r20, boolean r21, io.netty.channel.ChannelPromise r22) {
        /*
            Method dump skipped, instructions count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.DefaultHttp2FrameWriter.writeData(io.netty.channel.ChannelHandlerContext, int, io.netty.buffer.ByteBuf, int, boolean, io.netty.channel.ChannelPromise):io.netty.channel.ChannelFuture");
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z, ChannelPromise channelPromise) {
        return writeHeadersInternal(channelHandlerContext, i, http2Headers, i2, z, false, 0, (short) 0, false, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i3, boolean z2, ChannelPromise channelPromise) {
        return writeHeadersInternal(channelHandlerContext, i, http2Headers, i3, z2, true, i2, s, z, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePriority(ChannelHandlerContext channelHandlerContext, int i, int i2, short s, boolean z, ChannelPromise channelPromise) {
        try {
            verifyStreamId(i, STREAM_ID);
            verifyStreamId(i2, STREAM_DEPENDENCY);
            verifyWeight(s);
            ByteBuf buffer = channelHandlerContext.alloc().buffer(14);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, 5, (byte) 2, new Http2Flags(), i);
            if (z) {
                i2 = (int) (i2 | IjkMediaMeta.AV_CH_WIDE_LEFT);
            }
            buffer.writeInt(i2);
            buffer.writeByte(s - 1);
            return channelHandlerContext.write(buffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i, long j, ChannelPromise channelPromise) {
        try {
            verifyStreamId(i, STREAM_ID);
            verifyErrorCode(j);
            ByteBuf buffer = channelHandlerContext.alloc().buffer(13);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, 4, (byte) 3, new Http2Flags(), i);
            buffer.writeInt((int) j);
            return channelHandlerContext.write(buffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettings(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings, ChannelPromise channelPromise) {
        try {
            ObjectUtil.checkNotNull(http2Settings, "settings");
            int size = http2Settings.size() * 6;
            ByteBuf buffer = channelHandlerContext.alloc().buffer((http2Settings.size() * 6) + 9);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, size, (byte) 4, new Http2Flags(), 0);
            for (CharObjectMap.PrimitiveEntry<Long> primitiveEntry : http2Settings.entries()) {
                buffer.writeChar(primitiveEntry.key());
                buffer.writeInt(primitiveEntry.value().intValue());
            }
            return channelHandlerContext.write(buffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettingsAck(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        try {
            ByteBuf buffer = channelHandlerContext.alloc().buffer(9);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, 0, (byte) 4, new Http2Flags().ack(true), 0);
            return channelHandlerContext.write(buffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z, ByteBuf byteBuf, ChannelPromise channelPromise) {
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        try {
            verifyPingPayload(byteBuf);
            Http2Flags ack = z ? new Http2Flags().ack(true) : new Http2Flags();
            int readableBytes = byteBuf.readableBytes();
            ByteBuf buffer = channelHandlerContext.alloc().buffer(9);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, readableBytes, (byte) 6, ack, 0);
            channelHandlerContext.write(buffer, simpleChannelPromiseAggregator.newPromise());
            try {
                channelHandlerContext.write(byteBuf, simpleChannelPromiseAggregator.newPromise());
            } catch (Throwable th) {
                simpleChannelPromiseAggregator.setFailure(th);
            }
            return simpleChannelPromiseAggregator.doneAllocatingPromises();
        } catch (Throwable th2) {
            try {
                byteBuf.release();
                return simpleChannelPromiseAggregator;
            } finally {
                simpleChannelPromiseAggregator.setFailure(th2);
                simpleChannelPromiseAggregator.doneAllocatingPromises();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a1, code lost:
    
        if (r13 != null) goto L26;
     */
    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.netty.channel.ChannelFuture writePushPromise(io.netty.channel.ChannelHandlerContext r8, int r9, int r10, io.netty.handler.codec.http2.Http2Headers r11, int r12, io.netty.channel.ChannelPromise r13) {
        /*
            r7 = this;
            io.netty.handler.codec.http2.Http2CodecUtil$SimpleChannelPromiseAggregator r6 = new io.netty.handler.codec.http2.Http2CodecUtil$SimpleChannelPromiseAggregator
            io.netty.channel.Channel r0 = r8.channel()
            io.netty.util.concurrent.EventExecutor r1 = r8.executor()
            r6.<init>(r13, r0, r1)
            r13 = 0
            java.lang.String r0 = "Stream ID"
            verifyStreamId(r9, r0)     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            java.lang.String r0 = "Promised Stream ID"
            verifyStreamId(r10, r0)     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            io.netty.handler.codec.http2.Http2CodecUtil.verifyPadding(r12)     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            io.netty.buffer.ByteBufAllocator r0 = r8.alloc()     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            io.netty.buffer.ByteBuf r13 = r0.buffer()     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            io.netty.handler.codec.http2.Http2HeadersEncoder r0 = r7.headersEncoder     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            r0.encodeHeaders(r9, r11, r13)     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            io.netty.handler.codec.http2.Http2Flags r11 = new io.netty.handler.codec.http2.Http2Flags     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            r11.<init>()     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            r0 = 1
            r1 = 0
            if (r12 <= 0) goto L33
            r2 = r0
            goto L34
        L33:
            r2 = r1
        L34:
            io.netty.handler.codec.http2.Http2Flags r11 = r11.paddingPresent(r2)     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            int r2 = r12 + 4
            int r3 = r7.maxFrameSize     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            int r3 = r3 - r2
            int r4 = r13.readableBytes()     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            io.netty.buffer.ByteBuf r3 = r13.readRetainedSlice(r3)     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            boolean r4 = r13.isReadable()     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            if (r4 != 0) goto L50
            goto L51
        L50:
            r0 = r1
        L51:
            r11.endOfHeaders(r0)     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            int r0 = r3.readableBytes()     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            int r0 = r0 + r2
            io.netty.buffer.ByteBufAllocator r2 = r8.alloc()     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            r4 = 14
            io.netty.buffer.ByteBuf r2 = r2.buffer(r4)     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            r4 = 5
            io.netty.handler.codec.http2.Http2CodecUtil.writeFrameHeaderInternal(r2, r0, r4, r11, r9)     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            writePaddingLength(r2, r12)     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            r2.writeInt(r10)     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            io.netty.channel.ChannelPromise r10 = r6.newPromise()     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            r8.write(r2, r10)     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            io.netty.channel.ChannelPromise r10 = r6.newPromise()     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            r8.write(r3, r10)     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            int r10 = paddingBytes(r12)     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            if (r10 <= 0) goto L92
            io.netty.buffer.ByteBuf r10 = io.netty.handler.codec.http2.DefaultHttp2FrameWriter.ZERO_BUFFER     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            int r0 = paddingBytes(r12)     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            io.netty.buffer.ByteBuf r10 = r10.slice(r1, r0)     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            io.netty.channel.ChannelPromise r0 = r6.newPromise()     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            r8.write(r10, r0)     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
        L92:
            boolean r10 = r11.endOfHeaders()     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
            if (r10 != 0) goto La1
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r13
            r4 = r12
            r5 = r6
            r0.writeContinuationFrames(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> La4 io.netty.handler.codec.http2.Http2Exception -> Lb1
        La1:
            if (r13 == 0) goto Lba
            goto Lb7
        La4:
            r8 = move-exception
            r6.setFailure(r8)     // Catch: java.lang.Throwable -> Lbf
            r6.doneAllocatingPromises()     // Catch: java.lang.Throwable -> Lbf
            io.netty.util.internal.PlatformDependent.throwException(r8)     // Catch: java.lang.Throwable -> Lbf
            if (r13 == 0) goto Lba
            goto Lb7
        Lb1:
            r8 = move-exception
            r6.setFailure(r8)     // Catch: java.lang.Throwable -> Lbf
            if (r13 == 0) goto Lba
        Lb7:
            r13.release()
        Lba:
            io.netty.channel.ChannelPromise r8 = r6.doneAllocatingPromises()
            return r8
        Lbf:
            r8 = move-exception
            if (r13 == 0) goto Lc5
            r13.release()
        Lc5:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.DefaultHttp2FrameWriter.writePushPromise(io.netty.channel.ChannelHandlerContext, int, int, io.netty.handler.codec.http2.Http2Headers, int, io.netty.channel.ChannelPromise):io.netty.channel.ChannelFuture");
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeGoAway(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf, ChannelPromise channelPromise) {
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        try {
            verifyStreamOrConnectionId(i, "Last Stream ID");
            verifyErrorCode(j);
            int readableBytes = byteBuf.readableBytes() + 8;
            ByteBuf buffer = channelHandlerContext.alloc().buffer(17);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, readableBytes, (byte) 7, new Http2Flags(), 0);
            buffer.writeInt(i);
            buffer.writeInt((int) j);
            channelHandlerContext.write(buffer, simpleChannelPromiseAggregator.newPromise());
            try {
                channelHandlerContext.write(byteBuf, simpleChannelPromiseAggregator.newPromise());
            } catch (Throwable th) {
                simpleChannelPromiseAggregator.setFailure(th);
            }
            return simpleChannelPromiseAggregator.doneAllocatingPromises();
        } catch (Throwable th2) {
            try {
                byteBuf.release();
                return simpleChannelPromiseAggregator;
            } finally {
                simpleChannelPromiseAggregator.setFailure(th2);
                simpleChannelPromiseAggregator.doneAllocatingPromises();
            }
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeWindowUpdate(ChannelHandlerContext channelHandlerContext, int i, int i2, ChannelPromise channelPromise) {
        try {
            verifyStreamOrConnectionId(i, STREAM_ID);
            verifyWindowSizeIncrement(i2);
            ByteBuf buffer = channelHandlerContext.alloc().buffer(13);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, 4, (byte) 8, new Http2Flags(), i);
            buffer.writeInt(i2);
            return channelHandlerContext.write(buffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeFrame(ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf, ChannelPromise channelPromise) {
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        try {
            verifyStreamOrConnectionId(i, STREAM_ID);
            ByteBuf buffer = channelHandlerContext.alloc().buffer(9);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, byteBuf.readableBytes(), b, http2Flags, i);
            channelHandlerContext.write(buffer, simpleChannelPromiseAggregator.newPromise());
            try {
                channelHandlerContext.write(byteBuf, simpleChannelPromiseAggregator.newPromise());
            } catch (Throwable th) {
                simpleChannelPromiseAggregator.setFailure(th);
            }
            return simpleChannelPromiseAggregator.doneAllocatingPromises();
        } catch (Throwable th2) {
            try {
                byteBuf.release();
                return simpleChannelPromiseAggregator;
            } finally {
                simpleChannelPromiseAggregator.setFailure(th2);
                simpleChannelPromiseAggregator.doneAllocatingPromises();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00da, code lost:
    
        if (r7 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ee, code lost:
    
        if (r7 == null) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private io.netty.channel.ChannelFuture writeHeadersInternal(io.netty.channel.ChannelHandlerContext r16, int r17, io.netty.handler.codec.http2.Http2Headers r18, int r19, boolean r20, boolean r21, int r22, short r23, boolean r24, io.netty.channel.ChannelPromise r25) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.DefaultHttp2FrameWriter.writeHeadersInternal(io.netty.channel.ChannelHandlerContext, int, io.netty.handler.codec.http2.Http2Headers, int, boolean, boolean, int, short, boolean, io.netty.channel.ChannelPromise):io.netty.channel.ChannelFuture");
    }

    private ChannelFuture writeContinuationFrames(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator) {
        Http2Flags paddingPresent = new Http2Flags().paddingPresent(i2 > 0);
        int i3 = this.maxFrameSize - i2;
        if (i3 <= 0) {
            return simpleChannelPromiseAggregator.setFailure((Throwable) new IllegalArgumentException("Padding [" + i2 + "] is too large for max frame size [" + this.maxFrameSize + "]"));
        }
        if (byteBuf.isReadable()) {
            int min = Math.min(byteBuf.readableBytes(), i3) + i2;
            ByteBuf buffer = channelHandlerContext.alloc().buffer(10);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, min, (byte) 9, paddingPresent, i);
            writePaddingLength(buffer, i2);
            do {
                int min2 = Math.min(byteBuf.readableBytes(), i3);
                ByteBuf readRetainedSlice = byteBuf.readRetainedSlice(min2);
                int i4 = min2 + i2;
                if (byteBuf.isReadable()) {
                    channelHandlerContext.write(buffer.retain(), simpleChannelPromiseAggregator.newPromise());
                } else {
                    paddingPresent = paddingPresent.endOfHeaders(true);
                    buffer.release();
                    buffer = channelHandlerContext.alloc().buffer(10);
                    Http2CodecUtil.writeFrameHeaderInternal(buffer, i4, (byte) 9, paddingPresent, i);
                    writePaddingLength(buffer, i2);
                    channelHandlerContext.write(buffer, simpleChannelPromiseAggregator.newPromise());
                }
                channelHandlerContext.write(readRetainedSlice, simpleChannelPromiseAggregator.newPromise());
                if (paddingBytes(i2) > 0) {
                    channelHandlerContext.write(ZERO_BUFFER.slice(0, paddingBytes(i2)), simpleChannelPromiseAggregator.newPromise());
                }
            } while (byteBuf.isReadable());
        }
        return simpleChannelPromiseAggregator;
    }

    private static void writePaddingLength(ByteBuf byteBuf, int i) {
        if (i > 0) {
            byteBuf.writeByte(i - 1);
        }
    }

    private static void verifyStreamId(int i, String str) {
        if (i <= 0) {
            throw new IllegalArgumentException(str + " must be > 0");
        }
    }

    private static void verifyStreamOrConnectionId(int i, String str) {
        if (i < 0) {
            throw new IllegalArgumentException(str + " must be >= 0");
        }
    }

    private static void verifyWeight(short s) {
        if (s < 1 || s > 256) {
            throw new IllegalArgumentException("Invalid weight: " + ((int) s));
        }
    }

    private static void verifyErrorCode(long j) {
        if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException("Invalid errorCode: " + j);
        }
    }

    private static void verifyWindowSizeIncrement(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("WindowSizeIncrement must be >= 0");
        }
    }

    private static void verifyPingPayload(ByteBuf byteBuf) {
        if (byteBuf == null || byteBuf.readableBytes() != 8) {
            throw new IllegalArgumentException("Opaque data must be 8 bytes");
        }
    }
}

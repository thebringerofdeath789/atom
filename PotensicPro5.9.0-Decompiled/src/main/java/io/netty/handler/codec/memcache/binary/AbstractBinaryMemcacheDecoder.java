package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.memcache.AbstractMemcacheObjectDecoder;
import io.netty.handler.codec.memcache.DefaultLastMemcacheContent;
import io.netty.handler.codec.memcache.MemcacheContent;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage;

/* loaded from: classes3.dex */
public abstract class AbstractBinaryMemcacheDecoder<M extends BinaryMemcacheMessage> extends AbstractMemcacheObjectDecoder {
    public static final int DEFAULT_MAX_CHUNK_SIZE = 8192;
    private int alreadyReadChunkSize;
    private final int chunkSize;
    private M currentMessage;
    private State state;

    enum State {
        READ_HEADER,
        READ_EXTRAS,
        READ_KEY,
        READ_CONTENT,
        BAD_MESSAGE
    }

    protected abstract M buildInvalidMessage();

    protected abstract M decodeHeader(ByteBuf byteBuf);

    protected AbstractBinaryMemcacheDecoder() {
        this(8192);
    }

    protected AbstractBinaryMemcacheDecoder(int i) {
        this.state = State.READ_HEADER;
        if (i < 0) {
            throw new IllegalArgumentException("chunkSize must be a positive integer: " + i);
        }
        this.chunkSize = i;
    }

    /* renamed from: io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State = iArr;
            try {
                iArr[State.READ_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State[State.READ_EXTRAS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State[State.READ_KEY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State[State.READ_CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State[State.BAD_MESSAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00da A[Catch: Exception -> 0x00e7, TryCatch #2 {Exception -> 0x00e7, blocks: (B:17:0x0093, B:21:0x00b0, B:24:0x00b5, B:27:0x00bc, B:29:0x00c7, B:30:0x00d2, B:33:0x00df, B:36:0x00cd, B:37:0x00da), top: B:16:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0076 A[Catch: Exception -> 0x00f3, TryCatch #3 {Exception -> 0x00f3, blocks: (B:42:0x006e, B:44:0x0076, B:47:0x007d, B:48:0x0086), top: B:41:0x006e }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r3, io.netty.buffer.ByteBuf r4, java.util.List<java.lang.Object> r5) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    private M invalidMessage(Exception exc) {
        this.state = State.BAD_MESSAGE;
        M buildInvalidMessage = buildInvalidMessage();
        buildInvalidMessage.setDecoderResult(DecoderResult.failure(exc));
        return buildInvalidMessage;
    }

    private MemcacheContent invalidChunk(Exception exc) {
        this.state = State.BAD_MESSAGE;
        DefaultLastMemcacheContent defaultLastMemcacheContent = new DefaultLastMemcacheContent(Unpooled.EMPTY_BUFFER);
        defaultLastMemcacheContent.setDecoderResult(DecoderResult.failure(exc));
        return defaultLastMemcacheContent;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.channelInactive(channelHandlerContext);
        resetDecoder();
    }

    protected void resetDecoder() {
        M m = this.currentMessage;
        if (m != null) {
            m.release();
            this.currentMessage = null;
        }
        this.alreadyReadChunkSize = 0;
    }
}

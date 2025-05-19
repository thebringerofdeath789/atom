package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/* loaded from: classes3.dex */
abstract class SpdyHeaderBlockDecoder {
    abstract void decode(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, SpdyHeadersFrame spdyHeadersFrame) throws Exception;

    abstract void end();

    abstract void endHeaderBlock(SpdyHeadersFrame spdyHeadersFrame) throws Exception;

    SpdyHeaderBlockDecoder() {
    }

    static SpdyHeaderBlockDecoder newInstance(SpdyVersion spdyVersion, int i) {
        return new SpdyHeaderBlockZlibDecoder(spdyVersion, i);
    }
}

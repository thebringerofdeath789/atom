package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.PlatformDependent;

/* loaded from: classes3.dex */
abstract class SpdyHeaderBlockEncoder {
    abstract ByteBuf encode(ByteBufAllocator byteBufAllocator, SpdyHeadersFrame spdyHeadersFrame) throws Exception;

    abstract void end();

    SpdyHeaderBlockEncoder() {
    }

    static SpdyHeaderBlockEncoder newInstance(SpdyVersion spdyVersion, int i, int i2, int i3) {
        if (PlatformDependent.javaVersion() >= 7) {
            return new SpdyHeaderBlockZlibEncoder(spdyVersion, i);
        }
        return new SpdyHeaderBlockJZlibEncoder(spdyVersion, i, i2, i3);
    }
}

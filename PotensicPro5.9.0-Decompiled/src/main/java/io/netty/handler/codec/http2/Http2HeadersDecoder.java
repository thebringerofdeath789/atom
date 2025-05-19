package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;

/* loaded from: classes3.dex */
public interface Http2HeadersDecoder {

    public interface Configuration {
        long maxHeaderListSize();

        void maxHeaderListSize(long j, long j2) throws Http2Exception;

        long maxHeaderListSizeGoAway();

        long maxHeaderTableSize();

        void maxHeaderTableSize(long j) throws Http2Exception;
    }

    Configuration configuration();

    Http2Headers decodeHeaders(int i, ByteBuf byteBuf) throws Http2Exception;
}

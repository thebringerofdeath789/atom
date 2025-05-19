package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2Stream;

/* loaded from: classes3.dex */
public interface Http2FrameStream {
    public static final Http2FrameStream CONNECTION_STREAM = new Http2FrameStream() { // from class: io.netty.handler.codec.http2.Http2FrameStream.1
        @Override // io.netty.handler.codec.http2.Http2FrameStream
        public int id() {
            return 0;
        }

        @Override // io.netty.handler.codec.http2.Http2FrameStream
        public Http2Stream.State state() {
            return Http2Stream.State.IDLE;
        }
    };

    int id();

    Http2Stream.State state();
}

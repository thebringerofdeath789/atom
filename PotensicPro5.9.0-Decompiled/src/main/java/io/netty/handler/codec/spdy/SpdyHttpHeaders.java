package io.netty.handler.codec.spdy;

import io.netty.util.AsciiString;

/* loaded from: classes3.dex */
public final class SpdyHttpHeaders {

    public static final class Names {
        public static final AsciiString STREAM_ID = AsciiString.cached("x-spdy-stream-id");
        public static final AsciiString ASSOCIATED_TO_STREAM_ID = AsciiString.cached("x-spdy-associated-to-stream-id");
        public static final AsciiString PRIORITY = AsciiString.cached("x-spdy-priority");
        public static final AsciiString SCHEME = AsciiString.cached("x-spdy-scheme");

        private Names() {
        }
    }

    private SpdyHttpHeaders() {
    }
}

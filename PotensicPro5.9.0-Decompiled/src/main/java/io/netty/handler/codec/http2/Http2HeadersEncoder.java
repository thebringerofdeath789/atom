package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;

/* loaded from: classes3.dex */
public interface Http2HeadersEncoder {
    public static final SensitivityDetector NEVER_SENSITIVE = new SensitivityDetector() { // from class: io.netty.handler.codec.http2.Http2HeadersEncoder.1
        @Override // io.netty.handler.codec.http2.Http2HeadersEncoder.SensitivityDetector
        public boolean isSensitive(CharSequence charSequence, CharSequence charSequence2) {
            return false;
        }
    };
    public static final SensitivityDetector ALWAYS_SENSITIVE = new SensitivityDetector() { // from class: io.netty.handler.codec.http2.Http2HeadersEncoder.2
        @Override // io.netty.handler.codec.http2.Http2HeadersEncoder.SensitivityDetector
        public boolean isSensitive(CharSequence charSequence, CharSequence charSequence2) {
            return true;
        }
    };

    public interface Configuration {
        long maxHeaderListSize();

        void maxHeaderListSize(long j) throws Http2Exception;

        long maxHeaderTableSize();

        void maxHeaderTableSize(long j) throws Http2Exception;
    }

    public interface SensitivityDetector {
        boolean isSensitive(CharSequence charSequence, CharSequence charSequence2);
    }

    Configuration configuration();

    void encodeHeaders(int i, Http2Headers http2Headers, ByteBuf byteBuf) throws Http2Exception;
}

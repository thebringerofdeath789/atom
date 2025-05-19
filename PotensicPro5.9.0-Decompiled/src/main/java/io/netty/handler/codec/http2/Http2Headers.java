package io.netty.handler.codec.http2;

import io.netty.handler.codec.Headers;
import io.netty.util.AsciiString;
import java.util.Iterator;
import java.util.Map;
import okhttp3.internal.http2.Header;

/* loaded from: classes3.dex */
public interface Http2Headers extends Headers<CharSequence, CharSequence, Http2Headers> {
    Http2Headers authority(CharSequence charSequence);

    CharSequence authority();

    @Override // io.netty.handler.codec.Headers, java.lang.Iterable
    Iterator<Map.Entry<CharSequence, CharSequence>> iterator();

    Http2Headers method(CharSequence charSequence);

    CharSequence method();

    Http2Headers path(CharSequence charSequence);

    CharSequence path();

    Http2Headers scheme(CharSequence charSequence);

    CharSequence scheme();

    Http2Headers status(CharSequence charSequence);

    CharSequence status();

    Iterator<CharSequence> valueIterator(CharSequence charSequence);

    public enum PseudoHeaderName {
        METHOD(Header.TARGET_METHOD_UTF8),
        SCHEME(Header.TARGET_SCHEME_UTF8),
        AUTHORITY(Header.TARGET_AUTHORITY_UTF8),
        PATH(Header.TARGET_PATH_UTF8),
        STATUS(Header.RESPONSE_STATUS_UTF8);

        private static final CharSequenceMap<AsciiString> PSEUDO_HEADERS = new CharSequenceMap<>();
        private final AsciiString value;

        static {
            for (PseudoHeaderName pseudoHeaderName : values()) {
                PSEUDO_HEADERS.add((CharSequenceMap<AsciiString>) pseudoHeaderName.value(), AsciiString.EMPTY_STRING);
            }
        }

        PseudoHeaderName(String str) {
            this.value = AsciiString.cached(str);
        }

        public AsciiString value() {
            return this.value;
        }

        public static boolean isPseudoHeader(CharSequence charSequence) {
            return PSEUDO_HEADERS.contains(charSequence);
        }
    }
}

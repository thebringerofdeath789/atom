package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpHeaders;

/* loaded from: classes3.dex */
final class HttpPostBodyUtil {
    public static final String DEFAULT_BINARY_CONTENT_TYPE = "application/octet-stream";
    public static final String DEFAULT_TEXT_CONTENT_TYPE = "text/plain";
    public static final int chunkSize = 8096;

    public enum TransferEncodingMechanism {
        BIT7("7bit"),
        BIT8("8bit"),
        BINARY(HttpHeaders.Values.BINARY);

        private final String value;

        TransferEncodingMechanism(String str) {
            this.value = str;
        }

        public String value() {
            return this.value;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    private HttpPostBodyUtil() {
    }

    static class SeekAheadOptimize {
        ByteBuf buffer;
        byte[] bytes;
        int limit;
        int origPos;
        int pos;
        int readerIndex;

        SeekAheadOptimize(ByteBuf byteBuf) {
            if (!byteBuf.hasArray()) {
                throw new IllegalArgumentException("buffer hasn't backing byte array");
            }
            this.buffer = byteBuf;
            this.bytes = byteBuf.array();
            this.readerIndex = byteBuf.readerIndex();
            int arrayOffset = byteBuf.arrayOffset() + this.readerIndex;
            this.pos = arrayOffset;
            this.origPos = arrayOffset;
            this.limit = byteBuf.arrayOffset() + byteBuf.writerIndex();
        }

        void setReadPosition(int i) {
            int i2 = this.pos - i;
            this.pos = i2;
            int readPosition = getReadPosition(i2);
            this.readerIndex = readPosition;
            this.buffer.readerIndex(readPosition);
        }

        int getReadPosition(int i) {
            return (i - this.origPos) + this.readerIndex;
        }
    }

    static int findNonWhitespace(String str, int i) {
        while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return i;
    }

    static int findEndOfString(String str) {
        int length = str.length();
        while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }
        return length;
    }
}

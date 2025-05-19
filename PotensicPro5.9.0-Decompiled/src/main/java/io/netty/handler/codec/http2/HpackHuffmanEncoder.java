package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;

/* loaded from: classes3.dex */
final class HpackHuffmanEncoder {
    private final int[] codes;
    private final EncodeProcessor encodeProcessor;
    private final EncodedLengthProcessor encodedLengthProcessor;
    private final byte[] lengths;

    HpackHuffmanEncoder() {
        this(HpackUtil.HUFFMAN_CODES, HpackUtil.HUFFMAN_CODE_LENGTHS);
    }

    private HpackHuffmanEncoder(int[] iArr, byte[] bArr) {
        this.encodedLengthProcessor = new EncodedLengthProcessor();
        this.encodeProcessor = new EncodeProcessor();
        this.codes = iArr;
        this.lengths = bArr;
    }

    public void encode(ByteBuf byteBuf, CharSequence charSequence) {
        ObjectUtil.checkNotNull(byteBuf, "out");
        if (charSequence instanceof AsciiString) {
            AsciiString asciiString = (AsciiString) charSequence;
            try {
                try {
                    this.encodeProcessor.out = byteBuf;
                    asciiString.forEachByte(this.encodeProcessor);
                } catch (Exception e) {
                    PlatformDependent.throwException(e);
                }
                return;
            } finally {
                this.encodeProcessor.end();
            }
        }
        encodeSlowPath(byteBuf, charSequence);
    }

    private void encodeSlowPath(ByteBuf byteBuf, CharSequence charSequence) {
        long j = 0;
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            int charAt = charSequence.charAt(i2) & 255;
            int i3 = this.codes[charAt];
            byte b = this.lengths[charAt];
            j = (j << b) | i3;
            i += b;
            while (i >= 8) {
                i -= 8;
                byteBuf.writeByte((int) (j >> i));
            }
        }
        if (i > 0) {
            byteBuf.writeByte((int) ((255 >>> i) | (j << (8 - i))));
        }
    }

    int getEncodedLength(CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            AsciiString asciiString = (AsciiString) charSequence;
            try {
                this.encodedLengthProcessor.reset();
                asciiString.forEachByte(this.encodedLengthProcessor);
                return this.encodedLengthProcessor.length();
            } catch (Exception e) {
                PlatformDependent.throwException(e);
                return -1;
            }
        }
        return getEncodedLengthSlowPath(charSequence);
    }

    private int getEncodedLengthSlowPath(CharSequence charSequence) {
        long j = 0;
        for (int i = 0; i < charSequence.length(); i++) {
            j += this.lengths[charSequence.charAt(i) & 255];
        }
        return (int) ((j + 7) >> 3);
    }

    private final class EncodeProcessor implements ByteProcessor {
        private long current;
        private int n;
        ByteBuf out;

        private EncodeProcessor() {
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            byte b2 = HpackHuffmanEncoder.this.lengths[b & 255];
            long j = this.current << b2;
            this.current = j;
            this.current = j | HpackHuffmanEncoder.this.codes[r6];
            this.n += b2;
            while (true) {
                int i = this.n;
                if (i < 8) {
                    return true;
                }
                int i2 = i - 8;
                this.n = i2;
                this.out.writeByte((int) (this.current >> i2));
            }
        }

        void end() {
            try {
                int i = this.n;
                if (i > 0) {
                    long j = this.current << (8 - i);
                    this.current = j;
                    long j2 = j | (255 >>> i);
                    this.current = j2;
                    this.out.writeByte((int) j2);
                }
            } finally {
                this.out = null;
                this.current = 0L;
                this.n = 0;
            }
        }
    }

    private final class EncodedLengthProcessor implements ByteProcessor {
        private long len;

        private EncodedLengthProcessor() {
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            this.len += HpackHuffmanEncoder.this.lengths[b & 255];
            return true;
        }

        void reset() {
            this.len = 0L;
        }

        int length() {
            return (int) ((this.len + 7) >> 3);
        }
    }
}

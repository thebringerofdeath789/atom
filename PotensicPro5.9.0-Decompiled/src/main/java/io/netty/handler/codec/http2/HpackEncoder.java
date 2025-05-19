package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.HpackUtil;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.MathUtil;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes3.dex */
final class HpackEncoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final byte hashMask;
    private final HeaderEntry head;
    private final HeaderEntry[] headerFields;
    private final HpackHuffmanEncoder hpackHuffmanEncoder;
    private final boolean ignoreMaxHeaderListSize;
    private long maxHeaderListSize;
    private long maxHeaderTableSize;
    private long size;

    HpackEncoder() {
        this(false);
    }

    public HpackEncoder(boolean z) {
        this(z, 16);
    }

    public HpackEncoder(boolean z, int i) {
        HeaderEntry headerEntry = new HeaderEntry(-1, AsciiString.EMPTY_STRING, AsciiString.EMPTY_STRING, Integer.MAX_VALUE, null);
        this.head = headerEntry;
        this.hpackHuffmanEncoder = new HpackHuffmanEncoder();
        this.ignoreMaxHeaderListSize = z;
        this.maxHeaderTableSize = 4096L;
        this.maxHeaderListSize = 8192L;
        this.headerFields = new HeaderEntry[MathUtil.findNextPositivePowerOfTwo(Math.max(2, Math.min(i, 128)))];
        this.hashMask = (byte) (r8.length - 1);
        headerEntry.after = headerEntry;
        headerEntry.before = headerEntry;
    }

    public void encodeHeaders(int i, ByteBuf byteBuf, Http2Headers http2Headers, Http2HeadersEncoder.SensitivityDetector sensitivityDetector) throws Http2Exception {
        if (this.ignoreMaxHeaderListSize) {
            encodeHeadersIgnoreMaxHeaderListSize(byteBuf, http2Headers, sensitivityDetector);
        } else {
            encodeHeadersEnforceMaxHeaderListSize(i, byteBuf, http2Headers, sensitivityDetector);
        }
    }

    private void encodeHeadersEnforceMaxHeaderListSize(int i, ByteBuf byteBuf, Http2Headers http2Headers, Http2HeadersEncoder.SensitivityDetector sensitivityDetector) throws Http2Exception {
        long j = 0;
        for (Map.Entry<CharSequence, CharSequence> entry : http2Headers) {
            j += HpackHeaderField.sizeOf(entry.getKey(), entry.getValue());
            long j2 = this.maxHeaderListSize;
            if (j > j2) {
                Http2CodecUtil.headerListSizeExceeded(i, j2, false);
            }
        }
        encodeHeadersIgnoreMaxHeaderListSize(byteBuf, http2Headers, sensitivityDetector);
    }

    private void encodeHeadersIgnoreMaxHeaderListSize(ByteBuf byteBuf, Http2Headers http2Headers, Http2HeadersEncoder.SensitivityDetector sensitivityDetector) throws Http2Exception {
        for (Map.Entry<CharSequence, CharSequence> entry : http2Headers) {
            CharSequence key = entry.getKey();
            CharSequence value = entry.getValue();
            encodeHeader(byteBuf, key, value, sensitivityDetector.isSensitive(key, value), HpackHeaderField.sizeOf(key, value));
        }
    }

    private void encodeHeader(ByteBuf byteBuf, CharSequence charSequence, CharSequence charSequence2, boolean z, long j) {
        if (z) {
            encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.NEVER, getNameIndex(charSequence));
            return;
        }
        long j2 = this.maxHeaderTableSize;
        if (j2 == 0) {
            int index = HpackStaticTable.getIndex(charSequence, charSequence2);
            if (index == -1) {
                encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.NONE, HpackStaticTable.getIndex(charSequence));
                return;
            } else {
                encodeInteger(byteBuf, 128, 7, index);
                return;
            }
        }
        if (j > j2) {
            encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.NONE, getNameIndex(charSequence));
            return;
        }
        HeaderEntry entry = getEntry(charSequence, charSequence2);
        if (entry != null) {
            encodeInteger(byteBuf, 128, 7, getIndex(entry.index) + HpackStaticTable.length);
            return;
        }
        int index2 = HpackStaticTable.getIndex(charSequence, charSequence2);
        if (index2 != -1) {
            encodeInteger(byteBuf, 128, 7, index2);
            return;
        }
        ensureCapacity(j);
        encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.INCREMENTAL, getNameIndex(charSequence));
        add(charSequence, charSequence2, j);
    }

    public void setMaxHeaderTableSize(ByteBuf byteBuf, long j) throws Http2Exception {
        if (j < 0 || j > 4294967295L) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header Table Size must be >= %d and <= %d but was %d", 0L, 4294967295L, Long.valueOf(j));
        }
        if (this.maxHeaderTableSize == j) {
            return;
        }
        this.maxHeaderTableSize = j;
        ensureCapacity(0L);
        encodeInteger(byteBuf, 32, 5, j);
    }

    public long getMaxHeaderTableSize() {
        return this.maxHeaderTableSize;
    }

    public void setMaxHeaderListSize(long j) throws Http2Exception {
        if (j < 0 || j > 4294967295L) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header List Size must be >= %d and <= %d but was %d", 0L, 4294967295L, Long.valueOf(j));
        }
        this.maxHeaderListSize = j;
    }

    public long getMaxHeaderListSize() {
        return this.maxHeaderListSize;
    }

    private static void encodeInteger(ByteBuf byteBuf, int i, int i2, int i3) {
        encodeInteger(byteBuf, i, i2, i3);
    }

    private static void encodeInteger(ByteBuf byteBuf, int i, int i2, long j) {
        int i3 = 255 >>> (8 - i2);
        long j2 = i3;
        if (j < j2) {
            byteBuf.writeByte((int) (i | j));
            return;
        }
        byteBuf.writeByte(i | i3);
        long j3 = j - j2;
        while (((-128) & j3) != 0) {
            byteBuf.writeByte((int) ((127 & j3) | 128));
            j3 >>>= 7;
        }
        byteBuf.writeByte((int) j3);
    }

    private void encodeStringLiteral(ByteBuf byteBuf, CharSequence charSequence) {
        int encodedLength = this.hpackHuffmanEncoder.getEncodedLength(charSequence);
        if (encodedLength < charSequence.length()) {
            encodeInteger(byteBuf, 128, 7, encodedLength);
            this.hpackHuffmanEncoder.encode(byteBuf, charSequence);
            return;
        }
        encodeInteger(byteBuf, 0, 7, charSequence.length());
        if (charSequence instanceof AsciiString) {
            AsciiString asciiString = (AsciiString) charSequence;
            byteBuf.writeBytes(asciiString.array(), asciiString.arrayOffset(), asciiString.length());
        } else {
            byteBuf.writeCharSequence(charSequence, CharsetUtil.ISO_8859_1);
        }
    }

    /* renamed from: io.netty.handler.codec.http2.HpackEncoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType;

        static {
            int[] iArr = new int[HpackUtil.IndexType.values().length];
            $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType = iArr;
            try {
                iArr[HpackUtil.IndexType.INCREMENTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[HpackUtil.IndexType.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[HpackUtil.IndexType.NEVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void encodeLiteral(ByteBuf byteBuf, CharSequence charSequence, CharSequence charSequence2, HpackUtil.IndexType indexType, int i) {
        boolean z = i != -1;
        int i2 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[indexType.ordinal()];
        if (i2 == 1) {
            if (!z) {
                i = 0;
            }
            encodeInteger(byteBuf, 64, 6, i);
        } else if (i2 == 2) {
            if (!z) {
                i = 0;
            }
            encodeInteger(byteBuf, 0, 4, i);
        } else if (i2 == 3) {
            if (!z) {
                i = 0;
            }
            encodeInteger(byteBuf, 16, 4, i);
        } else {
            throw new Error("should not reach here");
        }
        if (!z) {
            encodeStringLiteral(byteBuf, charSequence);
        }
        encodeStringLiteral(byteBuf, charSequence2);
    }

    private int getNameIndex(CharSequence charSequence) {
        int index = HpackStaticTable.getIndex(charSequence);
        if (index != -1) {
            return index;
        }
        int index2 = getIndex(charSequence);
        return index2 >= 0 ? index2 + HpackStaticTable.length : index2;
    }

    private void ensureCapacity(long j) {
        while (this.maxHeaderTableSize - this.size < j && length() != 0) {
            remove();
        }
    }

    int length() {
        if (this.size == 0) {
            return 0;
        }
        return (this.head.after.index - this.head.before.index) + 1;
    }

    long size() {
        return this.size;
    }

    HpackHeaderField getHeaderField(int i) {
        HeaderEntry headerEntry = this.head;
        while (true) {
            int i2 = i - 1;
            if (i < 0) {
                return headerEntry;
            }
            headerEntry = headerEntry.before;
            i = i2;
        }
    }

    private HeaderEntry getEntry(CharSequence charSequence, CharSequence charSequence2) {
        if (length() != 0 && charSequence != null && charSequence2 != null) {
            int hashCode = AsciiString.hashCode(charSequence);
            for (HeaderEntry headerEntry = this.headerFields[index(hashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
                if (headerEntry.hash == hashCode && (HpackUtil.equalsConstantTime(charSequence, headerEntry.name) & HpackUtil.equalsConstantTime(charSequence2, headerEntry.value)) != 0) {
                    return headerEntry;
                }
            }
        }
        return null;
    }

    private int getIndex(CharSequence charSequence) {
        if (length() != 0 && charSequence != null) {
            int hashCode = AsciiString.hashCode(charSequence);
            for (HeaderEntry headerEntry = this.headerFields[index(hashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
                if (headerEntry.hash == hashCode && HpackUtil.equalsConstantTime(charSequence, headerEntry.name) != 0) {
                    return getIndex(headerEntry.index);
                }
            }
        }
        return -1;
    }

    private int getIndex(int i) {
        if (i == -1) {
            return -1;
        }
        return (i - this.head.before.index) + 1;
    }

    private void add(CharSequence charSequence, CharSequence charSequence2, long j) {
        if (j > this.maxHeaderTableSize) {
            clear();
            return;
        }
        while (this.maxHeaderTableSize - this.size < j) {
            remove();
        }
        int hashCode = AsciiString.hashCode(charSequence);
        int index = index(hashCode);
        HeaderEntry headerEntry = new HeaderEntry(hashCode, charSequence, charSequence2, this.head.before.index - 1, this.headerFields[index]);
        this.headerFields[index] = headerEntry;
        headerEntry.addBefore(this.head);
        this.size += j;
    }

    private HpackHeaderField remove() {
        if (this.size == 0) {
            return null;
        }
        HeaderEntry headerEntry = this.head.after;
        int index = index(headerEntry.hash);
        HeaderEntry headerEntry2 = this.headerFields[index];
        HeaderEntry headerEntry3 = headerEntry2;
        while (headerEntry2 != null) {
            HeaderEntry headerEntry4 = headerEntry2.next;
            if (headerEntry2 == headerEntry) {
                if (headerEntry3 == headerEntry) {
                    this.headerFields[index] = headerEntry4;
                } else {
                    headerEntry3.next = headerEntry4;
                }
                headerEntry.remove();
                this.size -= headerEntry.size();
                return headerEntry;
            }
            headerEntry3 = headerEntry2;
            headerEntry2 = headerEntry4;
        }
        return null;
    }

    private void clear() {
        Arrays.fill(this.headerFields, (Object) null);
        HeaderEntry headerEntry = this.head;
        headerEntry.after = headerEntry;
        headerEntry.before = headerEntry;
        this.size = 0L;
    }

    private int index(int i) {
        return i & this.hashMask;
    }

    private static final class HeaderEntry extends HpackHeaderField {
        HeaderEntry after;
        HeaderEntry before;
        int hash;
        int index;
        HeaderEntry next;

        HeaderEntry(int i, CharSequence charSequence, CharSequence charSequence2, int i2, HeaderEntry headerEntry) {
            super(charSequence, charSequence2);
            this.index = i2;
            this.hash = i;
            this.next = headerEntry;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void remove() {
            HeaderEntry headerEntry = this.before;
            headerEntry.after = this.after;
            this.after.before = headerEntry;
            this.before = null;
            this.after = null;
            this.next = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addBefore(HeaderEntry headerEntry) {
            this.after = headerEntry;
            HeaderEntry headerEntry2 = headerEntry.before;
            this.before = headerEntry2;
            headerEntry2.after = this;
            this.after.before = this;
        }
    }
}

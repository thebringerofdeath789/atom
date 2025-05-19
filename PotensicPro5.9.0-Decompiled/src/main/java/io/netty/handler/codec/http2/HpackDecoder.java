package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.HpackUtil;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.ThrowableUtil;

/* loaded from: classes3.dex */
final class HpackDecoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte READ_HEADER_REPRESENTATION = 0;
    private static final byte READ_INDEXED_HEADER = 2;
    private static final byte READ_INDEXED_HEADER_NAME = 3;
    private static final byte READ_LITERAL_HEADER_NAME = 6;
    private static final byte READ_LITERAL_HEADER_NAME_LENGTH = 5;
    private static final byte READ_LITERAL_HEADER_NAME_LENGTH_PREFIX = 4;
    private static final byte READ_LITERAL_HEADER_VALUE = 9;
    private static final byte READ_LITERAL_HEADER_VALUE_LENGTH = 8;
    private static final byte READ_LITERAL_HEADER_VALUE_LENGTH_PREFIX = 7;
    private static final byte READ_MAX_DYNAMIC_TABLE_SIZE = 1;
    private long encoderMaxDynamicTableSize;
    private final HpackDynamicTable hpackDynamicTable;
    private final HpackHuffmanDecoder hpackHuffmanDecoder;
    private long maxDynamicTableSize;
    private boolean maxDynamicTableSizeChangeRequired;
    private long maxHeaderListSize;
    private long maxHeaderListSizeGoAway;
    private static final Http2Exception DECODE_ULE_128_DECOMPRESSION_EXCEPTION = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, "HPACK - decompression failure", new Object[0]), HpackDecoder.class, "decodeULE128(..)");
    private static final Http2Exception DECODE_ULE_128_TO_LONG_DECOMPRESSION_EXCEPTION = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, "HPACK - long overflow", new Object[0]), HpackDecoder.class, "decodeULE128(..)");
    private static final Http2Exception DECODE_ULE_128_TO_INT_DECOMPRESSION_EXCEPTION = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, "HPACK - int overflow", new Object[0]), HpackDecoder.class, "decodeULE128ToInt(..)");
    private static final Http2Exception DECODE_ILLEGAL_INDEX_VALUE = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, "HPACK - illegal index value", new Object[0]), HpackDecoder.class, "decode(..)");
    private static final Http2Exception INDEX_HEADER_ILLEGAL_INDEX_VALUE = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, "HPACK - illegal index value", new Object[0]), HpackDecoder.class, "indexHeader(..)");
    private static final Http2Exception READ_NAME_ILLEGAL_INDEX_VALUE = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, "HPACK - illegal index value", new Object[0]), HpackDecoder.class, "readName(..)");
    private static final Http2Exception INVALID_MAX_DYNAMIC_TABLE_SIZE = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, "HPACK - invalid max dynamic table size", new Object[0]), HpackDecoder.class, "setDynamicTableSize(..)");
    private static final Http2Exception MAX_DYNAMIC_TABLE_SIZE_CHANGE_REQUIRED = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, "HPACK - max dynamic table size change required", new Object[0]), HpackDecoder.class, "decode(..)");

    HpackDecoder(long j, int i) {
        this(j, i, 4096);
    }

    HpackDecoder(long j, int i, int i2) {
        this.maxHeaderListSize = ObjectUtil.checkPositive(j, "maxHeaderListSize");
        this.maxHeaderListSizeGoAway = Http2CodecUtil.calculateMaxHeaderListSizeGoAway(j);
        long j2 = i2;
        this.encoderMaxDynamicTableSize = j2;
        this.maxDynamicTableSize = j2;
        this.maxDynamicTableSizeChangeRequired = false;
        this.hpackDynamicTable = new HpackDynamicTable(j2);
        this.hpackHuffmanDecoder = new HpackHuffmanDecoder(i);
    }

    public void decode(int i, ByteBuf byteBuf, Http2Headers http2Headers) throws Http2Exception {
        int i2;
        int i3;
        boolean z;
        boolean z2;
        int i4;
        int i5;
        HpackUtil.IndexType indexType = HpackUtil.IndexType.NONE;
        long j = 0;
        CharSequence charSequence = null;
        boolean z3 = false;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (byteBuf.isReadable()) {
            switch (i8) {
                case 0:
                    z = z3;
                    i2 = i6;
                    i3 = i7;
                    byte readByte = byteBuf.readByte();
                    if (this.maxDynamicTableSizeChangeRequired && (readByte & 224) != 32) {
                        throw MAX_DYNAMIC_TABLE_SIZE_CHANGE_REQUIRED;
                    }
                    if (readByte < 0) {
                        i9 = readByte & Byte.MAX_VALUE;
                        if (i9 == 0) {
                            throw DECODE_ILLEGAL_INDEX_VALUE;
                        }
                        if (i9 != 127) {
                            j = indexHeader(i, i9, http2Headers, j);
                            i8 = i8;
                            i7 = i3;
                            z3 = z;
                            i6 = i2;
                            i9 = i9;
                        } else {
                            i8 = 2;
                            i7 = i3;
                            z3 = z;
                            i6 = i2;
                        }
                    } else {
                        if ((readByte & 64) == 64) {
                            indexType = HpackUtil.IndexType.INCREMENTAL;
                            i9 = readByte & 63;
                            if (i9 == 0) {
                                i7 = i3;
                                z3 = z;
                                i6 = i2;
                                i8 = 4;
                            } else if (i9 != 63) {
                                charSequence = readName(i9);
                                i7 = i3;
                                z3 = z;
                                i8 = 7;
                            } else {
                                i7 = i3;
                                z3 = z;
                                i6 = i2;
                                i8 = 3;
                            }
                        } else if ((readByte & 32) == 32) {
                            i9 = readByte & 31;
                            if (i9 == 31) {
                                i7 = i3;
                                z3 = z;
                                i8 = 1;
                            } else {
                                setDynamicTableSize(i9);
                                i7 = i3;
                                z3 = z;
                                i8 = 0;
                            }
                        } else {
                            indexType = (readByte & 16) == 16 ? HpackUtil.IndexType.NEVER : HpackUtil.IndexType.NONE;
                            i9 = readByte & 15;
                            if (i9 == 0) {
                                i7 = i3;
                                z3 = z;
                                i6 = i2;
                                i8 = 4;
                            } else if (i9 != 15) {
                                charSequence = readName(i9);
                                i7 = i3;
                                z3 = z;
                                i8 = 7;
                            } else {
                                i7 = i3;
                                z3 = z;
                                i6 = i2;
                                i8 = 3;
                            }
                        }
                        i6 = i2;
                    }
                    break;
                case 1:
                    setDynamicTableSize(decodeULE128(byteBuf, i9));
                    z3 = z3;
                    i8 = 0;
                case 2:
                    z2 = z3;
                    i2 = i6;
                    i4 = i7;
                    i5 = i9;
                    j = indexHeader(i, decodeULE128(byteBuf, i5), http2Headers, j);
                    z3 = z2;
                    i7 = i4;
                    i9 = i5;
                    i8 = 0;
                    i6 = i2;
                case 3:
                    charSequence = readName(decodeULE128(byteBuf, i9));
                    i8 = 7;
                case 4:
                    i2 = i6;
                    int i10 = i7;
                    byte readByte2 = byteBuf.readByte();
                    boolean z4 = (readByte2 & 128) == 128;
                    i7 = readByte2 & Byte.MAX_VALUE;
                    if (i7 == 127) {
                        i8 = 5;
                        z3 = z4;
                        i9 = i7;
                        i7 = i10;
                        i6 = i2;
                    } else {
                        long j2 = i7;
                        long j3 = this.maxHeaderListSizeGoAway;
                        if (j2 > j3 - j) {
                            Http2CodecUtil.headerListSizeExceeded(j3);
                        }
                        z3 = z4;
                        i9 = i7;
                        i8 = 6;
                        i6 = i2;
                    }
                case 5:
                    boolean z5 = z3;
                    i2 = i6;
                    int i11 = i9;
                    i7 = decodeULE128(byteBuf, i11);
                    long j4 = i7;
                    long j5 = this.maxHeaderListSizeGoAway;
                    if (j4 > j5 - j) {
                        Http2CodecUtil.headerListSizeExceeded(j5);
                    }
                    z3 = z5;
                    i9 = i11;
                    i8 = 6;
                    i6 = i2;
                case 6:
                    boolean z6 = z3;
                    i2 = i6;
                    int i12 = i7;
                    int i13 = i9;
                    if (byteBuf.readableBytes() < i12) {
                        throw notEnoughDataException(byteBuf);
                    }
                    charSequence = readStringLiteral(byteBuf, i12, z6);
                    z3 = z6;
                    i7 = i12;
                    i9 = i13;
                    i8 = 7;
                    i6 = i2;
                case 7:
                    i2 = i6;
                    i3 = i7;
                    byte readByte3 = byteBuf.readByte();
                    z = (readByte3 & 128) == 128;
                    i9 = readByte3 & Byte.MAX_VALUE;
                    if (i9 == 0) {
                        j = insertHeader(i, http2Headers, charSequence, AsciiString.EMPTY_STRING, indexType, j);
                        i9 = i9;
                        i7 = i3;
                        z3 = z;
                        i8 = 0;
                        i6 = i2;
                    } else if (i9 != 127) {
                        long j6 = i9 + i3;
                        long j7 = this.maxHeaderListSizeGoAway;
                        if (j6 > j7 - j) {
                            Http2CodecUtil.headerListSizeExceeded(j7);
                        }
                        i6 = i9;
                        i7 = i3;
                        z3 = z;
                        i8 = 9;
                    } else {
                        i8 = 8;
                        i7 = i3;
                        z3 = z;
                        i6 = i2;
                    }
                case 8:
                    boolean z7 = z3;
                    int i14 = i7;
                    int i15 = i9;
                    i6 = decodeULE128(byteBuf, i15);
                    long j8 = i6 + i14;
                    long j9 = this.maxHeaderListSizeGoAway;
                    if (j8 > j9 - j) {
                        Http2CodecUtil.headerListSizeExceeded(j9);
                    }
                    z3 = z7;
                    i7 = i14;
                    i9 = i15;
                    i8 = 9;
                case 9:
                    if (byteBuf.readableBytes() < i6) {
                        throw notEnoughDataException(byteBuf);
                    }
                    z2 = z3;
                    i2 = i6;
                    i4 = i7;
                    i5 = i9;
                    j = insertHeader(i, http2Headers, charSequence, readStringLiteral(byteBuf, i6, z3), indexType, j);
                    z3 = z2;
                    i7 = i4;
                    i9 = i5;
                    i8 = 0;
                    i6 = i2;
                default:
                    throw new Error("should not reach here state: " + i8);
            }
        }
        long j10 = this.maxHeaderListSize;
        if (j > j10) {
            Http2CodecUtil.headerListSizeExceeded(i, j10, true);
        }
    }

    public void setMaxHeaderTableSize(long j) throws Http2Exception {
        if (j < 0 || j > 4294967295L) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header Table Size must be >= %d and <= %d but was %d", 0L, 4294967295L, Long.valueOf(j));
        }
        this.maxDynamicTableSize = j;
        if (j < this.encoderMaxDynamicTableSize) {
            this.maxDynamicTableSizeChangeRequired = true;
            this.hpackDynamicTable.setCapacity(j);
        }
    }

    public void setMaxHeaderListSize(long j, long j2) throws Http2Exception {
        if (j2 < j || j2 < 0) {
            throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "Header List Size GO_AWAY %d must be positive and >= %d", Long.valueOf(j2), Long.valueOf(j));
        }
        if (j < 0 || j > 4294967295L) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header List Size must be >= %d and <= %d but was %d", 0L, 4294967295L, Long.valueOf(j));
        }
        this.maxHeaderListSize = j;
        this.maxHeaderListSizeGoAway = j2;
    }

    public long getMaxHeaderListSize() {
        return this.maxHeaderListSize;
    }

    public long getMaxHeaderListSizeGoAway() {
        return this.maxHeaderListSizeGoAway;
    }

    public long getMaxHeaderTableSize() {
        return this.hpackDynamicTable.capacity();
    }

    int length() {
        return this.hpackDynamicTable.length();
    }

    long size() {
        return this.hpackDynamicTable.size();
    }

    HpackHeaderField getHeaderField(int i) {
        return this.hpackDynamicTable.getEntry(i + 1);
    }

    private void setDynamicTableSize(long j) throws Http2Exception {
        if (j > this.maxDynamicTableSize) {
            throw INVALID_MAX_DYNAMIC_TABLE_SIZE;
        }
        this.encoderMaxDynamicTableSize = j;
        this.maxDynamicTableSizeChangeRequired = false;
        this.hpackDynamicTable.setCapacity(j);
    }

    private CharSequence readName(int i) throws Http2Exception {
        if (i <= HpackStaticTable.length) {
            return HpackStaticTable.getEntry(i).name;
        }
        if (i - HpackStaticTable.length <= this.hpackDynamicTable.length()) {
            return this.hpackDynamicTable.getEntry(i - HpackStaticTable.length).name;
        }
        throw READ_NAME_ILLEGAL_INDEX_VALUE;
    }

    private long indexHeader(int i, int i2, Http2Headers http2Headers, long j) throws Http2Exception {
        if (i2 <= HpackStaticTable.length) {
            HpackHeaderField entry = HpackStaticTable.getEntry(i2);
            return addHeader(i, http2Headers, entry.name, entry.value, j);
        }
        if (i2 - HpackStaticTable.length <= this.hpackDynamicTable.length()) {
            HpackHeaderField entry2 = this.hpackDynamicTable.getEntry(i2 - HpackStaticTable.length);
            return addHeader(i, http2Headers, entry2.name, entry2.value, j);
        }
        throw INDEX_HEADER_ILLEGAL_INDEX_VALUE;
    }

    private long insertHeader(int i, Http2Headers http2Headers, CharSequence charSequence, CharSequence charSequence2, HpackUtil.IndexType indexType, long j) throws Http2Exception {
        long addHeader = addHeader(i, http2Headers, charSequence, charSequence2, j);
        int i2 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[indexType.ordinal()];
        if (i2 != 1 && i2 != 2) {
            if (i2 == 3) {
                this.hpackDynamicTable.add(new HpackHeaderField(charSequence, charSequence2));
            } else {
                throw new Error("should not reach here");
            }
        }
        return addHeader;
    }

    /* renamed from: io.netty.handler.codec.http2.HpackDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType;

        static {
            int[] iArr = new int[HpackUtil.IndexType.values().length];
            $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType = iArr;
            try {
                iArr[HpackUtil.IndexType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[HpackUtil.IndexType.NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[HpackUtil.IndexType.INCREMENTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private long addHeader(int i, Http2Headers http2Headers, CharSequence charSequence, CharSequence charSequence2, long j) throws Http2Exception {
        long length = j + charSequence.length() + charSequence2.length();
        long j2 = this.maxHeaderListSizeGoAway;
        if (length > j2) {
            Http2CodecUtil.headerListSizeExceeded(j2);
        }
        http2Headers.add((Http2Headers) charSequence, charSequence2);
        return length;
    }

    private CharSequence readStringLiteral(ByteBuf byteBuf, int i, boolean z) throws Http2Exception {
        if (z) {
            return this.hpackHuffmanDecoder.decode(byteBuf, i);
        }
        byte[] bArr = new byte[i];
        byteBuf.readBytes(bArr);
        return new AsciiString(bArr, false);
    }

    private static IllegalArgumentException notEnoughDataException(ByteBuf byteBuf) {
        return new IllegalArgumentException("decode only works with an entire header block! " + byteBuf);
    }

    static int decodeULE128(ByteBuf byteBuf, int i) throws Http2Exception {
        int readerIndex = byteBuf.readerIndex();
        long decodeULE128 = decodeULE128(byteBuf, i);
        if (decodeULE128 <= 2147483647L) {
            return (int) decodeULE128;
        }
        byteBuf.readerIndex(readerIndex);
        throw DECODE_ULE_128_TO_INT_DECOMPRESSION_EXCEPTION;
    }

    static long decodeULE128(ByteBuf byteBuf, long j) throws Http2Exception {
        int i = 0;
        boolean z = j == 0;
        int writerIndex = byteBuf.writerIndex();
        int readerIndex = byteBuf.readerIndex();
        while (readerIndex < writerIndex) {
            byte b = byteBuf.getByte(readerIndex);
            if (i == 56 && ((b & 128) != 0 || (b == Byte.MAX_VALUE && !z))) {
                throw DECODE_ULE_128_TO_LONG_DECOMPRESSION_EXCEPTION;
            }
            if ((b & 128) == 0) {
                byteBuf.readerIndex(readerIndex + 1);
                return j + ((b & 127) << i);
            }
            j += (b & 127) << i;
            readerIndex++;
            i += 7;
        }
        throw DECODE_ULE_128_DECOMPRESSION_EXCEPTION;
    }
}

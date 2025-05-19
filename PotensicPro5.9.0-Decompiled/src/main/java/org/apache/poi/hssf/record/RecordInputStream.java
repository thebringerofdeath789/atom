package org.apache.poi.hssf.record;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Objects;
import org.apache.poi.hssf.record.crypto.Biff8DecryptingStream;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianInputStream;

/* loaded from: classes5.dex */
public final class RecordInputStream implements LittleEndianInput {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DATA_LEN_NEEDS_TO_BE_READ = -1;
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final int INVALID_SID_VALUE = -1;
    public static final short MAX_RECORD_DATA_SIZE = 8224;
    private final BiffHeaderInput _bhi;
    private int _currentDataLength;
    private int _currentDataOffset;
    private int _currentSid;
    private final LittleEndianInput _dataInput;
    private int _nextSid;

    public static final class LeftoverDataException extends RuntimeException {
        public LeftoverDataException(int i, int i2) {
            super("Initialisation of record 0x" + Integer.toHexString(i).toUpperCase() + " left " + i2 + " bytes remaining still to be read.");
        }
    }

    private static final class SimpleHeaderInput implements BiffHeaderInput {
        private final LittleEndianInput _lei;

        public SimpleHeaderInput(InputStream inputStream) {
            this._lei = RecordInputStream.getLEI(inputStream);
        }

        @Override // org.apache.poi.hssf.record.BiffHeaderInput
        public int available() {
            return this._lei.available();
        }

        @Override // org.apache.poi.hssf.record.BiffHeaderInput
        public int readDataSize() {
            return this._lei.readUShort();
        }

        @Override // org.apache.poi.hssf.record.BiffHeaderInput
        public int readRecordSID() {
            return this._lei.readUShort();
        }
    }

    public RecordInputStream(InputStream inputStream) throws RecordFormatException {
        this(inputStream, null, 0);
    }

    public RecordInputStream(InputStream inputStream, Biff8EncryptionKey biff8EncryptionKey, int i) throws RecordFormatException {
        if (biff8EncryptionKey == null) {
            this._dataInput = getLEI(inputStream);
            this._bhi = new SimpleHeaderInput(inputStream);
        } else {
            Biff8DecryptingStream biff8DecryptingStream = new Biff8DecryptingStream(inputStream, i, biff8EncryptionKey);
            this._bhi = biff8DecryptingStream;
            this._dataInput = biff8DecryptingStream;
        }
        this._nextSid = readNextSid();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static LittleEndianInput getLEI(InputStream inputStream) {
        if (inputStream instanceof LittleEndianInput) {
            return (LittleEndianInput) inputStream;
        }
        return new LittleEndianInputStream(inputStream);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int available() {
        return remaining();
    }

    public int read(byte[] bArr, int i, int i2) {
        int min = Math.min(i2, remaining());
        if (min == 0) {
            return 0;
        }
        readFully(bArr, i, min);
        return min;
    }

    public short getSid() {
        return (short) this._currentSid;
    }

    public boolean hasNextRecord() throws LeftoverDataException {
        int i = this._currentDataLength;
        if (i != -1 && i != this._currentDataOffset) {
            throw new LeftoverDataException(this._currentSid, remaining());
        }
        if (i != -1) {
            this._nextSid = readNextSid();
        }
        return this._nextSid != -1;
    }

    private int readNextSid() {
        if (this._bhi.available() < 4) {
            return -1;
        }
        int readRecordSID = this._bhi.readRecordSID();
        if (readRecordSID == -1) {
            throw new RecordFormatException("Found invalid sid (" + readRecordSID + ")");
        }
        this._currentDataLength = -1;
        return readRecordSID;
    }

    public void nextRecord() throws RecordFormatException {
        int i = this._nextSid;
        if (i == -1) {
            throw new IllegalStateException("EOF - next record not available");
        }
        if (this._currentDataLength != -1) {
            throw new IllegalStateException("Cannot call nextRecord() without checking hasNextRecord() first");
        }
        this._currentSid = i;
        this._currentDataOffset = 0;
        int readDataSize = this._bhi.readDataSize();
        this._currentDataLength = readDataSize;
        if (readDataSize > 8224) {
            throw new RecordFormatException("The content of an excel record cannot exceed 8224 bytes");
        }
    }

    private void checkRecordPosition(int i) {
        int remaining = remaining();
        if (remaining >= i) {
            return;
        }
        if (remaining == 0 && isContinueNext()) {
            nextRecord();
            return;
        }
        throw new RecordFormatException("Not enough data (" + remaining + ") to read requested (" + i + ") bytes");
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        checkRecordPosition(1);
        this._currentDataOffset++;
        return this._dataInput.readByte();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        checkRecordPosition(2);
        this._currentDataOffset += 2;
        return this._dataInput.readShort();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        checkRecordPosition(4);
        this._currentDataOffset += 4;
        return this._dataInput.readInt();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        checkRecordPosition(8);
        this._currentDataOffset += 8;
        return this._dataInput.readLong();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        return readByte() & 255;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        checkRecordPosition(2);
        this._currentDataOffset += 2;
        return this._dataInput.readUShort();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        double longBitsToDouble = Double.longBitsToDouble(readLong());
        Double.isNaN(longBitsToDouble);
        return longBitsToDouble;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr) {
        readFully(bArr, 0, bArr.length);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr);
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2;
        while (i3 > 0) {
            int min = Math.min(available(), i3);
            if (min == 0) {
                if (!hasNextRecord()) {
                    throw new RecordFormatException("Can't read the remaining " + i3 + " bytes of the requested " + i2 + " bytes. No further record exists.");
                }
                nextRecord();
                min = Math.min(available(), i3);
            }
            checkRecordPosition(min);
            this._dataInput.readFully(bArr, i, min);
            this._currentDataOffset += min;
            i += min;
            i3 -= min;
        }
    }

    public String readString() {
        return readStringCommon(readUShort(), readByte() == 0);
    }

    public String readUnicodeLEString(int i) {
        return readStringCommon(i, false);
    }

    public String readCompressedUnicode(int i) {
        return readStringCommon(i, true);
    }

    private String readStringCommon(int i, boolean z) {
        int readShort;
        int readShort2;
        if (i < 0 || i > 1048576) {
            throw new IllegalArgumentException("Bad requested string length (" + i + ")");
        }
        char[] cArr = new char[i];
        int i2 = 0;
        while (true) {
            int remaining = remaining();
            if (!z) {
                remaining /= 2;
            }
            if (i - i2 <= remaining) {
                while (i2 < i) {
                    if (z) {
                        readShort = readUByte();
                    } else {
                        readShort = readShort();
                    }
                    cArr[i2] = (char) readShort;
                    i2++;
                }
                return new String(cArr);
            }
            while (remaining > 0) {
                if (z) {
                    readShort2 = readUByte();
                } else {
                    readShort2 = readShort();
                }
                cArr[i2] = (char) readShort2;
                i2++;
                remaining--;
            }
            if (!isContinueNext()) {
                throw new RecordFormatException("Expected to find a ContinueRecord in order to read remaining " + (i - i2) + " of " + i + " chars");
            }
            if (remaining() != 0) {
                throw new RecordFormatException("Odd number of bytes(" + remaining() + ") left behind");
            }
            nextRecord();
            z = readByte() == 0;
        }
    }

    public byte[] readRemainder() {
        int remaining = remaining();
        if (remaining == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[remaining];
        readFully(bArr);
        return bArr;
    }

    public byte[] readAllContinuedRemainder() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16448);
        while (true) {
            byte[] readRemainder = readRemainder();
            byteArrayOutputStream.write(readRemainder, 0, readRemainder.length);
            if (isContinueNext()) {
                nextRecord();
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public int remaining() {
        int i = this._currentDataLength;
        if (i == -1) {
            return 0;
        }
        return i - this._currentDataOffset;
    }

    private boolean isContinueNext() {
        int i = this._currentDataLength;
        if (i == -1 || this._currentDataOffset == i) {
            return hasNextRecord() && this._nextSid == 60;
        }
        throw new IllegalStateException("Should never be called before end of current record");
    }

    public int getNextSid() {
        return this._nextSid;
    }
}

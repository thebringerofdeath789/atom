package org.apache.poi.poifs.filesystem;

import java.io.IOException;
import org.apache.poi.poifs.storage.DataInputBlock;

/* loaded from: classes5.dex */
public final class ODocumentInputStream extends DocumentInputStream {
    private boolean _closed;
    private DataInputBlock _currentBlock;
    private int _current_offset;
    private POIFSDocument _document;
    private int _document_size;
    private int _marked_offset;

    public ODocumentInputStream(DocumentEntry documentEntry) throws IOException {
        if (!(documentEntry instanceof DocumentNode)) {
            throw new IOException("Cannot open internal document storage");
        }
        DocumentNode documentNode = (DocumentNode) documentEntry;
        if (documentNode.getDocument() == null) {
            throw new IOException("Cannot open internal document storage");
        }
        this._current_offset = 0;
        this._marked_offset = 0;
        this._document_size = documentEntry.getSize();
        this._closed = false;
        this._document = documentNode.getDocument();
        this._currentBlock = getDataInputBlock(0);
    }

    public ODocumentInputStream(POIFSDocument pOIFSDocument) {
        this._current_offset = 0;
        this._marked_offset = 0;
        this._document_size = pOIFSDocument.getSize();
        this._closed = false;
        this._document = pOIFSDocument;
        this._currentBlock = getDataInputBlock(0);
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, java.io.InputStream, org.apache.poi.util.LittleEndianInput
    public int available() {
        if (this._closed) {
            throw new IllegalStateException("cannot perform requested operation on a closed stream");
        }
        return this._document_size - this._current_offset;
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this._closed = true;
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, java.io.InputStream
    public void mark(int i) {
        this._marked_offset = this._current_offset;
    }

    private DataInputBlock getDataInputBlock(int i) {
        return this._document.getDataInputBlock(i);
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, java.io.InputStream
    public int read() throws IOException {
        dieIfClosed();
        if (atEOD()) {
            return -1;
        }
        int readUByte = this._currentBlock.readUByte();
        this._current_offset++;
        if (this._currentBlock.available() < 1) {
            this._currentBlock = getDataInputBlock(this._current_offset);
        }
        return readUByte;
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        dieIfClosed();
        if (bArr == null) {
            throw new IllegalArgumentException("buffer must not be null");
        }
        if (i < 0 || i2 < 0 || bArr.length < i + i2) {
            throw new IndexOutOfBoundsException("can't read past buffer boundaries");
        }
        if (i2 == 0) {
            return 0;
        }
        if (atEOD()) {
            return -1;
        }
        int min = Math.min(available(), i2);
        readFully(bArr, i, min);
        return min;
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, java.io.InputStream
    public void reset() {
        int i = this._marked_offset;
        this._current_offset = i;
        this._currentBlock = getDataInputBlock(i);
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        dieIfClosed();
        if (j < 0) {
            return 0L;
        }
        int i = this._current_offset;
        int i2 = ((int) j) + i;
        if (i2 < i) {
            i2 = this._document_size;
        } else {
            int i3 = this._document_size;
            if (i2 > i3) {
                i2 = i3;
            }
        }
        long j2 = i2 - i;
        this._current_offset = i2;
        this._currentBlock = getDataInputBlock(i2);
        return j2;
    }

    private void dieIfClosed() throws IOException {
        if (this._closed) {
            throw new IOException("cannot perform requested operation on a closed stream");
        }
    }

    private boolean atEOD() {
        return this._current_offset == this._document_size;
    }

    private void checkAvaliable(int i) {
        if (this._closed) {
            throw new IllegalStateException("cannot perform requested operation on a closed stream");
        }
        if (i > this._document_size - this._current_offset) {
            throw new RuntimeException("Buffer underrun - requested " + i + " bytes but " + (this._document_size - this._current_offset) + " was available");
        }
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        return (byte) readUByte();
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public short readShort() {
        return (short) readUShort();
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr, int i, int i2) {
        checkAvaliable(i2);
        int available = this._currentBlock.available();
        if (available > i2) {
            this._currentBlock.readFully(bArr, i, i2);
            this._current_offset += i2;
            return;
        }
        while (i2 > 0) {
            boolean z = i2 >= available;
            int i3 = z ? available : i2;
            this._currentBlock.readFully(bArr, i, i3);
            i2 -= i3;
            i += i3;
            int i4 = this._current_offset + i3;
            this._current_offset = i4;
            if (z) {
                if (i4 == this._document_size) {
                    if (i2 > 0) {
                        throw new IllegalStateException("reached end of document stream unexpectedly");
                    }
                    this._currentBlock = null;
                    return;
                } else {
                    DataInputBlock dataInputBlock = getDataInputBlock(i4);
                    this._currentBlock = dataInputBlock;
                    available = dataInputBlock.available();
                }
            }
        }
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public long readLong() {
        long readLongLE;
        long j;
        checkAvaliable(8);
        int available = this._currentBlock.available();
        if (available > 8) {
            j = this._currentBlock.readLongLE();
        } else {
            DataInputBlock dataInputBlock = getDataInputBlock(this._current_offset + available);
            if (available == 8) {
                readLongLE = this._currentBlock.readLongLE();
            } else {
                readLongLE = dataInputBlock.readLongLE(this._currentBlock, available);
            }
            this._currentBlock = dataInputBlock;
            j = readLongLE;
        }
        this._current_offset += 8;
        return j;
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public int readInt() {
        int readIntLE;
        checkAvaliable(4);
        int available = this._currentBlock.available();
        if (available > 4) {
            readIntLE = this._currentBlock.readIntLE();
        } else {
            DataInputBlock dataInputBlock = getDataInputBlock(this._current_offset + available);
            if (available == 4) {
                readIntLE = this._currentBlock.readIntLE();
            } else {
                readIntLE = dataInputBlock.readIntLE(this._currentBlock, available);
            }
            this._currentBlock = dataInputBlock;
        }
        this._current_offset += 4;
        return readIntLE;
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        int readUShortLE;
        checkAvaliable(2);
        int available = this._currentBlock.available();
        if (available > 2) {
            readUShortLE = this._currentBlock.readUShortLE();
        } else {
            DataInputBlock dataInputBlock = getDataInputBlock(this._current_offset + available);
            if (available == 2) {
                readUShortLE = this._currentBlock.readUShortLE();
            } else {
                readUShortLE = dataInputBlock.readUShortLE(this._currentBlock);
            }
            this._currentBlock = dataInputBlock;
        }
        this._current_offset += 2;
        return readUShortLE;
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentInputStream, org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        checkAvaliable(1);
        int readUByte = this._currentBlock.readUByte();
        this._current_offset++;
        if (this._currentBlock.available() < 1) {
            this._currentBlock = getDataInputBlock(this._current_offset);
        }
        return readUByte;
    }
}

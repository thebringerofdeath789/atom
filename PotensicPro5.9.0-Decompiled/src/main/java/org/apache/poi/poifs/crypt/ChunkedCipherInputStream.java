package org.apache.poi.poifs.crypt;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianInputStream;

@Internal
/* loaded from: classes5.dex */
public abstract class ChunkedCipherInputStream extends LittleEndianInputStream {
    private byte[] _chunk;
    private Cipher _cipher;
    private int _lastIndex;
    private long _pos;
    private long _size;
    private final int chunkBits;
    private final int chunkMask;
    private final int chunkSize;

    protected abstract Cipher initCipherForBlock(Cipher cipher, int i) throws GeneralSecurityException;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChunkedCipherInputStream(LittleEndianInput littleEndianInput, long j, int i) throws GeneralSecurityException {
        super((InputStream) littleEndianInput);
        this._lastIndex = 0;
        this._pos = 0L;
        this._size = j;
        this.chunkSize = i;
        int i2 = i - 1;
        this.chunkMask = i2;
        this.chunkBits = Integer.bitCount(i2);
        this._cipher = initCipherForBlock(null, 0);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr) == 1) {
            return bArr[0];
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (available() <= 0) {
            return -1;
        }
        int i3 = 0;
        while (i2 > 0) {
            if (this._chunk == null) {
                try {
                    this._chunk = nextChunk();
                } catch (GeneralSecurityException e) {
                    throw new EncryptedDocumentException(e.getMessage(), e);
                }
            }
            int i4 = (int) (this.chunkSize - (this._pos & this.chunkMask));
            int available = available();
            if (available == 0) {
                return i3;
            }
            int min = Math.min(available, Math.min(i4, i2));
            System.arraycopy(this._chunk, (int) (this._pos & this.chunkMask), bArr, i, min);
            i += min;
            i2 -= min;
            long j = this._pos + min;
            this._pos = j;
            if ((j & this.chunkMask) == 0) {
                this._chunk = null;
            }
            i3 += min;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long j2 = this._pos;
        long min = Math.min(available(), j);
        long j3 = this._pos;
        if (((j2 ^ (j3 + min)) & (~this.chunkMask)) != 0) {
            this._chunk = null;
        }
        this._pos = j3 + min;
        return min;
    }

    @Override // org.apache.poi.util.LittleEndianInputStream, java.io.FilterInputStream, java.io.InputStream, org.apache.poi.util.LittleEndianInput
    public int available() {
        return (int) (this._size - this._pos);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    private byte[] nextChunk() throws GeneralSecurityException, IOException {
        int i = (int) (this._pos >> this.chunkBits);
        initCipherForBlock(this._cipher, i);
        if (this._lastIndex != i) {
            super.skip((i - r1) << this.chunkBits);
        }
        int min = Math.min(super.available(), this.chunkSize);
        byte[] bArr = new byte[min];
        super.read(bArr, 0, min);
        this._lastIndex = i + 1;
        return this._cipher.doFinal(bArr);
    }
}

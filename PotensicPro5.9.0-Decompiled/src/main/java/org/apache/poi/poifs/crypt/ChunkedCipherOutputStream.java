package org.apache.poi.poifs.crypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentOutputStream;
import org.apache.poi.poifs.filesystem.POIFSWriterEvent;
import org.apache.poi.poifs.filesystem.POIFSWriterListener;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.TempFile;

@Internal
/* loaded from: classes5.dex */
public abstract class ChunkedCipherOutputStream extends FilterOutputStream {
    private final byte[] _chunk;
    private Cipher _cipher;
    private long _pos;
    protected final int chunkBits;
    protected final int chunkMask;
    protected final int chunkSize;
    private final DirectoryNode dir;
    private final File fileOut;

    protected abstract void calculateChecksum(File file, int i) throws GeneralSecurityException, IOException;

    protected abstract void createEncryptionInfoEntry(DirectoryNode directoryNode, File file) throws IOException, GeneralSecurityException;

    protected abstract Cipher initCipherForBlock(Cipher cipher, int i, boolean z) throws GeneralSecurityException;

    public ChunkedCipherOutputStream(DirectoryNode directoryNode, int i) throws IOException, GeneralSecurityException {
        super(null);
        this._pos = 0L;
        this.chunkSize = i;
        int i2 = i - 1;
        this.chunkMask = i2;
        this.chunkBits = Integer.bitCount(i2);
        this._chunk = new byte[i];
        File createTempFile = TempFile.createTempFile("encrypted_package", "crypt");
        this.fileOut = createTempFile;
        createTempFile.deleteOnExit();
        this.out = new FileOutputStream(createTempFile);
        this.dir = directoryNode;
        this._cipher = initCipherForBlock(null, 0, false);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return;
        }
        if (i2 < 0 || bArr.length < i + i2) {
            throw new IOException("not enough bytes in your input buffer");
        }
        while (i2 > 0) {
            int i3 = (int) (this._pos & this.chunkMask);
            int min = Math.min(this.chunkSize - i3, i2);
            System.arraycopy(bArr, i, this._chunk, i3, min);
            long j = this._pos + min;
            this._pos = j;
            i += min;
            i2 -= min;
            if ((this.chunkMask & j) == 0) {
                try {
                    writeChunk();
                } catch (GeneralSecurityException e) {
                    throw new IOException(e);
                }
            }
        }
    }

    protected void writeChunk() throws IOException, GeneralSecurityException {
        boolean z;
        long j = this._pos;
        int i = (int) (this.chunkMask & j);
        int i2 = (int) (j >> this.chunkBits);
        if (i == 0) {
            i2--;
            i = this.chunkSize;
            z = false;
        } else {
            z = true;
        }
        Cipher initCipherForBlock = initCipherForBlock(this._cipher, i2, z);
        this._cipher = initCipherForBlock;
        byte[] bArr = this._chunk;
        this.out.write(this._chunk, 0, initCipherForBlock.doFinal(bArr, 0, i, bArr));
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            writeChunk();
            super.close();
            int length = (int) (this.fileOut.length() + 8);
            calculateChecksum(this.fileOut, length);
            this.dir.createDocument(Decryptor.DEFAULT_POIFS_ENTRY, length, new EncryptedPackageWriter());
            createEncryptionInfoEntry(this.dir, this.fileOut);
        } catch (GeneralSecurityException e) {
            throw new IOException(e);
        }
    }

    private class EncryptedPackageWriter implements POIFSWriterListener {
        private EncryptedPackageWriter() {
        }

        @Override // org.apache.poi.poifs.filesystem.POIFSWriterListener
        public void processPOIFSWriterEvent(POIFSWriterEvent pOIFSWriterEvent) {
            try {
                DocumentOutputStream stream = pOIFSWriterEvent.getStream();
                byte[] bArr = new byte[ChunkedCipherOutputStream.this.chunkSize];
                LittleEndian.putLong(bArr, 0, ChunkedCipherOutputStream.this._pos);
                stream.write(bArr, 0, 8);
                FileInputStream fileInputStream = new FileInputStream(ChunkedCipherOutputStream.this.fileOut);
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        stream.write(bArr, 0, read);
                    } else {
                        fileInputStream.close();
                        stream.close();
                        ChunkedCipherOutputStream.this.fileOut.delete();
                        return;
                    }
                }
            } catch (IOException e) {
                throw new EncryptedDocumentException(e);
            }
        }
    }
}

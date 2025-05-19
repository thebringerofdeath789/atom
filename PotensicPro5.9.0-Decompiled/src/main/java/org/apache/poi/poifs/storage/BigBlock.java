package org.apache.poi.poifs.storage;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.poifs.common.POIFSBigBlockSize;

/* loaded from: classes5.dex */
abstract class BigBlock implements BlockWritable {
    protected POIFSBigBlockSize bigBlockSize;

    abstract void writeData(OutputStream outputStream) throws IOException;

    protected BigBlock(POIFSBigBlockSize pOIFSBigBlockSize) {
        this.bigBlockSize = pOIFSBigBlockSize;
    }

    protected void doWriteData(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(bArr);
    }

    @Override // org.apache.poi.poifs.storage.BlockWritable
    public void writeBlocks(OutputStream outputStream) throws IOException {
        writeData(outputStream);
    }
}

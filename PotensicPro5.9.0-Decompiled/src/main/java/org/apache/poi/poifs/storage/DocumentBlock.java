package org.apache.poi.poifs.storage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.common.POIFSConstants;
import org.apache.poi.util.IOUtils;

/* loaded from: classes5.dex */
public final class DocumentBlock extends BigBlock {
    private static final byte _default_value = -1;
    private int _bytes_read;
    private byte[] _data;

    public static byte getFillByte() {
        return (byte) -1;
    }

    @Override // org.apache.poi.poifs.storage.BigBlock, org.apache.poi.poifs.storage.BlockWritable
    public /* bridge */ /* synthetic */ void writeBlocks(OutputStream outputStream) throws IOException {
        super.writeBlocks(outputStream);
    }

    public DocumentBlock(RawDataBlock rawDataBlock) throws IOException {
        super(rawDataBlock.getBigBlockSize() == 512 ? POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS : POIFSConstants.LARGER_BIG_BLOCK_SIZE_DETAILS);
        byte[] data = rawDataBlock.getData();
        this._data = data;
        this._bytes_read = data.length;
    }

    public DocumentBlock(InputStream inputStream, POIFSBigBlockSize pOIFSBigBlockSize) throws IOException {
        this(pOIFSBigBlockSize);
        int readFully = IOUtils.readFully(inputStream, this._data);
        this._bytes_read = readFully == -1 ? 0 : readFully;
    }

    private DocumentBlock(POIFSBigBlockSize pOIFSBigBlockSize) {
        super(pOIFSBigBlockSize);
        byte[] bArr = new byte[pOIFSBigBlockSize.getBigBlockSize()];
        this._data = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    public int size() {
        return this._bytes_read;
    }

    public boolean partiallyRead() {
        return this._bytes_read != this.bigBlockSize.getBigBlockSize();
    }

    public static DocumentBlock[] convert(POIFSBigBlockSize pOIFSBigBlockSize, byte[] bArr, int i) {
        int bigBlockSize = ((i + pOIFSBigBlockSize.getBigBlockSize()) - 1) / pOIFSBigBlockSize.getBigBlockSize();
        DocumentBlock[] documentBlockArr = new DocumentBlock[bigBlockSize];
        int i2 = 0;
        for (int i3 = 0; i3 < bigBlockSize; i3++) {
            documentBlockArr[i3] = new DocumentBlock(pOIFSBigBlockSize);
            if (i2 < bArr.length) {
                int min = Math.min(pOIFSBigBlockSize.getBigBlockSize(), bArr.length - i2);
                System.arraycopy(bArr, i2, documentBlockArr[i3]._data, 0, min);
                if (min != pOIFSBigBlockSize.getBigBlockSize()) {
                    Arrays.fill(documentBlockArr[i3]._data, min, pOIFSBigBlockSize.getBigBlockSize(), (byte) -1);
                }
            } else {
                Arrays.fill(documentBlockArr[i3]._data, (byte) -1);
            }
            i2 += pOIFSBigBlockSize.getBigBlockSize();
        }
        return documentBlockArr;
    }

    public static DataInputBlock getDataInputBlock(DocumentBlock[] documentBlockArr, int i) {
        if (documentBlockArr == null || documentBlockArr.length == 0) {
            return null;
        }
        return new DataInputBlock(documentBlockArr[i >> documentBlockArr[0].bigBlockSize.getHeaderValue()]._data, i & (r0.getBigBlockSize() - 1));
    }

    @Override // org.apache.poi.poifs.storage.BigBlock
    void writeData(OutputStream outputStream) throws IOException {
        doWriteData(outputStream, this._data);
    }
}

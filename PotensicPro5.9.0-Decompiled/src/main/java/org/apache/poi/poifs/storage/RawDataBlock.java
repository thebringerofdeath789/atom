package org.apache.poi.poifs.storage;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* loaded from: classes5.dex */
public class RawDataBlock implements ListManagedBlock {
    private static POILogger log = POILogFactory.getLogger((Class<?>) RawDataBlock.class);
    private byte[] _data;
    private boolean _eof;
    private boolean _hasData;

    public RawDataBlock(InputStream inputStream) throws IOException {
        this(inputStream, 512);
    }

    public RawDataBlock(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        this._data = bArr;
        int readFully = IOUtils.readFully(inputStream, bArr);
        this._hasData = readFully > 0;
        if (readFully == -1) {
            this._eof = true;
        } else if (readFully != i) {
            this._eof = true;
            log.log(7, "Unable to read entire block; " + readFully + (" byte" + (readFully == 1 ? "" : "s")) + " read before EOF; expected " + i + " bytes. Your document was either written by software that ignores the spec, or has been truncated!");
        } else {
            this._eof = false;
        }
    }

    public boolean eof() {
        return this._eof;
    }

    public boolean hasData() {
        return this._hasData;
    }

    public String toString() {
        return "RawDataBlock of size " + this._data.length;
    }

    @Override // org.apache.poi.poifs.storage.ListManagedBlock
    public byte[] getData() throws IOException {
        if (!hasData()) {
            throw new IOException("Cannot return empty data");
        }
        return this._data;
    }

    public int getBigBlockSize() {
        return this._data.length;
    }
}

package org.apache.poi.poifs.property;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.NPOIFSStream;
import org.apache.poi.poifs.storage.HeaderBlock;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* loaded from: classes5.dex */
public final class NPropertyTable extends PropertyTableBase {
    private static final POILogger _logger = POILogFactory.getLogger((Class<?>) NPropertyTable.class);
    private POIFSBigBlockSize _bigBigBlockSize;

    public NPropertyTable(HeaderBlock headerBlock) {
        super(headerBlock);
        this._bigBigBlockSize = headerBlock.getBigBlockSize();
    }

    public NPropertyTable(HeaderBlock headerBlock, NPOIFSFileSystem nPOIFSFileSystem) throws IOException {
        super(headerBlock, buildProperties(new NPOIFSStream(nPOIFSFileSystem, headerBlock.getPropertyStart()).iterator(), headerBlock.getBigBlockSize()));
        this._bigBigBlockSize = headerBlock.getBigBlockSize();
    }

    private static List<Property> buildProperties(Iterator<ByteBuffer> it, POIFSBigBlockSize pOIFSBigBlockSize) throws IOException {
        byte[] bArr;
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            ByteBuffer next = it.next();
            if (next.hasArray() && next.arrayOffset() == 0 && next.array().length == pOIFSBigBlockSize.getBigBlockSize()) {
                bArr = next.array();
            } else {
                int bigBlockSize = pOIFSBigBlockSize.getBigBlockSize();
                byte[] bArr2 = new byte[bigBlockSize];
                if (next.remaining() < pOIFSBigBlockSize.getBigBlockSize()) {
                    _logger.log(5, "Short Property Block, ", Integer.valueOf(next.remaining()), " bytes instead of the expected " + pOIFSBigBlockSize.getBigBlockSize());
                    bigBlockSize = next.remaining();
                }
                next.get(bArr2, 0, bigBlockSize);
                bArr = bArr2;
            }
            PropertyFactory.convertToProperties(bArr, arrayList);
        }
        return arrayList;
    }

    @Override // org.apache.poi.poifs.filesystem.BATManaged
    public int countBlocks() {
        return (int) Math.ceil((this._properties.size() * 128) / this._bigBigBlockSize.getBigBlockSize());
    }

    public void preWrite() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Property property : this._properties) {
            if (property != null) {
                property.setIndex(i);
                arrayList.add(property);
                i++;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Property) it.next()).preWrite();
        }
    }

    public void write(NPOIFSStream nPOIFSStream) throws IOException {
        OutputStream outputStream = nPOIFSStream.getOutputStream();
        for (Property property : this._properties) {
            if (property != null) {
                property.writeData(outputStream);
            }
        }
        outputStream.close();
        if (getStartBlock() != nPOIFSStream.getStartBlock()) {
            setStartBlock(nPOIFSStream.getStartBlock());
        }
    }
}

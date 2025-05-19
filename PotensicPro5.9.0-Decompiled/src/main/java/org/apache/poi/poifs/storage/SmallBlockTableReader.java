package org.apache.poi.poifs.storage;

import java.io.IOException;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.property.RootProperty;

/* loaded from: classes5.dex */
public final class SmallBlockTableReader {
    public static BlockList getSmallDocumentBlocks(POIFSBigBlockSize pOIFSBigBlockSize, RawDataBlockList rawDataBlockList, RootProperty rootProperty, int i) throws IOException {
        SmallDocumentBlockList smallDocumentBlockList = new SmallDocumentBlockList(SmallDocumentBlock.extract(pOIFSBigBlockSize, rawDataBlockList.fetchBlocks(rootProperty.getStartBlock(), -1)));
        new BlockAllocationTableReader(pOIFSBigBlockSize, rawDataBlockList.fetchBlocks(i, -1), smallDocumentBlockList);
        return smallDocumentBlockList;
    }
}

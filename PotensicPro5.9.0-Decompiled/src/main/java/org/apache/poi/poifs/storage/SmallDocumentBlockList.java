package org.apache.poi.poifs.storage;

import java.io.IOException;
import java.util.List;

/* loaded from: classes5.dex */
public class SmallDocumentBlockList extends BlockListImpl {
    @Override // org.apache.poi.poifs.storage.BlockListImpl, org.apache.poi.poifs.storage.BlockList
    public /* bridge */ /* synthetic */ int blockCount() {
        return super.blockCount();
    }

    @Override // org.apache.poi.poifs.storage.BlockListImpl, org.apache.poi.poifs.storage.BlockList
    public /* bridge */ /* synthetic */ ListManagedBlock[] fetchBlocks(int i, int i2) throws IOException {
        return super.fetchBlocks(i, i2);
    }

    @Override // org.apache.poi.poifs.storage.BlockListImpl, org.apache.poi.poifs.storage.BlockList
    public /* bridge */ /* synthetic */ ListManagedBlock remove(int i) throws IOException {
        return super.remove(i);
    }

    @Override // org.apache.poi.poifs.storage.BlockListImpl, org.apache.poi.poifs.storage.BlockList
    public /* bridge */ /* synthetic */ void setBAT(BlockAllocationTableReader blockAllocationTableReader) throws IOException {
        super.setBAT(blockAllocationTableReader);
    }

    @Override // org.apache.poi.poifs.storage.BlockListImpl, org.apache.poi.poifs.storage.BlockList
    public /* bridge */ /* synthetic */ void zap(int i) {
        super.zap(i);
    }

    public SmallDocumentBlockList(List list) {
        setBlocks((SmallDocumentBlock[]) list.toArray(new SmallDocumentBlock[list.size()]));
    }
}

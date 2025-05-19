package org.apache.poi.poifs.storage;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.filesystem.BATManaged;
import org.apache.poi.util.IntList;

/* loaded from: classes5.dex */
public final class BlockAllocationTableWriter implements BlockWritable, BATManaged {
    private POIFSBigBlockSize _bigBlockSize;
    private int _start_block = -2;
    private IntList _entries = new IntList();
    private BATBlock[] _blocks = new BATBlock[0];

    public BlockAllocationTableWriter(POIFSBigBlockSize pOIFSBigBlockSize) {
        this._bigBlockSize = pOIFSBigBlockSize;
    }

    public int createBlocks() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int calculateStorageRequirements = BATBlock.calculateStorageRequirements(this._bigBlockSize, i + i2 + this._entries.size());
            int calculateXBATStorageRequirements = HeaderBlockWriter.calculateXBATStorageRequirements(this._bigBlockSize, calculateStorageRequirements);
            if (i == calculateStorageRequirements && i2 == calculateXBATStorageRequirements) {
                int allocateSpace = allocateSpace(i);
                allocateSpace(i2);
                simpleCreateBlocks();
                return allocateSpace;
            }
            i = calculateStorageRequirements;
            i2 = calculateXBATStorageRequirements;
        }
    }

    public int allocateSpace(int i) {
        int size = this._entries.size();
        if (i > 0) {
            int i2 = i - 1;
            int i3 = size + 1;
            int i4 = 0;
            while (i4 < i2) {
                this._entries.add(i3);
                i4++;
                i3++;
            }
            this._entries.add(-2);
        }
        return size;
    }

    public int getStartBlock() {
        return this._start_block;
    }

    void simpleCreateBlocks() {
        this._blocks = BATBlock.createBATBlocks(this._bigBlockSize, this._entries.toArray());
    }

    @Override // org.apache.poi.poifs.storage.BlockWritable
    public void writeBlocks(OutputStream outputStream) throws IOException {
        int i = 0;
        while (true) {
            BATBlock[] bATBlockArr = this._blocks;
            if (i >= bATBlockArr.length) {
                return;
            }
            bATBlockArr[i].writeBlocks(outputStream);
            i++;
        }
    }

    public static void writeBlock(BATBlock bATBlock, ByteBuffer byteBuffer) throws IOException {
        bATBlock.writeData(byteBuffer);
    }

    @Override // org.apache.poi.poifs.filesystem.BATManaged
    public int countBlocks() {
        return this._blocks.length;
    }

    @Override // org.apache.poi.poifs.filesystem.BATManaged
    public void setStartBlock(int i) {
        this._start_block = i;
    }
}

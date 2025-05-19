package org.apache.poi.poifs.storage;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.util.LittleEndian;

/* loaded from: classes5.dex */
public final class BATBlock extends BigBlock {
    private boolean _has_free_sectors;
    private int[] _values;
    private int ourBlockIndex;

    @Override // org.apache.poi.poifs.storage.BigBlock, org.apache.poi.poifs.storage.BlockWritable
    public /* bridge */ /* synthetic */ void writeBlocks(OutputStream outputStream) throws IOException {
        super.writeBlocks(outputStream);
    }

    private BATBlock(POIFSBigBlockSize pOIFSBigBlockSize) {
        super(pOIFSBigBlockSize);
        int[] iArr = new int[pOIFSBigBlockSize.getBATEntriesPerBlock()];
        this._values = iArr;
        this._has_free_sectors = true;
        Arrays.fill(iArr, -1);
    }

    private BATBlock(POIFSBigBlockSize pOIFSBigBlockSize, int[] iArr, int i, int i2) {
        this(pOIFSBigBlockSize);
        for (int i3 = i; i3 < i2; i3++) {
            this._values[i3 - i] = iArr[i3];
        }
        if (i2 - i == this._values.length) {
            recomputeFree();
        }
    }

    private void recomputeFree() {
        boolean z = false;
        int i = 0;
        while (true) {
            int[] iArr = this._values;
            if (i >= iArr.length) {
                break;
            }
            if (iArr[i] == -1) {
                z = true;
                break;
            }
            i++;
        }
        this._has_free_sectors = z;
    }

    public static BATBlock createBATBlock(POIFSBigBlockSize pOIFSBigBlockSize, ByteBuffer byteBuffer) {
        BATBlock bATBlock = new BATBlock(pOIFSBigBlockSize);
        byte[] bArr = new byte[4];
        for (int i = 0; i < bATBlock._values.length; i++) {
            byteBuffer.get(bArr);
            bATBlock._values[i] = LittleEndian.getInt(bArr);
        }
        bATBlock.recomputeFree();
        return bATBlock;
    }

    public static BATBlock createEmptyBATBlock(POIFSBigBlockSize pOIFSBigBlockSize, boolean z) {
        BATBlock bATBlock = new BATBlock(pOIFSBigBlockSize);
        if (z) {
            bATBlock.setXBATChain(pOIFSBigBlockSize, -2);
        }
        return bATBlock;
    }

    public static BATBlock[] createBATBlocks(POIFSBigBlockSize pOIFSBigBlockSize, int[] iArr) {
        BATBlock[] bATBlockArr = new BATBlock[calculateStorageRequirements(pOIFSBigBlockSize, iArr.length)];
        int length = iArr.length;
        int bATEntriesPerBlock = pOIFSBigBlockSize.getBATEntriesPerBlock();
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            int i3 = i2 + 1;
            bATBlockArr[i2] = new BATBlock(pOIFSBigBlockSize, iArr, i, length > bATEntriesPerBlock ? i + bATEntriesPerBlock : iArr.length);
            length -= bATEntriesPerBlock;
            i += bATEntriesPerBlock;
            i2 = i3;
        }
        return bATBlockArr;
    }

    public static BATBlock[] createXBATBlocks(POIFSBigBlockSize pOIFSBigBlockSize, int[] iArr, int i) {
        int calculateXBATStorageRequirements = calculateXBATStorageRequirements(pOIFSBigBlockSize, iArr.length);
        BATBlock[] bATBlockArr = new BATBlock[calculateXBATStorageRequirements];
        int length = iArr.length;
        int xBATEntriesPerBlock = pOIFSBigBlockSize.getXBATEntriesPerBlock();
        if (calculateXBATStorageRequirements != 0) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i3 < iArr.length) {
                int i5 = i4 + 1;
                bATBlockArr[i4] = new BATBlock(pOIFSBigBlockSize, iArr, i3, length > xBATEntriesPerBlock ? i3 + xBATEntriesPerBlock : iArr.length);
                length -= xBATEntriesPerBlock;
                i3 += xBATEntriesPerBlock;
                i4 = i5;
            }
            while (i2 < calculateXBATStorageRequirements - 1) {
                bATBlockArr[i2].setXBATChain(pOIFSBigBlockSize, i + i2 + 1);
                i2++;
            }
            bATBlockArr[i2].setXBATChain(pOIFSBigBlockSize, -2);
        }
        return bATBlockArr;
    }

    public static int calculateStorageRequirements(POIFSBigBlockSize pOIFSBigBlockSize, int i) {
        return ((i + r0) - 1) / pOIFSBigBlockSize.getBATEntriesPerBlock();
    }

    public static int calculateXBATStorageRequirements(POIFSBigBlockSize pOIFSBigBlockSize, int i) {
        return ((i + r0) - 1) / pOIFSBigBlockSize.getXBATEntriesPerBlock();
    }

    public static long calculateMaximumSize(POIFSBigBlockSize pOIFSBigBlockSize, int i) {
        return ((i * pOIFSBigBlockSize.getBATEntriesPerBlock()) + 1) * pOIFSBigBlockSize.getBigBlockSize();
    }

    public static long calculateMaximumSize(HeaderBlock headerBlock) {
        return calculateMaximumSize(headerBlock.getBigBlockSize(), headerBlock.getBATCount());
    }

    public static BATBlockAndIndex getBATBlockAndIndex(int i, HeaderBlock headerBlock, List<BATBlock> list) {
        return new BATBlockAndIndex(i % headerBlock.getBigBlockSize().getBATEntriesPerBlock(), list.get((int) Math.floor(i / r3.getBATEntriesPerBlock())));
    }

    public static BATBlockAndIndex getSBATBlockAndIndex(int i, HeaderBlock headerBlock, List<BATBlock> list) {
        return new BATBlockAndIndex(i % headerBlock.getBigBlockSize().getBATEntriesPerBlock(), list.get((int) Math.floor(i / r3.getBATEntriesPerBlock())));
    }

    private void setXBATChain(POIFSBigBlockSize pOIFSBigBlockSize, int i) {
        this._values[pOIFSBigBlockSize.getXBATEntriesPerBlock()] = i;
    }

    public boolean hasFreeSectors() {
        return this._has_free_sectors;
    }

    public int getValueAt(int i) {
        int[] iArr = this._values;
        if (i >= iArr.length) {
            throw new ArrayIndexOutOfBoundsException("Unable to fetch offset " + i + " as the BAT only contains " + this._values.length + " entries");
        }
        return iArr[i];
    }

    public void setValueAt(int i, int i2) {
        int[] iArr = this._values;
        int i3 = iArr[i];
        iArr[i] = i2;
        if (i2 == -1) {
            this._has_free_sectors = true;
        } else if (i3 == -1) {
            recomputeFree();
        }
    }

    public void setOurBlockIndex(int i) {
        this.ourBlockIndex = i;
    }

    public int getOurBlockIndex() {
        return this.ourBlockIndex;
    }

    @Override // org.apache.poi.poifs.storage.BigBlock
    void writeData(OutputStream outputStream) throws IOException {
        outputStream.write(serialize());
    }

    void writeData(ByteBuffer byteBuffer) throws IOException {
        byteBuffer.put(serialize());
    }

    private byte[] serialize() {
        byte[] bArr = new byte[this.bigBlockSize.getBigBlockSize()];
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this._values;
            if (i >= iArr.length) {
                return bArr;
            }
            LittleEndian.putInt(bArr, i2, iArr[i]);
            i2 += 4;
            i++;
        }
    }

    public static class BATBlockAndIndex {
        private final BATBlock block;
        private final int index;

        private BATBlockAndIndex(int i, BATBlock bATBlock) {
            this.index = i;
            this.block = bATBlock;
        }

        public int getIndex() {
            return this.index;
        }

        public BATBlock getBlock() {
            return this.block;
        }
    }
}

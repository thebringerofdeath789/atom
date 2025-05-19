package org.apache.poi.poifs.filesystem;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.apache.poi.poifs.storage.BATBlock;

/* loaded from: classes5.dex */
public abstract class BlockStore {
    protected abstract ByteBuffer createBlockIfNeeded(int i) throws IOException;

    protected abstract BATBlock.BATBlockAndIndex getBATBlockAndIndex(int i);

    protected abstract ByteBuffer getBlockAt(int i) throws IOException;

    protected abstract int getBlockStoreBlockSize();

    protected abstract ChainLoopDetector getChainLoopDetector() throws IOException;

    protected abstract int getFreeBlock() throws IOException;

    protected abstract int getNextBlock(int i);

    protected abstract void setNextBlock(int i, int i2);

    protected class ChainLoopDetector {
        private boolean[] used_blocks;

        protected ChainLoopDetector(long j) {
            this.used_blocks = new boolean[(int) Math.ceil(j / BlockStore.this.getBlockStoreBlockSize())];
        }

        protected void claim(int i) {
            boolean[] zArr = this.used_blocks;
            if (i >= zArr.length) {
                return;
            }
            if (zArr[i]) {
                throw new IllegalStateException("Potential loop detected - Block " + i + " was already claimed but was just requested again");
            }
            zArr[i] = true;
        }
    }
}

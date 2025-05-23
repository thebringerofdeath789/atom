package io.netty.buffer;

import io.netty.util.internal.StringUtil;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public final class PooledByteBufAllocatorMetric implements ByteBufAllocatorMetric {
    private final PooledByteBufAllocator allocator;

    PooledByteBufAllocatorMetric(PooledByteBufAllocator pooledByteBufAllocator) {
        this.allocator = pooledByteBufAllocator;
    }

    public int numHeapArenas() {
        return this.allocator.numHeapArenas();
    }

    public int numDirectArenas() {
        return this.allocator.numDirectArenas();
    }

    public List<PoolArenaMetric> heapArenas() {
        return this.allocator.heapArenas();
    }

    public List<PoolArenaMetric> directArenas() {
        return this.allocator.directArenas();
    }

    public int numThreadLocalCaches() {
        return this.allocator.numThreadLocalCaches();
    }

    public int tinyCacheSize() {
        return this.allocator.tinyCacheSize();
    }

    public int smallCacheSize() {
        return this.allocator.smallCacheSize();
    }

    public int normalCacheSize() {
        return this.allocator.normalCacheSize();
    }

    public int chunkSize() {
        return this.allocator.chunkSize();
    }

    @Override // io.netty.buffer.ByteBufAllocatorMetric
    public long usedHeapMemory() {
        return this.allocator.usedHeapMemory();
    }

    @Override // io.netty.buffer.ByteBufAllocatorMetric
    public long usedDirectMemory() {
        return this.allocator.usedDirectMemory();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(256);
        sb.append(StringUtil.simpleClassName(this)).append("(usedHeapMemory: ").append(usedHeapMemory()).append("; usedDirectMemory: ").append(usedDirectMemory()).append("; numHeapArenas: ").append(numHeapArenas()).append("; numDirectArenas: ").append(numDirectArenas()).append("; tinyCacheSize: ").append(tinyCacheSize()).append("; smallCacheSize: ").append(smallCacheSize()).append("; normalCacheSize: ").append(normalCacheSize()).append("; numThreadLocalCaches: ").append(numThreadLocalCaches()).append("; chunkSize: ").append(chunkSize()).append(PropertyUtils.MAPPED_DELIM2);
        return sb.toString();
    }
}

package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
class UnpooledUnsafeNoCleanerDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
    UnpooledUnsafeNoCleanerDirectByteBuf(ByteBufAllocator byteBufAllocator, int i, int i2) {
        super(byteBufAllocator, i, i2);
    }

    @Override // io.netty.buffer.UnpooledUnsafeDirectByteBuf
    protected ByteBuffer allocateDirect(int i) {
        return PlatformDependent.allocateDirectNoCleaner(i);
    }

    ByteBuffer reallocateDirect(ByteBuffer byteBuffer, int i) {
        return PlatformDependent.reallocateDirectNoCleaner(byteBuffer, i);
    }

    @Override // io.netty.buffer.UnpooledUnsafeDirectByteBuf
    protected void freeDirect(ByteBuffer byteBuffer) {
        PlatformDependent.freeDirectNoCleaner(byteBuffer);
    }

    @Override // io.netty.buffer.UnpooledUnsafeDirectByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i) {
        checkNewCapacity(i);
        int capacity = capacity();
        if (i == capacity) {
            return this;
        }
        ByteBuffer reallocateDirect = reallocateDirect(this.buffer, i);
        if (i < capacity) {
            if (readerIndex() < i) {
                if (writerIndex() > i) {
                    writerIndex(i);
                }
            } else {
                setIndex(i, i);
            }
        }
        setByteBuffer(reallocateDirect, false);
        return this;
    }
}

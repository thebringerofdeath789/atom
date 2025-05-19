package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
final class WrappedUnpooledUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
    WrappedUnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, long j, int i, boolean z) {
        super(byteBufAllocator, PlatformDependent.directBuffer(j, i), i, z);
    }

    @Override // io.netty.buffer.UnpooledUnsafeDirectByteBuf
    protected void freeDirect(ByteBuffer byteBuffer) {
        PlatformDependent.freeMemory(this.memoryAddress);
    }
}

package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: classes3.dex */
final class ReadOnlyUnsafeDirectByteBuf extends ReadOnlyByteBufferBuf {
    private final long memoryAddress;

    ReadOnlyUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer) {
        super(byteBufAllocator, byteBuffer);
        this.memoryAddress = PlatformDependent.directBufferAddress(byteBuffer);
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i) {
        return UnsafeByteBufUtil.getByte(addr(i));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i) {
        return UnsafeByteBufUtil.getShort(addr(i));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i) {
        return UnsafeByteBufUtil.getUnsignedMedium(addr(i));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i) {
        return UnsafeByteBufUtil.getInt(addr(i));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i) {
        return UnsafeByteBufUtil.getLong(addr(i));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkIndex(i, i3);
        Objects.requireNonNull(byteBuf, "dst");
        if (i2 < 0 || i2 > byteBuf.capacity() - i3) {
            throw new IndexOutOfBoundsException("dstIndex: " + i2);
        }
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(addr(i), i2 + byteBuf.memoryAddress(), i3);
        } else if (byteBuf.hasArray()) {
            PlatformDependent.copyMemory(addr(i), byteBuf.array(), byteBuf.arrayOffset() + i2, i3);
        } else {
            byteBuf.setBytes(i2, this, i, i3);
        }
        return this;
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        checkIndex(i, i3);
        Objects.requireNonNull(bArr, "dst");
        if (i2 < 0 || i2 > bArr.length - i3) {
            throw new IndexOutOfBoundsException(String.format("dstIndex: %d, length: %d (expected: range(0, %d))", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length)));
        }
        if (i3 != 0) {
            PlatformDependent.copyMemory(addr(i), bArr, i2, i3);
        }
        return this;
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        checkIndex(i);
        Objects.requireNonNull(byteBuffer, "dst");
        int min = Math.min(capacity() - i, byteBuffer.remaining());
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(i).limit(i + min);
        byteBuffer.put(internalNioBuffer);
        return this;
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public ByteBuf copy(int i, int i2) {
        checkIndex(i, i2);
        ByteBuf directBuffer = alloc().directBuffer(i2, maxCapacity());
        if (i2 != 0) {
            if (directBuffer.hasMemoryAddress()) {
                PlatformDependent.copyMemory(addr(i), directBuffer.memoryAddress(), i2);
                directBuffer.setIndex(0, i2);
            } else {
                directBuffer.writeBytes(this, i, i2);
            }
        }
        return directBuffer;
    }

    private long addr(int i) {
        return this.memoryAddress + i;
    }
}

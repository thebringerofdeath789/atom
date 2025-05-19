package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.Objects;

/* loaded from: classes3.dex */
public class UnpooledUnsafeDirectByteBuf extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator alloc;
    ByteBuffer buffer;
    private int capacity;
    private boolean doNotFree;
    long memoryAddress;
    private ByteBuffer tmpNioBuf;

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return 1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    public UnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, int i, int i2) {
        super(i2);
        Objects.requireNonNull(byteBufAllocator, "alloc");
        if (i < 0) {
            throw new IllegalArgumentException("initialCapacity: " + i);
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("maxCapacity: " + i2);
        }
        if (i > i2) {
            throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", Integer.valueOf(i), Integer.valueOf(i2)));
        }
        this.alloc = byteBufAllocator;
        setByteBuffer(allocateDirect(i), false);
    }

    protected UnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer, int i) {
        this(byteBufAllocator, byteBuffer.slice(), i, false);
    }

    UnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer, int i, boolean z) {
        super(i);
        Objects.requireNonNull(byteBufAllocator, "alloc");
        Objects.requireNonNull(byteBuffer, "initialBuffer");
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("initialBuffer is not a direct buffer.");
        }
        if (byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("initialBuffer is a read-only buffer.");
        }
        int remaining = byteBuffer.remaining();
        if (remaining > i) {
            throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", Integer.valueOf(remaining), Integer.valueOf(i)));
        }
        this.alloc = byteBufAllocator;
        this.doNotFree = !z;
        setByteBuffer(byteBuffer.order(ByteOrder.BIG_ENDIAN), false);
        writerIndex(remaining);
    }

    protected ByteBuffer allocateDirect(int i) {
        return ByteBuffer.allocateDirect(i);
    }

    protected void freeDirect(ByteBuffer byteBuffer) {
        PlatformDependent.freeDirectBuffer(byteBuffer);
    }

    final void setByteBuffer(ByteBuffer byteBuffer, boolean z) {
        ByteBuffer byteBuffer2;
        if (z && (byteBuffer2 = this.buffer) != null) {
            if (this.doNotFree) {
                this.doNotFree = false;
            } else {
                freeDirect(byteBuffer2);
            }
        }
        this.buffer = byteBuffer;
        this.memoryAddress = PlatformDependent.directBufferAddress(byteBuffer);
        this.tmpNioBuf = null;
        this.capacity = byteBuffer.remaining();
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.capacity;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i) {
        checkNewCapacity(i);
        int readerIndex = readerIndex();
        int writerIndex = writerIndex();
        int i2 = this.capacity;
        if (i > i2) {
            ByteBuffer byteBuffer = this.buffer;
            ByteBuffer allocateDirect = allocateDirect(i);
            byteBuffer.position(0).limit(byteBuffer.capacity());
            allocateDirect.position(0).limit(byteBuffer.capacity());
            allocateDirect.put(byteBuffer);
            allocateDirect.clear();
            setByteBuffer(allocateDirect, true);
        } else if (i < i2) {
            ByteBuffer byteBuffer2 = this.buffer;
            ByteBuffer allocateDirect2 = allocateDirect(i);
            if (readerIndex < i) {
                if (writerIndex > i) {
                    writerIndex(i);
                } else {
                    i = writerIndex;
                }
                byteBuffer2.position(readerIndex).limit(i);
                allocateDirect2.position(readerIndex).limit(i);
                allocateDirect2.put(byteBuffer2);
                allocateDirect2.clear();
            } else {
                setIndex(i, i);
            }
            setByteBuffer(allocateDirect2, true);
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        ensureAccessible();
        return this.memoryAddress;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i) {
        return UnsafeByteBufUtil.getByte(addr(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i) {
        return UnsafeByteBufUtil.getShort(addr(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i) {
        return UnsafeByteBufUtil.getShortLE(addr(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i) {
        return UnsafeByteBufUtil.getUnsignedMedium(addr(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i) {
        return UnsafeByteBufUtil.getUnsignedMediumLE(addr(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i) {
        return UnsafeByteBufUtil.getInt(addr(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i) {
        return UnsafeByteBufUtil.getIntLE(addr(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i) {
        return UnsafeByteBufUtil.getLong(addr(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i) {
        return UnsafeByteBufUtil.getLongLE(addr(i));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        UnsafeByteBufUtil.getBytes(this, addr(i), i, byteBuf, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        UnsafeByteBufUtil.getBytes(this, addr(i), i, bArr, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        UnsafeByteBufUtil.getBytes(this, addr(i), i, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkReadableBytes(remaining);
        getBytes(this.readerIndex, byteBuffer);
        this.readerIndex += remaining;
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i, int i2) {
        UnsafeByteBufUtil.setByte(addr(i), i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i, int i2) {
        UnsafeByteBufUtil.setShort(addr(i), i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i, int i2) {
        UnsafeByteBufUtil.setShortLE(addr(i), i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i, int i2) {
        UnsafeByteBufUtil.setMedium(addr(i), i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i, int i2) {
        UnsafeByteBufUtil.setMediumLE(addr(i), i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i, int i2) {
        UnsafeByteBufUtil.setInt(addr(i), i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i, int i2) {
        UnsafeByteBufUtil.setIntLE(addr(i), i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i, long j) {
        UnsafeByteBufUtil.setLong(addr(i), j);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i, long j) {
        UnsafeByteBufUtil.setLongLE(addr(i), j);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        UnsafeByteBufUtil.setBytes(this, addr(i), i, byteBuf, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        UnsafeByteBufUtil.setBytes(this, addr(i), i, bArr, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        UnsafeByteBufUtil.setBytes(this, addr(i), i, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        UnsafeByteBufUtil.getBytes(this, addr(i), i, outputStream, i2);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        return getBytes(i, gatheringByteChannel, i2, false);
    }

    private int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2, boolean z) throws IOException {
        ByteBuffer duplicate;
        ensureAccessible();
        if (i2 == 0) {
            return 0;
        }
        if (z) {
            duplicate = internalNioBuffer();
        } else {
            duplicate = this.buffer.duplicate();
        }
        duplicate.clear().position(i).limit(i + i2);
        return gatheringByteChannel.write(duplicate);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        return getBytes(i, fileChannel, j, i2, false);
    }

    private int getBytes(int i, FileChannel fileChannel, long j, int i2, boolean z) throws IOException {
        ensureAccessible();
        if (i2 == 0) {
            return 0;
        }
        ByteBuffer internalNioBuffer = z ? internalNioBuffer() : this.buffer.duplicate();
        internalNioBuffer.clear().position(i).limit(i + i2);
        return fileChannel.write(internalNioBuffer, j);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i) throws IOException {
        checkReadableBytes(i);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i, true);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel, long j, int i) throws IOException {
        checkReadableBytes(i);
        int bytes = getBytes(this.readerIndex, fileChannel, j, i, true);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, InputStream inputStream, int i2) throws IOException {
        return UnsafeByteBufUtil.setBytes(this, addr(i), i, inputStream, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) throws IOException {
        ensureAccessible();
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(i).limit(i + i2);
        try {
            return scatteringByteChannel.read(internalNioBuffer);
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        ensureAccessible();
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(i).limit(i + i2);
        try {
            return fileChannel.read(internalNioBuffer, j);
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i, int i2) {
        return new ByteBuffer[]{nioBuffer(i, i2)};
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i, int i2) {
        return UnsafeByteBufUtil.copy(this, addr(i), i, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i, int i2) {
        checkIndex(i, i2);
        return (ByteBuffer) internalNioBuffer().clear().position(i).limit(i + i2);
    }

    private ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer != null) {
            return byteBuffer;
        }
        ByteBuffer duplicate = this.buffer.duplicate();
        this.tmpNioBuf = duplicate;
        return duplicate;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i, int i2) {
        checkIndex(i, i2);
        return ((ByteBuffer) this.buffer.duplicate().position(i).limit(i + i2)).slice();
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    protected void deallocate() {
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer == null) {
            return;
        }
        this.buffer = null;
        if (this.doNotFree) {
            return;
        }
        freeDirect(byteBuffer);
    }

    long addr(int i) {
        return this.memoryAddress + i;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected SwappedByteBuf newSwappedByteBuf() {
        if (PlatformDependent.isUnaligned()) {
            return new UnsafeDirectSwappedByteBuf(this);
        }
        return super.newSwappedByteBuf();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i, int i2) {
        checkIndex(i, i2);
        UnsafeByteBufUtil.setZero(addr(i), i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i) {
        ensureWritable(i);
        int i2 = this.writerIndex;
        UnsafeByteBufUtil.setZero(addr(i2), i);
        this.writerIndex = i2 + i;
        return this;
    }
}

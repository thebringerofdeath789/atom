package io.netty.buffer;

import io.netty.util.internal.ObjectUtil;
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

/* loaded from: classes3.dex */
public class UnpooledHeapByteBuf extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator alloc;
    byte[] array;
    private ByteBuffer tmpNioBuf;

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return 0;
    }

    void freeArray(byte[] bArr) {
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return 1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    public UnpooledHeapByteBuf(ByteBufAllocator byteBufAllocator, int i, int i2) {
        super(i2);
        ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        if (i > i2) {
            throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", Integer.valueOf(i), Integer.valueOf(i2)));
        }
        this.alloc = byteBufAllocator;
        setArray(allocateArray(i));
        setIndex(0, 0);
    }

    protected UnpooledHeapByteBuf(ByteBufAllocator byteBufAllocator, byte[] bArr, int i) {
        super(i);
        ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        ObjectUtil.checkNotNull(bArr, "initialArray");
        if (bArr.length > i) {
            throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", Integer.valueOf(bArr.length), Integer.valueOf(i)));
        }
        this.alloc = byteBufAllocator;
        setArray(bArr);
        setIndex(0, bArr.length);
    }

    byte[] allocateArray(int i) {
        return new byte[i];
    }

    private void setArray(byte[] bArr) {
        this.array = bArr;
        this.tmpNioBuf = null;
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
    public int capacity() {
        ensureAccessible();
        return this.array.length;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i) {
        checkNewCapacity(i);
        byte[] bArr = this.array;
        int length = bArr.length;
        if (i > length) {
            byte[] allocateArray = allocateArray(i);
            System.arraycopy(bArr, 0, allocateArray, 0, bArr.length);
            setArray(allocateArray);
            freeArray(bArr);
        } else if (i < length) {
            byte[] allocateArray2 = allocateArray(i);
            int readerIndex = readerIndex();
            if (readerIndex < i) {
                int writerIndex = writerIndex();
                if (writerIndex > i) {
                    writerIndex(i);
                } else {
                    i = writerIndex;
                }
                System.arraycopy(bArr, readerIndex, allocateArray2, readerIndex, i - readerIndex);
            } else {
                setIndex(i, i);
            }
            setArray(allocateArray2);
            freeArray(bArr);
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        ensureAccessible();
        return this.array;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkDstIndex(i, i3, i2, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(this.array, i, byteBuf.memoryAddress() + i2, i3);
        } else if (byteBuf.hasArray()) {
            getBytes(i, byteBuf.array(), byteBuf.arrayOffset() + i2, i3);
        } else {
            byteBuf.setBytes(i2, this.array, i, i3);
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        checkDstIndex(i, i3, i2, bArr.length);
        System.arraycopy(this.array, i, bArr, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        checkIndex(i, byteBuffer.remaining());
        byteBuffer.put(this.array, i, byteBuffer.remaining());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        ensureAccessible();
        outputStream.write(this.array, i, i2);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        ensureAccessible();
        return getBytes(i, gatheringByteChannel, i2, false);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        ensureAccessible();
        return getBytes(i, fileChannel, j, i2, false);
    }

    private int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2, boolean z) throws IOException {
        ByteBuffer wrap;
        ensureAccessible();
        if (z) {
            wrap = internalNioBuffer();
        } else {
            wrap = ByteBuffer.wrap(this.array);
        }
        return gatheringByteChannel.write((ByteBuffer) wrap.clear().position(i).limit(i + i2));
    }

    private int getBytes(int i, FileChannel fileChannel, long j, int i2, boolean z) throws IOException {
        ensureAccessible();
        return fileChannel.write((ByteBuffer) (z ? internalNioBuffer() : ByteBuffer.wrap(this.array)).clear().position(i).limit(i + i2), j);
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
    public ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkSrcIndex(i, i3, i2, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(byteBuf.memoryAddress() + i2, this.array, i, i3);
        } else if (byteBuf.hasArray()) {
            setBytes(i, byteBuf.array(), byteBuf.arrayOffset() + i2, i3);
        } else {
            byteBuf.getBytes(i2, this.array, i, i3);
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        checkSrcIndex(i, i3, i2, bArr.length);
        System.arraycopy(bArr, i2, this.array, i, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        ensureAccessible();
        byteBuffer.get(this.array, i, byteBuffer.remaining());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, InputStream inputStream, int i2) throws IOException {
        ensureAccessible();
        return inputStream.read(this.array, i, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) throws IOException {
        ensureAccessible();
        try {
            return scatteringByteChannel.read((ByteBuffer) internalNioBuffer().clear().position(i).limit(i + i2));
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        ensureAccessible();
        try {
            return fileChannel.read((ByteBuffer) internalNioBuffer().clear().position(i).limit(i + i2), j);
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i, int i2) {
        ensureAccessible();
        return ByteBuffer.wrap(this.array, i, i2).slice();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i, int i2) {
        return new ByteBuffer[]{nioBuffer(i, i2)};
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i, int i2) {
        checkIndex(i, i2);
        return (ByteBuffer) internalNioBuffer().clear().position(i).limit(i + i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i) {
        ensureAccessible();
        return _getByte(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i) {
        return HeapByteBufUtil.getByte(this.array, i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i) {
        ensureAccessible();
        return _getShort(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i) {
        return HeapByteBufUtil.getShort(this.array, i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i) {
        ensureAccessible();
        return _getShortLE(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i) {
        return HeapByteBufUtil.getShortLE(this.array, i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i) {
        ensureAccessible();
        return _getUnsignedMedium(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i) {
        return HeapByteBufUtil.getUnsignedMedium(this.array, i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i) {
        ensureAccessible();
        return _getUnsignedMediumLE(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i) {
        return HeapByteBufUtil.getUnsignedMediumLE(this.array, i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i) {
        ensureAccessible();
        return _getInt(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i) {
        return HeapByteBufUtil.getInt(this.array, i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i) {
        ensureAccessible();
        return _getIntLE(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i) {
        return HeapByteBufUtil.getIntLE(this.array, i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i) {
        ensureAccessible();
        return _getLong(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i) {
        return HeapByteBufUtil.getLong(this.array, i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLongLE(int i) {
        ensureAccessible();
        return _getLongLE(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i) {
        return HeapByteBufUtil.getLongLE(this.array, i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i, int i2) {
        ensureAccessible();
        _setByte(i, i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i, int i2) {
        HeapByteBufUtil.setByte(this.array, i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i, int i2) {
        ensureAccessible();
        _setShort(i, i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i, int i2) {
        HeapByteBufUtil.setShort(this.array, i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i, int i2) {
        ensureAccessible();
        _setShortLE(i, i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i, int i2) {
        HeapByteBufUtil.setShortLE(this.array, i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i, int i2) {
        ensureAccessible();
        _setMedium(i, i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i, int i2) {
        HeapByteBufUtil.setMedium(this.array, i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i, int i2) {
        ensureAccessible();
        _setMediumLE(i, i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i, int i2) {
        HeapByteBufUtil.setMediumLE(this.array, i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i, int i2) {
        ensureAccessible();
        _setInt(i, i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i, int i2) {
        HeapByteBufUtil.setInt(this.array, i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i, int i2) {
        ensureAccessible();
        _setIntLE(i, i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i, int i2) {
        HeapByteBufUtil.setIntLE(this.array, i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i, long j) {
        ensureAccessible();
        _setLong(i, j);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i, long j) {
        HeapByteBufUtil.setLong(this.array, i, j);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i, long j) {
        ensureAccessible();
        _setLongLE(i, j);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i, long j) {
        HeapByteBufUtil.setLongLE(this.array, i, j);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i, int i2) {
        checkIndex(i, i2);
        byte[] bArr = new byte[i2];
        System.arraycopy(this.array, i, bArr, 0, i2);
        return new UnpooledHeapByteBuf(alloc(), bArr, maxCapacity());
    }

    private ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer != null) {
            return byteBuffer;
        }
        ByteBuffer wrap = ByteBuffer.wrap(this.array);
        this.tmpNioBuf = wrap;
        return wrap;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    protected void deallocate() {
        freeArray(this.array);
        this.array = null;
    }
}

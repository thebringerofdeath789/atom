package io.netty.buffer;

import io.netty.util.Recycler;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* loaded from: classes3.dex */
final class PooledDirectByteBuf extends PooledByteBuf<ByteBuffer> {
    private static final Recycler<PooledDirectByteBuf> RECYCLER = new Recycler<PooledDirectByteBuf>() { // from class: io.netty.buffer.PooledDirectByteBuf.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.Recycler
        public PooledDirectByteBuf newObject(Recycler.Handle<PooledDirectByteBuf> handle) {
            return new PooledDirectByteBuf(handle, 0);
        }
    };

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return 1;
    }

    static PooledDirectByteBuf newInstance(int i) {
        PooledDirectByteBuf pooledDirectByteBuf = RECYCLER.get();
        pooledDirectByteBuf.reuse(i);
        return pooledDirectByteBuf;
    }

    private PooledDirectByteBuf(Recycler.Handle<PooledDirectByteBuf> handle, int i) {
        super(handle, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledByteBuf
    public ByteBuffer newInternalNioBuffer(ByteBuffer byteBuffer) {
        return byteBuffer.duplicate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i) {
        return ((ByteBuffer) this.memory).get(idx(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i) {
        return ((ByteBuffer) this.memory).getShort(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i) {
        return ByteBufUtil.swapShort(_getShort(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i) {
        int idx = idx(i);
        return (((ByteBuffer) this.memory).get(idx + 2) & 255) | ((((ByteBuffer) this.memory).get(idx) & 255) << 16) | ((((ByteBuffer) this.memory).get(idx + 1) & 255) << 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i) {
        int idx = idx(i);
        return ((((ByteBuffer) this.memory).get(idx + 2) & 255) << 16) | (((ByteBuffer) this.memory).get(idx) & 255) | ((((ByteBuffer) this.memory).get(idx + 1) & 255) << 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i) {
        return ((ByteBuffer) this.memory).getInt(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i) {
        return ByteBufUtil.swapInt(_getInt(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i) {
        return ((ByteBuffer) this.memory).getLong(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i) {
        return ByteBufUtil.swapLong(_getLong(i));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkDstIndex(i, i3, i2, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            getBytes(i, byteBuf.array(), byteBuf.arrayOffset() + i2, i3);
        } else if (byteBuf.nioBufferCount() > 0) {
            ByteBuffer[] nioBuffers = byteBuf.nioBuffers(i2, i3);
            for (ByteBuffer byteBuffer : nioBuffers) {
                int remaining = byteBuffer.remaining();
                getBytes(i, byteBuffer);
                i += remaining;
            }
        } else {
            byteBuf.setBytes(i2, this, i, i3);
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        getBytes(i, bArr, i2, i3, false);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getBytes(int i, byte[] bArr, int i2, int i3, boolean z) {
        ByteBuffer duplicate;
        checkDstIndex(i, i3, i2, bArr.length);
        if (z) {
            duplicate = internalNioBuffer();
        } else {
            duplicate = ((ByteBuffer) this.memory).duplicate();
        }
        int idx = idx(i);
        duplicate.clear().position(idx).limit(idx + i3);
        duplicate.get(bArr, i2, i3);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i, int i2) {
        checkReadableBytes(i2);
        getBytes(this.readerIndex, bArr, i, i2, true);
        this.readerIndex += i2;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        getBytes(i, byteBuffer, false);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getBytes(int i, ByteBuffer byteBuffer, boolean z) {
        ByteBuffer duplicate;
        checkIndex(i, byteBuffer.remaining());
        if (z) {
            duplicate = internalNioBuffer();
        } else {
            duplicate = ((ByteBuffer) this.memory).duplicate();
        }
        int idx = idx(i);
        duplicate.clear().position(idx).limit(idx + byteBuffer.remaining());
        byteBuffer.put(duplicate);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkReadableBytes(remaining);
        getBytes(this.readerIndex, byteBuffer, true);
        this.readerIndex += remaining;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        getBytes(i, outputStream, i2, false);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getBytes(int i, OutputStream outputStream, int i2, boolean z) throws IOException {
        ByteBuffer duplicate;
        checkIndex(i, i2);
        if (i2 == 0) {
            return;
        }
        byte[] bArr = new byte[i2];
        if (z) {
            duplicate = internalNioBuffer();
        } else {
            duplicate = ((ByteBuffer) this.memory).duplicate();
        }
        duplicate.clear().position(idx(i));
        duplicate.get(bArr);
        outputStream.write(bArr);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream outputStream, int i) throws IOException {
        checkReadableBytes(i);
        getBytes(this.readerIndex, outputStream, i, true);
        this.readerIndex += i;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        return getBytes(i, gatheringByteChannel, i2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2, boolean z) throws IOException {
        ByteBuffer duplicate;
        checkIndex(i, i2);
        if (i2 == 0) {
            return 0;
        }
        if (z) {
            duplicate = internalNioBuffer();
        } else {
            duplicate = ((ByteBuffer) this.memory).duplicate();
        }
        int idx = idx(i);
        duplicate.clear().position(idx).limit(idx + i2);
        return gatheringByteChannel.write(duplicate);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        return getBytes(i, fileChannel, j, i2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int getBytes(int i, FileChannel fileChannel, long j, int i2, boolean z) throws IOException {
        checkIndex(i, i2);
        if (i2 == 0) {
            return 0;
        }
        ByteBuffer internalNioBuffer = z ? internalNioBuffer() : ((ByteBuffer) this.memory).duplicate();
        int idx = idx(i);
        internalNioBuffer.clear().position(idx).limit(idx + i2);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i, int i2) {
        ((ByteBuffer) this.memory).put(idx(i), (byte) i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i, int i2) {
        ((ByteBuffer) this.memory).putShort(idx(i), (short) i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i, int i2) {
        _setShort(i, ByteBufUtil.swapShort((short) i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i, int i2) {
        int idx = idx(i);
        ((ByteBuffer) this.memory).put(idx, (byte) (i2 >>> 16));
        ((ByteBuffer) this.memory).put(idx + 1, (byte) (i2 >>> 8));
        ((ByteBuffer) this.memory).put(idx + 2, (byte) i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i, int i2) {
        int idx = idx(i);
        ((ByteBuffer) this.memory).put(idx, (byte) i2);
        ((ByteBuffer) this.memory).put(idx + 1, (byte) (i2 >>> 8));
        ((ByteBuffer) this.memory).put(idx + 2, (byte) (i2 >>> 16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i, int i2) {
        ((ByteBuffer) this.memory).putInt(idx(i), i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i, int i2) {
        _setInt(i, ByteBufUtil.swapInt(i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i, long j) {
        ((ByteBuffer) this.memory).putLong(idx(i), j);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i, long j) {
        _setLong(i, ByteBufUtil.swapLong(j));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkSrcIndex(i, i3, i2, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            setBytes(i, byteBuf.array(), byteBuf.arrayOffset() + i2, i3);
        } else if (byteBuf.nioBufferCount() > 0) {
            ByteBuffer[] nioBuffers = byteBuf.nioBuffers(i2, i3);
            for (ByteBuffer byteBuffer : nioBuffers) {
                int remaining = byteBuffer.remaining();
                setBytes(i, byteBuffer);
                i += remaining;
            }
        } else {
            byteBuf.getBytes(i2, this, i, i3);
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        checkSrcIndex(i, i3, i2, bArr.length);
        ByteBuffer internalNioBuffer = internalNioBuffer();
        int idx = idx(i);
        internalNioBuffer.clear().position(idx).limit(idx + i3);
        internalNioBuffer.put(bArr, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        checkIndex(i, byteBuffer.remaining());
        ByteBuffer internalNioBuffer = internalNioBuffer();
        if (byteBuffer == internalNioBuffer) {
            byteBuffer = byteBuffer.duplicate();
        }
        int idx = idx(i);
        internalNioBuffer.clear().position(idx).limit(idx + byteBuffer.remaining());
        internalNioBuffer.put(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, InputStream inputStream, int i2) throws IOException {
        checkIndex(i, i2);
        byte[] bArr = new byte[i2];
        int read = inputStream.read(bArr);
        if (read <= 0) {
            return read;
        }
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(idx(i));
        internalNioBuffer.put(bArr, 0, read);
        return read;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) throws IOException {
        checkIndex(i, i2);
        ByteBuffer internalNioBuffer = internalNioBuffer();
        int idx = idx(i);
        internalNioBuffer.clear().position(idx).limit(idx + i2);
        try {
            return scatteringByteChannel.read(internalNioBuffer);
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        checkIndex(i, i2);
        ByteBuffer internalNioBuffer = internalNioBuffer();
        int idx = idx(i);
        internalNioBuffer.clear().position(idx).limit(idx + i2);
        try {
            return fileChannel.read(internalNioBuffer, j);
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i, int i2) {
        checkIndex(i, i2);
        ByteBuf directBuffer = alloc().directBuffer(i2, maxCapacity());
        directBuffer.writeBytes(this, i, i2);
        return directBuffer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i, int i2) {
        checkIndex(i, i2);
        int idx = idx(i);
        return ((ByteBuffer) ((ByteBuffer) this.memory).duplicate().position(idx).limit(idx + i2)).slice();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i, int i2) {
        return new ByteBuffer[]{nioBuffer(i, i2)};
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i, int i2) {
        checkIndex(i, i2);
        int idx = idx(i);
        return (ByteBuffer) internalNioBuffer().clear().position(idx).limit(idx + i2);
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
        throw new UnsupportedOperationException();
    }
}

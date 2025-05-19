package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

/* loaded from: classes3.dex */
class UnpooledUnsafeHeapByteBuf extends UnpooledHeapByteBuf {
    UnpooledUnsafeHeapByteBuf(ByteBufAllocator byteBufAllocator, int i, int i2) {
        super(byteBufAllocator, i, i2);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf
    byte[] allocateArray(int i) {
        return PlatformDependent.allocateUninitializedArray(i);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i) {
        checkIndex(i);
        return _getByte(i);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i) {
        return UnsafeByteBufUtil.getByte(this.array, i);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i) {
        checkIndex(i, 2);
        return _getShort(i);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i) {
        return UnsafeByteBufUtil.getShort(this.array, i);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i) {
        checkIndex(i, 2);
        return _getShortLE(i);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i) {
        return UnsafeByteBufUtil.getShortLE(this.array, i);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i) {
        checkIndex(i, 3);
        return _getUnsignedMedium(i);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i) {
        return UnsafeByteBufUtil.getUnsignedMedium(this.array, i);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i) {
        checkIndex(i, 3);
        return _getUnsignedMediumLE(i);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i) {
        return UnsafeByteBufUtil.getUnsignedMediumLE(this.array, i);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i) {
        checkIndex(i, 4);
        return _getInt(i);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i) {
        return UnsafeByteBufUtil.getInt(this.array, i);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i) {
        checkIndex(i, 4);
        return _getIntLE(i);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i) {
        return UnsafeByteBufUtil.getIntLE(this.array, i);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i) {
        checkIndex(i, 8);
        return _getLong(i);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i) {
        return UnsafeByteBufUtil.getLong(this.array, i);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLongLE(int i) {
        checkIndex(i, 8);
        return _getLongLE(i);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i) {
        return UnsafeByteBufUtil.getLongLE(this.array, i);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i, int i2) {
        checkIndex(i);
        _setByte(i, i2);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i, int i2) {
        UnsafeByteBufUtil.setByte(this.array, i, i2);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i, int i2) {
        checkIndex(i, 2);
        _setShort(i, i2);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i, int i2) {
        UnsafeByteBufUtil.setShort(this.array, i, i2);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i, int i2) {
        checkIndex(i, 2);
        _setShortLE(i, i2);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i, int i2) {
        UnsafeByteBufUtil.setShortLE(this.array, i, i2);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i, int i2) {
        checkIndex(i, 3);
        _setMedium(i, i2);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i, int i2) {
        UnsafeByteBufUtil.setMedium(this.array, i, i2);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i, int i2) {
        checkIndex(i, 3);
        _setMediumLE(i, i2);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i, int i2) {
        UnsafeByteBufUtil.setMediumLE(this.array, i, i2);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i, int i2) {
        checkIndex(i, 4);
        _setInt(i, i2);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i, int i2) {
        UnsafeByteBufUtil.setInt(this.array, i, i2);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i, int i2) {
        checkIndex(i, 4);
        _setIntLE(i, i2);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i, int i2) {
        UnsafeByteBufUtil.setIntLE(this.array, i, i2);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i, long j) {
        checkIndex(i, 8);
        _setLong(i, j);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i, long j) {
        UnsafeByteBufUtil.setLong(this.array, i, j);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i, long j) {
        checkIndex(i, 8);
        _setLongLE(i, j);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i, long j) {
        UnsafeByteBufUtil.setLongLE(this.array, i, j);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i, int i2) {
        if (PlatformDependent.javaVersion() >= 7) {
            checkIndex(i, i2);
            UnsafeByteBufUtil.setZero(this.array, i, i2);
            return this;
        }
        return super.setZero(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i) {
        if (PlatformDependent.javaVersion() >= 7) {
            ensureWritable(i);
            int i2 = this.writerIndex;
            UnsafeByteBufUtil.setZero(this.array, i2, i);
            this.writerIndex = i2 + i;
            return this;
        }
        return super.writeZero(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    @Deprecated
    protected SwappedByteBuf newSwappedByteBuf() {
        if (PlatformDependent.isUnaligned()) {
            return new UnsafeHeapSwappedByteBuf(this);
        }
        return super.newSwappedByteBuf();
    }
}

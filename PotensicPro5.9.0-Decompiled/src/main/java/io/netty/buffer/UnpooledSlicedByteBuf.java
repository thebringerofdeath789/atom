package io.netty.buffer;

/* loaded from: classes3.dex */
class UnpooledSlicedByteBuf extends AbstractUnpooledSlicedByteBuf {
    UnpooledSlicedByteBuf(AbstractByteBuf abstractByteBuf, int i, int i2) {
        super(abstractByteBuf, i, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return maxCapacity();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public AbstractByteBuf unwrap() {
        return (AbstractByteBuf) super.unwrap();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i) {
        return unwrap()._getByte(idx(i));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i) {
        return unwrap()._getShort(idx(i));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i) {
        return unwrap()._getShortLE(idx(i));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i) {
        return unwrap()._getUnsignedMedium(idx(i));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i) {
        return unwrap()._getUnsignedMediumLE(idx(i));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i) {
        return unwrap()._getInt(idx(i));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i) {
        return unwrap()._getIntLE(idx(i));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i) {
        return unwrap()._getLong(idx(i));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i) {
        return unwrap()._getLongLE(idx(i));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i, int i2) {
        unwrap()._setByte(idx(i), i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i, int i2) {
        unwrap()._setShort(idx(i), i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i, int i2) {
        unwrap()._setShortLE(idx(i), i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i, int i2) {
        unwrap()._setMedium(idx(i), i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i, int i2) {
        unwrap()._setMediumLE(idx(i), i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i, int i2) {
        unwrap()._setInt(idx(i), i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i, int i2) {
        unwrap()._setIntLE(idx(i), i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i, long j) {
        unwrap()._setLong(idx(i), j);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i, long j) {
        unwrap()._setLongLE(idx(i), j);
    }
}

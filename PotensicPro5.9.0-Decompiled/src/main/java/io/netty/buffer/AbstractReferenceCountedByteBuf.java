package io.netty.buffer;

import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes3.dex */
public abstract class AbstractReferenceCountedByteBuf extends AbstractByteBuf {
    private static final AtomicIntegerFieldUpdater<AbstractReferenceCountedByteBuf> refCntUpdater = AtomicIntegerFieldUpdater.newUpdater(AbstractReferenceCountedByteBuf.class, "refCnt");
    private volatile int refCnt;

    protected abstract void deallocate();

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch(Object obj) {
        return this;
    }

    protected AbstractReferenceCountedByteBuf(int i) {
        super(i);
        refCntUpdater.set(this, 1);
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.refCnt;
    }

    protected final void setRefCnt(int i) {
        refCntUpdater.set(this, i);
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        return retain0(1);
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain(int i) {
        return retain0(ObjectUtil.checkPositive(i, "increment"));
    }

    private ByteBuf retain0(int i) {
        AtomicIntegerFieldUpdater<AbstractReferenceCountedByteBuf> atomicIntegerFieldUpdater = refCntUpdater;
        int andAdd = atomicIntegerFieldUpdater.getAndAdd(this, i);
        if (andAdd > 0 && andAdd + i >= andAdd) {
            return this;
        }
        atomicIntegerFieldUpdater.getAndAdd(this, -i);
        throw new IllegalReferenceCountException(andAdd, i);
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return release0(1);
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i) {
        return release0(ObjectUtil.checkPositive(i, "decrement"));
    }

    private boolean release0(int i) {
        AtomicIntegerFieldUpdater<AbstractReferenceCountedByteBuf> atomicIntegerFieldUpdater = refCntUpdater;
        int andAdd = atomicIntegerFieldUpdater.getAndAdd(this, -i);
        if (andAdd == i) {
            deallocate();
            return true;
        }
        if (andAdd >= i && andAdd - i <= andAdd) {
            return false;
        }
        atomicIntegerFieldUpdater.getAndAdd(this, i);
        throw new IllegalReferenceCountException(andAdd, i);
    }
}

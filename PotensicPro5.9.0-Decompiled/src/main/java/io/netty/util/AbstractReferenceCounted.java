package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes4.dex */
public abstract class AbstractReferenceCounted implements ReferenceCounted {
    private static final AtomicIntegerFieldUpdater<AbstractReferenceCounted> refCntUpdater = AtomicIntegerFieldUpdater.newUpdater(AbstractReferenceCounted.class, "refCnt");
    private volatile int refCnt = 1;

    protected abstract void deallocate();

    @Override // io.netty.util.ReferenceCounted
    public final int refCnt() {
        return this.refCnt;
    }

    protected final void setRefCnt(int i) {
        refCntUpdater.set(this, i);
    }

    @Override // io.netty.util.ReferenceCounted
    public ReferenceCounted retain() {
        return retain0(1);
    }

    @Override // io.netty.util.ReferenceCounted
    public ReferenceCounted retain(int i) {
        return retain0(ObjectUtil.checkPositive(i, "increment"));
    }

    private ReferenceCounted retain0(int i) {
        AtomicIntegerFieldUpdater<AbstractReferenceCounted> atomicIntegerFieldUpdater = refCntUpdater;
        int andAdd = atomicIntegerFieldUpdater.getAndAdd(this, i);
        if (andAdd > 0 && andAdd + i >= andAdd) {
            return this;
        }
        atomicIntegerFieldUpdater.getAndAdd(this, -i);
        throw new IllegalReferenceCountException(andAdd, i);
    }

    @Override // io.netty.util.ReferenceCounted
    public ReferenceCounted touch() {
        return touch(null);
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
        AtomicIntegerFieldUpdater<AbstractReferenceCounted> atomicIntegerFieldUpdater = refCntUpdater;
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

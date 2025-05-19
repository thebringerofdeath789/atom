package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: MpscAtomicArrayQueue.java */
/* loaded from: classes4.dex */
abstract class MpscAtomicArrayQueueConsumerIndexField<E> extends MpscAtomicArrayQueueL2Pad<E> {
    private static final AtomicLongFieldUpdater<MpscAtomicArrayQueueConsumerIndexField> C_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(MpscAtomicArrayQueueConsumerIndexField.class, "consumerIndex");
    protected volatile long consumerIndex;

    public MpscAtomicArrayQueueConsumerIndexField(int i) {
        super(i);
    }

    protected final long lpConsumerIndex() {
        return this.consumerIndex;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }

    protected void soConsumerIndex(long j) {
        C_INDEX_UPDATER.lazySet(this, j);
    }
}

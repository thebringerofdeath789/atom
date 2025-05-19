package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: BaseMpscLinkedAtomicArrayQueue.java */
/* loaded from: classes4.dex */
abstract class BaseMpscLinkedAtomicArrayQueueProducerFields<E> extends BaseMpscLinkedAtomicArrayQueuePad1<E> {
    private static final AtomicLongFieldUpdater<BaseMpscLinkedAtomicArrayQueueProducerFields> P_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(BaseMpscLinkedAtomicArrayQueueProducerFields.class, "producerIndex");
    protected volatile long producerIndex;

    BaseMpscLinkedAtomicArrayQueueProducerFields() {
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    final void soProducerIndex(long j) {
        P_INDEX_UPDATER.lazySet(this, j);
    }

    final boolean casProducerIndex(long j, long j2) {
        return P_INDEX_UPDATER.compareAndSet(this, j, j2);
    }
}

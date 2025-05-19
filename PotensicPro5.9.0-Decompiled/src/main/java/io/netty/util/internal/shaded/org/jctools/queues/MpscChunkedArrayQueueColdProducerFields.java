package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;

/* compiled from: MpscChunkedArrayQueue.java */
/* loaded from: classes4.dex */
abstract class MpscChunkedArrayQueueColdProducerFields<E> extends BaseMpscLinkedArrayQueue<E> {
    protected final long maxQueueCapacity;

    public MpscChunkedArrayQueueColdProducerFields(int i, int i2) {
        super(i);
        RangeUtil.checkGreaterThanOrEqual(i2, 4, "maxCapacity");
        RangeUtil.checkLessThan(Pow2.roundToPowerOfTwo(i), Pow2.roundToPowerOfTwo(i2), "initialCapacity");
        this.maxQueueCapacity = Pow2.roundToPowerOfTwo(i2) << 1;
    }
}

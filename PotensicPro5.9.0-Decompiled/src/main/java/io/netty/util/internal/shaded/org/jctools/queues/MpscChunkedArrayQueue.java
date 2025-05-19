package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;

/* loaded from: classes4.dex */
public class MpscChunkedArrayQueue<E> extends MpscChunkedArrayQueueColdProducerFields<E> {
    long p0;
    long p1;
    long p10;
    long p11;
    long p12;
    long p13;
    long p14;
    long p15;
    long p16;
    long p17;
    long p2;
    long p3;
    long p4;
    long p5;
    long p6;
    long p7;

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue
    protected long getCurrentBufferCapacity(long j) {
        return j;
    }

    public MpscChunkedArrayQueue(int i) {
        super(Math.max(2, Math.min(1024, Pow2.roundToPowerOfTwo(i / 8))), i);
    }

    public MpscChunkedArrayQueue(int i, int i2) {
        super(i, i2);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue
    protected long availableInQueue(long j, long j2) {
        return this.maxQueueCapacity - (j - j2);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return (int) (this.maxQueueCapacity / 2);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue
    protected int getNextBufferSize(E[] eArr) {
        return LinkedArrayQueueUtil.length(eArr);
    }
}

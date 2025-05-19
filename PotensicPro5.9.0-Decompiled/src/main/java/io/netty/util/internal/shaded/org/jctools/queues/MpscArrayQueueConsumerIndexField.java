package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* compiled from: MpscArrayQueue.java */
/* loaded from: classes4.dex */
abstract class MpscArrayQueueConsumerIndexField<E> extends MpscArrayQueueL2Pad<E> {
    private static final long C_INDEX_OFFSET;
    protected long consumerIndex;

    static {
        try {
            C_INDEX_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset(MpscArrayQueueConsumerIndexField.class.getDeclaredField("consumerIndex"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public MpscArrayQueueConsumerIndexField(int i) {
        super(i);
    }

    protected final long lpConsumerIndex() {
        return this.consumerIndex;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, C_INDEX_OFFSET);
    }

    protected void soConsumerIndex(long j) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, j);
    }
}

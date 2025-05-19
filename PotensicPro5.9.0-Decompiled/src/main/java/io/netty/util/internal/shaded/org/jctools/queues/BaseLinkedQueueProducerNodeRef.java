package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* compiled from: BaseLinkedQueue.java */
/* loaded from: classes4.dex */
abstract class BaseLinkedQueueProducerNodeRef<E> extends BaseLinkedQueuePad0<E> {
    protected static final long P_NODE_OFFSET;
    protected LinkedQueueNode<E> producerNode;

    BaseLinkedQueueProducerNodeRef() {
    }

    static {
        try {
            P_NODE_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset(BaseLinkedQueueProducerNodeRef.class.getDeclaredField("producerNode"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    protected final void spProducerNode(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode = linkedQueueNode;
    }

    protected final LinkedQueueNode<E> lvProducerNode() {
        return (LinkedQueueNode) UnsafeAccess.UNSAFE.getObjectVolatile(this, P_NODE_OFFSET);
    }

    protected final boolean casProducerNode(LinkedQueueNode<E> linkedQueueNode, LinkedQueueNode<E> linkedQueueNode2) {
        return UnsafeAccess.UNSAFE.compareAndSwapObject(this, P_NODE_OFFSET, linkedQueueNode, linkedQueueNode2);
    }

    protected final LinkedQueueNode<E> lpProducerNode() {
        return this.producerNode;
    }
}

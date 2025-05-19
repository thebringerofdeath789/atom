package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* compiled from: BaseLinkedQueue.java */
/* loaded from: classes4.dex */
abstract class BaseLinkedQueueConsumerNodeRef<E> extends BaseLinkedQueuePad1<E> {
    protected static final long C_NODE_OFFSET;
    protected LinkedQueueNode<E> consumerNode;

    BaseLinkedQueueConsumerNodeRef() {
    }

    static {
        try {
            C_NODE_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset(BaseLinkedQueueConsumerNodeRef.class.getDeclaredField("consumerNode"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    protected final void spConsumerNode(LinkedQueueNode<E> linkedQueueNode) {
        this.consumerNode = linkedQueueNode;
    }

    protected final LinkedQueueNode<E> lvConsumerNode() {
        return (LinkedQueueNode) UnsafeAccess.UNSAFE.getObjectVolatile(this, C_NODE_OFFSET);
    }

    protected final LinkedQueueNode<E> lpConsumerNode() {
        return this.consumerNode;
    }
}

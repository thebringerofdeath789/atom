package io.netty.util.internal.shaded.org.jctools.queues;

/* loaded from: classes4.dex */
public final class IndexedQueueSizeUtil {

    public interface IndexedQueue {
        long lvConsumerIndex();

        long lvProducerIndex();
    }

    public static int size(IndexedQueue indexedQueue) {
        long lvProducerIndex;
        long lvConsumerIndex;
        long lvConsumerIndex2 = indexedQueue.lvConsumerIndex();
        while (true) {
            lvProducerIndex = indexedQueue.lvProducerIndex();
            lvConsumerIndex = indexedQueue.lvConsumerIndex();
            if (lvConsumerIndex2 == lvConsumerIndex) {
                break;
            }
            lvConsumerIndex2 = lvConsumerIndex;
        }
        long j = lvProducerIndex - lvConsumerIndex;
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    public static boolean isEmpty(IndexedQueue indexedQueue) {
        return indexedQueue.lvConsumerIndex() == indexedQueue.lvProducerIndex();
    }
}

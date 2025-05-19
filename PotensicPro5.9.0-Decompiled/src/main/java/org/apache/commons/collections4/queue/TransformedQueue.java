package org.apache.commons.collections4.queue;

import java.util.Queue;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.collection.TransformedCollection;

/* loaded from: classes4.dex */
public class TransformedQueue<E> extends TransformedCollection<E> implements Queue<E> {
    private static final long serialVersionUID = -7901091318986132033L;

    public static <E> TransformedQueue<E> transformingQueue(Queue<E> queue, Transformer<? super E, ? extends E> transformer) {
        return new TransformedQueue<>(queue, transformer);
    }

    public static <E> TransformedQueue<E> transformedQueue(Queue<E> queue, Transformer<? super E, ? extends E> transformer) {
        TransformedQueue<E> transformedQueue = new TransformedQueue<>(queue, transformer);
        if (queue.size() > 0) {
            Object[] array = queue.toArray();
            queue.clear();
            for (Object obj : array) {
                transformedQueue.decorated().add(transformer.transform(obj));
            }
        }
        return transformedQueue;
    }

    protected TransformedQueue(Queue<E> queue, Transformer<? super E, ? extends E> transformer) {
        super(queue, transformer);
    }

    protected Queue<E> getQueue() {
        return (Queue) decorated();
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        return getQueue().offer(transform((TransformedQueue<E>) e));
    }

    @Override // java.util.Queue
    public E poll() {
        return getQueue().poll();
    }

    @Override // java.util.Queue
    public E peek() {
        return getQueue().peek();
    }

    @Override // java.util.Queue
    public E element() {
        return getQueue().element();
    }

    @Override // java.util.Queue
    public E remove() {
        return getQueue().remove();
    }
}

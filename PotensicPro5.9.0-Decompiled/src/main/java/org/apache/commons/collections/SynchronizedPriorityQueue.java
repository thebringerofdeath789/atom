package org.apache.commons.collections;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class SynchronizedPriorityQueue implements PriorityQueue {
    protected final PriorityQueue m_priorityQueue;

    public SynchronizedPriorityQueue(PriorityQueue priorityQueue) {
        this.m_priorityQueue = priorityQueue;
    }

    @Override // org.apache.commons.collections.PriorityQueue, java.util.Collection
    public synchronized void clear() {
        this.m_priorityQueue.clear();
    }

    @Override // org.apache.commons.collections.PriorityQueue, java.util.Collection
    public synchronized boolean isEmpty() {
        return this.m_priorityQueue.isEmpty();
    }

    @Override // org.apache.commons.collections.PriorityQueue
    public synchronized void insert(Object obj) {
        this.m_priorityQueue.insert(obj);
    }

    @Override // org.apache.commons.collections.PriorityQueue
    public synchronized Object peek() throws NoSuchElementException {
        return this.m_priorityQueue.peek();
    }

    @Override // org.apache.commons.collections.PriorityQueue
    public synchronized Object pop() throws NoSuchElementException {
        return this.m_priorityQueue.pop();
    }

    public synchronized String toString() {
        return this.m_priorityQueue.toString();
    }
}

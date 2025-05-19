package com.ipotensic.baselib.utils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public class ReleasableLinkedBlockingDeque<E> extends AbstractQueue<E> implements BlockingDeque<E>, Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    private final int capacity;
    private transient int count;
    transient Node<E> first;
    public final AtomicBoolean isRelease;
    transient Node<E> last;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    static final class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E e) {
            this.item = e;
        }
    }

    public ReleasableLinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    public ReleasableLinkedBlockingDeque(int i) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        this.notFull = reentrantLock.newCondition();
        this.isRelease = new AtomicBoolean(false);
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = i;
    }

    public ReleasableLinkedBlockingDeque(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (E e : collection) {
                if (e == null) {
                    throw new NullPointerException();
                }
                if (!linkLast(new Node<>(e))) {
                    throw new IllegalStateException("Deque full");
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private boolean linkFirst(Node<E> node) {
        if (this.count >= this.capacity) {
            return false;
        }
        Node<E> node2 = this.first;
        node.next = node2;
        this.first = node;
        if (this.last == null) {
            this.last = node;
        } else {
            node2.prev = node;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private boolean linkLast(Node<E> node) {
        if (this.count >= this.capacity) {
            return false;
        }
        Node<E> node2 = this.last;
        node.prev = node2;
        this.last = node;
        if (this.first == null) {
            this.first = node;
        } else {
            node2.next = node;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private E unlinkFirst() {
        Node<E> node = this.first;
        if (node == null) {
            return null;
        }
        Node<E> node2 = node.next;
        E e = node.item;
        node.item = null;
        node.next = node;
        this.first = node2;
        if (node2 == null) {
            this.last = null;
        } else {
            node2.prev = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    private E unlinkLast() {
        Node<E> node = this.last;
        if (node == null) {
            return null;
        }
        Node<E> node2 = node.prev;
        E e = node.item;
        node.item = null;
        node.prev = node;
        this.last = node2;
        if (node2 == null) {
            this.first = null;
        } else {
            node2.next = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unlink(Node<E> node) {
        Node<E> node2 = node.prev;
        Node<E> node3 = node.next;
        if (node2 == null) {
            unlinkFirst();
            return;
        }
        if (node3 == null) {
            unlinkLast();
            return;
        }
        node2.next = node3;
        node3.prev = node2;
        node.item = null;
        this.count--;
        this.notFull.signal();
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.Deque
    public void addFirst(E e) {
        if (!offerFirst(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.Deque
    public void addLast(E e) {
        if (!offerLast(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.Deque
    public boolean offerFirst(E e) {
        Objects.requireNonNull(e);
        Node<E> node = new Node<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return linkFirst(node);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.Deque
    public boolean offerLast(E e) {
        Objects.requireNonNull(e);
        Node<E> node = new Node<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return linkLast(node);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putFirst(E e) throws InterruptedException {
        Objects.requireNonNull(e);
        Node<E> node = new Node<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!linkFirst(node)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putLast(E e) throws InterruptedException {
        Objects.requireNonNull(e);
        Node<E> node = new Node<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!linkLast(node)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerFirst(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        boolean z;
        Objects.requireNonNull(e);
        Node<E> node = new Node<>(e);
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                if (linkFirst(node)) {
                    z = true;
                    break;
                }
                if (nanos <= 0) {
                    z = false;
                    break;
                }
                nanos = this.notFull.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        return z;
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerLast(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        boolean z;
        Objects.requireNonNull(e);
        Node<E> node = new Node<>(e);
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                if (linkLast(node)) {
                    z = true;
                    break;
                }
                if (nanos <= 0) {
                    z = false;
                    break;
                }
                nanos = this.notFull.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        return z;
    }

    @Override // java.util.Deque
    public E removeFirst() {
        E pollFirst = pollFirst();
        if (pollFirst != null) {
            return pollFirst;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Deque
    public E removeLast() {
        E pollLast = pollLast();
        if (pollLast != null) {
            return pollLast;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Deque
    public E pollFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkFirst();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Deque
    public E pollLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkLast();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeFirst() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        System.out.println("lock");
        E e = null;
        while (!this.isRelease.get() && (e = unlinkFirst()) == null) {
            try {
                System.out.println("wait");
                this.notEmpty.await();
                System.out.println("wait1");
            } finally {
                reentrantLock.unlock();
            }
        }
        return e;
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeLast() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    return unlinkLast;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.concurrent.BlockingDeque
    public E pollFirst(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    return unlinkFirst;
                }
                if (nanos > 0) {
                    nanos = this.notEmpty.awaitNanos(nanos);
                } else {
                    return null;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.concurrent.BlockingDeque
    public E pollLast(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    return unlinkLast;
                }
                if (nanos > 0) {
                    nanos = this.notEmpty.awaitNanos(nanos);
                } else {
                    return null;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.Deque
    public E getFirst() {
        E peekFirst = peekFirst();
        if (peekFirst != null) {
            return peekFirst;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Deque
    public E getLast() {
        E peekLast = peekLast();
        if (peekLast != null) {
            return peekLast;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Deque
    public E peekFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Node<E> node = this.first;
            return node == null ? null : node.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Deque
    public E peekLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Node<E> node = this.last;
            return node == null ? null : node.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.Deque
    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Node<E> node = this.first; node != null; node = node.next) {
                if (obj.equals(node.item)) {
                    unlink(node);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.Deque
    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Node<E> node = this.last; node != null; node = node.prev) {
                if (obj.equals(node.item)) {
                    unlink(node);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
    public boolean offer(E e) {
        return offerLast(e);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public void put(E e) throws InterruptedException {
        if (this.isRelease.get()) {
            return;
        }
        putLast(e);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        return offerLast(e, j, timeUnit);
    }

    @Override // java.util.AbstractQueue, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.Deque
    public E remove() {
        return removeFirst();
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingDeque, java.util.Deque
    public E poll() {
        return pollFirst();
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return takeFirst();
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        return pollFirst(j, timeUnit);
    }

    @Override // java.util.AbstractQueue, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.Deque
    public E element() {
        return getFirst();
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingDeque, java.util.Deque
    public E peek() {
        return peekFirst();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.capacity - this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        Objects.requireNonNull(collection);
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        if (i <= 0) {
            return 0;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int min = Math.min(i, this.count);
            for (int i2 = 0; i2 < min; i2++) {
                collection.add(this.first.item);
                unlinkFirst();
            }
            return min;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.Deque
    public void push(E e) {
        addFirst(e);
    }

    @Override // java.util.Deque
    public E pop() {
        return removeFirst();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingDeque, java.util.Deque
    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Node<E> node = this.first; node != null; node = node.next) {
                if (obj.equals(node.item)) {
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.count];
            int i = 0;
            Node<E> node = this.first;
            while (node != null) {
                int i2 = i + 1;
                objArr[i] = node.item;
                node = node.next;
                i = i2;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (tArr.length < this.count) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.count));
            }
            int i = 0;
            Node<E> node = this.first;
            while (node != null) {
                tArr[i] = node.item;
                node = node.next;
                i++;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return Helpers.collectionToString(this);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Node<E> node = this.first;
            while (node != null) {
                node.item = null;
                Node<E> node2 = node.next;
                node.prev = null;
                node.next = null;
                node = node2;
            }
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.concurrent.BlockingDeque, java.util.Deque
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return new DescendingItr();
    }

    private abstract class AbstractItr implements Iterator<E> {
        private Node<E> lastRet;
        Node<E> next;
        E nextItem;

        abstract Node<E> firstNode();

        abstract Node<E> nextNode(Node<E> node);

        AbstractItr() {
            ReentrantLock reentrantLock = ReleasableLinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                Node<E> firstNode = firstNode();
                this.next = firstNode;
                this.nextItem = firstNode == null ? null : firstNode.item;
            } finally {
                reentrantLock.unlock();
            }
        }

        private Node<E> succ(Node<E> node) {
            while (true) {
                Node<E> nextNode = nextNode(node);
                if (nextNode == null) {
                    return null;
                }
                if (nextNode.item != null) {
                    return nextNode;
                }
                if (nextNode == node) {
                    return firstNode();
                }
                node = nextNode;
            }
        }

        void advance() {
            ReentrantLock reentrantLock = ReleasableLinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                Node<E> succ = succ(this.next);
                this.next = succ;
                this.nextItem = succ == null ? null : succ.item;
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public E next() {
            Node<E> node = this.next;
            if (node == null) {
                throw new NoSuchElementException();
            }
            this.lastRet = node;
            E e = this.nextItem;
            advance();
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            Node<E> node = this.lastRet;
            if (node == null) {
                throw new IllegalStateException();
            }
            this.lastRet = null;
            ReentrantLock reentrantLock = ReleasableLinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                if (node.item != null) {
                    ReleasableLinkedBlockingDeque.this.unlink(node);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private class Itr extends ReleasableLinkedBlockingDeque<E>.AbstractItr {
        private Itr() {
            super();
        }

        @Override // com.ipotensic.baselib.utils.ReleasableLinkedBlockingDeque.AbstractItr
        Node<E> firstNode() {
            return ReleasableLinkedBlockingDeque.this.first;
        }

        @Override // com.ipotensic.baselib.utils.ReleasableLinkedBlockingDeque.AbstractItr
        Node<E> nextNode(Node<E> node) {
            return node.next;
        }
    }

    private class DescendingItr extends ReleasableLinkedBlockingDeque<E>.AbstractItr {
        private DescendingItr() {
            super();
        }

        @Override // com.ipotensic.baselib.utils.ReleasableLinkedBlockingDeque.AbstractItr
        Node<E> firstNode() {
            return ReleasableLinkedBlockingDeque.this.last;
        }

        @Override // com.ipotensic.baselib.utils.ReleasableLinkedBlockingDeque.AbstractItr
        Node<E> nextNode(Node<E> node) {
            return node.prev;
        }
    }

    static final class LBDSpliterator<E> implements Spliterator<E> {
        static final int MAX_BATCH = 33554432;
        int batch;
        Node<E> current;
        long est;
        boolean exhausted;
        final ReleasableLinkedBlockingDeque<E> queue;

        @Override // java.util.Spliterator
        public int characteristics() {
            return 4368;
        }

        LBDSpliterator(ReleasableLinkedBlockingDeque<E> releasableLinkedBlockingDeque) {
            this.queue = releasableLinkedBlockingDeque;
            this.est = releasableLinkedBlockingDeque.size();
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0050  */
        @Override // java.util.Spliterator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.util.Spliterator<E> trySplit() {
            /*
                r9 = this;
                com.ipotensic.baselib.utils.ReleasableLinkedBlockingDeque<E> r0 = r9.queue
                int r1 = r9.batch
                r2 = 33554432(0x2000000, float:9.403955E-38)
                r3 = 1
                if (r1 > 0) goto Lb
                r2 = r3
                goto L10
            Lb:
                if (r1 < r2) goto Le
                goto L10
            Le:
                int r2 = r1 + 1
            L10:
                boolean r1 = r9.exhausted
                if (r1 != 0) goto L6c
                com.ipotensic.baselib.utils.ReleasableLinkedBlockingDeque$Node<E> r1 = r9.current
                if (r1 != 0) goto L1c
                com.ipotensic.baselib.utils.ReleasableLinkedBlockingDeque$Node<E> r1 = r0.first
                if (r1 == 0) goto L6c
            L1c:
                com.ipotensic.baselib.utils.ReleasableLinkedBlockingDeque$Node<E> r1 = r1.next
                if (r1 == 0) goto L6c
                java.lang.Object[] r1 = new java.lang.Object[r2]
                java.util.concurrent.locks.ReentrantLock r4 = r0.lock
                com.ipotensic.baselib.utils.ReleasableLinkedBlockingDeque$Node<E> r5 = r9.current
                r4.lock()
                r6 = 0
                if (r5 != 0) goto L33
                com.ipotensic.baselib.utils.ReleasableLinkedBlockingDeque$Node<E> r5 = r0.first     // Catch: java.lang.Throwable -> L67
                if (r5 == 0) goto L31
                goto L33
            L31:
                r0 = r6
                goto L42
            L33:
                r0 = r6
            L34:
                E r7 = r5.item     // Catch: java.lang.Throwable -> L67
                r1[r0] = r7     // Catch: java.lang.Throwable -> L67
                if (r7 == 0) goto L3c
                int r0 = r0 + 1
            L3c:
                com.ipotensic.baselib.utils.ReleasableLinkedBlockingDeque$Node<E> r5 = r5.next     // Catch: java.lang.Throwable -> L67
                if (r5 == 0) goto L42
                if (r0 < r2) goto L34
            L42:
                r4.unlock()
                r9.current = r5
                r7 = 0
                if (r5 != 0) goto L50
                r9.est = r7
                r9.exhausted = r3
                goto L5c
            L50:
                long r2 = r9.est
                long r4 = (long) r0
                long r2 = r2 - r4
                r9.est = r2
                int r2 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
                if (r2 >= 0) goto L5c
                r9.est = r7
            L5c:
                if (r0 <= 0) goto L6c
                r9.batch = r0
                r2 = 4368(0x1110, float:6.121E-42)
                java.util.Spliterator r0 = java.util.Spliterators.spliterator(r1, r6, r0, r2)
                return r0
            L67:
                r0 = move-exception
                r4.unlock()
                throw r0
            L6c:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.baselib.utils.ReleasableLinkedBlockingDeque.LBDSpliterator.trySplit():java.util.Spliterator");
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            ReleasableLinkedBlockingDeque<E> releasableLinkedBlockingDeque = this.queue;
            ReentrantLock reentrantLock = releasableLinkedBlockingDeque.lock;
            if (this.exhausted) {
                return;
            }
            this.exhausted = true;
            Node<E> node = this.current;
            do {
                E e = (E) null;
                reentrantLock.lock();
                if (node == null) {
                    try {
                        node = releasableLinkedBlockingDeque.first;
                    } catch (Throwable th) {
                        reentrantLock.unlock();
                        throw th;
                    }
                }
                while (node != null) {
                    e = node.item;
                    node = node.next;
                    if (e != null) {
                        break;
                    }
                }
                reentrantLock.unlock();
                if (e != null) {
                    consumer.accept(e);
                }
            } while (node != null);
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            ReleasableLinkedBlockingDeque<E> releasableLinkedBlockingDeque = this.queue;
            ReentrantLock reentrantLock = releasableLinkedBlockingDeque.lock;
            if (this.exhausted) {
                return false;
            }
            E e = (E) null;
            reentrantLock.lock();
            try {
                if (this.current == null) {
                    this.current = releasableLinkedBlockingDeque.first;
                }
                do {
                    Node<E> node = this.current;
                    if (node == null) {
                        break;
                    }
                    e = node.item;
                    this.current = this.current.next;
                } while (e == null);
                reentrantLock.unlock();
                if (this.current == null) {
                    this.exhausted = true;
                }
                if (e == null) {
                    return false;
                }
                consumer.accept(e);
                return true;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return new LBDSpliterator(this);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (Node<E> node = this.first; node != null; node = node.next) {
                objectOutputStream.writeObject(node.item);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.count = 0;
        this.first = null;
        this.last = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                return;
            } else {
                add(readObject);
            }
        }
    }

    public void release() {
        this.isRelease.set(true);
        clear();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        this.notEmpty.signal();
        this.notFull.signal();
        reentrantLock.unlock();
    }
}

package org.apache.commons.collections.buffer;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.BoundedCollection;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferOverflowException;
import org.apache.commons.collections.BufferUnderflowException;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;

/* loaded from: classes4.dex */
public class BoundedBuffer extends SynchronizedBuffer implements BoundedCollection {
    private static final long serialVersionUID = 1536432911093974264L;
    private final int maximumSize;
    private final long timeout;

    public static BoundedBuffer decorate(Buffer buffer, int i) {
        return new BoundedBuffer(buffer, i, 0L);
    }

    public static BoundedBuffer decorate(Buffer buffer, int i, long j) {
        return new BoundedBuffer(buffer, i, j);
    }

    protected BoundedBuffer(Buffer buffer, int i, long j) {
        super(buffer);
        if (i < 1) {
            throw new IllegalArgumentException();
        }
        this.maximumSize = i;
        this.timeout = j;
    }

    @Override // org.apache.commons.collections.buffer.SynchronizedBuffer, org.apache.commons.collections.Buffer
    public Object remove() {
        Object remove;
        synchronized (this.lock) {
            remove = getBuffer().remove();
            this.lock.notifyAll();
        }
        return remove;
    }

    @Override // org.apache.commons.collections.collection.SynchronizedCollection, java.util.Collection
    public boolean add(Object obj) {
        boolean add;
        synchronized (this.lock) {
            timeoutWait(1);
            add = getBuffer().add(obj);
        }
        return add;
    }

    @Override // org.apache.commons.collections.collection.SynchronizedCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        boolean addAll;
        synchronized (this.lock) {
            timeoutWait(collection.size());
            addAll = getBuffer().addAll(collection);
        }
        return addAll;
    }

    @Override // org.apache.commons.collections.collection.SynchronizedCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new NotifyingIterator(this, this.collection.iterator());
    }

    private void timeoutWait(int i) {
        if (i > this.maximumSize) {
            throw new BufferOverflowException(new StringBuffer().append("Buffer size cannot exceed ").append(this.maximumSize).toString());
        }
        if (this.timeout <= 0) {
            if (getBuffer().size() + i > this.maximumSize) {
                throw new BufferOverflowException(new StringBuffer().append("Buffer size cannot exceed ").append(this.maximumSize).toString());
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() + this.timeout;
        long currentTimeMillis2 = System.currentTimeMillis();
        while (true) {
            long j = currentTimeMillis - currentTimeMillis2;
            if (j <= 0 || getBuffer().size() + i <= this.maximumSize) {
                break;
            }
            try {
                this.lock.wait(j);
                currentTimeMillis2 = System.currentTimeMillis();
            } catch (InterruptedException e) {
                PrintWriter printWriter = new PrintWriter(new StringWriter());
                e.printStackTrace(printWriter);
                throw new BufferUnderflowException(new StringBuffer().append("Caused by InterruptedException: ").append(printWriter.toString()).toString());
            }
        }
        if (getBuffer().size() + i > this.maximumSize) {
            throw new BufferOverflowException("Timeout expired");
        }
    }

    @Override // org.apache.commons.collections.BoundedCollection
    public boolean isFull() {
        return size() == maxSize();
    }

    @Override // org.apache.commons.collections.BoundedCollection
    public int maxSize() {
        return this.maximumSize;
    }

    private class NotifyingIterator extends AbstractIteratorDecorator {
        private final /* synthetic */ BoundedBuffer this$0;

        public NotifyingIterator(BoundedBuffer boundedBuffer, Iterator it) {
            super(it);
            this.this$0 = boundedBuffer;
        }

        @Override // org.apache.commons.collections.iterators.AbstractIteratorDecorator, java.util.Iterator
        public void remove() {
            synchronized (this.this$0.lock) {
                this.iterator.remove();
                this.this$0.lock.notifyAll();
            }
        }
    }
}

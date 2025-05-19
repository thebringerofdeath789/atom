package org.apache.commons.collections.buffer;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferUnderflowException;

/* loaded from: classes4.dex */
public class BlockingBuffer extends SynchronizedBuffer {
    private static final long serialVersionUID = 1719328905017860541L;
    private final long timeout;

    public static Buffer decorate(Buffer buffer) {
        return new BlockingBuffer(buffer);
    }

    public static Buffer decorate(Buffer buffer, long j) {
        return new BlockingBuffer(buffer, j);
    }

    protected BlockingBuffer(Buffer buffer) {
        super(buffer);
        this.timeout = 0L;
    }

    protected BlockingBuffer(Buffer buffer, long j) {
        super(buffer);
        this.timeout = j < 0 ? 0L : j;
    }

    @Override // org.apache.commons.collections.collection.SynchronizedCollection, java.util.Collection
    public boolean add(Object obj) {
        boolean add;
        synchronized (this.lock) {
            add = this.collection.add(obj);
            this.lock.notifyAll();
        }
        return add;
    }

    @Override // org.apache.commons.collections.collection.SynchronizedCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        boolean addAll;
        synchronized (this.lock) {
            addAll = this.collection.addAll(collection);
            this.lock.notifyAll();
        }
        return addAll;
    }

    @Override // org.apache.commons.collections.buffer.SynchronizedBuffer, org.apache.commons.collections.Buffer
    public Object get() {
        synchronized (this.lock) {
            while (this.collection.isEmpty()) {
                try {
                    long j = this.timeout;
                    if (j <= 0) {
                        this.lock.wait();
                    } else {
                        return get(j);
                    }
                } catch (InterruptedException e) {
                    PrintWriter printWriter = new PrintWriter(new StringWriter());
                    e.printStackTrace(printWriter);
                    throw new BufferUnderflowException(new StringBuffer().append("Caused by InterruptedException: ").append(printWriter.toString()).toString());
                }
            }
            return getBuffer().get();
        }
    }

    public Object get(long j) {
        Object obj;
        synchronized (this.lock) {
            long currentTimeMillis = System.currentTimeMillis() + j;
            long currentTimeMillis2 = System.currentTimeMillis();
            while (true) {
                long j2 = currentTimeMillis - currentTimeMillis2;
                if (j2 <= 0 || !this.collection.isEmpty()) {
                    break;
                }
                try {
                    this.lock.wait(j2);
                    currentTimeMillis2 = System.currentTimeMillis();
                } catch (InterruptedException e) {
                    PrintWriter printWriter = new PrintWriter(new StringWriter());
                    e.printStackTrace(printWriter);
                    throw new BufferUnderflowException(new StringBuffer().append("Caused by InterruptedException: ").append(printWriter.toString()).toString());
                }
            }
            if (this.collection.isEmpty()) {
                throw new BufferUnderflowException("Timeout expired");
            }
            obj = getBuffer().get();
        }
        return obj;
    }

    @Override // org.apache.commons.collections.buffer.SynchronizedBuffer, org.apache.commons.collections.Buffer
    public Object remove() {
        synchronized (this.lock) {
            while (this.collection.isEmpty()) {
                try {
                    long j = this.timeout;
                    if (j <= 0) {
                        this.lock.wait();
                    } else {
                        return remove(j);
                    }
                } catch (InterruptedException e) {
                    PrintWriter printWriter = new PrintWriter(new StringWriter());
                    e.printStackTrace(printWriter);
                    throw new BufferUnderflowException(new StringBuffer().append("Caused by InterruptedException: ").append(printWriter.toString()).toString());
                }
            }
            return getBuffer().remove();
        }
    }

    public Object remove(long j) {
        Object remove;
        synchronized (this.lock) {
            long currentTimeMillis = System.currentTimeMillis() + j;
            long currentTimeMillis2 = System.currentTimeMillis();
            while (true) {
                long j2 = currentTimeMillis - currentTimeMillis2;
                if (j2 <= 0 || !this.collection.isEmpty()) {
                    break;
                }
                try {
                    this.lock.wait(j2);
                    currentTimeMillis2 = System.currentTimeMillis();
                } catch (InterruptedException e) {
                    PrintWriter printWriter = new PrintWriter(new StringWriter());
                    e.printStackTrace(printWriter);
                    throw new BufferUnderflowException(new StringBuffer().append("Caused by InterruptedException: ").append(printWriter.toString()).toString());
                }
            }
            if (this.collection.isEmpty()) {
                throw new BufferUnderflowException("Timeout expired");
            }
            remove = getBuffer().remove();
        }
        return remove;
    }
}

package org.apache.commons.collections.buffer;

import java.util.Collection;

/* loaded from: classes4.dex */
public class CircularFifoBuffer extends BoundedFifoBuffer {
    private static final long serialVersionUID = -8423413834657610406L;

    public CircularFifoBuffer() {
        super(32);
    }

    public CircularFifoBuffer(int i) {
        super(i);
    }

    public CircularFifoBuffer(Collection collection) {
        super(collection);
    }

    @Override // org.apache.commons.collections.buffer.BoundedFifoBuffer, java.util.AbstractCollection, java.util.Collection
    public boolean add(Object obj) {
        if (isFull()) {
            remove();
        }
        return super.add(obj);
    }
}

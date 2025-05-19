package org.apache.commons.collections.buffer;

import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;

/* loaded from: classes4.dex */
public abstract class AbstractBufferDecorator extends AbstractCollectionDecorator implements Buffer {
    protected AbstractBufferDecorator() {
    }

    protected AbstractBufferDecorator(Buffer buffer) {
        super(buffer);
    }

    protected Buffer getBuffer() {
        return (Buffer) getCollection();
    }

    @Override // org.apache.commons.collections.Buffer
    public Object get() {
        return getBuffer().get();
    }

    @Override // org.apache.commons.collections.Buffer
    public Object remove() {
        return getBuffer().remove();
    }
}

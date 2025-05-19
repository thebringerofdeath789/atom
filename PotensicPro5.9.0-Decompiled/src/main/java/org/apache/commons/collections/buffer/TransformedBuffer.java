package org.apache.commons.collections.buffer;

import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.collection.TransformedCollection;

/* loaded from: classes4.dex */
public class TransformedBuffer extends TransformedCollection implements Buffer {
    private static final long serialVersionUID = -7901091318986132033L;

    public static Buffer decorate(Buffer buffer, Transformer transformer) {
        return new TransformedBuffer(buffer, transformer);
    }

    protected TransformedBuffer(Buffer buffer, Transformer transformer) {
        super(buffer, transformer);
    }

    protected Buffer getBuffer() {
        return (Buffer) this.collection;
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

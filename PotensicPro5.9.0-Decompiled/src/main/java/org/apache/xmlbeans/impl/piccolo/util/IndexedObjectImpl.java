package org.apache.xmlbeans.impl.piccolo.util;

/* loaded from: classes5.dex */
public final class IndexedObjectImpl implements IndexedObject {
    private int index;
    private Object object;

    public IndexedObjectImpl(int i, Object obj) {
        this.index = i;
        this.object = obj;
    }

    @Override // org.apache.xmlbeans.impl.piccolo.util.IndexedObject
    public final int getIndex() {
        return this.index;
    }

    @Override // org.apache.xmlbeans.impl.piccolo.util.IndexedObject
    public final void setIndex(int i) {
        this.index = i;
    }

    @Override // org.apache.xmlbeans.impl.piccolo.util.IndexedObject
    public final Object getObject() {
        return this.object;
    }

    @Override // org.apache.xmlbeans.impl.piccolo.util.IndexedObject
    public final void setObject(Object obj) {
        this.object = obj;
    }

    public final Object clone() {
        return new IndexedObjectImpl(this.index, this.object);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof IndexedObject)) {
            return false;
        }
        IndexedObject indexedObject = (IndexedObject) obj;
        return this.index == indexedObject.getIndex() && this.object.equals(indexedObject.getObject());
    }
}

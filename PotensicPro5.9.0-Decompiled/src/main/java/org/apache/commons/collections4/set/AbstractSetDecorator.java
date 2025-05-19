package org.apache.commons.collections4.set;

import java.util.Set;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

/* loaded from: classes4.dex */
public abstract class AbstractSetDecorator<E> extends AbstractCollectionDecorator<E> implements Set<E> {
    private static final long serialVersionUID = -4678668309576958546L;

    protected AbstractSetDecorator() {
    }

    protected AbstractSetDecorator(Set<E> set) {
        super(set);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public Set<E> decorated() {
        return (Set) super.decorated();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return obj == this || decorated().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return decorated().hashCode();
    }
}

package gnu.trove.impl.sync;

import java.util.Set;

/* loaded from: classes3.dex */
class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
    private static final long serialVersionUID = 487447009682186044L;

    SynchronizedSet(Set<E> set, Object obj) {
        super(set, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.c.equals(obj);
        }
        return equals;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.c.hashCode();
        }
        return hashCode;
    }
}

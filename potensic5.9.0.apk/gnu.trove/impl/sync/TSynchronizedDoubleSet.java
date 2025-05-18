package gnu.trove.impl.sync;

import gnu.trove.set.TDoubleSet;

/* loaded from: classes3.dex */
public class TSynchronizedDoubleSet extends TSynchronizedDoubleCollection implements TDoubleSet {
    private static final long serialVersionUID = 487447009682186044L;

    public TSynchronizedDoubleSet(TDoubleSet tDoubleSet) {
        super(tDoubleSet);
    }

    public TSynchronizedDoubleSet(TDoubleSet tDoubleSet, Object obj) {
        super(tDoubleSet, obj);
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3600c.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.TDoubleCollection
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3600c.hashCode();
        }
        return hashCode;
    }
}
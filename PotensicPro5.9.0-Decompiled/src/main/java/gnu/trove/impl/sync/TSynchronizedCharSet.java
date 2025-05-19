package gnu.trove.impl.sync;

import gnu.trove.set.TCharSet;

/* loaded from: classes3.dex */
public class TSynchronizedCharSet extends TSynchronizedCharCollection implements TCharSet {
    private static final long serialVersionUID = 487447009682186044L;

    public TSynchronizedCharSet(TCharSet tCharSet) {
        super(tCharSet);
    }

    public TSynchronizedCharSet(TCharSet tCharSet, Object obj) {
        super(tCharSet, obj);
    }

    @Override // gnu.trove.TCharCollection
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.c.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.TCharCollection
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.c.hashCode();
        }
        return hashCode;
    }
}

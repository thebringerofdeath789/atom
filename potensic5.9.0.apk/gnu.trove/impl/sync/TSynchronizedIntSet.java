package gnu.trove.impl.sync;

import gnu.trove.set.TIntSet;

/* loaded from: classes3.dex */
public class TSynchronizedIntSet extends TSynchronizedIntCollection implements TIntSet {
    private static final long serialVersionUID = 487447009682186044L;

    public TSynchronizedIntSet(TIntSet tIntSet) {
        super(tIntSet);
    }

    public TSynchronizedIntSet(TIntSet tIntSet, Object obj) {
        super(tIntSet, obj);
    }

    @Override // gnu.trove.TIntCollection
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3618c.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.TIntCollection
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3618c.hashCode();
        }
        return hashCode;
    }
}
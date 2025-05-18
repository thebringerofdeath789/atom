package gnu.trove.impl.sync;

import gnu.trove.set.TLongSet;

/* loaded from: classes3.dex */
public class TSynchronizedLongSet extends TSynchronizedLongCollection implements TLongSet {
    private static final long serialVersionUID = 487447009682186044L;

    public TSynchronizedLongSet(TLongSet tLongSet) {
        super(tLongSet);
    }

    public TSynchronizedLongSet(TLongSet tLongSet, Object obj) {
        super(tLongSet, obj);
    }

    @Override // gnu.trove.TLongCollection
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3627c.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.TLongCollection
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3627c.hashCode();
        }
        return hashCode;
    }
}
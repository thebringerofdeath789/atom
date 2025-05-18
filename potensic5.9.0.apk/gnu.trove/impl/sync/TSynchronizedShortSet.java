package gnu.trove.impl.sync;

import gnu.trove.set.TShortSet;

/* loaded from: classes3.dex */
public class TSynchronizedShortSet extends TSynchronizedShortCollection implements TShortSet {
    private static final long serialVersionUID = 487447009682186044L;

    public TSynchronizedShortSet(TShortSet tShortSet) {
        super(tShortSet);
    }

    public TSynchronizedShortSet(TShortSet tShortSet, Object obj) {
        super(tShortSet, obj);
    }

    @Override // gnu.trove.TShortCollection
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3643c.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.TShortCollection
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3643c.hashCode();
        }
        return hashCode;
    }
}
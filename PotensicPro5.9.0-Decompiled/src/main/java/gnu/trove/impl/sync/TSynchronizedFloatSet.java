package gnu.trove.impl.sync;

import gnu.trove.set.TFloatSet;

/* loaded from: classes3.dex */
public class TSynchronizedFloatSet extends TSynchronizedFloatCollection implements TFloatSet {
    private static final long serialVersionUID = 487447009682186044L;

    public TSynchronizedFloatSet(TFloatSet tFloatSet) {
        super(tFloatSet);
    }

    public TSynchronizedFloatSet(TFloatSet tFloatSet, Object obj) {
        super(tFloatSet, obj);
    }

    @Override // gnu.trove.TFloatCollection
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.c.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.TFloatCollection
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.c.hashCode();
        }
        return hashCode;
    }
}

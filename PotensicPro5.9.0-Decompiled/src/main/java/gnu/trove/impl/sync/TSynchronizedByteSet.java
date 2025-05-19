package gnu.trove.impl.sync;

import gnu.trove.set.TByteSet;

/* loaded from: classes3.dex */
public class TSynchronizedByteSet extends TSynchronizedByteCollection implements TByteSet {
    private static final long serialVersionUID = 487447009682186044L;

    public TSynchronizedByteSet(TByteSet tByteSet) {
        super(tByteSet);
    }

    public TSynchronizedByteSet(TByteSet tByteSet, Object obj) {
        super(tByteSet, obj);
    }

    @Override // gnu.trove.TByteCollection
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.c.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.TByteCollection
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.c.hashCode();
        }
        return hashCode;
    }
}

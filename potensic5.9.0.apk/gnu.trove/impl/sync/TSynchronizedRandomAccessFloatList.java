package gnu.trove.impl.sync;

import gnu.trove.list.TFloatList;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TSynchronizedRandomAccessFloatList extends TSynchronizedFloatList implements RandomAccess {
    static final long serialVersionUID = 1530674583602358482L;

    public TSynchronizedRandomAccessFloatList(TFloatList tFloatList) {
        super(tFloatList);
    }

    public TSynchronizedRandomAccessFloatList(TFloatList tFloatList, Object obj) {
        super(tFloatList, obj);
    }

    @Override // gnu.trove.impl.sync.TSynchronizedFloatList, gnu.trove.list.TFloatList
    public TFloatList subList(int i, int i2) {
        TSynchronizedRandomAccessFloatList tSynchronizedRandomAccessFloatList;
        synchronized (this.mutex) {
            tSynchronizedRandomAccessFloatList = new TSynchronizedRandomAccessFloatList(this.list.subList(i, i2), this.mutex);
        }
        return tSynchronizedRandomAccessFloatList;
    }

    private Object writeReplace() {
        return new TSynchronizedFloatList(this.list);
    }
}
package gnu.trove.impl.sync;

import gnu.trove.list.TIntList;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TSynchronizedRandomAccessIntList extends TSynchronizedIntList implements RandomAccess {
    static final long serialVersionUID = 1530674583602358482L;

    public TSynchronizedRandomAccessIntList(TIntList tIntList) {
        super(tIntList);
    }

    public TSynchronizedRandomAccessIntList(TIntList tIntList, Object obj) {
        super(tIntList, obj);
    }

    @Override // gnu.trove.impl.sync.TSynchronizedIntList, gnu.trove.list.TIntList
    public TIntList subList(int i, int i2) {
        TSynchronizedRandomAccessIntList tSynchronizedRandomAccessIntList;
        synchronized (this.mutex) {
            tSynchronizedRandomAccessIntList = new TSynchronizedRandomAccessIntList(this.list.subList(i, i2), this.mutex);
        }
        return tSynchronizedRandomAccessIntList;
    }

    private Object writeReplace() {
        return new TSynchronizedIntList(this.list);
    }
}

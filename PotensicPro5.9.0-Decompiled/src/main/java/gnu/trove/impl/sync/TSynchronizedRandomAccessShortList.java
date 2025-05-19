package gnu.trove.impl.sync;

import gnu.trove.list.TShortList;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TSynchronizedRandomAccessShortList extends TSynchronizedShortList implements RandomAccess {
    static final long serialVersionUID = 1530674583602358482L;

    public TSynchronizedRandomAccessShortList(TShortList tShortList) {
        super(tShortList);
    }

    public TSynchronizedRandomAccessShortList(TShortList tShortList, Object obj) {
        super(tShortList, obj);
    }

    @Override // gnu.trove.impl.sync.TSynchronizedShortList, gnu.trove.list.TShortList
    public TShortList subList(int i, int i2) {
        TSynchronizedRandomAccessShortList tSynchronizedRandomAccessShortList;
        synchronized (this.mutex) {
            tSynchronizedRandomAccessShortList = new TSynchronizedRandomAccessShortList(this.list.subList(i, i2), this.mutex);
        }
        return tSynchronizedRandomAccessShortList;
    }

    private Object writeReplace() {
        return new TSynchronizedShortList(this.list);
    }
}

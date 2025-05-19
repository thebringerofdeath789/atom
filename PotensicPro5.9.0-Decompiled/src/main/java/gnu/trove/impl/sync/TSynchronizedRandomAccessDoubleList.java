package gnu.trove.impl.sync;

import gnu.trove.list.TDoubleList;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TSynchronizedRandomAccessDoubleList extends TSynchronizedDoubleList implements RandomAccess {
    static final long serialVersionUID = 1530674583602358482L;

    public TSynchronizedRandomAccessDoubleList(TDoubleList tDoubleList) {
        super(tDoubleList);
    }

    public TSynchronizedRandomAccessDoubleList(TDoubleList tDoubleList, Object obj) {
        super(tDoubleList, obj);
    }

    @Override // gnu.trove.impl.sync.TSynchronizedDoubleList, gnu.trove.list.TDoubleList
    public TDoubleList subList(int i, int i2) {
        TSynchronizedRandomAccessDoubleList tSynchronizedRandomAccessDoubleList;
        synchronized (this.mutex) {
            tSynchronizedRandomAccessDoubleList = new TSynchronizedRandomAccessDoubleList(this.list.subList(i, i2), this.mutex);
        }
        return tSynchronizedRandomAccessDoubleList;
    }

    private Object writeReplace() {
        return new TSynchronizedDoubleList(this.list);
    }
}

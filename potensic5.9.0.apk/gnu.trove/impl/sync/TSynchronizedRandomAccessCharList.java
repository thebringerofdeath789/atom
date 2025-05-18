package gnu.trove.impl.sync;

import gnu.trove.list.TCharList;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TSynchronizedRandomAccessCharList extends TSynchronizedCharList implements RandomAccess {
    static final long serialVersionUID = 1530674583602358482L;

    public TSynchronizedRandomAccessCharList(TCharList tCharList) {
        super(tCharList);
    }

    public TSynchronizedRandomAccessCharList(TCharList tCharList, Object obj) {
        super(tCharList, obj);
    }

    @Override // gnu.trove.impl.sync.TSynchronizedCharList, gnu.trove.list.TCharList
    public TCharList subList(int i, int i2) {
        TSynchronizedRandomAccessCharList tSynchronizedRandomAccessCharList;
        synchronized (this.mutex) {
            tSynchronizedRandomAccessCharList = new TSynchronizedRandomAccessCharList(this.list.subList(i, i2), this.mutex);
        }
        return tSynchronizedRandomAccessCharList;
    }

    private Object writeReplace() {
        return new TSynchronizedCharList(this.list);
    }
}
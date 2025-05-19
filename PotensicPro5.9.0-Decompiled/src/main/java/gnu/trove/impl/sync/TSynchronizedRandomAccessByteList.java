package gnu.trove.impl.sync;

import gnu.trove.list.TByteList;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TSynchronizedRandomAccessByteList extends TSynchronizedByteList implements RandomAccess {
    static final long serialVersionUID = 1530674583602358482L;

    public TSynchronizedRandomAccessByteList(TByteList tByteList) {
        super(tByteList);
    }

    public TSynchronizedRandomAccessByteList(TByteList tByteList, Object obj) {
        super(tByteList, obj);
    }

    @Override // gnu.trove.impl.sync.TSynchronizedByteList, gnu.trove.list.TByteList
    public TByteList subList(int i, int i2) {
        TSynchronizedRandomAccessByteList tSynchronizedRandomAccessByteList;
        synchronized (this.mutex) {
            tSynchronizedRandomAccessByteList = new TSynchronizedRandomAccessByteList(this.list.subList(i, i2), this.mutex);
        }
        return tSynchronizedRandomAccessByteList;
    }

    private Object writeReplace() {
        return new TSynchronizedByteList(this.list);
    }
}

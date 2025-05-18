package gnu.trove.impl.sync;

import gnu.trove.list.TLongList;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TSynchronizedRandomAccessLongList extends TSynchronizedLongList implements RandomAccess {
    static final long serialVersionUID = 1530674583602358482L;

    public TSynchronizedRandomAccessLongList(TLongList tLongList) {
        super(tLongList);
    }

    public TSynchronizedRandomAccessLongList(TLongList tLongList, Object obj) {
        super(tLongList, obj);
    }

    @Override // gnu.trove.impl.sync.TSynchronizedLongList, gnu.trove.list.TLongList
    public TLongList subList(int i, int i2) {
        TSynchronizedRandomAccessLongList tSynchronizedRandomAccessLongList;
        synchronized (this.mutex) {
            tSynchronizedRandomAccessLongList = new TSynchronizedRandomAccessLongList(this.list.subList(i, i2), this.mutex);
        }
        return tSynchronizedRandomAccessLongList;
    }

    private Object writeReplace() {
        return new TSynchronizedLongList(this.list);
    }
}
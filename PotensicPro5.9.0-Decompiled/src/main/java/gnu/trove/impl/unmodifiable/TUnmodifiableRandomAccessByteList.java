package gnu.trove.impl.unmodifiable;

import gnu.trove.list.TByteList;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TUnmodifiableRandomAccessByteList extends TUnmodifiableByteList implements RandomAccess {
    private static final long serialVersionUID = -2542308836966382001L;

    public TUnmodifiableRandomAccessByteList(TByteList tByteList) {
        super(tByteList);
    }

    @Override // gnu.trove.impl.unmodifiable.TUnmodifiableByteList, gnu.trove.list.TByteList
    public TByteList subList(int i, int i2) {
        return new TUnmodifiableRandomAccessByteList(this.list.subList(i, i2));
    }

    private Object writeReplace() {
        return new TUnmodifiableByteList(this.list);
    }
}

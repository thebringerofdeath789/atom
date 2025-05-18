package gnu.trove.impl.unmodifiable;

import gnu.trove.list.TLongList;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TUnmodifiableRandomAccessLongList extends TUnmodifiableLongList implements RandomAccess {
    private static final long serialVersionUID = -2542308836966382001L;

    public TUnmodifiableRandomAccessLongList(TLongList tLongList) {
        super(tLongList);
    }

    @Override // gnu.trove.impl.unmodifiable.TUnmodifiableLongList, gnu.trove.list.TLongList
    public TLongList subList(int i, int i2) {
        return new TUnmodifiableRandomAccessLongList(this.list.subList(i, i2));
    }

    private Object writeReplace() {
        return new TUnmodifiableLongList(this.list);
    }
}
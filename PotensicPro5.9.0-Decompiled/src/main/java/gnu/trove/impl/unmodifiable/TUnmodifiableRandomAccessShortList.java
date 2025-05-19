package gnu.trove.impl.unmodifiable;

import gnu.trove.list.TShortList;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TUnmodifiableRandomAccessShortList extends TUnmodifiableShortList implements RandomAccess {
    private static final long serialVersionUID = -2542308836966382001L;

    public TUnmodifiableRandomAccessShortList(TShortList tShortList) {
        super(tShortList);
    }

    @Override // gnu.trove.impl.unmodifiable.TUnmodifiableShortList, gnu.trove.list.TShortList
    public TShortList subList(int i, int i2) {
        return new TUnmodifiableRandomAccessShortList(this.list.subList(i, i2));
    }

    private Object writeReplace() {
        return new TUnmodifiableShortList(this.list);
    }
}

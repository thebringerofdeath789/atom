package gnu.trove.impl.unmodifiable;

import gnu.trove.list.TFloatList;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TUnmodifiableRandomAccessFloatList extends TUnmodifiableFloatList implements RandomAccess {
    private static final long serialVersionUID = -2542308836966382001L;

    public TUnmodifiableRandomAccessFloatList(TFloatList tFloatList) {
        super(tFloatList);
    }

    @Override // gnu.trove.impl.unmodifiable.TUnmodifiableFloatList, gnu.trove.list.TFloatList
    public TFloatList subList(int i, int i2) {
        return new TUnmodifiableRandomAccessFloatList(this.list.subList(i, i2));
    }

    private Object writeReplace() {
        return new TUnmodifiableFloatList(this.list);
    }
}

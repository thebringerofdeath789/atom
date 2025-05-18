package gnu.trove.impl.unmodifiable;

import gnu.trove.list.TIntList;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TUnmodifiableRandomAccessIntList extends TUnmodifiableIntList implements RandomAccess {
    private static final long serialVersionUID = -2542308836966382001L;

    public TUnmodifiableRandomAccessIntList(TIntList tIntList) {
        super(tIntList);
    }

    @Override // gnu.trove.impl.unmodifiable.TUnmodifiableIntList, gnu.trove.list.TIntList
    public TIntList subList(int i, int i2) {
        return new TUnmodifiableRandomAccessIntList(this.list.subList(i, i2));
    }

    private Object writeReplace() {
        return new TUnmodifiableIntList(this.list);
    }
}
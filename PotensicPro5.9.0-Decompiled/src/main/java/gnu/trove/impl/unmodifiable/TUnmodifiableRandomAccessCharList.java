package gnu.trove.impl.unmodifiable;

import gnu.trove.list.TCharList;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TUnmodifiableRandomAccessCharList extends TUnmodifiableCharList implements RandomAccess {
    private static final long serialVersionUID = -2542308836966382001L;

    public TUnmodifiableRandomAccessCharList(TCharList tCharList) {
        super(tCharList);
    }

    @Override // gnu.trove.impl.unmodifiable.TUnmodifiableCharList, gnu.trove.list.TCharList
    public TCharList subList(int i, int i2) {
        return new TUnmodifiableRandomAccessCharList(this.list.subList(i, i2));
    }

    private Object writeReplace() {
        return new TUnmodifiableCharList(this.list);
    }
}

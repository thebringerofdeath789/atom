package gnu.trove.impl.unmodifiable;

import gnu.trove.list.TDoubleList;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TUnmodifiableRandomAccessDoubleList extends TUnmodifiableDoubleList implements RandomAccess {
    private static final long serialVersionUID = -2542308836966382001L;

    public TUnmodifiableRandomAccessDoubleList(TDoubleList tDoubleList) {
        super(tDoubleList);
    }

    @Override // gnu.trove.impl.unmodifiable.TUnmodifiableDoubleList, gnu.trove.list.TDoubleList
    public TDoubleList subList(int i, int i2) {
        return new TUnmodifiableRandomAccessDoubleList(this.list.subList(i, i2));
    }

    private Object writeReplace() {
        return new TUnmodifiableDoubleList(this.list);
    }
}
package gnu.trove.iterator.hash;

import gnu.trove.impl.hash.THashIterator;
import gnu.trove.impl.hash.TObjectHash;

/* loaded from: classes3.dex */
public class TObjectHashIterator<E> extends THashIterator<E> {
    protected final TObjectHash _objectHash;

    public TObjectHashIterator(TObjectHash<E> tObjectHash) {
        super(tObjectHash);
        this._objectHash = tObjectHash;
    }

    @Override // gnu.trove.impl.hash.THashIterator
    protected E objectAtIndex(int i) {
        E e = (E) this._objectHash._set[i];
        if (e == TObjectHash.FREE || e == TObjectHash.REMOVED) {
            return null;
        }
        return e;
    }
}

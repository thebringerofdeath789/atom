package gnu.trove.strategy;

/* loaded from: classes3.dex */
public class IdentityHashingStrategy<K> implements HashingStrategy<K> {
    public static final IdentityHashingStrategy<Object> INSTANCE = new IdentityHashingStrategy<>();
    static final long serialVersionUID = -5188534454583764904L;

    @Override // gnu.trove.strategy.HashingStrategy
    public boolean equals(K k, K k2) {
        return k == k2;
    }

    @Override // gnu.trove.strategy.HashingStrategy
    public int computeHashCode(K k) {
        return System.identityHashCode(k);
    }
}
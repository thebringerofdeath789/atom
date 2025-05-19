package gnu.trove.iterator;

/* loaded from: classes3.dex */
public interface TObjectCharIterator<K> extends TAdvancingIterator {
    K key();

    char setValue(char c);

    char value();
}

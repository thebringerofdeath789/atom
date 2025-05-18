package gnu.trove.iterator;

/* loaded from: classes3.dex */
public interface TIntObjectIterator<V> extends TAdvancingIterator {
    int key();

    V setValue(V v);

    V value();
}
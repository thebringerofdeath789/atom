package gnu.trove.iterator;

/* loaded from: classes3.dex */
public interface TLongObjectIterator<V> extends TAdvancingIterator {
    long key();

    V setValue(V v);

    V value();
}

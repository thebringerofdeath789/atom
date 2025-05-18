package gnu.trove.iterator;

/* loaded from: classes3.dex */
public interface TFloatObjectIterator<V> extends TAdvancingIterator {
    float key();

    V setValue(V v);

    V value();
}
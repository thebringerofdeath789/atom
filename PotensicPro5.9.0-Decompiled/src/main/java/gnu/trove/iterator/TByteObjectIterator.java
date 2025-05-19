package gnu.trove.iterator;

/* loaded from: classes3.dex */
public interface TByteObjectIterator<V> extends TAdvancingIterator {
    byte key();

    V setValue(V v);

    V value();
}

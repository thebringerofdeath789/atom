package gnu.trove.iterator;

/* loaded from: classes3.dex */
public interface TObjectIntIterator<K> extends TAdvancingIterator {
    K key();

    int setValue(int i);

    int value();
}
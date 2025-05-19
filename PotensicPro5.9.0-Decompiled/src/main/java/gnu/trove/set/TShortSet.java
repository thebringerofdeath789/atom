package gnu.trove.set;

import gnu.trove.TShortCollection;
import gnu.trove.iterator.TShortIterator;
import gnu.trove.procedure.TShortProcedure;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface TShortSet extends TShortCollection {
    @Override // gnu.trove.TShortCollection
    boolean add(short s);

    @Override // gnu.trove.TShortCollection
    boolean addAll(TShortCollection tShortCollection);

    @Override // gnu.trove.TShortCollection
    boolean addAll(Collection<? extends Short> collection);

    @Override // gnu.trove.TShortCollection
    boolean addAll(short[] sArr);

    @Override // gnu.trove.TShortCollection
    void clear();

    @Override // gnu.trove.TShortCollection
    boolean contains(short s);

    @Override // gnu.trove.TShortCollection
    boolean containsAll(TShortCollection tShortCollection);

    @Override // gnu.trove.TShortCollection
    boolean containsAll(Collection<?> collection);

    @Override // gnu.trove.TShortCollection
    boolean containsAll(short[] sArr);

    @Override // gnu.trove.TShortCollection
    boolean equals(Object obj);

    @Override // gnu.trove.TShortCollection
    boolean forEach(TShortProcedure tShortProcedure);

    @Override // gnu.trove.TShortCollection
    short getNoEntryValue();

    @Override // gnu.trove.TShortCollection
    int hashCode();

    @Override // gnu.trove.TShortCollection
    boolean isEmpty();

    @Override // gnu.trove.TShortCollection
    TShortIterator iterator();

    @Override // gnu.trove.TShortCollection
    boolean remove(short s);

    @Override // gnu.trove.TShortCollection
    boolean removeAll(TShortCollection tShortCollection);

    @Override // gnu.trove.TShortCollection
    boolean removeAll(Collection<?> collection);

    @Override // gnu.trove.TShortCollection
    boolean removeAll(short[] sArr);

    @Override // gnu.trove.TShortCollection
    boolean retainAll(TShortCollection tShortCollection);

    @Override // gnu.trove.TShortCollection
    boolean retainAll(Collection<?> collection);

    @Override // gnu.trove.TShortCollection
    boolean retainAll(short[] sArr);

    @Override // gnu.trove.TShortCollection
    int size();

    @Override // gnu.trove.TShortCollection
    short[] toArray();

    @Override // gnu.trove.TShortCollection
    short[] toArray(short[] sArr);
}

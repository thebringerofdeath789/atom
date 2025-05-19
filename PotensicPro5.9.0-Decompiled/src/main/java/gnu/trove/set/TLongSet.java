package gnu.trove.set;

import gnu.trove.TLongCollection;
import gnu.trove.iterator.TLongIterator;
import gnu.trove.procedure.TLongProcedure;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface TLongSet extends TLongCollection {
    @Override // gnu.trove.TLongCollection
    boolean add(long j);

    @Override // gnu.trove.TLongCollection
    boolean addAll(TLongCollection tLongCollection);

    @Override // gnu.trove.TLongCollection
    boolean addAll(Collection<? extends Long> collection);

    @Override // gnu.trove.TLongCollection
    boolean addAll(long[] jArr);

    @Override // gnu.trove.TLongCollection
    void clear();

    @Override // gnu.trove.TLongCollection
    boolean contains(long j);

    @Override // gnu.trove.TLongCollection
    boolean containsAll(TLongCollection tLongCollection);

    @Override // gnu.trove.TLongCollection
    boolean containsAll(Collection<?> collection);

    @Override // gnu.trove.TLongCollection
    boolean containsAll(long[] jArr);

    @Override // gnu.trove.TLongCollection
    boolean equals(Object obj);

    @Override // gnu.trove.TLongCollection
    boolean forEach(TLongProcedure tLongProcedure);

    @Override // gnu.trove.TLongCollection
    long getNoEntryValue();

    @Override // gnu.trove.TLongCollection
    int hashCode();

    @Override // gnu.trove.TLongCollection
    boolean isEmpty();

    @Override // gnu.trove.TLongCollection
    TLongIterator iterator();

    @Override // gnu.trove.TLongCollection
    boolean remove(long j);

    @Override // gnu.trove.TLongCollection
    boolean removeAll(TLongCollection tLongCollection);

    @Override // gnu.trove.TLongCollection
    boolean removeAll(Collection<?> collection);

    @Override // gnu.trove.TLongCollection
    boolean removeAll(long[] jArr);

    @Override // gnu.trove.TLongCollection
    boolean retainAll(TLongCollection tLongCollection);

    @Override // gnu.trove.TLongCollection
    boolean retainAll(Collection<?> collection);

    @Override // gnu.trove.TLongCollection
    boolean retainAll(long[] jArr);

    @Override // gnu.trove.TLongCollection
    int size();

    @Override // gnu.trove.TLongCollection
    long[] toArray();

    @Override // gnu.trove.TLongCollection
    long[] toArray(long[] jArr);
}

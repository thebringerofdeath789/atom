package gnu.trove;

import gnu.trove.iterator.TLongIterator;
import gnu.trove.procedure.TLongProcedure;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface TLongCollection {
    public static final long serialVersionUID = 1;

    boolean add(long j);

    boolean addAll(TLongCollection tLongCollection);

    boolean addAll(Collection<? extends Long> collection);

    boolean addAll(long[] jArr);

    void clear();

    boolean contains(long j);

    boolean containsAll(TLongCollection tLongCollection);

    boolean containsAll(Collection<?> collection);

    boolean containsAll(long[] jArr);

    boolean equals(Object obj);

    boolean forEach(TLongProcedure tLongProcedure);

    long getNoEntryValue();

    int hashCode();

    boolean isEmpty();

    TLongIterator iterator();

    boolean remove(long j);

    boolean removeAll(TLongCollection tLongCollection);

    boolean removeAll(Collection<?> collection);

    boolean removeAll(long[] jArr);

    boolean retainAll(TLongCollection tLongCollection);

    boolean retainAll(Collection<?> collection);

    boolean retainAll(long[] jArr);

    int size();

    long[] toArray();

    long[] toArray(long[] jArr);
}
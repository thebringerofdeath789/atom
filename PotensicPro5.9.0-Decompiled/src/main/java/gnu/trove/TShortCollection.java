package gnu.trove;

import gnu.trove.iterator.TShortIterator;
import gnu.trove.procedure.TShortProcedure;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface TShortCollection {
    public static final long serialVersionUID = 1;

    boolean add(short s);

    boolean addAll(TShortCollection tShortCollection);

    boolean addAll(Collection<? extends Short> collection);

    boolean addAll(short[] sArr);

    void clear();

    boolean contains(short s);

    boolean containsAll(TShortCollection tShortCollection);

    boolean containsAll(Collection<?> collection);

    boolean containsAll(short[] sArr);

    boolean equals(Object obj);

    boolean forEach(TShortProcedure tShortProcedure);

    short getNoEntryValue();

    int hashCode();

    boolean isEmpty();

    TShortIterator iterator();

    boolean remove(short s);

    boolean removeAll(TShortCollection tShortCollection);

    boolean removeAll(Collection<?> collection);

    boolean removeAll(short[] sArr);

    boolean retainAll(TShortCollection tShortCollection);

    boolean retainAll(Collection<?> collection);

    boolean retainAll(short[] sArr);

    int size();

    short[] toArray();

    short[] toArray(short[] sArr);
}

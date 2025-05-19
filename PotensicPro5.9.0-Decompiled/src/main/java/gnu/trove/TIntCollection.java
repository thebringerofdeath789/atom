package gnu.trove;

import gnu.trove.iterator.TIntIterator;
import gnu.trove.procedure.TIntProcedure;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface TIntCollection {
    public static final long serialVersionUID = 1;

    boolean add(int i);

    boolean addAll(TIntCollection tIntCollection);

    boolean addAll(Collection<? extends Integer> collection);

    boolean addAll(int[] iArr);

    void clear();

    boolean contains(int i);

    boolean containsAll(TIntCollection tIntCollection);

    boolean containsAll(Collection<?> collection);

    boolean containsAll(int[] iArr);

    boolean equals(Object obj);

    boolean forEach(TIntProcedure tIntProcedure);

    int getNoEntryValue();

    int hashCode();

    boolean isEmpty();

    TIntIterator iterator();

    boolean remove(int i);

    boolean removeAll(TIntCollection tIntCollection);

    boolean removeAll(Collection<?> collection);

    boolean removeAll(int[] iArr);

    boolean retainAll(TIntCollection tIntCollection);

    boolean retainAll(Collection<?> collection);

    boolean retainAll(int[] iArr);

    int size();

    int[] toArray();

    int[] toArray(int[] iArr);
}

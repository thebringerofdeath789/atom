package gnu.trove.set;

import gnu.trove.TIntCollection;
import gnu.trove.iterator.TIntIterator;
import gnu.trove.procedure.TIntProcedure;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface TIntSet extends TIntCollection {
    @Override // gnu.trove.TIntCollection
    boolean add(int i);

    @Override // gnu.trove.TIntCollection
    boolean addAll(TIntCollection tIntCollection);

    @Override // gnu.trove.TIntCollection
    boolean addAll(Collection<? extends Integer> collection);

    @Override // gnu.trove.TIntCollection
    boolean addAll(int[] iArr);

    @Override // gnu.trove.TIntCollection
    void clear();

    @Override // gnu.trove.TIntCollection
    boolean contains(int i);

    @Override // gnu.trove.TIntCollection
    boolean containsAll(TIntCollection tIntCollection);

    @Override // gnu.trove.TIntCollection
    boolean containsAll(Collection<?> collection);

    @Override // gnu.trove.TIntCollection
    boolean containsAll(int[] iArr);

    @Override // gnu.trove.TIntCollection
    boolean equals(Object obj);

    @Override // gnu.trove.TIntCollection
    boolean forEach(TIntProcedure tIntProcedure);

    @Override // gnu.trove.TIntCollection
    int getNoEntryValue();

    @Override // gnu.trove.TIntCollection
    int hashCode();

    @Override // gnu.trove.TIntCollection
    boolean isEmpty();

    @Override // gnu.trove.TIntCollection
    TIntIterator iterator();

    @Override // gnu.trove.TIntCollection
    boolean remove(int i);

    @Override // gnu.trove.TIntCollection
    boolean removeAll(TIntCollection tIntCollection);

    @Override // gnu.trove.TIntCollection
    boolean removeAll(Collection<?> collection);

    @Override // gnu.trove.TIntCollection
    boolean removeAll(int[] iArr);

    @Override // gnu.trove.TIntCollection
    boolean retainAll(TIntCollection tIntCollection);

    @Override // gnu.trove.TIntCollection
    boolean retainAll(Collection<?> collection);

    @Override // gnu.trove.TIntCollection
    boolean retainAll(int[] iArr);

    @Override // gnu.trove.TIntCollection
    int size();

    @Override // gnu.trove.TIntCollection
    int[] toArray();

    @Override // gnu.trove.TIntCollection
    int[] toArray(int[] iArr);
}
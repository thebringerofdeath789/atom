package gnu.trove.set;

import gnu.trove.TDoubleCollection;
import gnu.trove.iterator.TDoubleIterator;
import gnu.trove.procedure.TDoubleProcedure;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface TDoubleSet extends TDoubleCollection {
    @Override // gnu.trove.TDoubleCollection
    boolean add(double d);

    @Override // gnu.trove.TDoubleCollection
    boolean addAll(TDoubleCollection tDoubleCollection);

    @Override // gnu.trove.TDoubleCollection
    boolean addAll(Collection<? extends Double> collection);

    @Override // gnu.trove.TDoubleCollection
    boolean addAll(double[] dArr);

    @Override // gnu.trove.TDoubleCollection
    void clear();

    @Override // gnu.trove.TDoubleCollection
    boolean contains(double d);

    @Override // gnu.trove.TDoubleCollection
    boolean containsAll(TDoubleCollection tDoubleCollection);

    @Override // gnu.trove.TDoubleCollection
    boolean containsAll(Collection<?> collection);

    @Override // gnu.trove.TDoubleCollection
    boolean containsAll(double[] dArr);

    @Override // gnu.trove.TDoubleCollection
    boolean equals(Object obj);

    @Override // gnu.trove.TDoubleCollection
    boolean forEach(TDoubleProcedure tDoubleProcedure);

    @Override // gnu.trove.TDoubleCollection
    double getNoEntryValue();

    @Override // gnu.trove.TDoubleCollection
    int hashCode();

    @Override // gnu.trove.TDoubleCollection
    boolean isEmpty();

    @Override // gnu.trove.TDoubleCollection
    TDoubleIterator iterator();

    @Override // gnu.trove.TDoubleCollection
    boolean remove(double d);

    @Override // gnu.trove.TDoubleCollection
    boolean removeAll(TDoubleCollection tDoubleCollection);

    @Override // gnu.trove.TDoubleCollection
    boolean removeAll(Collection<?> collection);

    @Override // gnu.trove.TDoubleCollection
    boolean removeAll(double[] dArr);

    @Override // gnu.trove.TDoubleCollection
    boolean retainAll(TDoubleCollection tDoubleCollection);

    @Override // gnu.trove.TDoubleCollection
    boolean retainAll(Collection<?> collection);

    @Override // gnu.trove.TDoubleCollection
    boolean retainAll(double[] dArr);

    @Override // gnu.trove.TDoubleCollection
    int size();

    @Override // gnu.trove.TDoubleCollection
    double[] toArray();

    @Override // gnu.trove.TDoubleCollection
    double[] toArray(double[] dArr);
}

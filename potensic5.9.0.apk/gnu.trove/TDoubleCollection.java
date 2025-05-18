package gnu.trove;

import gnu.trove.iterator.TDoubleIterator;
import gnu.trove.procedure.TDoubleProcedure;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface TDoubleCollection {
    public static final long serialVersionUID = 1;

    boolean add(double d);

    boolean addAll(TDoubleCollection tDoubleCollection);

    boolean addAll(Collection<? extends Double> collection);

    boolean addAll(double[] dArr);

    void clear();

    boolean contains(double d);

    boolean containsAll(TDoubleCollection tDoubleCollection);

    boolean containsAll(Collection<?> collection);

    boolean containsAll(double[] dArr);

    boolean equals(Object obj);

    boolean forEach(TDoubleProcedure tDoubleProcedure);

    double getNoEntryValue();

    int hashCode();

    boolean isEmpty();

    TDoubleIterator iterator();

    boolean remove(double d);

    boolean removeAll(TDoubleCollection tDoubleCollection);

    boolean removeAll(Collection<?> collection);

    boolean removeAll(double[] dArr);

    boolean retainAll(TDoubleCollection tDoubleCollection);

    boolean retainAll(Collection<?> collection);

    boolean retainAll(double[] dArr);

    int size();

    double[] toArray();

    double[] toArray(double[] dArr);
}
package gnu.trove;

import gnu.trove.iterator.TFloatIterator;
import gnu.trove.procedure.TFloatProcedure;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface TFloatCollection {
    public static final long serialVersionUID = 1;

    boolean add(float f);

    boolean addAll(TFloatCollection tFloatCollection);

    boolean addAll(Collection<? extends Float> collection);

    boolean addAll(float[] fArr);

    void clear();

    boolean contains(float f);

    boolean containsAll(TFloatCollection tFloatCollection);

    boolean containsAll(Collection<?> collection);

    boolean containsAll(float[] fArr);

    boolean equals(Object obj);

    boolean forEach(TFloatProcedure tFloatProcedure);

    float getNoEntryValue();

    int hashCode();

    boolean isEmpty();

    TFloatIterator iterator();

    boolean remove(float f);

    boolean removeAll(TFloatCollection tFloatCollection);

    boolean removeAll(Collection<?> collection);

    boolean removeAll(float[] fArr);

    boolean retainAll(TFloatCollection tFloatCollection);

    boolean retainAll(Collection<?> collection);

    boolean retainAll(float[] fArr);

    int size();

    float[] toArray();

    float[] toArray(float[] fArr);
}

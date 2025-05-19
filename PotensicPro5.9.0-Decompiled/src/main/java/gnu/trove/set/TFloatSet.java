package gnu.trove.set;

import gnu.trove.TFloatCollection;
import gnu.trove.iterator.TFloatIterator;
import gnu.trove.procedure.TFloatProcedure;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface TFloatSet extends TFloatCollection {
    @Override // gnu.trove.TFloatCollection
    boolean add(float f);

    @Override // gnu.trove.TFloatCollection
    boolean addAll(TFloatCollection tFloatCollection);

    @Override // gnu.trove.TFloatCollection
    boolean addAll(Collection<? extends Float> collection);

    @Override // gnu.trove.TFloatCollection
    boolean addAll(float[] fArr);

    @Override // gnu.trove.TFloatCollection
    void clear();

    @Override // gnu.trove.TFloatCollection
    boolean contains(float f);

    @Override // gnu.trove.TFloatCollection
    boolean containsAll(TFloatCollection tFloatCollection);

    @Override // gnu.trove.TFloatCollection
    boolean containsAll(Collection<?> collection);

    @Override // gnu.trove.TFloatCollection
    boolean containsAll(float[] fArr);

    @Override // gnu.trove.TFloatCollection
    boolean equals(Object obj);

    @Override // gnu.trove.TFloatCollection
    boolean forEach(TFloatProcedure tFloatProcedure);

    @Override // gnu.trove.TFloatCollection
    float getNoEntryValue();

    @Override // gnu.trove.TFloatCollection
    int hashCode();

    @Override // gnu.trove.TFloatCollection
    boolean isEmpty();

    @Override // gnu.trove.TFloatCollection
    TFloatIterator iterator();

    @Override // gnu.trove.TFloatCollection
    boolean remove(float f);

    @Override // gnu.trove.TFloatCollection
    boolean removeAll(TFloatCollection tFloatCollection);

    @Override // gnu.trove.TFloatCollection
    boolean removeAll(Collection<?> collection);

    @Override // gnu.trove.TFloatCollection
    boolean removeAll(float[] fArr);

    @Override // gnu.trove.TFloatCollection
    boolean retainAll(TFloatCollection tFloatCollection);

    @Override // gnu.trove.TFloatCollection
    boolean retainAll(Collection<?> collection);

    @Override // gnu.trove.TFloatCollection
    boolean retainAll(float[] fArr);

    @Override // gnu.trove.TFloatCollection
    int size();

    @Override // gnu.trove.TFloatCollection
    float[] toArray();

    @Override // gnu.trove.TFloatCollection
    float[] toArray(float[] fArr);
}

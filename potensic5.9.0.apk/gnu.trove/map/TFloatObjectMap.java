package gnu.trove.map;

import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TFloatObjectIterator;
import gnu.trove.procedure.TFloatObjectProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TFloatSet;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TFloatObjectMap<V> {
    void clear();

    boolean containsKey(float f);

    boolean containsValue(Object obj);

    boolean equals(Object obj);

    boolean forEachEntry(TFloatObjectProcedure<? super V> tFloatObjectProcedure);

    boolean forEachKey(TFloatProcedure tFloatProcedure);

    boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure);

    V get(float f);

    float getNoEntryKey();

    int hashCode();

    boolean isEmpty();

    TFloatObjectIterator<V> iterator();

    TFloatSet keySet();

    float[] keys();

    float[] keys(float[] fArr);

    V put(float f, V v);

    void putAll(TFloatObjectMap<? extends V> tFloatObjectMap);

    void putAll(Map<? extends Float, ? extends V> map);

    V putIfAbsent(float f, V v);

    V remove(float f);

    boolean retainEntries(TFloatObjectProcedure<? super V> tFloatObjectProcedure);

    int size();

    void transformValues(TObjectFunction<V, V> tObjectFunction);

    Collection<V> valueCollection();

    Object[] values();

    V[] values(V[] vArr);
}
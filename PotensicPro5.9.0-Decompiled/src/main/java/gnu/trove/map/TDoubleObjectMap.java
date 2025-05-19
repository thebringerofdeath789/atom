package gnu.trove.map;

import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TDoubleObjectIterator;
import gnu.trove.procedure.TDoubleObjectProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TDoubleSet;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TDoubleObjectMap<V> {
    void clear();

    boolean containsKey(double d);

    boolean containsValue(Object obj);

    boolean equals(Object obj);

    boolean forEachEntry(TDoubleObjectProcedure<? super V> tDoubleObjectProcedure);

    boolean forEachKey(TDoubleProcedure tDoubleProcedure);

    boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure);

    V get(double d);

    double getNoEntryKey();

    int hashCode();

    boolean isEmpty();

    TDoubleObjectIterator<V> iterator();

    TDoubleSet keySet();

    double[] keys();

    double[] keys(double[] dArr);

    V put(double d, V v);

    void putAll(TDoubleObjectMap<? extends V> tDoubleObjectMap);

    void putAll(Map<? extends Double, ? extends V> map);

    V putIfAbsent(double d, V v);

    V remove(double d);

    boolean retainEntries(TDoubleObjectProcedure<? super V> tDoubleObjectProcedure);

    int size();

    void transformValues(TObjectFunction<V, V> tObjectFunction);

    Collection<V> valueCollection();

    Object[] values();

    V[] values(V[] vArr);
}

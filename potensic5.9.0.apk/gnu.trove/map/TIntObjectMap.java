package gnu.trove.map;

import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TIntObjectIterator;
import gnu.trove.procedure.TIntObjectProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TIntSet;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TIntObjectMap<V> {
    void clear();

    boolean containsKey(int i);

    boolean containsValue(Object obj);

    boolean equals(Object obj);

    boolean forEachEntry(TIntObjectProcedure<? super V> tIntObjectProcedure);

    boolean forEachKey(TIntProcedure tIntProcedure);

    boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure);

    V get(int i);

    int getNoEntryKey();

    int hashCode();

    boolean isEmpty();

    TIntObjectIterator<V> iterator();

    TIntSet keySet();

    int[] keys();

    int[] keys(int[] iArr);

    V put(int i, V v);

    void putAll(TIntObjectMap<? extends V> tIntObjectMap);

    void putAll(Map<? extends Integer, ? extends V> map);

    V putIfAbsent(int i, V v);

    V remove(int i);

    boolean retainEntries(TIntObjectProcedure<? super V> tIntObjectProcedure);

    int size();

    void transformValues(TObjectFunction<V, V> tObjectFunction);

    Collection<V> valueCollection();

    Object[] values();

    V[] values(V[] vArr);
}
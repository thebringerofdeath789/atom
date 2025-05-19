package gnu.trove.map;

import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TLongObjectIterator;
import gnu.trove.procedure.TLongObjectProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TLongSet;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TLongObjectMap<V> {
    void clear();

    boolean containsKey(long j);

    boolean containsValue(Object obj);

    boolean equals(Object obj);

    boolean forEachEntry(TLongObjectProcedure<? super V> tLongObjectProcedure);

    boolean forEachKey(TLongProcedure tLongProcedure);

    boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure);

    V get(long j);

    long getNoEntryKey();

    int hashCode();

    boolean isEmpty();

    TLongObjectIterator<V> iterator();

    TLongSet keySet();

    long[] keys();

    long[] keys(long[] jArr);

    V put(long j, V v);

    void putAll(TLongObjectMap<? extends V> tLongObjectMap);

    void putAll(Map<? extends Long, ? extends V> map);

    V putIfAbsent(long j, V v);

    V remove(long j);

    boolean retainEntries(TLongObjectProcedure<? super V> tLongObjectProcedure);

    int size();

    void transformValues(TObjectFunction<V, V> tObjectFunction);

    Collection<V> valueCollection();

    Object[] values();

    V[] values(V[] vArr);
}

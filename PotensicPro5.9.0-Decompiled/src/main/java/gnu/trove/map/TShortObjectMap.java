package gnu.trove.map;

import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TShortObjectIterator;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.procedure.TShortObjectProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TShortObjectMap<V> {
    void clear();

    boolean containsKey(short s);

    boolean containsValue(Object obj);

    boolean equals(Object obj);

    boolean forEachEntry(TShortObjectProcedure<? super V> tShortObjectProcedure);

    boolean forEachKey(TShortProcedure tShortProcedure);

    boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure);

    V get(short s);

    short getNoEntryKey();

    int hashCode();

    boolean isEmpty();

    TShortObjectIterator<V> iterator();

    TShortSet keySet();

    short[] keys();

    short[] keys(short[] sArr);

    V put(short s, V v);

    void putAll(TShortObjectMap<? extends V> tShortObjectMap);

    void putAll(Map<? extends Short, ? extends V> map);

    V putIfAbsent(short s, V v);

    V remove(short s);

    boolean retainEntries(TShortObjectProcedure<? super V> tShortObjectProcedure);

    int size();

    void transformValues(TObjectFunction<V, V> tObjectFunction);

    Collection<V> valueCollection();

    Object[] values();

    V[] values(V[] vArr);
}

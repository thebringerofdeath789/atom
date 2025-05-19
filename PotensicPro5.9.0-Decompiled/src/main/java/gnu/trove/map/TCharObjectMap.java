package gnu.trove.map;

import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TCharObjectIterator;
import gnu.trove.procedure.TCharObjectProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TCharSet;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TCharObjectMap<V> {
    void clear();

    boolean containsKey(char c);

    boolean containsValue(Object obj);

    boolean equals(Object obj);

    boolean forEachEntry(TCharObjectProcedure<? super V> tCharObjectProcedure);

    boolean forEachKey(TCharProcedure tCharProcedure);

    boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure);

    V get(char c);

    char getNoEntryKey();

    int hashCode();

    boolean isEmpty();

    TCharObjectIterator<V> iterator();

    TCharSet keySet();

    char[] keys();

    char[] keys(char[] cArr);

    V put(char c, V v);

    void putAll(TCharObjectMap<? extends V> tCharObjectMap);

    void putAll(Map<? extends Character, ? extends V> map);

    V putIfAbsent(char c, V v);

    V remove(char c);

    boolean retainEntries(TCharObjectProcedure<? super V> tCharObjectProcedure);

    int size();

    void transformValues(TObjectFunction<V, V> tObjectFunction);

    Collection<V> valueCollection();

    Object[] values();

    V[] values(V[] vArr);
}

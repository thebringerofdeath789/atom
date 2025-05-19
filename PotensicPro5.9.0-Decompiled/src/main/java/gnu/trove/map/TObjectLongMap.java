package gnu.trove.map;

import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TObjectLongIterator;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.procedure.TObjectLongProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public interface TObjectLongMap<K> {
    long adjustOrPutValue(K k, long j, long j2);

    boolean adjustValue(K k, long j);

    void clear();

    boolean containsKey(Object obj);

    boolean containsValue(long j);

    boolean equals(Object obj);

    boolean forEachEntry(TObjectLongProcedure<? super K> tObjectLongProcedure);

    boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure);

    boolean forEachValue(TLongProcedure tLongProcedure);

    long get(Object obj);

    long getNoEntryValue();

    int hashCode();

    boolean increment(K k);

    boolean isEmpty();

    TObjectLongIterator<K> iterator();

    Set<K> keySet();

    Object[] keys();

    K[] keys(K[] kArr);

    long put(K k, long j);

    void putAll(TObjectLongMap<? extends K> tObjectLongMap);

    void putAll(Map<? extends K, ? extends Long> map);

    long putIfAbsent(K k, long j);

    long remove(Object obj);

    boolean retainEntries(TObjectLongProcedure<? super K> tObjectLongProcedure);

    int size();

    void transformValues(TLongFunction tLongFunction);

    TLongCollection valueCollection();

    long[] values();

    long[] values(long[] jArr);
}

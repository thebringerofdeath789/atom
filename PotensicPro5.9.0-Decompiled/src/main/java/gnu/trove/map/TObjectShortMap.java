package gnu.trove.map;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TObjectShortIterator;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.procedure.TObjectShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public interface TObjectShortMap<K> {
    short adjustOrPutValue(K k, short s, short s2);

    boolean adjustValue(K k, short s);

    void clear();

    boolean containsKey(Object obj);

    boolean containsValue(short s);

    boolean equals(Object obj);

    boolean forEachEntry(TObjectShortProcedure<? super K> tObjectShortProcedure);

    boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure);

    boolean forEachValue(TShortProcedure tShortProcedure);

    short get(Object obj);

    short getNoEntryValue();

    int hashCode();

    boolean increment(K k);

    boolean isEmpty();

    TObjectShortIterator<K> iterator();

    Set<K> keySet();

    Object[] keys();

    K[] keys(K[] kArr);

    short put(K k, short s);

    void putAll(TObjectShortMap<? extends K> tObjectShortMap);

    void putAll(Map<? extends K, ? extends Short> map);

    short putIfAbsent(K k, short s);

    short remove(Object obj);

    boolean retainEntries(TObjectShortProcedure<? super K> tObjectShortProcedure);

    int size();

    void transformValues(TShortFunction tShortFunction);

    TShortCollection valueCollection();

    short[] values();

    short[] values(short[] sArr);
}

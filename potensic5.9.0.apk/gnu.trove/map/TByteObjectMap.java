package gnu.trove.map;

import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TByteObjectIterator;
import gnu.trove.procedure.TByteObjectProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TByteSet;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TByteObjectMap<V> {
    void clear();

    boolean containsKey(byte b);

    boolean containsValue(Object obj);

    boolean equals(Object obj);

    boolean forEachEntry(TByteObjectProcedure<? super V> tByteObjectProcedure);

    boolean forEachKey(TByteProcedure tByteProcedure);

    boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure);

    V get(byte b);

    byte getNoEntryKey();

    int hashCode();

    boolean isEmpty();

    TByteObjectIterator<V> iterator();

    TByteSet keySet();

    byte[] keys();

    byte[] keys(byte[] bArr);

    V put(byte b, V v);

    void putAll(TByteObjectMap<? extends V> tByteObjectMap);

    void putAll(Map<? extends Byte, ? extends V> map);

    V putIfAbsent(byte b, V v);

    V remove(byte b);

    boolean retainEntries(TByteObjectProcedure<? super V> tByteObjectProcedure);

    int size();

    void transformValues(TObjectFunction<V, V> tObjectFunction);

    Collection<V> valueCollection();

    Object[] values();

    V[] values(V[] vArr);
}
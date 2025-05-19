package gnu.trove.map;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TObjectByteIterator;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TObjectByteProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public interface TObjectByteMap<K> {
    byte adjustOrPutValue(K k, byte b, byte b2);

    boolean adjustValue(K k, byte b);

    void clear();

    boolean containsKey(Object obj);

    boolean containsValue(byte b);

    boolean equals(Object obj);

    boolean forEachEntry(TObjectByteProcedure<? super K> tObjectByteProcedure);

    boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure);

    boolean forEachValue(TByteProcedure tByteProcedure);

    byte get(Object obj);

    byte getNoEntryValue();

    int hashCode();

    boolean increment(K k);

    boolean isEmpty();

    TObjectByteIterator<K> iterator();

    Set<K> keySet();

    Object[] keys();

    K[] keys(K[] kArr);

    byte put(K k, byte b);

    void putAll(TObjectByteMap<? extends K> tObjectByteMap);

    void putAll(Map<? extends K, ? extends Byte> map);

    byte putIfAbsent(K k, byte b);

    byte remove(Object obj);

    boolean retainEntries(TObjectByteProcedure<? super K> tObjectByteProcedure);

    int size();

    void transformValues(TByteFunction tByteFunction);

    TByteCollection valueCollection();

    byte[] values();

    byte[] values(byte[] bArr);
}

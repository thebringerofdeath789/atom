package gnu.trove.map;

import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TObjectCharIterator;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TObjectCharProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public interface TObjectCharMap<K> {
    char adjustOrPutValue(K k, char c, char c2);

    boolean adjustValue(K k, char c);

    void clear();

    boolean containsKey(Object obj);

    boolean containsValue(char c);

    boolean equals(Object obj);

    boolean forEachEntry(TObjectCharProcedure<? super K> tObjectCharProcedure);

    boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure);

    boolean forEachValue(TCharProcedure tCharProcedure);

    char get(Object obj);

    char getNoEntryValue();

    int hashCode();

    boolean increment(K k);

    boolean isEmpty();

    TObjectCharIterator<K> iterator();

    Set<K> keySet();

    Object[] keys();

    K[] keys(K[] kArr);

    char put(K k, char c);

    void putAll(TObjectCharMap<? extends K> tObjectCharMap);

    void putAll(Map<? extends K, ? extends Character> map);

    char putIfAbsent(K k, char c);

    char remove(Object obj);

    boolean retainEntries(TObjectCharProcedure<? super K> tObjectCharProcedure);

    int size();

    void transformValues(TCharFunction tCharFunction);

    TCharCollection valueCollection();

    char[] values();

    char[] values(char[] cArr);
}
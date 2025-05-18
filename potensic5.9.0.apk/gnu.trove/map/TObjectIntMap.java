package gnu.trove.map;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TObjectIntIterator;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TObjectIntProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public interface TObjectIntMap<K> {
    int adjustOrPutValue(K k, int i, int i2);

    boolean adjustValue(K k, int i);

    void clear();

    boolean containsKey(Object obj);

    boolean containsValue(int i);

    boolean equals(Object obj);

    boolean forEachEntry(TObjectIntProcedure<? super K> tObjectIntProcedure);

    boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure);

    boolean forEachValue(TIntProcedure tIntProcedure);

    int get(Object obj);

    int getNoEntryValue();

    int hashCode();

    boolean increment(K k);

    boolean isEmpty();

    TObjectIntIterator<K> iterator();

    Set<K> keySet();

    Object[] keys();

    K[] keys(K[] kArr);

    int put(K k, int i);

    void putAll(TObjectIntMap<? extends K> tObjectIntMap);

    void putAll(Map<? extends K, ? extends Integer> map);

    int putIfAbsent(K k, int i);

    int remove(Object obj);

    boolean retainEntries(TObjectIntProcedure<? super K> tObjectIntProcedure);

    int size();

    void transformValues(TIntFunction tIntFunction);

    TIntCollection valueCollection();

    int[] values();

    int[] values(int[] iArr);
}
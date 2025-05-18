package gnu.trove.map;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TObjectFloatIterator;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TObjectFloatProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public interface TObjectFloatMap<K> {
    float adjustOrPutValue(K k, float f, float f2);

    boolean adjustValue(K k, float f);

    void clear();

    boolean containsKey(Object obj);

    boolean containsValue(float f);

    boolean equals(Object obj);

    boolean forEachEntry(TObjectFloatProcedure<? super K> tObjectFloatProcedure);

    boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure);

    boolean forEachValue(TFloatProcedure tFloatProcedure);

    float get(Object obj);

    float getNoEntryValue();

    int hashCode();

    boolean increment(K k);

    boolean isEmpty();

    TObjectFloatIterator<K> iterator();

    Set<K> keySet();

    Object[] keys();

    K[] keys(K[] kArr);

    float put(K k, float f);

    void putAll(TObjectFloatMap<? extends K> tObjectFloatMap);

    void putAll(Map<? extends K, ? extends Float> map);

    float putIfAbsent(K k, float f);

    float remove(Object obj);

    boolean retainEntries(TObjectFloatProcedure<? super K> tObjectFloatProcedure);

    int size();

    void transformValues(TFloatFunction tFloatFunction);

    TFloatCollection valueCollection();

    float[] values();

    float[] values(float[] fArr);
}
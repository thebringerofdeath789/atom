package gnu.trove.map;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TLongFloatIterator;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TLongFloatProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TLongFloatMap {
    float adjustOrPutValue(long j, float f, float f2);

    boolean adjustValue(long j, float f);

    void clear();

    boolean containsKey(long j);

    boolean containsValue(float f);

    boolean forEachEntry(TLongFloatProcedure tLongFloatProcedure);

    boolean forEachKey(TLongProcedure tLongProcedure);

    boolean forEachValue(TFloatProcedure tFloatProcedure);

    float get(long j);

    long getNoEntryKey();

    float getNoEntryValue();

    boolean increment(long j);

    boolean isEmpty();

    TLongFloatIterator iterator();

    TLongSet keySet();

    long[] keys();

    long[] keys(long[] jArr);

    float put(long j, float f);

    void putAll(TLongFloatMap tLongFloatMap);

    void putAll(Map<? extends Long, ? extends Float> map);

    float putIfAbsent(long j, float f);

    float remove(long j);

    boolean retainEntries(TLongFloatProcedure tLongFloatProcedure);

    int size();

    void transformValues(TFloatFunction tFloatFunction);

    TFloatCollection valueCollection();

    float[] values();

    float[] values(float[] fArr);
}
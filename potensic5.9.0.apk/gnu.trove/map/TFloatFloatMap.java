package gnu.trove.map;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TFloatFloatIterator;
import gnu.trove.procedure.TFloatFloatProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TFloatSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TFloatFloatMap {
    float adjustOrPutValue(float f, float f2, float f3);

    boolean adjustValue(float f, float f2);

    void clear();

    boolean containsKey(float f);

    boolean containsValue(float f);

    boolean forEachEntry(TFloatFloatProcedure tFloatFloatProcedure);

    boolean forEachKey(TFloatProcedure tFloatProcedure);

    boolean forEachValue(TFloatProcedure tFloatProcedure);

    float get(float f);

    float getNoEntryKey();

    float getNoEntryValue();

    boolean increment(float f);

    boolean isEmpty();

    TFloatFloatIterator iterator();

    TFloatSet keySet();

    float[] keys();

    float[] keys(float[] fArr);

    float put(float f, float f2);

    void putAll(TFloatFloatMap tFloatFloatMap);

    void putAll(Map<? extends Float, ? extends Float> map);

    float putIfAbsent(float f, float f2);

    float remove(float f);

    boolean retainEntries(TFloatFloatProcedure tFloatFloatProcedure);

    int size();

    void transformValues(TFloatFunction tFloatFunction);

    TFloatCollection valueCollection();

    float[] values();

    float[] values(float[] fArr);
}
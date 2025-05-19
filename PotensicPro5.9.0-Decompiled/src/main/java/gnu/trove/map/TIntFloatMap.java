package gnu.trove.map;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TIntFloatIterator;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TIntFloatProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TIntSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TIntFloatMap {
    float adjustOrPutValue(int i, float f, float f2);

    boolean adjustValue(int i, float f);

    void clear();

    boolean containsKey(int i);

    boolean containsValue(float f);

    boolean forEachEntry(TIntFloatProcedure tIntFloatProcedure);

    boolean forEachKey(TIntProcedure tIntProcedure);

    boolean forEachValue(TFloatProcedure tFloatProcedure);

    float get(int i);

    int getNoEntryKey();

    float getNoEntryValue();

    boolean increment(int i);

    boolean isEmpty();

    TIntFloatIterator iterator();

    TIntSet keySet();

    int[] keys();

    int[] keys(int[] iArr);

    float put(int i, float f);

    void putAll(TIntFloatMap tIntFloatMap);

    void putAll(Map<? extends Integer, ? extends Float> map);

    float putIfAbsent(int i, float f);

    float remove(int i);

    boolean retainEntries(TIntFloatProcedure tIntFloatProcedure);

    int size();

    void transformValues(TFloatFunction tFloatFunction);

    TFloatCollection valueCollection();

    float[] values();

    float[] values(float[] fArr);
}

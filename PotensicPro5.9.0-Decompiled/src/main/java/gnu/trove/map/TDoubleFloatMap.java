package gnu.trove.map;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TDoubleFloatIterator;
import gnu.trove.procedure.TDoubleFloatProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TDoubleSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TDoubleFloatMap {
    float adjustOrPutValue(double d, float f, float f2);

    boolean adjustValue(double d, float f);

    void clear();

    boolean containsKey(double d);

    boolean containsValue(float f);

    boolean forEachEntry(TDoubleFloatProcedure tDoubleFloatProcedure);

    boolean forEachKey(TDoubleProcedure tDoubleProcedure);

    boolean forEachValue(TFloatProcedure tFloatProcedure);

    float get(double d);

    double getNoEntryKey();

    float getNoEntryValue();

    boolean increment(double d);

    boolean isEmpty();

    TDoubleFloatIterator iterator();

    TDoubleSet keySet();

    double[] keys();

    double[] keys(double[] dArr);

    float put(double d, float f);

    void putAll(TDoubleFloatMap tDoubleFloatMap);

    void putAll(Map<? extends Double, ? extends Float> map);

    float putIfAbsent(double d, float f);

    float remove(double d);

    boolean retainEntries(TDoubleFloatProcedure tDoubleFloatProcedure);

    int size();

    void transformValues(TFloatFunction tFloatFunction);

    TFloatCollection valueCollection();

    float[] values();

    float[] values(float[] fArr);
}

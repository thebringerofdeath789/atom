package gnu.trove.map;

import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TFloatDoubleIterator;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TFloatDoubleProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TFloatSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TFloatDoubleMap {
    double adjustOrPutValue(float f, double d, double d2);

    boolean adjustValue(float f, double d);

    void clear();

    boolean containsKey(float f);

    boolean containsValue(double d);

    boolean forEachEntry(TFloatDoubleProcedure tFloatDoubleProcedure);

    boolean forEachKey(TFloatProcedure tFloatProcedure);

    boolean forEachValue(TDoubleProcedure tDoubleProcedure);

    double get(float f);

    float getNoEntryKey();

    double getNoEntryValue();

    boolean increment(float f);

    boolean isEmpty();

    TFloatDoubleIterator iterator();

    TFloatSet keySet();

    float[] keys();

    float[] keys(float[] fArr);

    double put(float f, double d);

    void putAll(TFloatDoubleMap tFloatDoubleMap);

    void putAll(Map<? extends Float, ? extends Double> map);

    double putIfAbsent(float f, double d);

    double remove(float f);

    boolean retainEntries(TFloatDoubleProcedure tFloatDoubleProcedure);

    int size();

    void transformValues(TDoubleFunction tDoubleFunction);

    TDoubleCollection valueCollection();

    double[] values();

    double[] values(double[] dArr);
}

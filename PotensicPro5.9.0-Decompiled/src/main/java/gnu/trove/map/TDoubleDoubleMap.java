package gnu.trove.map;

import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TDoubleDoubleIterator;
import gnu.trove.procedure.TDoubleDoubleProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.set.TDoubleSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TDoubleDoubleMap {
    double adjustOrPutValue(double d, double d2, double d3);

    boolean adjustValue(double d, double d2);

    void clear();

    boolean containsKey(double d);

    boolean containsValue(double d);

    boolean forEachEntry(TDoubleDoubleProcedure tDoubleDoubleProcedure);

    boolean forEachKey(TDoubleProcedure tDoubleProcedure);

    boolean forEachValue(TDoubleProcedure tDoubleProcedure);

    double get(double d);

    double getNoEntryKey();

    double getNoEntryValue();

    boolean increment(double d);

    boolean isEmpty();

    TDoubleDoubleIterator iterator();

    TDoubleSet keySet();

    double[] keys();

    double[] keys(double[] dArr);

    double put(double d, double d2);

    void putAll(TDoubleDoubleMap tDoubleDoubleMap);

    void putAll(Map<? extends Double, ? extends Double> map);

    double putIfAbsent(double d, double d2);

    double remove(double d);

    boolean retainEntries(TDoubleDoubleProcedure tDoubleDoubleProcedure);

    int size();

    void transformValues(TDoubleFunction tDoubleFunction);

    TDoubleCollection valueCollection();

    double[] values();

    double[] values(double[] dArr);
}

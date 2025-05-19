package gnu.trove.map;

import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TIntDoubleIterator;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TIntDoubleProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TIntSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TIntDoubleMap {
    double adjustOrPutValue(int i, double d, double d2);

    boolean adjustValue(int i, double d);

    void clear();

    boolean containsKey(int i);

    boolean containsValue(double d);

    boolean forEachEntry(TIntDoubleProcedure tIntDoubleProcedure);

    boolean forEachKey(TIntProcedure tIntProcedure);

    boolean forEachValue(TDoubleProcedure tDoubleProcedure);

    double get(int i);

    int getNoEntryKey();

    double getNoEntryValue();

    boolean increment(int i);

    boolean isEmpty();

    TIntDoubleIterator iterator();

    TIntSet keySet();

    int[] keys();

    int[] keys(int[] iArr);

    double put(int i, double d);

    void putAll(TIntDoubleMap tIntDoubleMap);

    void putAll(Map<? extends Integer, ? extends Double> map);

    double putIfAbsent(int i, double d);

    double remove(int i);

    boolean retainEntries(TIntDoubleProcedure tIntDoubleProcedure);

    int size();

    void transformValues(TDoubleFunction tDoubleFunction);

    TDoubleCollection valueCollection();

    double[] values();

    double[] values(double[] dArr);
}

package gnu.trove.map;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TDoubleIntIterator;
import gnu.trove.procedure.TDoubleIntProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TDoubleSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TDoubleIntMap {
    int adjustOrPutValue(double d, int i, int i2);

    boolean adjustValue(double d, int i);

    void clear();

    boolean containsKey(double d);

    boolean containsValue(int i);

    boolean forEachEntry(TDoubleIntProcedure tDoubleIntProcedure);

    boolean forEachKey(TDoubleProcedure tDoubleProcedure);

    boolean forEachValue(TIntProcedure tIntProcedure);

    int get(double d);

    double getNoEntryKey();

    int getNoEntryValue();

    boolean increment(double d);

    boolean isEmpty();

    TDoubleIntIterator iterator();

    TDoubleSet keySet();

    double[] keys();

    double[] keys(double[] dArr);

    int put(double d, int i);

    void putAll(TDoubleIntMap tDoubleIntMap);

    void putAll(Map<? extends Double, ? extends Integer> map);

    int putIfAbsent(double d, int i);

    int remove(double d);

    boolean retainEntries(TDoubleIntProcedure tDoubleIntProcedure);

    int size();

    void transformValues(TIntFunction tIntFunction);

    TIntCollection valueCollection();

    int[] values();

    int[] values(int[] iArr);
}
package gnu.trove.map;

import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TLongDoubleIterator;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TLongDoubleProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TLongDoubleMap {
    double adjustOrPutValue(long j, double d, double d2);

    boolean adjustValue(long j, double d);

    void clear();

    boolean containsKey(long j);

    boolean containsValue(double d);

    boolean forEachEntry(TLongDoubleProcedure tLongDoubleProcedure);

    boolean forEachKey(TLongProcedure tLongProcedure);

    boolean forEachValue(TDoubleProcedure tDoubleProcedure);

    double get(long j);

    long getNoEntryKey();

    double getNoEntryValue();

    boolean increment(long j);

    boolean isEmpty();

    TLongDoubleIterator iterator();

    TLongSet keySet();

    long[] keys();

    long[] keys(long[] jArr);

    double put(long j, double d);

    void putAll(TLongDoubleMap tLongDoubleMap);

    void putAll(Map<? extends Long, ? extends Double> map);

    double putIfAbsent(long j, double d);

    double remove(long j);

    boolean retainEntries(TLongDoubleProcedure tLongDoubleProcedure);

    int size();

    void transformValues(TDoubleFunction tDoubleFunction);

    TDoubleCollection valueCollection();

    double[] values();

    double[] values(double[] dArr);
}
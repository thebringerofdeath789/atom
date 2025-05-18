package gnu.trove.map;

import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TDoubleLongIterator;
import gnu.trove.procedure.TDoubleLongProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TDoubleSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TDoubleLongMap {
    long adjustOrPutValue(double d, long j, long j2);

    boolean adjustValue(double d, long j);

    void clear();

    boolean containsKey(double d);

    boolean containsValue(long j);

    boolean forEachEntry(TDoubleLongProcedure tDoubleLongProcedure);

    boolean forEachKey(TDoubleProcedure tDoubleProcedure);

    boolean forEachValue(TLongProcedure tLongProcedure);

    long get(double d);

    double getNoEntryKey();

    long getNoEntryValue();

    boolean increment(double d);

    boolean isEmpty();

    TDoubleLongIterator iterator();

    TDoubleSet keySet();

    double[] keys();

    double[] keys(double[] dArr);

    long put(double d, long j);

    void putAll(TDoubleLongMap tDoubleLongMap);

    void putAll(Map<? extends Double, ? extends Long> map);

    long putIfAbsent(double d, long j);

    long remove(double d);

    boolean retainEntries(TDoubleLongProcedure tDoubleLongProcedure);

    int size();

    void transformValues(TLongFunction tLongFunction);

    TLongCollection valueCollection();

    long[] values();

    long[] values(long[] jArr);
}
package gnu.trove.map;

import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TLongLongIterator;
import gnu.trove.procedure.TLongLongProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TLongLongMap {
    long adjustOrPutValue(long j, long j2, long j3);

    boolean adjustValue(long j, long j2);

    void clear();

    boolean containsKey(long j);

    boolean containsValue(long j);

    boolean forEachEntry(TLongLongProcedure tLongLongProcedure);

    boolean forEachKey(TLongProcedure tLongProcedure);

    boolean forEachValue(TLongProcedure tLongProcedure);

    long get(long j);

    long getNoEntryKey();

    long getNoEntryValue();

    boolean increment(long j);

    boolean isEmpty();

    TLongLongIterator iterator();

    TLongSet keySet();

    long[] keys();

    long[] keys(long[] jArr);

    long put(long j, long j2);

    void putAll(TLongLongMap tLongLongMap);

    void putAll(Map<? extends Long, ? extends Long> map);

    long putIfAbsent(long j, long j2);

    long remove(long j);

    boolean retainEntries(TLongLongProcedure tLongLongProcedure);

    int size();

    void transformValues(TLongFunction tLongFunction);

    TLongCollection valueCollection();

    long[] values();

    long[] values(long[] jArr);
}
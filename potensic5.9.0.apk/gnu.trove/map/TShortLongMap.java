package gnu.trove.map;

import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TShortLongIterator;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.procedure.TShortLongProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TShortLongMap {
    long adjustOrPutValue(short s, long j, long j2);

    boolean adjustValue(short s, long j);

    void clear();

    boolean containsKey(short s);

    boolean containsValue(long j);

    boolean forEachEntry(TShortLongProcedure tShortLongProcedure);

    boolean forEachKey(TShortProcedure tShortProcedure);

    boolean forEachValue(TLongProcedure tLongProcedure);

    long get(short s);

    short getNoEntryKey();

    long getNoEntryValue();

    boolean increment(short s);

    boolean isEmpty();

    TShortLongIterator iterator();

    TShortSet keySet();

    short[] keys();

    short[] keys(short[] sArr);

    long put(short s, long j);

    void putAll(TShortLongMap tShortLongMap);

    void putAll(Map<? extends Short, ? extends Long> map);

    long putIfAbsent(short s, long j);

    long remove(short s);

    boolean retainEntries(TShortLongProcedure tShortLongProcedure);

    int size();

    void transformValues(TLongFunction tLongFunction);

    TLongCollection valueCollection();

    long[] values();

    long[] values(long[] jArr);
}
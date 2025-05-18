package gnu.trove.map;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TLongShortIterator;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.procedure.TLongShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TLongSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TLongShortMap {
    short adjustOrPutValue(long j, short s, short s2);

    boolean adjustValue(long j, short s);

    void clear();

    boolean containsKey(long j);

    boolean containsValue(short s);

    boolean forEachEntry(TLongShortProcedure tLongShortProcedure);

    boolean forEachKey(TLongProcedure tLongProcedure);

    boolean forEachValue(TShortProcedure tShortProcedure);

    short get(long j);

    long getNoEntryKey();

    short getNoEntryValue();

    boolean increment(long j);

    boolean isEmpty();

    TLongShortIterator iterator();

    TLongSet keySet();

    long[] keys();

    long[] keys(long[] jArr);

    short put(long j, short s);

    void putAll(TLongShortMap tLongShortMap);

    void putAll(Map<? extends Long, ? extends Short> map);

    short putIfAbsent(long j, short s);

    short remove(long j);

    boolean retainEntries(TLongShortProcedure tLongShortProcedure);

    int size();

    void transformValues(TShortFunction tShortFunction);

    TShortCollection valueCollection();

    short[] values();

    short[] values(short[] sArr);
}
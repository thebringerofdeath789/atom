package gnu.trove.map;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TLongIntIterator;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TLongIntProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TLongIntMap {
    int adjustOrPutValue(long j, int i, int i2);

    boolean adjustValue(long j, int i);

    void clear();

    boolean containsKey(long j);

    boolean containsValue(int i);

    boolean forEachEntry(TLongIntProcedure tLongIntProcedure);

    boolean forEachKey(TLongProcedure tLongProcedure);

    boolean forEachValue(TIntProcedure tIntProcedure);

    int get(long j);

    long getNoEntryKey();

    int getNoEntryValue();

    boolean increment(long j);

    boolean isEmpty();

    TLongIntIterator iterator();

    TLongSet keySet();

    long[] keys();

    long[] keys(long[] jArr);

    int put(long j, int i);

    void putAll(TLongIntMap tLongIntMap);

    void putAll(Map<? extends Long, ? extends Integer> map);

    int putIfAbsent(long j, int i);

    int remove(long j);

    boolean retainEntries(TLongIntProcedure tLongIntProcedure);

    int size();

    void transformValues(TIntFunction tIntFunction);

    TIntCollection valueCollection();

    int[] values();

    int[] values(int[] iArr);
}
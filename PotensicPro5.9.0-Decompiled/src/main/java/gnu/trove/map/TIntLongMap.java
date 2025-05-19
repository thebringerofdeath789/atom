package gnu.trove.map;

import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TIntLongIterator;
import gnu.trove.procedure.TIntLongProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TIntSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TIntLongMap {
    long adjustOrPutValue(int i, long j, long j2);

    boolean adjustValue(int i, long j);

    void clear();

    boolean containsKey(int i);

    boolean containsValue(long j);

    boolean forEachEntry(TIntLongProcedure tIntLongProcedure);

    boolean forEachKey(TIntProcedure tIntProcedure);

    boolean forEachValue(TLongProcedure tLongProcedure);

    long get(int i);

    int getNoEntryKey();

    long getNoEntryValue();

    boolean increment(int i);

    boolean isEmpty();

    TIntLongIterator iterator();

    TIntSet keySet();

    int[] keys();

    int[] keys(int[] iArr);

    long put(int i, long j);

    void putAll(TIntLongMap tIntLongMap);

    void putAll(Map<? extends Integer, ? extends Long> map);

    long putIfAbsent(int i, long j);

    long remove(int i);

    boolean retainEntries(TIntLongProcedure tIntLongProcedure);

    int size();

    void transformValues(TLongFunction tLongFunction);

    TLongCollection valueCollection();

    long[] values();

    long[] values(long[] jArr);
}

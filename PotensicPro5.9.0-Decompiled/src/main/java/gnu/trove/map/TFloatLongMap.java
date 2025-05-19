package gnu.trove.map;

import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TFloatLongIterator;
import gnu.trove.procedure.TFloatLongProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TFloatSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TFloatLongMap {
    long adjustOrPutValue(float f, long j, long j2);

    boolean adjustValue(float f, long j);

    void clear();

    boolean containsKey(float f);

    boolean containsValue(long j);

    boolean forEachEntry(TFloatLongProcedure tFloatLongProcedure);

    boolean forEachKey(TFloatProcedure tFloatProcedure);

    boolean forEachValue(TLongProcedure tLongProcedure);

    long get(float f);

    float getNoEntryKey();

    long getNoEntryValue();

    boolean increment(float f);

    boolean isEmpty();

    TFloatLongIterator iterator();

    TFloatSet keySet();

    float[] keys();

    float[] keys(float[] fArr);

    long put(float f, long j);

    void putAll(TFloatLongMap tFloatLongMap);

    void putAll(Map<? extends Float, ? extends Long> map);

    long putIfAbsent(float f, long j);

    long remove(float f);

    boolean retainEntries(TFloatLongProcedure tFloatLongProcedure);

    int size();

    void transformValues(TLongFunction tLongFunction);

    TLongCollection valueCollection();

    long[] values();

    long[] values(long[] jArr);
}

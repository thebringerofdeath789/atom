package gnu.trove.map;

import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TByteLongIterator;
import gnu.trove.procedure.TByteLongProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TByteSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TByteLongMap {
    long adjustOrPutValue(byte b, long j, long j2);

    boolean adjustValue(byte b, long j);

    void clear();

    boolean containsKey(byte b);

    boolean containsValue(long j);

    boolean forEachEntry(TByteLongProcedure tByteLongProcedure);

    boolean forEachKey(TByteProcedure tByteProcedure);

    boolean forEachValue(TLongProcedure tLongProcedure);

    long get(byte b);

    byte getNoEntryKey();

    long getNoEntryValue();

    boolean increment(byte b);

    boolean isEmpty();

    TByteLongIterator iterator();

    TByteSet keySet();

    byte[] keys();

    byte[] keys(byte[] bArr);

    long put(byte b, long j);

    void putAll(TByteLongMap tByteLongMap);

    void putAll(Map<? extends Byte, ? extends Long> map);

    long putIfAbsent(byte b, long j);

    long remove(byte b);

    boolean retainEntries(TByteLongProcedure tByteLongProcedure);

    int size();

    void transformValues(TLongFunction tLongFunction);

    TLongCollection valueCollection();

    long[] values();

    long[] values(long[] jArr);
}
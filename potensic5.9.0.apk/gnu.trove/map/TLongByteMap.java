package gnu.trove.map;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TLongByteIterator;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TLongByteProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TLongByteMap {
    byte adjustOrPutValue(long j, byte b, byte b2);

    boolean adjustValue(long j, byte b);

    void clear();

    boolean containsKey(long j);

    boolean containsValue(byte b);

    boolean forEachEntry(TLongByteProcedure tLongByteProcedure);

    boolean forEachKey(TLongProcedure tLongProcedure);

    boolean forEachValue(TByteProcedure tByteProcedure);

    byte get(long j);

    long getNoEntryKey();

    byte getNoEntryValue();

    boolean increment(long j);

    boolean isEmpty();

    TLongByteIterator iterator();

    TLongSet keySet();

    long[] keys();

    long[] keys(long[] jArr);

    byte put(long j, byte b);

    void putAll(TLongByteMap tLongByteMap);

    void putAll(Map<? extends Long, ? extends Byte> map);

    byte putIfAbsent(long j, byte b);

    byte remove(long j);

    boolean retainEntries(TLongByteProcedure tLongByteProcedure);

    int size();

    void transformValues(TByteFunction tByteFunction);

    TByteCollection valueCollection();

    byte[] values();

    byte[] values(byte[] bArr);
}
package gnu.trove.map;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TByteShortIterator;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TByteShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TByteSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TByteShortMap {
    short adjustOrPutValue(byte b, short s, short s2);

    boolean adjustValue(byte b, short s);

    void clear();

    boolean containsKey(byte b);

    boolean containsValue(short s);

    boolean forEachEntry(TByteShortProcedure tByteShortProcedure);

    boolean forEachKey(TByteProcedure tByteProcedure);

    boolean forEachValue(TShortProcedure tShortProcedure);

    short get(byte b);

    byte getNoEntryKey();

    short getNoEntryValue();

    boolean increment(byte b);

    boolean isEmpty();

    TByteShortIterator iterator();

    TByteSet keySet();

    byte[] keys();

    byte[] keys(byte[] bArr);

    short put(byte b, short s);

    void putAll(TByteShortMap tByteShortMap);

    void putAll(Map<? extends Byte, ? extends Short> map);

    short putIfAbsent(byte b, short s);

    short remove(byte b);

    boolean retainEntries(TByteShortProcedure tByteShortProcedure);

    int size();

    void transformValues(TShortFunction tShortFunction);

    TShortCollection valueCollection();

    short[] values();

    short[] values(short[] sArr);
}
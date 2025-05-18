package gnu.trove.map;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TShortByteIterator;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TShortByteProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TShortByteMap {
    byte adjustOrPutValue(short s, byte b, byte b2);

    boolean adjustValue(short s, byte b);

    void clear();

    boolean containsKey(short s);

    boolean containsValue(byte b);

    boolean forEachEntry(TShortByteProcedure tShortByteProcedure);

    boolean forEachKey(TShortProcedure tShortProcedure);

    boolean forEachValue(TByteProcedure tByteProcedure);

    byte get(short s);

    short getNoEntryKey();

    byte getNoEntryValue();

    boolean increment(short s);

    boolean isEmpty();

    TShortByteIterator iterator();

    TShortSet keySet();

    short[] keys();

    short[] keys(short[] sArr);

    byte put(short s, byte b);

    void putAll(TShortByteMap tShortByteMap);

    void putAll(Map<? extends Short, ? extends Byte> map);

    byte putIfAbsent(short s, byte b);

    byte remove(short s);

    boolean retainEntries(TShortByteProcedure tShortByteProcedure);

    int size();

    void transformValues(TByteFunction tByteFunction);

    TByteCollection valueCollection();

    byte[] values();

    byte[] values(byte[] bArr);
}
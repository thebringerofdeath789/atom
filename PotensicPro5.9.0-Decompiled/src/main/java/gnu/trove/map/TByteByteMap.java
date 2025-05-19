package gnu.trove.map;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TByteByteIterator;
import gnu.trove.procedure.TByteByteProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.set.TByteSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TByteByteMap {
    byte adjustOrPutValue(byte b, byte b2, byte b3);

    boolean adjustValue(byte b, byte b2);

    void clear();

    boolean containsKey(byte b);

    boolean containsValue(byte b);

    boolean forEachEntry(TByteByteProcedure tByteByteProcedure);

    boolean forEachKey(TByteProcedure tByteProcedure);

    boolean forEachValue(TByteProcedure tByteProcedure);

    byte get(byte b);

    byte getNoEntryKey();

    byte getNoEntryValue();

    boolean increment(byte b);

    boolean isEmpty();

    TByteByteIterator iterator();

    TByteSet keySet();

    byte[] keys();

    byte[] keys(byte[] bArr);

    byte put(byte b, byte b2);

    void putAll(TByteByteMap tByteByteMap);

    void putAll(Map<? extends Byte, ? extends Byte> map);

    byte putIfAbsent(byte b, byte b2);

    byte remove(byte b);

    boolean retainEntries(TByteByteProcedure tByteByteProcedure);

    int size();

    void transformValues(TByteFunction tByteFunction);

    TByteCollection valueCollection();

    byte[] values();

    byte[] values(byte[] bArr);
}

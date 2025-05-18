package gnu.trove.map;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TIntByteIterator;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TIntByteProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TIntSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TIntByteMap {
    byte adjustOrPutValue(int i, byte b, byte b2);

    boolean adjustValue(int i, byte b);

    void clear();

    boolean containsKey(int i);

    boolean containsValue(byte b);

    boolean forEachEntry(TIntByteProcedure tIntByteProcedure);

    boolean forEachKey(TIntProcedure tIntProcedure);

    boolean forEachValue(TByteProcedure tByteProcedure);

    byte get(int i);

    int getNoEntryKey();

    byte getNoEntryValue();

    boolean increment(int i);

    boolean isEmpty();

    TIntByteIterator iterator();

    TIntSet keySet();

    int[] keys();

    int[] keys(int[] iArr);

    byte put(int i, byte b);

    void putAll(TIntByteMap tIntByteMap);

    void putAll(Map<? extends Integer, ? extends Byte> map);

    byte putIfAbsent(int i, byte b);

    byte remove(int i);

    boolean retainEntries(TIntByteProcedure tIntByteProcedure);

    int size();

    void transformValues(TByteFunction tByteFunction);

    TByteCollection valueCollection();

    byte[] values();

    byte[] values(byte[] bArr);
}
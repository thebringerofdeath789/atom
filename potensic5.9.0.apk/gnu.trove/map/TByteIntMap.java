package gnu.trove.map;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TByteIntIterator;
import gnu.trove.procedure.TByteIntProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TByteSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TByteIntMap {
    int adjustOrPutValue(byte b, int i, int i2);

    boolean adjustValue(byte b, int i);

    void clear();

    boolean containsKey(byte b);

    boolean containsValue(int i);

    boolean forEachEntry(TByteIntProcedure tByteIntProcedure);

    boolean forEachKey(TByteProcedure tByteProcedure);

    boolean forEachValue(TIntProcedure tIntProcedure);

    int get(byte b);

    byte getNoEntryKey();

    int getNoEntryValue();

    boolean increment(byte b);

    boolean isEmpty();

    TByteIntIterator iterator();

    TByteSet keySet();

    byte[] keys();

    byte[] keys(byte[] bArr);

    int put(byte b, int i);

    void putAll(TByteIntMap tByteIntMap);

    void putAll(Map<? extends Byte, ? extends Integer> map);

    int putIfAbsent(byte b, int i);

    int remove(byte b);

    boolean retainEntries(TByteIntProcedure tByteIntProcedure);

    int size();

    void transformValues(TIntFunction tIntFunction);

    TIntCollection valueCollection();

    int[] values();

    int[] values(int[] iArr);
}
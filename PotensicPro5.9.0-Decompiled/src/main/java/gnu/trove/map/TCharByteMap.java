package gnu.trove.map;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TCharByteIterator;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TCharByteProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.set.TCharSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TCharByteMap {
    byte adjustOrPutValue(char c, byte b, byte b2);

    boolean adjustValue(char c, byte b);

    void clear();

    boolean containsKey(char c);

    boolean containsValue(byte b);

    boolean forEachEntry(TCharByteProcedure tCharByteProcedure);

    boolean forEachKey(TCharProcedure tCharProcedure);

    boolean forEachValue(TByteProcedure tByteProcedure);

    byte get(char c);

    char getNoEntryKey();

    byte getNoEntryValue();

    boolean increment(char c);

    boolean isEmpty();

    TCharByteIterator iterator();

    TCharSet keySet();

    char[] keys();

    char[] keys(char[] cArr);

    byte put(char c, byte b);

    void putAll(TCharByteMap tCharByteMap);

    void putAll(Map<? extends Character, ? extends Byte> map);

    byte putIfAbsent(char c, byte b);

    byte remove(char c);

    boolean retainEntries(TCharByteProcedure tCharByteProcedure);

    int size();

    void transformValues(TByteFunction tByteFunction);

    TByteCollection valueCollection();

    byte[] values();

    byte[] values(byte[] bArr);
}

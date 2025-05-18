package gnu.trove.map;

import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TByteCharIterator;
import gnu.trove.procedure.TByteCharProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.set.TByteSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TByteCharMap {
    char adjustOrPutValue(byte b, char c, char c2);

    boolean adjustValue(byte b, char c);

    void clear();

    boolean containsKey(byte b);

    boolean containsValue(char c);

    boolean forEachEntry(TByteCharProcedure tByteCharProcedure);

    boolean forEachKey(TByteProcedure tByteProcedure);

    boolean forEachValue(TCharProcedure tCharProcedure);

    char get(byte b);

    byte getNoEntryKey();

    char getNoEntryValue();

    boolean increment(byte b);

    boolean isEmpty();

    TByteCharIterator iterator();

    TByteSet keySet();

    byte[] keys();

    byte[] keys(byte[] bArr);

    char put(byte b, char c);

    void putAll(TByteCharMap tByteCharMap);

    void putAll(Map<? extends Byte, ? extends Character> map);

    char putIfAbsent(byte b, char c);

    char remove(byte b);

    boolean retainEntries(TByteCharProcedure tByteCharProcedure);

    int size();

    void transformValues(TCharFunction tCharFunction);

    TCharCollection valueCollection();

    char[] values();

    char[] values(char[] cArr);
}
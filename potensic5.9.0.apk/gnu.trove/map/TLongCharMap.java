package gnu.trove.map;

import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TLongCharIterator;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TLongCharProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TLongCharMap {
    char adjustOrPutValue(long j, char c, char c2);

    boolean adjustValue(long j, char c);

    void clear();

    boolean containsKey(long j);

    boolean containsValue(char c);

    boolean forEachEntry(TLongCharProcedure tLongCharProcedure);

    boolean forEachKey(TLongProcedure tLongProcedure);

    boolean forEachValue(TCharProcedure tCharProcedure);

    char get(long j);

    long getNoEntryKey();

    char getNoEntryValue();

    boolean increment(long j);

    boolean isEmpty();

    TLongCharIterator iterator();

    TLongSet keySet();

    long[] keys();

    long[] keys(long[] jArr);

    char put(long j, char c);

    void putAll(TLongCharMap tLongCharMap);

    void putAll(Map<? extends Long, ? extends Character> map);

    char putIfAbsent(long j, char c);

    char remove(long j);

    boolean retainEntries(TLongCharProcedure tLongCharProcedure);

    int size();

    void transformValues(TCharFunction tCharFunction);

    TCharCollection valueCollection();

    char[] values();

    char[] values(char[] cArr);
}
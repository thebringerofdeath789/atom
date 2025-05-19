package gnu.trove.map;

import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TCharLongIterator;
import gnu.trove.procedure.TCharLongProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TCharSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TCharLongMap {
    long adjustOrPutValue(char c, long j, long j2);

    boolean adjustValue(char c, long j);

    void clear();

    boolean containsKey(char c);

    boolean containsValue(long j);

    boolean forEachEntry(TCharLongProcedure tCharLongProcedure);

    boolean forEachKey(TCharProcedure tCharProcedure);

    boolean forEachValue(TLongProcedure tLongProcedure);

    long get(char c);

    char getNoEntryKey();

    long getNoEntryValue();

    boolean increment(char c);

    boolean isEmpty();

    TCharLongIterator iterator();

    TCharSet keySet();

    char[] keys();

    char[] keys(char[] cArr);

    long put(char c, long j);

    void putAll(TCharLongMap tCharLongMap);

    void putAll(Map<? extends Character, ? extends Long> map);

    long putIfAbsent(char c, long j);

    long remove(char c);

    boolean retainEntries(TCharLongProcedure tCharLongProcedure);

    int size();

    void transformValues(TLongFunction tLongFunction);

    TLongCollection valueCollection();

    long[] values();

    long[] values(long[] jArr);
}

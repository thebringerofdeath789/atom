package gnu.trove.map;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TCharShortIterator;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TCharShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TCharSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TCharShortMap {
    short adjustOrPutValue(char c, short s, short s2);

    boolean adjustValue(char c, short s);

    void clear();

    boolean containsKey(char c);

    boolean containsValue(short s);

    boolean forEachEntry(TCharShortProcedure tCharShortProcedure);

    boolean forEachKey(TCharProcedure tCharProcedure);

    boolean forEachValue(TShortProcedure tShortProcedure);

    short get(char c);

    char getNoEntryKey();

    short getNoEntryValue();

    boolean increment(char c);

    boolean isEmpty();

    TCharShortIterator iterator();

    TCharSet keySet();

    char[] keys();

    char[] keys(char[] cArr);

    short put(char c, short s);

    void putAll(TCharShortMap tCharShortMap);

    void putAll(Map<? extends Character, ? extends Short> map);

    short putIfAbsent(char c, short s);

    short remove(char c);

    boolean retainEntries(TCharShortProcedure tCharShortProcedure);

    int size();

    void transformValues(TShortFunction tShortFunction);

    TShortCollection valueCollection();

    short[] values();

    short[] values(short[] sArr);
}
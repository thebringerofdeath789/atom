package gnu.trove.map;

import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TShortCharIterator;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TShortCharProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TShortCharMap {
    char adjustOrPutValue(short s, char c, char c2);

    boolean adjustValue(short s, char c);

    void clear();

    boolean containsKey(short s);

    boolean containsValue(char c);

    boolean forEachEntry(TShortCharProcedure tShortCharProcedure);

    boolean forEachKey(TShortProcedure tShortProcedure);

    boolean forEachValue(TCharProcedure tCharProcedure);

    char get(short s);

    short getNoEntryKey();

    char getNoEntryValue();

    boolean increment(short s);

    boolean isEmpty();

    TShortCharIterator iterator();

    TShortSet keySet();

    short[] keys();

    short[] keys(short[] sArr);

    char put(short s, char c);

    void putAll(TShortCharMap tShortCharMap);

    void putAll(Map<? extends Short, ? extends Character> map);

    char putIfAbsent(short s, char c);

    char remove(short s);

    boolean retainEntries(TShortCharProcedure tShortCharProcedure);

    int size();

    void transformValues(TCharFunction tCharFunction);

    TCharCollection valueCollection();

    char[] values();

    char[] values(char[] cArr);
}

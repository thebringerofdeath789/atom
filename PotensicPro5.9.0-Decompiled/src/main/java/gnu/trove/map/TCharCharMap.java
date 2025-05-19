package gnu.trove.map;

import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TCharCharIterator;
import gnu.trove.procedure.TCharCharProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.set.TCharSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TCharCharMap {
    char adjustOrPutValue(char c, char c2, char c3);

    boolean adjustValue(char c, char c2);

    void clear();

    boolean containsKey(char c);

    boolean containsValue(char c);

    boolean forEachEntry(TCharCharProcedure tCharCharProcedure);

    boolean forEachKey(TCharProcedure tCharProcedure);

    boolean forEachValue(TCharProcedure tCharProcedure);

    char get(char c);

    char getNoEntryKey();

    char getNoEntryValue();

    boolean increment(char c);

    boolean isEmpty();

    TCharCharIterator iterator();

    TCharSet keySet();

    char[] keys();

    char[] keys(char[] cArr);

    char put(char c, char c2);

    void putAll(TCharCharMap tCharCharMap);

    void putAll(Map<? extends Character, ? extends Character> map);

    char putIfAbsent(char c, char c2);

    char remove(char c);

    boolean retainEntries(TCharCharProcedure tCharCharProcedure);

    int size();

    void transformValues(TCharFunction tCharFunction);

    TCharCollection valueCollection();

    char[] values();

    char[] values(char[] cArr);
}

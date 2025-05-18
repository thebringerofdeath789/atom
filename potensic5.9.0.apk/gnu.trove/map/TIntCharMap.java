package gnu.trove.map;

import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TIntCharIterator;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TIntCharProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TIntSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TIntCharMap {
    char adjustOrPutValue(int i, char c, char c2);

    boolean adjustValue(int i, char c);

    void clear();

    boolean containsKey(int i);

    boolean containsValue(char c);

    boolean forEachEntry(TIntCharProcedure tIntCharProcedure);

    boolean forEachKey(TIntProcedure tIntProcedure);

    boolean forEachValue(TCharProcedure tCharProcedure);

    char get(int i);

    int getNoEntryKey();

    char getNoEntryValue();

    boolean increment(int i);

    boolean isEmpty();

    TIntCharIterator iterator();

    TIntSet keySet();

    int[] keys();

    int[] keys(int[] iArr);

    char put(int i, char c);

    void putAll(TIntCharMap tIntCharMap);

    void putAll(Map<? extends Integer, ? extends Character> map);

    char putIfAbsent(int i, char c);

    char remove(int i);

    boolean retainEntries(TIntCharProcedure tIntCharProcedure);

    int size();

    void transformValues(TCharFunction tCharFunction);

    TCharCollection valueCollection();

    char[] values();

    char[] values(char[] cArr);
}
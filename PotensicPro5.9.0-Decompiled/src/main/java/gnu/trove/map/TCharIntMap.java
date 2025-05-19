package gnu.trove.map;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TCharIntIterator;
import gnu.trove.procedure.TCharIntProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TCharSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TCharIntMap {
    int adjustOrPutValue(char c, int i, int i2);

    boolean adjustValue(char c, int i);

    void clear();

    boolean containsKey(char c);

    boolean containsValue(int i);

    boolean forEachEntry(TCharIntProcedure tCharIntProcedure);

    boolean forEachKey(TCharProcedure tCharProcedure);

    boolean forEachValue(TIntProcedure tIntProcedure);

    int get(char c);

    char getNoEntryKey();

    int getNoEntryValue();

    boolean increment(char c);

    boolean isEmpty();

    TCharIntIterator iterator();

    TCharSet keySet();

    char[] keys();

    char[] keys(char[] cArr);

    int put(char c, int i);

    void putAll(TCharIntMap tCharIntMap);

    void putAll(Map<? extends Character, ? extends Integer> map);

    int putIfAbsent(char c, int i);

    int remove(char c);

    boolean retainEntries(TCharIntProcedure tCharIntProcedure);

    int size();

    void transformValues(TIntFunction tIntFunction);

    TIntCollection valueCollection();

    int[] values();

    int[] values(int[] iArr);
}

package gnu.trove.map;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TShortIntIterator;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TShortIntProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TShortIntMap {
    int adjustOrPutValue(short s, int i, int i2);

    boolean adjustValue(short s, int i);

    void clear();

    boolean containsKey(short s);

    boolean containsValue(int i);

    boolean forEachEntry(TShortIntProcedure tShortIntProcedure);

    boolean forEachKey(TShortProcedure tShortProcedure);

    boolean forEachValue(TIntProcedure tIntProcedure);

    int get(short s);

    short getNoEntryKey();

    int getNoEntryValue();

    boolean increment(short s);

    boolean isEmpty();

    TShortIntIterator iterator();

    TShortSet keySet();

    short[] keys();

    short[] keys(short[] sArr);

    int put(short s, int i);

    void putAll(TShortIntMap tShortIntMap);

    void putAll(Map<? extends Short, ? extends Integer> map);

    int putIfAbsent(short s, int i);

    int remove(short s);

    boolean retainEntries(TShortIntProcedure tShortIntProcedure);

    int size();

    void transformValues(TIntFunction tIntFunction);

    TIntCollection valueCollection();

    int[] values();

    int[] values(int[] iArr);
}
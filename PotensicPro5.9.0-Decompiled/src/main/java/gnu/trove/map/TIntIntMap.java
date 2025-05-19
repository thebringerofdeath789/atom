package gnu.trove.map;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TIntIntIterator;
import gnu.trove.procedure.TIntIntProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TIntSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TIntIntMap {
    int adjustOrPutValue(int i, int i2, int i3);

    boolean adjustValue(int i, int i2);

    void clear();

    boolean containsKey(int i);

    boolean containsValue(int i);

    boolean forEachEntry(TIntIntProcedure tIntIntProcedure);

    boolean forEachKey(TIntProcedure tIntProcedure);

    boolean forEachValue(TIntProcedure tIntProcedure);

    int get(int i);

    int getNoEntryKey();

    int getNoEntryValue();

    boolean increment(int i);

    boolean isEmpty();

    TIntIntIterator iterator();

    TIntSet keySet();

    int[] keys();

    int[] keys(int[] iArr);

    int put(int i, int i2);

    void putAll(TIntIntMap tIntIntMap);

    void putAll(Map<? extends Integer, ? extends Integer> map);

    int putIfAbsent(int i, int i2);

    int remove(int i);

    boolean retainEntries(TIntIntProcedure tIntIntProcedure);

    int size();

    void transformValues(TIntFunction tIntFunction);

    TIntCollection valueCollection();

    int[] values();

    int[] values(int[] iArr);
}

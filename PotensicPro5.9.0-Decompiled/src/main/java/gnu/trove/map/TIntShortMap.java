package gnu.trove.map;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TIntShortIterator;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TIntShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TIntSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TIntShortMap {
    short adjustOrPutValue(int i, short s, short s2);

    boolean adjustValue(int i, short s);

    void clear();

    boolean containsKey(int i);

    boolean containsValue(short s);

    boolean forEachEntry(TIntShortProcedure tIntShortProcedure);

    boolean forEachKey(TIntProcedure tIntProcedure);

    boolean forEachValue(TShortProcedure tShortProcedure);

    short get(int i);

    int getNoEntryKey();

    short getNoEntryValue();

    boolean increment(int i);

    boolean isEmpty();

    TIntShortIterator iterator();

    TIntSet keySet();

    int[] keys();

    int[] keys(int[] iArr);

    short put(int i, short s);

    void putAll(TIntShortMap tIntShortMap);

    void putAll(Map<? extends Integer, ? extends Short> map);

    short putIfAbsent(int i, short s);

    short remove(int i);

    boolean retainEntries(TIntShortProcedure tIntShortProcedure);

    int size();

    void transformValues(TShortFunction tShortFunction);

    TShortCollection valueCollection();

    short[] values();

    short[] values(short[] sArr);
}

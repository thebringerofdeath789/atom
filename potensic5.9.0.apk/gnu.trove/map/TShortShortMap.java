package gnu.trove.map;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TShortShortIterator;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.procedure.TShortShortProcedure;
import gnu.trove.set.TShortSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TShortShortMap {
    short adjustOrPutValue(short s, short s2, short s3);

    boolean adjustValue(short s, short s2);

    void clear();

    boolean containsKey(short s);

    boolean containsValue(short s);

    boolean forEachEntry(TShortShortProcedure tShortShortProcedure);

    boolean forEachKey(TShortProcedure tShortProcedure);

    boolean forEachValue(TShortProcedure tShortProcedure);

    short get(short s);

    short getNoEntryKey();

    short getNoEntryValue();

    boolean increment(short s);

    boolean isEmpty();

    TShortShortIterator iterator();

    TShortSet keySet();

    short[] keys();

    short[] keys(short[] sArr);

    short put(short s, short s2);

    void putAll(TShortShortMap tShortShortMap);

    void putAll(Map<? extends Short, ? extends Short> map);

    short putIfAbsent(short s, short s2);

    short remove(short s);

    boolean retainEntries(TShortShortProcedure tShortShortProcedure);

    int size();

    void transformValues(TShortFunction tShortFunction);

    TShortCollection valueCollection();

    short[] values();

    short[] values(short[] sArr);
}
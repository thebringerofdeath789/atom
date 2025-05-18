package gnu.trove.map;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TDoubleShortIterator;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TDoubleShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TDoubleSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TDoubleShortMap {
    short adjustOrPutValue(double d, short s, short s2);

    boolean adjustValue(double d, short s);

    void clear();

    boolean containsKey(double d);

    boolean containsValue(short s);

    boolean forEachEntry(TDoubleShortProcedure tDoubleShortProcedure);

    boolean forEachKey(TDoubleProcedure tDoubleProcedure);

    boolean forEachValue(TShortProcedure tShortProcedure);

    short get(double d);

    double getNoEntryKey();

    short getNoEntryValue();

    boolean increment(double d);

    boolean isEmpty();

    TDoubleShortIterator iterator();

    TDoubleSet keySet();

    double[] keys();

    double[] keys(double[] dArr);

    short put(double d, short s);

    void putAll(TDoubleShortMap tDoubleShortMap);

    void putAll(Map<? extends Double, ? extends Short> map);

    short putIfAbsent(double d, short s);

    short remove(double d);

    boolean retainEntries(TDoubleShortProcedure tDoubleShortProcedure);

    int size();

    void transformValues(TShortFunction tShortFunction);

    TShortCollection valueCollection();

    short[] values();

    short[] values(short[] sArr);
}
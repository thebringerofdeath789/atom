package gnu.trove.map;

import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TShortDoubleIterator;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TShortDoubleProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TShortDoubleMap {
    double adjustOrPutValue(short s, double d, double d2);

    boolean adjustValue(short s, double d);

    void clear();

    boolean containsKey(short s);

    boolean containsValue(double d);

    boolean forEachEntry(TShortDoubleProcedure tShortDoubleProcedure);

    boolean forEachKey(TShortProcedure tShortProcedure);

    boolean forEachValue(TDoubleProcedure tDoubleProcedure);

    double get(short s);

    short getNoEntryKey();

    double getNoEntryValue();

    boolean increment(short s);

    boolean isEmpty();

    TShortDoubleIterator iterator();

    TShortSet keySet();

    short[] keys();

    short[] keys(short[] sArr);

    double put(short s, double d);

    void putAll(TShortDoubleMap tShortDoubleMap);

    void putAll(Map<? extends Short, ? extends Double> map);

    double putIfAbsent(short s, double d);

    double remove(short s);

    boolean retainEntries(TShortDoubleProcedure tShortDoubleProcedure);

    int size();

    void transformValues(TDoubleFunction tDoubleFunction);

    TDoubleCollection valueCollection();

    double[] values();

    double[] values(double[] dArr);
}

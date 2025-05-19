package gnu.trove.map;

import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TCharDoubleIterator;
import gnu.trove.procedure.TCharDoubleProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.set.TCharSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TCharDoubleMap {
    double adjustOrPutValue(char c, double d, double d2);

    boolean adjustValue(char c, double d);

    void clear();

    boolean containsKey(char c);

    boolean containsValue(double d);

    boolean forEachEntry(TCharDoubleProcedure tCharDoubleProcedure);

    boolean forEachKey(TCharProcedure tCharProcedure);

    boolean forEachValue(TDoubleProcedure tDoubleProcedure);

    double get(char c);

    char getNoEntryKey();

    double getNoEntryValue();

    boolean increment(char c);

    boolean isEmpty();

    TCharDoubleIterator iterator();

    TCharSet keySet();

    char[] keys();

    char[] keys(char[] cArr);

    double put(char c, double d);

    void putAll(TCharDoubleMap tCharDoubleMap);

    void putAll(Map<? extends Character, ? extends Double> map);

    double putIfAbsent(char c, double d);

    double remove(char c);

    boolean retainEntries(TCharDoubleProcedure tCharDoubleProcedure);

    int size();

    void transformValues(TDoubleFunction tDoubleFunction);

    TDoubleCollection valueCollection();

    double[] values();

    double[] values(double[] dArr);
}

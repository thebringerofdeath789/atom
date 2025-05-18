package gnu.trove.map;

import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TDoubleCharIterator;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TDoubleCharProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.set.TDoubleSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TDoubleCharMap {
    char adjustOrPutValue(double d, char c, char c2);

    boolean adjustValue(double d, char c);

    void clear();

    boolean containsKey(double d);

    boolean containsValue(char c);

    boolean forEachEntry(TDoubleCharProcedure tDoubleCharProcedure);

    boolean forEachKey(TDoubleProcedure tDoubleProcedure);

    boolean forEachValue(TCharProcedure tCharProcedure);

    char get(double d);

    double getNoEntryKey();

    char getNoEntryValue();

    boolean increment(double d);

    boolean isEmpty();

    TDoubleCharIterator iterator();

    TDoubleSet keySet();

    double[] keys();

    double[] keys(double[] dArr);

    char put(double d, char c);

    void putAll(TDoubleCharMap tDoubleCharMap);

    void putAll(Map<? extends Double, ? extends Character> map);

    char putIfAbsent(double d, char c);

    char remove(double d);

    boolean retainEntries(TDoubleCharProcedure tDoubleCharProcedure);

    int size();

    void transformValues(TCharFunction tCharFunction);

    TCharCollection valueCollection();

    char[] values();

    char[] values(char[] cArr);
}
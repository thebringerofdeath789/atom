package gnu.trove.map;

import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TObjectDoubleIterator;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TObjectDoubleProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public interface TObjectDoubleMap<K> {
    double adjustOrPutValue(K k, double d, double d2);

    boolean adjustValue(K k, double d);

    void clear();

    boolean containsKey(Object obj);

    boolean containsValue(double d);

    boolean equals(Object obj);

    boolean forEachEntry(TObjectDoubleProcedure<? super K> tObjectDoubleProcedure);

    boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure);

    boolean forEachValue(TDoubleProcedure tDoubleProcedure);

    double get(Object obj);

    double getNoEntryValue();

    int hashCode();

    boolean increment(K k);

    boolean isEmpty();

    TObjectDoubleIterator<K> iterator();

    Set<K> keySet();

    Object[] keys();

    K[] keys(K[] kArr);

    double put(K k, double d);

    void putAll(TObjectDoubleMap<? extends K> tObjectDoubleMap);

    void putAll(Map<? extends K, ? extends Double> map);

    double putIfAbsent(K k, double d);

    double remove(Object obj);

    boolean retainEntries(TObjectDoubleProcedure<? super K> tObjectDoubleProcedure);

    int size();

    void transformValues(TDoubleFunction tDoubleFunction);

    TDoubleCollection valueCollection();

    double[] values();

    double[] values(double[] dArr);
}

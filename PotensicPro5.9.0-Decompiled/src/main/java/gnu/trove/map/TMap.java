package gnu.trove.map;

import gnu.trove.function.TObjectFunction;
import gnu.trove.procedure.TObjectObjectProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TMap<K, V> extends Map<K, V> {
    boolean forEachEntry(TObjectObjectProcedure<? super K, ? super V> tObjectObjectProcedure);

    boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure);

    boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure);

    @Override // java.util.Map
    V putIfAbsent(K k, V v);

    boolean retainEntries(TObjectObjectProcedure<? super K, ? super V> tObjectObjectProcedure);

    void transformValues(TObjectFunction<V, V> tObjectFunction);
}

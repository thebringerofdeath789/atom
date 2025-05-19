package org.apache.commons.collections4;

import java.util.Collection;
import java.util.List;

/* loaded from: classes4.dex */
public interface ListValuedMap<K, V> extends MultiValuedMap<K, V> {
    @Override // org.apache.commons.collections4.MultiValuedMap
    List<V> get(K k);

    @Override // org.apache.commons.collections4.MultiValuedMap
    List<V> remove(Object obj);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.MultiValuedMap
    /* bridge */ /* synthetic */ default Collection get(Object obj) {
        return get((ListValuedMap<K, V>) obj);
    }
}

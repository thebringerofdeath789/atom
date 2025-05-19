package org.apache.commons.collections4.multimap;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FluentIterable;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Transformer;

/* loaded from: classes4.dex */
public class TransformedMultiValuedMap<K, V> extends AbstractMultiValuedMapDecorator<K, V> {
    private static final long serialVersionUID = 20150612;
    private final Transformer<? super K, ? extends K> keyTransformer;
    private final Transformer<? super V, ? extends V> valueTransformer;

    public static <K, V> TransformedMultiValuedMap<K, V> transformingMap(MultiValuedMap<K, V> multiValuedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return new TransformedMultiValuedMap<>(multiValuedMap, transformer, transformer2);
    }

    public static <K, V> TransformedMultiValuedMap<K, V> transformedMap(MultiValuedMap<K, V> multiValuedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        TransformedMultiValuedMap<K, V> transformedMultiValuedMap = new TransformedMultiValuedMap<>(multiValuedMap, transformer, transformer2);
        if (!multiValuedMap.isEmpty()) {
            ArrayListValuedHashMap arrayListValuedHashMap = new ArrayListValuedHashMap(multiValuedMap);
            transformedMultiValuedMap.clear();
            transformedMultiValuedMap.putAll(arrayListValuedHashMap);
        }
        return transformedMultiValuedMap;
    }

    protected TransformedMultiValuedMap(MultiValuedMap<K, V> multiValuedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        super(multiValuedMap);
        this.keyTransformer = transformer;
        this.valueTransformer = transformer2;
    }

    protected K transformKey(K k) {
        Transformer<? super K, ? extends K> transformer = this.keyTransformer;
        return transformer == null ? k : transformer.transform(k);
    }

    protected V transformValue(V v) {
        Transformer<? super V, ? extends V> transformer = this.valueTransformer;
        return transformer == null ? v : transformer.transform(v);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean put(K k, V v) {
        return decorated().put(transformKey(k), transformValue(v));
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        Objects.requireNonNull(iterable, "Values must not be null.");
        Iterator<E> it = FluentIterable.of((Iterable) iterable).transform(this.valueTransformer).iterator();
        return it.hasNext() && CollectionUtils.addAll(decorated().get(transformKey(k)), it);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(Map<? extends K, ? extends V> map) {
        Objects.requireNonNull(map, "Map must not be null.");
        boolean z = false;
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            z |= put(entry.getKey(), entry.getValue());
        }
        return z;
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(MultiValuedMap<? extends K, ? extends V> multiValuedMap) {
        Objects.requireNonNull(multiValuedMap, "Map must not be null.");
        boolean z = false;
        for (Map.Entry<? extends K, ? extends V> entry : multiValuedMap.entries()) {
            z |= put(entry.getKey(), entry.getValue());
        }
        return z;
    }
}

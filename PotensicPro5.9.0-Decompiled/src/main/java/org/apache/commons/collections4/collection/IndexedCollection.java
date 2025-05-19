package org.apache.commons.collections4.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.MultiValueMap;

/* loaded from: classes4.dex */
public class IndexedCollection<K, C> extends AbstractCollectionDecorator<C> {
    private static final long serialVersionUID = -5512610452568370038L;
    private final MultiMap<K, C> index;
    private final Transformer<C, K> keyTransformer;
    private final boolean uniqueIndex;

    public static <K, C> IndexedCollection<K, C> uniqueIndexedCollection(Collection<C> collection, Transformer<C, K> transformer) {
        return new IndexedCollection<>(collection, transformer, MultiValueMap.multiValueMap(new HashMap()), true);
    }

    public static <K, C> IndexedCollection<K, C> nonUniqueIndexedCollection(Collection<C> collection, Transformer<C, K> transformer) {
        return new IndexedCollection<>(collection, transformer, MultiValueMap.multiValueMap(new HashMap()), false);
    }

    public IndexedCollection(Collection<C> collection, Transformer<C, K> transformer, MultiMap<K, C> multiMap, boolean z) {
        super(collection);
        this.keyTransformer = transformer;
        this.index = multiMap;
        this.uniqueIndex = z;
        reindex();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(C c) {
        boolean add = super.add(c);
        if (add) {
            addToIndex(c);
        }
        return add;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends C> collection) {
        Iterator<? extends C> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public void clear() {
        super.clear();
        this.index.clear();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.index.containsKey(this.keyTransformer.transform(obj));
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public C get(K k) {
        Collection collection = (Collection) this.index.get(k);
        if (collection == null) {
            return null;
        }
        return (C) collection.iterator().next();
    }

    public Collection<C> values(K k) {
        return (Collection) this.index.get(k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void reindex() {
        this.index.clear();
        Iterator it = decorated().iterator();
        while (it.hasNext()) {
            addToIndex(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean remove(Object obj) {
        boolean remove = super.remove(obj);
        if (remove) {
            removeFromIndex(obj);
        }
        return remove;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean removeIf(Predicate<? super C> predicate) {
        boolean z = false;
        if (Objects.isNull(predicate)) {
            return false;
        }
        Iterator<C> it = iterator();
        while (it.hasNext()) {
            if (predicate.test(it.next())) {
                it.remove();
                z = true;
            }
        }
        if (z) {
            reindex();
        }
        return z;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll = super.retainAll(collection);
        if (retainAll) {
            reindex();
        }
        return retainAll;
    }

    private void addToIndex(C c) {
        K transform = this.keyTransformer.transform(c);
        if (this.uniqueIndex && this.index.containsKey(transform)) {
            throw new IllegalArgumentException("Duplicate key in uniquely indexed collection.");
        }
        this.index.put(transform, c);
    }

    private void removeFromIndex(C c) {
        this.index.remove(this.keyTransformer.transform(c));
    }
}

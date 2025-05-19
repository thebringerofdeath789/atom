package org.apache.commons.collections4.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.collections4.Transformer;

/* loaded from: classes4.dex */
public class TransformedCollection<E> extends AbstractCollectionDecorator<E> {
    private static final long serialVersionUID = 8692300188161871514L;
    protected final Transformer<? super E, ? extends E> transformer;

    public static <E> TransformedCollection<E> transformingCollection(Collection<E> collection, Transformer<? super E, ? extends E> transformer) {
        return new TransformedCollection<>(collection, transformer);
    }

    public static <E> TransformedCollection<E> transformedCollection(Collection<E> collection, Transformer<? super E, ? extends E> transformer) {
        TransformedCollection<E> transformedCollection = new TransformedCollection<>(collection, transformer);
        if (collection.size() > 0) {
            Object[] array = collection.toArray();
            collection.clear();
            for (Object obj : array) {
                transformedCollection.decorated().add(transformer.transform(obj));
            }
        }
        return transformedCollection;
    }

    protected TransformedCollection(Collection<E> collection, Transformer<? super E, ? extends E> transformer) {
        super(collection);
        Objects.requireNonNull(transformer, "Transformer must not be null");
        this.transformer = transformer;
    }

    protected E transform(E e) {
        return this.transformer.transform(e);
    }

    protected Collection<E> transform(Collection<? extends E> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(transform((TransformedCollection<E>) it.next()));
        }
        return arrayList;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(E e) {
        return decorated().add(transform((TransformedCollection<E>) e));
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        return decorated().addAll(transform((Collection) collection));
    }
}

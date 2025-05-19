package org.apache.commons.collections.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.Transformer;

/* loaded from: classes4.dex */
public class TransformedCollection extends AbstractSerializableCollectionDecorator {
    private static final long serialVersionUID = 8692300188161871514L;
    protected final Transformer transformer;

    public static Collection decorate(Collection collection, Transformer transformer) {
        return new TransformedCollection(collection, transformer);
    }

    protected TransformedCollection(Collection collection, Transformer transformer) {
        super(collection);
        if (transformer == null) {
            throw new IllegalArgumentException("Transformer must not be null");
        }
        this.transformer = transformer;
    }

    protected Object transform(Object obj) {
        return this.transformer.transform(obj);
    }

    protected Collection transform(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(transform(it.next()));
        }
        return arrayList;
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean add(Object obj) {
        return getCollection().add(transform(obj));
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection collection) {
        return getCollection().addAll(transform(collection));
    }
}

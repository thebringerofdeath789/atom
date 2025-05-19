package org.apache.commons.collections.collection;

import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.Predicate;

/* loaded from: classes4.dex */
public class PredicatedCollection extends AbstractSerializableCollectionDecorator {
    private static final long serialVersionUID = -5259182142076705162L;
    protected final Predicate predicate;

    public static Collection decorate(Collection collection, Predicate predicate) {
        return new PredicatedCollection(collection, predicate);
    }

    protected PredicatedCollection(Collection collection, Predicate predicate) {
        super(collection);
        if (predicate == null) {
            throw new IllegalArgumentException("Predicate must not be null");
        }
        this.predicate = predicate;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            validate(it.next());
        }
    }

    protected void validate(Object obj) {
        if (!this.predicate.evaluate(obj)) {
            throw new IllegalArgumentException(new StringBuffer().append("Cannot add Object '").append(obj).append("' - Predicate rejected it").toString());
        }
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean add(Object obj) {
        validate(obj);
        return getCollection().add(obj);
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            validate(it.next());
        }
        return getCollection().addAll(collection);
    }
}

package org.apache.commons.collections.bag;

import java.util.Set;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.collection.PredicatedCollection;

/* loaded from: classes4.dex */
public class PredicatedBag extends PredicatedCollection implements Bag {
    private static final long serialVersionUID = -2575833140344736876L;

    public static Bag decorate(Bag bag, Predicate predicate) {
        return new PredicatedBag(bag, predicate);
    }

    protected PredicatedBag(Bag bag, Predicate predicate) {
        super(bag, predicate);
    }

    protected Bag getBag() {
        return (Bag) getCollection();
    }

    @Override // org.apache.commons.collections.Bag
    public boolean add(Object obj, int i) {
        validate(obj);
        return getBag().add(obj, i);
    }

    @Override // org.apache.commons.collections.Bag
    public boolean remove(Object obj, int i) {
        return getBag().remove(obj, i);
    }

    @Override // org.apache.commons.collections.Bag
    public Set uniqueSet() {
        return getBag().uniqueSet();
    }

    @Override // org.apache.commons.collections.Bag
    public int getCount(Object obj) {
        return getBag().getCount(obj);
    }
}

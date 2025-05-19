package org.apache.commons.collections.bag;

import java.util.Set;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.collection.SynchronizedCollection;
import org.apache.commons.collections.set.SynchronizedSet;

/* loaded from: classes4.dex */
public class SynchronizedBag extends SynchronizedCollection implements Bag {
    private static final long serialVersionUID = 8084674570753837109L;

    public static Bag decorate(Bag bag) {
        return new SynchronizedBag(bag);
    }

    protected SynchronizedBag(Bag bag) {
        super(bag);
    }

    protected SynchronizedBag(Bag bag, Object obj) {
        super(bag, obj);
    }

    protected Bag getBag() {
        return (Bag) this.collection;
    }

    @Override // org.apache.commons.collections.Bag
    public boolean add(Object obj, int i) {
        boolean add;
        synchronized (this.lock) {
            add = getBag().add(obj, i);
        }
        return add;
    }

    @Override // org.apache.commons.collections.Bag
    public boolean remove(Object obj, int i) {
        boolean remove;
        synchronized (this.lock) {
            remove = getBag().remove(obj, i);
        }
        return remove;
    }

    @Override // org.apache.commons.collections.Bag
    public Set uniqueSet() {
        SynchronizedBagSet synchronizedBagSet;
        synchronized (this.lock) {
            synchronizedBagSet = new SynchronizedBagSet(this, getBag().uniqueSet(), this.lock);
        }
        return synchronizedBagSet;
    }

    @Override // org.apache.commons.collections.Bag
    public int getCount(Object obj) {
        int count;
        synchronized (this.lock) {
            count = getBag().getCount(obj);
        }
        return count;
    }

    class SynchronizedBagSet extends SynchronizedSet {
        private final /* synthetic */ SynchronizedBag this$0;

        SynchronizedBagSet(SynchronizedBag synchronizedBag, Set set, Object obj) {
            super(set, obj);
            this.this$0 = synchronizedBag;
        }
    }
}

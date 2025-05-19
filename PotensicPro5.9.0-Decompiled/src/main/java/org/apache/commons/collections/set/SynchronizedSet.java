package org.apache.commons.collections.set;

import java.util.Set;
import org.apache.commons.collections.collection.SynchronizedCollection;

/* loaded from: classes4.dex */
public class SynchronizedSet extends SynchronizedCollection implements Set {
    private static final long serialVersionUID = -8304417378626543635L;

    public static Set decorate(Set set) {
        return new SynchronizedSet(set);
    }

    protected SynchronizedSet(Set set) {
        super(set);
    }

    protected SynchronizedSet(Set set, Object obj) {
        super(set, obj);
    }

    protected Set getSet() {
        return (Set) this.collection;
    }
}

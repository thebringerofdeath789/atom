package org.apache.commons.collections.set;

import java.util.Set;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.collection.PredicatedCollection;

/* loaded from: classes4.dex */
public class PredicatedSet extends PredicatedCollection implements Set {
    private static final long serialVersionUID = -684521469108685117L;

    public static Set decorate(Set set, Predicate predicate) {
        return new PredicatedSet(set, predicate);
    }

    protected PredicatedSet(Set set, Predicate predicate) {
        super(set, predicate);
    }

    protected Set getSet() {
        return (Set) getCollection();
    }
}

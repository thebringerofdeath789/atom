package org.apache.commons.collections;

import java.util.Collection;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class HashBag extends DefaultMapBag implements Bag {
    public HashBag() {
        super(new HashMap());
    }

    public HashBag(Collection collection) {
        this();
        addAll(collection);
    }
}

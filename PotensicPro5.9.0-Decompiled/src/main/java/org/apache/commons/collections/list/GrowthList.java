package org.apache.commons.collections.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public class GrowthList extends AbstractSerializableListDecorator {
    private static final long serialVersionUID = -3620001881672L;

    public static List decorate(List list) {
        return new GrowthList(list);
    }

    public GrowthList() {
        super(new ArrayList());
    }

    public GrowthList(int i) {
        super(new ArrayList(i));
    }

    protected GrowthList(List list) {
        super(list);
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public void add(int i, Object obj) {
        int size = getList().size();
        if (i > size) {
            getList().addAll(Collections.nCopies(i - size, null));
        }
        getList().add(i, obj);
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public boolean addAll(int i, Collection collection) {
        boolean z;
        int size = getList().size();
        if (i > size) {
            getList().addAll(Collections.nCopies(i - size, null));
            z = true;
        } else {
            z = false;
        }
        return getList().addAll(i, collection) | z;
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public Object set(int i, Object obj) {
        int size = getList().size();
        if (i >= size) {
            getList().addAll(Collections.nCopies((i - size) + 1, null));
        }
        return getList().set(i, obj);
    }
}

package org.apache.commons.collections.list;

import java.util.List;
import org.apache.commons.collections.Factory;

/* loaded from: classes4.dex */
public class LazyList extends AbstractSerializableListDecorator {
    private static final long serialVersionUID = -1708388017160694542L;
    protected final Factory factory;

    public static List decorate(List list, Factory factory) {
        return new LazyList(list, factory);
    }

    protected LazyList(List list, Factory factory) {
        super(list);
        if (factory == null) {
            throw new IllegalArgumentException("Factory must not be null");
        }
        this.factory = factory;
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public Object get(int i) {
        int size = getList().size();
        if (i < size) {
            Object obj = getList().get(i);
            if (obj != null) {
                return obj;
            }
            Object create = this.factory.create();
            getList().set(i, create);
            return create;
        }
        while (size < i) {
            getList().add(null);
            size++;
        }
        Object create2 = this.factory.create();
        getList().add(create2);
        return create2;
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public List subList(int i, int i2) {
        return new LazyList(getList().subList(i, i2), this.factory);
    }
}

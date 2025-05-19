package org.apache.commons.collections.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.collection.TransformedCollection;
import org.apache.commons.collections.iterators.AbstractListIteratorDecorator;

/* loaded from: classes4.dex */
public class TransformedList extends TransformedCollection implements List {
    private static final long serialVersionUID = 1077193035000013141L;

    public static List decorate(List list, Transformer transformer) {
        return new TransformedList(list, transformer);
    }

    protected TransformedList(List list, Transformer transformer) {
        super(list, transformer);
    }

    protected List getList() {
        return (List) this.collection;
    }

    @Override // java.util.List
    public Object get(int i) {
        return getList().get(i);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return getList().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return getList().lastIndexOf(obj);
    }

    @Override // java.util.List
    public Object remove(int i) {
        return getList().remove(i);
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        getList().add(i, transform(obj));
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        return getList().addAll(i, transform(collection));
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        return new TransformedListIterator(this, getList().listIterator(i));
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        return getList().set(i, transform(obj));
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        return new TransformedList(getList().subList(i, i2), this.transformer);
    }

    protected class TransformedListIterator extends AbstractListIteratorDecorator {
        private final /* synthetic */ TransformedList this$0;

        protected TransformedListIterator(TransformedList transformedList, ListIterator listIterator) {
            super(listIterator);
            this.this$0 = transformedList;
        }

        @Override // org.apache.commons.collections.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void add(Object obj) {
            this.iterator.add(this.this$0.transform(obj));
        }

        @Override // org.apache.commons.collections.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void set(Object obj) {
            this.iterator.set(this.this$0.transform(obj));
        }
    }
}

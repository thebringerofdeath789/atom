package org.apache.commons.collections4.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.list.UnmodifiableList;

/* loaded from: classes4.dex */
public class ListOrderedSet<E> extends AbstractSerializableSetDecorator<E> {
    private static final long serialVersionUID = -228664372470420141L;
    private final List<E> setOrder;

    public static <E> ListOrderedSet<E> listOrderedSet(Set<E> set, List<E> list) {
        Objects.requireNonNull(set, "Set must not be null");
        Objects.requireNonNull(list, "List must not be null");
        if (set.size() > 0 || list.size() > 0) {
            throw new IllegalArgumentException("Set and List must be empty");
        }
        return new ListOrderedSet<>(set, list);
    }

    public static <E> ListOrderedSet<E> listOrderedSet(Set<E> set) {
        return new ListOrderedSet<>(set);
    }

    public static <E> ListOrderedSet<E> listOrderedSet(List<E> list) {
        Objects.requireNonNull(list, "List must not be null");
        CollectionUtils.filter(list, UniquePredicate.uniquePredicate());
        return new ListOrderedSet<>(new HashSet(list), list);
    }

    public ListOrderedSet() {
        super(new HashSet());
        this.setOrder = new ArrayList();
    }

    protected ListOrderedSet(Set<E> set) {
        super(set);
        this.setOrder = new ArrayList(set);
    }

    protected ListOrderedSet(Set<E> set, List<E> list) {
        super(set);
        Objects.requireNonNull(list, "List must not be null");
        this.setOrder = list;
    }

    public List<E> asList() {
        return UnmodifiableList.unmodifiableList(this.setOrder);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public void clear() {
        decorated().clear();
        this.setOrder.clear();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
    public OrderedIterator<E> iterator() {
        return new OrderedSetIterator(this.setOrder.listIterator(), decorated());
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(E e) {
        if (!decorated().add(e)) {
            return false;
        }
        this.setOrder.add(e);
        return true;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean remove(Object obj) {
        boolean remove = decorated().remove(obj);
        if (remove) {
            this.setOrder.remove(obj);
        }
        return remove;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean removeIf(Predicate<? super E> predicate) {
        if (Objects.isNull(predicate)) {
            return false;
        }
        boolean removeIf = decorated().removeIf(predicate);
        if (removeIf) {
            this.setOrder.removeIf(predicate);
        }
        return removeIf;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll = decorated().retainAll(collection);
        if (!retainAll) {
            return false;
        }
        if (decorated().size() == 0) {
            this.setOrder.clear();
        } else {
            Iterator<E> it = this.setOrder.iterator();
            while (it.hasNext()) {
                if (!decorated().contains(it.next())) {
                    it.remove();
                }
            }
        }
        return retainAll;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public Object[] toArray() {
        return this.setOrder.toArray();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.setOrder.toArray(tArr);
    }

    public E get(int i) {
        return this.setOrder.get(i);
    }

    public int indexOf(Object obj) {
        return this.setOrder.indexOf(obj);
    }

    public void add(int i, E e) {
        if (contains(e)) {
            return;
        }
        decorated().add(e);
        this.setOrder.add(i, e);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (E e : collection) {
            if (!contains(e)) {
                decorated().add(e);
                arrayList.add(e);
                z = true;
            }
        }
        if (z) {
            this.setOrder.addAll(i, arrayList);
        }
        return z;
    }

    public E remove(int i) {
        E remove = this.setOrder.remove(i);
        remove(remove);
        return remove;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public String toString() {
        return this.setOrder.toString();
    }

    static class OrderedSetIterator<E> extends AbstractIteratorDecorator<E> implements OrderedIterator<E> {
        private E last;
        private final Collection<E> set;

        private OrderedSetIterator(ListIterator<E> listIterator, Collection<E> collection) {
            super(listIterator);
            this.set = collection;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public E next() {
            E next = getIterator().next();
            this.last = next;
            return next;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            this.set.remove(this.last);
            getIterator().remove();
            this.last = null;
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return ((ListIterator) getIterator()).hasPrevious();
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public E previous() {
            E e = (E) ((ListIterator) getIterator()).previous();
            this.last = e;
            return e;
        }
    }
}

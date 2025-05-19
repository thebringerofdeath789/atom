package org.apache.commons.collections4.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.PredicatedBag;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.list.PredicatedList;
import org.apache.commons.collections4.multiset.HashMultiSet;
import org.apache.commons.collections4.multiset.PredicatedMultiSet;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.set.PredicatedSet;

/* loaded from: classes4.dex */
public class PredicatedCollection<E> extends AbstractCollectionDecorator<E> {
    private static final long serialVersionUID = -5259182142076705162L;
    protected final Predicate<? super E> predicate;

    public static <E> Builder<E> builder(Predicate<? super E> predicate) {
        return new Builder<>(predicate);
    }

    public static <E> Builder<E> notNullBuilder() {
        return new Builder<>(NotNullPredicate.notNullPredicate());
    }

    public static <T> PredicatedCollection<T> predicatedCollection(Collection<T> collection, Predicate<? super T> predicate) {
        return new PredicatedCollection<>(collection, predicate);
    }

    protected PredicatedCollection(Collection<E> collection, Predicate<? super E> predicate) {
        super(collection);
        Objects.requireNonNull(predicate, "Predicate must not be null.");
        this.predicate = predicate;
        Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            validate(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void validate(E e) {
        if (!this.predicate.evaluate(e)) {
            throw new IllegalArgumentException("Cannot add Object '" + e + "' - Predicate '" + this.predicate + "' rejected it");
        }
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(E e) {
        validate(e);
        return decorated().add(e);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            validate(it.next());
        }
        return decorated().addAll(collection);
    }

    public static class Builder<E> {
        private final Predicate<? super E> predicate;
        private final List<E> accepted = new ArrayList();
        private final List<E> rejected = new ArrayList();

        public Builder(Predicate<? super E> predicate) {
            Objects.requireNonNull(predicate, "Predicate must not be null");
            this.predicate = predicate;
        }

        public Builder<E> add(E e) {
            if (this.predicate.evaluate(e)) {
                this.accepted.add(e);
            } else {
                this.rejected.add(e);
            }
            return this;
        }

        public Builder<E> addAll(Collection<? extends E> collection) {
            if (collection != null) {
                Iterator<? extends E> it = collection.iterator();
                while (it.hasNext()) {
                    add(it.next());
                }
            }
            return this;
        }

        public List<E> createPredicatedList() {
            return createPredicatedList(new ArrayList());
        }

        public List<E> createPredicatedList(List<E> list) {
            Objects.requireNonNull(list, "List must not be null.");
            PredicatedList predicatedList = PredicatedList.predicatedList(list, this.predicate);
            predicatedList.addAll(this.accepted);
            return predicatedList;
        }

        public Set<E> createPredicatedSet() {
            return createPredicatedSet(new HashSet());
        }

        public Set<E> createPredicatedSet(Set<E> set) {
            Objects.requireNonNull(set, "Set must not be null.");
            PredicatedSet predicatedSet = PredicatedSet.predicatedSet(set, this.predicate);
            predicatedSet.addAll(this.accepted);
            return predicatedSet;
        }

        public MultiSet<E> createPredicatedMultiSet() {
            return createPredicatedMultiSet(new HashMultiSet());
        }

        public MultiSet<E> createPredicatedMultiSet(MultiSet<E> multiSet) {
            Objects.requireNonNull(multiSet, "MultiSet must not be null.");
            PredicatedMultiSet predicatedMultiSet = PredicatedMultiSet.predicatedMultiSet(multiSet, this.predicate);
            predicatedMultiSet.addAll(this.accepted);
            return predicatedMultiSet;
        }

        public Bag<E> createPredicatedBag() {
            return createPredicatedBag(new HashBag());
        }

        public Bag<E> createPredicatedBag(Bag<E> bag) {
            Objects.requireNonNull(bag, "Bag must not be null.");
            PredicatedBag predicatedBag = PredicatedBag.predicatedBag(bag, this.predicate);
            predicatedBag.addAll(this.accepted);
            return predicatedBag;
        }

        public Queue<E> createPredicatedQueue() {
            return createPredicatedQueue(new LinkedList());
        }

        public Queue<E> createPredicatedQueue(Queue<E> queue) {
            Objects.requireNonNull(queue, "queue must not be null");
            PredicatedQueue predicatedQueue = PredicatedQueue.predicatedQueue(queue, this.predicate);
            predicatedQueue.addAll(this.accepted);
            return predicatedQueue;
        }

        public Collection<E> rejectedElements() {
            return Collections.unmodifiableCollection(this.rejected);
        }
    }
}

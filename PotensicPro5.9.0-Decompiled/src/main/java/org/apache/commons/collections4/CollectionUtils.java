package org.apache.commons.collections4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.collection.SynchronizedCollection;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.collection.UnmodifiableBoundedCollection;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.functors.TruePredicate;
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.apache.commons.collections4.iterators.PermutationIterator;

/* loaded from: classes4.dex */
public class CollectionUtils {
    public static final Collection EMPTY_COLLECTION = Collections.emptyList();

    private static class CardinalityHelper<O> {
        final Map<O, Integer> cardinalityA;
        final Map<O, Integer> cardinalityB;

        public CardinalityHelper(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
            this.cardinalityA = CollectionUtils.getCardinalityMap(iterable);
            this.cardinalityB = CollectionUtils.getCardinalityMap(iterable2);
        }

        public final int max(Object obj) {
            return Math.max(freqA(obj), freqB(obj));
        }

        public final int min(Object obj) {
            return Math.min(freqA(obj), freqB(obj));
        }

        public int freqA(Object obj) {
            return getFreq(obj, this.cardinalityA);
        }

        public int freqB(Object obj) {
            return getFreq(obj, this.cardinalityB);
        }

        private int getFreq(Object obj, Map<?, Integer> map) {
            Integer num = map.get(obj);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
    }

    private static class SetOperationCardinalityHelper<O> extends CardinalityHelper<O> implements Iterable<O> {
        private final Set<O> elements;
        private final List<O> newList;

        public SetOperationCardinalityHelper(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
            super(iterable, iterable2);
            HashSet hashSet = new HashSet();
            this.elements = hashSet;
            CollectionUtils.addAll(hashSet, iterable);
            CollectionUtils.addAll(hashSet, iterable2);
            this.newList = new ArrayList(hashSet.size());
        }

        @Override // java.lang.Iterable
        public Iterator<O> iterator() {
            return this.elements.iterator();
        }

        public void setCardinality(O o, int i) {
            for (int i2 = 0; i2 < i; i2++) {
                this.newList.add(o);
            }
        }

        public Collection<O> list() {
            return this.newList;
        }
    }

    private CollectionUtils() {
    }

    public static <T> Collection<T> emptyCollection() {
        return EMPTY_COLLECTION;
    }

    public static <T> Collection<T> emptyIfNull(Collection<T> collection) {
        return collection == null ? emptyCollection() : collection;
    }

    public static <O> Collection<O> union(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
        SetOperationCardinalityHelper setOperationCardinalityHelper = new SetOperationCardinalityHelper(iterable, iterable2);
        Iterator<O> it = setOperationCardinalityHelper.iterator();
        while (it.hasNext()) {
            O next = it.next();
            setOperationCardinalityHelper.setCardinality(next, setOperationCardinalityHelper.max(next));
        }
        return setOperationCardinalityHelper.list();
    }

    public static <O> Collection<O> intersection(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
        SetOperationCardinalityHelper setOperationCardinalityHelper = new SetOperationCardinalityHelper(iterable, iterable2);
        Iterator<O> it = setOperationCardinalityHelper.iterator();
        while (it.hasNext()) {
            O next = it.next();
            setOperationCardinalityHelper.setCardinality(next, setOperationCardinalityHelper.min(next));
        }
        return setOperationCardinalityHelper.list();
    }

    public static <O> Collection<O> disjunction(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
        SetOperationCardinalityHelper setOperationCardinalityHelper = new SetOperationCardinalityHelper(iterable, iterable2);
        Iterator<O> it = setOperationCardinalityHelper.iterator();
        while (it.hasNext()) {
            O next = it.next();
            setOperationCardinalityHelper.setCardinality(next, setOperationCardinalityHelper.max(next) - setOperationCardinalityHelper.min(next));
        }
        return setOperationCardinalityHelper.list();
    }

    public static <O> Collection<O> subtract(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
        return subtract(iterable, iterable2, TruePredicate.truePredicate());
    }

    public static <O> Collection<O> subtract(Iterable<? extends O> iterable, Iterable<? extends O> iterable2, Predicate<O> predicate) {
        ArrayList arrayList = new ArrayList();
        HashBag hashBag = new HashBag();
        for (O o : iterable2) {
            if (predicate.evaluate(o)) {
                hashBag.add(o);
            }
        }
        for (O o2 : iterable) {
            if (!hashBag.remove(o2, 1)) {
                arrayList.add(o2);
            }
        }
        return arrayList;
    }

    public static boolean containsAll(Collection<?> collection, Collection<?> collection2) {
        boolean z;
        if (collection2.isEmpty()) {
            return true;
        }
        HashSet hashSet = new HashSet();
        for (Object obj : collection2) {
            if (!hashSet.contains(obj)) {
                for (Object obj2 : collection) {
                    hashSet.add(obj2);
                    if (obj != null) {
                        if (obj.equals(obj2)) {
                            z = true;
                            break;
                        }
                    } else {
                        if (obj2 == null) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    return false;
                }
            }
        }
        return true;
    }

    public static <T> boolean containsAny(Collection<?> collection, T... tArr) {
        if (collection.size() < tArr.length) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (ArrayUtils.contains(tArr, it.next())) {
                    return true;
                }
            }
        } else {
            for (T t : tArr) {
                if (collection.contains(t)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsAny(Collection<?> collection, Collection<?> collection2) {
        if (collection.size() < collection2.size()) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (collection2.contains(it.next())) {
                    return true;
                }
            }
            return false;
        }
        Iterator<?> it2 = collection2.iterator();
        while (it2.hasNext()) {
            if (collection.contains(it2.next())) {
                return true;
            }
        }
        return false;
    }

    public static <O> Map<O, Integer> getCardinalityMap(Iterable<? extends O> iterable) {
        HashMap hashMap = new HashMap();
        for (O o : iterable) {
            Integer num = (Integer) hashMap.get(o);
            if (num == null) {
                hashMap.put(o, 1);
            } else {
                hashMap.put(o, Integer.valueOf(num.intValue() + 1));
            }
        }
        return hashMap;
    }

    public static boolean isSubCollection(Collection<?> collection, Collection<?> collection2) {
        CardinalityHelper cardinalityHelper = new CardinalityHelper(collection, collection2);
        for (Object obj : collection) {
            if (cardinalityHelper.freqA(obj) > cardinalityHelper.freqB(obj)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isProperSubCollection(Collection<?> collection, Collection<?> collection2) {
        return collection.size() < collection2.size() && isSubCollection(collection, collection2);
    }

    public static boolean isEqualCollection(Collection<?> collection, Collection<?> collection2) {
        if (collection.size() != collection2.size()) {
            return false;
        }
        CardinalityHelper cardinalityHelper = new CardinalityHelper(collection, collection2);
        if (cardinalityHelper.cardinalityA.size() != cardinalityHelper.cardinalityB.size()) {
            return false;
        }
        for (Object obj : cardinalityHelper.cardinalityA.keySet()) {
            if (cardinalityHelper.freqA(obj) != cardinalityHelper.freqB(obj)) {
                return false;
            }
        }
        return true;
    }

    public static <E> boolean isEqualCollection(Collection<? extends E> collection, Collection<? extends E> collection2, final Equator<? super E> equator) {
        Objects.requireNonNull(equator, "Equator must not be null.");
        if (collection.size() != collection2.size()) {
            return false;
        }
        Transformer transformer = new Transformer() { // from class: org.apache.commons.collections4.CollectionUtils.1
            @Override // org.apache.commons.collections4.Transformer
            public EquatorWrapper<?> transform(Object obj) {
                return new EquatorWrapper<>(Equator.this, obj);
            }
        };
        return isEqualCollection(collect(collection, transformer), collect(collection2, transformer));
    }

    private static class EquatorWrapper<O> {
        private final Equator<? super O> equator;
        private final O object;

        public EquatorWrapper(Equator<? super O> equator, O o) {
            this.equator = equator;
            this.object = o;
        }

        public O getObject() {
            return this.object;
        }

        public boolean equals(Object obj) {
            if (obj instanceof EquatorWrapper) {
                return this.equator.equate(this.object, (Object) ((EquatorWrapper) obj).getObject());
            }
            return false;
        }

        public int hashCode() {
            return this.equator.hash(this.object);
        }
    }

    @Deprecated
    public static <O> int cardinality(O o, Iterable<? super O> iterable) {
        Objects.requireNonNull(iterable, "coll must not be null.");
        return IterableUtils.frequency(iterable, o);
    }

    @Deprecated
    public static <T> T find(Iterable<T> iterable, Predicate<? super T> predicate) {
        if (predicate != null) {
            return (T) IterableUtils.find(iterable, predicate);
        }
        return null;
    }

    @Deprecated
    public static <T, C extends Closure<? super T>> C forAllDo(Iterable<T> iterable, C c) {
        if (c != null) {
            IterableUtils.forEach(iterable, c);
        }
        return c;
    }

    @Deprecated
    public static <T, C extends Closure<? super T>> C forAllDo(Iterator<T> it, C c) {
        if (c != null) {
            IteratorUtils.forEach(it, c);
        }
        return c;
    }

    @Deprecated
    public static <T, C extends Closure<? super T>> T forAllButLastDo(Iterable<T> iterable, C c) {
        if (c != null) {
            return (T) IterableUtils.forEachButLast(iterable, c);
        }
        return null;
    }

    @Deprecated
    public static <T, C extends Closure<? super T>> T forAllButLastDo(Iterator<T> it, C c) {
        if (c != null) {
            return (T) IteratorUtils.forEachButLast(it, c);
        }
        return null;
    }

    public static <T> boolean filter(Iterable<T> iterable, Predicate<? super T> predicate) {
        boolean z = false;
        if (iterable != null && predicate != null) {
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                if (!predicate.evaluate(it.next())) {
                    it.remove();
                    z = true;
                }
            }
        }
        return z;
    }

    public static <T> boolean filterInverse(Iterable<T> iterable, Predicate<? super T> predicate) {
        return filter(iterable, predicate == null ? null : PredicateUtils.notPredicate(predicate));
    }

    public static <C> void transform(Collection<C> collection, Transformer<? super C, ? extends C> transformer) {
        if (collection == null || transformer == null) {
            return;
        }
        if (collection instanceof List) {
            ListIterator listIterator = ((List) collection).listIterator();
            while (listIterator.hasNext()) {
                listIterator.set(transformer.transform((Object) listIterator.next()));
            }
        } else {
            Collection<? extends C> collect = collect(collection, transformer);
            collection.clear();
            collection.addAll(collect);
        }
    }

    @Deprecated
    public static <C> int countMatches(Iterable<C> iterable, Predicate<? super C> predicate) {
        if (predicate == null) {
            return 0;
        }
        return (int) IterableUtils.countMatches(iterable, predicate);
    }

    @Deprecated
    public static <C> boolean exists(Iterable<C> iterable, Predicate<? super C> predicate) {
        return predicate != null && IterableUtils.matchesAny(iterable, predicate);
    }

    @Deprecated
    public static <C> boolean matchesAll(Iterable<C> iterable, Predicate<? super C> predicate) {
        return predicate != null && IterableUtils.matchesAll(iterable, predicate);
    }

    public static <O> Collection<O> select(Iterable<? extends O> iterable, Predicate<? super O> predicate) {
        return select(iterable, predicate, iterable instanceof Collection ? new ArrayList(((Collection) iterable).size()) : new ArrayList());
    }

    public static <O, R extends Collection<? super O>> R select(Iterable<? extends O> iterable, Predicate<? super O> predicate, R r) {
        if (iterable != null && predicate != null) {
            for (O o : iterable) {
                if (predicate.evaluate(o)) {
                    r.add(o);
                }
            }
        }
        return r;
    }

    public static <O, R extends Collection<? super O>> R select(Iterable<? extends O> iterable, Predicate<? super O> predicate, R r, R r2) {
        if (iterable != null && predicate != null) {
            for (O o : iterable) {
                if (predicate.evaluate(o)) {
                    r.add(o);
                } else {
                    r2.add(o);
                }
            }
        }
        return r;
    }

    public static <O> Collection<O> selectRejected(Iterable<? extends O> iterable, Predicate<? super O> predicate) {
        return selectRejected(iterable, predicate, iterable instanceof Collection ? new ArrayList(((Collection) iterable).size()) : new ArrayList());
    }

    public static <O, R extends Collection<? super O>> R selectRejected(Iterable<? extends O> iterable, Predicate<? super O> predicate, R r) {
        if (iterable != null && predicate != null) {
            for (O o : iterable) {
                if (!predicate.evaluate(o)) {
                    r.add(o);
                }
            }
        }
        return r;
    }

    public static <I, O> Collection<O> collect(Iterable<I> iterable, Transformer<? super I, ? extends O> transformer) {
        return collect(iterable, transformer, iterable instanceof Collection ? new ArrayList(((Collection) iterable).size()) : new ArrayList());
    }

    public static <I, O> Collection<O> collect(Iterator<I> it, Transformer<? super I, ? extends O> transformer) {
        return collect(it, transformer, new ArrayList());
    }

    public static <I, O, R extends Collection<? super O>> R collect(Iterable<? extends I> iterable, Transformer<? super I, ? extends O> transformer, R r) {
        return iterable != null ? (R) collect(iterable.iterator(), transformer, r) : r;
    }

    public static <I, O, R extends Collection<? super O>> R collect(Iterator<? extends I> it, Transformer<? super I, ? extends O> transformer, R r) {
        if (it != null && transformer != null) {
            while (it.hasNext()) {
                r.add(transformer.transform(it.next()));
            }
        }
        return r;
    }

    public static <T> boolean addIgnoreNull(Collection<T> collection, T t) {
        Objects.requireNonNull(collection, "The collection must not be null");
        return t != null && collection.add(t);
    }

    public static <C> boolean addAll(Collection<C> collection, Iterable<? extends C> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        return addAll(collection, iterable.iterator());
    }

    public static <C> boolean addAll(Collection<C> collection, Iterator<? extends C> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    public static <C> boolean addAll(Collection<C> collection, Enumeration<? extends C> enumeration) {
        boolean z = false;
        while (enumeration.hasMoreElements()) {
            z |= collection.add(enumeration.nextElement());
        }
        return z;
    }

    public static <C> boolean addAll(Collection<C> collection, C... cArr) {
        boolean z = false;
        for (C c : cArr) {
            z |= collection.add(c);
        }
        return z;
    }

    @Deprecated
    public static <T> T get(Iterator<T> it, int i) {
        return (T) IteratorUtils.get(it, i);
    }

    static void checkIndexBounds(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative: " + i);
        }
    }

    @Deprecated
    public static <T> T get(Iterable<T> iterable, int i) {
        return (T) IterableUtils.get(iterable, i);
    }

    public static Object get(Object obj, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative: " + i);
        }
        if (obj instanceof Map) {
            return IteratorUtils.get(((Map) obj).entrySet().iterator(), i);
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj)[i];
        }
        if (obj instanceof Iterator) {
            return IteratorUtils.get((Iterator) obj, i);
        }
        if (obj instanceof Iterable) {
            return IterableUtils.get((Iterable) obj, i);
        }
        if (obj instanceof Enumeration) {
            return EnumerationUtils.get((Enumeration) obj, i);
        }
        if (obj == null) {
            throw new IllegalArgumentException("Unsupported object type: null");
        }
        try {
            return Array.get(obj, i);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Unsupported object type: " + obj.getClass().getName());
        }
    }

    public static <K, V> Map.Entry<K, V> get(Map<K, V> map, int i) {
        checkIndexBounds(i);
        return (Map.Entry) get((Iterable) map.entrySet(), i);
    }

    public static int size(Object obj) {
        int i = 0;
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Map) {
            return ((Map) obj).size();
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Iterable) {
            return IterableUtils.size((Iterable) obj);
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj instanceof Iterator) {
            return IteratorUtils.size((Iterator) obj);
        }
        if (obj instanceof Enumeration) {
            Enumeration enumeration = (Enumeration) obj;
            while (enumeration.hasMoreElements()) {
                i++;
                enumeration.nextElement();
            }
            return i;
        }
        try {
            return Array.getLength(obj);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Unsupported object type: " + obj.getClass().getName());
        }
    }

    public static boolean sizeIsEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Iterable) {
            return IterableUtils.isEmpty((Iterable) obj);
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length == 0;
        }
        if (obj instanceof Iterator) {
            return !((Iterator) obj).hasNext();
        }
        if (obj instanceof Enumeration) {
            return !((Enumeration) obj).hasMoreElements();
        }
        try {
            return Array.getLength(obj) == 0;
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Unsupported object type: " + obj.getClass().getName());
        }
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static void reverseArray(Object[] objArr) {
        int length = objArr.length - 1;
        for (int i = 0; length > i; i++) {
            Object obj = objArr[length];
            objArr[length] = objArr[i];
            objArr[i] = obj;
            length--;
        }
    }

    public static boolean isFull(Collection<? extends Object> collection) {
        Objects.requireNonNull(collection, "The collection must not be null");
        if (collection instanceof BoundedCollection) {
            return ((BoundedCollection) collection).isFull();
        }
        try {
            return UnmodifiableBoundedCollection.unmodifiableBoundedCollection(collection).isFull();
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static int maxSize(Collection<? extends Object> collection) {
        Objects.requireNonNull(collection, "The collection must not be null");
        if (collection instanceof BoundedCollection) {
            return ((BoundedCollection) collection).maxSize();
        }
        try {
            return UnmodifiableBoundedCollection.unmodifiableBoundedCollection(collection).maxSize();
        } catch (IllegalArgumentException unused) {
            return -1;
        }
    }

    public static <O extends Comparable<? super O>> List<O> collate(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
        return collate(iterable, iterable2, ComparatorUtils.naturalComparator(), true);
    }

    public static <O extends Comparable<? super O>> List<O> collate(Iterable<? extends O> iterable, Iterable<? extends O> iterable2, boolean z) {
        return collate(iterable, iterable2, ComparatorUtils.naturalComparator(), z);
    }

    public static <O> List<O> collate(Iterable<? extends O> iterable, Iterable<? extends O> iterable2, Comparator<? super O> comparator) {
        return collate(iterable, iterable2, comparator, true);
    }

    public static <O> List<O> collate(Iterable<? extends O> iterable, Iterable<? extends O> iterable2, Comparator<? super O> comparator, boolean z) {
        if (iterable == null || iterable2 == null) {
            throw new NullPointerException("The collections must not be null");
        }
        Objects.requireNonNull(comparator, "The comparator must not be null");
        int max = ((iterable instanceof Collection) && (iterable2 instanceof Collection)) ? Math.max(1, ((Collection) iterable).size() + ((Collection) iterable2).size()) : 10;
        CollatingIterator collatingIterator = new CollatingIterator(comparator, iterable.iterator(), iterable2.iterator());
        if (z) {
            return IteratorUtils.toList(collatingIterator, max);
        }
        ArrayList arrayList = new ArrayList(max);
        Object obj = null;
        while (collatingIterator.hasNext()) {
            Object next = collatingIterator.next();
            if (obj == null || !obj.equals(next)) {
                arrayList.add(next);
            }
            obj = next;
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static <E> Collection<List<E>> permutations(Collection<E> collection) {
        PermutationIterator permutationIterator = new PermutationIterator(collection);
        ArrayList arrayList = new ArrayList();
        while (permutationIterator.hasNext()) {
            arrayList.add(permutationIterator.next());
        }
        return arrayList;
    }

    public static <C> Collection<C> retainAll(Collection<C> collection, Collection<?> collection2) {
        return ListUtils.retainAll(collection, collection2);
    }

    public static <E> Collection<E> retainAll(Iterable<E> iterable, Iterable<? extends E> iterable2, final Equator<? super E> equator) {
        Set set = (Set) collect(iterable2, new Transformer<E, EquatorWrapper<E>>() { // from class: org.apache.commons.collections4.CollectionUtils.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // org.apache.commons.collections4.Transformer
            public /* bridge */ /* synthetic */ Object transform(Object obj) {
                return transform((AnonymousClass2<E>) obj);
            }

            @Override // org.apache.commons.collections4.Transformer
            public EquatorWrapper<E> transform(E e) {
                return new EquatorWrapper<>(Equator.this, e);
            }
        }, new HashSet());
        ArrayList arrayList = new ArrayList();
        for (E e : iterable) {
            if (set.contains(new EquatorWrapper(equator, e))) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    public static <E> Collection<E> removeAll(Collection<E> collection, Collection<?> collection2) {
        return ListUtils.removeAll(collection, collection2);
    }

    public static <E> Collection<E> removeAll(Iterable<E> iterable, Iterable<? extends E> iterable2, final Equator<? super E> equator) {
        Set set = (Set) collect(iterable2, new Transformer<E, EquatorWrapper<E>>() { // from class: org.apache.commons.collections4.CollectionUtils.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // org.apache.commons.collections4.Transformer
            public /* bridge */ /* synthetic */ Object transform(Object obj) {
                return transform((AnonymousClass3<E>) obj);
            }

            @Override // org.apache.commons.collections4.Transformer
            public EquatorWrapper<E> transform(E e) {
                return new EquatorWrapper<>(Equator.this, e);
            }
        }, new HashSet());
        ArrayList arrayList = new ArrayList();
        for (E e : iterable) {
            if (!set.contains(new EquatorWrapper(equator, e))) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    @Deprecated
    public static <C> Collection<C> synchronizedCollection(Collection<C> collection) {
        return SynchronizedCollection.synchronizedCollection(collection);
    }

    @Deprecated
    public static <C> Collection<C> unmodifiableCollection(Collection<? extends C> collection) {
        return UnmodifiableCollection.unmodifiableCollection(collection);
    }

    public static <C> Collection<C> predicatedCollection(Collection<C> collection, Predicate<? super C> predicate) {
        return PredicatedCollection.predicatedCollection(collection, predicate);
    }

    public static <E> Collection<E> transformingCollection(Collection<E> collection, Transformer<? super E, ? extends E> transformer) {
        return TransformedCollection.transformingCollection(collection, transformer);
    }

    public static <E> E extractSingleton(Collection<E> collection) {
        Objects.requireNonNull(collection, "Collection must not be null.");
        if (collection.size() != 1) {
            throw new IllegalArgumentException("Can extract singleton only when collection size == 1");
        }
        return collection.iterator().next();
    }
}

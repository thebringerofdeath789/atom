package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {
    private static final int ABSENT = -1;
    private static final int ENDPOINT = -2;
    private transient Set<Map.Entry<K, V>> entrySet;

    @NullableDecl
    private transient int firstInInsertionOrder;
    private transient int[] hashTableKToV;
    private transient int[] hashTableVToK;

    @MonotonicNonNullDecl
    private transient BiMap<V, K> inverse;
    private transient Set<K> keySet;
    transient K[] keys;

    @NullableDecl
    private transient int lastInInsertionOrder;
    transient int modCount;
    private transient int[] nextInBucketKToV;
    private transient int[] nextInBucketVToK;
    private transient int[] nextInInsertionOrder;
    private transient int[] prevInInsertionOrder;
    transient int size;
    private transient Set<V> valueSet;
    transient V[] values;

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    public static <K, V> HashBiMap<K, V> create(int i) {
        return new HashBiMap<>(i);
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }

    private HashBiMap(int i) {
        init(i);
    }

    void init(int i) {
        CollectPreconditions.checkNonnegative(i, "expectedSize");
        int closedTableSize = Hashing.closedTableSize(i, 1.0d);
        this.size = 0;
        this.keys = (K[]) new Object[i];
        this.values = (V[]) new Object[i];
        this.hashTableKToV = createFilledWithAbsent(closedTableSize);
        this.hashTableVToK = createFilledWithAbsent(closedTableSize);
        this.nextInBucketKToV = createFilledWithAbsent(i);
        this.nextInBucketVToK = createFilledWithAbsent(i);
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.prevInInsertionOrder = createFilledWithAbsent(i);
        this.nextInInsertionOrder = createFilledWithAbsent(i);
    }

    private static int[] createFilledWithAbsent(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private static int[] expandAndFillWithAbsent(int[] iArr, int i) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i);
        Arrays.fill(copyOf, length, i, -1);
        return copyOf;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    private void ensureCapacity(int i) {
        int[] iArr = this.nextInBucketKToV;
        if (iArr.length < i) {
            int expandedCapacity = ImmutableCollection.Builder.expandedCapacity(iArr.length, i);
            this.keys = (K[]) Arrays.copyOf(this.keys, expandedCapacity);
            this.values = (V[]) Arrays.copyOf(this.values, expandedCapacity);
            this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, expandedCapacity);
            this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, expandedCapacity);
            this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, expandedCapacity);
            this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, expandedCapacity);
        }
        if (this.hashTableKToV.length < i) {
            int closedTableSize = Hashing.closedTableSize(i, 1.0d);
            this.hashTableKToV = createFilledWithAbsent(closedTableSize);
            this.hashTableVToK = createFilledWithAbsent(closedTableSize);
            for (int i2 = 0; i2 < this.size; i2++) {
                int bucket = bucket(Hashing.smearedHash(this.keys[i2]));
                int[] iArr2 = this.nextInBucketKToV;
                int[] iArr3 = this.hashTableKToV;
                iArr2[i2] = iArr3[bucket];
                iArr3[bucket] = i2;
                int bucket2 = bucket(Hashing.smearedHash(this.values[i2]));
                int[] iArr4 = this.nextInBucketVToK;
                int[] iArr5 = this.hashTableVToK;
                iArr4[i2] = iArr5[bucket2];
                iArr5[bucket2] = i2;
            }
        }
    }

    private int bucket(int i) {
        return i & (this.hashTableKToV.length - 1);
    }

    int findEntryByKey(@NullableDecl Object obj) {
        return findEntryByKey(obj, Hashing.smearedHash(obj));
    }

    int findEntryByKey(@NullableDecl Object obj, int i) {
        return findEntry(obj, i, this.hashTableKToV, this.nextInBucketKToV, this.keys);
    }

    int findEntryByValue(@NullableDecl Object obj) {
        return findEntryByValue(obj, Hashing.smearedHash(obj));
    }

    int findEntryByValue(@NullableDecl Object obj, int i) {
        return findEntry(obj, i, this.hashTableVToK, this.nextInBucketVToK, this.values);
    }

    int findEntry(@NullableDecl Object obj, int i, int[] iArr, int[] iArr2, Object[] objArr) {
        int i2 = iArr[bucket(i)];
        while (i2 != -1) {
            if (Objects.equal(objArr[i2], obj)) {
                return i2;
            }
            i2 = iArr2[i2];
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return findEntryByKey(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return findEntryByValue(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        int findEntryByKey = findEntryByKey(obj);
        if (findEntryByKey == -1) {
            return null;
        }
        return this.values[findEntryByKey];
    }

    @NullableDecl
    K getInverse(@NullableDecl Object obj) {
        int findEntryByValue = findEntryByValue(obj);
        if (findEntryByValue == -1) {
            return null;
        }
        return this.keys[findEntryByValue];
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    public V put(@NullableDecl K k, @NullableDecl V v) {
        return put(k, v, false);
    }

    @NullableDecl
    V put(@NullableDecl K k, @NullableDecl V v, boolean z) {
        int smearedHash = Hashing.smearedHash(k);
        int findEntryByKey = findEntryByKey(k, smearedHash);
        if (findEntryByKey != -1) {
            V v2 = this.values[findEntryByKey];
            if (Objects.equal(v2, v)) {
                return v;
            }
            replaceValueInEntry(findEntryByKey, v, z);
            return v2;
        }
        int smearedHash2 = Hashing.smearedHash(v);
        int findEntryByValue = findEntryByValue(v, smearedHash2);
        if (!z) {
            Preconditions.checkArgument(findEntryByValue == -1, "Value already present: %s", v);
        } else if (findEntryByValue != -1) {
            removeEntryValueHashKnown(findEntryByValue, smearedHash2);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i = this.size;
        kArr[i] = k;
        this.values[i] = v;
        insertIntoTableKToV(i, smearedHash);
        insertIntoTableVToK(this.size, smearedHash2);
        setSucceeds(this.lastInInsertionOrder, this.size);
        setSucceeds(this.size, -2);
        this.size++;
        this.modCount++;
        return null;
    }

    @Override // com.google.common.collect.BiMap
    @NullableDecl
    public V forcePut(@NullableDecl K k, @NullableDecl V v) {
        return put(k, v, true);
    }

    @NullableDecl
    K putInverse(@NullableDecl V v, @NullableDecl K k, boolean z) {
        int smearedHash = Hashing.smearedHash(v);
        int findEntryByValue = findEntryByValue(v, smearedHash);
        if (findEntryByValue != -1) {
            K k2 = this.keys[findEntryByValue];
            if (Objects.equal(k2, k)) {
                return k;
            }
            replaceKeyInEntry(findEntryByValue, k, z);
            return k2;
        }
        int i = this.lastInInsertionOrder;
        int smearedHash2 = Hashing.smearedHash(k);
        int findEntryByKey = findEntryByKey(k, smearedHash2);
        if (!z) {
            Preconditions.checkArgument(findEntryByKey == -1, "Key already present: %s", k);
        } else if (findEntryByKey != -1) {
            i = this.prevInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, smearedHash2);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i2 = this.size;
        kArr[i2] = k;
        this.values[i2] = v;
        insertIntoTableKToV(i2, smearedHash2);
        insertIntoTableVToK(this.size, smearedHash);
        int i3 = i == -2 ? this.firstInInsertionOrder : this.nextInInsertionOrder[i];
        setSucceeds(i, this.size);
        setSucceeds(this.size, i3);
        this.size++;
        this.modCount++;
        return null;
    }

    private void setSucceeds(int i, int i2) {
        if (i == -2) {
            this.firstInInsertionOrder = i2;
        } else {
            this.nextInInsertionOrder[i] = i2;
        }
        if (i2 == -2) {
            this.lastInInsertionOrder = i;
        } else {
            this.prevInInsertionOrder[i2] = i;
        }
    }

    private void insertIntoTableKToV(int i, int i2) {
        Preconditions.checkArgument(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.nextInBucketKToV;
        int[] iArr2 = this.hashTableKToV;
        iArr[i] = iArr2[bucket];
        iArr2[bucket] = i;
    }

    private void insertIntoTableVToK(int i, int i2) {
        Preconditions.checkArgument(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.nextInBucketVToK;
        int[] iArr2 = this.hashTableVToK;
        iArr[i] = iArr2[bucket];
        iArr2[bucket] = i;
    }

    private void deleteFromTableKToV(int i, int i2) {
        Preconditions.checkArgument(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.hashTableKToV;
        if (iArr[bucket] == i) {
            int[] iArr2 = this.nextInBucketKToV;
            iArr[bucket] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i3 = iArr[bucket];
        int i4 = this.nextInBucketKToV[i3];
        while (true) {
            int i5 = i4;
            int i6 = i3;
            i3 = i5;
            if (i3 == -1) {
                throw new AssertionError("Expected to find entry with key " + this.keys[i]);
            }
            if (i3 != i) {
                i4 = this.nextInBucketKToV[i3];
            } else {
                int[] iArr3 = this.nextInBucketKToV;
                iArr3[i6] = iArr3[i];
                iArr3[i] = -1;
                return;
            }
        }
    }

    private void deleteFromTableVToK(int i, int i2) {
        Preconditions.checkArgument(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.hashTableVToK;
        if (iArr[bucket] == i) {
            int[] iArr2 = this.nextInBucketVToK;
            iArr[bucket] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i3 = iArr[bucket];
        int i4 = this.nextInBucketVToK[i3];
        while (true) {
            int i5 = i4;
            int i6 = i3;
            i3 = i5;
            if (i3 == -1) {
                throw new AssertionError("Expected to find entry with value " + this.values[i]);
            }
            if (i3 != i) {
                i4 = this.nextInBucketVToK[i3];
            } else {
                int[] iArr3 = this.nextInBucketVToK;
                iArr3[i6] = iArr3[i];
                iArr3[i] = -1;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceValueInEntry(int i, @NullableDecl V v, boolean z) {
        Preconditions.checkArgument(i != -1);
        int smearedHash = Hashing.smearedHash(v);
        int findEntryByValue = findEntryByValue(v, smearedHash);
        if (findEntryByValue != -1) {
            if (z) {
                removeEntryValueHashKnown(findEntryByValue, smearedHash);
                if (i == this.size) {
                    i = findEntryByValue;
                }
            } else {
                throw new IllegalArgumentException("Value already present in map: " + v);
            }
        }
        deleteFromTableVToK(i, Hashing.smearedHash(this.values[i]));
        this.values[i] = v;
        insertIntoTableVToK(i, smearedHash);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceKeyInEntry(int i, @NullableDecl K k, boolean z) {
        Preconditions.checkArgument(i != -1);
        int smearedHash = Hashing.smearedHash(k);
        int findEntryByKey = findEntryByKey(k, smearedHash);
        int i2 = this.lastInInsertionOrder;
        int i3 = -2;
        if (findEntryByKey != -1) {
            if (z) {
                i2 = this.prevInInsertionOrder[findEntryByKey];
                i3 = this.nextInInsertionOrder[findEntryByKey];
                removeEntryKeyHashKnown(findEntryByKey, smearedHash);
                if (i == this.size) {
                    i = findEntryByKey;
                }
            } else {
                throw new IllegalArgumentException("Key already present in map: " + k);
            }
        }
        if (i2 == i) {
            i2 = this.prevInInsertionOrder[i];
        } else if (i2 == this.size) {
            i2 = findEntryByKey;
        }
        if (i3 == i) {
            findEntryByKey = this.nextInInsertionOrder[i];
        } else if (i3 != this.size) {
            findEntryByKey = i3;
        }
        setSucceeds(this.prevInInsertionOrder[i], this.nextInInsertionOrder[i]);
        deleteFromTableKToV(i, Hashing.smearedHash(this.keys[i]));
        this.keys[i] = k;
        insertIntoTableKToV(i, Hashing.smearedHash(k));
        setSucceeds(i2, i);
        setSucceeds(i, findEntryByKey);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public V remove(@NullableDecl Object obj) {
        int smearedHash = Hashing.smearedHash(obj);
        int findEntryByKey = findEntryByKey(obj, smearedHash);
        if (findEntryByKey == -1) {
            return null;
        }
        V v = this.values[findEntryByKey];
        removeEntryKeyHashKnown(findEntryByKey, smearedHash);
        return v;
    }

    @NullableDecl
    K removeInverse(@NullableDecl Object obj) {
        int smearedHash = Hashing.smearedHash(obj);
        int findEntryByValue = findEntryByValue(obj, smearedHash);
        if (findEntryByValue == -1) {
            return null;
        }
        K k = this.keys[findEntryByValue];
        removeEntryValueHashKnown(findEntryByValue, smearedHash);
        return k;
    }

    void removeEntry(int i) {
        removeEntryKeyHashKnown(i, Hashing.smearedHash(this.keys[i]));
    }

    private void removeEntry(int i, int i2, int i3) {
        Preconditions.checkArgument(i != -1);
        deleteFromTableKToV(i, i2);
        deleteFromTableVToK(i, i3);
        setSucceeds(this.prevInInsertionOrder[i], this.nextInInsertionOrder[i]);
        moveEntryToIndex(this.size - 1, i);
        K[] kArr = this.keys;
        int i4 = this.size;
        kArr[i4 - 1] = null;
        this.values[i4 - 1] = null;
        this.size = i4 - 1;
        this.modCount++;
    }

    void removeEntryKeyHashKnown(int i, int i2) {
        removeEntry(i, i2, Hashing.smearedHash(this.values[i]));
    }

    void removeEntryValueHashKnown(int i, int i2) {
        removeEntry(i, Hashing.smearedHash(this.keys[i]), i2);
    }

    private void moveEntryToIndex(int i, int i2) {
        int i3;
        int i4;
        if (i == i2) {
            return;
        }
        int i5 = this.prevInInsertionOrder[i];
        int i6 = this.nextInInsertionOrder[i];
        setSucceeds(i5, i2);
        setSucceeds(i2, i6);
        K[] kArr = this.keys;
        K k = kArr[i];
        V[] vArr = this.values;
        V v = vArr[i];
        kArr[i2] = k;
        vArr[i2] = v;
        int bucket = bucket(Hashing.smearedHash(k));
        int[] iArr = this.hashTableKToV;
        if (iArr[bucket] == i) {
            iArr[bucket] = i2;
        } else {
            int i7 = iArr[bucket];
            int i8 = this.nextInBucketKToV[i7];
            while (true) {
                int i9 = i8;
                i3 = i7;
                i7 = i9;
                if (i7 == i) {
                    break;
                } else {
                    i8 = this.nextInBucketKToV[i7];
                }
            }
            this.nextInBucketKToV[i3] = i2;
        }
        int[] iArr2 = this.nextInBucketKToV;
        iArr2[i2] = iArr2[i];
        iArr2[i] = -1;
        int bucket2 = bucket(Hashing.smearedHash(v));
        int[] iArr3 = this.hashTableVToK;
        if (iArr3[bucket2] == i) {
            iArr3[bucket2] = i2;
        } else {
            int i10 = iArr3[bucket2];
            int i11 = this.nextInBucketVToK[i10];
            while (true) {
                int i12 = i11;
                i4 = i10;
                i10 = i12;
                if (i10 == i) {
                    break;
                } else {
                    i11 = this.nextInBucketVToK[i10];
                }
            }
            this.nextInBucketVToK[i4] = i2;
        }
        int[] iArr4 = this.nextInBucketVToK;
        iArr4[i2] = iArr4[i];
        iArr4[i] = -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.hashTableKToV, -1);
        Arrays.fill(this.hashTableVToK, -1);
        Arrays.fill(this.nextInBucketKToV, 0, this.size, -1);
        Arrays.fill(this.nextInBucketVToK, 0, this.size, -1);
        Arrays.fill(this.prevInInsertionOrder, 0, this.size, -1);
        Arrays.fill(this.nextInInsertionOrder, 0, this.size, -1);
        this.size = 0;
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.modCount++;
    }

    static abstract class View<K, V, T> extends AbstractSet<T> {
        final HashBiMap<K, V> biMap;

        abstract T forEntry(int i);

        View(HashBiMap<K, V> hashBiMap) {
            this.biMap = hashBiMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<T> iterator() {
            return new Iterator<T>() { // from class: com.google.common.collect.HashBiMap.View.1
                private int expectedModCount;
                private int index;
                private int indexToRemove = -1;
                private int remaining;

                {
                    this.index = ((HashBiMap) View.this.biMap).firstInInsertionOrder;
                    this.expectedModCount = View.this.biMap.modCount;
                    this.remaining = View.this.biMap.size;
                }

                private void checkForComodification() {
                    if (View.this.biMap.modCount != this.expectedModCount) {
                        throw new ConcurrentModificationException();
                    }
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    checkForComodification();
                    return this.index != -2 && this.remaining > 0;
                }

                @Override // java.util.Iterator
                public T next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    T t = (T) View.this.forEntry(this.index);
                    this.indexToRemove = this.index;
                    this.index = ((HashBiMap) View.this.biMap).nextInInsertionOrder[this.index];
                    this.remaining--;
                    return t;
                }

                @Override // java.util.Iterator
                public void remove() {
                    checkForComodification();
                    CollectPreconditions.checkRemove(this.indexToRemove != -1);
                    View.this.biMap.removeEntry(this.indexToRemove);
                    if (this.index == View.this.biMap.size) {
                        this.index = this.indexToRemove;
                    }
                    this.indexToRemove = -1;
                    this.expectedModCount = View.this.biMap.modCount;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.biMap.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.biMap.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.keySet = keySet;
        return keySet;
    }

    final class KeySet extends View<K, V, K> {
        KeySet() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.View
        K forEntry(int i) {
            return HashBiMap.this.keys[i];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            int smearedHash = Hashing.smearedHash(obj);
            int findEntryByKey = HashBiMap.this.findEntryByKey(obj, smearedHash);
            if (findEntryByKey == -1) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, smearedHash);
            return true;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        ValueSet valueSet = new ValueSet();
        this.valueSet = valueSet;
        return valueSet;
    }

    final class ValueSet extends View<K, V, V> {
        ValueSet() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.View
        V forEntry(int i) {
            return HashBiMap.this.values[i];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            int smearedHash = Hashing.smearedHash(obj);
            int findEntryByValue = HashBiMap.this.findEntryByValue(obj, smearedHash);
            if (findEntryByValue == -1) {
                return false;
            }
            HashBiMap.this.removeEntryValueHashKnown(findEntryByValue, smearedHash);
            return true;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    final class EntrySet extends View<K, V, Map.Entry<K, V>> {
        EntrySet() {
            super(HashBiMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int findEntryByKey = HashBiMap.this.findEntryByKey(key);
            return findEntryByKey != -1 && Objects.equal(value, HashBiMap.this.values[findEntryByKey]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int smearedHash = Hashing.smearedHash(key);
            int findEntryByKey = HashBiMap.this.findEntryByKey(key, smearedHash);
            if (findEntryByKey == -1 || !Objects.equal(value, HashBiMap.this.values[findEntryByKey])) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, smearedHash);
            return true;
        }

        @Override // com.google.common.collect.HashBiMap.View
        Map.Entry<K, V> forEntry(int i) {
            return new EntryForKey(i);
        }
    }

    final class EntryForKey extends AbstractMapEntry<K, V> {
        int index;

        @NullableDecl
        final K key;

        EntryForKey(int i) {
            this.key = HashBiMap.this.keys[i];
            this.index = i;
        }

        void updateIndex() {
            int i = this.index;
            if (i == -1 || i > HashBiMap.this.size || !Objects.equal(HashBiMap.this.keys[this.index], this.key)) {
                this.index = HashBiMap.this.findEntryByKey(this.key);
            }
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @NullableDecl
        public V getValue() {
            updateIndex();
            if (this.index == -1) {
                return null;
            }
            return HashBiMap.this.values[this.index];
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(V v) {
            updateIndex();
            if (this.index == -1) {
                return (V) HashBiMap.this.put(this.key, v);
            }
            V v2 = HashBiMap.this.values[this.index];
            if (Objects.equal(v2, v)) {
                return v;
            }
            HashBiMap.this.replaceValueInEntry(this.index, v, false);
            return v2;
        }
    }

    @Override // com.google.common.collect.BiMap
    public BiMap<V, K> inverse() {
        BiMap<V, K> biMap = this.inverse;
        if (biMap != null) {
            return biMap;
        }
        Inverse inverse = new Inverse(this);
        this.inverse = inverse;
        return inverse;
    }

    static class Inverse<K, V> extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {
        private final HashBiMap<K, V> forward;
        private transient Set<Map.Entry<V, K>> inverseEntrySet;

        Inverse(HashBiMap<K, V> hashBiMap) {
            this.forward = hashBiMap;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.forward.size;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return this.forward.containsValue(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @NullableDecl
        public K get(@NullableDecl Object obj) {
            return this.forward.getInverse(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(@NullableDecl Object obj) {
            return this.forward.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        @NullableDecl
        public K put(@NullableDecl V v, @NullableDecl K k) {
            return this.forward.putInverse(v, k, false);
        }

        @Override // com.google.common.collect.BiMap
        @NullableDecl
        public K forcePut(@NullableDecl V v, @NullableDecl K k) {
            return this.forward.putInverse(v, k, true);
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<K, V> inverse() {
            return this.forward;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @NullableDecl
        public K remove(@NullableDecl Object obj) {
            return this.forward.removeInverse(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.forward.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return this.forward.values();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> values() {
            return this.forward.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.inverseEntrySet;
            if (set != null) {
                return set;
            }
            InverseEntrySet inverseEntrySet = new InverseEntrySet(this.forward);
            this.inverseEntrySet = inverseEntrySet;
            return inverseEntrySet;
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            ((HashBiMap) this.forward).inverse = this;
        }
    }

    static class InverseEntrySet<K, V> extends View<K, V, Map.Entry<V, K>> {
        InverseEntrySet(HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int findEntryByValue = this.biMap.findEntryByValue(key);
            return findEntryByValue != -1 && Objects.equal(this.biMap.keys[findEntryByValue], value);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int smearedHash = Hashing.smearedHash(key);
            int findEntryByValue = this.biMap.findEntryByValue(key, smearedHash);
            if (findEntryByValue == -1 || !Objects.equal(this.biMap.keys[findEntryByValue], value)) {
                return false;
            }
            this.biMap.removeEntryValueHashKnown(findEntryByValue, smearedHash);
            return true;
        }

        @Override // com.google.common.collect.HashBiMap.View
        Map.Entry<V, K> forEntry(int i) {
            return new EntryForValue(this.biMap, i);
        }
    }

    static final class EntryForValue<K, V> extends AbstractMapEntry<V, K> {
        final HashBiMap<K, V> biMap;
        int index;
        final V value;

        EntryForValue(HashBiMap<K, V> hashBiMap, int i) {
            this.biMap = hashBiMap;
            this.value = hashBiMap.values[i];
            this.index = i;
        }

        private void updateIndex() {
            int i = this.index;
            if (i == -1 || i > this.biMap.size || !Objects.equal(this.value, this.biMap.values[this.index])) {
                this.index = this.biMap.findEntryByValue(this.value);
            }
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getKey() {
            return this.value;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getValue() {
            updateIndex();
            if (this.index == -1) {
                return null;
            }
            return this.biMap.keys[this.index];
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K setValue(K k) {
            updateIndex();
            if (this.index == -1) {
                return this.biMap.putInverse(this.value, k, false);
            }
            K k2 = this.biMap.keys[this.index];
            if (Objects.equal(k2, k)) {
                return k;
            }
            this.biMap.replaceKeyInEntry(this.index, k, false);
            return k2;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMap(this, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readCount = Serialization.readCount(objectInputStream);
        init(16);
        Serialization.populateMap(this, objectInputStream, readCount);
    }
}
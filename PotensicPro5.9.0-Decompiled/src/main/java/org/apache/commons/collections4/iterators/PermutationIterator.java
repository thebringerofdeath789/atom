package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes4.dex */
public class PermutationIterator<E> implements Iterator<List<E>> {
    private final boolean[] direction;
    private final int[] keys;
    private List<E> nextPermutation;
    private final Map<Integer, E> objectMap;

    public PermutationIterator(Collection<? extends E> collection) {
        Objects.requireNonNull(collection, "The collection must not be null");
        this.keys = new int[collection.size()];
        boolean[] zArr = new boolean[collection.size()];
        this.direction = zArr;
        Arrays.fill(zArr, false);
        this.objectMap = new HashMap();
        Iterator<? extends E> it = collection.iterator();
        int i = 1;
        while (it.hasNext()) {
            this.objectMap.put(Integer.valueOf(i), it.next());
            this.keys[i - 1] = i;
            i++;
        }
        this.nextPermutation = new ArrayList(collection);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.nextPermutation != null;
    }

    @Override // java.util.Iterator
    public List<E> next() {
        int[] iArr;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        while (true) {
            iArr = this.keys;
            if (i2 >= iArr.length) {
                break;
            }
            boolean[] zArr = this.direction;
            if (((zArr[i2] && i2 < iArr.length - 1 && iArr[i2] > iArr[i2 + 1]) || (!zArr[i2] && i2 > 0 && iArr[i2] > iArr[i2 - 1])) && iArr[i2] > i3) {
                i3 = iArr[i2];
                i4 = i2;
            }
            i2++;
        }
        if (i3 == -1) {
            List<E> list = this.nextPermutation;
            this.nextPermutation = null;
            return list;
        }
        boolean[] zArr2 = this.direction;
        int i5 = zArr2[i4] ? 1 : -1;
        int i6 = iArr[i4];
        int i7 = i5 + i4;
        iArr[i4] = iArr[i7];
        iArr[i7] = i6;
        boolean z = zArr2[i4];
        zArr2[i4] = zArr2[i7];
        zArr2[i7] = z;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int[] iArr2 = this.keys;
            if (i < iArr2.length) {
                if (iArr2[i] > i3) {
                    this.direction[i] = !r4[i];
                }
                arrayList.add(this.objectMap.get(Integer.valueOf(iArr2[i])));
                i++;
            } else {
                List<E> list2 = this.nextPermutation;
                this.nextPermutation = arrayList;
                return list2;
            }
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }
}

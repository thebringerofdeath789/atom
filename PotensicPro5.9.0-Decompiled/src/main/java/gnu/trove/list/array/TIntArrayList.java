package gnu.trove.list.array;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.iterator.TIntIterator;
import gnu.trove.list.TIntList;
import gnu.trove.procedure.TIntProcedure;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TIntArrayList implements TIntList, Externalizable {
    protected static final int DEFAULT_CAPACITY = 10;
    static final long serialVersionUID = 1;
    protected int[] _data;
    protected int _pos;
    protected int no_entry_value;

    public TIntArrayList() {
        this(10, 0);
    }

    public TIntArrayList(int i) {
        this(i, 0);
    }

    public TIntArrayList(int i, int i2) {
        this._data = new int[i];
        this._pos = 0;
        this.no_entry_value = i2;
    }

    public TIntArrayList(TIntCollection tIntCollection) {
        this(tIntCollection.size());
        addAll(tIntCollection);
    }

    public TIntArrayList(int[] iArr) {
        this(iArr.length);
        add(iArr);
    }

    protected TIntArrayList(int[] iArr, int i, boolean z) {
        if (!z) {
            throw new IllegalStateException("Wrong call");
        }
        if (iArr == null) {
            throw new IllegalArgumentException("values can not be null");
        }
        this._data = iArr;
        this._pos = iArr.length;
        this.no_entry_value = i;
    }

    public static TIntArrayList wrap(int[] iArr) {
        return wrap(iArr, 0);
    }

    public static TIntArrayList wrap(int[] iArr, int i) {
        return new TIntArrayList(iArr, i, true) { // from class: gnu.trove.list.array.TIntArrayList.1
            @Override // gnu.trove.list.array.TIntArrayList
            public void ensureCapacity(int i2) {
                if (i2 > this._data.length) {
                    throw new IllegalStateException("Can not grow ArrayList wrapped external array");
                }
            }
        };
    }

    @Override // gnu.trove.list.TIntList, gnu.trove.TIntCollection
    public int getNoEntryValue() {
        return this.no_entry_value;
    }

    public void ensureCapacity(int i) {
        int[] iArr = this._data;
        if (i > iArr.length) {
            int[] iArr2 = new int[Math.max(iArr.length << 1, i)];
            int[] iArr3 = this._data;
            System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
            this._data = iArr2;
        }
    }

    @Override // gnu.trove.list.TIntList, gnu.trove.TIntCollection
    public int size() {
        return this._pos;
    }

    @Override // gnu.trove.list.TIntList, gnu.trove.TIntCollection
    public boolean isEmpty() {
        return this._pos == 0;
    }

    public void trimToSize() {
        if (this._data.length > size()) {
            int size = size();
            int[] iArr = new int[size];
            toArray(iArr, 0, size);
            this._data = iArr;
        }
    }

    @Override // gnu.trove.list.TIntList, gnu.trove.TIntCollection
    public boolean add(int i) {
        ensureCapacity(this._pos + 1);
        int[] iArr = this._data;
        int i2 = this._pos;
        this._pos = i2 + 1;
        iArr[i2] = i;
        return true;
    }

    @Override // gnu.trove.list.TIntList
    public void add(int[] iArr) {
        add(iArr, 0, iArr.length);
    }

    @Override // gnu.trove.list.TIntList
    public void add(int[] iArr, int i, int i2) {
        ensureCapacity(this._pos + i2);
        System.arraycopy(iArr, i, this._data, this._pos, i2);
        this._pos += i2;
    }

    @Override // gnu.trove.list.TIntList
    public void insert(int i, int i2) {
        int i3 = this._pos;
        if (i == i3) {
            add(i2);
            return;
        }
        ensureCapacity(i3 + 1);
        int[] iArr = this._data;
        System.arraycopy(iArr, i, iArr, i + 1, this._pos - i);
        this._data[i] = i2;
        this._pos++;
    }

    @Override // gnu.trove.list.TIntList
    public void insert(int i, int[] iArr) {
        insert(i, iArr, 0, iArr.length);
    }

    @Override // gnu.trove.list.TIntList
    public void insert(int i, int[] iArr, int i2, int i3) {
        int i4 = this._pos;
        if (i == i4) {
            add(iArr, i2, i3);
            return;
        }
        ensureCapacity(i4 + i3);
        int[] iArr2 = this._data;
        System.arraycopy(iArr2, i, iArr2, i + i3, this._pos - i);
        System.arraycopy(iArr, i2, this._data, i, i3);
        this._pos += i3;
    }

    @Override // gnu.trove.list.TIntList
    public int get(int i) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        return this._data[i];
    }

    public int getQuick(int i) {
        return this._data[i];
    }

    @Override // gnu.trove.list.TIntList
    public int set(int i, int i2) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        int[] iArr = this._data;
        int i3 = iArr[i];
        iArr[i] = i2;
        return i3;
    }

    @Override // gnu.trove.list.TIntList
    public int replace(int i, int i2) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        int[] iArr = this._data;
        int i3 = iArr[i];
        iArr[i] = i2;
        return i3;
    }

    @Override // gnu.trove.list.TIntList
    public void set(int i, int[] iArr) {
        set(i, iArr, 0, iArr.length);
    }

    @Override // gnu.trove.list.TIntList
    public void set(int i, int[] iArr, int i2, int i3) {
        if (i < 0 || i + i3 > this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(iArr, i2, this._data, i, i3);
    }

    public void setQuick(int i, int i2) {
        this._data[i] = i2;
    }

    @Override // gnu.trove.list.TIntList, gnu.trove.TIntCollection
    public void clear() {
        clearQuick();
        Arrays.fill(this._data, this.no_entry_value);
    }

    public void clearQuick() {
        this._pos = 0;
    }

    @Override // gnu.trove.list.TIntList, gnu.trove.TIntCollection
    public boolean remove(int i) {
        for (int i2 = 0; i2 < this._pos; i2++) {
            if (i == this._data[i2]) {
                remove(i2, 1);
                return true;
            }
        }
        return false;
    }

    @Override // gnu.trove.list.TIntList
    public int removeAt(int i) {
        int i2 = get(i);
        remove(i, 1);
        return i2;
    }

    @Override // gnu.trove.list.TIntList
    public void remove(int i, int i2) {
        int i3;
        if (i2 == 0) {
            return;
        }
        if (i < 0 || i >= (i3 = this._pos)) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        if (i == 0) {
            int[] iArr = this._data;
            System.arraycopy(iArr, i2, iArr, 0, i3 - i2);
        } else if (i3 - i2 != i) {
            int[] iArr2 = this._data;
            int i4 = i + i2;
            System.arraycopy(iArr2, i4, iArr2, i, i3 - i4);
        }
        this._pos -= i2;
    }

    @Override // gnu.trove.TIntCollection
    public TIntIterator iterator() {
        return new TIntArrayIterator(0);
    }

    @Override // gnu.trove.TIntCollection
    public boolean containsAll(Collection<?> collection) {
        for (Object obj : collection) {
            if (!(obj instanceof Integer) || !contains(((Integer) obj).intValue())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.TIntCollection
    public boolean containsAll(TIntCollection tIntCollection) {
        if (this == tIntCollection) {
            return true;
        }
        TIntIterator it = tIntCollection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.TIntCollection
    public boolean containsAll(int[] iArr) {
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!contains(iArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.TIntCollection
    public boolean addAll(Collection<? extends Integer> collection) {
        Iterator<? extends Integer> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next().intValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TIntCollection
    public boolean addAll(TIntCollection tIntCollection) {
        TIntIterator it = tIntCollection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TIntCollection
    public boolean addAll(int[] iArr) {
        boolean z = false;
        for (int i : iArr) {
            if (add(i)) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TIntCollection
    public boolean retainAll(Collection<?> collection) {
        TIntIterator it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(Integer.valueOf(it.next()))) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TIntCollection
    public boolean retainAll(TIntCollection tIntCollection) {
        boolean z = false;
        if (this == tIntCollection) {
            return false;
        }
        TIntIterator it = iterator();
        while (it.hasNext()) {
            if (!tIntCollection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TIntCollection
    public boolean retainAll(int[] iArr) {
        Arrays.sort(iArr);
        int[] iArr2 = this._data;
        int i = this._pos;
        boolean z = false;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return z;
            }
            if (Arrays.binarySearch(iArr, iArr2[i2]) < 0) {
                remove(i2, 1);
                z = true;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.TIntCollection
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object obj : collection) {
            if ((obj instanceof Integer) && remove(((Integer) obj).intValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TIntCollection
    public boolean removeAll(TIntCollection tIntCollection) {
        if (tIntCollection == this) {
            clear();
            return true;
        }
        boolean z = false;
        TIntIterator it = tIntCollection.iterator();
        while (it.hasNext()) {
            if (remove(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TIntCollection
    public boolean removeAll(int[] iArr) {
        int length = iArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return z;
            }
            if (remove(iArr[i])) {
                z = true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.list.TIntList
    public void transformValues(TIntFunction tIntFunction) {
        for (int i = 0; i < this._pos; i++) {
            int[] iArr = this._data;
            iArr[i] = tIntFunction.execute(iArr[i]);
        }
    }

    @Override // gnu.trove.list.TIntList
    public void reverse() {
        reverse(0, this._pos);
    }

    @Override // gnu.trove.list.TIntList
    public void reverse(int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i > i2) {
            throw new IllegalArgumentException("from cannot be greater than to");
        }
        for (int i3 = i2 - 1; i < i3; i3--) {
            swap(i, i3);
            i++;
        }
    }

    @Override // gnu.trove.list.TIntList
    public void shuffle(Random random) {
        int i = this._pos;
        while (true) {
            int i2 = i - 1;
            if (i <= 1) {
                return;
            }
            swap(i2, random.nextInt(i2));
            i = i2;
        }
    }

    private void swap(int i, int i2) {
        int[] iArr = this._data;
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    @Override // gnu.trove.list.TIntList
    public TIntList subList(int i, int i2) {
        if (i2 < i) {
            throw new IllegalArgumentException("end index " + i2 + " greater than begin index " + i);
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("begin index can not be < 0");
        }
        if (i2 > this._data.length) {
            throw new IndexOutOfBoundsException("end index < " + this._data.length);
        }
        TIntArrayList tIntArrayList = new TIntArrayList(i2 - i);
        while (i < i2) {
            tIntArrayList.add(this._data[i]);
            i++;
        }
        return tIntArrayList;
    }

    @Override // gnu.trove.list.TIntList, gnu.trove.TIntCollection
    public int[] toArray() {
        return toArray(0, this._pos);
    }

    @Override // gnu.trove.list.TIntList
    public int[] toArray(int i, int i2) {
        int[] iArr = new int[i2];
        toArray(iArr, i, i2);
        return iArr;
    }

    @Override // gnu.trove.list.TIntList, gnu.trove.TIntCollection
    public int[] toArray(int[] iArr) {
        int length = iArr.length;
        int length2 = iArr.length;
        int i = this._pos;
        if (length2 > i) {
            iArr[i] = this.no_entry_value;
            length = i;
        }
        toArray(iArr, 0, length);
        return iArr;
    }

    @Override // gnu.trove.list.TIntList
    public int[] toArray(int[] iArr, int i, int i2) {
        if (i2 == 0) {
            return iArr;
        }
        if (i < 0 || i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(this._data, i, iArr, 0, i2);
        return iArr;
    }

    @Override // gnu.trove.list.TIntList
    public int[] toArray(int[] iArr, int i, int i2, int i3) {
        if (i3 == 0) {
            return iArr;
        }
        if (i < 0 || i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(this._data, i, iArr, i2, i3);
        return iArr;
    }

    @Override // gnu.trove.TIntCollection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TIntList)) {
            return false;
        }
        if (obj instanceof TIntArrayList) {
            TIntArrayList tIntArrayList = (TIntArrayList) obj;
            if (tIntArrayList.size() != size()) {
                return false;
            }
            int i = this._pos;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return true;
                }
                if (this._data[i2] != tIntArrayList._data[i2]) {
                    return false;
                }
                i = i2;
            }
        } else {
            TIntList tIntList = (TIntList) obj;
            if (tIntList.size() != size()) {
                return false;
            }
            for (int i3 = 0; i3 < this._pos; i3++) {
                if (this._data[i3] != tIntList.get(i3)) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // gnu.trove.TIntCollection
    public int hashCode() {
        int i = this._pos;
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                return i2;
            }
            i2 += HashFunctions.hash(this._data[i3]);
            i = i3;
        }
    }

    @Override // gnu.trove.list.TIntList, gnu.trove.TIntCollection
    public boolean forEach(TIntProcedure tIntProcedure) {
        for (int i = 0; i < this._pos; i++) {
            if (!tIntProcedure.execute(this._data[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.list.TIntList
    public boolean forEachDescending(TIntProcedure tIntProcedure) {
        int i = this._pos;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return true;
            }
            if (!tIntProcedure.execute(this._data[i2])) {
                return false;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.list.TIntList
    public void sort() {
        Arrays.sort(this._data, 0, this._pos);
    }

    @Override // gnu.trove.list.TIntList
    public void sort(int i, int i2) {
        Arrays.sort(this._data, i, i2);
    }

    @Override // gnu.trove.list.TIntList
    public void fill(int i) {
        Arrays.fill(this._data, 0, this._pos, i);
    }

    @Override // gnu.trove.list.TIntList
    public void fill(int i, int i2, int i3) {
        if (i2 > this._pos) {
            ensureCapacity(i2);
            this._pos = i2;
        }
        Arrays.fill(this._data, i, i2, i3);
    }

    @Override // gnu.trove.list.TIntList
    public int binarySearch(int i) {
        return binarySearch(i, 0, this._pos);
    }

    @Override // gnu.trove.list.TIntList
    public int binarySearch(int i, int i2, int i3) {
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException(i2);
        }
        if (i3 > this._pos) {
            throw new ArrayIndexOutOfBoundsException(i3);
        }
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int i6 = this._data[i5];
            if (i6 < i) {
                i2 = i5 + 1;
            } else {
                if (i6 <= i) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    @Override // gnu.trove.list.TIntList
    public int indexOf(int i) {
        return indexOf(0, i);
    }

    @Override // gnu.trove.list.TIntList
    public int indexOf(int i, int i2) {
        while (i < this._pos) {
            if (this._data[i] == i2) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // gnu.trove.list.TIntList
    public int lastIndexOf(int i) {
        return lastIndexOf(this._pos, i);
    }

    @Override // gnu.trove.list.TIntList
    public int lastIndexOf(int i, int i2) {
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                return -1;
            }
            if (this._data[i3] == i2) {
                return i3;
            }
            i = i3;
        }
    }

    @Override // gnu.trove.list.TIntList, gnu.trove.TIntCollection
    public boolean contains(int i) {
        return lastIndexOf(i) >= 0;
    }

    @Override // gnu.trove.list.TIntList
    public TIntList grep(TIntProcedure tIntProcedure) {
        TIntArrayList tIntArrayList = new TIntArrayList();
        for (int i = 0; i < this._pos; i++) {
            if (tIntProcedure.execute(this._data[i])) {
                tIntArrayList.add(this._data[i]);
            }
        }
        return tIntArrayList;
    }

    @Override // gnu.trove.list.TIntList
    public TIntList inverseGrep(TIntProcedure tIntProcedure) {
        TIntArrayList tIntArrayList = new TIntArrayList();
        for (int i = 0; i < this._pos; i++) {
            if (!tIntProcedure.execute(this._data[i])) {
                tIntArrayList.add(this._data[i]);
            }
        }
        return tIntArrayList;
    }

    @Override // gnu.trove.list.TIntList
    public int max() {
        if (size() == 0) {
            throw new IllegalStateException("cannot find maximum of an empty list");
        }
        int i = Integer.MIN_VALUE;
        for (int i2 = 0; i2 < this._pos; i2++) {
            int[] iArr = this._data;
            if (iArr[i2] > i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    @Override // gnu.trove.list.TIntList
    public int min() {
        if (size() == 0) {
            throw new IllegalStateException("cannot find minimum of an empty list");
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < this._pos; i2++) {
            int[] iArr = this._data;
            if (iArr[i2] < i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    @Override // gnu.trove.list.TIntList
    public int sum() {
        int i = 0;
        for (int i2 = 0; i2 < this._pos; i2++) {
            i += this._data[i2];
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        int i = this._pos - 1;
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(this._data[i2]);
            sb.append(", ");
        }
        if (size() > 0) {
            sb.append(this._data[this._pos - 1]);
        }
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    class TIntArrayIterator implements TIntIterator {
        private int cursor;
        int lastRet = -1;

        TIntArrayIterator(int i) {
            this.cursor = 0;
            this.cursor = i;
        }

        @Override // gnu.trove.iterator.TIterator, java.util.Iterator
        public boolean hasNext() {
            return this.cursor < TIntArrayList.this.size();
        }

        @Override // gnu.trove.iterator.TIntIterator
        public int next() {
            try {
                int i = TIntArrayList.this.get(this.cursor);
                int i2 = this.cursor;
                this.cursor = i2 + 1;
                this.lastRet = i2;
                return i;
            } catch (IndexOutOfBoundsException unused) {
                throw new NoSuchElementException();
            }
        }

        @Override // gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            int i = this.lastRet;
            if (i == -1) {
                throw new IllegalStateException();
            }
            try {
                TIntArrayList.this.remove(i, 1);
                int i2 = this.lastRet;
                int i3 = this.cursor;
                if (i2 < i3) {
                    this.cursor = i3 - 1;
                }
                this.lastRet = -1;
            } catch (IndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeInt(this._pos);
        objectOutput.writeInt(this.no_entry_value);
        int length = this._data.length;
        objectOutput.writeInt(length);
        for (int i = 0; i < length; i++) {
            objectOutput.writeInt(this._data[i]);
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._pos = objectInput.readInt();
        this.no_entry_value = objectInput.readInt();
        int readInt = objectInput.readInt();
        this._data = new int[readInt];
        for (int i = 0; i < readInt; i++) {
            this._data[i] = objectInput.readInt();
        }
    }
}

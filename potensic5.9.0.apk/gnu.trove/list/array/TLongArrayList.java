package gnu.trove.list.array;

import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.iterator.TLongIterator;
import gnu.trove.list.TLongList;
import gnu.trove.procedure.TLongProcedure;
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
public class TLongArrayList implements TLongList, Externalizable {
    protected static final int DEFAULT_CAPACITY = 10;
    static final long serialVersionUID = 1;
    protected long[] _data;
    protected int _pos;
    protected long no_entry_value;

    public TLongArrayList() {
        this(10, 0L);
    }

    public TLongArrayList(int i) {
        this(i, 0L);
    }

    public TLongArrayList(int i, long j) {
        this._data = new long[i];
        this._pos = 0;
        this.no_entry_value = j;
    }

    public TLongArrayList(TLongCollection tLongCollection) {
        this(tLongCollection.size());
        addAll(tLongCollection);
    }

    public TLongArrayList(long[] jArr) {
        this(jArr.length);
        add(jArr);
    }

    protected TLongArrayList(long[] jArr, long j, boolean z) {
        if (!z) {
            throw new IllegalStateException("Wrong call");
        }
        if (jArr == null) {
            throw new IllegalArgumentException("values can not be null");
        }
        this._data = jArr;
        this._pos = jArr.length;
        this.no_entry_value = j;
    }

    public static TLongArrayList wrap(long[] jArr) {
        return wrap(jArr, 0L);
    }

    public static TLongArrayList wrap(long[] jArr, long j) {
        return new TLongArrayList(jArr, j, true) { // from class: gnu.trove.list.array.TLongArrayList.1
            @Override // gnu.trove.list.array.TLongArrayList
            public void ensureCapacity(int i) {
                if (i > this._data.length) {
                    throw new IllegalStateException("Can not grow ArrayList wrapped external array");
                }
            }
        };
    }

    @Override // gnu.trove.list.TLongList, gnu.trove.TLongCollection
    public long getNoEntryValue() {
        return this.no_entry_value;
    }

    public void ensureCapacity(int i) {
        long[] jArr = this._data;
        if (i > jArr.length) {
            long[] jArr2 = new long[Math.max(jArr.length << 1, i)];
            long[] jArr3 = this._data;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this._data = jArr2;
        }
    }

    @Override // gnu.trove.list.TLongList, gnu.trove.TLongCollection
    public int size() {
        return this._pos;
    }

    @Override // gnu.trove.list.TLongList, gnu.trove.TLongCollection
    public boolean isEmpty() {
        return this._pos == 0;
    }

    public void trimToSize() {
        if (this._data.length > size()) {
            int size = size();
            long[] jArr = new long[size];
            toArray(jArr, 0, size);
            this._data = jArr;
        }
    }

    @Override // gnu.trove.list.TLongList, gnu.trove.TLongCollection
    public boolean add(long j) {
        ensureCapacity(this._pos + 1);
        long[] jArr = this._data;
        int i = this._pos;
        this._pos = i + 1;
        jArr[i] = j;
        return true;
    }

    @Override // gnu.trove.list.TLongList
    public void add(long[] jArr) {
        add(jArr, 0, jArr.length);
    }

    @Override // gnu.trove.list.TLongList
    public void add(long[] jArr, int i, int i2) {
        ensureCapacity(this._pos + i2);
        System.arraycopy(jArr, i, this._data, this._pos, i2);
        this._pos += i2;
    }

    @Override // gnu.trove.list.TLongList
    public void insert(int i, long j) {
        int i2 = this._pos;
        if (i == i2) {
            add(j);
            return;
        }
        ensureCapacity(i2 + 1);
        long[] jArr = this._data;
        System.arraycopy(jArr, i, jArr, i + 1, this._pos - i);
        this._data[i] = j;
        this._pos++;
    }

    @Override // gnu.trove.list.TLongList
    public void insert(int i, long[] jArr) {
        insert(i, jArr, 0, jArr.length);
    }

    @Override // gnu.trove.list.TLongList
    public void insert(int i, long[] jArr, int i2, int i3) {
        int i4 = this._pos;
        if (i == i4) {
            add(jArr, i2, i3);
            return;
        }
        ensureCapacity(i4 + i3);
        long[] jArr2 = this._data;
        System.arraycopy(jArr2, i, jArr2, i + i3, this._pos - i);
        System.arraycopy(jArr, i2, this._data, i, i3);
        this._pos += i3;
    }

    @Override // gnu.trove.list.TLongList
    public long get(int i) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        return this._data[i];
    }

    public long getQuick(int i) {
        return this._data[i];
    }

    @Override // gnu.trove.list.TLongList
    public long set(int i, long j) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        long[] jArr = this._data;
        long j2 = jArr[i];
        jArr[i] = j;
        return j2;
    }

    @Override // gnu.trove.list.TLongList
    public long replace(int i, long j) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        long[] jArr = this._data;
        long j2 = jArr[i];
        jArr[i] = j;
        return j2;
    }

    @Override // gnu.trove.list.TLongList
    public void set(int i, long[] jArr) {
        set(i, jArr, 0, jArr.length);
    }

    @Override // gnu.trove.list.TLongList
    public void set(int i, long[] jArr, int i2, int i3) {
        if (i < 0 || i + i3 > this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(jArr, i2, this._data, i, i3);
    }

    public void setQuick(int i, long j) {
        this._data[i] = j;
    }

    @Override // gnu.trove.list.TLongList, gnu.trove.TLongCollection
    public void clear() {
        clearQuick();
        Arrays.fill(this._data, this.no_entry_value);
    }

    public void clearQuick() {
        this._pos = 0;
    }

    @Override // gnu.trove.list.TLongList, gnu.trove.TLongCollection
    public boolean remove(long j) {
        for (int i = 0; i < this._pos; i++) {
            if (j == this._data[i]) {
                remove(i, 1);
                return true;
            }
        }
        return false;
    }

    @Override // gnu.trove.list.TLongList
    public long removeAt(int i) {
        long j = get(i);
        remove(i, 1);
        return j;
    }

    @Override // gnu.trove.list.TLongList
    public void remove(int i, int i2) {
        int i3;
        if (i2 == 0) {
            return;
        }
        if (i < 0 || i >= (i3 = this._pos)) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        if (i == 0) {
            long[] jArr = this._data;
            System.arraycopy(jArr, i2, jArr, 0, i3 - i2);
        } else if (i3 - i2 != i) {
            long[] jArr2 = this._data;
            int i4 = i + i2;
            System.arraycopy(jArr2, i4, jArr2, i, i3 - i4);
        }
        this._pos -= i2;
    }

    @Override // gnu.trove.TLongCollection
    public TLongIterator iterator() {
        return new TLongArrayIterator(0);
    }

    @Override // gnu.trove.TLongCollection
    public boolean containsAll(Collection<?> collection) {
        for (Object obj : collection) {
            if (!(obj instanceof Long) || !contains(((Long) obj).longValue())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.TLongCollection
    public boolean containsAll(TLongCollection tLongCollection) {
        if (this == tLongCollection) {
            return true;
        }
        TLongIterator it = tLongCollection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.TLongCollection
    public boolean containsAll(long[] jArr) {
        int length = jArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!contains(jArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.TLongCollection
    public boolean addAll(Collection<? extends Long> collection) {
        Iterator<? extends Long> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next().longValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TLongCollection
    public boolean addAll(TLongCollection tLongCollection) {
        TLongIterator it = tLongCollection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TLongCollection
    public boolean addAll(long[] jArr) {
        boolean z = false;
        for (long j : jArr) {
            if (add(j)) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TLongCollection
    public boolean retainAll(Collection<?> collection) {
        TLongIterator it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(Long.valueOf(it.next()))) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TLongCollection
    public boolean retainAll(TLongCollection tLongCollection) {
        boolean z = false;
        if (this == tLongCollection) {
            return false;
        }
        TLongIterator it = iterator();
        while (it.hasNext()) {
            if (!tLongCollection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TLongCollection
    public boolean retainAll(long[] jArr) {
        Arrays.sort(jArr);
        long[] jArr2 = this._data;
        int i = this._pos;
        boolean z = false;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return z;
            }
            if (Arrays.binarySearch(jArr, jArr2[i2]) < 0) {
                remove(i2, 1);
                z = true;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.TLongCollection
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object obj : collection) {
            if ((obj instanceof Long) && remove(((Long) obj).longValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TLongCollection
    public boolean removeAll(TLongCollection tLongCollection) {
        if (tLongCollection == this) {
            clear();
            return true;
        }
        boolean z = false;
        TLongIterator it = tLongCollection.iterator();
        while (it.hasNext()) {
            if (remove(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TLongCollection
    public boolean removeAll(long[] jArr) {
        int length = jArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return z;
            }
            if (remove(jArr[i])) {
                z = true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.list.TLongList
    public void transformValues(TLongFunction tLongFunction) {
        for (int i = 0; i < this._pos; i++) {
            long[] jArr = this._data;
            jArr[i] = tLongFunction.execute(jArr[i]);
        }
    }

    @Override // gnu.trove.list.TLongList
    public void reverse() {
        reverse(0, this._pos);
    }

    @Override // gnu.trove.list.TLongList
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

    @Override // gnu.trove.list.TLongList
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
        long[] jArr = this._data;
        long j = jArr[i];
        jArr[i] = jArr[i2];
        jArr[i2] = j;
    }

    @Override // gnu.trove.list.TLongList
    public TLongList subList(int i, int i2) {
        if (i2 < i) {
            throw new IllegalArgumentException("end index " + i2 + " greater than begin index " + i);
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("begin index can not be < 0");
        }
        if (i2 > this._data.length) {
            throw new IndexOutOfBoundsException("end index < " + this._data.length);
        }
        TLongArrayList tLongArrayList = new TLongArrayList(i2 - i);
        while (i < i2) {
            tLongArrayList.add(this._data[i]);
            i++;
        }
        return tLongArrayList;
    }

    @Override // gnu.trove.list.TLongList, gnu.trove.TLongCollection
    public long[] toArray() {
        return toArray(0, this._pos);
    }

    @Override // gnu.trove.list.TLongList
    public long[] toArray(int i, int i2) {
        long[] jArr = new long[i2];
        toArray(jArr, i, i2);
        return jArr;
    }

    @Override // gnu.trove.list.TLongList, gnu.trove.TLongCollection
    public long[] toArray(long[] jArr) {
        int length = jArr.length;
        int length2 = jArr.length;
        int i = this._pos;
        if (length2 > i) {
            jArr[i] = this.no_entry_value;
            length = i;
        }
        toArray(jArr, 0, length);
        return jArr;
    }

    @Override // gnu.trove.list.TLongList
    public long[] toArray(long[] jArr, int i, int i2) {
        if (i2 == 0) {
            return jArr;
        }
        if (i < 0 || i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(this._data, i, jArr, 0, i2);
        return jArr;
    }

    @Override // gnu.trove.list.TLongList
    public long[] toArray(long[] jArr, int i, int i2, int i3) {
        if (i3 == 0) {
            return jArr;
        }
        if (i < 0 || i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(this._data, i, jArr, i2, i3);
        return jArr;
    }

    @Override // gnu.trove.TLongCollection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TLongList)) {
            return false;
        }
        if (obj instanceof TLongArrayList) {
            TLongArrayList tLongArrayList = (TLongArrayList) obj;
            if (tLongArrayList.size() != size()) {
                return false;
            }
            int i = this._pos;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return true;
                }
                if (this._data[i2] != tLongArrayList._data[i2]) {
                    return false;
                }
                i = i2;
            }
        } else {
            TLongList tLongList = (TLongList) obj;
            if (tLongList.size() != size()) {
                return false;
            }
            for (int i3 = 0; i3 < this._pos; i3++) {
                if (this._data[i3] != tLongList.get(i3)) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // gnu.trove.TLongCollection
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

    @Override // gnu.trove.list.TLongList, gnu.trove.TLongCollection
    public boolean forEach(TLongProcedure tLongProcedure) {
        for (int i = 0; i < this._pos; i++) {
            if (!tLongProcedure.execute(this._data[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.list.TLongList
    public boolean forEachDescending(TLongProcedure tLongProcedure) {
        int i = this._pos;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return true;
            }
            if (!tLongProcedure.execute(this._data[i2])) {
                return false;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.list.TLongList
    public void sort() {
        Arrays.sort(this._data, 0, this._pos);
    }

    @Override // gnu.trove.list.TLongList
    public void sort(int i, int i2) {
        Arrays.sort(this._data, i, i2);
    }

    @Override // gnu.trove.list.TLongList
    public void fill(long j) {
        Arrays.fill(this._data, 0, this._pos, j);
    }

    @Override // gnu.trove.list.TLongList
    public void fill(int i, int i2, long j) {
        if (i2 > this._pos) {
            ensureCapacity(i2);
            this._pos = i2;
        }
        Arrays.fill(this._data, i, i2, j);
    }

    @Override // gnu.trove.list.TLongList
    public int binarySearch(long j) {
        return binarySearch(j, 0, this._pos);
    }

    @Override // gnu.trove.list.TLongList
    public int binarySearch(long j, int i, int i2) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        if (i2 > this._pos) {
            throw new ArrayIndexOutOfBoundsException(i2);
        }
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            long j2 = this._data[i4];
            if (j2 < j) {
                i = i4 + 1;
            } else {
                if (j2 <= j) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    @Override // gnu.trove.list.TLongList
    public int indexOf(long j) {
        return indexOf(0, j);
    }

    @Override // gnu.trove.list.TLongList
    public int indexOf(int i, long j) {
        while (i < this._pos) {
            if (this._data[i] == j) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // gnu.trove.list.TLongList
    public int lastIndexOf(long j) {
        return lastIndexOf(this._pos, j);
    }

    @Override // gnu.trove.list.TLongList
    public int lastIndexOf(int i, long j) {
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return -1;
            }
            if (this._data[i2] == j) {
                return i2;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.list.TLongList, gnu.trove.TLongCollection
    public boolean contains(long j) {
        return lastIndexOf(j) >= 0;
    }

    @Override // gnu.trove.list.TLongList
    public TLongList grep(TLongProcedure tLongProcedure) {
        TLongArrayList tLongArrayList = new TLongArrayList();
        for (int i = 0; i < this._pos; i++) {
            if (tLongProcedure.execute(this._data[i])) {
                tLongArrayList.add(this._data[i]);
            }
        }
        return tLongArrayList;
    }

    @Override // gnu.trove.list.TLongList
    public TLongList inverseGrep(TLongProcedure tLongProcedure) {
        TLongArrayList tLongArrayList = new TLongArrayList();
        for (int i = 0; i < this._pos; i++) {
            if (!tLongProcedure.execute(this._data[i])) {
                tLongArrayList.add(this._data[i]);
            }
        }
        return tLongArrayList;
    }

    @Override // gnu.trove.list.TLongList
    public long max() {
        if (size() == 0) {
            throw new IllegalStateException("cannot find maximum of an empty list");
        }
        long j = Long.MIN_VALUE;
        for (int i = 0; i < this._pos; i++) {
            long[] jArr = this._data;
            if (jArr[i] > j) {
                j = jArr[i];
            }
        }
        return j;
    }

    @Override // gnu.trove.list.TLongList
    public long min() {
        if (size() == 0) {
            throw new IllegalStateException("cannot find minimum of an empty list");
        }
        long j = Long.MAX_VALUE;
        for (int i = 0; i < this._pos; i++) {
            long[] jArr = this._data;
            if (jArr[i] < j) {
                j = jArr[i];
            }
        }
        return j;
    }

    @Override // gnu.trove.list.TLongList
    public long sum() {
        long j = 0;
        for (int i = 0; i < this._pos; i++) {
            j += this._data[i];
        }
        return j;
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

    class TLongArrayIterator implements TLongIterator {
        private int cursor;
        int lastRet = -1;

        TLongArrayIterator(int i) {
            this.cursor = 0;
            this.cursor = i;
        }

        @Override // gnu.trove.iterator.TIterator, java.util.Iterator
        public boolean hasNext() {
            return this.cursor < TLongArrayList.this.size();
        }

        @Override // gnu.trove.iterator.TLongIterator
        public long next() {
            try {
                long j = TLongArrayList.this.get(this.cursor);
                int i = this.cursor;
                this.cursor = i + 1;
                this.lastRet = i;
                return j;
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
                TLongArrayList.this.remove(i, 1);
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
        objectOutput.writeLong(this.no_entry_value);
        int length = this._data.length;
        objectOutput.writeInt(length);
        for (int i = 0; i < length; i++) {
            objectOutput.writeLong(this._data[i]);
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._pos = objectInput.readInt();
        this.no_entry_value = objectInput.readLong();
        int readInt = objectInput.readInt();
        this._data = new long[readInt];
        for (int i = 0; i < readInt; i++) {
            this._data[i] = objectInput.readLong();
        }
    }
}
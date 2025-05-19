package gnu.trove.list.array;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.iterator.TShortIterator;
import gnu.trove.list.TShortList;
import gnu.trove.procedure.TShortProcedure;
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
import kotlin.jvm.internal.ShortCompanionObject;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TShortArrayList implements TShortList, Externalizable {
    protected static final int DEFAULT_CAPACITY = 10;
    static final long serialVersionUID = 1;
    protected short[] _data;
    protected int _pos;
    protected short no_entry_value;

    public TShortArrayList() {
        this(10, (short) 0);
    }

    public TShortArrayList(int i) {
        this(i, (short) 0);
    }

    public TShortArrayList(int i, short s) {
        this._data = new short[i];
        this._pos = 0;
        this.no_entry_value = s;
    }

    public TShortArrayList(TShortCollection tShortCollection) {
        this(tShortCollection.size());
        addAll(tShortCollection);
    }

    public TShortArrayList(short[] sArr) {
        this(sArr.length);
        add(sArr);
    }

    protected TShortArrayList(short[] sArr, short s, boolean z) {
        if (!z) {
            throw new IllegalStateException("Wrong call");
        }
        if (sArr == null) {
            throw new IllegalArgumentException("values can not be null");
        }
        this._data = sArr;
        this._pos = sArr.length;
        this.no_entry_value = s;
    }

    public static TShortArrayList wrap(short[] sArr) {
        return wrap(sArr, (short) 0);
    }

    public static TShortArrayList wrap(short[] sArr, short s) {
        return new TShortArrayList(sArr, s, true) { // from class: gnu.trove.list.array.TShortArrayList.1
            @Override // gnu.trove.list.array.TShortArrayList
            public void ensureCapacity(int i) {
                if (i > this._data.length) {
                    throw new IllegalStateException("Can not grow ArrayList wrapped external array");
                }
            }
        };
    }

    @Override // gnu.trove.list.TShortList, gnu.trove.TShortCollection
    public short getNoEntryValue() {
        return this.no_entry_value;
    }

    public void ensureCapacity(int i) {
        short[] sArr = this._data;
        if (i > sArr.length) {
            short[] sArr2 = new short[Math.max(sArr.length << 1, i)];
            short[] sArr3 = this._data;
            System.arraycopy(sArr3, 0, sArr2, 0, sArr3.length);
            this._data = sArr2;
        }
    }

    @Override // gnu.trove.list.TShortList, gnu.trove.TShortCollection
    public int size() {
        return this._pos;
    }

    @Override // gnu.trove.list.TShortList, gnu.trove.TShortCollection
    public boolean isEmpty() {
        return this._pos == 0;
    }

    public void trimToSize() {
        if (this._data.length > size()) {
            int size = size();
            short[] sArr = new short[size];
            toArray(sArr, 0, size);
            this._data = sArr;
        }
    }

    @Override // gnu.trove.list.TShortList, gnu.trove.TShortCollection
    public boolean add(short s) {
        ensureCapacity(this._pos + 1);
        short[] sArr = this._data;
        int i = this._pos;
        this._pos = i + 1;
        sArr[i] = s;
        return true;
    }

    @Override // gnu.trove.list.TShortList
    public void add(short[] sArr) {
        add(sArr, 0, sArr.length);
    }

    @Override // gnu.trove.list.TShortList
    public void add(short[] sArr, int i, int i2) {
        ensureCapacity(this._pos + i2);
        System.arraycopy(sArr, i, this._data, this._pos, i2);
        this._pos += i2;
    }

    @Override // gnu.trove.list.TShortList
    public void insert(int i, short s) {
        int i2 = this._pos;
        if (i == i2) {
            add(s);
            return;
        }
        ensureCapacity(i2 + 1);
        short[] sArr = this._data;
        System.arraycopy(sArr, i, sArr, i + 1, this._pos - i);
        this._data[i] = s;
        this._pos++;
    }

    @Override // gnu.trove.list.TShortList
    public void insert(int i, short[] sArr) {
        insert(i, sArr, 0, sArr.length);
    }

    @Override // gnu.trove.list.TShortList
    public void insert(int i, short[] sArr, int i2, int i3) {
        int i4 = this._pos;
        if (i == i4) {
            add(sArr, i2, i3);
            return;
        }
        ensureCapacity(i4 + i3);
        short[] sArr2 = this._data;
        System.arraycopy(sArr2, i, sArr2, i + i3, this._pos - i);
        System.arraycopy(sArr, i2, this._data, i, i3);
        this._pos += i3;
    }

    @Override // gnu.trove.list.TShortList
    public short get(int i) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        return this._data[i];
    }

    public short getQuick(int i) {
        return this._data[i];
    }

    @Override // gnu.trove.list.TShortList
    public short set(int i, short s) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        short[] sArr = this._data;
        short s2 = sArr[i];
        sArr[i] = s;
        return s2;
    }

    @Override // gnu.trove.list.TShortList
    public short replace(int i, short s) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        short[] sArr = this._data;
        short s2 = sArr[i];
        sArr[i] = s;
        return s2;
    }

    @Override // gnu.trove.list.TShortList
    public void set(int i, short[] sArr) {
        set(i, sArr, 0, sArr.length);
    }

    @Override // gnu.trove.list.TShortList
    public void set(int i, short[] sArr, int i2, int i3) {
        if (i < 0 || i + i3 > this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(sArr, i2, this._data, i, i3);
    }

    public void setQuick(int i, short s) {
        this._data[i] = s;
    }

    @Override // gnu.trove.list.TShortList, gnu.trove.TShortCollection
    public void clear() {
        clearQuick();
        Arrays.fill(this._data, this.no_entry_value);
    }

    public void clearQuick() {
        this._pos = 0;
    }

    @Override // gnu.trove.list.TShortList, gnu.trove.TShortCollection
    public boolean remove(short s) {
        for (int i = 0; i < this._pos; i++) {
            if (s == this._data[i]) {
                remove(i, 1);
                return true;
            }
        }
        return false;
    }

    @Override // gnu.trove.list.TShortList
    public short removeAt(int i) {
        short s = get(i);
        remove(i, 1);
        return s;
    }

    @Override // gnu.trove.list.TShortList
    public void remove(int i, int i2) {
        int i3;
        if (i2 == 0) {
            return;
        }
        if (i < 0 || i >= (i3 = this._pos)) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        if (i == 0) {
            short[] sArr = this._data;
            System.arraycopy(sArr, i2, sArr, 0, i3 - i2);
        } else if (i3 - i2 != i) {
            short[] sArr2 = this._data;
            int i4 = i + i2;
            System.arraycopy(sArr2, i4, sArr2, i, i3 - i4);
        }
        this._pos -= i2;
    }

    @Override // gnu.trove.TShortCollection
    public TShortIterator iterator() {
        return new TShortArrayIterator(0);
    }

    @Override // gnu.trove.TShortCollection
    public boolean containsAll(Collection<?> collection) {
        for (Object obj : collection) {
            if (!(obj instanceof Short) || !contains(((Short) obj).shortValue())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.TShortCollection
    public boolean containsAll(TShortCollection tShortCollection) {
        if (this == tShortCollection) {
            return true;
        }
        TShortIterator it = tShortCollection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.TShortCollection
    public boolean containsAll(short[] sArr) {
        int length = sArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!contains(sArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.TShortCollection
    public boolean addAll(Collection<? extends Short> collection) {
        Iterator<? extends Short> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next().shortValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TShortCollection
    public boolean addAll(TShortCollection tShortCollection) {
        TShortIterator it = tShortCollection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TShortCollection
    public boolean addAll(short[] sArr) {
        boolean z = false;
        for (short s : sArr) {
            if (add(s)) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TShortCollection
    public boolean retainAll(Collection<?> collection) {
        TShortIterator it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(Short.valueOf(it.next()))) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TShortCollection
    public boolean retainAll(TShortCollection tShortCollection) {
        boolean z = false;
        if (this == tShortCollection) {
            return false;
        }
        TShortIterator it = iterator();
        while (it.hasNext()) {
            if (!tShortCollection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TShortCollection
    public boolean retainAll(short[] sArr) {
        Arrays.sort(sArr);
        short[] sArr2 = this._data;
        int i = this._pos;
        boolean z = false;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return z;
            }
            if (Arrays.binarySearch(sArr, sArr2[i2]) < 0) {
                remove(i2, 1);
                z = true;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.TShortCollection
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object obj : collection) {
            if ((obj instanceof Short) && remove(((Short) obj).shortValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TShortCollection
    public boolean removeAll(TShortCollection tShortCollection) {
        if (tShortCollection == this) {
            clear();
            return true;
        }
        boolean z = false;
        TShortIterator it = tShortCollection.iterator();
        while (it.hasNext()) {
            if (remove(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TShortCollection
    public boolean removeAll(short[] sArr) {
        int length = sArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return z;
            }
            if (remove(sArr[i])) {
                z = true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.list.TShortList
    public void transformValues(TShortFunction tShortFunction) {
        for (int i = 0; i < this._pos; i++) {
            short[] sArr = this._data;
            sArr[i] = tShortFunction.execute(sArr[i]);
        }
    }

    @Override // gnu.trove.list.TShortList
    public void reverse() {
        reverse(0, this._pos);
    }

    @Override // gnu.trove.list.TShortList
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

    @Override // gnu.trove.list.TShortList
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
        short[] sArr = this._data;
        short s = sArr[i];
        sArr[i] = sArr[i2];
        sArr[i2] = s;
    }

    @Override // gnu.trove.list.TShortList
    public TShortList subList(int i, int i2) {
        if (i2 < i) {
            throw new IllegalArgumentException("end index " + i2 + " greater than begin index " + i);
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("begin index can not be < 0");
        }
        if (i2 > this._data.length) {
            throw new IndexOutOfBoundsException("end index < " + this._data.length);
        }
        TShortArrayList tShortArrayList = new TShortArrayList(i2 - i);
        while (i < i2) {
            tShortArrayList.add(this._data[i]);
            i++;
        }
        return tShortArrayList;
    }

    @Override // gnu.trove.list.TShortList, gnu.trove.TShortCollection
    public short[] toArray() {
        return toArray(0, this._pos);
    }

    @Override // gnu.trove.list.TShortList
    public short[] toArray(int i, int i2) {
        short[] sArr = new short[i2];
        toArray(sArr, i, i2);
        return sArr;
    }

    @Override // gnu.trove.list.TShortList, gnu.trove.TShortCollection
    public short[] toArray(short[] sArr) {
        int length = sArr.length;
        int length2 = sArr.length;
        int i = this._pos;
        if (length2 > i) {
            sArr[i] = this.no_entry_value;
            length = i;
        }
        toArray(sArr, 0, length);
        return sArr;
    }

    @Override // gnu.trove.list.TShortList
    public short[] toArray(short[] sArr, int i, int i2) {
        if (i2 == 0) {
            return sArr;
        }
        if (i < 0 || i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(this._data, i, sArr, 0, i2);
        return sArr;
    }

    @Override // gnu.trove.list.TShortList
    public short[] toArray(short[] sArr, int i, int i2, int i3) {
        if (i3 == 0) {
            return sArr;
        }
        if (i < 0 || i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(this._data, i, sArr, i2, i3);
        return sArr;
    }

    @Override // gnu.trove.TShortCollection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TShortList)) {
            return false;
        }
        if (obj instanceof TShortArrayList) {
            TShortArrayList tShortArrayList = (TShortArrayList) obj;
            if (tShortArrayList.size() != size()) {
                return false;
            }
            int i = this._pos;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return true;
                }
                if (this._data[i2] != tShortArrayList._data[i2]) {
                    return false;
                }
                i = i2;
            }
        } else {
            TShortList tShortList = (TShortList) obj;
            if (tShortList.size() != size()) {
                return false;
            }
            for (int i3 = 0; i3 < this._pos; i3++) {
                if (this._data[i3] != tShortList.get(i3)) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // gnu.trove.TShortCollection
    public int hashCode() {
        int i = this._pos;
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                return i2;
            }
            i2 += HashFunctions.hash((int) this._data[i3]);
            i = i3;
        }
    }

    @Override // gnu.trove.list.TShortList, gnu.trove.TShortCollection
    public boolean forEach(TShortProcedure tShortProcedure) {
        for (int i = 0; i < this._pos; i++) {
            if (!tShortProcedure.execute(this._data[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.list.TShortList
    public boolean forEachDescending(TShortProcedure tShortProcedure) {
        int i = this._pos;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return true;
            }
            if (!tShortProcedure.execute(this._data[i2])) {
                return false;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.list.TShortList
    public void sort() {
        Arrays.sort(this._data, 0, this._pos);
    }

    @Override // gnu.trove.list.TShortList
    public void sort(int i, int i2) {
        Arrays.sort(this._data, i, i2);
    }

    @Override // gnu.trove.list.TShortList
    public void fill(short s) {
        Arrays.fill(this._data, 0, this._pos, s);
    }

    @Override // gnu.trove.list.TShortList
    public void fill(int i, int i2, short s) {
        if (i2 > this._pos) {
            ensureCapacity(i2);
            this._pos = i2;
        }
        Arrays.fill(this._data, i, i2, s);
    }

    @Override // gnu.trove.list.TShortList
    public int binarySearch(short s) {
        return binarySearch(s, 0, this._pos);
    }

    @Override // gnu.trove.list.TShortList
    public int binarySearch(short s, int i, int i2) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        if (i2 > this._pos) {
            throw new ArrayIndexOutOfBoundsException(i2);
        }
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            short s2 = this._data[i4];
            if (s2 < s) {
                i = i4 + 1;
            } else {
                if (s2 <= s) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    @Override // gnu.trove.list.TShortList
    public int indexOf(short s) {
        return indexOf(0, s);
    }

    @Override // gnu.trove.list.TShortList
    public int indexOf(int i, short s) {
        while (i < this._pos) {
            if (this._data[i] == s) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // gnu.trove.list.TShortList
    public int lastIndexOf(short s) {
        return lastIndexOf(this._pos, s);
    }

    @Override // gnu.trove.list.TShortList
    public int lastIndexOf(int i, short s) {
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return -1;
            }
            if (this._data[i2] == s) {
                return i2;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.list.TShortList, gnu.trove.TShortCollection
    public boolean contains(short s) {
        return lastIndexOf(s) >= 0;
    }

    @Override // gnu.trove.list.TShortList
    public TShortList grep(TShortProcedure tShortProcedure) {
        TShortArrayList tShortArrayList = new TShortArrayList();
        for (int i = 0; i < this._pos; i++) {
            if (tShortProcedure.execute(this._data[i])) {
                tShortArrayList.add(this._data[i]);
            }
        }
        return tShortArrayList;
    }

    @Override // gnu.trove.list.TShortList
    public TShortList inverseGrep(TShortProcedure tShortProcedure) {
        TShortArrayList tShortArrayList = new TShortArrayList();
        for (int i = 0; i < this._pos; i++) {
            if (!tShortProcedure.execute(this._data[i])) {
                tShortArrayList.add(this._data[i]);
            }
        }
        return tShortArrayList;
    }

    @Override // gnu.trove.list.TShortList
    public short max() {
        if (size() == 0) {
            throw new IllegalStateException("cannot find maximum of an empty list");
        }
        short s = ShortCompanionObject.MIN_VALUE;
        for (int i = 0; i < this._pos; i++) {
            short[] sArr = this._data;
            if (sArr[i] > s) {
                s = sArr[i];
            }
        }
        return s;
    }

    @Override // gnu.trove.list.TShortList
    public short min() {
        if (size() == 0) {
            throw new IllegalStateException("cannot find minimum of an empty list");
        }
        short s = Short.MAX_VALUE;
        for (int i = 0; i < this._pos; i++) {
            short[] sArr = this._data;
            if (sArr[i] < s) {
                s = sArr[i];
            }
        }
        return s;
    }

    @Override // gnu.trove.list.TShortList
    public short sum() {
        short s = 0;
        for (int i = 0; i < this._pos; i++) {
            s = (short) (s + this._data[i]);
        }
        return s;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        int i = this._pos - 1;
        for (int i2 = 0; i2 < i; i2++) {
            sb.append((int) this._data[i2]);
            sb.append(", ");
        }
        if (size() > 0) {
            sb.append((int) this._data[this._pos - 1]);
        }
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    class TShortArrayIterator implements TShortIterator {
        private int cursor;
        int lastRet = -1;

        TShortArrayIterator(int i) {
            this.cursor = 0;
            this.cursor = i;
        }

        @Override // gnu.trove.iterator.TIterator, java.util.Iterator
        public boolean hasNext() {
            return this.cursor < TShortArrayList.this.size();
        }

        @Override // gnu.trove.iterator.TShortIterator
        public short next() {
            try {
                short s = TShortArrayList.this.get(this.cursor);
                int i = this.cursor;
                this.cursor = i + 1;
                this.lastRet = i;
                return s;
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
                TShortArrayList.this.remove(i, 1);
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
        objectOutput.writeShort(this.no_entry_value);
        int length = this._data.length;
        objectOutput.writeInt(length);
        for (int i = 0; i < length; i++) {
            objectOutput.writeShort(this._data[i]);
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._pos = objectInput.readInt();
        this.no_entry_value = objectInput.readShort();
        int readInt = objectInput.readInt();
        this._data = new short[readInt];
        for (int i = 0; i < readInt; i++) {
            this._data[i] = objectInput.readShort();
        }
    }
}

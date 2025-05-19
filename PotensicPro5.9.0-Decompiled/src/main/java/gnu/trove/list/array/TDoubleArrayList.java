package gnu.trove.list.array;

import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.iterator.TDoubleIterator;
import gnu.trove.list.TDoubleList;
import gnu.trove.procedure.TDoubleProcedure;
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
public class TDoubleArrayList implements TDoubleList, Externalizable {
    protected static final int DEFAULT_CAPACITY = 10;
    static final long serialVersionUID = 1;
    protected double[] _data;
    protected int _pos;
    protected double no_entry_value;

    public TDoubleArrayList() {
        this(10, 0.0d);
    }

    public TDoubleArrayList(int i) {
        this(i, 0.0d);
    }

    public TDoubleArrayList(int i, double d) {
        this._data = new double[i];
        this._pos = 0;
        this.no_entry_value = d;
    }

    public TDoubleArrayList(TDoubleCollection tDoubleCollection) {
        this(tDoubleCollection.size());
        addAll(tDoubleCollection);
    }

    public TDoubleArrayList(double[] dArr) {
        this(dArr.length);
        add(dArr);
    }

    protected TDoubleArrayList(double[] dArr, double d, boolean z) {
        if (!z) {
            throw new IllegalStateException("Wrong call");
        }
        if (dArr == null) {
            throw new IllegalArgumentException("values can not be null");
        }
        this._data = dArr;
        this._pos = dArr.length;
        this.no_entry_value = d;
    }

    public static TDoubleArrayList wrap(double[] dArr) {
        return wrap(dArr, 0.0d);
    }

    public static TDoubleArrayList wrap(double[] dArr, double d) {
        return new TDoubleArrayList(dArr, d, true) { // from class: gnu.trove.list.array.TDoubleArrayList.1
            @Override // gnu.trove.list.array.TDoubleArrayList
            public void ensureCapacity(int i) {
                if (i > this._data.length) {
                    throw new IllegalStateException("Can not grow ArrayList wrapped external array");
                }
            }
        };
    }

    @Override // gnu.trove.list.TDoubleList, gnu.trove.TDoubleCollection
    public double getNoEntryValue() {
        return this.no_entry_value;
    }

    public void ensureCapacity(int i) {
        double[] dArr = this._data;
        if (i > dArr.length) {
            double[] dArr2 = new double[Math.max(dArr.length << 1, i)];
            double[] dArr3 = this._data;
            System.arraycopy(dArr3, 0, dArr2, 0, dArr3.length);
            this._data = dArr2;
        }
    }

    @Override // gnu.trove.list.TDoubleList, gnu.trove.TDoubleCollection
    public int size() {
        return this._pos;
    }

    @Override // gnu.trove.list.TDoubleList, gnu.trove.TDoubleCollection
    public boolean isEmpty() {
        return this._pos == 0;
    }

    public void trimToSize() {
        if (this._data.length > size()) {
            int size = size();
            double[] dArr = new double[size];
            toArray(dArr, 0, size);
            this._data = dArr;
        }
    }

    @Override // gnu.trove.list.TDoubleList, gnu.trove.TDoubleCollection
    public boolean add(double d) {
        ensureCapacity(this._pos + 1);
        double[] dArr = this._data;
        int i = this._pos;
        this._pos = i + 1;
        dArr[i] = d;
        return true;
    }

    @Override // gnu.trove.list.TDoubleList
    public void add(double[] dArr) {
        add(dArr, 0, dArr.length);
    }

    @Override // gnu.trove.list.TDoubleList
    public void add(double[] dArr, int i, int i2) {
        ensureCapacity(this._pos + i2);
        System.arraycopy(dArr, i, this._data, this._pos, i2);
        this._pos += i2;
    }

    @Override // gnu.trove.list.TDoubleList
    public void insert(int i, double d) {
        int i2 = this._pos;
        if (i == i2) {
            add(d);
            return;
        }
        ensureCapacity(i2 + 1);
        double[] dArr = this._data;
        System.arraycopy(dArr, i, dArr, i + 1, this._pos - i);
        this._data[i] = d;
        this._pos++;
    }

    @Override // gnu.trove.list.TDoubleList
    public void insert(int i, double[] dArr) {
        insert(i, dArr, 0, dArr.length);
    }

    @Override // gnu.trove.list.TDoubleList
    public void insert(int i, double[] dArr, int i2, int i3) {
        int i4 = this._pos;
        if (i == i4) {
            add(dArr, i2, i3);
            return;
        }
        ensureCapacity(i4 + i3);
        double[] dArr2 = this._data;
        System.arraycopy(dArr2, i, dArr2, i + i3, this._pos - i);
        System.arraycopy(dArr, i2, this._data, i, i3);
        this._pos += i3;
    }

    @Override // gnu.trove.list.TDoubleList
    public double get(int i) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        return this._data[i];
    }

    public double getQuick(int i) {
        return this._data[i];
    }

    @Override // gnu.trove.list.TDoubleList
    public double set(int i, double d) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        double[] dArr = this._data;
        double d2 = dArr[i];
        dArr[i] = d;
        return d2;
    }

    @Override // gnu.trove.list.TDoubleList
    public double replace(int i, double d) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        double[] dArr = this._data;
        double d2 = dArr[i];
        dArr[i] = d;
        return d2;
    }

    @Override // gnu.trove.list.TDoubleList
    public void set(int i, double[] dArr) {
        set(i, dArr, 0, dArr.length);
    }

    @Override // gnu.trove.list.TDoubleList
    public void set(int i, double[] dArr, int i2, int i3) {
        if (i < 0 || i + i3 > this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(dArr, i2, this._data, i, i3);
    }

    public void setQuick(int i, double d) {
        this._data[i] = d;
    }

    @Override // gnu.trove.list.TDoubleList, gnu.trove.TDoubleCollection
    public void clear() {
        clearQuick();
        Arrays.fill(this._data, this.no_entry_value);
    }

    public void clearQuick() {
        this._pos = 0;
    }

    @Override // gnu.trove.list.TDoubleList, gnu.trove.TDoubleCollection
    public boolean remove(double d) {
        for (int i = 0; i < this._pos; i++) {
            if (d == this._data[i]) {
                remove(i, 1);
                return true;
            }
        }
        return false;
    }

    @Override // gnu.trove.list.TDoubleList
    public double removeAt(int i) {
        double d = get(i);
        remove(i, 1);
        return d;
    }

    @Override // gnu.trove.list.TDoubleList
    public void remove(int i, int i2) {
        int i3;
        if (i2 == 0) {
            return;
        }
        if (i < 0 || i >= (i3 = this._pos)) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        if (i == 0) {
            double[] dArr = this._data;
            System.arraycopy(dArr, i2, dArr, 0, i3 - i2);
        } else if (i3 - i2 != i) {
            double[] dArr2 = this._data;
            int i4 = i + i2;
            System.arraycopy(dArr2, i4, dArr2, i, i3 - i4);
        }
        this._pos -= i2;
    }

    @Override // gnu.trove.TDoubleCollection
    public TDoubleIterator iterator() {
        return new TDoubleArrayIterator(0);
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean containsAll(Collection<?> collection) {
        for (Object obj : collection) {
            if (!(obj instanceof Double) || !contains(((Double) obj).doubleValue())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean containsAll(TDoubleCollection tDoubleCollection) {
        if (this == tDoubleCollection) {
            return true;
        }
        TDoubleIterator it = tDoubleCollection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean containsAll(double[] dArr) {
        int length = dArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!contains(dArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean addAll(Collection<? extends Double> collection) {
        Iterator<? extends Double> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next().doubleValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean addAll(TDoubleCollection tDoubleCollection) {
        TDoubleIterator it = tDoubleCollection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean addAll(double[] dArr) {
        boolean z = false;
        for (double d : dArr) {
            if (add(d)) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean retainAll(Collection<?> collection) {
        TDoubleIterator it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(Double.valueOf(it.next()))) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean retainAll(TDoubleCollection tDoubleCollection) {
        boolean z = false;
        if (this == tDoubleCollection) {
            return false;
        }
        TDoubleIterator it = iterator();
        while (it.hasNext()) {
            if (!tDoubleCollection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean retainAll(double[] dArr) {
        Arrays.sort(dArr);
        double[] dArr2 = this._data;
        int i = this._pos;
        boolean z = false;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return z;
            }
            if (Arrays.binarySearch(dArr, dArr2[i2]) < 0) {
                remove(i2, 1);
                z = true;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object obj : collection) {
            if ((obj instanceof Double) && remove(((Double) obj).doubleValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean removeAll(TDoubleCollection tDoubleCollection) {
        if (tDoubleCollection == this) {
            clear();
            return true;
        }
        boolean z = false;
        TDoubleIterator it = tDoubleCollection.iterator();
        while (it.hasNext()) {
            if (remove(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean removeAll(double[] dArr) {
        int length = dArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return z;
            }
            if (remove(dArr[i])) {
                z = true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.list.TDoubleList
    public void transformValues(TDoubleFunction tDoubleFunction) {
        for (int i = 0; i < this._pos; i++) {
            double[] dArr = this._data;
            dArr[i] = tDoubleFunction.execute(dArr[i]);
        }
    }

    @Override // gnu.trove.list.TDoubleList
    public void reverse() {
        reverse(0, this._pos);
    }

    @Override // gnu.trove.list.TDoubleList
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

    @Override // gnu.trove.list.TDoubleList
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
        double[] dArr = this._data;
        double d = dArr[i];
        dArr[i] = dArr[i2];
        dArr[i2] = d;
    }

    @Override // gnu.trove.list.TDoubleList
    public TDoubleList subList(int i, int i2) {
        if (i2 < i) {
            throw new IllegalArgumentException("end index " + i2 + " greater than begin index " + i);
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("begin index can not be < 0");
        }
        if (i2 > this._data.length) {
            throw new IndexOutOfBoundsException("end index < " + this._data.length);
        }
        TDoubleArrayList tDoubleArrayList = new TDoubleArrayList(i2 - i);
        while (i < i2) {
            tDoubleArrayList.add(this._data[i]);
            i++;
        }
        return tDoubleArrayList;
    }

    @Override // gnu.trove.list.TDoubleList, gnu.trove.TDoubleCollection
    public double[] toArray() {
        return toArray(0, this._pos);
    }

    @Override // gnu.trove.list.TDoubleList
    public double[] toArray(int i, int i2) {
        double[] dArr = new double[i2];
        toArray(dArr, i, i2);
        return dArr;
    }

    @Override // gnu.trove.list.TDoubleList, gnu.trove.TDoubleCollection
    public double[] toArray(double[] dArr) {
        int length = dArr.length;
        int length2 = dArr.length;
        int i = this._pos;
        if (length2 > i) {
            dArr[i] = this.no_entry_value;
            length = i;
        }
        toArray(dArr, 0, length);
        return dArr;
    }

    @Override // gnu.trove.list.TDoubleList
    public double[] toArray(double[] dArr, int i, int i2) {
        if (i2 == 0) {
            return dArr;
        }
        if (i < 0 || i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(this._data, i, dArr, 0, i2);
        return dArr;
    }

    @Override // gnu.trove.list.TDoubleList
    public double[] toArray(double[] dArr, int i, int i2, int i3) {
        if (i3 == 0) {
            return dArr;
        }
        if (i < 0 || i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(this._data, i, dArr, i2, i3);
        return dArr;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TDoubleList)) {
            return false;
        }
        if (obj instanceof TDoubleArrayList) {
            TDoubleArrayList tDoubleArrayList = (TDoubleArrayList) obj;
            if (tDoubleArrayList.size() != size()) {
                return false;
            }
            int i = this._pos;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return true;
                }
                if (this._data[i2] != tDoubleArrayList._data[i2]) {
                    return false;
                }
                i = i2;
            }
        } else {
            TDoubleList tDoubleList = (TDoubleList) obj;
            if (tDoubleList.size() != size()) {
                return false;
            }
            for (int i3 = 0; i3 < this._pos; i3++) {
                if (this._data[i3] != tDoubleList.get(i3)) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // gnu.trove.TDoubleCollection
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

    @Override // gnu.trove.list.TDoubleList, gnu.trove.TDoubleCollection
    public boolean forEach(TDoubleProcedure tDoubleProcedure) {
        for (int i = 0; i < this._pos; i++) {
            if (!tDoubleProcedure.execute(this._data[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.list.TDoubleList
    public boolean forEachDescending(TDoubleProcedure tDoubleProcedure) {
        int i = this._pos;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return true;
            }
            if (!tDoubleProcedure.execute(this._data[i2])) {
                return false;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.list.TDoubleList
    public void sort() {
        Arrays.sort(this._data, 0, this._pos);
    }

    @Override // gnu.trove.list.TDoubleList
    public void sort(int i, int i2) {
        Arrays.sort(this._data, i, i2);
    }

    @Override // gnu.trove.list.TDoubleList
    public void fill(double d) {
        Arrays.fill(this._data, 0, this._pos, d);
    }

    @Override // gnu.trove.list.TDoubleList
    public void fill(int i, int i2, double d) {
        if (i2 > this._pos) {
            ensureCapacity(i2);
            this._pos = i2;
        }
        Arrays.fill(this._data, i, i2, d);
    }

    @Override // gnu.trove.list.TDoubleList
    public int binarySearch(double d) {
        return binarySearch(d, 0, this._pos);
    }

    @Override // gnu.trove.list.TDoubleList
    public int binarySearch(double d, int i, int i2) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        if (i2 > this._pos) {
            throw new ArrayIndexOutOfBoundsException(i2);
        }
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            double d2 = this._data[i4];
            if (d2 < d) {
                i = i4 + 1;
            } else {
                if (d2 <= d) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    @Override // gnu.trove.list.TDoubleList
    public int indexOf(double d) {
        return indexOf(0, d);
    }

    @Override // gnu.trove.list.TDoubleList
    public int indexOf(int i, double d) {
        while (i < this._pos) {
            if (this._data[i] == d) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // gnu.trove.list.TDoubleList
    public int lastIndexOf(double d) {
        return lastIndexOf(this._pos, d);
    }

    @Override // gnu.trove.list.TDoubleList
    public int lastIndexOf(int i, double d) {
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return -1;
            }
            if (this._data[i2] == d) {
                return i2;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.list.TDoubleList, gnu.trove.TDoubleCollection
    public boolean contains(double d) {
        return lastIndexOf(d) >= 0;
    }

    @Override // gnu.trove.list.TDoubleList
    public TDoubleList grep(TDoubleProcedure tDoubleProcedure) {
        TDoubleArrayList tDoubleArrayList = new TDoubleArrayList();
        for (int i = 0; i < this._pos; i++) {
            if (tDoubleProcedure.execute(this._data[i])) {
                tDoubleArrayList.add(this._data[i]);
            }
        }
        return tDoubleArrayList;
    }

    @Override // gnu.trove.list.TDoubleList
    public TDoubleList inverseGrep(TDoubleProcedure tDoubleProcedure) {
        TDoubleArrayList tDoubleArrayList = new TDoubleArrayList();
        for (int i = 0; i < this._pos; i++) {
            if (!tDoubleProcedure.execute(this._data[i])) {
                tDoubleArrayList.add(this._data[i]);
            }
        }
        return tDoubleArrayList;
    }

    @Override // gnu.trove.list.TDoubleList
    public double max() {
        if (size() == 0) {
            throw new IllegalStateException("cannot find maximum of an empty list");
        }
        double d = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < this._pos; i++) {
            double[] dArr = this._data;
            if (dArr[i] > d) {
                d = dArr[i];
            }
        }
        return d;
    }

    @Override // gnu.trove.list.TDoubleList
    public double min() {
        if (size() == 0) {
            throw new IllegalStateException("cannot find minimum of an empty list");
        }
        double d = Double.POSITIVE_INFINITY;
        for (int i = 0; i < this._pos; i++) {
            double[] dArr = this._data;
            if (dArr[i] < d) {
                d = dArr[i];
            }
        }
        return d;
    }

    @Override // gnu.trove.list.TDoubleList
    public double sum() {
        double d = 0.0d;
        for (int i = 0; i < this._pos; i++) {
            d += this._data[i];
        }
        return d;
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

    class TDoubleArrayIterator implements TDoubleIterator {
        private int cursor;
        int lastRet = -1;

        TDoubleArrayIterator(int i) {
            this.cursor = 0;
            this.cursor = i;
        }

        @Override // gnu.trove.iterator.TIterator, java.util.Iterator
        public boolean hasNext() {
            return this.cursor < TDoubleArrayList.this.size();
        }

        @Override // gnu.trove.iterator.TDoubleIterator
        public double next() {
            try {
                double d = TDoubleArrayList.this.get(this.cursor);
                int i = this.cursor;
                this.cursor = i + 1;
                this.lastRet = i;
                return d;
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
                TDoubleArrayList.this.remove(i, 1);
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
        objectOutput.writeDouble(this.no_entry_value);
        int length = this._data.length;
        objectOutput.writeInt(length);
        for (int i = 0; i < length; i++) {
            objectOutput.writeDouble(this._data[i]);
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._pos = objectInput.readInt();
        this.no_entry_value = objectInput.readDouble();
        int readInt = objectInput.readInt();
        this._data = new double[readInt];
        for (int i = 0; i < readInt; i++) {
            this._data[i] = objectInput.readDouble();
        }
    }
}

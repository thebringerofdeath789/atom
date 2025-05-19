package gnu.trove.list.array;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.iterator.TFloatIterator;
import gnu.trove.list.TFloatList;
import gnu.trove.procedure.TFloatProcedure;
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
public class TFloatArrayList implements TFloatList, Externalizable {
    protected static final int DEFAULT_CAPACITY = 10;
    static final long serialVersionUID = 1;
    protected float[] _data;
    protected int _pos;
    protected float no_entry_value;

    public TFloatArrayList() {
        this(10, 0.0f);
    }

    public TFloatArrayList(int i) {
        this(i, 0.0f);
    }

    public TFloatArrayList(int i, float f) {
        this._data = new float[i];
        this._pos = 0;
        this.no_entry_value = f;
    }

    public TFloatArrayList(TFloatCollection tFloatCollection) {
        this(tFloatCollection.size());
        addAll(tFloatCollection);
    }

    public TFloatArrayList(float[] fArr) {
        this(fArr.length);
        add(fArr);
    }

    protected TFloatArrayList(float[] fArr, float f, boolean z) {
        if (!z) {
            throw new IllegalStateException("Wrong call");
        }
        if (fArr == null) {
            throw new IllegalArgumentException("values can not be null");
        }
        this._data = fArr;
        this._pos = fArr.length;
        this.no_entry_value = f;
    }

    public static TFloatArrayList wrap(float[] fArr) {
        return wrap(fArr, 0.0f);
    }

    public static TFloatArrayList wrap(float[] fArr, float f) {
        return new TFloatArrayList(fArr, f, true) { // from class: gnu.trove.list.array.TFloatArrayList.1
            @Override // gnu.trove.list.array.TFloatArrayList
            public void ensureCapacity(int i) {
                if (i > this._data.length) {
                    throw new IllegalStateException("Can not grow ArrayList wrapped external array");
                }
            }
        };
    }

    @Override // gnu.trove.list.TFloatList, gnu.trove.TFloatCollection
    public float getNoEntryValue() {
        return this.no_entry_value;
    }

    public void ensureCapacity(int i) {
        float[] fArr = this._data;
        if (i > fArr.length) {
            float[] fArr2 = new float[Math.max(fArr.length << 1, i)];
            float[] fArr3 = this._data;
            System.arraycopy(fArr3, 0, fArr2, 0, fArr3.length);
            this._data = fArr2;
        }
    }

    @Override // gnu.trove.list.TFloatList, gnu.trove.TFloatCollection
    public int size() {
        return this._pos;
    }

    @Override // gnu.trove.list.TFloatList, gnu.trove.TFloatCollection
    public boolean isEmpty() {
        return this._pos == 0;
    }

    public void trimToSize() {
        if (this._data.length > size()) {
            int size = size();
            float[] fArr = new float[size];
            toArray(fArr, 0, size);
            this._data = fArr;
        }
    }

    @Override // gnu.trove.list.TFloatList, gnu.trove.TFloatCollection
    public boolean add(float f) {
        ensureCapacity(this._pos + 1);
        float[] fArr = this._data;
        int i = this._pos;
        this._pos = i + 1;
        fArr[i] = f;
        return true;
    }

    @Override // gnu.trove.list.TFloatList
    public void add(float[] fArr) {
        add(fArr, 0, fArr.length);
    }

    @Override // gnu.trove.list.TFloatList
    public void add(float[] fArr, int i, int i2) {
        ensureCapacity(this._pos + i2);
        System.arraycopy(fArr, i, this._data, this._pos, i2);
        this._pos += i2;
    }

    @Override // gnu.trove.list.TFloatList
    public void insert(int i, float f) {
        int i2 = this._pos;
        if (i == i2) {
            add(f);
            return;
        }
        ensureCapacity(i2 + 1);
        float[] fArr = this._data;
        System.arraycopy(fArr, i, fArr, i + 1, this._pos - i);
        this._data[i] = f;
        this._pos++;
    }

    @Override // gnu.trove.list.TFloatList
    public void insert(int i, float[] fArr) {
        insert(i, fArr, 0, fArr.length);
    }

    @Override // gnu.trove.list.TFloatList
    public void insert(int i, float[] fArr, int i2, int i3) {
        int i4 = this._pos;
        if (i == i4) {
            add(fArr, i2, i3);
            return;
        }
        ensureCapacity(i4 + i3);
        float[] fArr2 = this._data;
        System.arraycopy(fArr2, i, fArr2, i + i3, this._pos - i);
        System.arraycopy(fArr, i2, this._data, i, i3);
        this._pos += i3;
    }

    @Override // gnu.trove.list.TFloatList
    public float get(int i) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        return this._data[i];
    }

    public float getQuick(int i) {
        return this._data[i];
    }

    @Override // gnu.trove.list.TFloatList
    public float set(int i, float f) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        float[] fArr = this._data;
        float f2 = fArr[i];
        fArr[i] = f;
        return f2;
    }

    @Override // gnu.trove.list.TFloatList
    public float replace(int i, float f) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        float[] fArr = this._data;
        float f2 = fArr[i];
        fArr[i] = f;
        return f2;
    }

    @Override // gnu.trove.list.TFloatList
    public void set(int i, float[] fArr) {
        set(i, fArr, 0, fArr.length);
    }

    @Override // gnu.trove.list.TFloatList
    public void set(int i, float[] fArr, int i2, int i3) {
        if (i < 0 || i + i3 > this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(fArr, i2, this._data, i, i3);
    }

    public void setQuick(int i, float f) {
        this._data[i] = f;
    }

    @Override // gnu.trove.list.TFloatList, gnu.trove.TFloatCollection
    public void clear() {
        clearQuick();
        Arrays.fill(this._data, this.no_entry_value);
    }

    public void clearQuick() {
        this._pos = 0;
    }

    @Override // gnu.trove.list.TFloatList, gnu.trove.TFloatCollection
    public boolean remove(float f) {
        for (int i = 0; i < this._pos; i++) {
            if (f == this._data[i]) {
                remove(i, 1);
                return true;
            }
        }
        return false;
    }

    @Override // gnu.trove.list.TFloatList
    public float removeAt(int i) {
        float f = get(i);
        remove(i, 1);
        return f;
    }

    @Override // gnu.trove.list.TFloatList
    public void remove(int i, int i2) {
        int i3;
        if (i2 == 0) {
            return;
        }
        if (i < 0 || i >= (i3 = this._pos)) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        if (i == 0) {
            float[] fArr = this._data;
            System.arraycopy(fArr, i2, fArr, 0, i3 - i2);
        } else if (i3 - i2 != i) {
            float[] fArr2 = this._data;
            int i4 = i + i2;
            System.arraycopy(fArr2, i4, fArr2, i, i3 - i4);
        }
        this._pos -= i2;
    }

    @Override // gnu.trove.TFloatCollection
    public TFloatIterator iterator() {
        return new TFloatArrayIterator(0);
    }

    @Override // gnu.trove.TFloatCollection
    public boolean containsAll(Collection<?> collection) {
        for (Object obj : collection) {
            if (!(obj instanceof Float) || !contains(((Float) obj).floatValue())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean containsAll(TFloatCollection tFloatCollection) {
        if (this == tFloatCollection) {
            return true;
        }
        TFloatIterator it = tFloatCollection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean containsAll(float[] fArr) {
        int length = fArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!contains(fArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.TFloatCollection
    public boolean addAll(Collection<? extends Float> collection) {
        Iterator<? extends Float> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next().floatValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean addAll(TFloatCollection tFloatCollection) {
        TFloatIterator it = tFloatCollection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean addAll(float[] fArr) {
        boolean z = false;
        for (float f : fArr) {
            if (add(f)) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean retainAll(Collection<?> collection) {
        TFloatIterator it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(Float.valueOf(it.next()))) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean retainAll(TFloatCollection tFloatCollection) {
        boolean z = false;
        if (this == tFloatCollection) {
            return false;
        }
        TFloatIterator it = iterator();
        while (it.hasNext()) {
            if (!tFloatCollection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean retainAll(float[] fArr) {
        Arrays.sort(fArr);
        float[] fArr2 = this._data;
        int i = this._pos;
        boolean z = false;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return z;
            }
            if (Arrays.binarySearch(fArr, fArr2[i2]) < 0) {
                remove(i2, 1);
                z = true;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.TFloatCollection
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object obj : collection) {
            if ((obj instanceof Float) && remove(((Float) obj).floatValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean removeAll(TFloatCollection tFloatCollection) {
        if (tFloatCollection == this) {
            clear();
            return true;
        }
        boolean z = false;
        TFloatIterator it = tFloatCollection.iterator();
        while (it.hasNext()) {
            if (remove(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean removeAll(float[] fArr) {
        int length = fArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return z;
            }
            if (remove(fArr[i])) {
                z = true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.list.TFloatList
    public void transformValues(TFloatFunction tFloatFunction) {
        for (int i = 0; i < this._pos; i++) {
            float[] fArr = this._data;
            fArr[i] = tFloatFunction.execute(fArr[i]);
        }
    }

    @Override // gnu.trove.list.TFloatList
    public void reverse() {
        reverse(0, this._pos);
    }

    @Override // gnu.trove.list.TFloatList
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

    @Override // gnu.trove.list.TFloatList
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
        float[] fArr = this._data;
        float f = fArr[i];
        fArr[i] = fArr[i2];
        fArr[i2] = f;
    }

    @Override // gnu.trove.list.TFloatList
    public TFloatList subList(int i, int i2) {
        if (i2 < i) {
            throw new IllegalArgumentException("end index " + i2 + " greater than begin index " + i);
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("begin index can not be < 0");
        }
        if (i2 > this._data.length) {
            throw new IndexOutOfBoundsException("end index < " + this._data.length);
        }
        TFloatArrayList tFloatArrayList = new TFloatArrayList(i2 - i);
        while (i < i2) {
            tFloatArrayList.add(this._data[i]);
            i++;
        }
        return tFloatArrayList;
    }

    @Override // gnu.trove.list.TFloatList, gnu.trove.TFloatCollection
    public float[] toArray() {
        return toArray(0, this._pos);
    }

    @Override // gnu.trove.list.TFloatList
    public float[] toArray(int i, int i2) {
        float[] fArr = new float[i2];
        toArray(fArr, i, i2);
        return fArr;
    }

    @Override // gnu.trove.list.TFloatList, gnu.trove.TFloatCollection
    public float[] toArray(float[] fArr) {
        int length = fArr.length;
        int length2 = fArr.length;
        int i = this._pos;
        if (length2 > i) {
            fArr[i] = this.no_entry_value;
            length = i;
        }
        toArray(fArr, 0, length);
        return fArr;
    }

    @Override // gnu.trove.list.TFloatList
    public float[] toArray(float[] fArr, int i, int i2) {
        if (i2 == 0) {
            return fArr;
        }
        if (i < 0 || i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(this._data, i, fArr, 0, i2);
        return fArr;
    }

    @Override // gnu.trove.list.TFloatList
    public float[] toArray(float[] fArr, int i, int i2, int i3) {
        if (i3 == 0) {
            return fArr;
        }
        if (i < 0 || i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(this._data, i, fArr, i2, i3);
        return fArr;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TFloatList)) {
            return false;
        }
        if (obj instanceof TFloatArrayList) {
            TFloatArrayList tFloatArrayList = (TFloatArrayList) obj;
            if (tFloatArrayList.size() != size()) {
                return false;
            }
            int i = this._pos;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return true;
                }
                if (this._data[i2] != tFloatArrayList._data[i2]) {
                    return false;
                }
                i = i2;
            }
        } else {
            TFloatList tFloatList = (TFloatList) obj;
            if (tFloatList.size() != size()) {
                return false;
            }
            for (int i3 = 0; i3 < this._pos; i3++) {
                if (this._data[i3] != tFloatList.get(i3)) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // gnu.trove.TFloatCollection
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

    @Override // gnu.trove.list.TFloatList, gnu.trove.TFloatCollection
    public boolean forEach(TFloatProcedure tFloatProcedure) {
        for (int i = 0; i < this._pos; i++) {
            if (!tFloatProcedure.execute(this._data[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.list.TFloatList
    public boolean forEachDescending(TFloatProcedure tFloatProcedure) {
        int i = this._pos;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return true;
            }
            if (!tFloatProcedure.execute(this._data[i2])) {
                return false;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.list.TFloatList
    public void sort() {
        Arrays.sort(this._data, 0, this._pos);
    }

    @Override // gnu.trove.list.TFloatList
    public void sort(int i, int i2) {
        Arrays.sort(this._data, i, i2);
    }

    @Override // gnu.trove.list.TFloatList
    public void fill(float f) {
        Arrays.fill(this._data, 0, this._pos, f);
    }

    @Override // gnu.trove.list.TFloatList
    public void fill(int i, int i2, float f) {
        if (i2 > this._pos) {
            ensureCapacity(i2);
            this._pos = i2;
        }
        Arrays.fill(this._data, i, i2, f);
    }

    @Override // gnu.trove.list.TFloatList
    public int binarySearch(float f) {
        return binarySearch(f, 0, this._pos);
    }

    @Override // gnu.trove.list.TFloatList
    public int binarySearch(float f, int i, int i2) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        if (i2 > this._pos) {
            throw new ArrayIndexOutOfBoundsException(i2);
        }
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            float f2 = this._data[i4];
            if (f2 < f) {
                i = i4 + 1;
            } else {
                if (f2 <= f) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    @Override // gnu.trove.list.TFloatList
    public int indexOf(float f) {
        return indexOf(0, f);
    }

    @Override // gnu.trove.list.TFloatList
    public int indexOf(int i, float f) {
        while (i < this._pos) {
            if (this._data[i] == f) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // gnu.trove.list.TFloatList
    public int lastIndexOf(float f) {
        return lastIndexOf(this._pos, f);
    }

    @Override // gnu.trove.list.TFloatList
    public int lastIndexOf(int i, float f) {
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return -1;
            }
            if (this._data[i2] == f) {
                return i2;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.list.TFloatList, gnu.trove.TFloatCollection
    public boolean contains(float f) {
        return lastIndexOf(f) >= 0;
    }

    @Override // gnu.trove.list.TFloatList
    public TFloatList grep(TFloatProcedure tFloatProcedure) {
        TFloatArrayList tFloatArrayList = new TFloatArrayList();
        for (int i = 0; i < this._pos; i++) {
            if (tFloatProcedure.execute(this._data[i])) {
                tFloatArrayList.add(this._data[i]);
            }
        }
        return tFloatArrayList;
    }

    @Override // gnu.trove.list.TFloatList
    public TFloatList inverseGrep(TFloatProcedure tFloatProcedure) {
        TFloatArrayList tFloatArrayList = new TFloatArrayList();
        for (int i = 0; i < this._pos; i++) {
            if (!tFloatProcedure.execute(this._data[i])) {
                tFloatArrayList.add(this._data[i]);
            }
        }
        return tFloatArrayList;
    }

    @Override // gnu.trove.list.TFloatList
    public float max() {
        if (size() == 0) {
            throw new IllegalStateException("cannot find maximum of an empty list");
        }
        float f = Float.NEGATIVE_INFINITY;
        for (int i = 0; i < this._pos; i++) {
            float[] fArr = this._data;
            if (fArr[i] > f) {
                f = fArr[i];
            }
        }
        return f;
    }

    @Override // gnu.trove.list.TFloatList
    public float min() {
        if (size() == 0) {
            throw new IllegalStateException("cannot find minimum of an empty list");
        }
        float f = Float.POSITIVE_INFINITY;
        for (int i = 0; i < this._pos; i++) {
            float[] fArr = this._data;
            if (fArr[i] < f) {
                f = fArr[i];
            }
        }
        return f;
    }

    @Override // gnu.trove.list.TFloatList
    public float sum() {
        float f = 0.0f;
        for (int i = 0; i < this._pos; i++) {
            f += this._data[i];
        }
        return f;
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

    class TFloatArrayIterator implements TFloatIterator {
        private int cursor;
        int lastRet = -1;

        TFloatArrayIterator(int i) {
            this.cursor = 0;
            this.cursor = i;
        }

        @Override // gnu.trove.iterator.TIterator, java.util.Iterator
        public boolean hasNext() {
            return this.cursor < TFloatArrayList.this.size();
        }

        @Override // gnu.trove.iterator.TFloatIterator
        public float next() {
            try {
                float f = TFloatArrayList.this.get(this.cursor);
                int i = this.cursor;
                this.cursor = i + 1;
                this.lastRet = i;
                return f;
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
                TFloatArrayList.this.remove(i, 1);
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
        objectOutput.writeFloat(this.no_entry_value);
        int length = this._data.length;
        objectOutput.writeInt(length);
        for (int i = 0; i < length; i++) {
            objectOutput.writeFloat(this._data[i]);
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._pos = objectInput.readInt();
        this.no_entry_value = objectInput.readFloat();
        int readInt = objectInput.readInt();
        this._data = new float[readInt];
        for (int i = 0; i < readInt; i++) {
            this._data[i] = objectInput.readFloat();
        }
    }
}

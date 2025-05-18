package gnu.trove.list.array;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.iterator.TByteIterator;
import gnu.trove.list.TByteList;
import gnu.trove.procedure.TByteProcedure;
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
public class TByteArrayList implements TByteList, Externalizable {
    protected static final int DEFAULT_CAPACITY = 10;
    static final long serialVersionUID = 1;
    protected byte[] _data;
    protected int _pos;
    protected byte no_entry_value;

    public TByteArrayList() {
        this(10, (byte) 0);
    }

    public TByteArrayList(int i) {
        this(i, (byte) 0);
    }

    public TByteArrayList(int i, byte b) {
        this._data = new byte[i];
        this._pos = 0;
        this.no_entry_value = b;
    }

    public TByteArrayList(TByteCollection tByteCollection) {
        this(tByteCollection.size());
        addAll(tByteCollection);
    }

    public TByteArrayList(byte[] bArr) {
        this(bArr.length);
        add(bArr);
    }

    protected TByteArrayList(byte[] bArr, byte b, boolean z) {
        if (!z) {
            throw new IllegalStateException("Wrong call");
        }
        if (bArr == null) {
            throw new IllegalArgumentException("values can not be null");
        }
        this._data = bArr;
        this._pos = bArr.length;
        this.no_entry_value = b;
    }

    public static TByteArrayList wrap(byte[] bArr) {
        return wrap(bArr, (byte) 0);
    }

    public static TByteArrayList wrap(byte[] bArr, byte b) {
        return new TByteArrayList(bArr, b, true) { // from class: gnu.trove.list.array.TByteArrayList.1
            @Override // gnu.trove.list.array.TByteArrayList
            public void ensureCapacity(int i) {
                if (i > this._data.length) {
                    throw new IllegalStateException("Can not grow ArrayList wrapped external array");
                }
            }
        };
    }

    @Override // gnu.trove.list.TByteList, gnu.trove.TByteCollection
    public byte getNoEntryValue() {
        return this.no_entry_value;
    }

    public void ensureCapacity(int i) {
        byte[] bArr = this._data;
        if (i > bArr.length) {
            byte[] bArr2 = new byte[Math.max(bArr.length << 1, i)];
            byte[] bArr3 = this._data;
            System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
            this._data = bArr2;
        }
    }

    @Override // gnu.trove.list.TByteList, gnu.trove.TByteCollection
    public int size() {
        return this._pos;
    }

    @Override // gnu.trove.list.TByteList, gnu.trove.TByteCollection
    public boolean isEmpty() {
        return this._pos == 0;
    }

    public void trimToSize() {
        if (this._data.length > size()) {
            int size = size();
            byte[] bArr = new byte[size];
            toArray(bArr, 0, size);
            this._data = bArr;
        }
    }

    @Override // gnu.trove.list.TByteList, gnu.trove.TByteCollection
    public boolean add(byte b) {
        ensureCapacity(this._pos + 1);
        byte[] bArr = this._data;
        int i = this._pos;
        this._pos = i + 1;
        bArr[i] = b;
        return true;
    }

    @Override // gnu.trove.list.TByteList
    public void add(byte[] bArr) {
        add(bArr, 0, bArr.length);
    }

    @Override // gnu.trove.list.TByteList
    public void add(byte[] bArr, int i, int i2) {
        ensureCapacity(this._pos + i2);
        System.arraycopy(bArr, i, this._data, this._pos, i2);
        this._pos += i2;
    }

    @Override // gnu.trove.list.TByteList
    public void insert(int i, byte b) {
        int i2 = this._pos;
        if (i == i2) {
            add(b);
            return;
        }
        ensureCapacity(i2 + 1);
        byte[] bArr = this._data;
        System.arraycopy(bArr, i, bArr, i + 1, this._pos - i);
        this._data[i] = b;
        this._pos++;
    }

    @Override // gnu.trove.list.TByteList
    public void insert(int i, byte[] bArr) {
        insert(i, bArr, 0, bArr.length);
    }

    @Override // gnu.trove.list.TByteList
    public void insert(int i, byte[] bArr, int i2, int i3) {
        int i4 = this._pos;
        if (i == i4) {
            add(bArr, i2, i3);
            return;
        }
        ensureCapacity(i4 + i3);
        byte[] bArr2 = this._data;
        System.arraycopy(bArr2, i, bArr2, i + i3, this._pos - i);
        System.arraycopy(bArr, i2, this._data, i, i3);
        this._pos += i3;
    }

    @Override // gnu.trove.list.TByteList
    public byte get(int i) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        return this._data[i];
    }

    public byte getQuick(int i) {
        return this._data[i];
    }

    @Override // gnu.trove.list.TByteList
    public byte set(int i, byte b) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        byte[] bArr = this._data;
        byte b2 = bArr[i];
        bArr[i] = b;
        return b2;
    }

    @Override // gnu.trove.list.TByteList
    public byte replace(int i, byte b) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        byte[] bArr = this._data;
        byte b2 = bArr[i];
        bArr[i] = b;
        return b2;
    }

    @Override // gnu.trove.list.TByteList
    public void set(int i, byte[] bArr) {
        set(i, bArr, 0, bArr.length);
    }

    @Override // gnu.trove.list.TByteList
    public void set(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i + i3 > this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(bArr, i2, this._data, i, i3);
    }

    public void setQuick(int i, byte b) {
        this._data[i] = b;
    }

    @Override // gnu.trove.list.TByteList, gnu.trove.TByteCollection
    public void clear() {
        clearQuick();
        Arrays.fill(this._data, this.no_entry_value);
    }

    public void clearQuick() {
        this._pos = 0;
    }

    @Override // gnu.trove.list.TByteList, gnu.trove.TByteCollection
    public boolean remove(byte b) {
        for (int i = 0; i < this._pos; i++) {
            if (b == this._data[i]) {
                remove(i, 1);
                return true;
            }
        }
        return false;
    }

    @Override // gnu.trove.list.TByteList
    public byte removeAt(int i) {
        byte b = get(i);
        remove(i, 1);
        return b;
    }

    @Override // gnu.trove.list.TByteList
    public void remove(int i, int i2) {
        int i3;
        if (i2 == 0) {
            return;
        }
        if (i < 0 || i >= (i3 = this._pos)) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        if (i == 0) {
            byte[] bArr = this._data;
            System.arraycopy(bArr, i2, bArr, 0, i3 - i2);
        } else if (i3 - i2 != i) {
            byte[] bArr2 = this._data;
            int i4 = i + i2;
            System.arraycopy(bArr2, i4, bArr2, i, i3 - i4);
        }
        this._pos -= i2;
    }

    @Override // gnu.trove.TByteCollection
    public TByteIterator iterator() {
        return new TByteArrayIterator(0);
    }

    @Override // gnu.trove.TByteCollection
    public boolean containsAll(Collection<?> collection) {
        for (Object obj : collection) {
            if (!(obj instanceof Byte) || !contains(((Byte) obj).byteValue())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.TByteCollection
    public boolean containsAll(TByteCollection tByteCollection) {
        if (this == tByteCollection) {
            return true;
        }
        TByteIterator it = tByteCollection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.TByteCollection
    public boolean containsAll(byte[] bArr) {
        int length = bArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!contains(bArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.TByteCollection
    public boolean addAll(Collection<? extends Byte> collection) {
        Iterator<? extends Byte> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next().byteValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TByteCollection
    public boolean addAll(TByteCollection tByteCollection) {
        TByteIterator it = tByteCollection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TByteCollection
    public boolean addAll(byte[] bArr) {
        boolean z = false;
        for (byte b : bArr) {
            if (add(b)) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TByteCollection
    public boolean retainAll(Collection<?> collection) {
        TByteIterator it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(Byte.valueOf(it.next()))) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TByteCollection
    public boolean retainAll(TByteCollection tByteCollection) {
        boolean z = false;
        if (this == tByteCollection) {
            return false;
        }
        TByteIterator it = iterator();
        while (it.hasNext()) {
            if (!tByteCollection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TByteCollection
    public boolean retainAll(byte[] bArr) {
        Arrays.sort(bArr);
        byte[] bArr2 = this._data;
        int i = this._pos;
        boolean z = false;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return z;
            }
            if (Arrays.binarySearch(bArr, bArr2[i2]) < 0) {
                remove(i2, 1);
                z = true;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.TByteCollection
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object obj : collection) {
            if ((obj instanceof Byte) && remove(((Byte) obj).byteValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TByteCollection
    public boolean removeAll(TByteCollection tByteCollection) {
        if (tByteCollection == this) {
            clear();
            return true;
        }
        boolean z = false;
        TByteIterator it = tByteCollection.iterator();
        while (it.hasNext()) {
            if (remove(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TByteCollection
    public boolean removeAll(byte[] bArr) {
        int length = bArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return z;
            }
            if (remove(bArr[i])) {
                z = true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.list.TByteList
    public void transformValues(TByteFunction tByteFunction) {
        for (int i = 0; i < this._pos; i++) {
            byte[] bArr = this._data;
            bArr[i] = tByteFunction.execute(bArr[i]);
        }
    }

    @Override // gnu.trove.list.TByteList
    public void reverse() {
        reverse(0, this._pos);
    }

    @Override // gnu.trove.list.TByteList
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

    @Override // gnu.trove.list.TByteList
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
        byte[] bArr = this._data;
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }

    @Override // gnu.trove.list.TByteList
    public TByteList subList(int i, int i2) {
        if (i2 < i) {
            throw new IllegalArgumentException("end index " + i2 + " greater than begin index " + i);
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("begin index can not be < 0");
        }
        if (i2 > this._data.length) {
            throw new IndexOutOfBoundsException("end index < " + this._data.length);
        }
        TByteArrayList tByteArrayList = new TByteArrayList(i2 - i);
        while (i < i2) {
            tByteArrayList.add(this._data[i]);
            i++;
        }
        return tByteArrayList;
    }

    @Override // gnu.trove.list.TByteList, gnu.trove.TByteCollection
    public byte[] toArray() {
        return toArray(0, this._pos);
    }

    @Override // gnu.trove.list.TByteList
    public byte[] toArray(int i, int i2) {
        byte[] bArr = new byte[i2];
        toArray(bArr, i, i2);
        return bArr;
    }

    @Override // gnu.trove.list.TByteList, gnu.trove.TByteCollection
    public byte[] toArray(byte[] bArr) {
        int length = bArr.length;
        int length2 = bArr.length;
        int i = this._pos;
        if (length2 > i) {
            bArr[i] = this.no_entry_value;
            length = i;
        }
        toArray(bArr, 0, length);
        return bArr;
    }

    @Override // gnu.trove.list.TByteList
    public byte[] toArray(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return bArr;
        }
        if (i < 0 || i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(this._data, i, bArr, 0, i2);
        return bArr;
    }

    @Override // gnu.trove.list.TByteList
    public byte[] toArray(byte[] bArr, int i, int i2, int i3) {
        if (i3 == 0) {
            return bArr;
        }
        if (i < 0 || i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(this._data, i, bArr, i2, i3);
        return bArr;
    }

    @Override // gnu.trove.TByteCollection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TByteList)) {
            return false;
        }
        if (obj instanceof TByteArrayList) {
            TByteArrayList tByteArrayList = (TByteArrayList) obj;
            if (tByteArrayList.size() != size()) {
                return false;
            }
            int i = this._pos;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return true;
                }
                if (this._data[i2] != tByteArrayList._data[i2]) {
                    return false;
                }
                i = i2;
            }
        } else {
            TByteList tByteList = (TByteList) obj;
            if (tByteList.size() != size()) {
                return false;
            }
            for (int i3 = 0; i3 < this._pos; i3++) {
                if (this._data[i3] != tByteList.get(i3)) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // gnu.trove.TByteCollection
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

    @Override // gnu.trove.list.TByteList, gnu.trove.TByteCollection
    public boolean forEach(TByteProcedure tByteProcedure) {
        for (int i = 0; i < this._pos; i++) {
            if (!tByteProcedure.execute(this._data[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.list.TByteList
    public boolean forEachDescending(TByteProcedure tByteProcedure) {
        int i = this._pos;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return true;
            }
            if (!tByteProcedure.execute(this._data[i2])) {
                return false;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.list.TByteList
    public void sort() {
        Arrays.sort(this._data, 0, this._pos);
    }

    @Override // gnu.trove.list.TByteList
    public void sort(int i, int i2) {
        Arrays.sort(this._data, i, i2);
    }

    @Override // gnu.trove.list.TByteList
    public void fill(byte b) {
        Arrays.fill(this._data, 0, this._pos, b);
    }

    @Override // gnu.trove.list.TByteList
    public void fill(int i, int i2, byte b) {
        if (i2 > this._pos) {
            ensureCapacity(i2);
            this._pos = i2;
        }
        Arrays.fill(this._data, i, i2, b);
    }

    @Override // gnu.trove.list.TByteList
    public int binarySearch(byte b) {
        return binarySearch(b, 0, this._pos);
    }

    @Override // gnu.trove.list.TByteList
    public int binarySearch(byte b, int i, int i2) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        if (i2 > this._pos) {
            throw new ArrayIndexOutOfBoundsException(i2);
        }
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            byte b2 = this._data[i4];
            if (b2 < b) {
                i = i4 + 1;
            } else {
                if (b2 <= b) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    @Override // gnu.trove.list.TByteList
    public int indexOf(byte b) {
        return indexOf(0, b);
    }

    @Override // gnu.trove.list.TByteList
    public int indexOf(int i, byte b) {
        while (i < this._pos) {
            if (this._data[i] == b) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // gnu.trove.list.TByteList
    public int lastIndexOf(byte b) {
        return lastIndexOf(this._pos, b);
    }

    @Override // gnu.trove.list.TByteList
    public int lastIndexOf(int i, byte b) {
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return -1;
            }
            if (this._data[i2] == b) {
                return i2;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.list.TByteList, gnu.trove.TByteCollection
    public boolean contains(byte b) {
        return lastIndexOf(b) >= 0;
    }

    @Override // gnu.trove.list.TByteList
    public TByteList grep(TByteProcedure tByteProcedure) {
        TByteArrayList tByteArrayList = new TByteArrayList();
        for (int i = 0; i < this._pos; i++) {
            if (tByteProcedure.execute(this._data[i])) {
                tByteArrayList.add(this._data[i]);
            }
        }
        return tByteArrayList;
    }

    @Override // gnu.trove.list.TByteList
    public TByteList inverseGrep(TByteProcedure tByteProcedure) {
        TByteArrayList tByteArrayList = new TByteArrayList();
        for (int i = 0; i < this._pos; i++) {
            if (!tByteProcedure.execute(this._data[i])) {
                tByteArrayList.add(this._data[i]);
            }
        }
        return tByteArrayList;
    }

    @Override // gnu.trove.list.TByteList
    public byte max() {
        if (size() == 0) {
            throw new IllegalStateException("cannot find maximum of an empty list");
        }
        byte b = Byte.MIN_VALUE;
        for (int i = 0; i < this._pos; i++) {
            byte[] bArr = this._data;
            if (bArr[i] > b) {
                b = bArr[i];
            }
        }
        return b;
    }

    @Override // gnu.trove.list.TByteList
    public byte min() {
        if (size() == 0) {
            throw new IllegalStateException("cannot find minimum of an empty list");
        }
        byte b = Byte.MAX_VALUE;
        for (int i = 0; i < this._pos; i++) {
            byte[] bArr = this._data;
            if (bArr[i] < b) {
                b = bArr[i];
            }
        }
        return b;
    }

    @Override // gnu.trove.list.TByteList
    public byte sum() {
        byte b = 0;
        for (int i = 0; i < this._pos; i++) {
            b = (byte) (b + this._data[i]);
        }
        return b;
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

    class TByteArrayIterator implements TByteIterator {
        private int cursor;
        int lastRet = -1;

        TByteArrayIterator(int i) {
            this.cursor = 0;
            this.cursor = i;
        }

        @Override // gnu.trove.iterator.TIterator, java.util.Iterator
        public boolean hasNext() {
            return this.cursor < TByteArrayList.this.size();
        }

        @Override // gnu.trove.iterator.TByteIterator
        public byte next() {
            try {
                byte b = TByteArrayList.this.get(this.cursor);
                int i = this.cursor;
                this.cursor = i + 1;
                this.lastRet = i;
                return b;
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
                TByteArrayList.this.remove(i, 1);
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
        objectOutput.writeByte(this.no_entry_value);
        int length = this._data.length;
        objectOutput.writeInt(length);
        for (int i = 0; i < length; i++) {
            objectOutput.writeByte(this._data[i]);
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._pos = objectInput.readInt();
        this.no_entry_value = objectInput.readByte();
        int readInt = objectInput.readInt();
        this._data = new byte[readInt];
        for (int i = 0; i < readInt; i++) {
            this._data[i] = objectInput.readByte();
        }
    }
}
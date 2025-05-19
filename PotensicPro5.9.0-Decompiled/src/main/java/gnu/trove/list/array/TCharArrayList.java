package gnu.trove.list.array;

import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.iterator.TCharIterator;
import gnu.trove.list.TCharList;
import gnu.trove.procedure.TCharProcedure;
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
import kotlin.jvm.internal.CharCompanionObject;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TCharArrayList implements TCharList, Externalizable {
    protected static final int DEFAULT_CAPACITY = 10;
    static final long serialVersionUID = 1;
    protected char[] _data;
    protected int _pos;
    protected char no_entry_value;

    public TCharArrayList() {
        this(10, (char) 0);
    }

    public TCharArrayList(int i) {
        this(i, (char) 0);
    }

    public TCharArrayList(int i, char c) {
        this._data = new char[i];
        this._pos = 0;
        this.no_entry_value = c;
    }

    public TCharArrayList(TCharCollection tCharCollection) {
        this(tCharCollection.size());
        addAll(tCharCollection);
    }

    public TCharArrayList(char[] cArr) {
        this(cArr.length);
        add(cArr);
    }

    protected TCharArrayList(char[] cArr, char c, boolean z) {
        if (!z) {
            throw new IllegalStateException("Wrong call");
        }
        if (cArr == null) {
            throw new IllegalArgumentException("values can not be null");
        }
        this._data = cArr;
        this._pos = cArr.length;
        this.no_entry_value = c;
    }

    public static TCharArrayList wrap(char[] cArr) {
        return wrap(cArr, (char) 0);
    }

    public static TCharArrayList wrap(char[] cArr, char c) {
        return new TCharArrayList(cArr, c, true) { // from class: gnu.trove.list.array.TCharArrayList.1
            @Override // gnu.trove.list.array.TCharArrayList
            public void ensureCapacity(int i) {
                if (i > this._data.length) {
                    throw new IllegalStateException("Can not grow ArrayList wrapped external array");
                }
            }
        };
    }

    @Override // gnu.trove.list.TCharList, gnu.trove.TCharCollection
    public char getNoEntryValue() {
        return this.no_entry_value;
    }

    public void ensureCapacity(int i) {
        char[] cArr = this._data;
        if (i > cArr.length) {
            char[] cArr2 = new char[Math.max(cArr.length << 1, i)];
            char[] cArr3 = this._data;
            System.arraycopy(cArr3, 0, cArr2, 0, cArr3.length);
            this._data = cArr2;
        }
    }

    @Override // gnu.trove.list.TCharList, gnu.trove.TCharCollection
    public int size() {
        return this._pos;
    }

    @Override // gnu.trove.list.TCharList, gnu.trove.TCharCollection
    public boolean isEmpty() {
        return this._pos == 0;
    }

    public void trimToSize() {
        if (this._data.length > size()) {
            int size = size();
            char[] cArr = new char[size];
            toArray(cArr, 0, size);
            this._data = cArr;
        }
    }

    @Override // gnu.trove.list.TCharList, gnu.trove.TCharCollection
    public boolean add(char c) {
        ensureCapacity(this._pos + 1);
        char[] cArr = this._data;
        int i = this._pos;
        this._pos = i + 1;
        cArr[i] = c;
        return true;
    }

    @Override // gnu.trove.list.TCharList
    public void add(char[] cArr) {
        add(cArr, 0, cArr.length);
    }

    @Override // gnu.trove.list.TCharList
    public void add(char[] cArr, int i, int i2) {
        ensureCapacity(this._pos + i2);
        System.arraycopy(cArr, i, this._data, this._pos, i2);
        this._pos += i2;
    }

    @Override // gnu.trove.list.TCharList
    public void insert(int i, char c) {
        int i2 = this._pos;
        if (i == i2) {
            add(c);
            return;
        }
        ensureCapacity(i2 + 1);
        char[] cArr = this._data;
        System.arraycopy(cArr, i, cArr, i + 1, this._pos - i);
        this._data[i] = c;
        this._pos++;
    }

    @Override // gnu.trove.list.TCharList
    public void insert(int i, char[] cArr) {
        insert(i, cArr, 0, cArr.length);
    }

    @Override // gnu.trove.list.TCharList
    public void insert(int i, char[] cArr, int i2, int i3) {
        int i4 = this._pos;
        if (i == i4) {
            add(cArr, i2, i3);
            return;
        }
        ensureCapacity(i4 + i3);
        char[] cArr2 = this._data;
        System.arraycopy(cArr2, i, cArr2, i + i3, this._pos - i);
        System.arraycopy(cArr, i2, this._data, i, i3);
        this._pos += i3;
    }

    @Override // gnu.trove.list.TCharList
    public char get(int i) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        return this._data[i];
    }

    public char getQuick(int i) {
        return this._data[i];
    }

    @Override // gnu.trove.list.TCharList
    public char set(int i, char c) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        char[] cArr = this._data;
        char c2 = cArr[i];
        cArr[i] = c;
        return c2;
    }

    @Override // gnu.trove.list.TCharList
    public char replace(int i, char c) {
        if (i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        char[] cArr = this._data;
        char c2 = cArr[i];
        cArr[i] = c;
        return c2;
    }

    @Override // gnu.trove.list.TCharList
    public void set(int i, char[] cArr) {
        set(i, cArr, 0, cArr.length);
    }

    @Override // gnu.trove.list.TCharList
    public void set(int i, char[] cArr, int i2, int i3) {
        if (i < 0 || i + i3 > this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(cArr, i2, this._data, i, i3);
    }

    public void setQuick(int i, char c) {
        this._data[i] = c;
    }

    @Override // gnu.trove.list.TCharList, gnu.trove.TCharCollection
    public void clear() {
        clearQuick();
        Arrays.fill(this._data, this.no_entry_value);
    }

    public void clearQuick() {
        this._pos = 0;
    }

    @Override // gnu.trove.list.TCharList, gnu.trove.TCharCollection
    public boolean remove(char c) {
        for (int i = 0; i < this._pos; i++) {
            if (c == this._data[i]) {
                remove(i, 1);
                return true;
            }
        }
        return false;
    }

    @Override // gnu.trove.list.TCharList
    public char removeAt(int i) {
        char c = get(i);
        remove(i, 1);
        return c;
    }

    @Override // gnu.trove.list.TCharList
    public void remove(int i, int i2) {
        int i3;
        if (i2 == 0) {
            return;
        }
        if (i < 0 || i >= (i3 = this._pos)) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        if (i == 0) {
            char[] cArr = this._data;
            System.arraycopy(cArr, i2, cArr, 0, i3 - i2);
        } else if (i3 - i2 != i) {
            char[] cArr2 = this._data;
            int i4 = i + i2;
            System.arraycopy(cArr2, i4, cArr2, i, i3 - i4);
        }
        this._pos -= i2;
    }

    @Override // gnu.trove.TCharCollection
    public TCharIterator iterator() {
        return new TCharArrayIterator(0);
    }

    @Override // gnu.trove.TCharCollection
    public boolean containsAll(Collection<?> collection) {
        for (Object obj : collection) {
            if (!(obj instanceof Character) || !contains(((Character) obj).charValue())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.TCharCollection
    public boolean containsAll(TCharCollection tCharCollection) {
        if (this == tCharCollection) {
            return true;
        }
        TCharIterator it = tCharCollection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.TCharCollection
    public boolean containsAll(char[] cArr) {
        int length = cArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!contains(cArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.TCharCollection
    public boolean addAll(Collection<? extends Character> collection) {
        Iterator<? extends Character> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next().charValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TCharCollection
    public boolean addAll(TCharCollection tCharCollection) {
        TCharIterator it = tCharCollection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TCharCollection
    public boolean addAll(char[] cArr) {
        boolean z = false;
        for (char c : cArr) {
            if (add(c)) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TCharCollection
    public boolean retainAll(Collection<?> collection) {
        TCharIterator it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(Character.valueOf(it.next()))) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TCharCollection
    public boolean retainAll(TCharCollection tCharCollection) {
        boolean z = false;
        if (this == tCharCollection) {
            return false;
        }
        TCharIterator it = iterator();
        while (it.hasNext()) {
            if (!tCharCollection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TCharCollection
    public boolean retainAll(char[] cArr) {
        Arrays.sort(cArr);
        char[] cArr2 = this._data;
        int i = this._pos;
        boolean z = false;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return z;
            }
            if (Arrays.binarySearch(cArr, cArr2[i2]) < 0) {
                remove(i2, 1);
                z = true;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.TCharCollection
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object obj : collection) {
            if ((obj instanceof Character) && remove(((Character) obj).charValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TCharCollection
    public boolean removeAll(TCharCollection tCharCollection) {
        if (tCharCollection == this) {
            clear();
            return true;
        }
        boolean z = false;
        TCharIterator it = tCharCollection.iterator();
        while (it.hasNext()) {
            if (remove(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.TCharCollection
    public boolean removeAll(char[] cArr) {
        int length = cArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return z;
            }
            if (remove(cArr[i])) {
                z = true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.list.TCharList
    public void transformValues(TCharFunction tCharFunction) {
        for (int i = 0; i < this._pos; i++) {
            char[] cArr = this._data;
            cArr[i] = tCharFunction.execute(cArr[i]);
        }
    }

    @Override // gnu.trove.list.TCharList
    public void reverse() {
        reverse(0, this._pos);
    }

    @Override // gnu.trove.list.TCharList
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

    @Override // gnu.trove.list.TCharList
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
        char[] cArr = this._data;
        char c = cArr[i];
        cArr[i] = cArr[i2];
        cArr[i2] = c;
    }

    @Override // gnu.trove.list.TCharList
    public TCharList subList(int i, int i2) {
        if (i2 < i) {
            throw new IllegalArgumentException("end index " + i2 + " greater than begin index " + i);
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("begin index can not be < 0");
        }
        if (i2 > this._data.length) {
            throw new IndexOutOfBoundsException("end index < " + this._data.length);
        }
        TCharArrayList tCharArrayList = new TCharArrayList(i2 - i);
        while (i < i2) {
            tCharArrayList.add(this._data[i]);
            i++;
        }
        return tCharArrayList;
    }

    @Override // gnu.trove.list.TCharList, gnu.trove.TCharCollection
    public char[] toArray() {
        return toArray(0, this._pos);
    }

    @Override // gnu.trove.list.TCharList
    public char[] toArray(int i, int i2) {
        char[] cArr = new char[i2];
        toArray(cArr, i, i2);
        return cArr;
    }

    @Override // gnu.trove.list.TCharList, gnu.trove.TCharCollection
    public char[] toArray(char[] cArr) {
        int length = cArr.length;
        int length2 = cArr.length;
        int i = this._pos;
        if (length2 > i) {
            cArr[i] = this.no_entry_value;
            length = i;
        }
        toArray(cArr, 0, length);
        return cArr;
    }

    @Override // gnu.trove.list.TCharList
    public char[] toArray(char[] cArr, int i, int i2) {
        if (i2 == 0) {
            return cArr;
        }
        if (i < 0 || i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(this._data, i, cArr, 0, i2);
        return cArr;
    }

    @Override // gnu.trove.list.TCharList
    public char[] toArray(char[] cArr, int i, int i2, int i3) {
        if (i3 == 0) {
            return cArr;
        }
        if (i < 0 || i >= this._pos) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        System.arraycopy(this._data, i, cArr, i2, i3);
        return cArr;
    }

    @Override // gnu.trove.TCharCollection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TCharList)) {
            return false;
        }
        if (obj instanceof TCharArrayList) {
            TCharArrayList tCharArrayList = (TCharArrayList) obj;
            if (tCharArrayList.size() != size()) {
                return false;
            }
            int i = this._pos;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return true;
                }
                if (this._data[i2] != tCharArrayList._data[i2]) {
                    return false;
                }
                i = i2;
            }
        } else {
            TCharList tCharList = (TCharList) obj;
            if (tCharList.size() != size()) {
                return false;
            }
            for (int i3 = 0; i3 < this._pos; i3++) {
                if (this._data[i3] != tCharList.get(i3)) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // gnu.trove.TCharCollection
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

    @Override // gnu.trove.list.TCharList, gnu.trove.TCharCollection
    public boolean forEach(TCharProcedure tCharProcedure) {
        for (int i = 0; i < this._pos; i++) {
            if (!tCharProcedure.execute(this._data[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.list.TCharList
    public boolean forEachDescending(TCharProcedure tCharProcedure) {
        int i = this._pos;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return true;
            }
            if (!tCharProcedure.execute(this._data[i2])) {
                return false;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.list.TCharList
    public void sort() {
        Arrays.sort(this._data, 0, this._pos);
    }

    @Override // gnu.trove.list.TCharList
    public void sort(int i, int i2) {
        Arrays.sort(this._data, i, i2);
    }

    @Override // gnu.trove.list.TCharList
    public void fill(char c) {
        Arrays.fill(this._data, 0, this._pos, c);
    }

    @Override // gnu.trove.list.TCharList
    public void fill(int i, int i2, char c) {
        if (i2 > this._pos) {
            ensureCapacity(i2);
            this._pos = i2;
        }
        Arrays.fill(this._data, i, i2, c);
    }

    @Override // gnu.trove.list.TCharList
    public int binarySearch(char c) {
        return binarySearch(c, 0, this._pos);
    }

    @Override // gnu.trove.list.TCharList
    public int binarySearch(char c, int i, int i2) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        if (i2 > this._pos) {
            throw new ArrayIndexOutOfBoundsException(i2);
        }
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            char c2 = this._data[i4];
            if (c2 < c) {
                i = i4 + 1;
            } else {
                if (c2 <= c) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    @Override // gnu.trove.list.TCharList
    public int indexOf(char c) {
        return indexOf(0, c);
    }

    @Override // gnu.trove.list.TCharList
    public int indexOf(int i, char c) {
        while (i < this._pos) {
            if (this._data[i] == c) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // gnu.trove.list.TCharList
    public int lastIndexOf(char c) {
        return lastIndexOf(this._pos, c);
    }

    @Override // gnu.trove.list.TCharList
    public int lastIndexOf(int i, char c) {
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return -1;
            }
            if (this._data[i2] == c) {
                return i2;
            }
            i = i2;
        }
    }

    @Override // gnu.trove.list.TCharList, gnu.trove.TCharCollection
    public boolean contains(char c) {
        return lastIndexOf(c) >= 0;
    }

    @Override // gnu.trove.list.TCharList
    public TCharList grep(TCharProcedure tCharProcedure) {
        TCharArrayList tCharArrayList = new TCharArrayList();
        for (int i = 0; i < this._pos; i++) {
            if (tCharProcedure.execute(this._data[i])) {
                tCharArrayList.add(this._data[i]);
            }
        }
        return tCharArrayList;
    }

    @Override // gnu.trove.list.TCharList
    public TCharList inverseGrep(TCharProcedure tCharProcedure) {
        TCharArrayList tCharArrayList = new TCharArrayList();
        for (int i = 0; i < this._pos; i++) {
            if (!tCharProcedure.execute(this._data[i])) {
                tCharArrayList.add(this._data[i]);
            }
        }
        return tCharArrayList;
    }

    @Override // gnu.trove.list.TCharList
    public char max() {
        if (size() == 0) {
            throw new IllegalStateException("cannot find maximum of an empty list");
        }
        char c = 0;
        for (int i = 0; i < this._pos; i++) {
            char[] cArr = this._data;
            if (cArr[i] > c) {
                c = cArr[i];
            }
        }
        return c;
    }

    @Override // gnu.trove.list.TCharList
    public char min() {
        if (size() == 0) {
            throw new IllegalStateException("cannot find minimum of an empty list");
        }
        char c = CharCompanionObject.MAX_VALUE;
        for (int i = 0; i < this._pos; i++) {
            char[] cArr = this._data;
            if (cArr[i] < c) {
                c = cArr[i];
            }
        }
        return c;
    }

    @Override // gnu.trove.list.TCharList
    public char sum() {
        char c = 0;
        for (int i = 0; i < this._pos; i++) {
            c = (char) (c + this._data[i]);
        }
        return c;
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

    class TCharArrayIterator implements TCharIterator {
        private int cursor;
        int lastRet = -1;

        TCharArrayIterator(int i) {
            this.cursor = 0;
            this.cursor = i;
        }

        @Override // gnu.trove.iterator.TIterator, java.util.Iterator
        public boolean hasNext() {
            return this.cursor < TCharArrayList.this.size();
        }

        @Override // gnu.trove.iterator.TCharIterator
        public char next() {
            try {
                char c = TCharArrayList.this.get(this.cursor);
                int i = this.cursor;
                this.cursor = i + 1;
                this.lastRet = i;
                return c;
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
                TCharArrayList.this.remove(i, 1);
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
        objectOutput.writeChar(this.no_entry_value);
        int length = this._data.length;
        objectOutput.writeInt(length);
        for (int i = 0; i < length; i++) {
            objectOutput.writeChar(this._data[i]);
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._pos = objectInput.readInt();
        this.no_entry_value = objectInput.readChar();
        int readInt = objectInput.readInt();
        this._data = new char[readInt];
        for (int i = 0; i < readInt; i++) {
            this._data[i] = objectInput.readChar();
        }
    }
}

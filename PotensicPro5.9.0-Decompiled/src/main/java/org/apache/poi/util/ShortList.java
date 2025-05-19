package org.apache.poi.util;

/* loaded from: classes5.dex */
public class ShortList {
    private static final int _default_size = 128;
    private short[] _array;
    private int _limit;

    public ShortList() {
        this(128);
    }

    public ShortList(ShortList shortList) {
        this(shortList._array.length);
        short[] sArr = shortList._array;
        short[] sArr2 = this._array;
        System.arraycopy(sArr, 0, sArr2, 0, sArr2.length);
        this._limit = shortList._limit;
    }

    public ShortList(int i) {
        this._array = new short[i];
        this._limit = 0;
    }

    public void add(int i, short s) {
        int i2 = this._limit;
        if (i > i2) {
            throw new IndexOutOfBoundsException();
        }
        if (i == i2) {
            add(s);
            return;
        }
        if (i2 == this._array.length) {
            growArray(i2 * 2);
        }
        short[] sArr = this._array;
        System.arraycopy(sArr, i, sArr, i + 1, this._limit - i);
        this._array[i] = s;
        this._limit++;
    }

    public boolean add(short s) {
        int i = this._limit;
        if (i == this._array.length) {
            growArray(i * 2);
        }
        short[] sArr = this._array;
        int i2 = this._limit;
        this._limit = i2 + 1;
        sArr[i2] = s;
        return true;
    }

    public boolean addAll(ShortList shortList) {
        int i = shortList._limit;
        if (i == 0) {
            return true;
        }
        int i2 = this._limit;
        if (i2 + i > this._array.length) {
            growArray(i2 + i);
        }
        System.arraycopy(shortList._array, 0, this._array, this._limit, shortList._limit);
        this._limit += shortList._limit;
        return true;
    }

    public boolean addAll(int i, ShortList shortList) {
        int i2 = this._limit;
        if (i > i2) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = shortList._limit;
        if (i3 == 0) {
            return true;
        }
        if (i2 + i3 > this._array.length) {
            growArray(i2 + i3);
        }
        short[] sArr = this._array;
        System.arraycopy(sArr, i, sArr, shortList._limit + i, this._limit - i);
        System.arraycopy(shortList._array, 0, this._array, i, shortList._limit);
        this._limit += shortList._limit;
        return true;
    }

    public void clear() {
        this._limit = 0;
    }

    public boolean contains(short s) {
        boolean z = false;
        for (int i = 0; !z && i < this._limit; i++) {
            if (this._array[i] == s) {
                z = true;
            }
        }
        return z;
    }

    public boolean containsAll(ShortList shortList) {
        boolean z = true;
        if (this != shortList) {
            for (int i = 0; z && i < shortList._limit; i++) {
                if (!contains(shortList._array[i])) {
                    z = false;
                }
            }
        }
        return z;
    }

    public boolean equals(Object obj) {
        boolean z = this == obj;
        if (!z && obj != null && obj.getClass() == getClass()) {
            ShortList shortList = (ShortList) obj;
            if (shortList._limit == this._limit) {
                z = true;
                for (int i = 0; z && i < this._limit; i++) {
                    z = this._array[i] == shortList._array[i];
                }
            }
        }
        return z;
    }

    public short get(int i) {
        if (i >= this._limit) {
            throw new IndexOutOfBoundsException();
        }
        return this._array[i];
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < this._limit; i2++) {
            i = (i * 31) + this._array[i2];
        }
        return i;
    }

    public int indexOf(short s) {
        int i;
        int i2 = 0;
        while (true) {
            i = this._limit;
            if (i2 >= i || s == this._array[i2]) {
                break;
            }
            i2++;
        }
        if (i2 == i) {
            return -1;
        }
        return i2;
    }

    public boolean isEmpty() {
        return this._limit == 0;
    }

    public int lastIndexOf(short s) {
        int i = this._limit - 1;
        while (i >= 0 && s != this._array[i]) {
            i--;
        }
        return i;
    }

    public short remove(int i) {
        int i2 = this._limit;
        if (i >= i2) {
            throw new IndexOutOfBoundsException();
        }
        short[] sArr = this._array;
        short s = sArr[i];
        System.arraycopy(sArr, i + 1, sArr, i, i2 - i);
        this._limit--;
        return s;
    }

    public boolean removeValue(short s) {
        boolean z = false;
        int i = 0;
        while (!z) {
            int i2 = this._limit;
            if (i >= i2) {
                break;
            }
            short[] sArr = this._array;
            if (s == sArr[i]) {
                System.arraycopy(sArr, i + 1, sArr, i, i2 - i);
                this._limit--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public boolean removeAll(ShortList shortList) {
        boolean z = false;
        for (int i = 0; i < shortList._limit; i++) {
            if (removeValue(shortList._array[i])) {
                z = true;
            }
        }
        return z;
    }

    public boolean retainAll(ShortList shortList) {
        int i = 0;
        boolean z = false;
        while (i < this._limit) {
            if (shortList.contains(this._array[i])) {
                i++;
            } else {
                remove(i);
                z = true;
            }
        }
        return z;
    }

    public short set(int i, short s) {
        if (i >= this._limit) {
            throw new IndexOutOfBoundsException();
        }
        short[] sArr = this._array;
        short s2 = sArr[i];
        sArr[i] = s;
        return s2;
    }

    public int size() {
        return this._limit;
    }

    public short[] toArray() {
        int i = this._limit;
        short[] sArr = new short[i];
        System.arraycopy(this._array, 0, sArr, 0, i);
        return sArr;
    }

    public short[] toArray(short[] sArr) {
        int length = sArr.length;
        int i = this._limit;
        if (length == i) {
            System.arraycopy(this._array, 0, sArr, 0, i);
            return sArr;
        }
        return toArray();
    }

    private void growArray(int i) {
        short[] sArr = this._array;
        if (i == sArr.length) {
            i++;
        }
        short[] sArr2 = new short[i];
        System.arraycopy(sArr, 0, sArr2, 0, this._limit);
        this._array = sArr2;
    }
}

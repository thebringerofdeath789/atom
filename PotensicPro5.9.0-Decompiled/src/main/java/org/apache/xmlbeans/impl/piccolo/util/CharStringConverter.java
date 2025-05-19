package org.apache.xmlbeans.impl.piccolo.util;

/* loaded from: classes5.dex */
public final class CharStringConverter {
    private static final float DEFAULT_LOAD = 0.7f;
    private int hashmask;
    private char[][] keys;
    private float loadFactor;
    private int maxEntries;
    private int numEntries;
    private String[] values;

    public CharStringConverter(int i, float f) {
        this.numEntries = 0;
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuffer().append("Illegal initial capacity: ").append(i).toString());
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException(new StringBuffer().append("Illegal load factor: ").append(f).toString());
        }
        int i2 = 16;
        while (i2 < ((int) (i / f))) {
            i2 <<= 1;
        }
        this.hashmask = i2 - 1;
        this.maxEntries = (int) (i2 * f);
        this.keys = new char[i2][];
        this.values = new String[i2];
        this.loadFactor = f;
    }

    public CharStringConverter() {
        this(0, 0.7f);
    }

    public CharStringConverter(int i) {
        this(i, 0.7f);
    }

    public int getCacheSize() {
        return this.numEntries;
    }

    public String convert(char[] cArr) {
        return convert(cArr, 0, cArr.length);
    }

    public String convert(char[] cArr, int i, int i2) {
        int i3;
        char[] cArr2;
        if (this.numEntries >= this.maxEntries) {
            rehash();
        }
        int hashKey = hashKey(cArr, i, i2);
        int i4 = this.hashmask;
        while (true) {
            i3 = hashKey & i4;
            cArr2 = this.keys[i3];
            if (cArr2 == null || keysAreEqual(cArr2, 0, cArr2.length, cArr, i, i2)) {
                break;
            }
            hashKey = i3 - 1;
            i4 = this.hashmask;
        }
        if (cArr2 != null) {
            return this.values[i3];
        }
        char[] cArr3 = new char[i2];
        System.arraycopy(cArr, i, cArr3, 0, i2);
        String intern = new String(cArr3).intern();
        this.keys[i3] = cArr3;
        this.values[i3] = intern;
        this.numEntries++;
        return intern;
    }

    private void rehash() {
        int length = this.keys.length << 1;
        char[][] cArr = new char[length][];
        String[] strArr = new String[length];
        int i = length - 1;
        int i2 = 0;
        while (true) {
            char[][] cArr2 = this.keys;
            if (i2 < cArr2.length) {
                char[] cArr3 = cArr2[i2];
                String str = this.values[i2];
                if (cArr3 != null) {
                    int hashKey = hashKey(cArr3, 0, cArr3.length) & i;
                    while (true) {
                        char[] cArr4 = cArr[hashKey];
                        if (cArr4 == null || keysAreEqual(cArr4, 0, cArr4.length, cArr3, 0, cArr3.length)) {
                            break;
                        } else {
                            hashKey = (hashKey - 1) & i;
                        }
                    }
                    cArr[hashKey] = cArr3;
                    strArr[hashKey] = str;
                }
                i2++;
            } else {
                this.keys = cArr;
                this.values = strArr;
                this.maxEntries = (int) (length * this.loadFactor);
                this.hashmask = i;
                return;
            }
        }
    }

    public void clearCache() {
        int i = 0;
        while (true) {
            char[][] cArr = this.keys;
            if (i < cArr.length) {
                cArr[i] = null;
                this.values[i] = null;
                i++;
            } else {
                this.numEntries = 0;
                return;
            }
        }
    }

    private static final boolean keysAreEqual(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4) {
        if (i2 != i4) {
            return false;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            if (cArr[i + i5] != cArr2[i3 + i5]) {
                return false;
            }
        }
        return true;
    }

    private static final int hashKey(char[] cArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 << 5) + cArr[i + i4];
        }
        return i3;
    }
}

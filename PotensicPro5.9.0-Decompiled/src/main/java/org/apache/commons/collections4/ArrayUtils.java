package org.apache.commons.collections4;

/* loaded from: classes4.dex */
class ArrayUtils {
    static final int INDEX_NOT_FOUND = -1;

    ArrayUtils() {
    }

    static boolean contains(Object[] objArr, Object obj) {
        return indexOf(objArr, obj) != -1;
    }

    static <T> int indexOf(T[] tArr, Object obj) {
        return indexOf(tArr, obj, 0);
    }

    static int indexOf(Object[] objArr, Object obj, int i) {
        if (objArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        if (obj == null) {
            while (i < objArr.length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
        } else {
            while (i < objArr.length) {
                if (obj.equals(objArr[i])) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }
}

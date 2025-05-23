package com.ipotensic.baselib.utils;

import java.util.Collection;
import okhttp3.HttpUrl;
import org.apache.commons.beanutils.PropertyUtils;

/* compiled from: ReleasableLinkedBlockingDeque.java */
/* loaded from: classes2.dex */
class Helpers {
    private Helpers() {
    }

    static String collectionToString(Collection<?> collection) {
        Object[] array = collection.toArray();
        int length = array.length;
        if (length == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = array[i2];
            String objectToString = obj == collection ? "(this Collection)" : objectToString(obj);
            array[i2] = objectToString;
            i += objectToString.length();
        }
        return toString(array, length, i);
    }

    static String toString(Object[] objArr, int i, int i2) {
        char[] cArr = new char[i2 + (i * 2)];
        cArr[0] = PropertyUtils.INDEXED_DELIM;
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            if (i4 > 0) {
                int i5 = i3 + 1;
                cArr[i3] = ',';
                i3 = i5 + 1;
                cArr[i5] = ' ';
            }
            String str = (String) objArr[i4];
            int length = str.length();
            str.getChars(0, length, cArr, i3);
            i3 += length;
        }
        cArr[i3] = PropertyUtils.INDEXED_DELIM2;
        return new String(cArr);
    }

    static String mapEntryToString(Object obj, Object obj2) {
        String objectToString = objectToString(obj);
        int length = objectToString.length();
        String objectToString2 = objectToString(obj2);
        int length2 = objectToString2.length();
        char[] cArr = new char[length + length2 + 1];
        objectToString.getChars(0, length, cArr, 0);
        cArr[length] = '=';
        objectToString2.getChars(0, length2, cArr, length + 1);
        return new String(cArr);
    }

    private static String objectToString(Object obj) {
        String obj2;
        return (obj == null || (obj2 = obj.toString()) == null) ? "null" : obj2;
    }
}

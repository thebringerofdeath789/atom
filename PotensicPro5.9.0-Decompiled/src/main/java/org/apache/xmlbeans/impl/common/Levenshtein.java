package org.apache.xmlbeans.impl.common;

import java.lang.reflect.Array;

/* loaded from: classes5.dex */
public class Levenshtein {
    private static int minimum(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        return i3 < i ? i3 : i;
    }

    public static int distance(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (length == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length;
        }
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, length + 1, length2 + 1);
        for (int i = 0; i <= length; i++) {
            iArr[i][0] = i;
        }
        for (int i2 = 0; i2 <= length2; i2++) {
            iArr[0][i2] = i2;
        }
        for (int i3 = 1; i3 <= length; i3++) {
            int i4 = i3 - 1;
            char charAt = str.charAt(i4);
            for (int i5 = 1; i5 <= length2; i5++) {
                int i6 = i5 - 1;
                iArr[i3][i5] = minimum(iArr[i4][i5] + 1, iArr[i3][i6] + 1, iArr[i4][i6] + (charAt == str2.charAt(i6) ? 0 : 1));
            }
        }
        return iArr[length][length2];
    }
}

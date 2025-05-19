package org.apache.commons.lang3;

import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes4.dex */
public class ArraySorter {
    public static byte[] sort(byte[] bArr) {
        Arrays.sort(bArr);
        return bArr;
    }

    public static char[] sort(char[] cArr) {
        Arrays.sort(cArr);
        return cArr;
    }

    public static double[] sort(double[] dArr) {
        Arrays.sort(dArr);
        return dArr;
    }

    public static float[] sort(float[] fArr) {
        Arrays.sort(fArr);
        return fArr;
    }

    public static int[] sort(int[] iArr) {
        Arrays.sort(iArr);
        return iArr;
    }

    public static long[] sort(long[] jArr) {
        Arrays.sort(jArr);
        return jArr;
    }

    public static short[] sort(short[] sArr) {
        Arrays.sort(sArr);
        return sArr;
    }

    public static <T> T[] sort(T[] tArr) {
        Arrays.sort(tArr);
        return tArr;
    }

    public static <T> T[] sort(T[] tArr, Comparator<? super T> comparator) {
        Arrays.sort(tArr, comparator);
        return tArr;
    }
}

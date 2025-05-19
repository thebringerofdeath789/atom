package org.apache.poi.xssf.util;

/* loaded from: classes5.dex */
public class NumericRanges {
    public static int NO_OVERLAPS = -1;
    public static int OVERLAPS_1_MINOR = 0;
    public static int OVERLAPS_1_WRAPS = 2;
    public static int OVERLAPS_2_MINOR = 1;
    public static int OVERLAPS_2_WRAPS = 3;

    public static long[] getOverlappingRange(long[] jArr, long[] jArr2) {
        int overlappingType = getOverlappingType(jArr, jArr2);
        return overlappingType == OVERLAPS_1_MINOR ? new long[]{jArr2[0], jArr[1]} : overlappingType == OVERLAPS_2_MINOR ? new long[]{jArr[0], jArr2[1]} : overlappingType == OVERLAPS_2_WRAPS ? jArr : overlappingType == OVERLAPS_1_WRAPS ? jArr2 : new long[]{-1, -1};
    }

    public static int getOverlappingType(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr2[0];
        long j4 = jArr2[1];
        if (j >= j3 && j2 <= j4) {
            return OVERLAPS_2_WRAPS;
        }
        if (j3 >= j && j4 <= j2) {
            return OVERLAPS_1_WRAPS;
        }
        if (j3 >= j && j3 <= j2 && j4 >= j2) {
            return OVERLAPS_1_MINOR;
        }
        if (j >= j3 && j <= j4 && j2 >= j4) {
            return OVERLAPS_2_MINOR;
        }
        return NO_OVERLAPS;
    }
}

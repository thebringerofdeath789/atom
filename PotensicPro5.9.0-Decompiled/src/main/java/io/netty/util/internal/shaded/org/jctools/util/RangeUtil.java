package io.netty.util.internal.shaded.org.jctools.util;

import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes4.dex */
public final class RangeUtil {
    public static long checkPositive(long j, String str) {
        if (j > 0) {
            return j;
        }
        throw new IllegalArgumentException(str + ": " + j + " (expected: > 0)");
    }

    public static int checkPositiveOrZero(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + ": " + i + " (expected: >= 0)");
    }

    public static int checkLessThan(int i, int i2, String str) {
        if (i < i2) {
            return i;
        }
        throw new IllegalArgumentException(str + ": " + i + " (expected: < " + i2 + PropertyUtils.MAPPED_DELIM2);
    }

    public static int checkLessThanOrEqual(int i, long j, String str) {
        if (i <= j) {
            return i;
        }
        throw new IllegalArgumentException(str + ": " + i + " (expected: <= " + j + PropertyUtils.MAPPED_DELIM2);
    }

    public static int checkGreaterThanOrEqual(int i, int i2, String str) {
        if (i >= i2) {
            return i;
        }
        throw new IllegalArgumentException(str + ": " + i + " (expected: >= " + i2 + PropertyUtils.MAPPED_DELIM2);
    }
}
